// Copyright 2000-2022 JetBrains s.r.o. and other contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
package org.intellij.sdk.language;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;
import org.intellij.sdk.language.psi.CobolTypes;
import com.intellij.psi.TokenType;

%%

%class CobolLexer
%implements FlexLexer
%unicode
%function advance
%type IElementType
%eof{  return;
%eof}

%{
    StringBuffer stringLiteral = new StringBuffer();
    int stateBeforeStringLiteral = 0;
%}

CRLF=\r
WHITE_SPACE=[\ \n\t\f]
NEWLINE=[\r\n]
DIVISION_TYPE_ID="IDENTIFICATION DIVISION\."
DIVISION_TYPE_DATA="DATA DIVISION\."
DIVISION_TYPE_PROC="PROCEDURE DIVISION\."
LINE_NUMBER=\d\d
IDENTIFICATION_KEY=[^\s\.]+\.
IDENTIFICATION_VALUE=[^\.]+\.
WS_SECTION="WORKING-STORAGE SECTION\."
VARIABLE_NUMBER=\d\d
VARIABLE_NAME=[\dA-Z\-]+
PIC="PIC"
DATA_TYPE=.\([\d]+\)
VALUE_KEYWORD="VALUE"
NUMBER=[\d]+
DOT="\."
PARAGRAPH_NAME=[\dA-Z\-]+\.
PARAGRAPH_NAME_SHORT=[\dA-Z\-]+
WORD=[A-Z\-]+
VERB_PERFROM="PERFORM"
VARYING_KEYWORD="VARYING"
FROM_KEYWORD="FROM"
BY_KEYWORD="BY"
UNTIL_KEYWORD="UNTIL"
VALUE=([\dA-Z\-]+)|[\d]+
COMPARISON_SIGN=[<=>]
VERB_STOP_RUN="STOP RUN"
VERB_DISPLAY="DISPLAY"
SINGLE_QUOTE="'"
BASE_TYPE=\S
PAREN_OPEN=\(
PAREN_CLOSE=\)

%state IDENTIFICATION_DIVISION
%state DATA_DIVISION
%state PROCEDURE_DIVISION
%state REQUIRE_DIVISION
%state WAIT_IDENTIFICATION_VALUE
%state WS_SECTION
%state WAIT_VARIABLE_NUMBER
%state WAIT_VARIABLE_NAME
%state WAIT_PIC
%state WAIT_DATA_TYPE
%state WAIT_VALUE_KEYWORD
%state WAIT_VALUE
%state VARIABLE_DECLARATION_WAIT_DOT
%state PARAGRAPH
%state STATEMENT
%state PERFROM_WAIT_PARAGRAPH
%state PERFROM_WAIT_VARYING
%state PERFROM_WAIT_VARIABLE_TO_VARY
%state PERFROM_WAIT_FROM
%state PERFROM_WAIT_FROM_VALUE
%state PERFROM_WAIT_BY
%state PERFROM_WAIT_BY_VALUE
%state PERFROM_WAIT_UNTIL
%state PERFROM_WAIT_UNTIL_VALUE
%state WAIT_COMPARISON_SIGN
%state WAIT_COMPARISON_SECOND
%state SENTENCE
%state DISPLAY_WAIT
%xstate STRING_LITERAL
%state WAIT_PAREN_OPEN
%state WAIT_PAREN_CLOSE
%state WAIT_TYPE_SIZE

%%

<YYINITIAL> {LINE_NUMBER}                                   { yybegin(REQUIRE_DIVISION); return CobolTypes.LINE_NUMBER; }

<REQUIRE_DIVISION, IDENTIFICATION_DIVISION, DATA_DIVISION, PROCEDURE_DIVISION, WAIT_VARIABLE_NUMBER, PARAGRAPH> {DIVISION_TYPE_ID}  { yybegin(IDENTIFICATION_DIVISION); return CobolTypes.DIVISION_TYPE_ID; }

<REQUIRE_DIVISION, IDENTIFICATION_DIVISION, DATA_DIVISION, PROCEDURE_DIVISION, WAIT_VARIABLE_NUMBER, PARAGRAPH> {DIVISION_TYPE_DATA}  { yybegin(DATA_DIVISION); return CobolTypes.DIVISION_TYPE_DATA; }

<REQUIRE_DIVISION, IDENTIFICATION_DIVISION, DATA_DIVISION, PROCEDURE_DIVISION, WAIT_VARIABLE_NUMBER, PARAGRAPH> {DIVISION_TYPE_PROC}  { yybegin(PROCEDURE_DIVISION); return CobolTypes.DIVISION_TYPE_PROC; }

<IDENTIFICATION_DIVISION> {IDENTIFICATION_KEY}              { yybegin(WAIT_IDENTIFICATION_VALUE); return CobolTypes.IDENTIFICATION_KEY; }

<WAIT_IDENTIFICATION_VALUE> {IDENTIFICATION_VALUE}          { yybegin(IDENTIFICATION_DIVISION); return CobolTypes.IDENTIFICATION_VALUE; }

<IDENTIFICATION_DIVISION> {LINE_NUMBER}                     { return CobolTypes.LINE_NUMBER; }

<DATA_DIVISION> {WS_SECTION}                                { yybegin(WS_SECTION); return CobolTypes.DATA_SECTION_WS; }

<DATA_DIVISION> {LINE_NUMBER}                               { return CobolTypes.LINE_NUMBER; }

<WS_SECTION> {LINE_NUMBER}                                  { yybegin(WAIT_VARIABLE_NUMBER); return CobolTypes.LINE_NUMBER; }

<WAIT_VARIABLE_NUMBER> {VARIABLE_NUMBER}                    { yybegin(WAIT_VARIABLE_NAME); return CobolTypes.VARIABLE_NUMBER; }

<WAIT_VARIABLE_NAME> {VARIABLE_NAME}                        { yybegin(WAIT_PIC); return CobolTypes.VARIABLE_NAME; }

<WAIT_PIC> {PIC}                                            { yybegin(WAIT_DATA_TYPE); return CobolTypes.PIC_KEYWORD; }

// <WAIT_DATA_TYPE> {DATA_TYPE}                                { yybegin(WAIT_VALUE_KEYWORD); return CobolTypes.DATA_TYPE; }

<WAIT_DATA_TYPE> {BASE_TYPE}                                { yybegin(WAIT_PAREN_OPEN); return CobolTypes.BASE_TYPE; }

<WAIT_PAREN_OPEN> {PAREN_OPEN}                              { yybegin(WAIT_TYPE_SIZE); return CobolTypes.PAREN_OPEN; }

<WAIT_TYPE_SIZE> {NUMBER}                                   { yybegin(WAIT_PAREN_CLOSE); return CobolTypes.TYPE_SIZE; }

<WAIT_PAREN_CLOSE> {PAREN_CLOSE}                            { yybegin(WAIT_VALUE_KEYWORD); return CobolTypes.PAREN_CLOSE; }

<WAIT_VALUE_KEYWORD> {VALUE_KEYWORD}                        { yybegin(WAIT_VALUE); return CobolTypes.VALUE_KEYWORD; }

<WAIT_VALUE> {NUMBER}                                       { yybegin(VARIABLE_DECLARATION_WAIT_DOT); return CobolTypes.VALUE; }

<VARIABLE_DECLARATION_WAIT_DOT> {DOT}                       { yybegin(WS_SECTION); return CobolTypes.DOT; }

<PROCEDURE_DIVISION> {LINE_NUMBER}                          { return CobolTypes.LINE_NUMBER; }

<PROCEDURE_DIVISION, PARAGRAPH> {PARAGRAPH_NAME}            { yybegin(PARAGRAPH); return CobolTypes.PARAGRAPH_NAME; }

<PARAGRAPH, SENTENCE> {VERB_PERFROM}                        { yybegin(PERFROM_WAIT_PARAGRAPH); return CobolTypes.VERB_PERFROM; }

<PARAGRAPH, SENTENCE> {VERB_STOP_RUN}                       { yybegin(SENTENCE); return CobolTypes.VERB_STOP_RUN; }

<PARAGRAPH, SENTENCE> {VERB_DISPLAY}                        { yybegin(DISPLAY_WAIT); return CobolTypes.VERB_DISPLAY; }

<PARAGRAPH, SENTENCE> {LINE_NUMBER}                         { return CobolTypes.LINE_NUMBER; }

<STATEMENT> {NEWLINE}+                                      { yybegin(PARAGRAPH); return TokenType.WHITE_SPACE; }

<STATEMENT> {WORD}                                          { return CobolTypes.WORD; }

<SENTENCE> {DOT}                                            { yybegin(PARAGRAPH); return CobolTypes.DOT; }

<PERFROM_WAIT_PARAGRAPH> {PARAGRAPH_NAME_SHORT}             { yybegin(PERFROM_WAIT_VARYING); return CobolTypes.PARAGRAPH_NAME; }

<PERFROM_WAIT_VARYING> {VARYING_KEYWORD}                    { yybegin(PERFROM_WAIT_VARIABLE_TO_VARY); return CobolTypes.VARYING_KEYWORD; }

<PERFROM_WAIT_VARIABLE_TO_VARY> {VARIABLE_NAME}             { yybegin(PERFROM_WAIT_FROM); return CobolTypes.VARIABLE_NAME; }

<PERFROM_WAIT_FROM> {FROM_KEYWORD}                          { yybegin(PERFROM_WAIT_FROM_VALUE); return CobolTypes.FROM_KEYWORD; }

<PERFROM_WAIT_FROM_VALUE> {VALUE}                           { yybegin(PERFROM_WAIT_BY); return CobolTypes.VALUE; }

<PERFROM_WAIT_BY> {BY_KEYWORD}                              { yybegin(PERFROM_WAIT_BY_VALUE); return CobolTypes.BY_KEYWORD; }

<PERFROM_WAIT_BY_VALUE> {VALUE}                             { yybegin(PERFROM_WAIT_UNTIL); return CobolTypes.VALUE; }

<PERFROM_WAIT_UNTIL> {UNTIL_KEYWORD}                        { yybegin(PERFROM_WAIT_UNTIL_VALUE); return CobolTypes.UNTIL_KEYWORD; }

<PERFROM_WAIT_UNTIL_VALUE> {VALUE}                          { yybegin(WAIT_COMPARISON_SIGN); return CobolTypes.VALUE; }

<WAIT_COMPARISON_SIGN> {COMPARISON_SIGN}                    { yybegin(WAIT_COMPARISON_SECOND); return CobolTypes.COMPARISON_SIGN; }

<WAIT_COMPARISON_SECOND> {VALUE}                            { yybegin(SENTENCE); return CobolTypes.VALUE; }

<DISPLAY_WAIT> {VALUE}                                      { return CobolTypes.VALUE; }

<DISPLAY_WAIT> {NEWLINE}+                                   { yybegin(SENTENCE); return TokenType.WHITE_SPACE; }

<DISPLAY_WAIT> {DOT}                                        { yybegin(PARAGRAPH); return CobolTypes.DOT; }

{SINGLE_QUOTE}                                              { stateBeforeStringLiteral = yystate();
                                                              stringLiteral.setLength(0);
                                                              yybegin(STRING_LITERAL);
                                                              return CobolTypes.QUOTE; }

({CRLF}|{WHITE_SPACE})+                                     { return TokenType.WHITE_SPACE; }

[^]                                                         { return TokenType.BAD_CHARACTER; }

<STRING_LITERAL> '                                          { yybegin(stateBeforeStringLiteral);
                                                              return CobolTypes.QUOTE; }

<STRING_LITERAL> [\r\n]                                     { return TokenType.BAD_CHARACTER; }

<STRING_LITERAL> [^'\r\n]                                   { return CobolTypes.ANY_CHARACTER; }
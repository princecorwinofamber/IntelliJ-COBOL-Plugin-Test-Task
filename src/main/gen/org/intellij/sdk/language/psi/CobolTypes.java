// This is a generated file. Not intended for manual editing.
package org.intellij.sdk.language.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import org.intellij.sdk.language.psi.impl.*;

public interface CobolTypes {

  IElementType ABCD = new CobolElementType("ABCD");
  IElementType ARGUMENT_LIST = new CobolElementType("ARGUMENT_LIST");
  IElementType COMMAND = new CobolElementType("COMMAND");
  IElementType COMPARISON = new CobolElementType("COMPARISON");
  IElementType DATA_CONTENT = new CobolElementType("DATA_CONTENT");
  IElementType DATA_SECTION = new CobolElementType("DATA_SECTION");
  IElementType DATA_TYPE = new CobolElementType("DATA_TYPE");
  IElementType DISPLAY = new CobolElementType("DISPLAY");
  IElementType DIVISION = new CobolElementType("DIVISION");
  IElementType DIVISION_TYPE = new CobolElementType("DIVISION_TYPE");
  IElementType IDENTIFICATION_CONTENT = new CobolElementType("IDENTIFICATION_CONTENT");
  IElementType IDENTIFICATION_KV_PAIR = new CobolElementType("IDENTIFICATION_KV_PAIR");
  IElementType PARAGRAPH_BODY = new CobolElementType("PARAGRAPH_BODY");
  IElementType PERFORM = new CobolElementType("PERFORM");
  IElementType PROCEDURE_CONTENT = new CobolElementType("PROCEDURE_CONTENT");
  IElementType PROCEDURE_PARAGRAPH = new CobolElementType("PROCEDURE_PARAGRAPH");
  IElementType SENTENCE = new CobolElementType("SENTENCE");
  IElementType STATEMENT = new CobolElementType("STATEMENT");
  IElementType STOP = new CobolElementType("STOP");
  IElementType STRING_LITERAL = new CobolElementType("STRING_LITERAL");
  IElementType VALUE_OR_STRING = new CobolElementType("VALUE_OR_STRING");
  IElementType VARIABLE_DECLARATION = new CobolElementType("VARIABLE_DECLARATION");
  IElementType WS_SECTION_CONTENT = new CobolElementType("WS_SECTION_CONTENT");

  IElementType ANY_CHARACTER = new CobolTokenType("ANY_CHARACTER");
  IElementType BASE_TYPE = new CobolTokenType("BASE_TYPE");
  IElementType BY_KEYWORD = new CobolTokenType("BY_KEYWORD");
  IElementType COMMENT = new CobolTokenType("COMMENT");
  IElementType COMPARISON_SIGN = new CobolTokenType("COMPARISON_SIGN");
  IElementType DATA_SECTION_WS = new CobolTokenType("DATA_SECTION_WS");
  IElementType DIVISION_TYPE_DATA = new CobolTokenType("DIVISION_TYPE_DATA");
  IElementType DIVISION_TYPE_ID = new CobolTokenType("DIVISION_TYPE_ID");
  IElementType DIVISION_TYPE_PROC = new CobolTokenType("DIVISION_TYPE_PROC");
  IElementType DOT = new CobolTokenType("DOT");
  IElementType FROM_KEYWORD = new CobolTokenType("FROM_KEYWORD");
  IElementType IDENTIFICATION_KEY = new CobolTokenType("IDENTIFICATION_KEY");
  IElementType IDENTIFICATION_VALUE = new CobolTokenType("IDENTIFICATION_VALUE");
  IElementType LINE_NUMBER = new CobolTokenType("line_number");
  IElementType PARAGRAPH_NAME = new CobolTokenType("PARAGRAPH_NAME");
  IElementType PAREN_CLOSE = new CobolTokenType("PAREN_CLOSE");
  IElementType PAREN_OPEN = new CobolTokenType("PAREN_OPEN");
  IElementType PIC_KEYWORD = new CobolTokenType("PIC_KEYWORD");
  IElementType QUOTE = new CobolTokenType("QUOTE");
  IElementType TYPE_SIZE = new CobolTokenType("TYPE_SIZE");
  IElementType UNTIL_KEYWORD = new CobolTokenType("UNTIL_KEYWORD");
  IElementType VALUE = new CobolTokenType("VALUE");
  IElementType VALUE_KEYWORD = new CobolTokenType("VALUE_KEYWORD");
  IElementType VARIABLE_NAME = new CobolTokenType("VARIABLE_NAME");
  IElementType VARIABLE_NUMBER = new CobolTokenType("VARIABLE_NUMBER");
  IElementType VARYING_KEYWORD = new CobolTokenType("VARYING_KEYWORD");
  IElementType VERB_DISPLAY = new CobolTokenType("VERB_DISPLAY");
  IElementType VERB_PERFROM = new CobolTokenType("VERB_PERFROM");
  IElementType VERB_STOP_RUN = new CobolTokenType("VERB_STOP_RUN");
  IElementType WORD = new CobolTokenType("WORD");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
      if (type == ABCD) {
        return new CobolAbcdImpl(node);
      }
      else if (type == ARGUMENT_LIST) {
        return new CobolArgumentListImpl(node);
      }
      else if (type == COMMAND) {
        return new CobolCommandImpl(node);
      }
      else if (type == COMPARISON) {
        return new CobolComparisonImpl(node);
      }
      else if (type == DATA_CONTENT) {
        return new CobolDataContentImpl(node);
      }
      else if (type == DATA_SECTION) {
        return new CobolDataSectionImpl(node);
      }
      else if (type == DATA_TYPE) {
        return new CobolDataTypeImpl(node);
      }
      else if (type == DISPLAY) {
        return new CobolDisplayImpl(node);
      }
      else if (type == DIVISION) {
        return new CobolDivisionImpl(node);
      }
      else if (type == DIVISION_TYPE) {
        return new CobolDivisionTypeImpl(node);
      }
      else if (type == IDENTIFICATION_CONTENT) {
        return new CobolIdentificationContentImpl(node);
      }
      else if (type == IDENTIFICATION_KV_PAIR) {
        return new CobolIdentificationKvPairImpl(node);
      }
      else if (type == PARAGRAPH_BODY) {
        return new CobolParagraphBodyImpl(node);
      }
      else if (type == PERFORM) {
        return new CobolPerformImpl(node);
      }
      else if (type == PROCEDURE_CONTENT) {
        return new CobolProcedureContentImpl(node);
      }
      else if (type == PROCEDURE_PARAGRAPH) {
        return new CobolProcedureParagraphImpl(node);
      }
      else if (type == SENTENCE) {
        return new CobolSentenceImpl(node);
      }
      else if (type == STATEMENT) {
        return new CobolStatementImpl(node);
      }
      else if (type == STOP) {
        return new CobolStopImpl(node);
      }
      else if (type == STRING_LITERAL) {
        return new CobolStringLiteralImpl(node);
      }
      else if (type == VALUE_OR_STRING) {
        return new CobolValueOrStringImpl(node);
      }
      else if (type == VARIABLE_DECLARATION) {
        return new CobolVariableDeclarationImpl(node);
      }
      else if (type == WS_SECTION_CONTENT) {
        return new CobolWsSectionContentImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}

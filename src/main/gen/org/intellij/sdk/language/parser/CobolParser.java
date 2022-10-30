// This is a generated file. Not intended for manual editing.
package org.intellij.sdk.language.parser;

import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilder.Marker;
import static org.intellij.sdk.language.psi.CobolTypes.*;
import static com.intellij.lang.parser.GeneratedParserUtilBase.*;
import com.intellij.psi.tree.IElementType;
import com.intellij.lang.ASTNode;
import com.intellij.psi.tree.TokenSet;
import com.intellij.lang.PsiParser;
import com.intellij.lang.LightPsiParser;

@SuppressWarnings({"SimplifiableIfStatement", "UnusedAssignment"})
public class CobolParser implements PsiParser, LightPsiParser {

  public ASTNode parse(IElementType t, PsiBuilder b) {
    parseLight(t, b);
    return b.getTreeBuilt();
  }

  public void parseLight(IElementType t, PsiBuilder b) {
    boolean r;
    b = adapt_builder_(t, b, this, null);
    Marker m = enter_section_(b, 0, _COLLAPSE_, null);
    r = parse_root_(t, b);
    exit_section_(b, 0, m, t, r, true, TRUE_CONDITION);
  }

  protected boolean parse_root_(IElementType t, PsiBuilder b) {
    return parse_root_(t, b, 0);
  }

  static boolean parse_root_(IElementType t, PsiBuilder b, int l) {
    return CobolFile(b, l + 1);
  }

  /* ********************************************************** */
  // division*
  static boolean CobolFile(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "CobolFile")) return false;
    while (true) {
      int c = current_position_(b);
      if (!division(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "CobolFile", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // COMMENT
  public static boolean abcd(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "abcd")) return false;
    if (!nextTokenIs(b, COMMENT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMENT);
    exit_section_(b, m, ABCD, r);
    return r;
  }

  /* ********************************************************** */
  // WORD*
  public static boolean argument_list(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "argument_list")) return false;
    Marker m = enter_section_(b, l, _NONE_, ARGUMENT_LIST, "<argument list>");
    while (true) {
      int c = current_position_(b);
      if (!consumeToken(b, WORD)) break;
      if (!empty_element_parsed_guard_(b, "argument_list", c)) break;
    }
    exit_section_(b, l, m, true, false, null);
    return true;
  }

  /* ********************************************************** */
  // perform | stop | display
  public static boolean command(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "command")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, COMMAND, "<command>");
    r = perform(b, l + 1);
    if (!r) r = stop(b, l + 1);
    if (!r) r = display(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // VALUE COMPARISON_SIGN VALUE
  public static boolean comparison(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "comparison")) return false;
    if (!nextTokenIs(b, VALUE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, VALUE, COMPARISON_SIGN, VALUE);
    exit_section_(b, m, COMPARISON, r);
    return r;
  }

  /* ********************************************************** */
  // data_section*
  public static boolean data_content(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "data_content")) return false;
    Marker m = enter_section_(b, l, _NONE_, DATA_CONTENT, "<data content>");
    while (true) {
      int c = current_position_(b);
      if (!data_section(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "data_content", c)) break;
    }
    exit_section_(b, l, m, true, false, null);
    return true;
  }

  /* ********************************************************** */
  // line_number DATA_SECTION_WS ws_section_content
  public static boolean data_section(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "data_section")) return false;
    if (!nextTokenIs(b, LINE_NUMBER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, LINE_NUMBER, DATA_SECTION_WS);
    r = r && ws_section_content(b, l + 1);
    exit_section_(b, m, DATA_SECTION, r);
    return r;
  }

  /* ********************************************************** */
  // BASE_TYPE PAREN_OPEN TYPE_SIZE PAREN_CLOSE
  public static boolean data_type(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "data_type")) return false;
    if (!nextTokenIs(b, BASE_TYPE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, BASE_TYPE, PAREN_OPEN, TYPE_SIZE, PAREN_CLOSE);
    exit_section_(b, m, DATA_TYPE, r);
    return r;
  }

  /* ********************************************************** */
  // VERB_DISPLAY value_or_string+
  public static boolean display(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "display")) return false;
    if (!nextTokenIs(b, VERB_DISPLAY)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, VERB_DISPLAY);
    r = r && display_1(b, l + 1);
    exit_section_(b, m, DISPLAY, r);
    return r;
  }

  // value_or_string+
  private static boolean display_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "display_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = value_or_string(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!value_or_string(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "display_1", c)) break;
    }
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // (line_number DIVISION_TYPE_ID identification_content) | (line_number DIVISION_TYPE_DATA data_content) | (line_number DIVISION_TYPE_PROC procedure_content)
  public static boolean division(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "division")) return false;
    if (!nextTokenIs(b, LINE_NUMBER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = division_0(b, l + 1);
    if (!r) r = division_1(b, l + 1);
    if (!r) r = division_2(b, l + 1);
    exit_section_(b, m, DIVISION, r);
    return r;
  }

  // line_number DIVISION_TYPE_ID identification_content
  private static boolean division_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "division_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, LINE_NUMBER, DIVISION_TYPE_ID);
    r = r && identification_content(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // line_number DIVISION_TYPE_DATA data_content
  private static boolean division_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "division_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, LINE_NUMBER, DIVISION_TYPE_DATA);
    r = r && data_content(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // line_number DIVISION_TYPE_PROC procedure_content
  private static boolean division_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "division_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, LINE_NUMBER, DIVISION_TYPE_PROC);
    r = r && procedure_content(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // DIVISION_TYPE_ID | DIVISION_TYPE_DATA | DIVISION_TYPE_PROC
  public static boolean division_type(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "division_type")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, DIVISION_TYPE, "<division type>");
    r = consumeToken(b, DIVISION_TYPE_ID);
    if (!r) r = consumeToken(b, DIVISION_TYPE_DATA);
    if (!r) r = consumeToken(b, DIVISION_TYPE_PROC);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // identification_kv_pair*
  public static boolean identification_content(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "identification_content")) return false;
    Marker m = enter_section_(b, l, _NONE_, IDENTIFICATION_CONTENT, "<identification content>");
    while (true) {
      int c = current_position_(b);
      if (!identification_kv_pair(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "identification_content", c)) break;
    }
    exit_section_(b, l, m, true, false, null);
    return true;
  }

  /* ********************************************************** */
  // line_number IDENTIFICATION_KEY IDENTIFICATION_VALUE
  public static boolean identification_kv_pair(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "identification_kv_pair")) return false;
    if (!nextTokenIs(b, LINE_NUMBER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, LINE_NUMBER, IDENTIFICATION_KEY, IDENTIFICATION_VALUE);
    exit_section_(b, m, IDENTIFICATION_KV_PAIR, r);
    return r;
  }

  /* ********************************************************** */
  // sentence*
  public static boolean paragraph_body(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "paragraph_body")) return false;
    Marker m = enter_section_(b, l, _NONE_, PARAGRAPH_BODY, "<paragraph body>");
    while (true) {
      int c = current_position_(b);
      if (!sentence(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "paragraph_body", c)) break;
    }
    exit_section_(b, l, m, true, false, null);
    return true;
  }

  /* ********************************************************** */
  // VERB_PERFROM PARAGRAPH_NAME VARYING_KEYWORD VARIABLE_NAME FROM_KEYWORD VALUE BY_KEYWORD VALUE UNTIL_KEYWORD comparison
  public static boolean perform(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "perform")) return false;
    if (!nextTokenIs(b, VERB_PERFROM)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, VERB_PERFROM, PARAGRAPH_NAME, VARYING_KEYWORD, VARIABLE_NAME, FROM_KEYWORD, VALUE, BY_KEYWORD, VALUE, UNTIL_KEYWORD);
    r = r && comparison(b, l + 1);
    exit_section_(b, m, PERFORM, r);
    return r;
  }

  /* ********************************************************** */
  // procedure_paragraph*
  public static boolean procedure_content(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "procedure_content")) return false;
    Marker m = enter_section_(b, l, _NONE_, PROCEDURE_CONTENT, "<procedure content>");
    while (true) {
      int c = current_position_(b);
      if (!procedure_paragraph(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "procedure_content", c)) break;
    }
    exit_section_(b, l, m, true, false, null);
    return true;
  }

  /* ********************************************************** */
  // line_number PARAGRAPH_NAME paragraph_body
  public static boolean procedure_paragraph(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "procedure_paragraph")) return false;
    if (!nextTokenIs(b, LINE_NUMBER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, LINE_NUMBER, PARAGRAPH_NAME);
    r = r && paragraph_body(b, l + 1);
    exit_section_(b, m, PROCEDURE_PARAGRAPH, r);
    return r;
  }

  /* ********************************************************** */
  // statement* DOT
  public static boolean sentence(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "sentence")) return false;
    if (!nextTokenIs(b, "<sentence>", DOT, LINE_NUMBER)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, SENTENCE, "<sentence>");
    r = sentence_0(b, l + 1);
    r = r && consumeToken(b, DOT);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // statement*
  private static boolean sentence_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "sentence_0")) return false;
    while (true) {
      int c = current_position_(b);
      if (!statement(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "sentence_0", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // line_number command
  public static boolean statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "statement")) return false;
    if (!nextTokenIs(b, LINE_NUMBER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LINE_NUMBER);
    r = r && command(b, l + 1);
    exit_section_(b, m, STATEMENT, r);
    return r;
  }

  /* ********************************************************** */
  // VERB_STOP_RUN
  public static boolean stop(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "stop")) return false;
    if (!nextTokenIs(b, VERB_STOP_RUN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, VERB_STOP_RUN);
    exit_section_(b, m, STOP, r);
    return r;
  }

  /* ********************************************************** */
  // QUOTE ANY_CHARACTER* QUOTE
  public static boolean string_literal(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "string_literal")) return false;
    if (!nextTokenIs(b, QUOTE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, QUOTE);
    r = r && string_literal_1(b, l + 1);
    r = r && consumeToken(b, QUOTE);
    exit_section_(b, m, STRING_LITERAL, r);
    return r;
  }

  // ANY_CHARACTER*
  private static boolean string_literal_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "string_literal_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!consumeToken(b, ANY_CHARACTER)) break;
      if (!empty_element_parsed_guard_(b, "string_literal_1", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // VALUE | string_literal
  public static boolean value_or_string(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "value_or_string")) return false;
    if (!nextTokenIs(b, "<value or string>", QUOTE, VALUE)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, VALUE_OR_STRING, "<value or string>");
    r = consumeToken(b, VALUE);
    if (!r) r = string_literal(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // line_number VARIABLE_NUMBER VARIABLE_NAME PIC_KEYWORD data_type VALUE_KEYWORD VALUE DOT
  public static boolean variable_declaration(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "variable_declaration")) return false;
    if (!nextTokenIs(b, LINE_NUMBER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, LINE_NUMBER, VARIABLE_NUMBER, VARIABLE_NAME, PIC_KEYWORD);
    r = r && data_type(b, l + 1);
    r = r && consumeTokens(b, 0, VALUE_KEYWORD, VALUE, DOT);
    exit_section_(b, m, VARIABLE_DECLARATION, r);
    return r;
  }

  /* ********************************************************** */
  // variable_declaration*
  public static boolean ws_section_content(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ws_section_content")) return false;
    Marker m = enter_section_(b, l, _NONE_, WS_SECTION_CONTENT, "<ws section content>");
    while (true) {
      int c = current_position_(b);
      if (!variable_declaration(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "ws_section_content", c)) break;
    }
    exit_section_(b, l, m, true, false, null);
    return true;
  }

}

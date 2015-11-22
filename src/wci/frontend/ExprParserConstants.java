/* Generated By:JJTree&JavaCC: Do not edit this line. ExprParserConstants.java */
package wci.frontend;


/**
 * Token literal values and constants.
 * Generated by org.javacc.parser.OtherFilesGen#start()
 */
public interface ExprParserConstants {

  /** End of File. */
  int EOF = 0;
  /** RegularExpression Id. */
  int IGNORE = 1;
  /** RegularExpression Id. */
  int SINGLELINECOMMENT = 2;
  /** RegularExpression Id. */
  int NEWLINE = 3;
  /** RegularExpression Id. */
  int SPECIALSYMBOL = 7;
  /** RegularExpression Id. */
  int SSAnd = 8;
  /** RegularExpression Id. */
  int SSOr = 9;
  /** RegularExpression Id. */
  int SSNot = 10;
  /** RegularExpression Id. */
  int SSL = 11;
  /** RegularExpression Id. */
  int SSLE = 12;
  /** RegularExpression Id. */
  int SSG = 13;
  /** RegularExpression Id. */
  int SSGE = 14;
  /** RegularExpression Id. */
  int SSNE = 15;
  /** RegularExpression Id. */
  int SSPlus = 16;
  /** RegularExpression Id. */
  int SSMinus = 17;
  /** RegularExpression Id. */
  int SSStar = 18;
  /** RegularExpression Id. */
  int SSDivide = 19;
  /** RegularExpression Id. */
  int SSplusplus = 20;
  /** RegularExpression Id. */
  int SSminusminus = 21;
  /** RegularExpression Id. */
  int SSSemiColon = 22;
  /** RegularExpression Id. */
  int SSPlusEquals = 23;
  /** RegularExpression Id. */
  int SSMinusEquals = 24;
  /** RegularExpression Id. */
  int SSMultEquals = 25;
  /** RegularExpression Id. */
  int SSDivideEquals = 26;
  /** RegularExpression Id. */
  int SSEquals = 27;
  /** RegularExpression Id. */
  int SSOpenParen = 28;
  /** RegularExpression Id. */
  int SSCloseParen = 29;
  /** RegularExpression Id. */
  int SSOpenBraces = 30;
  /** RegularExpression Id. */
  int SSCloseBraces = 31;
  /** RegularExpression Id. */
  int SSOpenBracket = 32;
  /** RegularExpression Id. */
  int SSCloseBracket = 33;
  /** RegularExpression Id. */
  int ComparisonEquals = 34;
  /** RegularExpression Id. */
  int SSComma = 35;
  /** RegularExpression Id. */
  int SSColon = 36;
  /** RegularExpression Id. */
  int RESERVEDWORDPROCEDURE = 37;
  /** RegularExpression Id. */
  int RESERVEDWORDIF = 38;
  /** RegularExpression Id. */
  int RESERVEDWORDBREAK = 39;
  /** RegularExpression Id. */
  int RESERVEDWORDELSE = 40;
  /** RegularExpression Id. */
  int RESERVEDWORDELSEIF = 41;
  /** RegularExpression Id. */
  int RESERVEDWORDRETURN = 42;
  /** RegularExpression Id. */
  int RESERVEDWORDCASE = 43;
  /** RegularExpression Id. */
  int RESERVEDWORDSWITCH = 44;
  /** RegularExpression Id. */
  int RESERVEDWORDWHILE = 45;
  /** RegularExpression Id. */
  int RESERVEDWORDFOR = 46;
  /** RegularExpression Id. */
  int RESERVEDWORDTRUE = 47;
  /** RegularExpression Id. */
  int RESERVEDWORDFALSE = 48;
  /** RegularExpression Id. */
  int RESERVEDWORDINT = 49;
  /** RegularExpression Id. */
  int RESERVEDWORDFLOAT = 50;
  /** RegularExpression Id. */
  int RESERVEDWORDBOOLEAN = 51;
  /** RegularExpression Id. */
  int RESERVEDWORDDOUBLE = 52;
  /** RegularExpression Id. */
  int RESERVEDWORDSTRING = 53;
  /** RegularExpression Id. */
  int RESERVEDWORDHASHMAP = 54;
  /** RegularExpression Id. */
  int RESERVEDWORDSET = 55;
  /** RegularExpression Id. */
  int RESERVEDWORDLIST = 56;
  /** RegularExpression Id. */
  int RESERVEDWORDNEW = 57;
  /** RegularExpression Id. */
  int IDENTIFIER = 58;
  /** RegularExpression Id. */
  int STRING = 59;
  /** RegularExpression Id. */
  int INTEGER = 60;
  /** RegularExpression Id. */
  int DECIMALINTEGER = 61;
  /** RegularExpression Id. */
  int OCTALINTEGER = 62;
  /** RegularExpression Id. */
  int HEXINTEGER = 63;
  /** RegularExpression Id. */
  int REALNUMBER = 64;
  /** RegularExpression Id. */
  int REAL_NUMBER = 65;
  /** RegularExpression Id. */
  int SINGLEQUOTE = 66;
  /** RegularExpression Id. */
  int DOUBLEQUOTE = 67;
  /** RegularExpression Id. */
  int HEXLETTERS = 68;
  /** RegularExpression Id. */
  int DIGIT = 69;
  /** RegularExpression Id. */
  int NONZERO = 70;
  /** RegularExpression Id. */
  int LETTER = 71;
  /** RegularExpression Id. */
  int OCTALS = 72;
  /** RegularExpression Id. */
  int ZERO = 73;
  /** RegularExpression Id. */
  int ERROR = 74;

  /** Lexical state. */
  int DEFAULT = 0;
  /** Lexical state. */
  int WithinComment = 1;

  /** Literal token values. */
  String[] tokenImage = {
    "<EOF>",
    "<IGNORE>",
    "<SINGLELINECOMMENT>",
    "<NEWLINE>",
    "\"/*\"",
    "\"*/\"",
    "<token of kind 6>",
    "<SPECIALSYMBOL>",
    "\"&\"",
    "\"|\"",
    "\"!\"",
    "\"<\"",
    "\"<=\"",
    "\">\"",
    "\">=\"",
    "\"!=\"",
    "\"+\"",
    "\"-\"",
    "\"*\"",
    "\"/\"",
    "\"++\"",
    "\"--\"",
    "\";\"",
    "\"+=\"",
    "\"-=\"",
    "\"*=\"",
    "\"/=\"",
    "\"=\"",
    "\"(\"",
    "\")\"",
    "\"{\"",
    "\"}\"",
    "\"[\"",
    "\"]\"",
    "\"==\"",
    "\",\"",
    "\":\"",
    "\"Procedure ::\"",
    "\"if\"",
    "\"break\"",
    "\"else\"",
    "\"elseif\"",
    "\"return\"",
    "\"case\"",
    "\"switch\"",
    "\"while\"",
    "\"for\"",
    "\"true\"",
    "\"false\"",
    "\"int\"",
    "\"float\"",
    "\"boolean\"",
    "\"double\"",
    "\"string\"",
    "\"hashmap\"",
    "\"set\"",
    "\"list\"",
    "\"new\"",
    "<IDENTIFIER>",
    "<STRING>",
    "<INTEGER>",
    "<DECIMALINTEGER>",
    "<OCTALINTEGER>",
    "<HEXINTEGER>",
    "<REALNUMBER>",
    "<REAL_NUMBER>",
    "<SINGLEQUOTE>",
    "<DOUBLEQUOTE>",
    "<HEXLETTERS>",
    "<DIGIT>",
    "<NONZERO>",
    "<LETTER>",
    "<OCTALS>",
    "<ZERO>",
    "<ERROR>",
  };

}

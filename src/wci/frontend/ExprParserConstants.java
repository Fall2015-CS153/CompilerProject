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
  int SSDollar = 11;
  /** RegularExpression Id. */
  int SSL = 12;
  /** RegularExpression Id. */
  int SSLE = 13;
  /** RegularExpression Id. */
  int SSG = 14;
  /** RegularExpression Id. */
  int SSGE = 15;
  /** RegularExpression Id. */
  int SSNE = 16;
  /** RegularExpression Id. */
  int SSPlus = 17;
  /** RegularExpression Id. */
  int SSMinus = 18;
  /** RegularExpression Id. */
  int SSStar = 19;
  /** RegularExpression Id. */
  int SSDivide = 20;
  /** RegularExpression Id. */
  int SSplusplus = 21;
  /** RegularExpression Id. */
  int SSminusminus = 22;
  /** RegularExpression Id. */
  int SSSemiColon = 23;
  /** RegularExpression Id. */
  int SSPlusEquals = 24;
  /** RegularExpression Id. */
  int SSMinusEquals = 25;
  /** RegularExpression Id. */
  int SSMultEquals = 26;
  /** RegularExpression Id. */
  int SSDivideEquals = 27;
  /** RegularExpression Id. */
  int SSEquals = 28;
  /** RegularExpression Id. */
  int SSOpenParen = 29;
  /** RegularExpression Id. */
  int SSCloseParen = 30;
  /** RegularExpression Id. */
  int SSOpenBraces = 31;
  /** RegularExpression Id. */
  int SSCloseBraces = 32;
  /** RegularExpression Id. */
  int SSOpenBracket = 33;
  /** RegularExpression Id. */
  int SSCloseBracket = 34;
  /** RegularExpression Id. */
  int ComparisonEquals = 35;
  /** RegularExpression Id. */
  int SSComma = 36;
  /** RegularExpression Id. */
  int SSColon = 37;
  /** RegularExpression Id. */
  int SSTilda = 38;
  /** RegularExpression Id. */
  int SSDot = 39;
  /** RegularExpression Id. */
  int RESERVEDWORDLOCAL = 40;
  /** RegularExpression Id. */
  int RESERVEDWORDREADINT = 41;
  /** RegularExpression Id. */
  int RESERVEDWORDPRINT = 42;
  /** RegularExpression Id. */
  int RESERVEDWORDPROCEDURE = 43;
  /** RegularExpression Id. */
  int RESERVEDWORDCALL = 44;
  /** RegularExpression Id. */
  int RESERVEDWORDIF = 45;
  /** RegularExpression Id. */
  int RESERVEDWORDBREAK = 46;
  /** RegularExpression Id. */
  int RESERVEDWORDELSE = 47;
  /** RegularExpression Id. */
  int RESERVEDWORDELSEIF = 48;
  /** RegularExpression Id. */
  int RESERVEDWORDRETURN = 49;
  /** RegularExpression Id. */
  int RESERVEDWORDCASE = 50;
  /** RegularExpression Id. */
  int RESERVEDWORDSWITCH = 51;
  /** RegularExpression Id. */
  int RESERVEDWORDWHILE = 52;
  /** RegularExpression Id. */
  int RESERVEDWORDFOR = 53;
  /** RegularExpression Id. */
  int RESERVEDWORDINT = 54;
  /** RegularExpression Id. */
  int RESERVEDWORDFLOAT = 55;
  /** RegularExpression Id. */
  int RESERVEDWORDBOOLEAN = 56;
  /** RegularExpression Id. */
  int RESERVEDWORDDOUBLE = 57;
  /** RegularExpression Id. */
  int RESERVEDWORDSTRING = 58;
  /** RegularExpression Id. */
  int RESERVEDWORDHASHMAP = 59;
  /** RegularExpression Id. */
  int RESERVEDWORDSET = 60;
  /** RegularExpression Id. */
  int RESERVEDWORDLIST = 61;
  /** RegularExpression Id. */
  int RESERVEDWORDNEW = 62;
  /** RegularExpression Id. */
  int RESERVEDWORDPUBLIC = 63;
  /** RegularExpression Id. */
  int RESERVEDWORDVOID = 64;
  /** RegularExpression Id. */
  int DOTGETVAL = 65;
  /** RegularExpression Id. */
  int DOTADD = 66;
  /** RegularExpression Id. */
  int DOTREMOVE = 67;
  /** RegularExpression Id. */
  int DOTSETVAL = 68;
  /** RegularExpression Id. */
  int DOTGETINDEX = 69;
  /** RegularExpression Id. */
  int DOTGETSIZE = 70;
  /** RegularExpression Id. */
  int DOTGETSTRING = 71;
  /** RegularExpression Id. */
  int DOTCONTAINS = 72;
  /** RegularExpression Id. */
  int DOTSUBSTRING = 73;
  /** RegularExpression Id. */
  int DOTAPPEND = 74;
  /** RegularExpression Id. */
  int BOOLEAN = 75;
  /** RegularExpression Id. */
  int IDENTIFIER = 76;
  /** RegularExpression Id. */
  int STRING = 77;
  /** RegularExpression Id. */
  int INTEGER = 78;
  /** RegularExpression Id. */
  int DECIMALINTEGER = 79;
  /** RegularExpression Id. */
  int OCTALINTEGER = 80;
  /** RegularExpression Id. */
  int HEXINTEGER = 81;
  /** RegularExpression Id. */
  int DOUBLE = 82;
  /** RegularExpression Id. */
  int REALNUMBER = 83;
  /** RegularExpression Id. */
  int REAL_NUMBER = 84;
  /** RegularExpression Id. */
  int SINGLEQUOTE = 85;
  /** RegularExpression Id. */
  int DOUBLEQUOTE = 86;
  /** RegularExpression Id. */
  int HEXLETTERS = 87;
  /** RegularExpression Id. */
  int DIGIT = 88;
  /** RegularExpression Id. */
  int NONZERO = 89;
  /** RegularExpression Id. */
  int LETTER = 90;
  /** RegularExpression Id. */
  int OCTALS = 91;
  /** RegularExpression Id. */
  int ZERO = 92;
  /** RegularExpression Id. */
  int ERROR = 93;

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
    "\"$\"",
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
    "\"~\"",
    "\".\"",
    "\"local\"",
    "\"readInt\"",
    "\"put\"",
    "\"Procedure ::\"",
    "\"Call\"",
    "\"if\"",
    "\"break\"",
    "\"else\"",
    "\"elseif\"",
    "\"return\"",
    "\"case\"",
    "\"switch\"",
    "\"while\"",
    "\"for\"",
    "\"int\"",
    "\"float\"",
    "\"boolean\"",
    "\"double\"",
    "\"string\"",
    "\"map\"",
    "\"set\"",
    "\"list\"",
    "\"new\"",
    "\"public\"",
    "\"void\"",
    "\"getVal\"",
    "\"add\"",
    "\"remove\"",
    "\"setVal\"",
    "\"getIndex\"",
    "\"getSize\"",
    "\"getString\"",
    "\"contains\"",
    "\"substring\"",
    "\"append\"",
    "<BOOLEAN>",
    "<IDENTIFIER>",
    "<STRING>",
    "<INTEGER>",
    "<DECIMALINTEGER>",
    "<OCTALINTEGER>",
    "<HEXINTEGER>",
    "<DOUBLE>",
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

/* Generated By:JJTree: Do not edit this line. ASTDeclaration.java Version 4.3 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=true,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
public
class ASTDeclaration extends SimpleNode {
  public ASTDeclaration(int id) {
    super(id);
  }

  public ASTDeclaration(ExprParser p, int id) {
    super(p, id);
  }


  /** Accept the visitor. **/
  public Object jjtAccept(ExprParserVisitor visitor, Object data) {
    return visitor.visit(this, data);
  }
}
/* JavaCC - OriginalChecksum=81cfbad82322f4337005d5c6bc4fe1c3 (do not edit this line) */
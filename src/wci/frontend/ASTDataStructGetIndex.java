/* Generated By:JJTree: Do not edit this line. ASTDataStructGetIndex.java Version 4.3 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=true,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=wci.intermediate.icodeimpl.ICodeNodeImpl,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package wci.frontend;

public
class ASTDataStructGetIndex extends SimpleNode {
  public ASTDataStructGetIndex(int id) {
    super(id);
  }

  public ASTDataStructGetIndex(ExprParser p, int id) {
    super(p, id);
  }


  /** Accept the visitor. **/
  public Object jjtAccept(ExprParserVisitor visitor, Object data) {
    return visitor.visit(this, data);
  }
}
/* JavaCC - OriginalChecksum=bb4faece5da5d562231e26889e2f01d5 (do not edit this line) */
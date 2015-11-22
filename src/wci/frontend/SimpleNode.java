package wci.frontend;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import wci.intermediate.*;
import wci.intermediate.icodeimpl.ICodeKeyImpl;
import wci.intermediate.icodeimpl.ICodeNodeImpl;


/* Generated By:JJTree: Do not edit this line. SimpleNode.java Version 4.3 */
/* JavaCCOptions:MULTI=false,NODE_USES_PARSER=false,VISITOR=false,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
public
class SimpleNode implements Node {

  protected Node parent;
  protected Node[] children;
  protected int id;
  protected Object value;
  protected ExprParser parser;
  private String image;
  private TypeSpec TypeSpec;
  private ICodeNodeImpl Attribute = new ICodeNodeImpl();
  
  
  public SimpleNode(int i) {
    id = i;
  }

  public SimpleNode(ExprParser p, int i) {
    this(i);
    parser = p;
  }

  public void jjtOpen() {
  }

  public void jjtClose() {
  }

  public void jjtSetParent(Node n) { parent = n; }
  public Node jjtGetParent() { return parent; }

  public void jjtAddChild(Node n, int i) {
    if (children == null) {
      children = new Node[i + 1];
    } else if (i >= children.length) {
      Node c[] = new Node[i + 1];
      System.arraycopy(children, 0, c, 0, children.length);
      children = c;
    }
    children[i] = n;
  }

  public Node jjtGetChild(int i) {
    return children[i];
  }

  public int jjtGetNumChildren() {
    return (children == null) ? 0 : children.length;
  }

  public void jjtSetValue(Object value) { this.value = value; }
  public Object jjtGetValue() { return value; }

  /* You can override these two methods in subclasses of SimpleNode to
     customize the way the node appears when the tree is dumped.  If
     your output uses more than one line you should override
     toString(String), otherwise overriding toString() is probably all
     you need to do. */

  public String toString() { return ExprParserTreeConstants.jjtNodeName[id]; }
  public String toString(String prefix) { return prefix + toString(); }

  /* Override this method if you want to customize how the node dumps
     out its children. */

  public void dump(String prefix) {
    System.out.println(toString(prefix));
    if (children != null) {
      for (int i = 0; i < children.length; ++i) {
        SimpleNode n = (SimpleNode)children[i];
        if (n != null) {
          n.dump(prefix + " ");
        }
      }
    }
  }

    /**
     * @return the image
     */
    public String getImage()
    {
        return image;
    }

    /**
     * @param image the image to set
     */
    public void setImage(String image)
    {
        this.image = image;
    }

    Object childrenAccept(ExprParserVisitor aThis, Object data)
    {
       System.out.println("acc " + aThis + " " + data);
        return this;
     }

    @Override
    public Object jjtAccept(ExprParserVisitor visitor, Object data)
    {
 System.out.println("Adding data " + data);
        Node child = (Node)(data);
        this.jjtAddChild(child,this.jjtGetNumChildren()+1);
        return this;    
    }

    /**
     * @return the TypeSpec
     */
    public TypeSpec getTypeSpec()
    {
        return TypeSpec;
    }

    /**
     * @param type the TypeSpec to set
     */
    public void setTypeSpec(TypeSpec type)
    {
        System.out.println(type);
        this.TypeSpec = type;
        System.out.println(this + " " + this.getTypeSpec());
    }

    public void setAttribute(ICodeKeyImpl a, Object b)
    {
         ICodeNodeImpl ab = new ICodeNodeImpl();
          Attribute.setAttribute(a,b);
          Attribute.addChild(ab);
        System.out.println( Attribute.getChildren().size());
    }
    
    

    public Set<Map.Entry<ICodeKey, Object>> entrySet()
    {
        return  ((ICodeNodeImpl) getAttribute()).entrySet();
    }

    /**
     * @return the Attribute
     */
    public Object getAttribute()
    {
        return Attribute;
    }
    
    /**
     * @return the Attribute
     */
    public Object getAttribute(ICodeKeyImpl a)
    {
        return  Attribute.getAttribute(a);
    }



}

/* JavaCC - OriginalChecksum=5a39e3e498280e4011f23937de66aaee (do not edit this line) */

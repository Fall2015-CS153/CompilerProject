package wci.backend.compiler;

import wci.frontend.*;
import wci.intermediate.*;
import wci.intermediate.symtabimpl.Predefined;

import static wci.intermediate.icodeimpl.ICodeKeyImpl.*;

public class CodeGeneratorVisitor
        extends ExprParserVisitorAdapter
        implements ExprParserTreeConstants
{
     public Object visit(ASTProcedure node, Object data) {
         
         // Generating method call
         CodeGenerator.objectFile.print(".method public "+node.getAttribute(VALUE)+"()V");
         CodeGenerator.objectFile.println();
         // create stuff inside
         SimpleNode commandsNode = (SimpleNode)node.jjtGetChild(0);
         commandsNode.jjtAccept(this, data);
         
         //create end
         CodeGenerator.objectFile.println();
         CodeGenerator.objectFile.println("return\n"+".limit locals 16\n" +
        ".limit stack 32\n" +
        ".end method"+"\n");
         return data;
    }
    public Object visit(ASTPrintStatement node, Object data) {
        Node commandsNode[]=new Node[node.jjtGetNumChildren()];
        String input[]= new String[node.jjtGetNumChildren()];
        for(int i=0;i<node.jjtGetNumChildren();i++){
            commandsNode[i]= node.jjtGetChild(i);
            input[i]=commandsNode[i].jjtAccept(this, data).toString();
        }

        CodeGenerator.objectFile.println("\n"+"    getstatic     java/lang/System/out Ljava/io/PrintStream; \n" +
        "    new       java/lang/StringBuilder \n"+
        "    dup \n"+
        ""+ input[0]+"\n" +
        "    "+
        "invokenonvirtual java/lang/StringBuilder/<init>(Ljava/lang/String;)V");
        for (int i=0; i<node.jjtGetNumChildren()-1;i++){
            CodeGenerator.objectFile.println(input[i+1]+"\n" +
        "    invokevirtual java/lang/StringBuilder/append("+input[i+1].substring(input[i+1].length()-1)+")Ljava/lang/StringBuilder;");
        }
        CodeGenerator.objectFile.println("    invokevirtual java/lang/StringBuilder/toString()Ljava/lang/String;\n" +
        "    invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V\n");
       
        return data;
    }
    public Object visit(ASTProcedureCall node, Object data){
        CodeGenerator.objectFile.println("    new Test\n" +
        "    dup\n" +
        "    invokespecial Test/<init>()V\n" +
        "    invokevirtual Test/"+node.getAttribute(VALUE)+"()V");
    return data;
    }

    public Object visit(ASTAssignment node, Object data)
    {
        String programName = (String) data;
        SimpleNode variableNode = (SimpleNode) node.jjtGetChild(0);
        SimpleNode expressionNode = (SimpleNode) node.jjtGetChild(1);

        // Emit code for the expression.
        expressionNode.jjtAccept(this, data);
        TypeSpec expressionType = expressionNode.getTypeSpec();

        // Get the assignment target type.
        TypeSpec targetType = node.getTypeSpec();

        // Convert an integer value to float if necessary.
        if ((targetType == Predefined.realType) && (expressionType
                == Predefined.integerType))
        {
            CodeGenerator.objectFile.println("    i2f");
            CodeGenerator.objectFile.flush();
        }

        SymTabEntry id = (SymTabEntry) variableNode.getAttribute(ID);
        String fieldName = id.getName();
        TypeSpec type = id.getTypeSpec();
        String typeCode = type == Predefined.integerType ? "I" : "F";

        // Emit the appropriate store instruction.
        CodeGenerator.objectFile.println("    putstatic " + programName + "/"
                + fieldName + " " + typeCode);
        CodeGenerator.objectFile.flush();

        return data;
    }

    public Object visit(ASTvariable node, Object data)
    {
        String programName = (String) data;
        SymTabEntry id = (SymTabEntry) node.getAttribute(ID);
        String fieldName = id.getName();
        TypeSpec type = id.getTypeSpec();
        String typeCode = type == Predefined.integerType ? "I" : "F";

        // Emit the appropriate load instruction.
        CodeGenerator.objectFile.println("    getstatic " + programName + "/"
                + fieldName + " " + typeCode);
        CodeGenerator.objectFile.flush();

        return "    getstatic " + programName + "/"
                + fieldName + " " + typeCode;
    }

    public Object visit(ASTIntegerConst node, Object data)
    {
        int value = (Integer) node.getAttribute(VALUE);

        // Emit a load constant instruction.
        CodeGenerator.objectFile.println("    ldc " + value);
        CodeGenerator.objectFile.flush();

        return "    ldc \""+value+"\"";
    }

    public Object visit(ASTRealConst node, Object data)
    {
        double value = (Double) node.getAttribute(VALUE);

        // Emit a load constant instruction.
        CodeGenerator.objectFile.println("    ldc " + value);
        CodeGenerator.objectFile.flush();

        return "    ldc \""+value+"\"";
    }
    public Object visit(ASTStringConst node, Object data){
        String value = (String) node.getAttribute(VALUE);

        // Emit a load constant instruction.
        CodeGenerator.objectFile.println("    ldc \"" + value+"\"");
        CodeGenerator.objectFile.flush();
        
        return "    ldc \""+value+"\"";
    }
    public Object visit(ASTPlusEqualsStatement node, Object data)
    {
        SimpleNode addend0Node = (SimpleNode) node.jjtGetChild(0);
        SimpleNode addend1Node = (SimpleNode) node.jjtGetChild(1);

        TypeSpec type0 = addend0Node.getTypeSpec();
        TypeSpec type1 = addend1Node.getTypeSpec();

        // Get the addition type.
        TypeSpec type = node.getTypeSpec();
        String typePrefix = (type == Predefined.integerType) ? "i" : "f";

        // Emit code for the first expression
        // with type conversion if necessary.
        addend0Node.jjtAccept(this, data);
        if ((type == Predefined.realType) && (type0 == Predefined.integerType))
        {
            CodeGenerator.objectFile.println("    i2f");
            CodeGenerator.objectFile.flush();
        }

        // Emit code for the second expression
        // with type conversion if necessary.
        addend1Node.jjtAccept(this, data);
        if ((type == Predefined.realType) && (type1 == Predefined.integerType))
        {
            CodeGenerator.objectFile.println("    i2f");
            CodeGenerator.objectFile.flush();
        }

        // Emit the appropriate add instruction.
        CodeGenerator.objectFile.println("    " + typePrefix + "add");
        CodeGenerator.objectFile.flush();
        //assign the value to itself.
                
        String typeCode = type == Predefined.integerType ? "I" : "F";
        String programName = (String) data;

        SymTabEntry id = (SymTabEntry) ( (SimpleNode)node.jjtGetChild(0)).getAttribute(ID);
        String fieldName = id.getName();

        CodeGenerator.objectFile.println("    putstatic " + programName + "/"
                + fieldName + " " + typeCode);
        CodeGenerator.objectFile.flush();

        return data;
    }

    public Object visit(ASTMinusEqualsStatement node, Object data)
    {
        SimpleNode addend0Node = (SimpleNode) node.jjtGetChild(0);
        SimpleNode addend1Node = (SimpleNode) node.jjtGetChild(1);

        TypeSpec type0 = addend0Node.getTypeSpec();
        TypeSpec type1 = addend1Node.getTypeSpec();

        // Get the addition type.
        TypeSpec type = node.getTypeSpec();
        String typePrefix = (type == Predefined.integerType) ? "i" : "f";

        // Emit code for the first expression
        // with type conversion if necessary.
        addend0Node.jjtAccept(this, data);
        if ((type == Predefined.realType) && (type0 == Predefined.integerType))
        {
            CodeGenerator.objectFile.println("    i2f");
            CodeGenerator.objectFile.flush();
        }

        // Emit code for the second expression
        // with type conversion if necessary.
        addend1Node.jjtAccept(this, data);
        if ((type == Predefined.realType) && (type1 == Predefined.integerType))
        {
            CodeGenerator.objectFile.println("    i2f");
            CodeGenerator.objectFile.flush();
        }

        // Emit the appropriate add instruction.
        CodeGenerator.objectFile.println("    " + typePrefix + "sub");
        CodeGenerator.objectFile.flush();
        //assign the result value [data] to the initial variable.
        
                
        String typeCode = type == Predefined.integerType ? "I" : "F";
        String programName = (String) data;

        SymTabEntry id = (SymTabEntry) ( (SimpleNode)node.jjtGetChild(0)).getAttribute(ID);
        String fieldName = id.getName();

        CodeGenerator.objectFile.println("    putstatic " + programName + "/"
                + fieldName+ " " + typeCode);
        CodeGenerator.objectFile.flush();
        return data;
    }

    public Object visit(ASTStarEqualsStatement node, Object data)
    {
        SimpleNode addend0Node = (SimpleNode) node.jjtGetChild(0);
        SimpleNode addend1Node = (SimpleNode) node.jjtGetChild(1);

        TypeSpec type0 = addend0Node.getTypeSpec();
        TypeSpec type1 = addend1Node.getTypeSpec();

        // Get the addition type.
        TypeSpec type = node.getTypeSpec();

        String typePrefix = (type == Predefined.integerType) ? "i" : "f";

        // Emit code for the first expression
        // with type conversion if necessary.
        addend0Node.jjtAccept(this, data);
        if ((type == Predefined.realType) && (type0 == Predefined.integerType))
        {
            CodeGenerator.objectFile.println("    i2f");
            CodeGenerator.objectFile.flush();
        }

        // Emit code for the second expression
        // with type conversion if necessary.
        addend1Node.jjtAccept(this, data);
        if ((type == Predefined.realType) && (type1 == Predefined.integerType))
        {
            CodeGenerator.objectFile.println("    i2f");
            CodeGenerator.objectFile.flush();
        }

        // Emit the appropriate add instruction.
        CodeGenerator.objectFile.println("    " + typePrefix + "mul");
        CodeGenerator.objectFile.flush();
        
                
        String typeCode = type == Predefined.integerType ? "I" : "F";
        String programName = (String) data;

        SymTabEntry id = (SymTabEntry) ( (SimpleNode)node.jjtGetChild(0)).getAttribute(ID);
        String fieldName = id.getName();
        

        CodeGenerator.objectFile.println("    putstatic " + programName + "/"
                + fieldName + " " + typeCode);
        CodeGenerator.objectFile.flush();

        return data;
    }

    public Object visit(ASTDivideEqualsStatement node, Object data)
    {
        SimpleNode addend0Node = (SimpleNode) node.jjtGetChild(0);
        SimpleNode addend1Node = (SimpleNode) node.jjtGetChild(1);

        TypeSpec type0 = addend0Node.getTypeSpec();
        TypeSpec type1 = addend1Node.getTypeSpec();

        // Get the addition type.
        TypeSpec type = node.getTypeSpec();
        String typePrefix = (type == Predefined.integerType) ? "i" : "f";

        // Emit code for the first expression
        // with type conversion if necessary.
        addend0Node.jjtAccept(this, data);
        if ((type == Predefined.realType) && (type0 == Predefined.integerType))
        {
            CodeGenerator.objectFile.println("    i2f");
            CodeGenerator.objectFile.flush();
        }

        // Emit code for the second expression
        // with type conversion if necessary.
        addend1Node.jjtAccept(this, data);
        if ((type == Predefined.realType) && (type1 == Predefined.integerType))
        {
            CodeGenerator.objectFile.println("    i2f");
            CodeGenerator.objectFile.flush();
        }

        // Emit the appropriate add instruction.
        CodeGenerator.objectFile.println("    " + typePrefix + "div");
        CodeGenerator.objectFile.flush();

        String typeCode = type == Predefined.integerType ? "I" : "F";
        String programName = (String) data;


        SymTabEntry id = (SymTabEntry) ( (SimpleNode)node.jjtGetChild(0)).getAttribute(ID);
        String fieldName = id.getName();
        

        CodeGenerator.objectFile.println("    putstatic " + programName + "/"
                + fieldName+ " " + typeCode);
        CodeGenerator.objectFile.flush();
        
        

        return data;
    }

    public Object visit(ASTadd node, Object data)
    {
        SimpleNode addend0Node = (SimpleNode) node.jjtGetChild(0);
        SimpleNode addend1Node = (SimpleNode) node.jjtGetChild(1);

        TypeSpec type0 = addend0Node.getTypeSpec();
        TypeSpec type1 = addend1Node.getTypeSpec();

        // Get the addition type.
        TypeSpec type = node.getTypeSpec();

        String typePrefix = (type == Predefined.integerType) ? "i" : "f";

        // Emit code for the first expression
        // with type conversion if necessary.
        addend0Node.jjtAccept(this, data);
        if ((type == Predefined.realType) && (type0 == Predefined.integerType))
        {
            CodeGenerator.objectFile.println("    i2f");
            CodeGenerator.objectFile.flush();
        }

        // Emit code for the second expression
        // with type conversion if necessary.
        addend1Node.jjtAccept(this, data);
        if ((type == Predefined.realType) && (type1 == Predefined.integerType))
        {
            CodeGenerator.objectFile.println("    i2f");
            CodeGenerator.objectFile.flush();
        }

        // Emit the appropriate add instruction.
        CodeGenerator.objectFile.println("    " + typePrefix + "add");
        CodeGenerator.objectFile.flush();
        
        String typeCode = type == Predefined.integerType ? "I" : "F";
        String programName = (String) data;

        SymTabEntry id = (SymTabEntry) ( (SimpleNode)node.jjtGetChild(0)).getAttribute(ID);
        String fieldName = id.getName();
        

        CodeGenerator.objectFile.println("    putstatic " + programName + "/"
                + node.getAttribute(VALUE) + " " + typeCode);
        CodeGenerator.objectFile.flush();

        return data;
    }

    public Object visit(ASTsubtract node, Object data)
    {
      
        SimpleNode addend0Node = (SimpleNode) node.jjtGetChild(0);
        SimpleNode addend1Node = (SimpleNode) node.jjtGetChild(1);

        TypeSpec type0 = addend0Node.getTypeSpec();
        TypeSpec type1 = addend1Node.getTypeSpec();

        // Get the addition type.
        TypeSpec type = node.getTypeSpec();
        
        String typePrefix = (type == Predefined.integerType) ? "i" : "f";

        // Emit code for the first expression
        // with type conversion if necessary.
        addend0Node.jjtAccept(this, data);
        if ((type == Predefined.realType) && (type0 == Predefined.integerType))
        {
            CodeGenerator.objectFile.println("    i2f");
            CodeGenerator.objectFile.flush();
        }

        // Emit code for the second expression
        // with type conversion if necessary.
        addend1Node.jjtAccept(this, data);
        if ((type == Predefined.realType) && (type1 == Predefined.integerType))
        {
            CodeGenerator.objectFile.println("    i2f");
            CodeGenerator.objectFile.flush();
        }

        // Emit the appropriate add instruction.
        CodeGenerator.objectFile.println("    " + typePrefix + "sub");
        CodeGenerator.objectFile.flush();


        return data;
    }

    public Object visit(ASTmultiply node, Object data)
    {
        
        SimpleNode addend0Node = (SimpleNode) node.jjtGetChild(0);
        SimpleNode addend1Node = (SimpleNode) node.jjtGetChild(1);

        TypeSpec type0 = addend0Node.getTypeSpec();
        TypeSpec type1 = addend1Node.getTypeSpec();

        // Get the addition type.
        TypeSpec type = node.getTypeSpec();
       
        String typePrefix = (type == Predefined.integerType) ? "i" : "f";

        // Emit code for the first expression
        // with type conversion if necessary.
        addend0Node.jjtAccept(this, data);
        if ((type == Predefined.realType) && (type0 == Predefined.integerType))
        {
            CodeGenerator.objectFile.println("    i2f");
            CodeGenerator.objectFile.flush();
        }

        // Emit code for the second expression
        // with type conversion if necessary.
        addend1Node.jjtAccept(this, data);
        if ((type == Predefined.realType) && (type1 == Predefined.integerType))
        {
            CodeGenerator.objectFile.println("    i2f");
            CodeGenerator.objectFile.flush();
        }

        // Emit the appropriate add instruction.
        CodeGenerator.objectFile.println("    " + typePrefix + "mul");
        CodeGenerator.objectFile.flush();
        

        return data;
    }

    public Object visit(ASTdivide node, Object data)
    {
        
        SimpleNode addend0Node = (SimpleNode) node.jjtGetChild(0);
        SimpleNode addend1Node = (SimpleNode) node.jjtGetChild(1);

        TypeSpec type0 = addend0Node.getTypeSpec();
        TypeSpec type1 = addend1Node.getTypeSpec();

        // Get the addition type.
        TypeSpec type = node.getTypeSpec();
        
        String typePrefix = (type == Predefined.integerType) ? "i" : "f";

        // Emit code for the first expression
        // with type conversion if necessary.
        addend0Node.jjtAccept(this, data);
        if ((type == Predefined.realType) && (type0 == Predefined.integerType))
        {
            CodeGenerator.objectFile.println("    i2f");
            CodeGenerator.objectFile.flush();
        }

        // Emit code for the second expression
        // with type conversion if necessary.
        addend1Node.jjtAccept(this, data);
        if ((type == Predefined.realType) && (type1 == Predefined.integerType))
        {
            CodeGenerator.objectFile.println("    i2f");
            CodeGenerator.objectFile.flush();
        }

        // Emit the appropriate add instruction.
        CodeGenerator.objectFile.println("    " + typePrefix + "div");
        CodeGenerator.objectFile.flush();

        return data;
    }
   
    
}

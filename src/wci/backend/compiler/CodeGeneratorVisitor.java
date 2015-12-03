package wci.backend.compiler;

import wci.frontend.*;
import wci.intermediate.*;
import wci.intermediate.symtabimpl.Predefined;

import static wci.intermediate.icodeimpl.ICodeKeyImpl.*;

public class CodeGeneratorVisitor
        extends ExprParserVisitorAdapter
        implements ExprParserTreeConstants
{

    public Object visit(ASTProcedure node, Object data)
    {

        // Generating method call
        CodeGenerator.objectFile.print(".method public " + node.getAttribute(
                VALUE) + "()V");
        CodeGenerator.objectFile.println();
        // create stuff inside
        SimpleNode commandsNode = (SimpleNode) node.jjtGetChild(0);
        commandsNode.jjtAccept(this, data);

        //create end
        CodeGenerator.objectFile.println();
        CodeGenerator.objectFile.println("return\n" + ".limit locals 32\n"
                + ".limit stack 32\n" + ".end method" + "\n");
        return data;
    }

    public Object visit(ASTPrintStatement node, Object data)
    {
        Node commandsNode[] = new Node[node.jjtGetNumChildren()];
        String input[][] = new String[node.jjtGetNumChildren()][2];
        for (int i = 0; i < node.jjtGetNumChildren(); i++)
        {
            commandsNode[i] = node.jjtGetChild(i);
            input[i] = (String[]) (commandsNode[i].jjtAccept(this, data));
        }

        CodeGenerator.objectFile.println("\n"
                + "    getstatic     java/lang/System/out Ljava/io/PrintStream; \n"
                + "    new       java/lang/StringBuilder \n" + "    dup \n" + ""
                + input[0][1] + "\n" + "    "
                + "invokenonvirtual java/lang/StringBuilder/<init>(Ljava/lang/String;)V");
        for (int i = 0; i < node.jjtGetNumChildren() - 1; i++)
        {
            CodeGenerator.objectFile.println(input[i + 1][0] + "\n"
                    + "    invokevirtual java/lang/StringBuilder/append("
                    + input[i + 1][1] + ")Ljava/lang/StringBuilder;");
        }
        CodeGenerator.objectFile.println(
                "    invokevirtual java/lang/StringBuilder/toString()Ljava/lang/String;\n"
                + "    invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V\n");

        return data;
    }

    public Object visit(ASTProcedureCall node, Object data)
    {
        CodeGenerator.objectFile.println("    new Test\n" + "    dup\n"
                + "    invokespecial Test/<init>()V\n"
                + "    invokevirtual Test/" + node.getAttribute(VALUE) + "()V");
        return data;
    }

    public Object visit(ASTDeclaration node, Object data)
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
        if (((targetType == Predefined.doubleType) || (targetType
                == Predefined.floatType)) && (expressionType
                == Predefined.integerType))
        {
            CodeGenerator.objectFile.println("    i2f");
            CodeGenerator.objectFile.flush();
        }

        SymTabEntry id = (SymTabEntry) variableNode.getAttribute(ID);
        String fieldName = id.getName();
        TypeSpec type = id.getTypeSpec();
        String typeCode = "";
        if (type == Predefined.integerType)
        {
            typeCode = "I";
        } else if (type == Predefined.realType || type == Predefined.floatType
                || type == Predefined.doubleType)
        {
            typeCode = "F";
        } else if (type == Predefined.stringType)
        {
            typeCode = "Ljava/lang/String;";
        } else if (type == Predefined.booleanType)
        {
            typeCode = "Z";
        }
        // Emit the appropriate store instruction.
        CodeGenerator.objectFile.println("    putstatic " + programName + "/"
                + fieldName + " " + typeCode);
        CodeGenerator.objectFile.flush();

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
        if (((targetType == Predefined.doubleType) || (targetType
                == Predefined.floatType)) && (expressionType
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
        String result[] = new String[2];
        String typeCode = "";
        if (type == Predefined.integerType)
        {
            typeCode = "I";
        } else if (type == Predefined.realType || type == Predefined.floatType
                || type == Predefined.doubleType)
        {
            typeCode = "F";
        } else if (type == Predefined.stringType)
        {
            typeCode = "Ljava/lang/String;";
        } else if (type == Predefined.booleanType)
        {
            typeCode = "Z";
        }
        // Emit the appropriate load instruction.
        CodeGenerator.objectFile.println("    getstatic " + programName + "/"
                + fieldName + " " + typeCode);
        CodeGenerator.objectFile.flush();

        result[0] = "    getstatic " + programName + "/"
                + fieldName + " " + typeCode;
        result[1] = typeCode;
        return result;
    }

    public Object visit(ASTBooleanConst node, Object data)
    {
        boolean bool = (boolean) node.getAttribute(VALUE);
        int value = 0;// false by default
        if (bool == true)
        {
            value = 1;
        }
        // Emit a load constant instruction.
        CodeGenerator.objectFile.println("    ldc " + value);
        CodeGenerator.objectFile.flush();
        String result[] = new String[2];
        result[0] = "    ldc " + value;
        result[1] = "    ldc " + value;
        return result;

    }

    public Object visit(ASTIntegerConst node, Object data)
    {
        int value = (Integer) node.getAttribute(VALUE);

        // Emit a load constant instruction.
        CodeGenerator.objectFile.println("    ldc " + value);
        CodeGenerator.objectFile.flush();
        String result[] = new String[2];
        result[0] = "    ldc \"" + value + "\"";
        result[1] = "    ldc \"" + value + "\"";
        return result;
    }

    public Object visit(ASTFloatConst node, Object data)
    {
        float value = (Float) node.getAttribute(VALUE);

        // Emit a load constant instruction.
        CodeGenerator.objectFile.println("    ldc " + value);
        CodeGenerator.objectFile.flush();
        String result[] = new String[2];
        result[0] = "    ldc \"" + value + "\"";
        result[1] = "    ldc \"" + value + "\"";
        return result;
    }

    public Object visit(ASTDoubleConst node, Object data)
    {
        double value = (Double) node.getAttribute(VALUE);

        // Emit a load constant instruction.
        CodeGenerator.objectFile.println("    ldc " + value);
        CodeGenerator.objectFile.flush();
        String result[] = new String[2];
        result[0] = "    ldc \"" + value + "\"";
        result[1] = "    ldc \"" + value + "\"";
        return result;
    }

    public Object visit(ASTStringConst node, Object data)
    {
        String value = (String) node.getAttribute(VALUE);

        // Emit a load constant instruction.
        CodeGenerator.objectFile.println("    ldc \"" + value + "\"");
        CodeGenerator.objectFile.flush();
        String result[] = new String[2];
        result[0] = "    ldc \"" + value + "\"";
        result[1] = "    ldc \"" + value + "\"";
        return result;
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
        if (((type == Predefined.doubleType) || (type == Predefined.floatType))
                && (type0 == Predefined.integerType))
        {
            CodeGenerator.objectFile.println("    i2f");
            CodeGenerator.objectFile.flush();
        }

        // Emit code for the second expression
        // with type conversion if necessary.
        addend1Node.jjtAccept(this, data);
        if (((type == Predefined.doubleType) || (type == Predefined.floatType))
                && (type1 == Predefined.integerType))
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

        SymTabEntry id = (SymTabEntry) ((SimpleNode) node.jjtGetChild(0)).
                getAttribute(ID);
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
        if (((type == Predefined.doubleType) || (type == Predefined.floatType))
                && (type0 == Predefined.integerType))
        {
            CodeGenerator.objectFile.println("    i2f");
            CodeGenerator.objectFile.flush();
        }

        // Emit code for the second expression
        // with type conversion if necessary.
        addend1Node.jjtAccept(this, data);
        if (((type == Predefined.doubleType) || (type == Predefined.floatType))
                && (type1 == Predefined.integerType))
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

        SymTabEntry id = (SymTabEntry) ((SimpleNode) node.jjtGetChild(0)).
                getAttribute(ID);
        String fieldName = id.getName();

        CodeGenerator.objectFile.println("    putstatic " + programName + "/"
                + fieldName + " " + typeCode);
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
        System.out.println("StaREquals:" + (type == Predefined.integerType));
        // Emit code for the first expression
        // with type conversion if necessary.
        addend0Node.jjtAccept(this, data);
        if (((type == Predefined.doubleType) || (type == Predefined.floatType))
                && (type0 == Predefined.integerType))
        {
            CodeGenerator.objectFile.println("    i2f");
            CodeGenerator.objectFile.flush();
        }

        // Emit code for the second expression
        // with type conversion if necessary.
        addend1Node.jjtAccept(this, data);
        if (((type == Predefined.doubleType) || (type == Predefined.floatType))
                && (type1 == Predefined.integerType))
        {
            CodeGenerator.objectFile.println("    i2f");
            CodeGenerator.objectFile.flush();
        }

        // Emit the appropriate add instruction.
        CodeGenerator.objectFile.println("    " + typePrefix + "mul");
        CodeGenerator.objectFile.flush();

        String typeCode = type == Predefined.integerType ? "I" : "F";
        String programName = (String) data;

        SymTabEntry id = (SymTabEntry) ((SimpleNode) node.jjtGetChild(0)).
                getAttribute(ID);
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
        if (((type == Predefined.doubleType) || (type == Predefined.floatType))
                && (type0 == Predefined.integerType))
        {
            CodeGenerator.objectFile.println("    i2f");
            CodeGenerator.objectFile.flush();
        }

        // Emit code for the second expression
        // with type conversion if necessary.
        addend1Node.jjtAccept(this, data);
        if (((type == Predefined.doubleType) || (type == Predefined.floatType))
                && (type1 == Predefined.integerType))
        {
            CodeGenerator.objectFile.println("    i2f");
            CodeGenerator.objectFile.flush();
        }

        // Emit the appropriate add instruction.
        CodeGenerator.objectFile.println("    " + typePrefix + "div");
        CodeGenerator.objectFile.flush();

        String typeCode = type == Predefined.integerType ? "I" : "F";
        String programName = (String) data;

        SymTabEntry id = (SymTabEntry) ((SimpleNode) node.jjtGetChild(0)).
                getAttribute(ID);
        String fieldName = id.getName();

        CodeGenerator.objectFile.println("    putstatic " + programName + "/"
                + fieldName + " " + typeCode);
        CodeGenerator.objectFile.flush();

        return data;
    }

    public Object visit(ASTadd node, Object data)
    {

        SimpleNode addend0Node = (SimpleNode) node.jjtGetChild(0);
        SimpleNode addend1Node = (SimpleNode) node.jjtGetChild(1);

        TypeSpec type0 = addend0Node.getTypeSpec();
        TypeSpec type1 = addend1Node.getTypeSpec();
        System.out.println(type0 + " " + type1);
        // Get the addition type.
        TypeSpec type = Predefined.integerType;
        if (type0 == Predefined.doubleType || type1 == Predefined.doubleType)
        {
            type = Predefined.doubleType;
        } else if (type0 == Predefined.floatType || type1
                == Predefined.floatType)
        {
            type = Predefined.floatType;
        }

        String typePrefix = (type == Predefined.integerType) ? "i" : "f";
        System.out.println(typePrefix);
        // Emit code for the first expression
        // with type conversion if necessary.
        addend0Node.jjtAccept(this, data);
        if (((type == Predefined.doubleType) || (type == Predefined.floatType))
                && (type0 == Predefined.integerType))
        {
            CodeGenerator.objectFile.println("    i2f");
            CodeGenerator.objectFile.flush();
        }

        // Emit code for the second expression
        // with type conversion if necessary.
        addend1Node.jjtAccept(this, data);
        if (((type == Predefined.doubleType) || (type == Predefined.floatType))
                && (type1 == Predefined.integerType))
        {
            CodeGenerator.objectFile.println("    i2f");
            CodeGenerator.objectFile.flush();
        }

        // Emit the appropriate add instruction.
        CodeGenerator.objectFile.println("    " + typePrefix + "add");
        CodeGenerator.objectFile.flush();
        /*
         String typeCode = type == Predefined.integerType ? "I" : "F";
         String programName = (String) data;

         SymTabEntry id = (SymTabEntry) ( (SimpleNode)node.jjtGetChild(0)).getAttribute(ID);
         String fieldName = id.getName();
        
         //System.out.println("Node " + node.getAttribute(VALUE));
         //CodeGenerator.objectFile.println("    putstatic " + programName + "/"+ node.getAttribute(VALUE) + " " + typeCode);
        
         CodeGenerator.objectFile.flush();*/

        return data;

    }

    public Object visit(ASTsubtract node, Object data)
    {

        SimpleNode addend0Node = (SimpleNode) node.jjtGetChild(0);
        SimpleNode addend1Node = (SimpleNode) node.jjtGetChild(1);

        TypeSpec type0 = addend0Node.getTypeSpec();
        TypeSpec type1 = addend1Node.getTypeSpec();
        System.out.println(type0 + " " + type1);
        // Get the addition type.
        TypeSpec type = Predefined.integerType;
        if (type0 == Predefined.doubleType || type1 == Predefined.doubleType)
        {
            type = Predefined.doubleType;
        } else if (type0 == Predefined.floatType || type1
                == Predefined.floatType)
        {
            type = Predefined.floatType;
        }

        String typePrefix = (type == Predefined.integerType) ? "i" : "f";
        System.out.println(typePrefix);
        // Emit code for the first expression
        // with type conversion if necessary.
        addend0Node.jjtAccept(this, data);
        if (((type == Predefined.doubleType) || (type == Predefined.floatType))
                && (type0 == Predefined.integerType))
        {
            CodeGenerator.objectFile.println("    i2f");
            CodeGenerator.objectFile.flush();
        }

        // Emit code for the second expression
        // with type conversion if necessary.
        addend1Node.jjtAccept(this, data);
        if (((type == Predefined.doubleType) || (type == Predefined.floatType))
                && (type1 == Predefined.integerType))
        {
            CodeGenerator.objectFile.println("    i2f");
            CodeGenerator.objectFile.flush();
        }

        // Emit the appropriate add instruction.
        CodeGenerator.objectFile.println("    " + typePrefix + "sub");
        CodeGenerator.objectFile.flush();
        /*
         String typeCode = type == Predefined.integerType ? "I" : "F";
         String programName = (String) data;

         SymTabEntry id = (SymTabEntry) ( (SimpleNode)node.jjtGetChild(0)).getAttribute(ID);
         String fieldName = id.getName();
        
         //System.out.println("Node " + node.getAttribute(VALUE));
         //CodeGenerator.objectFile.println("    putstatic " + programName + "/"+ node.getAttribute(VALUE) + " " + typeCode);
        
         CodeGenerator.objectFile.flush();*/

        return data;
    }

    public Object visit(ASTmultiply node, Object data)
    {

        SimpleNode addend0Node = (SimpleNode) node.jjtGetChild(0);
        SimpleNode addend1Node = (SimpleNode) node.jjtGetChild(1);

        TypeSpec type0 = addend0Node.getTypeSpec();
        TypeSpec type1 = addend1Node.getTypeSpec();
        System.out.println(type0 + " " + type1);
        // Get the addition type.
        TypeSpec type = Predefined.integerType;
        if (type0 == Predefined.doubleType || type1 == Predefined.doubleType)
        {
            type = Predefined.doubleType;
        } else if (type0 == Predefined.floatType || type1
                == Predefined.floatType)
        {
            type = Predefined.floatType;
        }

        String typePrefix = (type == Predefined.integerType) ? "i" : "f";
        System.out.println(typePrefix);
        // Emit code for the first expression
        // with type conversion if necessary.
        addend0Node.jjtAccept(this, data);
        if (((type == Predefined.doubleType) || (type == Predefined.floatType))
                && (type0 == Predefined.integerType))
        {
            CodeGenerator.objectFile.println("    i2f");
            CodeGenerator.objectFile.flush();
        }

        // Emit code for the second expression
        // with type conversion if necessary.
        addend1Node.jjtAccept(this, data);
        if (((type == Predefined.doubleType) || (type == Predefined.floatType))
                && (type1 == Predefined.integerType))
        {
            CodeGenerator.objectFile.println("    i2f");
            CodeGenerator.objectFile.flush();
        }

        // Emit the appropriate add instruction.
        CodeGenerator.objectFile.println("    " + typePrefix + "mul");
        CodeGenerator.objectFile.flush();
        /*
         String typeCode = type == Predefined.integerType ? "I" : "F";
         String programName = (String) data;

         SymTabEntry id = (SymTabEntry) ( (SimpleNode)node.jjtGetChild(0)).getAttribute(ID);
         String fieldName = id.getName();
        
         //System.out.println("Node " + node.getAttribute(VALUE));
         //CodeGenerator.objectFile.println("    putstatic " + programName + "/"+ node.getAttribute(VALUE) + " " + typeCode);
        
         CodeGenerator.objectFile.flush();*/

        return data;
    }

    public Object visit(ASTdivide node, Object data)
    {
        SimpleNode addend0Node = (SimpleNode) node.jjtGetChild(0);
        SimpleNode addend1Node = (SimpleNode) node.jjtGetChild(1);

        TypeSpec type0 = addend0Node.getTypeSpec();
        TypeSpec type1 = addend1Node.getTypeSpec();
        System.out.println(type0 + " " + type1);
        // Get the addition type.
        TypeSpec type = Predefined.integerType;
        if (type0 == Predefined.doubleType || type1 == Predefined.doubleType)
        {
            type = Predefined.doubleType;
        } else if (type0 == Predefined.floatType || type1
                == Predefined.floatType)
        {
            type = Predefined.floatType;
        }

        String typePrefix = (type == Predefined.integerType) ? "i" : "f";
        System.out.println(typePrefix);
        // Emit code for the first expression
        // with type conversion if necessary.
        addend0Node.jjtAccept(this, data);
        if (((type == Predefined.doubleType) || (type == Predefined.floatType))
                && (type0 == Predefined.integerType))
        {
            CodeGenerator.objectFile.println("    i2f");
            CodeGenerator.objectFile.flush();
        }

        // Emit code for the second expression
        // with type conversion if necessary.
        addend1Node.jjtAccept(this, data);
        if (((type == Predefined.doubleType) || (type == Predefined.floatType))
                && (type1 == Predefined.integerType))
        {
            CodeGenerator.objectFile.println("    i2f");
            CodeGenerator.objectFile.flush();
        }
        // Emit the appropriate add instruction.
        CodeGenerator.objectFile.println("    " + typePrefix + "div");
        CodeGenerator.objectFile.flush();
        /*
         String typeCode = type == Predefined.integerType ? "I" : "F";
         String programName = (String) data;

         SymTabEntry id = (SymTabEntry) ( (SimpleNode)node.jjtGetChild(0)).getAttribute(ID);
         String fieldName = id.getName();
        
         //System.out.println("Node " + node.getAttribute(VALUE));
         //CodeGenerator.objectFile.println("    putstatic " + programName + "/"+ node.getAttribute(VALUE) + " " + typeCode);
        
         CodeGenerator.objectFile.flush();*/

        return data;
    }

    public Object visit(ASTGreaterThan node, Object data)
    {

        SimpleNode addend0Node = (SimpleNode) node.jjtGetChild(0);
        SimpleNode addend1Node = (SimpleNode) node.jjtGetChild(1);

        TypeSpec type0 = addend0Node.getTypeSpec();
        TypeSpec type1 = addend1Node.getTypeSpec();

        // Get the boolean type.
        TypeSpec type = node.getTypeSpec();

        //String typePrefix = (type == Predefined.booleanType) ? "i" : "f";
        // Emit code for the first expression
        // with type conversion if necessary.
        addend0Node.jjtAccept(this, data);
        /*
         if ((type == Predefined.realType) && (type0 == Predefined.integerType))
         {
         CodeGenerator.objectFile.println("    i2f");
         CodeGenerator.objectFile.flush();
         }
         */
        // Emit code for the second expression
        // with type conversion if necessary.
        addend1Node.jjtAccept(this, data);
        /*
         if ((type == Predefined.realType) && (type1 == Predefined.integerType))
         {
         CodeGenerator.objectFile.println("    i2f");
         CodeGenerator.objectFile.flush();
         }
         */
        // Emit the appropriate add instruction.
        CodeGenerator.objectFile.println("    " + "if_icmpgt L00"
                + labelGenerator);
        labelGenerator++;
        CodeGenerator.objectFile.println("    " + "iconst_0"); //push false i hope
        CodeGenerator.objectFile.println("    " + "goto L00" + labelGenerator);
        labelGenerator--;
        CodeGenerator.objectFile.println("L00" + labelGenerator + ":");
        CodeGenerator.objectFile.println("    " + "iconst_1");
        labelGenerator++;
        CodeGenerator.objectFile.println("L00" + labelGenerator + ":");
        CodeGenerator.objectFile.flush();
        labelGenerator++;
        return data;
    }

    public Object visit(ASTLessThan node, Object data)
    {

        SimpleNode addend0Node = (SimpleNode) node.jjtGetChild(0);
        SimpleNode addend1Node = (SimpleNode) node.jjtGetChild(1);

        TypeSpec type0 = addend0Node.getTypeSpec();
        TypeSpec type1 = addend1Node.getTypeSpec();

        // Get the boolean type.
        TypeSpec type = node.getTypeSpec();

        //String typePrefix = (type == Predefined.booleanType) ? "i" : "f";
        // Emit code for the first expression
        // with type conversion if necessary.
        addend0Node.jjtAccept(this, data);
        /*
         if ((type == Predefined.realType) && (type0 == Predefined.integerType))
         {
         CodeGenerator.objectFile.println("    i2f");
         CodeGenerator.objectFile.flush();
         }
         */
        // Emit code for the second expression
        // with type conversion if necessary.
        addend1Node.jjtAccept(this, data);
        /*
         if ((type == Predefined.realType) && (type1 == Predefined.integerType))
         {
         CodeGenerator.objectFile.println("    i2f");
         CodeGenerator.objectFile.flush();
         }
         */
        // Emit the appropriate add instruction.
        CodeGenerator.objectFile.println("    " + "if_icmplt L00"
                + labelGenerator);
        labelGenerator++;
        CodeGenerator.objectFile.println("    " + "iconst_0"); //push false i hope
        CodeGenerator.objectFile.println("    " + "goto L00" + labelGenerator);
        labelGenerator--;
        CodeGenerator.objectFile.println("L00" + labelGenerator + ":");
        CodeGenerator.objectFile.println("    " + "iconst_1");
        labelGenerator++;
        CodeGenerator.objectFile.println("L00" + labelGenerator + ":");
        CodeGenerator.objectFile.flush();
        labelGenerator++;
        return data;
    }

    public Object visit(ASTEquals node, Object data)
    {

        SimpleNode addend0Node = (SimpleNode) node.jjtGetChild(0);
        SimpleNode addend1Node = (SimpleNode) node.jjtGetChild(1);

        TypeSpec type0 = addend0Node.getTypeSpec();
        TypeSpec type1 = addend1Node.getTypeSpec();

        // Get the boolean type.
        TypeSpec type = node.getTypeSpec();

        //String typePrefix = (type == Predefined.booleanType) ? "i" : "f";
        // Emit code for the first expression
        // with type conversion if necessary.
        addend0Node.jjtAccept(this, data);
        /*
         if ((type == Predefined.realType) && (type0 == Predefined.integerType))
         {
         CodeGenerator.objectFile.println("    i2f");
         CodeGenerator.objectFile.flush();
         }
         */
        // Emit code for the second expression
        // with type conversion if necessary.
        addend1Node.jjtAccept(this, data);
        /*
         if ((type == Predefined.realType) && (type1 == Predefined.integerType))
         {
         CodeGenerator.objectFile.println("    i2f");
         CodeGenerator.objectFile.flush();
         }
         */
        // Emit the appropriate add instruction.
        CodeGenerator.objectFile.println("    " + "if_icmpeq L00"
                + labelGenerator);
        labelGenerator++;
        CodeGenerator.objectFile.println("    " + "iconst_0"); //push false i hope
        CodeGenerator.objectFile.println("    " + "goto L00" + labelGenerator);
        labelGenerator--;
        CodeGenerator.objectFile.println("L00" + labelGenerator + ":");
        CodeGenerator.objectFile.println("    " + "iconst_1");
        labelGenerator++;
        CodeGenerator.objectFile.println("L00" + labelGenerator + ":");
        CodeGenerator.objectFile.flush();
        labelGenerator++;
        return data;
    }

    public Object visit(ASTGreaterEquals node, Object data)
    {

        SimpleNode addend0Node = (SimpleNode) node.jjtGetChild(0);
        SimpleNode addend1Node = (SimpleNode) node.jjtGetChild(1);

        TypeSpec type0 = addend0Node.getTypeSpec();
        TypeSpec type1 = addend1Node.getTypeSpec();

        // Get the boolean type.
        TypeSpec type = node.getTypeSpec();

        //String typePrefix = (type == Predefined.booleanType) ? "i" : "f";
        // Emit code for the first expression
        // with type conversion if necessary.
        addend0Node.jjtAccept(this, data);
        /*
         if ((type == Predefined.realType) && (type0 == Predefined.integerType))
         {
         CodeGenerator.objectFile.println("    i2f");
         CodeGenerator.objectFile.flush();
         }
         */
        // Emit code for the second expression
        // with type conversion if necessary.
        addend1Node.jjtAccept(this, data);
        /*
         if ((type == Predefined.realType) && (type1 == Predefined.integerType))
         {
         CodeGenerator.objectFile.println("    i2f");
         CodeGenerator.objectFile.flush();
         }
         */
        // Emit the appropriate add instruction.
        CodeGenerator.objectFile.println("    " + "if_icmpge L00"
                + labelGenerator);
        labelGenerator++;
        CodeGenerator.objectFile.println("    " + "iconst_0"); //push false i hope
        CodeGenerator.objectFile.println("    " + "goto L00" + labelGenerator);
        labelGenerator--;
        CodeGenerator.objectFile.println("L00" + labelGenerator + ":");
        CodeGenerator.objectFile.println("    " + "iconst_1");
        labelGenerator++;
        CodeGenerator.objectFile.println("L00" + labelGenerator + ":");
        CodeGenerator.objectFile.flush();
        labelGenerator++;
        return data;
    }

    public Object visit(ASTLessEquals node, Object data)
    {

        SimpleNode addend0Node = (SimpleNode) node.jjtGetChild(0);
        SimpleNode addend1Node = (SimpleNode) node.jjtGetChild(1);

        TypeSpec type0 = addend0Node.getTypeSpec();
        TypeSpec type1 = addend1Node.getTypeSpec();

        // Get the boolean type.
        TypeSpec type = node.getTypeSpec();

        //String typePrefix = (type == Predefined.booleanType) ? "i" : "f";
        // Emit code for the first expression
        // with type conversion if necessary.
        addend0Node.jjtAccept(this, data);
        /*
         if ((type == Predefined.realType) && (type0 == Predefined.integerType))
         {
         CodeGenerator.objectFile.println("    i2f");
         CodeGenerator.objectFile.flush();
         }
         */
        // Emit code for the second expression
        // with type conversion if necessary.
        addend1Node.jjtAccept(this, data);
        /*
         if ((type == Predefined.realType) && (type1 == Predefined.integerType))
         {
         CodeGenerator.objectFile.println("    i2f");
         CodeGenerator.objectFile.flush();
         }
         */
        // Emit the appropriate add instruction.
        CodeGenerator.objectFile.println("    " + "if_icmple L00"
                + labelGenerator);
        labelGenerator++;
        CodeGenerator.objectFile.println("    " + "iconst_0"); //push false i hope
        CodeGenerator.objectFile.println("    " + "goto L00" + labelGenerator);
        labelGenerator--;
        CodeGenerator.objectFile.println("L00" + labelGenerator + ":");
        CodeGenerator.objectFile.println("    " + "iconst_1");
        labelGenerator++;
        CodeGenerator.objectFile.println("L00" + labelGenerator + ":");
        CodeGenerator.objectFile.flush();
        labelGenerator++;
        return data;
    }

    public Object visit(ASTNotEquals node, Object data)
    {

        SimpleNode addend0Node = (SimpleNode) node.jjtGetChild(0);
        SimpleNode addend1Node = (SimpleNode) node.jjtGetChild(1);

        TypeSpec type0 = addend0Node.getTypeSpec();
        TypeSpec type1 = addend1Node.getTypeSpec();

        // Get the boolean type.
        TypeSpec type = node.getTypeSpec();

        //String typePrefix = (type == Predefined.booleanType) ? "i" : "f";
        // Emit code for the first expression
        // with type conversion if necessary.
        addend0Node.jjtAccept(this, data);
        /*
         if ((type == Predefined.realType) && (type0 == Predefined.integerType))
         {
         CodeGenerator.objectFile.println("    i2f");
         CodeGenerator.objectFile.flush();
         }
         */
        // Emit code for the second expression
        // with type conversion if necessary.
        addend1Node.jjtAccept(this, data);
        /*
         if ((type == Predefined.realType) && (type1 == Predefined.integerType))
         {
         CodeGenerator.objectFile.println("    i2f");
         CodeGenerator.objectFile.flush();
         }
         */
        // Emit the appropriate add instruction.
        CodeGenerator.objectFile.println("    " + "if_icmpne L00"
                + labelGenerator);
        labelGenerator++;
        CodeGenerator.objectFile.println("    " + "iconst_0"); //push false i hope
        CodeGenerator.objectFile.println("    " + "goto L00" + labelGenerator);
        labelGenerator--;
        CodeGenerator.objectFile.println("L00" + labelGenerator + ":");
        CodeGenerator.objectFile.println("    " + "iconst_1");
        labelGenerator++;
        CodeGenerator.objectFile.println("L00" + labelGenerator + ":");
        CodeGenerator.objectFile.flush();
        labelGenerator++;
        return data;
    }

    public Object visit(ASTIfPart node, Object data)
    {
        //Testing for only a single boolean operator for now
        //Extract operator: !=, <, <=, >, >=, ==
        SimpleNode addend0Node = (SimpleNode) node.jjtGetChild(0);
        SimpleNode addend1Node = (SimpleNode) addend0Node.jjtGetChild(0);
        SimpleNode addend2Node = (SimpleNode) addend0Node.jjtGetChild(0);

        SimpleNode insideStatement = (SimpleNode) node.jjtGetChild(1).
                jjtGetChild(0);
//        SimpleNode elseif = (SimpleNode) node.jjtGetChild(2).jjtGetChild(0); //may have to loop through elseif and elsez later on
        //SimpleNode elsez = (SimpleNode) node.jjtGetChild(3).jjtGetChild(0); //only supports single statement for now

        //System.out.println( node.jjtGetChild(1).jjtGetChild(0).toString() );
        String operation = "";

        //TypeSpec type0 = addend1Node.getTypeSpec();
        //TypeSpec type1 = addend2Node.getTypeSpec();
        // Get the boolean type.
        TypeSpec type = node.getTypeSpec();

        //String typePrefix = (type == Predefined.booleanType) ? "i" : "f";
        // Emit code for the first expression
        // with type conversion if necessary.
        addend0Node.jjtAccept(this, data);
        labelGenerator++;
        CodeGenerator.objectFile.println("    " + "ifeq L00" + labelGenerator);//if false
        insideStatement.jjtAccept(this, data); //CS153 NOTE: Loop through these if there are multiple statements
        //labelGenerator++;
        CodeGenerator.objectFile.println("L00" + labelGenerator + ":");
        labelGenerator++;
        //elseif.jjtAccept(this, data);
        //node.jjtGetChild(3).jjtGetChild(0).jjtAccept(this, data);
        //System.out.println(elseif.toString());
        //elsez.jjtAccept(this, data);
        /*
         if ((type == Predefined.realType) && (type0 == Predefined.integerType))
         {
         CodeGenerator.objectFile.println("    i2f");
         CodeGenerator.objectFile.flush();
         }
         */
        // Emit code for the second expression
        // with type conversion if necessary.
        //addend1Node.jjtAccept(this, data);
        /*
         if ((type == Predefined.realType) && (type1 == Predefined.integerType))
         {
         CodeGenerator.objectFile.println("    i2f");
         CodeGenerator.objectFile.flush();
         }
         */
        // Emit the appropriate add instruction.

        labelGenerator++;
        CodeGenerator.objectFile.flush();
        return data;
    }

    public Object visit(ASTFor node, Object data)
    {

        SimpleNode addend0Node = (SimpleNode) node.jjtGetChild(0);
        SimpleNode addend1Node = (SimpleNode) node.jjtGetChild(1);

        TypeSpec type0 = addend0Node.getTypeSpec();
        TypeSpec type1 = addend1Node.getTypeSpec();

        // Get the boolean type.
        TypeSpec type = node.getTypeSpec();

        //String typePrefix = (type == Predefined.booleanType) ? "i" : "f";
        // Emit code for the first expression
        // with type conversion if necessary.
        addend0Node.jjtAccept(this, data);
        /*
         if ((type == Predefined.realType) && (type0 == Predefined.integerType))
         {
         CodeGenerator.objectFile.println("    i2f");
         CodeGenerator.objectFile.flush();
         }
         */
        // Emit code for the second expression
        // with type conversion if necessary.
        addend1Node.jjtAccept(this, data);
        /*
         if ((type == Predefined.realType) && (type1 == Predefined.integerType))
         {
         CodeGenerator.objectFile.println("    i2f");
         CodeGenerator.objectFile.flush();
         }
         */
        // Emit the appropriate add instruction.
        CodeGenerator.objectFile.println("    " + "if_icmpne L00"
                + labelGenerator);
        labelGenerator++;
        CodeGenerator.objectFile.println("    " + "iconst_0"); //push false i hope
        CodeGenerator.objectFile.println("    " + "goto L00" + labelGenerator);
        labelGenerator--;
        CodeGenerator.objectFile.println("L00" + labelGenerator + ":");
        CodeGenerator.objectFile.println("    " + "iconst_1");
        labelGenerator++;
        CodeGenerator.objectFile.println("L00" + labelGenerator + ":");
        CodeGenerator.objectFile.flush();
        labelGenerator++;
        return data;
    }
    private int labelGenerator = 3;

    public Object visit(ASTIncrementStatement node, Object data)
    {
        SimpleNode addend0Node = (SimpleNode) node.jjtGetChild(0);
        System.out.println();

        TypeSpec type0 = addend0Node.getTypeSpec();

        // Get the addition type.
        TypeSpec type = node.getTypeSpec();
        String typePrefix = (type == Predefined.integerType) ? "i" : "f";

        // Emit code for the first expression
        // with type conversion if necessary.
        addend0Node.jjtAccept(this, data);
        if (((type == Predefined.doubleType) || (type == Predefined.floatType))
                && (type0 == Predefined.integerType))
        {
            CodeGenerator.objectFile.println("    i2f");
            CodeGenerator.objectFile.flush();
        }

        CodeGenerator.objectFile.println("ldc 1");

        // Emit the appropriate add instruction.
        CodeGenerator.objectFile.println("    " + typePrefix + "add");
        CodeGenerator.objectFile.flush();
        //assign the value to itself.

        String typeCode = type == Predefined.integerType ? "I" : "F";
        String programName = (String) data;

        SymTabEntry id = (SymTabEntry) ((SimpleNode) node.jjtGetChild(0)).
                getAttribute(ID);
        String fieldName = id.getName();

        CodeGenerator.objectFile.println("    putstatic " + programName + "/"
                + fieldName + " " + typeCode);
        CodeGenerator.objectFile.flush();

        return data;
    }

    public Object visit(ASTDecrementStatement node, Object data)
    {
        SimpleNode addend0Node = (SimpleNode) node.jjtGetChild(0);
        System.out.println();

        TypeSpec type0 = addend0Node.getTypeSpec();

        // Get the addition type.
        TypeSpec type = node.getTypeSpec();
        String typePrefix = (type == Predefined.integerType) ? "i" : "f";

        // Emit code for the first expression
        // with type conversion if necessary.
        addend0Node.jjtAccept(this, data);
        if (((type == Predefined.doubleType) || (type == Predefined.floatType))
                && (type0 == Predefined.integerType))
        {
            CodeGenerator.objectFile.println("    i2f");
            CodeGenerator.objectFile.flush();
        }

        CodeGenerator.objectFile.println("ldc 1");

        // Emit the appropriate add instruction.
        CodeGenerator.objectFile.println("    " + typePrefix + "sub");
        CodeGenerator.objectFile.flush();
        //assign the value to itself.

        String typeCode = type == Predefined.integerType ? "I" : "F";
        String programName = (String) data;

        SymTabEntry id = (SymTabEntry) ((SimpleNode) node.jjtGetChild(0)).
                getAttribute(ID);
        String fieldName = id.getName();

        CodeGenerator.objectFile.println("    putstatic " + programName + "/"
                + fieldName + " " + typeCode);
        CodeGenerator.objectFile.flush();

        return data;
    }

    public Object visit(ASTList node, Object data)
    {
        String programName = (String) data;

        SymTabEntry id = (SymTabEntry) ((SimpleNode) node).
                getAttribute(ID);
        String fieldName = id.getName();

        
        CodeGenerator.objectFile.println("new  List");
        CodeGenerator.objectFile.flush();
        CodeGenerator.objectFile.println("dup");
        CodeGenerator.objectFile.flush();
        CodeGenerator.objectFile.println("astore_" + id.getIndex());
        CodeGenerator.objectFile.flush();
        CodeGenerator.objectFile.println("aload_" + + id.getIndex());
        CodeGenerator.objectFile.flush();
        CodeGenerator.objectFile.println(
                "invokespecial List.<init>()V");
        CodeGenerator.objectFile.flush();
        CodeGenerator.objectFile.println(
                "invokevirtual List/StringList()Ljava/util/ArrayList;");
        CodeGenerator.objectFile.flush();
        CodeGenerator.objectFile.println("putstatic " + programName + "/" + fieldName + " Ljava/util/ArrayList;");
        CodeGenerator.objectFile.flush();

        return data;
    }

    public Object visit(ASTListAdd node, Object data)
    {
     SimpleNode addend0Node = (SimpleNode) node.jjtGetChild(1);
     addend0Node = (SimpleNode)addend0Node.jjtGetChild(0);
     
        TypeSpec type0 = addend0Node.getTypeSpec();
        System.out.println(type0);
        
        SymTabEntry id = (SymTabEntry) ((SimpleNode) node.jjtGetChild(0)).getAttribute(ID);
        String fieldName = id.getName();
        
        CodeGenerator.objectFile.println("aload_" + id.getIndex());
        CodeGenerator.objectFile.flush();
        CodeGenerator.objectFile.println("ldc \"" + addend0Node.getAttribute(VALUE) + "\"");
        CodeGenerator.objectFile.flush();
        CodeGenerator.objectFile.println("invokevirtual List/add(Ljava/lang/String;)V");
        CodeGenerator.objectFile.flush();
        //load the variable.
        // Emit code for the first expression
        // with type conversion if necessary.
        /*
        addend0Node.jjtAccept(this, data);
        CodeGenerator.objectFile.println("");
        CodeGenerator.objectFile.flush();
        CodeGenerator.objectFile.println("invokenonvirtual IWrap/<init>(I)V");
        CodeGenerator.objectFile.flush();
        CodeGenerator.objectFile.println("dup");
        CodeGenerator.objectFile.flush();
        CodeGenerator.objectFile.println("astore_1");
        CodeGenerator.objectFile.flush();
        CodeGenerator.objectFile.println("invokevirtual java/util/ArrayList.add(Ljava/lang/Object;)Z");
        CodeGenerator.objectFile.flush();
        CodeGenerator.objectFile.println("pop");
        CodeGenerator.objectFile.flush();
        */
        

        return data;
    }
    
    /*
    aload_0
ldc 0
invokevirtual List/getVal(I)Ljava/lang/Object;
putstatic Test/b Ljava/lang/Object;
    */
    
    public Object visit(ASTListGetVal node, Object data)
    {
        SimpleNode addend0Node = (SimpleNode) node.jjtGetChild(1);
        addend0Node = (SimpleNode)addend0Node.jjtGetChild(0);
        System.out.println(addend0Node);

        TypeSpec type0 = addend0Node.getTypeSpec();
        System.out.println(type0);
        
        SymTabEntry id = (SymTabEntry) ((SimpleNode) node.jjtGetChild(0)).getAttribute(ID);
        String fieldName = id.getName();
        
        CodeGenerator.objectFile.println("aload_" + id.getIndex());
        CodeGenerator.objectFile.flush();
        CodeGenerator.objectFile.println("ldc " + addend0Node.getAttribute(VALUE));
        CodeGenerator.objectFile.flush();
        CodeGenerator.objectFile.println("invokevirtual List/getVal(I)Ljava/lang/String;");
        CodeGenerator.objectFile.flush();
        return data;
    }
    
    public Object visit(ASTListDelete node, Object data)
    {
        SimpleNode addend0Node = (SimpleNode) node.jjtGetChild(1);
        addend0Node = (SimpleNode)addend0Node.jjtGetChild(0);
        System.out.println(addend0Node);

        TypeSpec type0 = addend0Node.getTypeSpec();
        System.out.println(type0);
        SymTabEntry id = (SymTabEntry) ((SimpleNode) node.jjtGetChild(0)).getAttribute(ID);
        String fieldName = id.getName();
        
        CodeGenerator.objectFile.println("aload_" + id.getIndex());
        CodeGenerator.objectFile.flush();
        CodeGenerator.objectFile.println("ldc \"" + addend0Node.getAttribute(VALUE) + "\"");
        CodeGenerator.objectFile.flush();
        CodeGenerator.objectFile.println("invokevirtual List/remove(Ljava/lang/String;)V");
        CodeGenerator.objectFile.flush();
        return data;
    }
    
        public Object visit(ASTListGetIndex node, Object data)
    {
        SimpleNode addend0Node = (SimpleNode) node.jjtGetChild(1);
        addend0Node = (SimpleNode)addend0Node.jjtGetChild(0);
        System.out.println(addend0Node);

        TypeSpec type0 = addend0Node.getTypeSpec();
        System.out.println(type0);
        
        SymTabEntry id = (SymTabEntry) ((SimpleNode) node.jjtGetChild(0)).getAttribute(ID);
        String fieldName = id.getName();
        
        CodeGenerator.objectFile.println("aload_" + id.getIndex());
        CodeGenerator.objectFile.flush();
        CodeGenerator.objectFile.println("ldc \"" + addend0Node.getAttribute(VALUE) + "\"");
        CodeGenerator.objectFile.flush();
        CodeGenerator.objectFile.println("invokevirtual List/getIndex(Ljava/lang/String;)I");
        CodeGenerator.objectFile.flush();
        return data;
    }
        
    public Object visit(ASTListSetVal node, Object data)
    {
        SimpleNode pos = (SimpleNode) node.jjtGetChild(1);
        pos = (SimpleNode)pos.jjtGetChild(0);
        System.out.println(pos);
        
        SimpleNode val = (SimpleNode) node.jjtGetChild(2);
        val = (SimpleNode)val.jjtGetChild(0);
        System.out.println(val);
        
         SymTabEntry id = (SymTabEntry) ((SimpleNode) node.jjtGetChild(0)).getAttribute(ID);
        String fieldName = id.getName();
        
       

        
        CodeGenerator.objectFile.println("aload_" + id.getIndex());
        CodeGenerator.objectFile.flush();
        CodeGenerator.objectFile.println("ldc " + pos.getAttribute(VALUE) + "");
        CodeGenerator.objectFile.flush();
        CodeGenerator.objectFile.println("ldc \"" + val.getAttribute(VALUE) + "\"");
        CodeGenerator.objectFile.flush();
        CodeGenerator.objectFile.println("invokevirtual List/setVal(ILjava/lang/String;)V");
        CodeGenerator.objectFile.flush();
        return data;
    }
    
        public Object visit(ASTListGetSize node, Object data)
    {
        SimpleNode addend0Node = (SimpleNode) node.jjtGetChild(0);
        //System.out.println(addend0Node);

        SymTabEntry id = (SymTabEntry) addend0Node.getAttribute(ID);
        String fieldName = id.getName();
        
        TypeSpec type0 = addend0Node.getTypeSpec();
        
        
        CodeGenerator.objectFile.println("aload_"+ id.getIndex());
        CodeGenerator.objectFile.flush();
        CodeGenerator.objectFile.println("invokevirtual List/getSize()I");
        CodeGenerator.objectFile.flush();
        return data;
    }
        
}

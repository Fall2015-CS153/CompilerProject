package wci.frontend;

import wci.frontend.SimpleNode;
import wci.frontend.ASTAssignment;
import wci.frontend.ASTCases;
import wci.frontend.ASTComparisonOperator;
import wci.frontend.ASTDataTypes;
import wci.frontend.ASTDeclaration;
import wci.frontend.ASTDecrementStatement;
import wci.frontend.ASTDivideEqualsStatement;
import wci.frontend.ASTElseIfPart;
import wci.frontend.ASTElsePart;
import wci.frontend.ASTExpr;
import wci.frontend.ASTFactor;
import wci.frontend.ASTHashmap;
import wci.frontend.ASTIfPart;
import wci.frontend.ASTIncrementStatement;
import wci.frontend.ASTList;
import wci.frontend.ASTLiteral;
import wci.frontend.ASTMinusEqualsStatement;
import wci.frontend.ASTPlusEqualsStatement;
import wci.frontend.ASTPrimitiveType;
import wci.frontend.ASTProgram;
import wci.frontend.ASTSet;
import wci.frontend.ASTSimpleExpr;
import wci.frontend.ASTStarEqualsStatement;
import wci.frontend.ASTStatement;
import wci.frontend.ASTSwitchPart;
import wci.frontend.ASTTerm;
import wci.frontend.ExprParserVisitor;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Aishwarya
 */
public class ExprParserVisitorAdapter implements ExprParserVisitor
{

    @Override
    public Object visit(SimpleNode node, Object data)
    {
        return node.childrenAccept(this, data);
    }

    @Override
    public Object visit(ASTProgram node, Object data)
    {
        return node.childrenAccept(this, data);

    }

    //@Override
    public Object visit(ASTPrimitiveType node, Object data)
    {
        return node.childrenAccept(this, data);
    }

    @Override
    public Object visit(ASTExpr node, Object data)
    {
        return node.childrenAccept(this, data);
    }

    @Override
    public Object visit(ASTSimpleExpr node, Object data)
    {
        return node.childrenAccept(this, data);
    }

    @Override
    public Object visit(ASTTerm node, Object data)
    {
        return node.childrenAccept(this, data);
    }

    @Override
    public Object visit(ASTFactor node, Object data)
    {
        return node.childrenAccept(this, data);
    }

    @Override
    public Object visit(ASTStatement node, Object data)
    {
        return node.childrenAccept(this, data);
    }

    @Override
    public Object visit(ASTIfPart node, Object data)
    {
        return node.childrenAccept(this, data);
    }

    @Override
    public Object visit(ASTElseIfPart node, Object data)
    {
        return node.childrenAccept(this, data);
    }

    @Override
    public Object visit(ASTElsePart node, Object data)
    {
        return node.childrenAccept(this, data);
    }

    /*@Override
    public Object visit(ASTLiteral node, Object data)
    {
        return node.childrenAccept(this, data);
    }*/

    @Override
    public Object visit(ASTSwitchPart node, Object data)
    {
        return node.childrenAccept(this, data);
    }

    @Override
    public Object visit(ASTComparisonOperator node, Object data)
    {
        return node.childrenAccept(this, data);
    }

    @Override
    public Object visit(ASTCases node, Object data)
    {
        return node.childrenAccept(this, data);
    }

    @Override
    public Object visit(ASTAssignment node, Object data)
    {
        return node.childrenAccept(this, data);
    }

    @Override
    public Object visit(ASTDeclaration node, Object data)
    {
        return node.childrenAccept(this, data);
    }

    @Override
    public Object visit(ASTIncrementStatement node, Object data)
    {
        return node.childrenAccept(this, data);
    }

    @Override
    public Object visit(ASTDecrementStatement node, Object data)
    {
        return node.childrenAccept(this, data);
    }

    @Override
    public Object visit(ASTPlusEqualsStatement node, Object data)
    {
        return node.childrenAccept(this, data);
    }

    @Override
    public Object visit(ASTMinusEqualsStatement node, Object data)
    {
        return node.childrenAccept(this, data);
    }

    @Override
    public Object visit(ASTStarEqualsStatement node, Object data)
    {
        return node.childrenAccept(this, data);
    }

    @Override
    public Object visit(ASTDivideEqualsStatement node, Object data)
    {
        return node.childrenAccept(this, data);
    }

    @Override
    public Object visit(ASTDataTypes node, Object data)
    {
        return node.childrenAccept(this, data);
    }

    @Override
    public Object visit(ASTHashmap node, Object data)
    {
        return node.childrenAccept(this, data);
    }

    @Override
    public Object visit(ASTSet node, Object data)
    {
        return node.childrenAccept(this, data);
    }

    @Override
    public Object visit(ASTList node, Object data)
    {
        return node.childrenAccept(this, data);
    }

    @Override
    public Object visit(ASTIntegerConst node, Object data)
    {
        return node.childrenAccept(this, data);
    }

    @Override
    public Object visit(ASTRealConst node, Object data)
    {
        return node.childrenAccept(this, data);
    }

    @Override
    public Object visit(ASTStringConst node, Object data)
    {
        return node.childrenAccept(this, data);
    }

    @Override
    public Object visit(ASTvariable node, Object data)
    {
      return node.childrenAccept(this, data);    
    }

    @Override
    public Object visit(ASThandleError node, Object data) {
        return node.childrenAccept(this, data); }

    @Override
    public Object visit(ASTError node, Object data) {
        return node.childrenAccept(this, data); }

    @Override
    public Object visit(ASTCommands node, Object data) {
        return node.childrenAccept(this, data);  
    }

    @Override
    public Object visit(ASTFor node, Object data) {
        return node.childrenAccept(this, data);  
    }

    @Override
    public Object visit(ASTWhile node, Object data) {
        return node.childrenAccept(this, data);  
    }

    @Override
    public Object visit(ASTvariableDecl node, Object data)
    {
        return node.childrenAccept(this, data); }

    @Override
    public Object visit(ASTadd node, Object data)
    {
        return node.childrenAccept(this, data);}

    @Override
    public Object visit(ASTsubtract node, Object data)
    {
         return node.childrenAccept(this, data);}

    @Override
    public Object visit(ASTor node, Object data)
    {
        return node.childrenAccept(this, data);}

    @Override
    public Object visit(ASTmultiply node, Object data)
    {
        return node.childrenAccept(this, data);}

    @Override
    public Object visit(ASTdivide node, Object data)
    {
        return node.childrenAccept(this, data); }

    @Override
    public Object visit(ASTand node, Object data)
    {
         return node.childrenAccept(this, data);}

    @Override
    public Object visit(ASTProcedure node, Object data) {
         return node.childrenAccept(this, data);
    }
   
   

}

package compiler;


import gen.JythonListener;
import gen.JythonParser;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.List;

public class ProgramPrinter implements JythonListener {

    @Override
    public void enterProgram(JythonParser.ProgramContext ctx) {
        System.out.println("Program start {");
        System.out.println(ctx.getText());
        System.out.println('}');
    }

    @Override
    public void exitProgram(JythonParser.ProgramContext ctx) {

    }

    @Override
    public void enterImportclass(JythonParser.ImportclassContext ctx) {
        System.out.println("import class: " + ctx.CLASSNAME());
    }

    @Override
    public void exitImportclass(JythonParser.ImportclassContext ctx) {

    }

    @Override
    public void enterClassDef(JythonParser.ClassDefContext ctx) {
        System.out.println("class: " + ctx.CLASSNAME() + "/ class parents: " + ctx.getParent() + ", {");
        //enterClass_body(ctx.class_body());
        System.out.println('}');
    }

    @Override
    public void exitClassDef(JythonParser.ClassDefContext ctx) {

    }

    @Override
    public void enterClass_body(JythonParser.Class_bodyContext ctx) {

    }

    @Override
    public void exitClass_body(JythonParser.Class_bodyContext ctx) {

    }

    @Override
    public void enterVarDec(JythonParser.VarDecContext ctx) {
        System.out.println("field: " + ctx.getText() + "/ type= " + ctx.TYPE());
    }

    @Override
    public void exitVarDec(JythonParser.VarDecContext ctx) {

    }

    @Override
    public void enterArrayDec(JythonParser.ArrayDecContext ctx) {
        System.out.println("field: " + ctx.getText() + "/ type= " + ctx.TYPE());
    }

    @Override
    public void exitArrayDec(JythonParser.ArrayDecContext ctx) {

    }

    @Override
    public void enterMethodDec(JythonParser.MethodDecContext ctx) {
        System.out.println("class method: " + ctx.CLASSNAME() + " return type:" + ctx.TYPE() + '{');
        //method body
        System.out.println('}');
    }

    @Override
    public void exitMethodDec(JythonParser.MethodDecContext ctx) {

    }

    @Override
    public void enterConstructor(JythonParser.ConstructorContext ctx) {
        System.out.println("class constructor: " + ctx.CLASSNAME().getText() + '{');
        System.out.print("    parameters list: ");
        if (ctx.parameter() != null) {
            //parameter
        }
    }

    @Override
    public void exitConstructor(JythonParser.ConstructorContext ctx) {

    }

    @Override
    public void enterParameter(JythonParser.ParameterContext ctx) {
        System.out.print("parameter list: [");
        for (int i = 0; i < ctx.varDec().size(); i++) {
            System.out.println(ctx.varDec(i).TYPE().getText() + ' ' + ctx.varDec(i).ID().getText() + ", ");
        }
        System.out.println(']');
    }

    @Override
    public void exitParameter(JythonParser.ParameterContext ctx) {

    }

    @Override
    public void enterStatement(JythonParser.StatementContext ctx) {

    }

    @Override
    public void exitStatement(JythonParser.StatementContext ctx) {

    }

    @Override
    public void enterReturn_statment(JythonParser.Return_statmentContext ctx) {
        System.out.println("return type: " + ctx.getText());
    }

    @Override
    public void exitReturn_statment(JythonParser.Return_statmentContext ctx) {

    }

    @Override
    public void enterCondition_list(JythonParser.Condition_listContext ctx) {
        System.out.print('(');
        if (ctx.condition().size() == 1) {
            System.out.println(ctx.condition().get(0));
        } else {
            for (JythonParser.ConditionContext cnd :
                    ctx.condition()) {
                if (ctx.getText().contains("or")) {
                    System.out.print("or");
                } else if (ctx.getText().contains("and")) {
                    System.out.print("and");
                }
                System.out.print(cnd.getText());
            }
        }
        System.out.print(')');
    }

    @Override
    public void exitCondition_list(JythonParser.Condition_listContext ctx) {

    }

    @Override
    public void enterCondition(JythonParser.ConditionContext ctx) {

    }

    @Override
    public void exitCondition(JythonParser.ConditionContext ctx) {

    }

    @Override
    public void enterIf_statment(JythonParser.If_statmentContext ctx) {
        System.out.println("if " + ctx.condition_list() + " {");
        //body
        System.out.println('}');
    }

    @Override
    public void exitIf_statment(JythonParser.If_statmentContext ctx) {

    }

    @Override
    public void enterWhile_statment(JythonParser.While_statmentContext ctx) {
        System.out.println("while " + ctx.condition_list() + " {");
        //body
        System.out.println('}');
    }

    @Override
    public void exitWhile_statment(JythonParser.While_statmentContext ctx) {

    }

    @Override
    public void enterIf_else_statment(JythonParser.If_else_statmentContext ctx) {
        System.out.println("if " + ctx.condition_list() + " {");
        //body
        System.out.println("} else {");
        //body
        System.out.println('}');
    }

    @Override
    public void exitIf_else_statment(JythonParser.If_else_statmentContext ctx) {

    }

    @Override
    public void enterPrint_statment(JythonParser.Print_statmentContext ctx) {

    }

    @Override
    public void exitPrint_statment(JythonParser.Print_statmentContext ctx) {

    }

    @Override
    public void enterFor_statment(JythonParser.For_statmentContext ctx) {

    }

    @Override
    public void exitFor_statment(JythonParser.For_statmentContext ctx) {

    }

    @Override
    public void enterMethod_call(JythonParser.Method_callContext ctx) {

    }

    @Override
    public void exitMethod_call(JythonParser.Method_callContext ctx) {

    }

    @Override
    public void enterAssignment(JythonParser.AssignmentContext ctx) {

    }

    @Override
    public void exitAssignment(JythonParser.AssignmentContext ctx) {

    }

    @Override
    public void enterExp(JythonParser.ExpContext ctx) {

    }

    @Override
    public void exitExp(JythonParser.ExpContext ctx) {

    }

    @Override
    public void enterPrefixexp(JythonParser.PrefixexpContext ctx) {
        System.out.println(ctx.prefixexp().getText());
    }

    @Override
    public void exitPrefixexp(JythonParser.PrefixexpContext ctx) {

    }

    @Override
    public void enterArgs(JythonParser.ArgsContext ctx) {
        System.out.println('(' + ctx.explist().getText() + ')');
    }

    @Override
    public void exitArgs(JythonParser.ArgsContext ctx) {

    }

    @Override
    public void enterExplist(JythonParser.ExplistContext ctx) {
        System.out.println('(' + ctx.getText() + ')');
    }

    @Override
    public void exitExplist(JythonParser.ExplistContext ctx) {

    }

    @Override
    public void enterArithmetic_operator(JythonParser.Arithmetic_operatorContext ctx) {
        System.out.print(ctx.getText());
    }

    @Override
    public void exitArithmetic_operator(JythonParser.Arithmetic_operatorContext ctx) {

    }

    @Override
    public void enterRelational_operators(JythonParser.Relational_operatorsContext ctx) {
        System.out.print(ctx.getText());
    }

    @Override
    public void exitRelational_operators(JythonParser.Relational_operatorsContext ctx) {

    }

    @Override
    public void enterAssignment_operators(JythonParser.Assignment_operatorsContext ctx) {
        System.out.print(ctx.getText());
    }

    @Override
    public void exitAssignment_operators(JythonParser.Assignment_operatorsContext ctx) {

    }

    @Override
    public void visitTerminal(TerminalNode terminalNode) {

    }

    @Override
    public void visitErrorNode(ErrorNode errorNode) {

    }

    @Override
    public void enterEveryRule(ParserRuleContext parserRuleContext) {

    }

    @Override
    public void exitEveryRule(ParserRuleContext parserRuleContext) {

    }
}

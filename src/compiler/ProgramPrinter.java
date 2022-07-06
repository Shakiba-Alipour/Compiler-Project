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
//        System.out.println(ctx.getText());
//        System.out.println('}');
    }

    @Override
    public void exitProgram(JythonParser.ProgramContext ctx) {
        System.out.println('}');
    }

    @Override
    public void enterImportclass(JythonParser.ImportclassContext ctx) {
        String indent_level = "";
        for (int i = 0; i < ctx.getParent().depth() * 4; i++) {
            indent_level += ' ';
        }
        System.out.println(indent_level + "import class: " + ctx.CLASSNAME());
    }

    @Override
    public void exitImportclass(JythonParser.ImportclassContext ctx) {

    }

    @Override
    public void enterClassDef(JythonParser.ClassDefContext ctx) {
        String indent_level = "";
        for (int i = 0; i < ctx.getParent().depth() * 4; i++) {
            indent_level += ' ';
        }
        System.out.print(indent_level + "class: " + ctx.CLASSNAME() + "/ class parents: ");
        if (!ctx.getParent().isEmpty()) {
            System.out.println(ctx.getParent() + ", {");
        } else {
            System.out.println("object, {");
        }
    }

    @Override
    public void exitClassDef(JythonParser.ClassDefContext ctx) {
        String indent_level = "";
        for (int i = 0; i < ctx.getParent().depth() * 4; i++) {
            indent_level += ' ';
        }
        System.out.println(indent_level + '}');
    }

    @Override
    public void enterClass_body(JythonParser.Class_bodyContext ctx) {

    }

    @Override
    public void exitClass_body(JythonParser.Class_bodyContext ctx) {

    }

    @Override
    public void enterVarDec(JythonParser.VarDecContext ctx) {
//        if (ctx.getParent()) {
//            if (ctx.CLASSNAME() != null) {
//                System.out.print(ctx.CLASSNAME());
//            } else if (ctx.TYPE() != null) {
//                System.out.print(ctx.TYPE());
//            }
//            System.out.println(" " + ctx.ID());
//        } else {
        String indent_level = "";
        for (int i = 0; i < ctx.getParent().depth() * 4; i++) {
            indent_level += ' ';
        }
        System.out.print(indent_level + "field: " + ctx.ID() + "/ type= ");
        if (ctx.CLASSNAME() != null) {
            System.out.print(ctx.CLASSNAME());
        } else if (ctx.TYPE() != null) {
            System.out.print(ctx.TYPE());
        }
        //}
    }

    @Override
    public void exitVarDec(JythonParser.VarDecContext ctx) {
        String indent_level = "";
        for (int i = 0; i < ctx.getParent().depth() * 4; i++) {
            indent_level += ' ';
        }
        System.out.println(indent_level);
    }

    @Override
    public void enterArrayDec(JythonParser.ArrayDecContext ctx) {
        String indent_level = "";
        for (int i = 0; i < ctx.getParent().depth() * 4; i++) {
            indent_level += ' ';
        }
        String type = null;
        if (ctx.CLASSNAME() != null) {
            type = ctx.CLASSNAME().getText();
        } else if (ctx.TYPE() != null) {
            type = ctx.TYPE().getText();
        }
        System.out.print(indent_level + "field: " + ctx.ID() + "/ type= " + type);
    }

    @Override
    public void exitArrayDec(JythonParser.ArrayDecContext ctx) {
        String indent_level = "";
        for (int i = 0; i < ctx.getParent().depth() * 4; i++) {
            indent_level += ' ';
        }
        System.out.println(indent_level);
    }

    @Override
    public void enterMethodDec(JythonParser.MethodDecContext ctx) {
        String indent_level = "";
        for (int i = 0; i < ctx.getParent().depth() * 4; i++) {
            indent_level += ' ';
        }
        String type = null;
        if (ctx.CLASSNAME() != null) {
            type = ctx.CLASSNAME().getText();
        } else if (ctx.TYPE() != null) {
            type = ctx.TYPE().getText();
        } else {
            type = "void";
        }
        System.out.println(indent_level + "class method: " + ctx.ID() + "/ return type: " + type + '{');
    }

    @Override
    public void exitMethodDec(JythonParser.MethodDecContext ctx) {
        String indent_level = "";
        for (int i = 0; i < ctx.getParent().depth() * 4; i++) {
            indent_level += ' ';
        }
        System.out.println(indent_level + '}');
    }

    @Override
    public void enterConstructor(JythonParser.ConstructorContext ctx) {
        String indent_level = "";
        for (int i = 0; i < ctx.getParent().depth() * 4; i++) {
            indent_level += ' ';
        }
        System.out.println(indent_level + "class constructor: " + ctx.CLASSNAME().getText() + '{');
    }

    @Override
    public void exitConstructor(JythonParser.ConstructorContext ctx) {
        String indent_level = "";
        for (int i = 0; i < ctx.getParent().depth() * 4; i++) {
            indent_level += ' ';
        }
        System.out.println(indent_level + "}");
    }

    @Override
    public void enterParameter(JythonParser.ParameterContext ctx) {
        String indent_level = "";
        for (int i = 0; i < ctx.getParent().depth() * 4; i++) {
            indent_level += ' ';
        }
        System.out.print(indent_level + "parameter list: [");
        String type = null;
        for (int i = 0; i < ctx.varDec().size(); i++) {
            if (ctx.varDec(i).CLASSNAME() != null) {
                type = ctx.varDec(i).CLASSNAME().getText();
            } else if (ctx.varDec(i).TYPE() != null) {
                type = ctx.varDec(i).TYPE().getText();
            }
            System.out.print(type + ' ' + ctx.varDec(i).ID().getText() + ", ");
        }
    }

    @Override
    public void exitParameter(JythonParser.ParameterContext ctx) {
        System.out.println(']');
    }

    @Override
    public void enterStatement(JythonParser.StatementContext ctx) {

    }

    @Override
    public void exitStatement(JythonParser.StatementContext ctx) {

    }

    @Override
    public void enterReturn_statment(JythonParser.Return_statmentContext ctx) {
        String indent_level = "";
        for (int i = 0; i < ctx.getParent().depth() * 4; i++) {
            indent_level += ' ';
        }
        System.out.print(indent_level + "return type: ");
        enterExp(ctx.exp());
    }

    @Override
    public void exitReturn_statment(JythonParser.Return_statmentContext ctx) {
        System.out.print('\n');
    }

    @Override
    public void enterCondition_list(JythonParser.Condition_listContext ctx) {
        System.out.print('(');
//        if (ctx.condition().size() == 1) {
//            enterCondition(ctx.condition(0));
//            System.out.print(')');
//        } else {
//            for (JythonParser.ConditionContext cnd :
//                    ctx.condition()) {
//                if (ctx.getText().contains("or")) {
//                    System.out.print("or");
//                } else if (ctx.getText().contains("and")) {
//                    System.out.print("and");
//                }
//                System.out.println(cnd);
//            }
//        }
        for (int i = 0; i < ctx.condition().size(); i++) {
            enterCondition(ctx.condition(i));
            if (ctx.getText().contains("or")) {
                System.out.print("or");
            } else if (ctx.getText().contains("and")) {
                System.out.print("and");
            }
        }
        System.out.print(')');
    }

    @Override
    public void exitCondition_list(JythonParser.Condition_listContext ctx) {

    }

    @Override
    public void enterCondition(JythonParser.ConditionContext ctx) {
        if (ctx.BOOL() != null) {
            System.out.println(ctx.BOOL().getText());
        } else if (ctx.prefixexp() != null) {
            enterPrefixexp(ctx.prefixexp());
        } else {
            enterExp(ctx.exp(0));
            enterRelational_operators(ctx.relational_operators());
            enterExp(ctx.exp(1));
        }
    }

    @Override
    public void exitCondition(JythonParser.ConditionContext ctx) {

    }

    @Override
    public void enterIf_statment(JythonParser.If_statmentContext ctx) {
        String indent_level = "";
        for (int i = 0; i < ctx.getParent().depth() * 4; i++) {
            indent_level += ' ';
        }
        System.out.print(indent_level + "if ");
        enterCondition_list(ctx.condition_list());
        System.out.println('{');
    }

    @Override
    public void exitIf_statment(JythonParser.If_statmentContext ctx) {
        String indent_level = "";
        for (int i = 0; i < ctx.getParent().depth() * 4; i++) {
            indent_level += ' ';
        }
        System.out.println(indent_level + '}');
    }

    @Override
    public void enterWhile_statment(JythonParser.While_statmentContext ctx) {
        String indent_level = "";
        for (int i = 0; i < ctx.getParent().depth() * 4; i++) {
            indent_level += ' ';
        }
        System.out.print(indent_level + "while ");
        enterCondition_list(ctx.condition_list());
        System.out.println('{');
    }

    @Override
    public void exitWhile_statment(JythonParser.While_statmentContext ctx) {
        String indent_level = "";
        for (int i = 0; i < ctx.getParent().depth() * 4; i++) {
            indent_level += ' ';
        }
        System.out.println(indent_level + '}');
    }

    @Override
    public void enterIf_else_statment(JythonParser.If_else_statmentContext ctx) {
        String indent_level = "";
        for (int i = 0; i < ctx.getParent().depth() * 4; i++) {
            indent_level += ' ';
        }
        System.out.println(indent_level + "if " + ctx.condition_list() + " {");
        //body
        System.out.println(indent_level + "} else {");
        //body
    }

    @Override
    public void exitIf_else_statment(JythonParser.If_else_statmentContext ctx) {
        String indent_level = "";
        for (int i = 0; i < ctx.getParent().depth() * 4; i++) {
            indent_level += ' ';
        }
        System.out.println(indent_level + '}');
    }

    @Override
    public void enterPrint_statment(JythonParser.Print_statmentContext ctx) {
        String indent_level = "";
        for (int i = 0; i < ctx.getParent().depth() * 4; i++) {
            indent_level += ' ';
        }
        System.out.println(indent_level + ctx.getText());
    }

    @Override
    public void exitPrint_statment(JythonParser.Print_statmentContext ctx) {

    }

    @Override
    public void enterFor_statment(JythonParser.For_statmentContext ctx) {
        String indent_level = "";
        for (int i = 0; i < ctx.getParent().depth() * 4; i++) {
            indent_level += ' ';
        }
        if (ctx.INTEGER() != null) {
            System.out.println(indent_level + "for " + ctx.ID(0) + " in " + ctx.ID(1) + '{');
            enterStatement(ctx.statement(0));
        } else {
            System.out.println(indent_level + "for " + ctx.ID() + " in range (" + ctx.INTEGER(0) +
                    ", " + ctx.INTEGER(1) + ", " + ctx.INTEGER(2) + '{');
            enterStatement(ctx.statement(0));
        }
    }

    @Override
    public void exitFor_statment(JythonParser.For_statmentContext ctx) {
        String indent_level = "";
        for (int i = 0; i < ctx.getParent().depth() * 4; i++) {
            indent_level += ' ';
        }
        System.out.println(indent_level + '}');
    }

    @Override
    public void enterMethod_call(JythonParser.Method_callContext ctx) {
        String indent_level = "";
        for (int i = 0; i < ctx.getParent().depth() * 4; i++) {
            indent_level += ' ';
        }
        System.out.print(indent_level + ctx.ID().getText());
        if (ctx.args() != null) {
            System.out.print('.');
            enterArgs(ctx.args());
        }
    }

    @Override
    public void exitMethod_call(JythonParser.Method_callContext ctx) {
        System.out.print('\n');
    }

    @Override
    public void enterAssignment(JythonParser.AssignmentContext ctx) {

    }

    @Override
    public void exitAssignment(JythonParser.AssignmentContext ctx) {

    }

    @Override
    public void enterExp(JythonParser.ExpContext ctx) {
        if (ctx.getText() == "none") {
            System.out.print("none");
        } else if (ctx.BOOL() != null) {
            System.out.print(ctx.BOOL().getText());
        } else if (ctx.INTEGER() != null) {
            System.out.print(ctx.INTEGER().getText());
        } else if (ctx.STRING() != null) {
            System.out.print(ctx.STRING().getText());
        } else if (ctx.FLOAT() != null) {
            System.out.print(ctx.FLOAT().getText());
        } else if (ctx.prefixexp() != null) {
            enterPrefixexp(ctx.prefixexp());
        } else if (ctx.arithmetic_operator() != null) {
            enterExp(ctx.exp(0));
            enterArithmetic_operator(ctx.arithmetic_operator());
            enterExp(ctx.exp(1));
        } else if (ctx.args() != null) {
            if (ctx.TYPE() != null) {
                System.out.print(ctx.TYPE().getText());
            } else if (ctx.CLASSNAME() != null) {
                System.out.print(ctx.CLASSNAME().getText());
            }
            enterArgs(ctx.args());
        } else if (!ctx.exp().isEmpty()) {
            System.out.print('(');
            enterExp(ctx.exp(0));
            System.out.print(')');
        } else if (ctx.ID() != null) {
            System.out.print(ctx.ID().getText());
            enterArgs(ctx.args());
        } else {
            System.out.print("void");
        }
    }

    @Override
    public void exitExp(JythonParser.ExpContext ctx) {

    }

    @Override
    public void enterPrefixexp(JythonParser.PrefixexpContext ctx) {

    }

    @Override
    public void exitPrefixexp(JythonParser.PrefixexpContext ctx) {

    }

    @Override
    public void enterArgs(JythonParser.ArgsContext ctx) {
        if (ctx.explist() != null) {
            System.out.print('(');
            enterExplist(ctx.explist());
        }
    }

    @Override
    public void exitArgs(JythonParser.ArgsContext ctx) {
        System.out.print(')');
    }

    @Override
    public void enterExplist(JythonParser.ExplistContext ctx) {
        System.out.print('(' + ctx.getText() + ')');
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

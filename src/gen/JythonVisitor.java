package gen;// Generated from D:/University/Compiler Designing/Project/Phase 1/Phase1/grammer\Jython.g4 by ANTLR 4.10.1
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link JythonParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface JythonVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link JythonParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(JythonParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link JythonParser#importclass}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImportclass(JythonParser.ImportclassContext ctx);
	/**
	 * Visit a parse tree produced by {@link JythonParser#classDef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassDef(JythonParser.ClassDefContext ctx);
	/**
	 * Visit a parse tree produced by {@link JythonParser#class_body}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClass_body(JythonParser.Class_bodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link JythonParser#varDec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarDec(JythonParser.VarDecContext ctx);
	/**
	 * Visit a parse tree produced by {@link JythonParser#arrayDec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayDec(JythonParser.ArrayDecContext ctx);
	/**
	 * Visit a parse tree produced by {@link JythonParser#methodDec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodDec(JythonParser.MethodDecContext ctx);
	/**
	 * Visit a parse tree produced by {@link JythonParser#constructor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstructor(JythonParser.ConstructorContext ctx);
	/**
	 * Visit a parse tree produced by {@link JythonParser#parameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameter(JythonParser.ParameterContext ctx);
	/**
	 * Visit a parse tree produced by {@link JythonParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(JythonParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link JythonParser#return_statment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturn_statment(JythonParser.Return_statmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link JythonParser#condition_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCondition_list(JythonParser.Condition_listContext ctx);
	/**
	 * Visit a parse tree produced by {@link JythonParser#condition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCondition(JythonParser.ConditionContext ctx);
	/**
	 * Visit a parse tree produced by {@link JythonParser#if_statment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIf_statment(JythonParser.If_statmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link JythonParser#while_statment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhile_statment(JythonParser.While_statmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link JythonParser#if_else_statment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIf_else_statment(JythonParser.If_else_statmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link JythonParser#print_statment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrint_statment(JythonParser.Print_statmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link JythonParser#for_statment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFor_statment(JythonParser.For_statmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link JythonParser#method_call}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethod_call(JythonParser.Method_callContext ctx);
	/**
	 * Visit a parse tree produced by {@link JythonParser#assignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignment(JythonParser.AssignmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link JythonParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExp(JythonParser.ExpContext ctx);
	/**
	 * Visit a parse tree produced by {@link JythonParser#prefixexp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrefixexp(JythonParser.PrefixexpContext ctx);
	/**
	 * Visit a parse tree produced by {@link JythonParser#args}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArgs(JythonParser.ArgsContext ctx);
	/**
	 * Visit a parse tree produced by {@link JythonParser#explist}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExplist(JythonParser.ExplistContext ctx);
	/**
	 * Visit a parse tree produced by {@link JythonParser#arithmetic_operator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArithmetic_operator(JythonParser.Arithmetic_operatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link JythonParser#relational_operators}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelational_operators(JythonParser.Relational_operatorsContext ctx);
	/**
	 * Visit a parse tree produced by {@link JythonParser#assignment_operators}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignment_operators(JythonParser.Assignment_operatorsContext ctx);
}
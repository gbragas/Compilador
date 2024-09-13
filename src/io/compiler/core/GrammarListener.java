// Generated from Grammar.g4 by ANTLR 4.13.2
package io.compiler.core;

    import java.util.ArrayList;
    import java.util.Stack;
    import java.util.HashMap;
    import io.compiler.types.*;
    import io.compiler.core.exceptions.*;
    import io.compiler.core.ast.*;
   	import io.compiler.runtime.*;
   	import io.compiler.expressionevaluator.*;
   	
    

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link GrammarParser}.
 */
public interface GrammarListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link GrammarParser#programa}.
	 * @param ctx the parse tree
	 */
	void enterPrograma(GrammarParser.ProgramaContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#programa}.
	 * @param ctx the parse tree
	 */
	void exitPrograma(GrammarParser.ProgramaContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#declararvar}.
	 * @param ctx the parse tree
	 */
	void enterDeclararvar(GrammarParser.DeclararvarContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#declararvar}.
	 * @param ctx the parse tree
	 */
	void exitDeclararvar(GrammarParser.DeclararvarContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#comando}.
	 * @param ctx the parse tree
	 */
	void enterComando(GrammarParser.ComandoContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#comando}.
	 * @param ctx the parse tree
	 */
	void exitComando(GrammarParser.ComandoContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#cmdDoWhile}.
	 * @param ctx the parse tree
	 */
	void enterCmdDoWhile(GrammarParser.CmdDoWhileContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#cmdDoWhile}.
	 * @param ctx the parse tree
	 */
	void exitCmdDoWhile(GrammarParser.CmdDoWhileContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#cmdWhile}.
	 * @param ctx the parse tree
	 */
	void enterCmdWhile(GrammarParser.CmdWhileContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#cmdWhile}.
	 * @param ctx the parse tree
	 */
	void exitCmdWhile(GrammarParser.CmdWhileContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#cmdIf}.
	 * @param ctx the parse tree
	 */
	void enterCmdIf(GrammarParser.CmdIfContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#cmdIf}.
	 * @param ctx the parse tree
	 */
	void exitCmdIf(GrammarParser.CmdIfContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#cmdAttrib}.
	 * @param ctx the parse tree
	 */
	void enterCmdAttrib(GrammarParser.CmdAttribContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#cmdAttrib}.
	 * @param ctx the parse tree
	 */
	void exitCmdAttrib(GrammarParser.CmdAttribContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#cmdRead}.
	 * @param ctx the parse tree
	 */
	void enterCmdRead(GrammarParser.CmdReadContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#cmdRead}.
	 * @param ctx the parse tree
	 */
	void exitCmdRead(GrammarParser.CmdReadContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#cmdWrite}.
	 * @param ctx the parse tree
	 */
	void enterCmdWrite(GrammarParser.CmdWriteContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#cmdWrite}.
	 * @param ctx the parse tree
	 */
	void exitCmdWrite(GrammarParser.CmdWriteContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(GrammarParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(GrammarParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#fator}.
	 * @param ctx the parse tree
	 */
	void enterFator(GrammarParser.FatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#fator}.
	 * @param ctx the parse tree
	 */
	void exitFator(GrammarParser.FatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#exprl}.
	 * @param ctx the parse tree
	 */
	void enterExprl(GrammarParser.ExprlContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#exprl}.
	 * @param ctx the parse tree
	 */
	void exitExprl(GrammarParser.ExprlContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#termo}.
	 * @param ctx the parse tree
	 */
	void enterTermo(GrammarParser.TermoContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#termo}.
	 * @param ctx the parse tree
	 */
	void exitTermo(GrammarParser.TermoContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#termol}.
	 * @param ctx the parse tree
	 */
	void enterTermol(GrammarParser.TermolContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#termol}.
	 * @param ctx the parse tree
	 */
	void exitTermol(GrammarParser.TermolContext ctx);
}
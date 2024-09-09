// Generated from Grammar.g4 by ANTLR 4.13.2
package io.compiler.core;

    import java.util.ArrayList;
    import java.util.HashMap;
    import io.compiler.types.*;
    import io.compiler.core.exceptions.*;

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
	 * Enter a parse tree produced by {@link GrammarParser#exprl}.
	 * @param ctx the parse tree
	 */
	void enterExprl(GrammarParser.ExprlContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#exprl}.
	 * @param ctx the parse tree
	 */
	void exitExprl(GrammarParser.ExprlContext ctx);
}
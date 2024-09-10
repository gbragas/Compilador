// Generated from Grammar.g4 by ANTLR 4.13.2
package io.compiler.core;

    import java.util.ArrayList;
    import java.util.Stack;
    import java.util.HashMap;
    import io.compiler.types.*;
    import io.compiler.core.exceptions.*;
    import io.compiler.core.ast.*;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class GrammarParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, OP=12, OP_AT=13, OP_REL=14, ID=15, NUM=16, WS=17, VG=18, 
		PV=19, DP=20, AP=21, FP=22, AC=23, FC=24, TEXTO=25;
	public static final int
		RULE_programa = 0, RULE_declararvar = 1, RULE_comando = 2, RULE_cmdIf = 3, 
		RULE_cmdAttrib = 4, RULE_cmdRead = 5, RULE_cmdWrite = 6, RULE_expr = 7, 
		RULE_termo = 8, RULE_exprl = 9;
	private static String[] makeRuleNames() {
		return new String[] {
			"programa", "declararvar", "comando", "cmdIf", "cmdAttrib", "cmdRead", 
			"cmdWrite", "expr", "termo", "exprl"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'programa'", "'inicio'", "'fim'", "'fimprog'", "'declare'", "'number'", 
			"'text'", "'if'", "'else'", "'read'", "'write'", null, "'='", null, null, 
			null, null, "','", "';'", "':'", "'('", "')'", "'{'", "'}'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			"OP", "OP_AT", "OP_REL", "ID", "NUM", "WS", "VG", "PV", "DP", "AP", "FP", 
			"AC", "FC", "TEXTO"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "Grammar.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }


	    private HashMap<String,Var> symbolTable = new HashMap<String,Var>();
	    private ArrayList<Var> currentDecl = new ArrayList<Var>();
	    private Types currentType;
	    private Types leftType, rightType;
	    private Program program = new Program();
	    private Stack<ArrayList<Command>> stack = new Stack<ArrayList<Command>>();
	    private String strExpr = "";
	    private IfCommand currentIfCommand;

	    public void updateType() {
	        for (Var v: currentDecl) {
	            v.setType(currentType);
	            symbolTable.put(v.getId(),v);
	        }
	    }

	    public void getVars() {
	        for (String id: symbolTable.keySet()) {
	            System.out.println(symbolTable.get(id));
	        }
	    }

	    public Program getProgram() {
	        return this.program;
	    }

	    public boolean isDeclared(String id) {
	        return symbolTable.get(id) != null;
	    }

	public GrammarParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgramaContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(GrammarParser.ID, 0); }
		public List<DeclararvarContext> declararvar() {
			return getRuleContexts(DeclararvarContext.class);
		}
		public DeclararvarContext declararvar(int i) {
			return getRuleContext(DeclararvarContext.class,i);
		}
		public List<ComandoContext> comando() {
			return getRuleContexts(ComandoContext.class);
		}
		public ComandoContext comando(int i) {
			return getRuleContext(ComandoContext.class,i);
		}
		public ProgramaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_programa; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterPrograma(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitPrograma(this);
		}
	}

	public final ProgramaContext programa() throws RecognitionException {
		ProgramaContext _localctx = new ProgramaContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_programa);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(20);
			match(T__0);
			setState(21);
			match(ID);
			 program.setName(_input.LT(-1).getText());
			                              stack.push(new ArrayList<Command>());
			                            
			setState(24); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(23);
				declararvar();
				}
				}
				setState(26); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__4 );
			setState(28);
			match(T__1);
			setState(30); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(29);
				comando();
				}
				}
				setState(32); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 36096L) != 0) );
			setState(34);
			match(T__2);
			setState(35);
			match(T__3);

			                    program.setSymbolTable(symbolTable);
			                    program.setCommandList(stack.pop());
			                
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DeclararvarContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(GrammarParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(GrammarParser.ID, i);
		}
		public TerminalNode DP() { return getToken(GrammarParser.DP, 0); }
		public TerminalNode PV() { return getToken(GrammarParser.PV, 0); }
		public List<TerminalNode> VG() { return getTokens(GrammarParser.VG); }
		public TerminalNode VG(int i) {
			return getToken(GrammarParser.VG, i);
		}
		public DeclararvarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declararvar; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterDeclararvar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitDeclararvar(this);
		}
	}

	public final DeclararvarContext declararvar() throws RecognitionException {
		DeclararvarContext _localctx = new DeclararvarContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_declararvar);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(38);
			match(T__4);
			 currentDecl.clear(); 
			setState(40);
			match(ID);
			 currentDecl.add(new Var(_input.LT(-1).getText())); 
			setState(47);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==VG) {
				{
				{
				setState(42);
				match(VG);
				setState(43);
				match(ID);
				 currentDecl.add(new Var(_input.LT(-1).getText())); 
				}
				}
				setState(49);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(50);
			match(DP);
			setState(55);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__5:
				{
				setState(51);
				match(T__5);
				 currentType = Types.NUMBER; 
				}
				break;
			case T__6:
				{
				setState(53);
				match(T__6);
				 currentType = Types.TEXT; 
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			 updateType(); 
			setState(58);
			match(PV);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ComandoContext extends ParserRuleContext {
		public CmdAttribContext cmdAttrib() {
			return getRuleContext(CmdAttribContext.class,0);
		}
		public CmdReadContext cmdRead() {
			return getRuleContext(CmdReadContext.class,0);
		}
		public CmdWriteContext cmdWrite() {
			return getRuleContext(CmdWriteContext.class,0);
		}
		public CmdIfContext cmdIf() {
			return getRuleContext(CmdIfContext.class,0);
		}
		public ComandoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comando; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterComando(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitComando(this);
		}
	}

	public final ComandoContext comando() throws RecognitionException {
		ComandoContext _localctx = new ComandoContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_comando);
		try {
			setState(64);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(60);
				cmdAttrib();
				}
				break;
			case T__9:
				enterOuterAlt(_localctx, 2);
				{
				setState(61);
				cmdRead();
				}
				break;
			case T__10:
				enterOuterAlt(_localctx, 3);
				{
				setState(62);
				cmdWrite();
				}
				break;
			case T__7:
				enterOuterAlt(_localctx, 4);
				{
				setState(63);
				cmdIf();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CmdIfContext extends ParserRuleContext {
		public TerminalNode AP() { return getToken(GrammarParser.AP, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode OP_REL() { return getToken(GrammarParser.OP_REL, 0); }
		public TerminalNode FP() { return getToken(GrammarParser.FP, 0); }
		public List<TerminalNode> AC() { return getTokens(GrammarParser.AC); }
		public TerminalNode AC(int i) {
			return getToken(GrammarParser.AC, i);
		}
		public List<TerminalNode> FC() { return getTokens(GrammarParser.FC); }
		public TerminalNode FC(int i) {
			return getToken(GrammarParser.FC, i);
		}
		public List<ComandoContext> comando() {
			return getRuleContexts(ComandoContext.class);
		}
		public ComandoContext comando(int i) {
			return getRuleContext(ComandoContext.class,i);
		}
		public CmdIfContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdIf; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterCmdIf(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitCmdIf(this);
		}
	}

	public final CmdIfContext cmdIf() throws RecognitionException {
		CmdIfContext _localctx = new CmdIfContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_cmdIf);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(66);
			match(T__7);

			                        stack.push(new ArrayList<Command>());
			                        strExpr = "";
			                        currentIfCommand = new IfCommand();
			                   
			setState(68);
			match(AP);
			setState(69);
			expr();
			setState(70);
			match(OP_REL);
			 strExpr += _input.LT(-1).getText(); 
			setState(72);
			expr();
			setState(73);
			match(FP);
			 currentIfCommand.setExpression(strExpr); 
			setState(75);
			match(AC);
			setState(77); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(76);
				comando();
				}
				}
				setState(79); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 36096L) != 0) );
			 currentIfCommand.setTrueList(stack.pop()); 
			setState(82);
			match(FC);
			setState(94);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__8) {
				{
				setState(83);
				match(T__8);
				 stack.push(new ArrayList<Command>()); 
				setState(85);
				match(AC);
				setState(87); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(86);
					comando();
					}
					}
					setState(89); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 36096L) != 0) );
				 currentIfCommand.setFalseList(stack.pop()); 
				setState(92);
				match(FC);
				}
			}

			 stack.peek().add(currentIfCommand); 
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CmdAttribContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(GrammarParser.ID, 0); }
		public TerminalNode OP_AT() { return getToken(GrammarParser.OP_AT, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode PV() { return getToken(GrammarParser.PV, 0); }
		public CmdAttribContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdAttrib; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterCmdAttrib(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitCmdAttrib(this);
		}
	}

	public final CmdAttribContext cmdAttrib() throws RecognitionException {
		CmdAttribContext _localctx = new CmdAttribContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_cmdAttrib);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(98);
			match(ID);
			 if (!isDeclared(_input.LT(-1).getText())) {
			                       throw new SemanticException("Undeclared Variable: " + _input.LT(-1).getText());
			                   }
			                   symbolTable.get(_input.LT(-1).getText()).setInitialized(true);
			                   leftType = symbolTable.get(_input.LT(-1).getText()).getType();
			                 
			setState(100);
			match(OP_AT);
			setState(101);
			expr();
			setState(102);
			match(PV);

			                System.out.println("Left Side Expression Type: " +leftType);
			                System.out.println("Right Side Expression Type: " +rightType);
			                if (leftType.getValue() < rightType.getValue()) {
			                       throw new SemanticException("Type Missmatching on Assignment");
			                }
			              
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CmdReadContext extends ParserRuleContext {
		public TerminalNode AP() { return getToken(GrammarParser.AP, 0); }
		public TerminalNode ID() { return getToken(GrammarParser.ID, 0); }
		public TerminalNode FP() { return getToken(GrammarParser.FP, 0); }
		public TerminalNode PV() { return getToken(GrammarParser.PV, 0); }
		public CmdReadContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdRead; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterCmdRead(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitCmdRead(this);
		}
	}

	public final CmdReadContext cmdRead() throws RecognitionException {
		CmdReadContext _localctx = new CmdReadContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_cmdRead);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(105);
			match(T__9);
			setState(106);
			match(AP);
			setState(107);
			match(ID);
			 if (!isDeclared(_input.LT(-1).getText())) {
			                         throw new SemanticException("Undeclared Variable: " + _input.LT(-1).getText());
			                     }
			                     symbolTable.get(_input.LT(-1).getText()).setInitialized(true);
			                     Command cmdRead = new ReadCommand(symbolTable.get(_input.LT(-1).getText()));
			                     stack.peek().add(cmdRead);
			                   
			setState(109);
			match(FP);
			setState(110);
			match(PV);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CmdWriteContext extends ParserRuleContext {
		public TerminalNode AP() { return getToken(GrammarParser.AP, 0); }
		public TerminalNode FP() { return getToken(GrammarParser.FP, 0); }
		public TerminalNode PV() { return getToken(GrammarParser.PV, 0); }
		public TermoContext termo() {
			return getRuleContext(TermoContext.class,0);
		}
		public CmdWriteContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdWrite; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterCmdWrite(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitCmdWrite(this);
		}
	}

	public final CmdWriteContext cmdWrite() throws RecognitionException {
		CmdWriteContext _localctx = new CmdWriteContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_cmdWrite);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(112);
			match(T__10);
			setState(113);
			match(AP);
			{
			setState(114);
			termo();

			                    Command cmdWrite = new WriteCommand(_input.LT(-1).getText());
			                    stack.peek().add(cmdWrite);
			                  
			}
			setState(117);
			match(FP);
			setState(118);
			match(PV);
			 rightType = null; 
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExprContext extends ParserRuleContext {
		public TermoContext termo() {
			return getRuleContext(TermoContext.class,0);
		}
		public ExprlContext exprl() {
			return getRuleContext(ExprlContext.class,0);
		}
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitExpr(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		ExprContext _localctx = new ExprContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_expr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(121);
			termo();
			 strExpr += _input.LT(-1).getText(); 
			setState(123);
			exprl();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TermoContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(GrammarParser.ID, 0); }
		public TerminalNode NUM() { return getToken(GrammarParser.NUM, 0); }
		public TerminalNode TEXTO() { return getToken(GrammarParser.TEXTO, 0); }
		public TermoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_termo; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterTermo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitTermo(this);
		}
	}

	public final TermoContext termo() throws RecognitionException {
		TermoContext _localctx = new TermoContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_termo);
		try {
			setState(131);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(125);
				match(ID);
				 if (!isDeclared(_input.LT(-1).getText())) {
				                        throw new SemanticException("Undeclared Variable: " + _input.LT(-1).getText());
				                    }
				                    if (!symbolTable.get(_input.LT(-1).getText()).isInitialized()) {
				                         throw new SemanticException("Variable: " + _input.LT(-1).getText() +" has no value assigned");
				                    }
				                    if (rightType == null) {
				                        rightType = symbolTable.get(_input.LT(-1).getText()).getType();
				                    } else {
				                        if (symbolTable.get(_input.LT(-1).getText()).getType().getValue() > rightType.getValue()) {
				                            rightType = symbolTable.get(_input.LT(-1).getText()).getType();
				                        }
				                    }
				                  
				}
				break;
			case NUM:
				enterOuterAlt(_localctx, 2);
				{
				setState(127);
				match(NUM);

				                    if (rightType == null) {
				                        rightType = Types.NUMBER;
				                    } else {
				                        if (rightType.getValue() < Types.NUMBER.getValue()) {
				                            rightType = Types.NUMBER;
				                        }
				                    }
				                  
				}
				break;
			case TEXTO:
				enterOuterAlt(_localctx, 3);
				{
				setState(129);
				match(TEXTO);

				                        if (rightType == null) {
				                            rightType = Types.TEXT;
				                        } else {
				                            if (rightType.getValue() < Types.TEXT.getValue()) {
				                                rightType = Types.TEXT;
				                            }
				                        }
				                    
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExprlContext extends ParserRuleContext {
		public List<TerminalNode> OP() { return getTokens(GrammarParser.OP); }
		public TerminalNode OP(int i) {
			return getToken(GrammarParser.OP, i);
		}
		public List<TermoContext> termo() {
			return getRuleContexts(TermoContext.class);
		}
		public TermoContext termo(int i) {
			return getRuleContext(TermoContext.class,i);
		}
		public ExprlContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exprl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterExprl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitExprl(this);
		}
	}

	public final ExprlContext exprl() throws RecognitionException {
		ExprlContext _localctx = new ExprlContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_exprl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(140);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OP) {
				{
				{
				setState(133);
				match(OP);
				 strExpr += _input.LT(-1).getText(); 
				setState(135);
				termo();
				 strExpr += _input.LT(-1).getText(); 
				}
				}
				setState(142);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\u0004\u0001\u0019\u0090\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001"+
		"\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004"+
		"\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007"+
		"\u0002\b\u0007\b\u0002\t\u0007\t\u0001\u0000\u0001\u0000\u0001\u0000\u0001"+
		"\u0000\u0004\u0000\u0019\b\u0000\u000b\u0000\f\u0000\u001a\u0001\u0000"+
		"\u0001\u0000\u0004\u0000\u001f\b\u0000\u000b\u0000\f\u0000 \u0001\u0000"+
		"\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0005\u0001.\b\u0001"+
		"\n\u0001\f\u00011\t\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0003\u00018\b\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0003\u0002A\b\u0002"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0004\u0003"+
		"N\b\u0003\u000b\u0003\f\u0003O\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0004\u0003X\b\u0003\u000b\u0003\f\u0003"+
		"Y\u0001\u0003\u0001\u0003\u0001\u0003\u0003\u0003_\b\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0003\b\u0084\b\b\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0005\t\u008b\b\t\n\t\f\t\u008e\t\t\u0001\t\u0000\u0000\n\u0000"+
		"\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0000\u0000\u0092\u0000\u0014"+
		"\u0001\u0000\u0000\u0000\u0002&\u0001\u0000\u0000\u0000\u0004@\u0001\u0000"+
		"\u0000\u0000\u0006B\u0001\u0000\u0000\u0000\bb\u0001\u0000\u0000\u0000"+
		"\ni\u0001\u0000\u0000\u0000\fp\u0001\u0000\u0000\u0000\u000ey\u0001\u0000"+
		"\u0000\u0000\u0010\u0083\u0001\u0000\u0000\u0000\u0012\u008c\u0001\u0000"+
		"\u0000\u0000\u0014\u0015\u0005\u0001\u0000\u0000\u0015\u0016\u0005\u000f"+
		"\u0000\u0000\u0016\u0018\u0006\u0000\uffff\uffff\u0000\u0017\u0019\u0003"+
		"\u0002\u0001\u0000\u0018\u0017\u0001\u0000\u0000\u0000\u0019\u001a\u0001"+
		"\u0000\u0000\u0000\u001a\u0018\u0001\u0000\u0000\u0000\u001a\u001b\u0001"+
		"\u0000\u0000\u0000\u001b\u001c\u0001\u0000\u0000\u0000\u001c\u001e\u0005"+
		"\u0002\u0000\u0000\u001d\u001f\u0003\u0004\u0002\u0000\u001e\u001d\u0001"+
		"\u0000\u0000\u0000\u001f \u0001\u0000\u0000\u0000 \u001e\u0001\u0000\u0000"+
		"\u0000 !\u0001\u0000\u0000\u0000!\"\u0001\u0000\u0000\u0000\"#\u0005\u0003"+
		"\u0000\u0000#$\u0005\u0004\u0000\u0000$%\u0006\u0000\uffff\uffff\u0000"+
		"%\u0001\u0001\u0000\u0000\u0000&\'\u0005\u0005\u0000\u0000\'(\u0006\u0001"+
		"\uffff\uffff\u0000()\u0005\u000f\u0000\u0000)/\u0006\u0001\uffff\uffff"+
		"\u0000*+\u0005\u0012\u0000\u0000+,\u0005\u000f\u0000\u0000,.\u0006\u0001"+
		"\uffff\uffff\u0000-*\u0001\u0000\u0000\u0000.1\u0001\u0000\u0000\u0000"+
		"/-\u0001\u0000\u0000\u0000/0\u0001\u0000\u0000\u000002\u0001\u0000\u0000"+
		"\u00001/\u0001\u0000\u0000\u000027\u0005\u0014\u0000\u000034\u0005\u0006"+
		"\u0000\u000048\u0006\u0001\uffff\uffff\u000056\u0005\u0007\u0000\u0000"+
		"68\u0006\u0001\uffff\uffff\u000073\u0001\u0000\u0000\u000075\u0001\u0000"+
		"\u0000\u000089\u0001\u0000\u0000\u00009:\u0006\u0001\uffff\uffff\u0000"+
		":;\u0005\u0013\u0000\u0000;\u0003\u0001\u0000\u0000\u0000<A\u0003\b\u0004"+
		"\u0000=A\u0003\n\u0005\u0000>A\u0003\f\u0006\u0000?A\u0003\u0006\u0003"+
		"\u0000@<\u0001\u0000\u0000\u0000@=\u0001\u0000\u0000\u0000@>\u0001\u0000"+
		"\u0000\u0000@?\u0001\u0000\u0000\u0000A\u0005\u0001\u0000\u0000\u0000"+
		"BC\u0005\b\u0000\u0000CD\u0006\u0003\uffff\uffff\u0000DE\u0005\u0015\u0000"+
		"\u0000EF\u0003\u000e\u0007\u0000FG\u0005\u000e\u0000\u0000GH\u0006\u0003"+
		"\uffff\uffff\u0000HI\u0003\u000e\u0007\u0000IJ\u0005\u0016\u0000\u0000"+
		"JK\u0006\u0003\uffff\uffff\u0000KM\u0005\u0017\u0000\u0000LN\u0003\u0004"+
		"\u0002\u0000ML\u0001\u0000\u0000\u0000NO\u0001\u0000\u0000\u0000OM\u0001"+
		"\u0000\u0000\u0000OP\u0001\u0000\u0000\u0000PQ\u0001\u0000\u0000\u0000"+
		"QR\u0006\u0003\uffff\uffff\u0000R^\u0005\u0018\u0000\u0000ST\u0005\t\u0000"+
		"\u0000TU\u0006\u0003\uffff\uffff\u0000UW\u0005\u0017\u0000\u0000VX\u0003"+
		"\u0004\u0002\u0000WV\u0001\u0000\u0000\u0000XY\u0001\u0000\u0000\u0000"+
		"YW\u0001\u0000\u0000\u0000YZ\u0001\u0000\u0000\u0000Z[\u0001\u0000\u0000"+
		"\u0000[\\\u0006\u0003\uffff\uffff\u0000\\]\u0005\u0018\u0000\u0000]_\u0001"+
		"\u0000\u0000\u0000^S\u0001\u0000\u0000\u0000^_\u0001\u0000\u0000\u0000"+
		"_`\u0001\u0000\u0000\u0000`a\u0006\u0003\uffff\uffff\u0000a\u0007\u0001"+
		"\u0000\u0000\u0000bc\u0005\u000f\u0000\u0000cd\u0006\u0004\uffff\uffff"+
		"\u0000de\u0005\r\u0000\u0000ef\u0003\u000e\u0007\u0000fg\u0005\u0013\u0000"+
		"\u0000gh\u0006\u0004\uffff\uffff\u0000h\t\u0001\u0000\u0000\u0000ij\u0005"+
		"\n\u0000\u0000jk\u0005\u0015\u0000\u0000kl\u0005\u000f\u0000\u0000lm\u0006"+
		"\u0005\uffff\uffff\u0000mn\u0005\u0016\u0000\u0000no\u0005\u0013\u0000"+
		"\u0000o\u000b\u0001\u0000\u0000\u0000pq\u0005\u000b\u0000\u0000qr\u0005"+
		"\u0015\u0000\u0000rs\u0003\u0010\b\u0000st\u0006\u0006\uffff\uffff\u0000"+
		"tu\u0001\u0000\u0000\u0000uv\u0005\u0016\u0000\u0000vw\u0005\u0013\u0000"+
		"\u0000wx\u0006\u0006\uffff\uffff\u0000x\r\u0001\u0000\u0000\u0000yz\u0003"+
		"\u0010\b\u0000z{\u0006\u0007\uffff\uffff\u0000{|\u0003\u0012\t\u0000|"+
		"\u000f\u0001\u0000\u0000\u0000}~\u0005\u000f\u0000\u0000~\u0084\u0006"+
		"\b\uffff\uffff\u0000\u007f\u0080\u0005\u0010\u0000\u0000\u0080\u0084\u0006"+
		"\b\uffff\uffff\u0000\u0081\u0082\u0005\u0019\u0000\u0000\u0082\u0084\u0006"+
		"\b\uffff\uffff\u0000\u0083}\u0001\u0000\u0000\u0000\u0083\u007f\u0001"+
		"\u0000\u0000\u0000\u0083\u0081\u0001\u0000\u0000\u0000\u0084\u0011\u0001"+
		"\u0000\u0000\u0000\u0085\u0086\u0005\f\u0000\u0000\u0086\u0087\u0006\t"+
		"\uffff\uffff\u0000\u0087\u0088\u0003\u0010\b\u0000\u0088\u0089\u0006\t"+
		"\uffff\uffff\u0000\u0089\u008b\u0001\u0000\u0000\u0000\u008a\u0085\u0001"+
		"\u0000\u0000\u0000\u008b\u008e\u0001\u0000\u0000\u0000\u008c\u008a\u0001"+
		"\u0000\u0000\u0000\u008c\u008d\u0001\u0000\u0000\u0000\u008d\u0013\u0001"+
		"\u0000\u0000\u0000\u008e\u008c\u0001\u0000\u0000\u0000\n\u001a /7@OY^"+
		"\u0083\u008c";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
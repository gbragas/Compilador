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
		T__9=10, T__10=11, T__11=12, T__12=13, OP=14, OP_AT=15, OP_REL=16, ID=17, 
		NUM=18, WS=19, VG=20, PV=21, DP=22, AP=23, FP=24, AC=25, FC=26, TEXTO=27;
	public static final int
		RULE_programa = 0, RULE_declararvar = 1, RULE_comando = 2, RULE_cmdDoWhile = 3, 
		RULE_cmdWhile = 4, RULE_cmdIf = 5, RULE_cmdAttrib = 6, RULE_cmdRead = 7, 
		RULE_cmdWrite = 8, RULE_expr = 9, RULE_termo = 10, RULE_exprl = 11;
	private static String[] makeRuleNames() {
		return new String[] {
			"programa", "declararvar", "comando", "cmdDoWhile", "cmdWhile", "cmdIf", 
			"cmdAttrib", "cmdRead", "cmdWrite", "expr", "termo", "exprl"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'programa'", "'inicio'", "'fim'", "'fimprog'", "'declare'", "'number'", 
			"'text'", "'fa\\u00E7a'", "'enquanto'", "'if'", "'else'", "'read'", "'write'", 
			null, "'='", null, null, null, null, "','", "';'", "':'", "'('", "')'", 
			"'{'", "'}'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, "OP", "OP_AT", "OP_REL", "ID", "NUM", "WS", "VG", "PV", "DP", 
			"AP", "FP", "AC", "FC", "TEXTO"
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
	    private WhileCommand currentWhileCommand;
	    private DoWhileCommand currentDoWhileCommand;
	    private AttributionCommand currentAttributionCommand;
	    private Warning warning;
	    
	    

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
	    
	    public boolean isTypeCompatible(Types leftType, Types rightType) {
	    if (leftType == Types.NUMBER && rightType == Types.TEXT) {
	        return false;
	    }
	    return true;
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
			setState(24);
			match(T__0);
			setState(25);
			match(ID);
			 program.setName(_input.LT(-1).getText());
			                              stack.push(new ArrayList<Command>());
			                               Warning warning = new Warning();
			                              
			                            
			setState(28); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(27);
				declararvar();
				}
				}
				setState(30); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__4 );
			setState(32);
			match(T__1);
			setState(34); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(33);
				comando();
				}
				}
				setState(36); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 145152L) != 0) );
			setState(38);
			match(T__2);
			setState(39);
			match(T__3);

			                    program.setSymbolTable(symbolTable);
			                    program.setCommandList(stack.pop());
			                    for (String varId : symbolTable.keySet()) {
								    Var var = symbolTable.get(varId);
								    if (!var.isUsed()) {
								        warning.addWarning("Variable '" + varId + "' declared but never used.");
								}
			}
			                    warning.printWarnings();
			                
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
			setState(42);
			match(T__4);
			 currentDecl.clear(); 
			setState(44);
			match(ID);
			 currentDecl.add(new Var(_input.LT(-1).getText())); 
			setState(51);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==VG) {
				{
				{
				setState(46);
				match(VG);
				setState(47);
				match(ID);
				 currentDecl.add(new Var(_input.LT(-1).getText())); 
				}
				}
				setState(53);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(54);
			match(DP);
			setState(59);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__5:
				{
				setState(55);
				match(T__5);
				 currentType = Types.NUMBER; 
				}
				break;
			case T__6:
				{
				setState(57);
				match(T__6);
				 currentType = Types.TEXT; 
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			 updateType(); 
			setState(62);
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
		public CmdWhileContext cmdWhile() {
			return getRuleContext(CmdWhileContext.class,0);
		}
		public CmdDoWhileContext cmdDoWhile() {
			return getRuleContext(CmdDoWhileContext.class,0);
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
			setState(70);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(64);
				cmdAttrib();
				}
				break;
			case T__11:
				enterOuterAlt(_localctx, 2);
				{
				setState(65);
				cmdRead();
				}
				break;
			case T__12:
				enterOuterAlt(_localctx, 3);
				{
				setState(66);
				cmdWrite();
				}
				break;
			case T__9:
				enterOuterAlt(_localctx, 4);
				{
				setState(67);
				cmdIf();
				}
				break;
			case T__8:
				enterOuterAlt(_localctx, 5);
				{
				setState(68);
				cmdWhile();
				}
				break;
			case T__7:
				enterOuterAlt(_localctx, 6);
				{
				setState(69);
				cmdDoWhile();
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
	public static class CmdDoWhileContext extends ParserRuleContext {
		public TerminalNode AC() { return getToken(GrammarParser.AC, 0); }
		public TerminalNode FC() { return getToken(GrammarParser.FC, 0); }
		public TerminalNode AP() { return getToken(GrammarParser.AP, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode OP_REL() { return getToken(GrammarParser.OP_REL, 0); }
		public TerminalNode FP() { return getToken(GrammarParser.FP, 0); }
		public TerminalNode PV() { return getToken(GrammarParser.PV, 0); }
		public List<ComandoContext> comando() {
			return getRuleContexts(ComandoContext.class);
		}
		public ComandoContext comando(int i) {
			return getRuleContext(ComandoContext.class,i);
		}
		public CmdDoWhileContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdDoWhile; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterCmdDoWhile(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitCmdDoWhile(this);
		}
	}

	public final CmdDoWhileContext cmdDoWhile() throws RecognitionException {
		CmdDoWhileContext _localctx = new CmdDoWhileContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_cmdDoWhile);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(72);
			match(T__7);

			                        stack.push(new ArrayList<Command>());
			                        strExpr = "";
			                        currentDoWhileCommand = new DoWhileCommand();
			                   
			setState(74);
			match(AC);
			setState(76); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(75);
				comando();
				}
				}
				setState(78); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 145152L) != 0) );
			 currentDoWhileCommand.setCommandList(stack.pop()); 
			setState(81);
			match(FC);
			setState(82);
			match(T__8);
			setState(83);
			match(AP);
			setState(84);
			expr();
			currentDoWhileCommand.setExpressiL(_input.LT(-1).getText());
			setState(86);
			match(OP_REL);
			currentDoWhileCommand.setOperation(_input.LT(-1).getText());
			setState(88);
			expr();
			currentDoWhileCommand.setExpressiR(_input.LT(-1).getText());
			setState(90);
			match(FP);
			setState(91);
			match(PV);
			 stack.peek().add(currentDoWhileCommand); 
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
	public static class CmdWhileContext extends ParserRuleContext {
		public TerminalNode AP() { return getToken(GrammarParser.AP, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode OP_REL() { return getToken(GrammarParser.OP_REL, 0); }
		public TerminalNode FP() { return getToken(GrammarParser.FP, 0); }
		public TerminalNode AC() { return getToken(GrammarParser.AC, 0); }
		public TerminalNode FC() { return getToken(GrammarParser.FC, 0); }
		public List<ComandoContext> comando() {
			return getRuleContexts(ComandoContext.class);
		}
		public ComandoContext comando(int i) {
			return getRuleContext(ComandoContext.class,i);
		}
		public CmdWhileContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdWhile; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterCmdWhile(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitCmdWhile(this);
		}
	}

	public final CmdWhileContext cmdWhile() throws RecognitionException {
		CmdWhileContext _localctx = new CmdWhileContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_cmdWhile);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(94);
			match(T__8);

			                        stack.push(new ArrayList<Command>());
			                        strExpr = "";
			                        currentWhileCommand = new WhileCommand();
			                   
			setState(96);
			match(AP);
			setState(97);
			expr();
			setState(98);
			match(OP_REL);
			 strExpr += " "+ _input.LT(-1).getText() + " "; 
			setState(100);
			expr();
			setState(101);
			match(FP);
			 currentWhileCommand.setExpression(strExpr); 
			setState(103);
			match(AC);
			setState(105); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(104);
				comando();
				}
				}
				setState(107); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 145152L) != 0) );
			 currentWhileCommand.setCommandList(stack.pop()); 
			setState(110);
			match(FC);
			 stack.peek().add(currentWhileCommand); 
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
		enterRule(_localctx, 10, RULE_cmdIf);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(113);
			match(T__9);

			                        stack.push(new ArrayList<Command>());
			                        strExpr = "";
			                        currentIfCommand = new IfCommand();
			                   
			setState(115);
			match(AP);
			setState(116);
			expr();
			setState(117);
			match(OP_REL);
			 strExpr += " "+ _input.LT(-1).getText() + " "; 
			setState(119);
			expr();
			setState(120);
			match(FP);
			 currentIfCommand.setExpression(strExpr); 
			setState(122);
			match(AC);
			setState(124); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(123);
				comando();
				}
				}
				setState(126); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 145152L) != 0) );
			 currentIfCommand.setTrueList(stack.pop()); 
			setState(129);
			match(FC);
			setState(141);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__10) {
				{
				setState(130);
				match(T__10);
				 stack.push(new ArrayList<Command>()); 
				setState(132);
				match(AC);
				setState(134); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(133);
					comando();
					}
					}
					setState(136); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 145152L) != 0) );
				 currentIfCommand.setFalseList(stack.pop()); 
				setState(139);
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
		enterRule(_localctx, 12, RULE_cmdAttrib);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(145);
			match(ID);

			        if (!isDeclared(_input.LT(-1).getText())) {
			            throw new SemanticException("Undeclared Variable: " + _input.LT(-1).getText());
			        }
			        
			                
			        currentAttributionCommand = new AttributionCommand();
			        symbolTable.get(_input.LT(-1).getText()).setUsed(true);
			        symbolTable.get(_input.LT(-1).getText()).setInitialized(true);
			        leftType = symbolTable.get(_input.LT(-1).getText()).getType();
			        
			        currentAttributionCommand.setVariable(_input.LT(-1).getText()); // Set variavel
			    
			setState(147);
			match(OP_AT);

			        currentAttributionCommand.setOperation(_input.LT(-1).getText()); // Set operador
			    
			setState(149);
			expr();

			    	currentAttributionCommand.setValue(_input.LT(-1).getText()); // Set valor atribuido
			    
			setState(151);
			match(PV);

			        
			        stack.peek().add(currentAttributionCommand);
			        //System.out.println("Left Side Expression Type: " + leftType);
			        //System.out.println("Right Side Expression Type: " + rightType);
			        if (!isTypeCompatible(leftType,rightType)) {
			            throw new SemanticException("Type Missmatching on Assignment: " + leftType + " and " + rightType);
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
		enterRule(_localctx, 14, RULE_cmdRead);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(154);
			match(T__11);
			setState(155);
			match(AP);
			setState(156);
			match(ID);
			 if (!isDeclared(_input.LT(-1).getText())) {
			                         throw new SemanticException("Undeclared Variable: " + _input.LT(-1).getText());
			                     }
			                     symbolTable.get(_input.LT(-1).getText()).setUsed(true);
			                     symbolTable.get(_input.LT(-1).getText()).setInitialized(true);
			                     Command cmdRead = new ReadCommand(symbolTable.get(_input.LT(-1).getText()));
			                     stack.peek().add(cmdRead);
			                   
			setState(158);
			match(FP);
			setState(159);
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
		enterRule(_localctx, 16, RULE_cmdWrite);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(161);
			match(T__12);
			setState(162);
			match(AP);
			{
			setState(163);
			termo();

			                    Command cmdWrite = new WriteCommand(_input.LT(-1).getText());
			                    stack.peek().add(cmdWrite);
			                  
			}
			setState(166);
			match(FP);
			setState(167);
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
		enterRule(_localctx, 18, RULE_expr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(170);
			termo();
			 strExpr +=  _input.LT(-1).getText(); 
			setState(172);
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
		enterRule(_localctx, 20, RULE_termo);
		try {
			setState(180);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(174);
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
				setState(176);
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
				setState(178);
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
		enterRule(_localctx, 22, RULE_exprl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(189);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OP) {
				{
				{
				setState(182);
				match(OP);
				 strExpr += " "+ _input.LT(-1).getText() + " "; 
				setState(184);
				termo();
				 strExpr += _input.LT(-1).getText(); 
				}
				}
				setState(191);
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
		"\u0004\u0001\u001b\u00c1\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001"+
		"\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004"+
		"\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007"+
		"\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b"+
		"\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0004\u0000\u001d\b\u0000"+
		"\u000b\u0000\f\u0000\u001e\u0001\u0000\u0001\u0000\u0004\u0000#\b\u0000"+
		"\u000b\u0000\f\u0000$\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0005\u00012\b\u0001\n\u0001\f\u00015\t\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0003\u0001<\b\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0003\u0002G\b\u0002\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0004\u0003M\b\u0003\u000b\u0003"+
		"\f\u0003N\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0004\u0004j\b\u0004\u000b\u0004\f\u0004k\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0004\u0005}\b\u0005\u000b\u0005\f\u0005"+
		"~\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0004\u0005\u0087\b\u0005\u000b\u0005\f\u0005\u0088\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0003\u0005\u008e\b\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0003\n\u00b5\b\n\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0005\u000b\u00bc"+
		"\b\u000b\n\u000b\f\u000b\u00bf\t\u000b\u0001\u000b\u0000\u0000\f\u0000"+
		"\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0000\u0000\u00c5"+
		"\u0000\u0018\u0001\u0000\u0000\u0000\u0002*\u0001\u0000\u0000\u0000\u0004"+
		"F\u0001\u0000\u0000\u0000\u0006H\u0001\u0000\u0000\u0000\b^\u0001\u0000"+
		"\u0000\u0000\nq\u0001\u0000\u0000\u0000\f\u0091\u0001\u0000\u0000\u0000"+
		"\u000e\u009a\u0001\u0000\u0000\u0000\u0010\u00a1\u0001\u0000\u0000\u0000"+
		"\u0012\u00aa\u0001\u0000\u0000\u0000\u0014\u00b4\u0001\u0000\u0000\u0000"+
		"\u0016\u00bd\u0001\u0000\u0000\u0000\u0018\u0019\u0005\u0001\u0000\u0000"+
		"\u0019\u001a\u0005\u0011\u0000\u0000\u001a\u001c\u0006\u0000\uffff\uffff"+
		"\u0000\u001b\u001d\u0003\u0002\u0001\u0000\u001c\u001b\u0001\u0000\u0000"+
		"\u0000\u001d\u001e\u0001\u0000\u0000\u0000\u001e\u001c\u0001\u0000\u0000"+
		"\u0000\u001e\u001f\u0001\u0000\u0000\u0000\u001f \u0001\u0000\u0000\u0000"+
		" \"\u0005\u0002\u0000\u0000!#\u0003\u0004\u0002\u0000\"!\u0001\u0000\u0000"+
		"\u0000#$\u0001\u0000\u0000\u0000$\"\u0001\u0000\u0000\u0000$%\u0001\u0000"+
		"\u0000\u0000%&\u0001\u0000\u0000\u0000&\'\u0005\u0003\u0000\u0000\'(\u0005"+
		"\u0004\u0000\u0000()\u0006\u0000\uffff\uffff\u0000)\u0001\u0001\u0000"+
		"\u0000\u0000*+\u0005\u0005\u0000\u0000+,\u0006\u0001\uffff\uffff\u0000"+
		",-\u0005\u0011\u0000\u0000-3\u0006\u0001\uffff\uffff\u0000./\u0005\u0014"+
		"\u0000\u0000/0\u0005\u0011\u0000\u000002\u0006\u0001\uffff\uffff\u0000"+
		"1.\u0001\u0000\u0000\u000025\u0001\u0000\u0000\u000031\u0001\u0000\u0000"+
		"\u000034\u0001\u0000\u0000\u000046\u0001\u0000\u0000\u000053\u0001\u0000"+
		"\u0000\u00006;\u0005\u0016\u0000\u000078\u0005\u0006\u0000\u00008<\u0006"+
		"\u0001\uffff\uffff\u00009:\u0005\u0007\u0000\u0000:<\u0006\u0001\uffff"+
		"\uffff\u0000;7\u0001\u0000\u0000\u0000;9\u0001\u0000\u0000\u0000<=\u0001"+
		"\u0000\u0000\u0000=>\u0006\u0001\uffff\uffff\u0000>?\u0005\u0015\u0000"+
		"\u0000?\u0003\u0001\u0000\u0000\u0000@G\u0003\f\u0006\u0000AG\u0003\u000e"+
		"\u0007\u0000BG\u0003\u0010\b\u0000CG\u0003\n\u0005\u0000DG\u0003\b\u0004"+
		"\u0000EG\u0003\u0006\u0003\u0000F@\u0001\u0000\u0000\u0000FA\u0001\u0000"+
		"\u0000\u0000FB\u0001\u0000\u0000\u0000FC\u0001\u0000\u0000\u0000FD\u0001"+
		"\u0000\u0000\u0000FE\u0001\u0000\u0000\u0000G\u0005\u0001\u0000\u0000"+
		"\u0000HI\u0005\b\u0000\u0000IJ\u0006\u0003\uffff\uffff\u0000JL\u0005\u0019"+
		"\u0000\u0000KM\u0003\u0004\u0002\u0000LK\u0001\u0000\u0000\u0000MN\u0001"+
		"\u0000\u0000\u0000NL\u0001\u0000\u0000\u0000NO\u0001\u0000\u0000\u0000"+
		"OP\u0001\u0000\u0000\u0000PQ\u0006\u0003\uffff\uffff\u0000QR\u0005\u001a"+
		"\u0000\u0000RS\u0005\t\u0000\u0000ST\u0005\u0017\u0000\u0000TU\u0003\u0012"+
		"\t\u0000UV\u0006\u0003\uffff\uffff\u0000VW\u0005\u0010\u0000\u0000WX\u0006"+
		"\u0003\uffff\uffff\u0000XY\u0003\u0012\t\u0000YZ\u0006\u0003\uffff\uffff"+
		"\u0000Z[\u0005\u0018\u0000\u0000[\\\u0005\u0015\u0000\u0000\\]\u0006\u0003"+
		"\uffff\uffff\u0000]\u0007\u0001\u0000\u0000\u0000^_\u0005\t\u0000\u0000"+
		"_`\u0006\u0004\uffff\uffff\u0000`a\u0005\u0017\u0000\u0000ab\u0003\u0012"+
		"\t\u0000bc\u0005\u0010\u0000\u0000cd\u0006\u0004\uffff\uffff\u0000de\u0003"+
		"\u0012\t\u0000ef\u0005\u0018\u0000\u0000fg\u0006\u0004\uffff\uffff\u0000"+
		"gi\u0005\u0019\u0000\u0000hj\u0003\u0004\u0002\u0000ih\u0001\u0000\u0000"+
		"\u0000jk\u0001\u0000\u0000\u0000ki\u0001\u0000\u0000\u0000kl\u0001\u0000"+
		"\u0000\u0000lm\u0001\u0000\u0000\u0000mn\u0006\u0004\uffff\uffff\u0000"+
		"no\u0005\u001a\u0000\u0000op\u0006\u0004\uffff\uffff\u0000p\t\u0001\u0000"+
		"\u0000\u0000qr\u0005\n\u0000\u0000rs\u0006\u0005\uffff\uffff\u0000st\u0005"+
		"\u0017\u0000\u0000tu\u0003\u0012\t\u0000uv\u0005\u0010\u0000\u0000vw\u0006"+
		"\u0005\uffff\uffff\u0000wx\u0003\u0012\t\u0000xy\u0005\u0018\u0000\u0000"+
		"yz\u0006\u0005\uffff\uffff\u0000z|\u0005\u0019\u0000\u0000{}\u0003\u0004"+
		"\u0002\u0000|{\u0001\u0000\u0000\u0000}~\u0001\u0000\u0000\u0000~|\u0001"+
		"\u0000\u0000\u0000~\u007f\u0001\u0000\u0000\u0000\u007f\u0080\u0001\u0000"+
		"\u0000\u0000\u0080\u0081\u0006\u0005\uffff\uffff\u0000\u0081\u008d\u0005"+
		"\u001a\u0000\u0000\u0082\u0083\u0005\u000b\u0000\u0000\u0083\u0084\u0006"+
		"\u0005\uffff\uffff\u0000\u0084\u0086\u0005\u0019\u0000\u0000\u0085\u0087"+
		"\u0003\u0004\u0002\u0000\u0086\u0085\u0001\u0000\u0000\u0000\u0087\u0088"+
		"\u0001\u0000\u0000\u0000\u0088\u0086\u0001\u0000\u0000\u0000\u0088\u0089"+
		"\u0001\u0000\u0000\u0000\u0089\u008a\u0001\u0000\u0000\u0000\u008a\u008b"+
		"\u0006\u0005\uffff\uffff\u0000\u008b\u008c\u0005\u001a\u0000\u0000\u008c"+
		"\u008e\u0001\u0000\u0000\u0000\u008d\u0082\u0001\u0000\u0000\u0000\u008d"+
		"\u008e\u0001\u0000\u0000\u0000\u008e\u008f\u0001\u0000\u0000\u0000\u008f"+
		"\u0090\u0006\u0005\uffff\uffff\u0000\u0090\u000b\u0001\u0000\u0000\u0000"+
		"\u0091\u0092\u0005\u0011\u0000\u0000\u0092\u0093\u0006\u0006\uffff\uffff"+
		"\u0000\u0093\u0094\u0005\u000f\u0000\u0000\u0094\u0095\u0006\u0006\uffff"+
		"\uffff\u0000\u0095\u0096\u0003\u0012\t\u0000\u0096\u0097\u0006\u0006\uffff"+
		"\uffff\u0000\u0097\u0098\u0005\u0015\u0000\u0000\u0098\u0099\u0006\u0006"+
		"\uffff\uffff\u0000\u0099\r\u0001\u0000\u0000\u0000\u009a\u009b\u0005\f"+
		"\u0000\u0000\u009b\u009c\u0005\u0017\u0000\u0000\u009c\u009d\u0005\u0011"+
		"\u0000\u0000\u009d\u009e\u0006\u0007\uffff\uffff\u0000\u009e\u009f\u0005"+
		"\u0018\u0000\u0000\u009f\u00a0\u0005\u0015\u0000\u0000\u00a0\u000f\u0001"+
		"\u0000\u0000\u0000\u00a1\u00a2\u0005\r\u0000\u0000\u00a2\u00a3\u0005\u0017"+
		"\u0000\u0000\u00a3\u00a4\u0003\u0014\n\u0000\u00a4\u00a5\u0006\b\uffff"+
		"\uffff\u0000\u00a5\u00a6\u0001\u0000\u0000\u0000\u00a6\u00a7\u0005\u0018"+
		"\u0000\u0000\u00a7\u00a8\u0005\u0015\u0000\u0000\u00a8\u00a9\u0006\b\uffff"+
		"\uffff\u0000\u00a9\u0011\u0001\u0000\u0000\u0000\u00aa\u00ab\u0003\u0014"+
		"\n\u0000\u00ab\u00ac\u0006\t\uffff\uffff\u0000\u00ac\u00ad\u0003\u0016"+
		"\u000b\u0000\u00ad\u0013\u0001\u0000\u0000\u0000\u00ae\u00af\u0005\u0011"+
		"\u0000\u0000\u00af\u00b5\u0006\n\uffff\uffff\u0000\u00b0\u00b1\u0005\u0012"+
		"\u0000\u0000\u00b1\u00b5\u0006\n\uffff\uffff\u0000\u00b2\u00b3\u0005\u001b"+
		"\u0000\u0000\u00b3\u00b5\u0006\n\uffff\uffff\u0000\u00b4\u00ae\u0001\u0000"+
		"\u0000\u0000\u00b4\u00b0\u0001\u0000\u0000\u0000\u00b4\u00b2\u0001\u0000"+
		"\u0000\u0000\u00b5\u0015\u0001\u0000\u0000\u0000\u00b6\u00b7\u0005\u000e"+
		"\u0000\u0000\u00b7\u00b8\u0006\u000b\uffff\uffff\u0000\u00b8\u00b9\u0003"+
		"\u0014\n\u0000\u00b9\u00ba\u0006\u000b\uffff\uffff\u0000\u00ba\u00bc\u0001"+
		"\u0000\u0000\u0000\u00bb\u00b6\u0001\u0000\u0000\u0000\u00bc\u00bf\u0001"+
		"\u0000\u0000\u0000\u00bd\u00bb\u0001\u0000\u0000\u0000\u00bd\u00be\u0001"+
		"\u0000\u0000\u0000\u00be\u0017\u0001\u0000\u0000\u0000\u00bf\u00bd\u0001"+
		"\u0000\u0000\u0000\f\u001e$3;FNk~\u0088\u008d\u00b4\u00bd";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
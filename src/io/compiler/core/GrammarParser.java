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
		T__9=10, T__10=11, T__11=12, T__12=13, OP_SUM=14, OP_SUB=15, OP_MUL=16, 
		OP_DIV=17, OP_AT=18, OP_REL=19, ID=20, NUM=21, WS=22, VG=23, PV=24, DP=25, 
		AP=26, FP=27, AC=28, FC=29, TEXTO=30;
	public static final int
		RULE_programa = 0, RULE_declararvar = 1, RULE_comando = 2, RULE_cmdDoWhile = 3, 
		RULE_cmdWhile = 4, RULE_cmdIf = 5, RULE_cmdAttrib = 6, RULE_cmdRead = 7, 
		RULE_cmdWrite = 8, RULE_expr = 9, RULE_fator = 10, RULE_exprl = 11, RULE_termo = 12, 
		RULE_termol = 13;
	private static String[] makeRuleNames() {
		return new String[] {
			"programa", "declararvar", "comando", "cmdDoWhile", "cmdWhile", "cmdIf", 
			"cmdAttrib", "cmdRead", "cmdWrite", "expr", "fator", "exprl", "termo", 
			"termol"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'programa'", "'inicio'", "'fim'", "'fimprog'", "'declare'", "'number'", 
			"'text'", "'fa\\u00E7a'", "'enquanto'", "'if'", "'else'", "'read'", "'write'", 
			"'+'", "'-'", "'*'", "'/'", "'='", null, null, null, null, "','", "';'", 
			"':'", "'('", "')'", "'{'", "'}'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, "OP_SUM", "OP_SUB", "OP_MUL", "OP_DIV", "OP_AT", "OP_REL", 
			"ID", "NUM", "WS", "VG", "PV", "DP", "AP", "FP", "AC", "FC", "TEXTO"
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
	    
	    
	 	private Stack<AbstractExpression> stackExpression = new Stack<AbstractExpression>();
		private AbstractExpression topo = null;
		
	    public double generateValue(){
	       if (topo == null){
	          topo = stackExpression.pop();
	       }
	       return topo.evaluate();
	    }
	    
	    public String generateJSON(){
	    	if (topo == null){
	          topo = stackExpression.pop();
	       }
	       return topo.toJson();
	    }
	    
	    
	    
	    
	    

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
			setState(28);
			match(T__0);
			setState(29);
			match(ID);
			 program.setName(_input.LT(-1).getText());
			                              stack.push(new ArrayList<Command>());
			                               Warning warning = new Warning();
			                              
			                            
			setState(32); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(31);
				declararvar();
				}
				}
				setState(34); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__4 );
			setState(36);
			match(T__1);
			setState(38); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(37);
				comando();
				}
				}
				setState(40); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 1062656L) != 0) );
			setState(42);
			match(T__2);
			setState(43);
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
			setState(46);
			match(T__4);
			 currentDecl.clear(); 
			setState(48);
			match(ID);
			 currentDecl.add(new Var(_input.LT(-1).getText())); 
			setState(55);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==VG) {
				{
				{
				setState(50);
				match(VG);
				setState(51);
				match(ID);
				 currentDecl.add(new Var(_input.LT(-1).getText())); 
				}
				}
				setState(57);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(58);
			match(DP);
			setState(63);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__5:
				{
				setState(59);
				match(T__5);
				 currentType = Types.NUMBER; 
				}
				break;
			case T__6:
				{
				setState(61);
				match(T__6);
				 currentType = Types.TEXT; 
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			 updateType(); 
			setState(66);
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
			setState(74);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(68);
				cmdAttrib();
				}
				break;
			case T__11:
				enterOuterAlt(_localctx, 2);
				{
				setState(69);
				cmdRead();
				}
				break;
			case T__12:
				enterOuterAlt(_localctx, 3);
				{
				setState(70);
				cmdWrite();
				}
				break;
			case T__9:
				enterOuterAlt(_localctx, 4);
				{
				setState(71);
				cmdIf();
				}
				break;
			case T__8:
				enterOuterAlt(_localctx, 5);
				{
				setState(72);
				cmdWhile();
				}
				break;
			case T__7:
				enterOuterAlt(_localctx, 6);
				{
				setState(73);
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
			setState(76);
			match(T__7);

			                        stack.push(new ArrayList<Command>());
			                        strExpr = "";
			                        currentDoWhileCommand = new DoWhileCommand();
			                   
			setState(78);
			match(AC);
			setState(80); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(79);
				comando();
				}
				}
				setState(82); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 1062656L) != 0) );
			 currentDoWhileCommand.setCommandList(stack.pop()); 
			setState(85);
			match(FC);
			setState(86);
			match(T__8);
			setState(87);
			match(AP);
			setState(88);
			expr();
			currentDoWhileCommand.setExpressiL(_input.LT(-1).getText());
			setState(90);
			match(OP_REL);
			currentDoWhileCommand.setOperation(_input.LT(-1).getText());
			setState(92);
			expr();
			currentDoWhileCommand.setExpressiR(_input.LT(-1).getText());
			setState(94);
			match(FP);
			setState(95);
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
			setState(98);
			match(T__8);

			                        stack.push(new ArrayList<Command>());
			                        strExpr = "";
			                        currentWhileCommand = new WhileCommand();
			                   
			setState(100);
			match(AP);
			setState(101);
			expr();
			setState(102);
			match(OP_REL);
			 strExpr += " "+ _input.LT(-1).getText() + " "; 
			setState(104);
			expr();
			setState(105);
			match(FP);
			 currentWhileCommand.setExpression(strExpr); 
			setState(107);
			match(AC);
			setState(109); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(108);
				comando();
				}
				}
				setState(111); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 1062656L) != 0) );
			 currentWhileCommand.setCommandList(stack.pop()); 
			setState(114);
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
			setState(117);
			match(T__9);

			                        stack.push(new ArrayList<Command>());
			                        strExpr = "";
			                        currentIfCommand = new IfCommand();
			                   
			setState(119);
			match(AP);
			setState(120);
			expr();
			setState(121);
			match(OP_REL);
			 strExpr += " "+ _input.LT(-1).getText() + " "; 
			setState(123);
			expr();
			setState(124);
			match(FP);
			 currentIfCommand.setExpression(strExpr); 
			setState(126);
			match(AC);
			setState(128); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(127);
				comando();
				}
				}
				setState(130); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 1062656L) != 0) );
			 currentIfCommand.setTrueList(stack.pop()); 
			setState(133);
			match(FC);
			setState(145);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__10) {
				{
				setState(134);
				match(T__10);
				 stack.push(new ArrayList<Command>()); 
				setState(136);
				match(AC);
				setState(138); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(137);
					comando();
					}
					}
					setState(140); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 1062656L) != 0) );
				 currentIfCommand.setFalseList(stack.pop()); 
				setState(143);
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
			setState(149);
			match(ID);

			        if (!isDeclared(_input.LT(-1).getText())) {
			            throw new SemanticException("Undeclared Variable: " + _input.LT(-1).getText());
			        }
			        
			                
			        currentAttributionCommand = new AttributionCommand();
			        symbolTable.get(_input.LT(-1).getText()).setUsed(true);
			        symbolTable.get(_input.LT(-1).getText()).setInitialized(true);
			        leftType = symbolTable.get(_input.LT(-1).getText()).getType();
			        
			        currentAttributionCommand.setVariable(_input.LT(-1).getText()); // Set variavel
			    
			setState(151);
			match(OP_AT);

			        currentAttributionCommand.setOperation(_input.LT(-1).getText()); // Set operador
			    
			setState(153);
			expr();

			    	currentAttributionCommand.setValue(_input.LT(-1).getText()); // Set valor atribuido
			    
			setState(155);
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
			setState(158);
			match(T__11);
			setState(159);
			match(AP);
			setState(160);
			match(ID);
			 if (!isDeclared(_input.LT(-1).getText())) {
			                         throw new SemanticException("Undeclared Variable: " + _input.LT(-1).getText());
			                     }
			                     symbolTable.get(_input.LT(-1).getText()).setUsed(true);
			                     symbolTable.get(_input.LT(-1).getText()).setInitialized(true);
			                     Command cmdRead = new ReadCommand(symbolTable.get(_input.LT(-1).getText()));
			                     stack.peek().add(cmdRead);
			                   
			setState(162);
			match(FP);
			setState(163);
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
			setState(165);
			match(T__12);
			setState(166);
			match(AP);
			{
			setState(167);
			termo();

			                    Command cmdWrite = new WriteCommand(_input.LT(-1).getText());
			                    stack.peek().add(cmdWrite);
			                  
			}
			setState(170);
			match(FP);
			setState(171);
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
			setState(174);
			termo();
			 strExpr +=  _input.LT(-1).getText(); 
			setState(176);
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
	public static class FatorContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(GrammarParser.ID, 0); }
		public TerminalNode NUM() { return getToken(GrammarParser.NUM, 0); }
		public TerminalNode TEXTO() { return getToken(GrammarParser.TEXTO, 0); }
		public FatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterFator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitFator(this);
		}
	}

	public final FatorContext fator() throws RecognitionException {
		FatorContext _localctx = new FatorContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_fator);
		try {
			setState(184);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(178);
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
				setState(180);
				match(NUM);

				                    if (rightType == null) {
				                        rightType = Types.NUMBER;
				                    } else {
				                        if (rightType.getValue() < Types.NUMBER.getValue()) {
				                            rightType = Types.NUMBER;
				                        }
				                    }
				                    
				                    UnaryExpression element = new UnaryExpression(Double.parseDouble(_input.LT(-1).getText()));
				                 	stackExpression.push(element);

				                    
				                  
				}
				break;
			case TEXTO:
				enterOuterAlt(_localctx, 3);
				{
				setState(182);
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
		public List<TermoContext> termo() {
			return getRuleContexts(TermoContext.class);
		}
		public TermoContext termo(int i) {
			return getRuleContext(TermoContext.class,i);
		}
		public List<TerminalNode> OP_SUM() { return getTokens(GrammarParser.OP_SUM); }
		public TerminalNode OP_SUM(int i) {
			return getToken(GrammarParser.OP_SUM, i);
		}
		public List<TerminalNode> OP_SUB() { return getTokens(GrammarParser.OP_SUB); }
		public TerminalNode OP_SUB(int i) {
			return getToken(GrammarParser.OP_SUB, i);
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
			setState(193);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OP_SUM || _la==OP_SUB) {
				{
				{
				setState(186);
				_la = _input.LA(1);
				if ( !(_la==OP_SUM || _la==OP_SUB) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}

				                   strExpr += " "+ _input.LT(-1).getText() + " "; 		
				                   	                 
					               BinaryExpression bin = new BinaryExpression(_input.LT(-1).getText().charAt(0));
					               bin.setLeft(stackExpression.pop());
					               stackExpression.push(bin);           
								
				setState(188);
				termo();
				 
				                	strExpr += _input.LT(-1).getText(); 
				                	
				                	AbstractExpression topo = stackExpression.pop(); // desempilhei o termo
						         	BinaryExpression root = (BinaryExpression) stackExpression.pop(); // preciso do componente binário
						         	root.setRight(topo);
						         	stackExpression.push(root);
				                
				                
				}
				}
				setState(195);
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

	@SuppressWarnings("CheckReturnValue")
	public static class TermoContext extends ParserRuleContext {
		public FatorContext fator() {
			return getRuleContext(FatorContext.class,0);
		}
		public TermolContext termol() {
			return getRuleContext(TermolContext.class,0);
		}
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
		enterRule(_localctx, 24, RULE_termo);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(196);
			fator();
			setState(197);
			termol();
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
	public static class TermolContext extends ParserRuleContext {
		public List<FatorContext> fator() {
			return getRuleContexts(FatorContext.class);
		}
		public FatorContext fator(int i) {
			return getRuleContext(FatorContext.class,i);
		}
		public List<TerminalNode> OP_MUL() { return getTokens(GrammarParser.OP_MUL); }
		public TerminalNode OP_MUL(int i) {
			return getToken(GrammarParser.OP_MUL, i);
		}
		public List<TerminalNode> OP_DIV() { return getTokens(GrammarParser.OP_DIV); }
		public TerminalNode OP_DIV(int i) {
			return getToken(GrammarParser.OP_DIV, i);
		}
		public TermolContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_termol; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterTermol(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitTermol(this);
		}
	}

	public final TermolContext termol() throws RecognitionException {
		TermolContext _localctx = new TermolContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_termol);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(206);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OP_MUL || _la==OP_DIV) {
				{
				{
				setState(199);
				_la = _input.LA(1);
				if ( !(_la==OP_MUL || _la==OP_DIV) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}

							 BinaryExpression bin = new BinaryExpression(_input.LT(-1).getText().charAt(0));
							 if (stackExpression.peek() instanceof UnaryExpression) { // o que tem no topo é um operador "simples"
							 	bin.setLeft(stackExpression.pop()); // desempilho já tornando ele filho da multiplicacao
							 }
							 else{
							    BinaryExpression father = (BinaryExpression)stackExpression.pop();
							    if (father.getOperation() == '-' || father.getOperation() == '+'){
							    	bin.setLeft(father.getRight());
							    	father.setRight(bin);
							    }
							    else{
							        bin.setLeft(father);
							        stackExpression.push(bin);			       
							    }
							 }        
				          
				setState(201);
				fator();

				             bin.setRight(stackExpression.pop());
				             stackExpression.push(bin);
				             System.out.println("DEBUG - :" + bin.toJson());
				          
				}
				}
				setState(208);
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
		"\u0004\u0001\u001e\u00d2\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001"+
		"\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004"+
		"\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007"+
		"\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b"+
		"\u0002\f\u0007\f\u0002\r\u0007\r\u0001\u0000\u0001\u0000\u0001\u0000\u0001"+
		"\u0000\u0004\u0000!\b\u0000\u000b\u0000\f\u0000\"\u0001\u0000\u0001\u0000"+
		"\u0004\u0000\'\b\u0000\u000b\u0000\f\u0000(\u0001\u0000\u0001\u0000\u0001"+
		"\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0005\u00016\b\u0001\n\u0001\f\u00019\t"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0003"+
		"\u0001@\b\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0003\u0002K\b"+
		"\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0004\u0003Q\b"+
		"\u0003\u000b\u0003\f\u0003R\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0004\u0004n\b\u0004\u000b"+
		"\u0004\f\u0004o\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0004\u0005\u0081"+
		"\b\u0005\u000b\u0005\f\u0005\u0082\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0004\u0005\u008b\b\u0005\u000b\u0005"+
		"\f\u0005\u008c\u0001\u0005\u0001\u0005\u0001\u0005\u0003\u0005\u0092\b"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b"+
		"\u0001\b\u0001\t\u0001\t\u0001\t\u0001\t\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0001\n\u0003\n\u00b9\b\n\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0005\u000b\u00c0\b\u000b\n\u000b\f\u000b\u00c3"+
		"\t\u000b\u0001\f\u0001\f\u0001\f\u0001\r\u0001\r\u0001\r\u0001\r\u0001"+
		"\r\u0005\r\u00cd\b\r\n\r\f\r\u00d0\t\r\u0001\r\u0000\u0000\u000e\u0000"+
		"\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u0000"+
		"\u0002\u0001\u0000\u000e\u000f\u0001\u0000\u0010\u0011\u00d5\u0000\u001c"+
		"\u0001\u0000\u0000\u0000\u0002.\u0001\u0000\u0000\u0000\u0004J\u0001\u0000"+
		"\u0000\u0000\u0006L\u0001\u0000\u0000\u0000\bb\u0001\u0000\u0000\u0000"+
		"\nu\u0001\u0000\u0000\u0000\f\u0095\u0001\u0000\u0000\u0000\u000e\u009e"+
		"\u0001\u0000\u0000\u0000\u0010\u00a5\u0001\u0000\u0000\u0000\u0012\u00ae"+
		"\u0001\u0000\u0000\u0000\u0014\u00b8\u0001\u0000\u0000\u0000\u0016\u00c1"+
		"\u0001\u0000\u0000\u0000\u0018\u00c4\u0001\u0000\u0000\u0000\u001a\u00ce"+
		"\u0001\u0000\u0000\u0000\u001c\u001d\u0005\u0001\u0000\u0000\u001d\u001e"+
		"\u0005\u0014\u0000\u0000\u001e \u0006\u0000\uffff\uffff\u0000\u001f!\u0003"+
		"\u0002\u0001\u0000 \u001f\u0001\u0000\u0000\u0000!\"\u0001\u0000\u0000"+
		"\u0000\" \u0001\u0000\u0000\u0000\"#\u0001\u0000\u0000\u0000#$\u0001\u0000"+
		"\u0000\u0000$&\u0005\u0002\u0000\u0000%\'\u0003\u0004\u0002\u0000&%\u0001"+
		"\u0000\u0000\u0000\'(\u0001\u0000\u0000\u0000(&\u0001\u0000\u0000\u0000"+
		"()\u0001\u0000\u0000\u0000)*\u0001\u0000\u0000\u0000*+\u0005\u0003\u0000"+
		"\u0000+,\u0005\u0004\u0000\u0000,-\u0006\u0000\uffff\uffff\u0000-\u0001"+
		"\u0001\u0000\u0000\u0000./\u0005\u0005\u0000\u0000/0\u0006\u0001\uffff"+
		"\uffff\u000001\u0005\u0014\u0000\u000017\u0006\u0001\uffff\uffff\u0000"+
		"23\u0005\u0017\u0000\u000034\u0005\u0014\u0000\u000046\u0006\u0001\uffff"+
		"\uffff\u000052\u0001\u0000\u0000\u000069\u0001\u0000\u0000\u000075\u0001"+
		"\u0000\u0000\u000078\u0001\u0000\u0000\u00008:\u0001\u0000\u0000\u0000"+
		"97\u0001\u0000\u0000\u0000:?\u0005\u0019\u0000\u0000;<\u0005\u0006\u0000"+
		"\u0000<@\u0006\u0001\uffff\uffff\u0000=>\u0005\u0007\u0000\u0000>@\u0006"+
		"\u0001\uffff\uffff\u0000?;\u0001\u0000\u0000\u0000?=\u0001\u0000\u0000"+
		"\u0000@A\u0001\u0000\u0000\u0000AB\u0006\u0001\uffff\uffff\u0000BC\u0005"+
		"\u0018\u0000\u0000C\u0003\u0001\u0000\u0000\u0000DK\u0003\f\u0006\u0000"+
		"EK\u0003\u000e\u0007\u0000FK\u0003\u0010\b\u0000GK\u0003\n\u0005\u0000"+
		"HK\u0003\b\u0004\u0000IK\u0003\u0006\u0003\u0000JD\u0001\u0000\u0000\u0000"+
		"JE\u0001\u0000\u0000\u0000JF\u0001\u0000\u0000\u0000JG\u0001\u0000\u0000"+
		"\u0000JH\u0001\u0000\u0000\u0000JI\u0001\u0000\u0000\u0000K\u0005\u0001"+
		"\u0000\u0000\u0000LM\u0005\b\u0000\u0000MN\u0006\u0003\uffff\uffff\u0000"+
		"NP\u0005\u001c\u0000\u0000OQ\u0003\u0004\u0002\u0000PO\u0001\u0000\u0000"+
		"\u0000QR\u0001\u0000\u0000\u0000RP\u0001\u0000\u0000\u0000RS\u0001\u0000"+
		"\u0000\u0000ST\u0001\u0000\u0000\u0000TU\u0006\u0003\uffff\uffff\u0000"+
		"UV\u0005\u001d\u0000\u0000VW\u0005\t\u0000\u0000WX\u0005\u001a\u0000\u0000"+
		"XY\u0003\u0012\t\u0000YZ\u0006\u0003\uffff\uffff\u0000Z[\u0005\u0013\u0000"+
		"\u0000[\\\u0006\u0003\uffff\uffff\u0000\\]\u0003\u0012\t\u0000]^\u0006"+
		"\u0003\uffff\uffff\u0000^_\u0005\u001b\u0000\u0000_`\u0005\u0018\u0000"+
		"\u0000`a\u0006\u0003\uffff\uffff\u0000a\u0007\u0001\u0000\u0000\u0000"+
		"bc\u0005\t\u0000\u0000cd\u0006\u0004\uffff\uffff\u0000de\u0005\u001a\u0000"+
		"\u0000ef\u0003\u0012\t\u0000fg\u0005\u0013\u0000\u0000gh\u0006\u0004\uffff"+
		"\uffff\u0000hi\u0003\u0012\t\u0000ij\u0005\u001b\u0000\u0000jk\u0006\u0004"+
		"\uffff\uffff\u0000km\u0005\u001c\u0000\u0000ln\u0003\u0004\u0002\u0000"+
		"ml\u0001\u0000\u0000\u0000no\u0001\u0000\u0000\u0000om\u0001\u0000\u0000"+
		"\u0000op\u0001\u0000\u0000\u0000pq\u0001\u0000\u0000\u0000qr\u0006\u0004"+
		"\uffff\uffff\u0000rs\u0005\u001d\u0000\u0000st\u0006\u0004\uffff\uffff"+
		"\u0000t\t\u0001\u0000\u0000\u0000uv\u0005\n\u0000\u0000vw\u0006\u0005"+
		"\uffff\uffff\u0000wx\u0005\u001a\u0000\u0000xy\u0003\u0012\t\u0000yz\u0005"+
		"\u0013\u0000\u0000z{\u0006\u0005\uffff\uffff\u0000{|\u0003\u0012\t\u0000"+
		"|}\u0005\u001b\u0000\u0000}~\u0006\u0005\uffff\uffff\u0000~\u0080\u0005"+
		"\u001c\u0000\u0000\u007f\u0081\u0003\u0004\u0002\u0000\u0080\u007f\u0001"+
		"\u0000\u0000\u0000\u0081\u0082\u0001\u0000\u0000\u0000\u0082\u0080\u0001"+
		"\u0000\u0000\u0000\u0082\u0083\u0001\u0000\u0000\u0000\u0083\u0084\u0001"+
		"\u0000\u0000\u0000\u0084\u0085\u0006\u0005\uffff\uffff\u0000\u0085\u0091"+
		"\u0005\u001d\u0000\u0000\u0086\u0087\u0005\u000b\u0000\u0000\u0087\u0088"+
		"\u0006\u0005\uffff\uffff\u0000\u0088\u008a\u0005\u001c\u0000\u0000\u0089"+
		"\u008b\u0003\u0004\u0002\u0000\u008a\u0089\u0001\u0000\u0000\u0000\u008b"+
		"\u008c\u0001\u0000\u0000\u0000\u008c\u008a\u0001\u0000\u0000\u0000\u008c"+
		"\u008d\u0001\u0000\u0000\u0000\u008d\u008e\u0001\u0000\u0000\u0000\u008e"+
		"\u008f\u0006\u0005\uffff\uffff\u0000\u008f\u0090\u0005\u001d\u0000\u0000"+
		"\u0090\u0092\u0001\u0000\u0000\u0000\u0091\u0086\u0001\u0000\u0000\u0000"+
		"\u0091\u0092\u0001\u0000\u0000\u0000\u0092\u0093\u0001\u0000\u0000\u0000"+
		"\u0093\u0094\u0006\u0005\uffff\uffff\u0000\u0094\u000b\u0001\u0000\u0000"+
		"\u0000\u0095\u0096\u0005\u0014\u0000\u0000\u0096\u0097\u0006\u0006\uffff"+
		"\uffff\u0000\u0097\u0098\u0005\u0012\u0000\u0000\u0098\u0099\u0006\u0006"+
		"\uffff\uffff\u0000\u0099\u009a\u0003\u0012\t\u0000\u009a\u009b\u0006\u0006"+
		"\uffff\uffff\u0000\u009b\u009c\u0005\u0018\u0000\u0000\u009c\u009d\u0006"+
		"\u0006\uffff\uffff\u0000\u009d\r\u0001\u0000\u0000\u0000\u009e\u009f\u0005"+
		"\f\u0000\u0000\u009f\u00a0\u0005\u001a\u0000\u0000\u00a0\u00a1\u0005\u0014"+
		"\u0000\u0000\u00a1\u00a2\u0006\u0007\uffff\uffff\u0000\u00a2\u00a3\u0005"+
		"\u001b\u0000\u0000\u00a3\u00a4\u0005\u0018\u0000\u0000\u00a4\u000f\u0001"+
		"\u0000\u0000\u0000\u00a5\u00a6\u0005\r\u0000\u0000\u00a6\u00a7\u0005\u001a"+
		"\u0000\u0000\u00a7\u00a8\u0003\u0018\f\u0000\u00a8\u00a9\u0006\b\uffff"+
		"\uffff\u0000\u00a9\u00aa\u0001\u0000\u0000\u0000\u00aa\u00ab\u0005\u001b"+
		"\u0000\u0000\u00ab\u00ac\u0005\u0018\u0000\u0000\u00ac\u00ad\u0006\b\uffff"+
		"\uffff\u0000\u00ad\u0011\u0001\u0000\u0000\u0000\u00ae\u00af\u0003\u0018"+
		"\f\u0000\u00af\u00b0\u0006\t\uffff\uffff\u0000\u00b0\u00b1\u0003\u0016"+
		"\u000b\u0000\u00b1\u0013\u0001\u0000\u0000\u0000\u00b2\u00b3\u0005\u0014"+
		"\u0000\u0000\u00b3\u00b9\u0006\n\uffff\uffff\u0000\u00b4\u00b5\u0005\u0015"+
		"\u0000\u0000\u00b5\u00b9\u0006\n\uffff\uffff\u0000\u00b6\u00b7\u0005\u001e"+
		"\u0000\u0000\u00b7\u00b9\u0006\n\uffff\uffff\u0000\u00b8\u00b2\u0001\u0000"+
		"\u0000\u0000\u00b8\u00b4\u0001\u0000\u0000\u0000\u00b8\u00b6\u0001\u0000"+
		"\u0000\u0000\u00b9\u0015\u0001\u0000\u0000\u0000\u00ba\u00bb\u0007\u0000"+
		"\u0000\u0000\u00bb\u00bc\u0006\u000b\uffff\uffff\u0000\u00bc\u00bd\u0003"+
		"\u0018\f\u0000\u00bd\u00be\u0006\u000b\uffff\uffff\u0000\u00be\u00c0\u0001"+
		"\u0000\u0000\u0000\u00bf\u00ba\u0001\u0000\u0000\u0000\u00c0\u00c3\u0001"+
		"\u0000\u0000\u0000\u00c1\u00bf\u0001\u0000\u0000\u0000\u00c1\u00c2\u0001"+
		"\u0000\u0000\u0000\u00c2\u0017\u0001\u0000\u0000\u0000\u00c3\u00c1\u0001"+
		"\u0000\u0000\u0000\u00c4\u00c5\u0003\u0014\n\u0000\u00c5\u00c6\u0003\u001a"+
		"\r\u0000\u00c6\u0019\u0001\u0000\u0000\u0000\u00c7\u00c8\u0007\u0001\u0000"+
		"\u0000\u00c8\u00c9\u0006\r\uffff\uffff\u0000\u00c9\u00ca\u0003\u0014\n"+
		"\u0000\u00ca\u00cb\u0006\r\uffff\uffff\u0000\u00cb\u00cd\u0001\u0000\u0000"+
		"\u0000\u00cc\u00c7\u0001\u0000\u0000\u0000\u00cd\u00d0\u0001\u0000\u0000"+
		"\u0000\u00ce\u00cc\u0001\u0000\u0000\u0000\u00ce\u00cf\u0001\u0000\u0000"+
		"\u0000\u00cf\u001b\u0001\u0000\u0000\u0000\u00d0\u00ce\u0001\u0000\u0000"+
		"\u0000\r\"(7?JRo\u0082\u008c\u0091\u00b8\u00c1\u00ce";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
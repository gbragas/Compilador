// Generated from Grammar.g4 by ANTLR 4.13.2
package io.compiler.core;

    import java.util.ArrayList;
    import io.compiler.types.*;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class GrammarLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.13.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, OP=6, ID=7, NUM=8, WS=9, VG=10, 
		PV=11, DP=12;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "OP", "ID", "NUM", "WS", "VG", 
			"PV", "DP"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'programa'", "'fimprog'", "'declare'", "'number'", "'text'", null, 
			null, null, null, "','", "';'", "':'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, "OP", "ID", "NUM", "WS", "VG", "PV", 
			"DP"
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


	    private ArrayList<Var> varList = new ArrayList<Var>();
	    private ArrayList<Var> currentDecl = new ArrayList<Var>();
	    private Types currentType;

	    public void updateType() {
	        for (Var v: currentDecl) {
	            v.setType(currentType);
	            varList.add(v);
	        }
	    }

	    public void getVars() {
	        for (Var v: varList) {
	            System.out.println(v);
	        }
	    }


	public GrammarLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Grammar.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\u0004\u0000\f^\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002\u0001"+
		"\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004"+
		"\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007"+
		"\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b"+
		"\u0007\u000b\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006"+
		"\u0005\u0006C\b\u0006\n\u0006\f\u0006F\t\u0006\u0001\u0007\u0004\u0007"+
		"I\b\u0007\u000b\u0007\f\u0007J\u0001\u0007\u0001\u0007\u0004\u0007O\b"+
		"\u0007\u000b\u0007\f\u0007P\u0003\u0007S\b\u0007\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0001\t\u0001\t\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0000"+
		"\u0000\f\u0001\u0001\u0003\u0002\u0005\u0003\u0007\u0004\t\u0005\u000b"+
		"\u0006\r\u0007\u000f\b\u0011\t\u0013\n\u0015\u000b\u0017\f\u0001\u0000"+
		"\u0005\u0003\u0000*+--//\u0001\u0000az\u0003\u000009AZaz\u0001\u00000"+
		"9\u0003\u0000\t\n\r\r  a\u0000\u0001\u0001\u0000\u0000\u0000\u0000\u0003"+
		"\u0001\u0000\u0000\u0000\u0000\u0005\u0001\u0000\u0000\u0000\u0000\u0007"+
		"\u0001\u0000\u0000\u0000\u0000\t\u0001\u0000\u0000\u0000\u0000\u000b\u0001"+
		"\u0000\u0000\u0000\u0000\r\u0001\u0000\u0000\u0000\u0000\u000f\u0001\u0000"+
		"\u0000\u0000\u0000\u0011\u0001\u0000\u0000\u0000\u0000\u0013\u0001\u0000"+
		"\u0000\u0000\u0000\u0015\u0001\u0000\u0000\u0000\u0000\u0017\u0001\u0000"+
		"\u0000\u0000\u0001\u0019\u0001\u0000\u0000\u0000\u0003\"\u0001\u0000\u0000"+
		"\u0000\u0005*\u0001\u0000\u0000\u0000\u00072\u0001\u0000\u0000\u0000\t"+
		"9\u0001\u0000\u0000\u0000\u000b>\u0001\u0000\u0000\u0000\r@\u0001\u0000"+
		"\u0000\u0000\u000fH\u0001\u0000\u0000\u0000\u0011T\u0001\u0000\u0000\u0000"+
		"\u0013X\u0001\u0000\u0000\u0000\u0015Z\u0001\u0000\u0000\u0000\u0017\\"+
		"\u0001\u0000\u0000\u0000\u0019\u001a\u0005p\u0000\u0000\u001a\u001b\u0005"+
		"r\u0000\u0000\u001b\u001c\u0005o\u0000\u0000\u001c\u001d\u0005g\u0000"+
		"\u0000\u001d\u001e\u0005r\u0000\u0000\u001e\u001f\u0005a\u0000\u0000\u001f"+
		" \u0005m\u0000\u0000 !\u0005a\u0000\u0000!\u0002\u0001\u0000\u0000\u0000"+
		"\"#\u0005f\u0000\u0000#$\u0005i\u0000\u0000$%\u0005m\u0000\u0000%&\u0005"+
		"p\u0000\u0000&\'\u0005r\u0000\u0000\'(\u0005o\u0000\u0000()\u0005g\u0000"+
		"\u0000)\u0004\u0001\u0000\u0000\u0000*+\u0005d\u0000\u0000+,\u0005e\u0000"+
		"\u0000,-\u0005c\u0000\u0000-.\u0005l\u0000\u0000./\u0005a\u0000\u0000"+
		"/0\u0005r\u0000\u000001\u0005e\u0000\u00001\u0006\u0001\u0000\u0000\u0000"+
		"23\u0005n\u0000\u000034\u0005u\u0000\u000045\u0005m\u0000\u000056\u0005"+
		"b\u0000\u000067\u0005e\u0000\u000078\u0005r\u0000\u00008\b\u0001\u0000"+
		"\u0000\u00009:\u0005t\u0000\u0000:;\u0005e\u0000\u0000;<\u0005x\u0000"+
		"\u0000<=\u0005t\u0000\u0000=\n\u0001\u0000\u0000\u0000>?\u0007\u0000\u0000"+
		"\u0000?\f\u0001\u0000\u0000\u0000@D\u0007\u0001\u0000\u0000AC\u0007\u0002"+
		"\u0000\u0000BA\u0001\u0000\u0000\u0000CF\u0001\u0000\u0000\u0000DB\u0001"+
		"\u0000\u0000\u0000DE\u0001\u0000\u0000\u0000E\u000e\u0001\u0000\u0000"+
		"\u0000FD\u0001\u0000\u0000\u0000GI\u0007\u0003\u0000\u0000HG\u0001\u0000"+
		"\u0000\u0000IJ\u0001\u0000\u0000\u0000JH\u0001\u0000\u0000\u0000JK\u0001"+
		"\u0000\u0000\u0000KR\u0001\u0000\u0000\u0000LN\u0005.\u0000\u0000MO\u0007"+
		"\u0003\u0000\u0000NM\u0001\u0000\u0000\u0000OP\u0001\u0000\u0000\u0000"+
		"PN\u0001\u0000\u0000\u0000PQ\u0001\u0000\u0000\u0000QS\u0001\u0000\u0000"+
		"\u0000RL\u0001\u0000\u0000\u0000RS\u0001\u0000\u0000\u0000S\u0010\u0001"+
		"\u0000\u0000\u0000TU\u0007\u0004\u0000\u0000UV\u0001\u0000\u0000\u0000"+
		"VW\u0006\b\u0000\u0000W\u0012\u0001\u0000\u0000\u0000XY\u0005,\u0000\u0000"+
		"Y\u0014\u0001\u0000\u0000\u0000Z[\u0005;\u0000\u0000[\u0016\u0001\u0000"+
		"\u0000\u0000\\]\u0005:\u0000\u0000]\u0018\u0001\u0000\u0000\u0000\u0006"+
		"\u0000BDJPR\u0001\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
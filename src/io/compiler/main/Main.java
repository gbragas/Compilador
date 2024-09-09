package io.compiler.main;

import io.compiler.core.GrammarLexer;
import io.compiler.core.GrammarParser;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

public class Main {
    public static void main(String[] args) {
        try {
            GrammarLexer lexer;
            GrammarParser parser;

            lexer = new GrammarLexer(CharStreams.fromFileName("input.in"));

            CommonTokenStream tokens = new CommonTokenStream(lexer);

            parser = new GrammarParser(tokens);

            System.out.println("BraPa Compiler");
            parser.programa();
            System.out.println("Compilation Successfully - Boaa");
            parser.getVars();

        }
        catch (Exception ex) {
            System.err.println("Error: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
}
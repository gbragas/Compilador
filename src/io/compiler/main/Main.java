package io.compiler.main;

import io.compiler.core.GrammarLexer;
import io.compiler.core.GrammarParser;
import io.compiler.core.ast.Program;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

public class Main {
    public static void main(String[] args) {
        try {
            GrammarLexer lexer;
            GrammarParser parser;

            lexer = new GrammarLexer(CharStreams.fromFileName("program.in"));

            CommonTokenStream tokens = new CommonTokenStream(lexer);

            parser = new GrammarParser(tokens);

            System.out.println("BraLuPa Compiler");
            parser.programa();
            System.out.println("Compilation Successfully - Boaa");
            //parser.getVars();

            Program program = parser.getProgram();

            System.out.println(program.generateTarget());
            

            try {
                File f = new File(program.getName()+".java");
                FileWriter fw = new FileWriter(f);
                PrintWriter pw = new PrintWriter(fw);
                pw.println(program.generateTarget());
                pw.close();

            } catch (Exception e) {
                e.printStackTrace();
            }
                        
            System.out.println(program.generatePythonCode());
            try {
                File f = new File(program.getName()+".py");
                FileWriter fw = new FileWriter(f);
                PrintWriter pw = new PrintWriter(fw);
                pw.println(program.generatePythonCode());
                pw.close();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        catch (Exception ex) {
            System.err.println("Error: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
}
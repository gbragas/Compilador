package io.compiler.runtime;

import java.util.HashMap;

import io.compiler.core.ast.Command;
import io.compiler.types.Var;

import java.util.List;

public class Runtime {
    private HashMap<String, Var> symbolTable;
    private List<Command> commands;

    public Runtime(HashMap<String, Var> symbolTable, List<Command> commands) {
        this.symbolTable = symbolTable;
        this.commands = commands;
    }

    public void run() {
        for (Command cmd : commands) {
            cmd.execute(new Context(symbolTable));
        }
    }
}

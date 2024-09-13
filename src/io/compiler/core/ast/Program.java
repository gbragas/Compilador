package io.compiler.core.ast;

import io.compiler.types.Types;
import io.compiler.types.Var;
import java.util.HashMap;
import java.util.List;

public class Program {
    private String name;
    private HashMap<String, Var> symbolTable;
    private List<Command> commandList;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HashMap<String, Var> getSymbolTable() {
        return symbolTable;
    }

    public void setSymbolTable(HashMap<String, Var> symbolTable) {
        this.symbolTable = symbolTable;
    }

    public List<Command> getCommandList() {
        return commandList;
    }

    public void setCommandList(List<Command> commandList) {
        this.commandList = commandList;
    }

    public String generateTarget() {
        StringBuilder str = new StringBuilder();
        str.append("import java.util.Scanner;\n");
        str.append("public class ").append(name).append(" {\n");
        str.append("    public static void main(String[] args) {\n");
        str.append("        Scanner _scTrx = new Scanner(System.in);\n");
        for (String varId : symbolTable.keySet()) {
            Var var = symbolTable.get(varId);
            str.append("        ");
            if (var.getType() == Types.NUMBER) {
                str.append("int ");
            } else {
                str.append("String ");
            }
            str.append(var.getId()).append(";\n");
        }

        for (Command command : commandList) {
            str.append("        ").append(command.generateTarget());
        }
        str.append("    }\n");
        str.append("}");

        return str.toString();
    }
    
    
    public String generatePythonCode() {
        StringBuilder str = new StringBuilder();
        str.append("# Código Python gerado\n\n");
        str.append("def main():\n");
        for (String varId : symbolTable.keySet()) {
            Var var = symbolTable.get(varId);
            str.append("    ");
            if (var.getType() == Types.NUMBER) {
                str.append(var.getId()).append(" = 0\n");  // Inicializa variáveis numéricas com 0
            } else {
                str.append(var.getId()).append(" = ''\n");  // Inicializa variáveis de texto com string vazia
            }
        }

        for (Command command : commandList) {
            str.append("    ").append(command.generatePythonCode());
        }
        str.append("\nif __name__ == '__main__':\n");
        str.append("    main()\n");

        return str.toString();
    }
}

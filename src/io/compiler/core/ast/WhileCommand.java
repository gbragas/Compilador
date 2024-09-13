package io.compiler.core.ast;

import java.util.ArrayList;
import java.util.List;

import io.compiler.runtime.Context;

public class WhileCommand extends Command {

    private String expressionL;
    private String expressionR;
    private String operation;
    private List<Command> commandList;

    public WhileCommand(String expressionL, String expressionR, String operation, List<Command> commandList) {
        super();
        this.expressionL = expressionL;
        this.expressionR = expressionR;
        this.operation = operation;
        this.commandList = commandList;
    }

    public WhileCommand() {
        super();
        this.expressionL = "";
        this.expressionR = "";
        this.operation = "";
        this.commandList = new ArrayList<>();
    }

    public String getExpressionL() {
        return expressionL;
    }

    public void setExpressionL(String expressionL) {
        this.expressionL = expressionL;
    }

    public String getExpressionR() {
        return expressionR;
    }

    public void setExpressionR(String expressionR) {
        this.expressionR = expressionR;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public List<Command> getCommandList() {
        return commandList;
    }

    public void setCommandList(List<Command> commandList) {
        this.commandList = commandList;
    }

    @Override
    public String generateTarget() {
        StringBuilder str = new StringBuilder();
        str.append("while (").append(expressionL).append(operation).append(expressionR).append(") {\n");

        for (Command cmd : commandList) {
            str.append("            ").append(cmd.generateTarget());
        }
        str.append("        }\n");

        return str.toString();
    }
    
    @Override
    public String generatePythonCode() {
        StringBuilder str = new StringBuilder();
        str.append("while ").append(expressionL).append(operation).append(expressionR).append(":\n");

        for (Command cmd : commandList) {
            str.append("        ").append(cmd.generatePythonCode());
        }

        return str.toString();
    }

    @Override
    public void execute(Context context) {
        while (evaluateCondition(context)) {
            for (Command cmd : commandList) {
                cmd.execute(context);
            }
        }
    }

    private boolean evaluateCondition(Context context) {
        double leftValue = (double) context.evaluateExpression(expressionL); 
        double rightValue = (double) context.evaluateExpression(expressionR); 
        
        switch (operation.strip()) {
            case "==": return leftValue == rightValue;
            case "!=": return leftValue != rightValue;
            case ">": return leftValue > rightValue;
            case "<": return leftValue < rightValue;
            case ">=": return leftValue >= rightValue;
            case "<=": return leftValue <= rightValue;
            default: throw new RuntimeException("Operação desconhecida: " + operation);
        }
    }
}

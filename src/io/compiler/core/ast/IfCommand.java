package io.compiler.core.ast;

import java.util.ArrayList;
import java.util.List;

import io.compiler.runtime.Context;

public class IfCommand extends Command {

    private String expressionL;
    private String expressionR;
    private String operation;
    private List<Command> trueList;
    private List<Command> falseList;

    public IfCommand(String expressionL, String expressionR, String operation, List<Command> trueList, List<Command> falseList) {
        super();
        this.expressionL = expressionL;
        this.expressionR = expressionR;
        this.operation = operation;
        this.trueList = trueList;
        this.falseList = falseList;
    }

    public IfCommand() {
        super();
        this.expressionL = "";
        this.expressionR = "";
        this.operation = "";
        this.trueList = new ArrayList<>();
        this.falseList = new ArrayList<>();
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

    public List<Command> getTrueList() {
        return trueList;
    }

    public void setTrueList(List<Command> trueList) {
        this.trueList = trueList;
    }

    public List<Command> getFalseList() {
        return falseList;
    }

    public void setFalseList(List<Command> falseList) {
        this.falseList = falseList;
    }

    @Override
    public String generateTarget() {
        StringBuilder str = new StringBuilder();
        str.append("if (").append(expressionL).append(" ").append(operation).append(" ").append(expressionR).append(") {\n");

        for (Command cmd : trueList) {
            str.append("            ").append(cmd.generateTarget()).append("\n");
        }
        str.append("        }\n");

        if (!falseList.isEmpty()) {
        	str.append("        ");
            str.append("else {\n");
            for (Command cmd : falseList) {
                str.append("            ").append(cmd.generateTarget()).append("\n");
            }
            str.append("        }\n");
        }

        return str.toString();
    }

    @Override
    public String generatePythonCode() {
        StringBuilder str = new StringBuilder();
        str.append("if ").append(expressionL).append(" ").append(operation).append(" ").append(expressionR).append(":\n");

        for (Command cmd : trueList) {
            str.append("        ").append(cmd.generatePythonCode()).append("\n");
        }

        if (!falseList.isEmpty()) {
            str.append("    else:\n");
            for (Command cmd : falseList) {
                str.append("        ").append(cmd.generatePythonCode()).append("\n");
            }
        }

        return str.toString();
    }

    @Override
    public void execute(Context context) {
        if (evaluateCondition(context)) {
            for (Command cmd : trueList) {
                cmd.execute(context);
            }
        } else if (!falseList.isEmpty()) {
            for (Command cmd : falseList) {
                cmd.execute(context);
            }
        }
    }

    private boolean evaluateCondition(Context context) {
        // Avalia a condição lógica
        double leftValue = (double) context.evaluateExpression(expressionL);
        double rightValue = (double) context.evaluateExpression(expressionR);

        switch (operation) {
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

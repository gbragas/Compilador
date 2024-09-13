package io.compiler.core.ast;

import java.util.ArrayList;
import java.util.List;

public class IfCommand extends Command {

    private String expression;
    private List<Command> trueList;
    private List<Command> falseList;

    public IfCommand(String expression, List<Command> trueList, List<Command> falseList) {
        super();
        this.expression = expression;
        this.trueList = trueList;
        this.falseList = falseList;
    }

    public IfCommand() {
        super();
        this.expression = "";
        this.trueList = new ArrayList<Command>();
        this.falseList = new ArrayList<Command>();
    }

    public String getExpression() {
        return expression;
    }

    public void setExpression(String expression) {
        this.expression = expression;
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
        str.append("if (").append(expression).append(") {\n");

        for (Command cmd : trueList) {
            str.append("            ").append(cmd.generateTarget());
        }
        str.append("        }\n");

        if (!falseList.isEmpty()) {
            str.append("        ");
            str.append("else {\n");
            str.append("            ");
            for (Command cmd : falseList) {
                str.append("            ").append(cmd.generateTarget());
            }
            str.append("        }\n");
        }

        return str.toString();
    }

    @Override
    public String generatePythonCode() {
        StringBuilder str = new StringBuilder();
        str.append("if ").append(expression).append(":\n");

        for (Command cmd : trueList) {
            str.append("        ").append(cmd.generatePythonCode());
        }

        if (!falseList.isEmpty()) {
            str.append("    else:\n");
            for (Command cmd : falseList) {
                str.append("        ").append(cmd.generatePythonCode());
            }
        }

        return str.toString();
    }
}

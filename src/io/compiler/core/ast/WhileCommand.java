package io.compiler.core.ast;

import java.util.ArrayList;
import java.util.List;

public class WhileCommand extends Command {

	private String expression;
	private List<Command> commandList;

	public WhileCommand(String expression, List<Command> commandList) {
		super();
		this.expression = expression;
		this.commandList = commandList;
	}
	public WhileCommand() {
		super();
	}

	public String getExpression() {
		return expression;
	}

	public void setExpression(String expression) {
		this.expression = expression;
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
		str.append("while (").append(expression).append(") {\n");
		

		for (Command cmd : commandList) {
			str.append("            ").append(cmd.generateTarget());
		}
		str.append("        }\n");

		return str.toString();
	}
	
	@Override
	public String generatePythonCode() {
	    StringBuilder str = new StringBuilder();
	    str.append("while ").append(expression).append(":\n");

	    for (Command cmd : commandList) {
	        str.append("        ").append(cmd.generatePythonCode());
	    }

	    return str.toString();
	}
}

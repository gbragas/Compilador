package io.compiler.core.ast;

import java.util.List;

public class DoWhileCommand extends Command {

	private String expressionL;
	private String expressionR;
	private String operation;
	private List<Command> commandList;
	
	
	
	
	
	public DoWhileCommand(String expressiL, String expressiR, String operation, List<Command> commandList) {
		super();
		this.expressionL = expressiL;
		this.expressionR = expressiR;
		this.operation = operation;
		this.commandList = commandList;
	}



	public DoWhileCommand() {
		super();
	}

	

	public String getExpressiL() {
		return expressionL;
	}



	public void setExpressiL(String expressiL) {
		this.expressionL = expressiL;
	}



	public String getExpressiR() {
		return expressionR;
	}



	public void setExpressiR(String expressiR) {
		this.expressionR = expressiR;
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
		str.append("do {\n");
		

		for (Command cmd : commandList) {
			str.append("            ").append(cmd.generateTarget());
		}
		str.append("        } while (").append(expressionL).append(operation).append(expressionR).append("); \n");

		return str.toString();
	}
	
	@Override
	 public String generatePythonCode() {
        StringBuilder str = new StringBuilder();

        str.append("while True:\n");
        for (Command cmd : commandList) {
            str.append("        ").append(cmd.generatePythonCode());
        }
        str.append("        if not (").append(expressionL).append(operation).append(expressionR).append("):\n");
        str.append("            break\n");

        return str.toString();
    }
}

package io.compiler.core.ast;

public class AttributionCommand extends Command {

    private String variable;
    private String operation;
    private String value;
    
    public AttributionCommand(String variable, String operation, String value) {
		super();
		this.variable = variable;
		this.operation = operation;
		this.value = value;
	}

	public AttributionCommand() {
        super();
    }

    public String getVariable() {
        return variable;
    }

    public void setVariable(String variable) {
        this.variable = variable;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String generateTarget() {
        return variable + " " + operation + " " + value + ";\n";
    }

    @Override
	public String generatePythonCode() {
    	return variable + " " + operation + " " + value + "\n";
	}
}

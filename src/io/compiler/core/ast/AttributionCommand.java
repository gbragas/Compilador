package io.compiler.core.ast;

import io.compiler.runtime.Context;
import io.compiler.types.Types;
import io.compiler.types.Var;

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

    @Override
    public void execute(Context context) {
        // Verifica se a variável existe no contexto
        if (context.containsVariable(variable)) {
            Var var = context.getVariable(variable);
            
            // avalia valor a ser atribuído
            Object evaluatedValue = context.evaluateExpression(value);
            
           
            if (var.getType() == Types.NUMBER && evaluatedValue instanceof Double) {
                var.setId(String.valueOf(evaluatedValue));
            } else if (var.getType() == Types.TEXT && evaluatedValue instanceof String) {
                var.setId((String) evaluatedValue);
            } else {
                throw new RuntimeException("Tipo de valor incompatível com o tipo da variável.");
            }
            System.out.println("VARIAVEL: "+variable+ " valor: "+ value + " ATRIBUIDA"+var.getId());
        } else {
            throw new RuntimeException("Variável '" + variable + "' não declarada.");
        }
        

    }
}

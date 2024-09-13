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

    public void execute(Context context) {

    	if (context.containsVariable(variable)) {
            Var var = context.getVariable(variable);

            // Avalia o valor a ser atribuído
            Object evaluatedValue = context.evaluateExpression(value);

            //  tipo da variável e aplica a operação adequada
            if (var.getType() == Types.NUMBER) {
                if (evaluatedValue instanceof Double) {
                    double newValue = (Double) evaluatedValue;
                    
                    // verif a operação
                    switch (operation) {
                        case "=":
                            var.setValue(String.valueOf(newValue));
                            break;
                        case "+=":
                            double currentValue = Double.parseDouble(var.getValue());
                            var.setValue(String.valueOf(currentValue + newValue));
                            break;
                        case "-=":
                            currentValue = Double.parseDouble(var.getValue());
                            var.setValue(String.valueOf(currentValue - newValue));
                            break;
                        case "*=":
                            currentValue = Double.parseDouble(var.getValue());
                            var.setValue(String.valueOf(currentValue * newValue));
                            break;
                        case "/=":
                            if (newValue != 0) {
                                currentValue = Double.parseDouble(var.getValue());
                                var.setValue(String.valueOf(currentValue / newValue));
                            } else {
                                throw new RuntimeException("Divisão por zero não permitida.");
                            }
                            break;
                        default:
                            throw new RuntimeException("Operação inválida: " + operation);
                    }
                } else {
                    throw new RuntimeException("Valor avaliado não é um número válido para tipo NUMBER.");
                }
            } else if (var.getType() == Types.TEXT) {
                if (evaluatedValue instanceof String) {
                	
                    // string aceita apenas operacáco "="
                	
                    if (operation.equals("=")) {
                        var.setValue((String) evaluatedValue);
                        
                    } else {
                        throw new RuntimeException("Operação inválida para tipo de texto: " + operation);
                    }
                } else {
                    throw new RuntimeException("Valor avaliado não é uma string válida para tipo TEXT.");
                }
            } else {
                throw new RuntimeException("Tipo de valor incompatível com o tipo da variável.");
            }

            //System.out.println("VARIÁVEL: " + variable + " valor: " + value + " ATRIBUIDA " + var.getValue());
        } else {
            throw new RuntimeException("Variável '" + variable + "' não declarada.");
        }
    }


}


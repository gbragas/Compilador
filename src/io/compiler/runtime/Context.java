package io.compiler.runtime;

import java.util.HashMap;

import io.compiler.types.Types;
import io.compiler.types.Var;

public class Context {
    private HashMap<String, Var> symbolTable;

    public Context(HashMap<String, Var> symbolTable) {
        this.symbolTable = symbolTable;
    }

    public Var getVariable(String id) {
        return symbolTable.get(id);
    }

    public boolean containsVariable(String id) {
        return symbolTable.containsKey(id);
    }

	

    public Object evaluateExpression(String expression) {
        

        try {
            
            return Double.parseDouble(expression);
            
        } catch (NumberFormatException e) {
        	
            // se der ruim, é variavel
            if (containsVariable(expression)) {
                Var var = getVariable(expression);
                if (var.getType() == Types.NUMBER && var.isInitialized()) {
                	
                    // tipo NUMERO inicializada
                    return Double.parseDouble(var.getId());
                    
                } else if (var.getType() == Types.TEXT && var.isInitialized()) {
                	
                    // tipo TEXT inicializada
                    Object value = var.getId();
                    return (value != null) ? value.toString() : "";
                } else {
                    throw new RuntimeException("Variável '" + expression + "' não inicializada ou tipo incompatível.");
                }
                
            } else {
                //  expressão original se a variável não for declarada
                return expression;
            }
        }
    }

	
	
}

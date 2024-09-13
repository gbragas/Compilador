package io.compiler.core.ast;

import java.util.Scanner;

import io.compiler.runtime.Context;
import io.compiler.types.Types;
import io.compiler.types.Var;

public class ReadCommand extends Command {

    private Var var;

    public ReadCommand(Var var) {
        super();
        this.var = var;
    }

    public ReadCommand() {
        super();
    }

    public Var getVar() {
        return var;
    }

    public void setVar(Var var) {
        this.var = var;
    }
    

    @Override
    public String generateTarget() {
        return var.getId() + " = " + ((var.getType() == Types.NUMBER)?"_scTrx.nextInt();\n" : "_scTrx.nextLine();\n");
    }
    
    @Override
    public String generatePythonCode() {
        if (var.getType() == Types.NUMBER) {
            return var.getId() + " = int(input())\n";  
        } else {
            return var.getId() + " = input()\n";  
        }
    }
    
    @Override
    public void execute(Context context) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter value for " + var.getId() + ": ");
        
        if (var.getType() == Types.NUMBER) {
            try {
                // Lê a entrada como String e converte para double
                String inputValue = scanner.nextLine();
                double doubleValue = Double.parseDouble(inputValue);
                var.setId(String.valueOf(doubleValue));  // Valor como String
            } catch (NumberFormatException e) {
                System.out.println("Invalid input for NUMBER type.");
            }
        } else {
            // Lê a entrada como String
            String inputValue = scanner.nextLine();
            var.setId(inputValue);  // Valor como String
        }
    }
}


package io.compiler.core.ast;

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
}

package io.compiler.core.ast;

import io.compiler.runtime.Context;
import io.compiler.types.Var;

public class WriteCommand extends Command {

    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public WriteCommand(String content) {
        super();
        this.content = content;
    }

    public WriteCommand() {
        super();
    }
    
    @Override
    public String generateTarget() {
        return "System.out.println("+content+");\n";
    }
    
    @Override
    public String generatePythonCode() {
        return "print(" + content + ")\n";
    }

    @Override
    public void execute(Context context) {
       
            System.out.println(context.evaluateExpression(content));
        
    }

}

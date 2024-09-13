package io.compiler.core.ast;

import io.compiler.runtime.Context;

public abstract class Command {

    public abstract String generateTarget();
    
    public abstract String generatePythonCode();
    
    public abstract void execute(Context context);
    
    
}

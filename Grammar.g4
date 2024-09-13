grammar Grammar;

@header {
    import java.util.ArrayList;
    import java.util.Stack;
    import java.util.HashMap;
    import io.compiler.types.*;
    import io.compiler.core.exceptions.*;
    import io.compiler.core.ast.*;
   	import io.compiler.runtime.*;
   	import io.compiler.expressionevaluator.*;
   	
    
}

@members {
    private HashMap<String,Var> symbolTable = new HashMap<String,Var>();
    private ArrayList<Var> currentDecl = new ArrayList<Var>();
    private Types currentType;
    private Types leftType, rightType;
    private Program program = new Program();
    private Stack<ArrayList<Command>> stack = new Stack<ArrayList<Command>>();
    private String strExpr = "";
    private IfCommand currentIfCommand;
    private WhileCommand currentWhileCommand;
    private DoWhileCommand currentDoWhileCommand;
    private AttributionCommand currentAttributionCommand;
    private Warning warning;
    
    
 	private Stack<AbstractExpression> stackExpression = new Stack<AbstractExpression>();
	private AbstractExpression topo = null;
	
    public double generateValue(){
       if (topo == null){
          topo = stackExpression.pop();
       }
       return topo.evaluate();
    }
    
    public String generateJSON(){
    	if (topo == null){
          topo = stackExpression.pop();
       }
       return topo.toJson();
    }
    
    
    
    
    

    public void updateType() {
        for (Var v: currentDecl) {
            v.setType(currentType);
            symbolTable.put(v.getId(),v);
        }
    }

    public void getVars() {
        for (String id: symbolTable.keySet()) {
            System.out.println(symbolTable.get(id));
        }
    }

    public Program getProgram() {
        return this.program;
    }

    public boolean isDeclared(String id) {
        return symbolTable.get(id) != null;
    }
    
    public boolean isTypeCompatible(Types leftType, Types rightType) {
    if (leftType == Types.NUMBER && rightType == Types.TEXT) {
        return false;
    }
    return true;
}
}


programa    : 'programa' ID { program.setName(_input.LT(-1).getText());
                              stack.push(new ArrayList<Command>());
                               Warning warning = new Warning();
                              
                            }
               declararvar+
               'inicio'
               comando+
               'fim'
               'fimprog' {
                    program.setSymbolTable(symbolTable);
                    program.setCommandList(stack.pop());
                    for (String varId : symbolTable.keySet()) {
					    Var var = symbolTable.get(varId);
					    if (!var.isUsed()) {
					        warning.addWarning("Variable '" + varId + "' declared but never used.");
					}
}
                    warning.printWarnings();
                }
            ;

declararvar : 'declare' { currentDecl.clear(); }
               ID { currentDecl.add(new Var(_input.LT(-1).getText())); }
               ( VG ID
                    { currentDecl.add(new Var(_input.LT(-1).getText())); }
               )* DP ('number' { currentType = Types.NUMBER; }
               | 'text' { currentType = Types.TEXT; }
               )
               { updateType(); }
               PV
            ;

comando     : cmdAttrib
            | cmdRead
            | cmdWrite
            | cmdIf
            | cmdWhile
            | cmdDoWhile
            ;
            
            
cmdDoWhile       : 'faça' {
                        stack.push(new ArrayList<Command>());
                        strExpr = "";
                        currentDoWhileCommand = new DoWhileCommand();
                   }
            AC
            comando+ { currentDoWhileCommand.setCommandList(stack.pop()); } 
            FC 
            'enquanto' 
            AP
            expr {currentDoWhileCommand.setExpressiL(_input.LT(-1).getText());}
            OP_REL {currentDoWhileCommand.setOperation(_input.LT(-1).getText());}
            expr {currentDoWhileCommand.setExpressiR(_input.LT(-1).getText());}
            FP 
            PV { stack.peek().add(currentDoWhileCommand); }
            ;    
            

cmdWhile       : 'enquanto' {
                        stack.push(new ArrayList<Command>());
                        strExpr = "";
                        currentWhileCommand = new WhileCommand();
                   }
            AP
            expr
            OP_REL { strExpr += " "+ _input.LT(-1).getText() + " "; }
            expr
            FP { currentWhileCommand.setExpression(strExpr); }
            AC
            comando+ { currentWhileCommand.setCommandList(stack.pop()); }          
            FC { stack.peek().add(currentWhileCommand); }
            ;




cmdIf       : 'if' {
                        stack.push(new ArrayList<Command>());
                        strExpr = "";
                        currentIfCommand = new IfCommand();
                   }
            AP
            expr {currentIfCommand.setExpressionL(_input.LT(-1).getText());}
            OP_REL {currentIfCommand.setOperation(_input.LT(-1).getText());}
            expr {currentIfCommand.setExpressionR(_input.LT(-1).getText());}
            FP 
            AC
            comando+ { currentIfCommand.setTrueList(stack.pop()); }
            FC (
            'else' { stack.push(new ArrayList<Command>()); }
            AC
            comando+ { currentIfCommand.setFalseList(stack.pop()); }
            FC )? { stack.peek().add(currentIfCommand); }
            ;

cmdAttrib : ID 
    {
        if (!isDeclared(_input.LT(-1).getText())) {
            throw new SemanticException("Undeclared Variable: " + _input.LT(-1).getText());
        }
        
                
        currentAttributionCommand = new AttributionCommand();
        symbolTable.get(_input.LT(-1).getText()).setUsed(true);
        symbolTable.get(_input.LT(-1).getText()).setInitialized(true);
        leftType = symbolTable.get(_input.LT(-1).getText()).getType();
        
        currentAttributionCommand.setVariable(_input.LT(-1).getText()); // Set variavel
    } 
    OP_AT 
    {
        currentAttributionCommand.setOperation(_input.LT(-1).getText()); // Set operador
    } 
    expr 
    {
    	currentAttributionCommand.setValue(_input.LT(-1).getText()); // Set valor atribuido
    }
    PV 
    {
        
        stack.peek().add(currentAttributionCommand);
        //System.out.println("Left Side Expression Type: " + leftType);
        //System.out.println("Right Side Expression Type: " + rightType);
        if (!isTypeCompatible(leftType,rightType)) {
            throw new SemanticException("Type Missmatching on Assignment: " + leftType + " and " + rightType);
        }
    };

cmdRead     : 'read' AP
               ID { if (!isDeclared(_input.LT(-1).getText())) {
                         throw new SemanticException("Undeclared Variable: " + _input.LT(-1).getText());
                     }
                     symbolTable.get(_input.LT(-1).getText()).setUsed(true);
                     symbolTable.get(_input.LT(-1).getText()).setInitialized(true);
                     Command cmdRead = new ReadCommand(symbolTable.get(_input.LT(-1).getText()));
                     stack.peek().add(cmdRead);
                   }
               FP PV
            ;

cmdWrite    : 'write' AP
            (
            termo {
                    Command cmdWrite = new WriteCommand(_input.LT(-1).getText());
                    stack.peek().add(cmdWrite);
                  }
            )
            FP PV { rightType = null; }
            ;

expr        : termo { strExpr +=  _input.LT(-1).getText(); } exprl 
            ;

fator       : ID { if (!isDeclared(_input.LT(-1).getText())) {
                        throw new SemanticException("Undeclared Variable: " + _input.LT(-1).getText());
                    }
                    if (!symbolTable.get(_input.LT(-1).getText()).isInitialized()) {
                         throw new SemanticException("Variable: " + _input.LT(-1).getText() +" has no value assigned");
                    }
                    
                    

                    
                    
                    
                    if (rightType == null) {
                        rightType = symbolTable.get(_input.LT(-1).getText()).getType();
                    } else {
                        if (symbolTable.get(_input.LT(-1).getText()).getType().getValue() > rightType.getValue()) {
                            rightType = symbolTable.get(_input.LT(-1).getText()).getType();
                        }
                    }
                    
                    
                  }
            | NUM {
                    if (rightType == null) {
                        rightType = Types.NUMBER;
                    } else {
                        if (rightType.getValue() < Types.NUMBER.getValue()) {
                            rightType = Types.NUMBER;
                        }
                    }
                    
                    UnaryExpression element = new UnaryExpression(Double.parseDouble(_input.LT(-1).getText()));
                 	stackExpression.push(element);

                    
                  }
            | TEXTO {
                        if (rightType == null) {
                            rightType = Types.TEXT;
                        } else {
                            if (rightType.getValue() < Types.TEXT.getValue()) {
                                rightType = Types.TEXT;
                            }
                        }
                    }
            ;

exprl       : (
                (OP_SUM | OP_SUB) 
                {
                   strExpr += " "+ _input.LT(-1).getText() + " "; 		
                   	                 
	               BinaryExpression bin = new BinaryExpression(_input.LT(-1).getText().charAt(0));
	               bin.setLeft(stackExpression.pop());
	               stackExpression.push(bin);           
				}
                termo 
                { 
                	strExpr += _input.LT(-1).getText(); 
                	
                	AbstractExpression topo = stackExpression.pop(); // desempilhei o termo
		         	BinaryExpression root = (BinaryExpression) stackExpression.pop(); // preciso do componente binário
		         	root.setRight(topo);
		         	stackExpression.push(root);
                
                }
              ) *
            ;
            
            
termo	: fator	termol
		;
		
termol	: ((OP_MUL | OP_DIV) {
			 BinaryExpression bin = new BinaryExpression(_input.LT(-1).getText().charAt(0));
			 if (stackExpression.peek() instanceof UnaryExpression) { // o que tem no topo é um operador "simples"
			 	bin.setLeft(stackExpression.pop()); // desempilho já tornando ele filho da multiplicacao
			 }
			 else{
			    BinaryExpression father = (BinaryExpression)stackExpression.pop();
			    if (father.getOperation() == '-' || father.getOperation() == '+'){
			    	bin.setLeft(father.getRight());
			    	father.setRight(bin);
			    }
			    else{
			        bin.setLeft(father);
			        stackExpression.push(bin);			       
			    }
			 }        
          }          
          fator {
             bin.setRight(stackExpression.pop());
             stackExpression.push(bin);
             System.out.println("DEBUG - :" + bin.toJson());
          }

          )*		
		;


OP_SUM	: '+'
		;
		
OP_SUB	: '-'
		;

OP_MUL	: '*'
		;
		
OP_DIV	: '/'
		;

OP_AT       : '=' | '+=' | '-=' | '*=' | '/='
            ;

OP_REL      : '<' | '>' | '>=' |  '<=' | '==' | '!='
            ;

ID          : [a-z] ( [a-z] | [A-Z] | [0-9] )*
            ;

NUM         : [0-9]+ ( '.' [0-9]+ )?
            ;

WS          : (' ' | '\n' | '\r' | '\t') -> skip
            ;

VG          : ','
            ;

PV          : ';'
            ;

DP          : ':'
            ;

AP          : '('
            ;

FP          : ')'
            ;

AC          : '{'
            ;

FC          : '}'
            ;

TEXTO       : '"' ( [a-z] | [A-Z] | [0-9] | ',' | '.' | ';' | ':' | ' ' | '-' )* '"'
            ;
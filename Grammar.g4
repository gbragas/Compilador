grammar Grammar;

@header {
    import java.util.ArrayList;
    import java.util.HashMap;
    import io.compiler.types.*;
    import io.compiler.core.exceptions.*;
}

@members {
    private HashMap<String,Var> symbolTable = new HashMap<String,Var>();
    private ArrayList<Var> currentDecl = new ArrayList<Var>();
    private Types currentType;
    private Types leftType, rightType;

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

    public boolean isDeclared(String id) {
        return symbolTable.get(id) != null;
    }
}


programa    : 'programa'
               declararvar+
               'inicio'
               comando+
               'fim'
               'fimprog'
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
            ;

cmdAttrib   : ID { if (!isDeclared(_input.LT(-1).getText())) {
                       throw new SemanticException("Undeclared Variable: " + _input.LT(-1).getText());
                   }
                   symbolTable.get(_input.LT(-1).getText()).setInitialized(true);
                   leftType = symbolTable.get(_input.LT(-1).getText()).getType();
                 }
              OP_AT
              expr
              PV
              {
                System.out.println("Left Side Expression Type: " +leftType);
                System.out.println("Right Side Expression Type: " +rightType);
                if (leftType.getValue() < rightType.getValue()) {
                       throw new SemanticException("Type Missmatching on Assignment");
                }
              }
            ;

cmdRead     : 'read' AP
               ID { if (!isDeclared(_input.LT(-1).getText())) {
                         throw new SemanticException("Undeclared Variable: " + _input.LT(-1).getText());
                     }
                     symbolTable.get(_input.LT(-1).getText()).setInitialized(true);
                   }
               FP PV
            ;

cmdWrite    : 'write' AP ( termo ) FP PV { rightType = null; }
            ;

expr        : termo exprl
            ;

termo       : ID { if (!isDeclared(_input.LT(-1).getText())) {
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

exprl       : ( OP  termo ) *
            ;

OP          : '+' | '-'| '*' | '/'
            ;

OP_AT       : '='
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

TEXTO       : '"' ( [a-z] | [A-Z] | [0-9] | ',' | '.' | ';' | ':' | ' ' | '-' )* '"'
            ;
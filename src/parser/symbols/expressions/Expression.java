/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parser.symbols.expressions;

import parser.symbols.ParserSymbol;


/**
 *
 * @author sample
 */
public abstract class Expression extends ParserSymbol {
    
    private static final String STRING_IDENTIFIER = "EXPRESSION";
    
    public Expression() {
        super(STRING_IDENTIFIER);
    }
    
}

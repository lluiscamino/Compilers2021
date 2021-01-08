package scanner;

import parser.ParserSym;
import java_cup.runtime.*;
import java_cup.runtime.ComplexSymbolFactory.ComplexSymbol;
import parser.symbols.RelationalOperatorType;
import parser.symbols.types.PrimitiveType;
import exceptions.LexicalError;

%%

%public
%class Scanner
%implements java_cup.runtime.Scanner
%function next_token
%type java_cup.runtime.Symbol
%yylexthrow LexicalError

intlit      = [0-9]+
boollit     = "true" | "false"
strlit      = \" [a-zA-Z0-9$_]* \"
primtype    = "int" | "boolean" | "string"
rel         = "<" | ">" | "<=" | ">=" | "==" | "!="
eol         = ";"
ws          = [ \n\t\r]+
ident       = [a-zA-Z$_] [a-zA-Z0-9$_]*
comment     = "//"[^\r\n]*[\r\n] | "/*"([^*]|\*[^/])*"*/"


%{
    private Symbol symbol(int type) {
        return new ComplexSymbol(ParserSym.terminalNames[type], type);
    }
    
    private Symbol symbol(int type, Object value) {
        return new ComplexSymbol(ParserSym.terminalNames[type], type, value);
    }

    private Symbol relationalSymbol(String value) {
        RelationalOperatorType relType = RelationalOperatorType.get(value);
        return new ComplexSymbol(ParserSym.terminalNames[ParserSym.REL], ParserSym.REL, relType);
    }

    private Symbol primitiveTypeSymbol(String value) {
        PrimitiveType primType = PrimitiveType.get(value);
        return new ComplexSymbol(ParserSym.terminalNames[ParserSym.PRIM_TYPE], ParserSym.PRIM_TYPE, primType);
    }
%}

%%
{ws}        { }
{comment}   { }
"const"     { return symbol(ParserSym.CONST); }
"var"       { return symbol(ParserSym.VAR); }
"array"     { return symbol(ParserSym.ARRAY); }
"function"  { return symbol(ParserSym.FUNCTION); }
"procedure" { return symbol(ParserSym.PROCEDURE); }
"main"      { return symbol(ParserSym.MAIN); }
"return"    { return symbol(ParserSym.RETURN); }
"while"     { return symbol(ParserSym.WHILE); }
"if"        { return symbol(ParserSym.IF); }
"else"      { return symbol(ParserSym.ELSE); }
"("         { return symbol(ParserSym.L_PAR); }
")"         { return symbol(ParserSym.R_PAR); }
"["         { return symbol(ParserSym.L_BOX); }
"]"         { return symbol(ParserSym.R_BOX); }
"{"         { return symbol(ParserSym.L_BRK); }
"}"         { return symbol(ParserSym.R_BRK); }
","         { return symbol(ParserSym.COMMA); }
{eol}       { return symbol(ParserSym.EOL); }
"read()"    { return symbol(ParserSym.READ); }
"print"     { return symbol(ParserSym.PRINT); }
"="         { return symbol(ParserSym.EQUALS); }
"+"         { return symbol(ParserSym.ADD); }
"-"         { return symbol(ParserSym.SUB); }
"*"         { return symbol(ParserSym.MUL); }
"/"         { return symbol(ParserSym.DIV); }
"%"         { return symbol(ParserSym.MOD); }
"&&"        { return symbol(ParserSym.AND); }
"||"        { return symbol(ParserSym.OR); }
"!"         { return symbol(ParserSym.NOT); }
"!"         { return symbol(ParserSym.NOT); }
{rel}       { return relationalSymbol(this.yytext()); }
{primtype}  { return primitiveTypeSymbol(yytext()); }
{intlit}    { return symbol(ParserSym.INT_LIT, Integer.parseInt(yytext())); }
{boollit}   { return symbol(ParserSym.BOOL_LIT, Boolean.parseBoolean(yytext())); }
{strlit}    { return symbol(ParserSym.STR_LIT, yytext()); }
{ident}     { return symbol(ParserSym.IDENT, yytext()); }
.           { throw new LexicalError("Invalid sequence '" + yytext() + "'", 0); }
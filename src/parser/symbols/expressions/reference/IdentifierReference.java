package parser.symbols.expressions.reference;

import dot.DotNode;
import java_cup.runtime.ComplexSymbolFactory.Location;
import parser.symbols.declarations.cva.CVADeclaration;
import parser.symbols.expressions.Expression;
import parser.symbols.types.Type;
import symboltable.SymbolTable;
import main.Compiler;

public class IdentifierReference extends Expression {

    protected final String identifierName;

    public IdentifierReference(String identifierName, Location location) {
        super(Type.getUnknown(), Mode.UNKNOWN, location);
        this.identifierName = identifierName;
    }
    
    @Override
    public Type getType() {
        SymbolTable symbolTable = Compiler.getCompiler().getSemanticAnalyzer().getSymbolTable();
        CVADeclaration decl = symbolTable.getCVA(identifierName);
        return decl != null ? decl.getType(): Type.getUnknown();
    }

    @Override
    public void validate() {
        SymbolTable symbolTable = Compiler.getCompiler().getSemanticAnalyzer().getSymbolTable();
        //mirar la tabla de simbolos
        CVADeclaration decl = symbolTable.getCVA(identifierName);
        if (decl == null) {
            addSemanticError("No existe ninguna variable llamada " + identifierName);
        }
    }

    @Override
    public void toDot() {
        DotNode dotNode = new DotNode("IDENT", "box", "filled", "#BADA55");
        
        dotNode.addEdge(() -> {
            new DotNode(identifierName, "plaintext", "", "");
        }, "ident");
    }

    @Override
    public void toTac() {
        TACVariableGenerator tacVariableGenerator = Compiler.getCompiler().getSemanticAnalyzer().getTacVariableGenerator();
        VariablesTable vt = Compiler.getCompiler().getSemanticAnalyzer().getVariablesTable();
        
        SymbolTable symbolTable = Compiler.getCompiler().getSemanticAnalyzer().getSymbolTable();
        CVADeclaration d = symbolTable.getCVA(identifierName);
        if (d.getMode().isVariable()) {
            tacVariable = vt.get(identifierName).getTacVariable();
        } else {
            TACVariable t = tacVariableGenerator.generate();
            addTACInstruction(new CopyInstruction(t, new TACLiteral(d.getName())));
            tacVariable = t;
        }
        tacVariable = null;



            // d = consulta(ts, id.id);
            // if d.td = dvar  {
            //     R.r = d.nv;
            // } else {
            //     t = novavar;
            //     genera(t = d.valor);
            //     R.r = t;
            // }
            // R.d = nul_val;
    }
}

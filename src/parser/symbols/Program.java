package parser.symbols;

import dot.DotNode;
import java_cup.runtime.ComplexSymbolFactory.Location;
import main.Compiler;
import parser.symbols.declarations.Declaration;
import parser.symbols.declarations.cva.CVADeclaration;
import parser.symbols.declarations.subprogram.MainDeclaration;
import parser.symbols.declarations.subprogram.SubprogramDeclaration;
import symboltable.SymbolTable;
import tac.instructions.special.InitProgramInstruction;

public final class Program extends ParserSymbol {
    private static final String STRING_IDENTIFIER = "PROGRAM";
    
    private final SymbolList<Declaration> declarations;
    private final MainDeclaration main;

    public Program(SymbolList<Declaration> declarations, MainDeclaration main, Location location) {
        super(STRING_IDENTIFIER, location);
        this.declarations = declarations;
        this.main = main;
    }

    @Override
    public void validate() {
        SymbolTable symbolTable = Compiler.getCompiler().getSemanticAnalyzer().getSymbolTable();
        if (declarations != null) {
            for (Declaration decl : declarations.toArrayList()) {
                if (!symbolTable.put(decl)) {
                    decl.addSemanticError("Declaración " + decl.getIdentifier() + " ya definida");
                }
            }
            declarations.validate();
        }
        symbolTable.put(main);
        main.validate();
    }

    @Override
    public void toDot() {
        DotNode dotNode = new DotNode(STRING_IDENTIFIER, "box", "filled", "#f55353");
        
        dotNode.addEdgeIfNotNull(declarations);
        dotNode.addEdge(main);
    }

    @Override
    public void toTac() {
        addSubprogramsToSymbolTable(); // Primero, añadimos todos los subprogramas a la tabla de símbolos para que se puedan llamar entre ellos, independientemente del orden de declaración.
        addSubprogramsToSubprogramsTable();
        generateCVAsTAC(); // Luego, generamos el TAC de todos los CVAs para que puedan ser accedidos desde cualquier subprograma, independientemente del orden de definición.
        addTACInstruction(new InitProgramInstruction());
        generateSubprogramsTAC(); // Finalmente, se genera el TAC de los subprogramas (se genera el TAC de todas las instrucciones).
    }

    private void addSubprogramsToSymbolTable() {
        SymbolTable symbolTable = Compiler.getCompiler().getSemanticAnalyzer().getSymbolTable();
        if (declarations != null) {
            for (Declaration decl : declarations.toArrayList()) {
                if (decl instanceof SubprogramDeclaration) {
                    symbolTable.put(decl);
                }
            }
        }
        symbolTable.put(main);
    }

    private void addSubprogramsToSubprogramsTable() {
        if (declarations != null) {
            for (Declaration decl : declarations.toArrayList()) {
                if (decl instanceof SubprogramDeclaration) {
                    ((SubprogramDeclaration) decl).addToSubprogramsTable();
                }
            }
        }
        main.addToSubprogramsTable();
    }

    private void generateCVAsTAC() {
        if (declarations != null) {
            for (Declaration decl : declarations.toArrayList()) {
                if (decl instanceof CVADeclaration) {
                    decl.toTac();
                }
            }
        }
    }

    private void generateSubprogramsTAC() {
        if (declarations != null) {
            for (Declaration decl : declarations.toArrayList()) {
                if (decl instanceof SubprogramDeclaration) {
                    decl.toTac();
                }
            }
        }
        main.toTac();
    }
}

package dot;

import java.io.PrintWriter;
import parser.symbols.ParserSymbol;

public class DotNode {
    private final ParserSymbol symbol;
    private final String label, shape, style, fillColor;
    private final StringBuilder buffer;

    public DotNode(ParserSymbol symbol, String label, String shape, String style, String fillColor) {
        this.symbol = symbol;
        this.label = label;
        this.shape = shape;
        this.style = style;
        this.fillColor = fillColor;
        this.buffer = new StringBuilder();
        addLabel();
    }
    
    public void addEdge(ParserSymbol child) {
        addEdge(child, "");
    }
    
    public void addEdge(ParserSymbol child, String label) {
        buffer.append(symbol.id);
        buffer.append("->");
        buffer.append(child.id);
        buffer.append("[label=\""); 
        buffer.append(label);
        buffer.append("\"]\n");
    }
    
    public void print(PrintWriter out) {
        out.print(buffer.toString());
    }
    
    private void addLabel() {
        buffer.append(symbol.id);
        buffer.append("\t[label=\"");
        buffer.append(label);
        buffer.append("\", style=");
        buffer.append(style);
        buffer.append(", fillcolor=\"");
        buffer.append(fillColor);
        buffer.append("\"];");
        buffer.append("\n");
    }
}

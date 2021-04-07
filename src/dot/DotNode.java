package dot;

import java.io.PrintWriter;
import main.Compiler;

public class DotNode {
    private final int id;
    private final String label, shape, style, fillColor;

    public DotNode(String label, String shape, String style, String fillColor) {
        DotIdGenerator dotIdGenerator = Compiler.getCompiler().getSemanticAnalyzer().getDotIdGenerator();
        this.id = dotIdGenerator.get();
        this.label = label.replaceAll("\"", "\\\\\"");
        this.shape = shape.length() > 0 ? shape : "none";
        this.style = style.length() > 0 ? style : "none";
        this.fillColor = fillColor.length() > 0 ? fillColor : "none";
        addLabel();
    }
    
    public void addEdgeIfNotNull(DOTizable node) {
        if (node != null) {
            addEdge(node);
        }
    }
    
    public void addEdgeIfNotNull(DOTizable node, String label) {
        if (node != null) {
            addEdge(node, label);
        }
    }
    
    public void addEdge(DOTizable node) {
        addEdge(node, "");
    }
    
    public void addEdge(DOTizable node, String label) {
        StringBuilder buffer = Compiler.getCompiler().getSemanticAnalyzer().getTreeBuffer();
        DotIdGenerator dotIdGenerator = Compiler.getCompiler().getSemanticAnalyzer().getDotIdGenerator();
        buffer.append("\t");
        buffer.append(id);
        buffer.append("->");
        buffer.append(dotIdGenerator.create());
        buffer.append("[label=\""); 
        buffer.append(label);
        buffer.append("\"]\n");
        node.toDot();
    }
    
    private void addLabel() {
        StringBuilder buffer = Compiler.getCompiler().getSemanticAnalyzer().getTreeBuffer();
        buffer.append(id);
        buffer.append("\t[label=\"");
        buffer.append(label);
        buffer.append("\", style=");
        buffer.append(style);
        buffer.append(", shape=");
        buffer.append(shape);
        buffer.append(", fillcolor=\"");
        buffer.append(fillColor);
        buffer.append("\"];");
        buffer.append("\n");
    }
}

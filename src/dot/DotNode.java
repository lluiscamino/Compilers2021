package dot;

import java.io.PrintWriter;

public class DotNode {
    private final int id;
    private final String label, shape, style, fillColor;
    private final StringBuilder buffer;

    public DotNode(StringBuilder buffer, String label, String shape, String style, String fillColor) {
        this.id = DotIdGenerator.get();
        this.label = label;
        this.shape = shape.length() > 0 ? shape : "none";
        this.style = style.length() > 0 ? style : "none";
        this.fillColor = fillColor.length() > 0 ? fillColor : "none";
        this.buffer = buffer;
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
        buffer.append("\n");
        buffer.append(id);
        buffer.append("->");
        buffer.append(DotIdGenerator.create());
        buffer.append("[label=\""); 
        buffer.append(label);
        buffer.append("\"]\n");
        node.toDot(buffer);
    }
    
    public void print(PrintWriter out) {
        out.print(buffer.toString());
    }
    
    private void addLabel() {
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

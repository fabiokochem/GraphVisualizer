package graph;

import java.awt.*;

public class Edge {
    private final Node from;
    private final Node to;
    private final int weight;

    public Edge(Node from, Node to, int weight) {
        this.from = from;
        this.to = to;
        this.weight = weight;
    }

    public void draw(Graphics g) {
        g.setColor(Color.BLACK);
        g.drawLine(from.getX(), from.getY(), to.getX(), to.getY());

        int midX = (from.getX() + to.getX()) / 2;
        int midY = (from.getY() + to.getY()) / 2;
        g.setColor(Color.RED);
        g.drawString(String.valueOf(weight), midX, midY);
    }

    public Node getFrom() { return from; }
    public Node getTo() { return to; }
    public int getWeight() { return weight; }
}

package graph;

import java.awt.*;

public class Node {
    private static int counter = 0;
    private final int id;
    private final int x, y;
    private Color color = Color.BLUE;
    private String label = "";

    public Node(int x, int y) {
        this.id = counter++;
        this.x = x;
        this.y = y;
    }
    
    public int getX() { return x; }
    public int getY() { return y; }
    public int getId() { return id; }

    public void setColor(Color color) {
        this.color = color;
    }
    
    public Color getColor() {
        return color;
    }    

    public void setLabel(String label) {
        this.label = label;
    }

    public void draw(Graphics g, int radius) {
        g.setColor(color);
        g.fillOval(x - radius, y - radius, radius * 2, radius * 2);
        g.setColor(Color.WHITE);
        g.drawString(String.valueOf(id), x - 5, y + 5);
        if (!label.isEmpty()) {
            g.setColor(Color.BLACK);
            g.drawString(label, x - radius, y - radius - 4);
        }
    }
}

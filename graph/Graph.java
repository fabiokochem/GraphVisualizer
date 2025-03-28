package graph;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Graph {
    private final List<Node> nodes = new ArrayList<>();
    private final List<Edge> edges = new ArrayList<>();

    public void addNode(int x, int y) {
        nodes.add(new Node(x, y));
    }

    public void addEdge(Node from, Node to, int weight) {
        edges.add(new Edge(from, to, weight));
    }

    public List<Node> getNodes() {
        return nodes;
    }

    public List<Edge> getEdges() {
        return edges;
    }

    public void draw(Graphics g, int radius) {
        // Desenhar arestas
        for (Edge edge : edges) {
            edge.draw(g);
        }

        // Desenhar nós
        for (Node node : nodes) {
            node.draw(g, radius);
        }
    }

    public Node getNodeAt(int x, int y, int radius) {
        for (Node node : nodes) {
            int dx = x - node.getX();
            int dy = y - node.getY();
            if (dx * dx + dy * dy <= radius * radius) {
                return node;
            }
        }
        return null;
    }

    public void clear() {
        nodes.clear();
        edges.clear();
    }    

    public List<Node> getNeighbors(Node node) {
        List<Node> neighbors = new ArrayList<>();
        for (Edge edge : edges) {
            if (edge.getFrom() == node) {
                neighbors.add(edge.getTo());
            } else if (edge.getTo() == node) {
                neighbors.add(edge.getFrom());
            }
        }
        return neighbors;
    }

    public int getEdgeWeight(Node from, Node to) {
        for (Edge edge : edges) {
            if ((edge.getFrom() == from && edge.getTo() == to) ||
                (edge.getFrom() == to && edge.getTo() == from)) {
                return edge.getWeight();
            }
        }
        return Integer.MAX_VALUE; // se não existir
    }
    
}

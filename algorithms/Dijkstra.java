package algorithms;

import graph.Edge;
import graph.Graph;
import graph.Node;
import utils.Sleep;

import javax.swing.*;
import java.awt.*;
import java.util.*;

public class Dijkstra {
    private final Graph graph;
    private final GraphPanelCallback callback;
    private final int delay = 500;
    Map<Node, Node> previous = new HashMap<>();

    public interface GraphPanelCallback {
        void refresh();
    }

    public Dijkstra(Graph graph, GraphPanelCallback callback) {
        this.graph = graph;
        this.callback = callback;
    }

    public void run() {
        List<Node> nodes = graph.getNodes();
        if (nodes.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Grafo vazio.");
            return;
        }

        Node start = nodes.get(0);
        Map<Node, Integer> distance = new HashMap<>();
        PriorityQueue<Node> queue = new PriorityQueue<>(Comparator.comparingInt(distance::get));

        for (Node node : nodes) {
            distance.put(node, Integer.MAX_VALUE);
            node.setLabel(""); // limpar
        }

        distance.put(start, 0);
        start.setColor(Color.GREEN);
        queue.add(start);
        updateNodeLabel(start, 0);

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            current.setColor(Color.CYAN);
            callback.refresh();
            Sleep.ms(delay);

            for (Node neighbor : graph.getNeighbors(current)) {
                int edgeWeight = graph.getEdgeWeight(current, neighbor);
                int newDist = distance.get(current) + edgeWeight;

                if (newDist < distance.get(neighbor)) {
                    distance.put(neighbor, newDist);
                    updateNodeLabel(neighbor, newDist);
                    queue.remove(neighbor);
                    queue.add(neighbor);
                    neighbor.setColor(Color.GREEN);
                    callback.refresh();
                    Sleep.ms(delay);
                }
            }

            current.setColor(Color.MAGENTA);
            callback.refresh();
            Sleep.ms(delay);
        }
    }

    private void updateNodeLabel(Node node, int dist) {
        node.setLabel(String.valueOf(dist));
    }
}

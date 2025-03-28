package algorithms;

import graph.Graph;
import graph.Node;
import utils.Sleep;

import javax.swing.*;
import java.awt.*;
import java.util.*;

public class BFS {
    private final Graph graph;
    private final GraphPanelCallback callback;
    private final int delay = 500; // ms

    public interface GraphPanelCallback {
        void refresh();
    }

    public BFS(Graph graph, GraphPanelCallback callback) {
        this.graph = graph;
        this.callback = callback;
    }

    public void run() {
        List<Node> nodes = graph.getNodes();
        if (nodes.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Grafo vazio.");
            return;
        }

        Set<Node> visited = new HashSet<>();
        Queue<Node> queue = new LinkedList<>();

        Node start = nodes.get(0);
        queue.add(start);
        visited.add(start);
        start.setColor(Color.GREEN);
        callback.refresh();
        Sleep.ms(delay);

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            current.setColor(Color.CYAN);
            callback.refresh();
            Sleep.ms(delay);

            for (Node neighbor : graph.getNeighbors(current)) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(neighbor);
                    neighbor.setColor(Color.GREEN);
                    callback.refresh();
                    Sleep.ms(delay);
                }
            }

            current.setColor(Color.BLUE); // final visitado
            callback.refresh();
            Sleep.ms(delay);
        }
    }
}

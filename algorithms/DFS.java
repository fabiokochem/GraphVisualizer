package algorithms;

import graph.Graph;
import graph.Node;
import utils.Sleep;

import javax.swing.*;
import java.awt.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DFS {
    private final Graph graph;
    private final GraphPanelCallback callback;
    private final int delay = 500;

    public interface GraphPanelCallback {
        void refresh();
    }

    public DFS(Graph graph, GraphPanelCallback callback) {
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
        dfs(nodes.get(0), visited);
    }

    private void dfs(Node node, Set<Node> visited) {
        visited.add(node);
        node.setColor(Color.CYAN);
        callback.refresh();
        Sleep.ms(delay);

        for (Node neighbor : graph.getNeighbors(node)) {
            if (!visited.contains(neighbor)) {
                dfs(neighbor, visited);
            }
        }

        node.setColor(Color.MAGENTA);
        callback.refresh();
        Sleep.ms(delay);
    }
}

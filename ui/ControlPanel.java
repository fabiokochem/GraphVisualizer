package ui;

import graph.Graph;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class ControlPanel extends JPanel {
    public ControlPanel(GraphPanel graphPanel) {
        setLayout(new GridLayout(0, 1, 10, 10));
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JButton bfsButton = new JButton("Rodar BFS");
        JButton dfsButton = new JButton("Rodar DFS");
        JButton dijkstraButton = new JButton("Rodar Dijkstra");
        JButton resetButton = new JButton("Resetar Grafo");

        bfsButton.addActionListener(e -> graphPanel.runBFS());
        dfsButton.addActionListener(e -> graphPanel.runDFS());
        dijkstraButton.addActionListener(e -> graphPanel.runDijkstra());
        
        resetButton.addActionListener(e -> {
            graphPanel.resetGraph();
        });
        
        add(bfsButton);
        add(dfsButton);
        add(dijkstraButton);
        add(resetButton);
    }
}

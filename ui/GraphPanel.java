package ui;

import graph.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import algorithms.*;

public class GraphPanel extends JPanel {
    private final Graph graph = new Graph();
    private final int nodeRadius = 20;
    private Node selectedNode = null;

    public GraphPanel() {
        setBackground(Color.WHITE);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Node clicked = graph.getNodeAt(e.getX(), e.getY(), nodeRadius);
        
                if (clicked != null) {
                    if (selectedNode == null) {
                        selectedNode = clicked;
                    } else if (selectedNode != clicked) {
                        String input = JOptionPane.showInputDialog("Peso da aresta:");
                        try {
                            int weight = Integer.parseInt(input);
                            graph.addEdge(selectedNode, clicked, weight);
                        } catch (NumberFormatException ex) {
                            JOptionPane.showMessageDialog(null, "Peso inválido. Aresta não criada.");
                        }
                        selectedNode = null;
                        repaint();
                    }
                } else {
                    graph.addNode(e.getX(), e.getY());
                    selectedNode = null;
                    repaint();
                }
            }
        });        
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        graph.draw(g, nodeRadius);
    }

    public void resetGraph() {
        graph.clear();
        selectedNode = null;
        repaint();
    }
    
    public void runBFS() {
        new Thread(() -> {
            BFS bfs = new BFS(graph, this::repaint);
            bfs.run();
        }).start();
    }

    public void runDFS() {
        new Thread(() -> {
            DFS dfs = new DFS(graph, this::repaint);
            dfs.run();
        }).start();
    }
    
    public void runDijkstra() {
        new Thread(() -> {
            Dijkstra algo = new Dijkstra(graph, this::repaint);
            algo.run();
        }).start();
    }
    
}

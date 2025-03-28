public static void main(String[] args) {
    SwingUtilities.invokeLater(() -> {
        JFrame frame = new JFrame("Graph Visualizer");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 600);
        frame.setLayout(new BorderLayout());

        GraphPanel graphPanel = new GraphPanel();
        ControlPanel controlPanel = new ControlPanel(graphPanel);

        frame.add(graphPanel, BorderLayout.CENTER);
        frame.add(controlPanel, BorderLayout.EAST);

        frame.setVisible(true);
    });
}

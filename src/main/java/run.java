import javax.swing.JFrame;

public static void main(String[] args) {
    JFrame frame = new JFrame("Laberinto Game");
    Laberinto maze = new Laberinto();
    frame.add(maze);
    frame.pack();
    frame.setVisible(true);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}
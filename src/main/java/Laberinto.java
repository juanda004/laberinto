import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Laberinto extends JPanel implements KeyListener {
    private int[][] maze = {
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
            {1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1},
            {1, 0, 1, 0, 0, 0, 0, 0, 1, 0, 1},
            {1, 0, 1, 1, 1, 1, 1, 0, 1, 0, 1},
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1},
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
            {1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1},
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 2, 1},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}
    };

    private int playerRow = 1;
    private int playerCol = 1;

    private final Stack<Integer> stack = new Stack<>();
    private final ArrayList<Integer> arrayList = new ArrayList<>();
    private final LinkedList<Integer> linkedList = new LinkedList<>();
    private final Queue<Integer> queue = new LinkedList<>();

    public Laberinto() {
        setPreferredSize(new Dimension(600, 600));
        setBackground(Color.WHITE);
        addKeyListener(this);
        setFocusable(true);

        for (int row = 0; row < maze.length; row++) {
            for (int col = 0; col < maze[row].length; col++) {
                if (maze[row][col] == 1) {
                    stack.push(row * maze.length + col);
                    arrayList.add(row * maze.length + col);
                    linkedList.add(row * maze.length + col);
                    queue.offer(row * maze.length + col);
                }
                if (maze[row][col] == 2){
                    stack.push(row * maze.length + col);
                    arrayList.add(row * maze.length + col);
                    linkedList.add(row * maze.length + col);
                    queue.add(row * maze.length + col);
                } else if (maze[row][col] == 2){
                    setBackground(Color.YELLOW);
                }
            }
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.BLACK);

        for (int row = 0; row < maze.length; row++) {
            for (int col = 0; col < maze[row].length; col++) {
                if (maze[row][col] == 1) {
                    g.fillRect(col * 60, row * 60, 60, 60);
                } else if (maze[row][col] == 2){
                    g.setColor(Color.YELLOW);
                    g.fillRect(col * 60, row * 60, 60, 60);
                }
            }
        }

        g.setColor(Color.GREEN);
        g.fillRect(playerCol * 60, playerRow * 60, 60, 60);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        if (keyCode == KeyEvent.VK_UP) {
            if (maze[playerRow - 1][playerCol] == 0|| maze[playerRow - 1][playerCol] == 2) {
                playerRow--;
            }
        } else if (keyCode == KeyEvent.VK_DOWN) {
            if (maze[playerRow + 1][playerCol] == 0||maze[playerRow + 1][playerCol] == 2) {
                playerRow++;
            }
        } else if (keyCode == KeyEvent.VK_LEFT) {
            if (maze[playerRow][playerCol - 1] == 0 || maze[playerRow][playerCol - 1] == 2) {
                playerCol--;
            }
        } else if (keyCode == KeyEvent.VK_RIGHT) {
            if (maze[playerRow][playerCol + 1] == 0 || maze[playerRow][playerCol + 1] == 2) {
                playerCol++;
            }
        }
        if (maze[playerRow][playerCol] == 2) {
            JOptionPane.showMessageDialog(null, "Has ganado");
        }
        repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {}

    @Override
    public void keyTyped(KeyEvent e) {}
}
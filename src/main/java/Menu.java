import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends JFrame {
    private Laberinto laberinto;

    public Menu(String laberinto_Game) {
        setTitle("Laberinto Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());

        JButton iniciarButton = new JButton("Iniciar");
        iniciarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (laberinto == null) {
                    laberinto = new Laberinto();
                    add(laberinto, BorderLayout.CENTER);
                    pack();
                }
                laberinto.requestFocus();
            }
        });

        JButton salirButton = new JButton("Salir");
        salirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        buttonPanel.add(iniciarButton);
        buttonPanel.add(salirButton);

        add(buttonPanel, BorderLayout.SOUTH);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
    public static void main(String[] args) {
        JFrame Menu = new Menu ("Laberinto Game");
        Menu.setSize(600, 600);
        Menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

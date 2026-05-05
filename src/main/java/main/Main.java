package main;

import javax.swing.JFrame;
import SleeknoteUI.MainPanel;
import SleeknoteUI.MenuPrincipal;

public class Main {
    public static void main(String[] args) {

        java.awt.EventQueue.invokeLater(() -> {
            JFrame frame = new JFrame("Main panel");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            frame.setContentPane(new MainPanel());

            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
        
    }

}
package main;

import javax.swing.JFrame;
import SleeknoteUI.MenuPrincipal;
import SleeknoteUI.Login;


public class Main {
    public static void main(String[] args) {
          java.awt.EventQueue.invokeLater(() -> {
            new Login().setVisible(true);
        });
    
    }

}
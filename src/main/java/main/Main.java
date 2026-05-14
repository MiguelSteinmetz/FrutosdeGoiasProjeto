package main;

import SleeknoteUI.MenuPrincipal;
import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        // gera carregamento de tela)
        JWindow splash = new JWindow();
        
        // pers painel carregamento
        JPanel painel = new JPanel(new BorderLayout());
        painel.setBackground(new java.awt.Color(102, 102, 102)); // Cor cinza do seu sistema
        painel.setBorder(BorderFactory.createLineBorder(new java.awt.Color(255, 153, 0), 2)); // Borda Laranja     
        JLabel texto = new JLabel("Carregando Sistema Frutos de Goiás...", SwingConstants.CENTER);
        texto.setForeground(Color.WHITE);
        texto.setFont(new Font("Segoe UI", Font.BOLD, 16));
        painel.add(texto, BorderLayout.CENTER);
        splash.getContentPane().add(painel);
        
        // tamanho da tela 
        splash.setSize(450, 250);
        splash.setLocationRelativeTo(null);
        splash.setVisible(true);

        // carregamento em segundo plano
        new Thread(() -> {
            try {
                
                System.out.println("Carregando recursos e banco de dados...");
               
                Thread.sleep(3000); 

                System.out.println("Tudo pronto!");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                //  Fecha o carregamento e abre o menu princpal
                SwingUtilities.invokeLater(() -> {
                    splash.dispose(); 
                    
                    
                    MenuPrincipal sistema = new MenuPrincipal();
                    sistema.setVisible(true); 
                });
            }
        }).start();
    }
}
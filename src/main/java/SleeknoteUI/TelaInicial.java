package SleeknoteUI;

import javax.swing.*;

public class TelaInicial extends JPanel {

    public TelaInicial() {
        initComponents();
    }

    private void initComponents() {

        JLabel label = new JLabel("Tela Inicial");

        setLayout(new java.awt.FlowLayout());
        add(label);
    }
}
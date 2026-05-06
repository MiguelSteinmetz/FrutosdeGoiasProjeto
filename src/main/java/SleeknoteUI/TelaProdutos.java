/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package SleeknoteUI;

/**
 *
 * @author vinic
 */
public class TelaProdutos extends javax.swing.JPanel {

    public TelaProdutos() {
        initComponents();
    }

    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();

        jLabel1.setText("Produto teste");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout); // <<< CORRETO

        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel1)
        );

        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel1)
        );
    }

    private javax.swing.JLabel jLabel1;
}
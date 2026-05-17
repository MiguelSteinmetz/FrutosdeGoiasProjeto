/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package SleeknoteUI;

import java.util.List;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;
import model.Venda;
import service.VendaService;

/**
 *
 * @author Erik_
 */
public class telaRelatorioTotalVendidos extends javax.swing.JInternalFrame {

 
    public telaRelatorioTotalVendidos() {
        initComponents();
        this.setSize(1000,500);
        BasicInternalFrameUI ui =
            (BasicInternalFrameUI) this.getUI();
        ui.setNorthPane(null);
         carregarTabela();
    }
   
    public void carregarTabela() {

    DefaultTableModel modelo = (DefaultTableModel) tblTotalVendidoProdutos1.getModel();
    modelo.setRowCount(0);

        VendaService service =
            new VendaService();
        
    List<Object[]> lista = service.totalVendidoProduto();

    for (Object[] obj : lista) {

    String nome = (String) obj[0];

    Double valorUnit =
            ((Number) obj[1]).doubleValue();

    Long quantidade = ((Number) obj[2]).longValue();

    Double valorTotal =((Number) obj[3]).doubleValue();

    modelo.addRow(new Object[]{
            nome,
            valorUnit,
            valorTotal,
            quantidade,

    });
}
   
}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblTotalVendidoProdutos1 = new javax.swing.JTable();
        jButton3 = new javax.swing.JButton();

        jPanel2.setBackground(new java.awt.Color(255, 255, 204));
        jPanel2.setPreferredSize(new java.awt.Dimension(850, 650));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblTotalVendidoProdutos1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.darkGray, null, java.awt.Color.darkGray, java.awt.Color.darkGray));
        tblTotalVendidoProdutos1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Produto", "Valor", "Valor Total Vendido", "Quantidade Vendida"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Double.class, java.lang.Double.class, java.lang.Long.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tblTotalVendidoProdutos1.setShowGrid(false);
        jScrollPane2.setViewportView(tblTotalVendidoProdutos1);

        jPanel2.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 980, 370));

        jButton3.setBackground(new java.awt.Color(255, 153, 51));
        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 153, 51));
        jButton3.setText("Total Vendido Por Produto");
        jButton3.setEnabled(false);
        jButton3.addActionListener(this::jButton3ActionPerformed);
        jPanel2.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 10, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 1000, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 501, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton3;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblTotalVendidoProdutos1;
    // End of variables declaration//GEN-END:variables
}

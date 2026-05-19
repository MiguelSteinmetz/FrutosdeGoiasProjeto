/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package SleeknoteUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import model.Venda;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import service.VendaService;

/**
 *
 * @author Erik_
 */
public class telaRelatorioTopVendidos extends javax.swing.JInternalFrame {
    
    

    public telaRelatorioTopVendidos() {
        initComponents();
        this.setSize(1000,500);
        criarGraficoTopVendidos();
        BasicInternalFrameUI ui =
            (BasicInternalFrameUI) this.getUI();
        ui.setNorthPane(null);
    }

private void criarGraficoTopVendidos() {

    VendaService service = new VendaService();

   List<Object[]> lista = service.topProdutosVendidos();

    DefaultCategoryDataset dados = new DefaultCategoryDataset();

    for (Object[] obj : lista) {
        String nome = (String) obj[0];
        Integer qtd = ((Number) obj[1]).intValue();

        dados.setValue(qtd, "Quantidade", nome);
    }

        JFreeChart grafico = ChartFactory.createBarChart(
                "Top Produtos Mais Vendidos",
                "Produto",
                "Quantidade",
                dados
        );
    CategoryPlot plot = grafico.getCategoryPlot();
    BarRenderer renderer = (BarRenderer) plot.getRenderer();
    renderer.setMaximumBarWidth(0.05);
    renderer.setSeriesPaint( 0, Color.orange);

   
    ChartPanel painel = new ChartPanel(grafico);

    iPanelTopVendidos.removeAll();
    iPanelTopVendidos.setLayout(new BorderLayout());
    iPanelTopVendidos.add(painel, BorderLayout.CENTER);
    iPanelTopVendidos.revalidate();
    iPanelTopVendidos.repaint();
}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        iPanelTopVendidos = new javax.swing.JPanel();

        setBorder(null);

        jPanel1.setBackground(new java.awt.Color(255, 255, 204));
        jPanel1.setMinimumSize(new java.awt.Dimension(910, 438));
        jPanel1.setPreferredSize(new java.awt.Dimension(850, 650));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton2.setBackground(new java.awt.Color(255, 153, 51));
        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 153, 51));
        jButton2.setText("Top Produtos Vendidos");
        jButton2.setEnabled(false);
        jButton2.addActionListener(this::jButton2ActionPerformed);
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 470, 260, -1));

        javax.swing.GroupLayout iPanelTopVendidosLayout = new javax.swing.GroupLayout(iPanelTopVendidos);
        iPanelTopVendidos.setLayout(iPanelTopVendidosLayout);
        iPanelTopVendidosLayout.setHorizontalGroup(
            iPanelTopVendidosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 900, Short.MAX_VALUE)
        );
        iPanelTopVendidosLayout.setVerticalGroup(
            iPanelTopVendidosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 370, Short.MAX_VALUE)
        );

        jPanel1.add(iPanelTopVendidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 80, 900, 370));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1000, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 501, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel iPanelTopVendidos;
    private javax.swing.JButton jButton2;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}

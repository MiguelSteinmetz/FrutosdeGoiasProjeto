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
public class telaRelatorioFinanceiro extends javax.swing.JInternalFrame {
    
    

    public telaRelatorioFinanceiro() {
        initComponents();
        this.setSize(1000,500);
        carregarRelatorio();
        BasicInternalFrameUI ui =
            (BasicInternalFrameUI) this.getUI();
        ui.setNorthPane(null);
        criarGraficoFinanceiro();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel5 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lbQuantVendida = new javax.swing.JLabel();
        lbFatTotal = new javax.swing.JLabel();
        lbCustoTotal = new javax.swing.JLabel();
        lbLucroBrutoTotal = new javax.swing.JLabel();
        jPanelRelatorioFinanceiro = new javax.swing.JPanel();

        jLabel5.setText("jLabel5");

        setBorder(null);
        setPreferredSize(new java.awt.Dimension(1248, 913));

        jPanel1.setBackground(new java.awt.Color(255, 255, 204));
        jPanel1.setMinimumSize(new java.awt.Dimension(910, 438));
        jPanel1.setPreferredSize(new java.awt.Dimension(850, 650));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton2.setBackground(new java.awt.Color(255, 153, 51));
        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 153, 51));
        jButton2.setText("Relatorio Financeiro");
        jButton2.setEnabled(false);
        jButton2.addActionListener(this::jButton2ActionPerformed);
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 410, 210, -1));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("Quantidade vendida:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, -1, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setText("Faturamento total: ");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel3.setText("Custo total");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, -1, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel4.setText("Lucro bruto total:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, -1, -1));

        lbQuantVendida.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lbQuantVendida.setText("0");
        jPanel1.add(lbQuantVendida, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 260, 110, 30));

        lbFatTotal.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lbFatTotal.setText("R$: 0");
        jPanel1.add(lbFatTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 110, 130, -1));

        lbCustoTotal.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lbCustoTotal.setText("R$: 0");
        jPanel1.add(lbCustoTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 160, 130, 30));

        lbLucroBrutoTotal.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lbLucroBrutoTotal.setText("R$: 0");
        jPanel1.add(lbLucroBrutoTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 210, 130, 30));

        javax.swing.GroupLayout jPanelRelatorioFinanceiroLayout = new javax.swing.GroupLayout(jPanelRelatorioFinanceiro);
        jPanelRelatorioFinanceiro.setLayout(jPanelRelatorioFinanceiroLayout);
        jPanelRelatorioFinanceiroLayout.setHorizontalGroup(
            jPanelRelatorioFinanceiroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 420, Short.MAX_VALUE)
        );
        jPanelRelatorioFinanceiroLayout.setVerticalGroup(
            jPanelRelatorioFinanceiroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 310, Short.MAX_VALUE)
        );

        jPanel1.add(jPanelRelatorioFinanceiro, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 80, 420, 310));

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

    private void carregarRelatorio(){  
      
    VendaService service =new VendaService();
    lbFatTotal.setText(   "R$ " + service.getLucroTotal());
    lbLucroBrutoTotal.setText("R$ " + service.getFaturamentoTotal());
    lbQuantVendida.setText( String.valueOf(service.getQuantidadeVendida()));
    lbCustoTotal.setText( "R$ " + service.getCustoTotal());                    
  }

   private void criarGraficoFinanceiro() {

    VendaService service =
            new VendaService();

    DefaultCategoryDataset dados =
            new DefaultCategoryDataset();

    dados.setValue(
            service.getFaturamentoTotal(),
            "Valor",
            "Faturamento"
    );

    dados.setValue(
            service.getCustoTotal(),
            "Valor",
            "Custos"
    );

    dados.setValue(
            service.getLucroTotal(),
            "Valor",
            "Lucro"
    );

    JFreeChart grafico =
            ChartFactory.createBarChart(
                    "Relatório Financeiro",
                    "Tipo",
                    "Valor",
                    dados
            );

    CategoryPlot plot = grafico.getCategoryPlot();
    BarRenderer renderer = (BarRenderer) plot.getRenderer();
    renderer.setMaximumBarWidth(0.05);
    renderer.setSeriesPaint( 0, Color.orange);
    
    ChartPanel painel =
            new ChartPanel(grafico);

    jPanelRelatorioFinanceiro.removeAll();

    jPanelRelatorioFinanceiro.setLayout(
            new BorderLayout());

    jPanelRelatorioFinanceiro.add(
            painel,
            BorderLayout.CENTER
    );

    jPanelRelatorioFinanceiro.revalidate();
    jPanelRelatorioFinanceiro.repaint();
}
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanelRelatorioFinanceiro;
    private javax.swing.JLabel lbCustoTotal;
    private javax.swing.JLabel lbFatTotal;
    private javax.swing.JLabel lbLucroBrutoTotal;
    private javax.swing.JLabel lbQuantVendida;
    // End of variables declaration//GEN-END:variables
}

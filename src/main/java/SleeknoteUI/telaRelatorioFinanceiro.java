package SleeknoteUI;

import java.awt.BorderLayout;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import model.Venda;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
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
        jPanelRelatorioFinanceiro = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        lbQuantVendida = new javax.swing.JLabel();
        lbLucroBrutoTotal = new javax.swing.JLabel();
        lbCustoTotal = new javax.swing.JLabel();
        lbFatTotal = new javax.swing.JLabel();

        jLabel5.setText("jLabel5");

        setPreferredSize(new java.awt.Dimension(1248, 913));

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));
        jPanel1.setMinimumSize(new java.awt.Dimension(910, 438));
        jPanel1.setPreferredSize(new java.awt.Dimension(850, 650));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton2.setBackground(new java.awt.Color(255, 153, 51));
        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 153, 51));
        jButton2.setText("Relatorio Financeiro");
        jButton2.setEnabled(false);
        jButton2.addActionListener(this::jButton2ActionPerformed);
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 10, 210, -1));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Quantidade vendida:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, -1, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Faturamento total: ");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Custo total");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, -1, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Lucro bruto total:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, -1, -1));

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

        lbQuantVendida.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lbQuantVendida.setText("0");

        lbLucroBrutoTotal.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lbLucroBrutoTotal.setText("R$: 0");

        lbCustoTotal.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lbCustoTotal.setText("R$: 0");

        lbFatTotal.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lbFatTotal.setText("R$: 0");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbQuantVendida, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbLucroBrutoTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbCustoTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbFatTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addComponent(lbFatTotal)
                .addGap(18, 18, 18)
                .addComponent(lbCustoTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lbLucroBrutoTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(lbQuantVendida, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 100, -1, 200));

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
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanelRelatorioFinanceiro;
    private javax.swing.JLabel lbCustoTotal;
    private javax.swing.JLabel lbFatTotal;
    private javax.swing.JLabel lbLucroBrutoTotal;
    private javax.swing.JLabel lbQuantVendida;
    // End of variables declaration//GEN-END:variables
}

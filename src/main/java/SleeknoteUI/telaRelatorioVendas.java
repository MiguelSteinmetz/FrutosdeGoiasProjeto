
package SleeknoteUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;
import model.Venda;
import repository.VendaRepository;
import service.VendaService;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author Erik_
 */
public class telaRelatorioVendas extends javax.swing.JInternalFrame {

   
    public telaRelatorioVendas() {
        initComponents();
        this.setSize(1000,500);
        carregarTabela();
        BasicInternalFrameUI ui =
            (BasicInternalFrameUI) this.getUI();
        ui.setNorthPane(null);
        
        criarGrafico();
    }

    public void carregarTabela() {

    DefaultTableModel modelo =
            (DefaultTableModel) TabelaVendas.getModel();
    modelo.setRowCount(0);

        VendaService repository =
            new VendaService();

    List<Venda> lista = repository.listarVendas();

    for (Venda v : lista) {

    String nomeUsuario;

    if (v.getUsuario() != null) {
        nomeUsuario = v.getUsuario().getNome();
    } else {
        nomeUsuario = "Sem usuário";
    }

    modelo.addRow(new Object[]{
        nomeUsuario,
        v.getProduto().getNome(),
        v.getTipoPagamento(),
        v.getQuantidade(),
        v.getValorTotal(),
        v.getData()
    });
}
}
  
  public void criarGrafico() {

    DefaultCategoryDataset dados = new DefaultCategoryDataset();

    VendaService repository = new VendaService();

    List<Venda> lista = repository.listarVendas();

    Map<String, Double> totais = new HashMap<>();

    for (Venda v : lista) {

        String produto = v.getProduto().getNome();

        double valor =  v.getQuantidade();

        if (totais.containsKey(produto)) {  totais.put( produto,totais.get(produto) + valor);
        } else {
            totais.put(produto, valor);
        }
    }

    for (String produto : totais.keySet()) {

        dados.setValue( totais.get(produto), "Vendas", produto);
    }

    JFreeChart grafico = ChartFactory.createBarChart(  "Vendas por Produto",  "Produto",    "Valor",  dados  );
        CategoryPlot CategoryPlot;
        
    CategoryPlot plot = grafico.getCategoryPlot();
    BarRenderer renderer = (BarRenderer) plot.getRenderer();
    renderer.setMaximumBarWidth(0.05);
    renderer.setSeriesPaint( 0, Color.orange);

    ChartPanel painel = new ChartPanel(grafico);

    jPanelGrafico.removeAll();
    jPanelGrafico.setLayout( new BorderLayout());
    jPanelGrafico.add( painel, BorderLayout.CENTER );
    jPanelGrafico.revalidate();
    jPanelGrafico.repaint();
    
}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TabelaVendas = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jPanelGrafico = new javax.swing.JPanel();

        jPanel1.setBackground(new java.awt.Color(255, 255, 204));
        jPanel1.setPreferredSize(new java.awt.Dimension(850, 650));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        TabelaVendas.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.darkGray, null, java.awt.Color.darkGray, java.awt.Color.darkGray));
        TabelaVendas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Usuario", "Produto", "Tipo Pagamento", "Quantidade", "Valor Total", "Data"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.String.class, java.lang.Byte.class, java.lang.Long.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        TabelaVendas.setShowGrid(false);
        jScrollPane1.setViewportView(TabelaVendas);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 560, 358));

        jButton2.setBackground(new java.awt.Color(255, 153, 51));
        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 153, 51));
        jButton2.setText("Relatorio Vendas");
        jButton2.setEnabled(false);
        jButton2.addActionListener(this::jButton2ActionPerformed);
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(286, 6, -1, -1));

        javax.swing.GroupLayout jPanelGraficoLayout = new javax.swing.GroupLayout(jPanelGrafico);
        jPanelGrafico.setLayout(jPanelGraficoLayout);
        jPanelGraficoLayout.setHorizontalGroup(
            jPanelGraficoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 330, Short.MAX_VALUE)
        );
        jPanelGraficoLayout.setVerticalGroup(
            jPanelGraficoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 340, Short.MAX_VALUE)
        );

        jPanel1.add(jPanelGrafico, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 80, 330, 340));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1000, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 236, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 501, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 376, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TabelaVendas;
    private javax.swing.JButton jButton2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanelGrafico;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}

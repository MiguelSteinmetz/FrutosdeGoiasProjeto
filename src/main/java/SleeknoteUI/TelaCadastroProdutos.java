/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package SleeknoteUI;
import model.Produto;
import repository.ProdutoRepository;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;
import model.Usuario;
import service.LogService;
import model.SessaoUsuario;

/**
 *
 * @author vinic
 */
public class TelaCadastroProdutos extends javax.swing.JInternalFrame {

    
     LogService log = new LogService();
     
     
    public TelaCadastroProdutos() {
        initComponents();
        listarProdutos();
    }
    public void listarProdutos() {

    DefaultTableModel modelo = (DefaultTableModel) TabelaCadastroProdutos.getModel();

    modelo.setRowCount(0);

    ProdutoRepository repository = new ProdutoRepository();

    for (Produto p : repository.buscartodos()) {

        modelo.addRow(new Object[]{
            p.getId(),
            p.getNome(),
            p.getCusto(),
            p.getEstoque(),
            p.getPreco()
        });

    }
    

}
    public void limparCampos(){

    TxtId.setText("");    

    TxtNome.setText("");

    TxtCusto.setText("");

    TxtEstoque.setText("");

    TxtPreco.setText("");

}
 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        TelaCadastroProdutosDSK = new javax.swing.JDesktopPane();
        TxtNome = new javax.swing.JTextField();
        TxtPreco = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        TxtEstoque = new javax.swing.JTextField();
        BntEditar = new javax.swing.JButton();
        BntCadastrar = new javax.swing.JButton();
        BntDeleta = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        TabelaCadastroProdutos = new javax.swing.JTable();
        TxtCusto = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        TxtId = new javax.swing.JTextField();
        lbId = new javax.swing.JLabel();

        setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        setClosable(true);
        setForeground(java.awt.Color.orange);
        setIconifiable(true);
        setTitle("Tela de Cadastro de Produtos");
        setToolTipText("3");
        setName(""); // NOI18N
        setVisible(true);

        TelaCadastroProdutosDSK.setBackground(new java.awt.Color(255, 255, 204));

        TxtNome.addActionListener(this::TxtNomeActionPerformed);

        jLabel4.setText("Nome");

        jLabel5.setText("Estoque");

        jLabel6.setText("Custo");

        BntEditar.setBackground(new java.awt.Color(255, 153, 51));
        BntEditar.setForeground(new java.awt.Color(255, 255, 255));
        BntEditar.setText("Editar");
        BntEditar.addActionListener(this::BntEditarActionPerformed);

        BntCadastrar.setBackground(new java.awt.Color(255, 153, 51));
        BntCadastrar.setForeground(new java.awt.Color(255, 255, 255));
        BntCadastrar.setText("Cadastrar");
        BntCadastrar.addActionListener(this::BntCadastrarActionPerformed);

        BntDeleta.setBackground(new java.awt.Color(255, 51, 51));
        BntDeleta.setForeground(new java.awt.Color(255, 255, 255));
        BntDeleta.setText("Deletar");
        BntDeleta.addActionListener(this::BntDeletaActionPerformed);

        TabelaCadastroProdutos.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.darkGray, null, java.awt.Color.darkGray, java.awt.Color.darkGray));
        TabelaCadastroProdutos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Nome", "Login", "Senha", "Cargo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        TabelaCadastroProdutos.setShowGrid(false);
        TabelaCadastroProdutos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TabelaCadastroProdutosMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(TabelaCadastroProdutos);

        TxtCusto.addActionListener(this::TxtCustoActionPerformed);

        jLabel7.setText("Valor");

        TxtId.setEditable(false);
        TxtId.addActionListener(this::TxtIdActionPerformed);

        lbId.setText("ID");

        TelaCadastroProdutosDSK.setLayer(TxtNome, javax.swing.JLayeredPane.DEFAULT_LAYER);
        TelaCadastroProdutosDSK.setLayer(TxtPreco, javax.swing.JLayeredPane.DEFAULT_LAYER);
        TelaCadastroProdutosDSK.setLayer(jLabel4, javax.swing.JLayeredPane.DEFAULT_LAYER);
        TelaCadastroProdutosDSK.setLayer(jLabel5, javax.swing.JLayeredPane.DEFAULT_LAYER);
        TelaCadastroProdutosDSK.setLayer(jLabel6, javax.swing.JLayeredPane.DEFAULT_LAYER);
        TelaCadastroProdutosDSK.setLayer(TxtEstoque, javax.swing.JLayeredPane.DEFAULT_LAYER);
        TelaCadastroProdutosDSK.setLayer(BntEditar, javax.swing.JLayeredPane.DEFAULT_LAYER);
        TelaCadastroProdutosDSK.setLayer(BntCadastrar, javax.swing.JLayeredPane.DEFAULT_LAYER);
        TelaCadastroProdutosDSK.setLayer(BntDeleta, javax.swing.JLayeredPane.DEFAULT_LAYER);
        TelaCadastroProdutosDSK.setLayer(jScrollPane3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        TelaCadastroProdutosDSK.setLayer(TxtCusto, javax.swing.JLayeredPane.DEFAULT_LAYER);
        TelaCadastroProdutosDSK.setLayer(jLabel7, javax.swing.JLayeredPane.DEFAULT_LAYER);
        TelaCadastroProdutosDSK.setLayer(TxtId, javax.swing.JLayeredPane.DEFAULT_LAYER);
        TelaCadastroProdutosDSK.setLayer(lbId, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout TelaCadastroProdutosDSKLayout = new javax.swing.GroupLayout(TelaCadastroProdutosDSK);
        TelaCadastroProdutosDSK.setLayout(TelaCadastroProdutosDSKLayout);
        TelaCadastroProdutosDSKLayout.setHorizontalGroup(
            TelaCadastroProdutosDSKLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TelaCadastroProdutosDSKLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(TelaCadastroProdutosDSKLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(TelaCadastroProdutosDSKLayout.createSequentialGroup()
                        .addGroup(TelaCadastroProdutosDSKLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(TelaCadastroProdutosDSKLayout.createSequentialGroup()
                                .addComponent(BntCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(182, 182, 182)
                                .addComponent(BntEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(BntDeleta, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 650, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, TelaCadastroProdutosDSKLayout.createSequentialGroup()
                        .addGroup(TelaCadastroProdutosDSKLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(TelaCadastroProdutosDSKLayout.createSequentialGroup()
                                .addComponent(TxtId, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(TxtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(TxtCusto, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(TxtEstoque, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(TxtPreco, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 21, Short.MAX_VALUE))
                            .addGroup(TelaCadastroProdutosDSKLayout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addComponent(lbId)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel4)
                                .addGap(206, 206, 206)
                                .addComponent(jLabel6)
                                .addGap(47, 47, 47)
                                .addComponent(jLabel5)
                                .addGap(94, 94, 94)
                                .addComponent(jLabel7)))
                        .addGap(69, 69, 69))))
        );
        TelaCadastroProdutosDSKLayout.setVerticalGroup(
            TelaCadastroProdutosDSKLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TelaCadastroProdutosDSKLayout.createSequentialGroup()
                .addGap(84, 84, 84)
                .addGroup(TelaCadastroProdutosDSKLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(lbId))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(TelaCadastroProdutosDSKLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TxtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TxtEstoque, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TxtCusto, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TxtPreco, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TxtId, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(TelaCadastroProdutosDSKLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BntCadastrar)
                    .addComponent(BntEditar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BntDeleta))
                .addGap(81, 81, 81))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(TelaCadastroProdutosDSK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(TelaCadastroProdutosDSK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TxtNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtNomeActionPerformed

    private void BntEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BntEditarActionPerformed
        // TODO add your handling code here:
        try {
            
        Long id = Long.parseLong(TxtId.getText());

        String nome = TxtNome.getText();

        double custo = Double.parseDouble(TxtCusto.getText());

        int estoque = Integer.parseInt(TxtEstoque.getText());

        double preco = Double.parseDouble(TxtPreco.getText());

        Produto produto = new Produto();
        
        produto.setId(id);

        produto.setNome(nome);

        produto.setCusto(custo);

        produto.setEstoque(estoque);

        produto.setPreco(preco);

        ProdutoRepository repository = new ProdutoRepository();

        repository.atualizar(produto);

        JOptionPane.showMessageDialog(this,
            "Produto atualizado!");
        
        log.registrar(SessaoUsuario.getUsuarioLogado().getNome(),"Editou um Produto" );
        listarProdutos();

        limparCampos();

    } catch (Exception e) {

        JOptionPane.showMessageDialog(this,
            "Insira o Id\nErro: " + e.getMessage());

    }
        
    }//GEN-LAST:event_BntEditarActionPerformed

    private void BntCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BntCadastrarActionPerformed
        // TODO add your handling code here:
      try{
          
        String nome = TxtNome.getText();

        double preco = Double.parseDouble(TxtPreco.getText());

        int estoque = Integer.parseInt(TxtEstoque.getText());

        double custo = Double.parseDouble(TxtCusto.getText());
        
        Produto produto = new Produto();

        produto.setNome(nome);
        produto.setPreco(preco);
        produto.setEstoque(estoque);
        produto.setCusto(custo);
        
        ProdutoRepository repository = new ProdutoRepository();

        repository.salvar(produto);
        
        JOptionPane.showMessageDialog(this, "Produto Cadastrado com sucesso!!!");
         log.registrar(SessaoUsuario.getUsuarioLogado().getNome(),"Cadastrou um Produto" );
        listarProdutos();
      }catch(Exception e) {
          JOptionPane.showMessageDialog(this, "Produto nao cadastrado \n Erro : " + e.getMessage());
      }
    }//GEN-LAST:event_BntCadastrarActionPerformed

    private void BntDeletaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BntDeletaActionPerformed
        // TODO add your handling code here:
        
    int linha = TabelaCadastroProdutos.getSelectedRow();

    if(linha == -1){

        JOptionPane.showMessageDialog(this,
            "Selecione um produto");

        return;
    }

    int id = Integer.parseInt(
        TabelaCadastroProdutos.getValueAt(linha, 0).toString()
    );

    Produto produto = new Produto();

    produto.setId(id);

    ProdutoRepository repository = new ProdutoRepository();

    repository.remover(produto);

    listarProdutos();
    
    limparCampos();

    JOptionPane.showMessageDialog(this,
        "Produto removido!!!");
    
    log.registrar(SessaoUsuario.getUsuarioLogado().getNome(),"Deletou um Produto" );
    
    }//GEN-LAST:event_BntDeletaActionPerformed

    private void TabelaCadastroProdutosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TabelaCadastroProdutosMouseClicked
        // TODO add your handling code here:
        int linha = TabelaCadastroProdutos.getSelectedRow();

    TxtId.setText(
        TabelaCadastroProdutos.getValueAt(linha, 0).toString()
    );    
        
    TxtNome.setText(
        TabelaCadastroProdutos.getValueAt(linha, 1).toString()
    );

    TxtCusto.setText(
        TabelaCadastroProdutos.getValueAt(linha, 2).toString()
    );

    TxtEstoque.setText(
        TabelaCadastroProdutos.getValueAt(linha, 3).toString()
    );

    TxtPreco.setText(
        TabelaCadastroProdutos.getValueAt(linha, 4).toString()
    );
    }//GEN-LAST:event_TabelaCadastroProdutosMouseClicked

    private void TxtCustoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtCustoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtCustoActionPerformed

    private void TxtIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtIdActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BntCadastrar;
    private javax.swing.JButton BntDeleta;
    private javax.swing.JButton BntEditar;
    private javax.swing.JTable TabelaCadastroProdutos;
    private javax.swing.JDesktopPane TelaCadastroProdutosDSK;
    private javax.swing.JTextField TxtCusto;
    private javax.swing.JTextField TxtEstoque;
    private javax.swing.JTextField TxtId;
    private javax.swing.JTextField TxtNome;
    private javax.swing.JTextField TxtPreco;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lbId;
    // End of variables declaration//GEN-END:variables
}

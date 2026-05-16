/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package SleeknoteUI;

import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Produto;
import repository.ProdutoRepository;
import javax.swing.JDialog;
import model.Usuario;
import model.Venda;
import service.LogService;
import service.ProdutoService;
import service.VendaService;

/**
 *
 * @author vinic
 */
public class TelaVendas extends javax.swing.JPanel {

    /**
     * Creates new form TelaProdutos
     */
    
     LogService log = new LogService();
     private Usuario usuario;
     VendaService vendaService = new VendaService();
     ProdutoService produtoService = new ProdutoService();
     
    public TelaVendas() {
        initComponents();
        carregarTabela();
        listarProdutos();
    }
     public void listarProdutos() {

    DefaultTableModel modelo = (DefaultTableModel) tabelaProdutos.getModel();

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
        
    TxtBuscarProduto.setText("");
    }
    
    
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    public void carregarTabela() {

        DefaultTableModel modelo =
                (DefaultTableModel) tabelaProdutos.getModel();

        modelo.setRowCount(0);

        ProdutoRepository repository =
                new ProdutoRepository();

        List<Produto> lista = repository.buscartodos();

        for (Produto p : lista) {

            modelo.addRow(new Object[]{
                p.getId(),
                p.getNome(),
                p.getEstoque(),
                p.getPreco()
            });
        }
    
    }
    
    private void calcularTotal() 
    {

        DefaultTableModel modelo =
            (DefaultTableModel) tabelaCarrinho.getModel();

        double total = 0;

        for (int i = 0; i < modelo.getRowCount(); i++) {

            Object valorObj = modelo.getValueAt(i, 4);
            Object qtdObj = modelo.getValueAt(i, 3);

            if (valorObj != null && qtdObj != null) {

                double valor = Double.parseDouble(
                    valorObj.toString());

                int qtd = Integer.parseInt(
                    qtdObj.toString());

                total += valor * qtd;
            }
        }

    txtValorTotalPg.setText("R$ " + total);
    }
    
    
    private void adicionarAoCarrinho() {
        
        int linhaProduto = tabelaProdutos.getSelectedRow();
        if (linhaProduto == -1) {

            JOptionPane.showMessageDialog(null,
                    "Selecione um produto!");

            return;
        }

        DefaultTableModel produtos =
                (DefaultTableModel) tabelaProdutos.getModel();

        DefaultTableModel carrinho =
                (DefaultTableModel) tabelaCarrinho.getModel();

        Object id = produtos.getValueAt(linhaProduto, 0);
        Object nome = produtos.getValueAt(linhaProduto, 1);
        Object custo = produtos.getValueAt(linhaProduto, 2);
        Object quantidade = 1;
        Object valor = produtos.getValueAt(linhaProduto, 4);

        // verifica se já existe
        for (int i = 0; i < carrinho.getRowCount(); i++) {

            Object itemCarrinho = carrinho.getValueAt(i, 0);

            if (itemCarrinho != null &&
                itemCarrinho.equals(id)) {

                int qtdAtual = Integer.parseInt(
                        carrinho.getValueAt(i, 3).toString());

                carrinho.setValueAt(qtdAtual + 1, i, 3);

                calcularTotal();
                return;
        }
    }

        carrinho.addRow(new Object[]{
            id,
            nome,
            custo,
            quantidade,
            valor
        });

        calcularTotal();
    }
        
    private void salvarVenda(String pagamento) {

    DefaultTableModel carrinho =
            (DefaultTableModel) tabelaCarrinho.getModel();

    for (int i = 0; i < carrinho.getRowCount(); i++) {

        Long idProduto = Long.parseLong(
                carrinho.getValueAt(i, 0).toString()
        );

        int quantidade = Integer.parseInt(
                carrinho.getValueAt(i, 3).toString()
        );

        double valor = Double.parseDouble(
                carrinho.getValueAt(i, 4).toString()
        );

        Produto produto =
                produtoService.buscarPorId(
                        idProduto.intValue()
                );

        if (produto != null) {

            Venda venda = new Venda();

            venda.setUsuario(usuario);

            venda.setProduto(produto);

            venda.setQuantidade(quantidade);

            venda.setTipoPagamento(pagamento);

            venda.setValorTotal(valor * quantidade);

            vendaService.salvarVenda(venda);

       
            produto.setEstoque(
                    produto.getEstoque() - quantidade
            );

            produtoService.atualizar(produto);
        }
    }
}
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaProdutos = new javax.swing.JTable();
        Pesquisar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        BntSair = new javax.swing.JButton();
        BntRelatorios = new javax.swing.JButton();
        BntFuncionarios = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        BntProdutos = new javax.swing.JButton();
        BntPagar = new javax.swing.JButton();
        BntDeletar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtValorTotal = new javax.swing.JTextPane();
        TxtBuscarProduto = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        Recarregar = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabelaCarrinho = new javax.swing.JTable();
        adcionarCarrinho = new javax.swing.JButton();
        txtValorTotalPg = new javax.swing.JLabel();
        BntRemover = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 204));

        tabelaProdutos.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.darkGray, null, java.awt.Color.darkGray, java.awt.Color.darkGray));
        tabelaProdutos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Produto", "Custo", "Quantidade", "Valor"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Float.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tabelaProdutos.setShowGrid(false);
        tabelaProdutos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaProdutosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelaProdutos);

        Pesquisar.setBackground(new java.awt.Color(255, 153, 51));
        Pesquisar.setForeground(new java.awt.Color(255, 255, 255));
        Pesquisar.setText("Pesquisar");
        Pesquisar.addActionListener(this::PesquisarActionPerformed);

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logo_256x256.png"))); // NOI18N

        jButton2.setBackground(new java.awt.Color(255, 153, 51));
        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Caixa");
        jButton2.setEnabled(false);
        jButton2.setMaximumSize(new java.awt.Dimension(591, 519));
        jButton2.setMinimumSize(new java.awt.Dimension(591, 519));
        jButton2.addActionListener(this::jButton2ActionPerformed);

        BntSair.setBackground(new java.awt.Color(255, 153, 51));
        BntSair.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        BntSair.setForeground(new java.awt.Color(255, 255, 255));
        BntSair.setText("Sair");
        BntSair.setMaximumSize(new java.awt.Dimension(591, 519));
        BntSair.setMinimumSize(new java.awt.Dimension(591, 519));
        BntSair.addActionListener(this::BntSairActionPerformed);

        BntRelatorios.setBackground(new java.awt.Color(255, 153, 51));
        BntRelatorios.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        BntRelatorios.setForeground(new java.awt.Color(255, 255, 255));
        BntRelatorios.setText("Relatorios");
        BntRelatorios.setMaximumSize(new java.awt.Dimension(591, 519));
        BntRelatorios.setMinimumSize(new java.awt.Dimension(591, 519));
        BntRelatorios.addActionListener(this::BntRelatoriosActionPerformed);

        BntFuncionarios.setBackground(new java.awt.Color(255, 153, 51));
        BntFuncionarios.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        BntFuncionarios.setForeground(new java.awt.Color(255, 255, 255));
        BntFuncionarios.setText("Funcionarios");
        BntFuncionarios.setMaximumSize(new java.awt.Dimension(591, 519));
        BntFuncionarios.setMinimumSize(new java.awt.Dimension(591, 519));
        BntFuncionarios.addActionListener(this::BntFuncionariosActionPerformed);

        jButton9.setBackground(new java.awt.Color(255, 153, 51));
        jButton9.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton9.setForeground(new java.awt.Color(255, 255, 255));
        jButton9.setText("Pedidos");
        jButton9.setMaximumSize(new java.awt.Dimension(591, 519));
        jButton9.setMinimumSize(new java.awt.Dimension(591, 519));
        jButton9.addActionListener(this::jButton9ActionPerformed);

        BntProdutos.setBackground(new java.awt.Color(255, 153, 51));
        BntProdutos.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        BntProdutos.setForeground(new java.awt.Color(255, 255, 255));
        BntProdutos.setText("Produtos");
        BntProdutos.setMaximumSize(new java.awt.Dimension(591, 519));
        BntProdutos.setMinimumSize(new java.awt.Dimension(591, 519));
        BntProdutos.addActionListener(this::BntProdutosActionPerformed);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BntSair, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BntRelatorios, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BntFuncionarios, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BntProdutos, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(BntProdutos, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(BntFuncionarios, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(BntRelatorios, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(BntSair, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 180, Short.MAX_VALUE))
        );

        BntPagar.setBackground(new java.awt.Color(102, 255, 102));
        BntPagar.setForeground(new java.awt.Color(255, 255, 255));
        BntPagar.setText("Pagar");
        BntPagar.addActionListener(this::BntPagarActionPerformed);

        BntDeletar.setBackground(new java.awt.Color(255, 51, 51));
        BntDeletar.setForeground(new java.awt.Color(255, 255, 255));
        BntDeletar.setText("Deletar");
        BntDeletar.addActionListener(this::BntDeletarActionPerformed);

        txtValorTotal.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txtValorTotal.setText("Valor Total : ");
        jScrollPane2.setViewportView(txtValorTotal);

        TxtBuscarProduto.setText("Buscar produto por ID");
        TxtBuscarProduto.addActionListener(this::TxtBuscarProdutoActionPerformed);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setText("Buscar produto");

        jButton6.setBackground(new java.awt.Color(255, 153, 51));
        jButton6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton6.setForeground(new java.awt.Color(255, 153, 51));
        jButton6.setText("Caixa Vendas");
        jButton6.setEnabled(false);

        Recarregar.setBackground(new java.awt.Color(255, 153, 51));
        Recarregar.setForeground(new java.awt.Color(255, 255, 255));
        Recarregar.setText("🔃");
        Recarregar.addActionListener(this::RecarregarActionPerformed);

        tabelaCarrinho.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.darkGray, null, java.awt.Color.darkGray, java.awt.Color.darkGray));
        tabelaCarrinho.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Produto", "Custo", "Quantidade", "Valor"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Float.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tabelaCarrinho.setShowGrid(false);
        jScrollPane3.setViewportView(tabelaCarrinho);

        adcionarCarrinho.setBackground(new java.awt.Color(255, 153, 51));
        adcionarCarrinho.setForeground(new java.awt.Color(255, 255, 255));
        adcionarCarrinho.setText("Adcionar");
        adcionarCarrinho.addActionListener(this::adcionarCarrinhoActionPerformed);

        txtValorTotalPg.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N

        BntRemover.setBackground(new java.awt.Color(255, 153, 51));
        BntRemover.setForeground(new java.awt.Color(255, 255, 255));
        BntRemover.setText("➖");
        BntRemover.addActionListener(this::BntRemoverActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton6)
                    .addComponent(jLabel2)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(TxtBuscarProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Pesquisar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(Recarregar, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 555, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(146, 146, 146)
                                .addComponent(adcionarCarrinho, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtValorTotalPg, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(BntPagar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(50, 50, 50)
                                .addComponent(BntDeletar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 695, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BntRemover, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton6)
                .addGap(62, 62, 62)
                .addComponent(jLabel2)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(TxtBuscarProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Pesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Recarregar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(30, 30, 30)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(103, 103, 103)
                        .addComponent(BntRemover, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
                        .addComponent(adcionarCarrinho, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(5, 5, 5)
                            .addComponent(txtValorTotalPg, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(BntDeletar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BntPagar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void BntSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BntSairActionPerformed
        // TODO add your handling code here:
        MenuPrincipal tela = new MenuPrincipal();

    tela.setSize(this.getSize());

    this.removeAll();

    this.setLayout(new java.awt.BorderLayout());

    this.add(tela, java.awt.BorderLayout.CENTER);

    this.revalidate();

    this.repaint();
    }//GEN-LAST:event_BntSairActionPerformed

    private void BntPagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BntPagarActionPerformed
        // TODO add your handling code here:
         DefaultTableModel carrinho =
        (DefaultTableModel) tabelaCarrinho.getModel();

    if (carrinho.getRowCount() == 0) {

        JOptionPane.showMessageDialog(
                null,
                "Carrinho vazio!"
        );

        return;
    }

    String total = txtValorTotalPg.getText();

    // opções
    String[] formasPagamento = {
        "PIX",
        "Cartão de Débito",
        "Cartão de Crédito"
    };

    // seleção
    String pagamento = (String) JOptionPane.showInputDialog(
            null,
            "Selecione a forma de pagamento:",
            "Pagamento",
            JOptionPane.QUESTION_MESSAGE,
            null,
            formasPagamento,
            formasPagamento[0]
    );

    // cancelou
    if (pagamento == null) {
        return;
    }

    //
    // PIX
    //
    if (pagamento.equals("PIX")) {

        TelaPix painelPix = new TelaPix(total);

        JDialog dialog = new JDialog();

        dialog.setTitle("Pagamento PIX");

        dialog.setContentPane(painelPix);

        dialog.pack();

        dialog.setSize(400, 500);

        dialog.setResizable(false);

        dialog.setModal(true);

        dialog.setLocationRelativeTo(null);

        dialog.setVisible(true);

        return;
    }

    //
    // cartão
    //
    int confirmar = JOptionPane.showConfirmDialog(
            null,
            "Forma: " + pagamento
            + "\nTotal: " + total
            + "\n\nConfirmar pagamento?",
            "Finalizar Compra",
            JOptionPane.YES_NO_OPTION
    );

    if (confirmar == JOptionPane.YES_OPTION) {

        salvarVenda(pagamento);
        JOptionPane.showMessageDialog(
                null,
                "Pagamento realizado com sucesso!"
                + "\nForma: " + pagamento
                + "\nTotal: " + total
        );
        String nome = usuario != null
        ? usuario.getNome()
        : "Sem usuário";

        log.registrar(nome, "Vendeu um Produto");
       
        
        carrinho.setRowCount(0);

        txtValorTotalPg.setText("R$ 0,00");
    }

    }//GEN-LAST:event_BntPagarActionPerformed

    private void TxtBuscarProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtBuscarProdutoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtBuscarProdutoActionPerformed

    private void BntRelatoriosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BntRelatoriosActionPerformed
        // TODO add your handling code here:
        TelaRelatorios tela = new TelaRelatorios();

    tela.setSize(this.getSize());

    this.removeAll();

    this.setLayout(new java.awt.BorderLayout());

    this.add(tela, java.awt.BorderLayout.CENTER);

    this.revalidate();

    this.repaint();
    }//GEN-LAST:event_BntRelatoriosActionPerformed

    private void BntFuncionariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BntFuncionariosActionPerformed
        // TODO add your handling code here:
        TelaFuncionarios tela = new TelaFuncionarios();

    tela.setSize(this.getSize());

    this.removeAll();

    this.setLayout(new java.awt.BorderLayout());

    this.add(tela, java.awt.BorderLayout.CENTER);

    this.revalidate();

    this.repaint();
    }//GEN-LAST:event_BntFuncionariosActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton9ActionPerformed

    private void BntProdutosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BntProdutosActionPerformed
        // TODO add your handling code here:
        TelaProdutos tela = new TelaProdutos();

    tela.setSize(this.getSize());

    this.removeAll();

    this.setLayout(new java.awt.BorderLayout());

    this.add(tela, java.awt.BorderLayout.CENTER);

    this.revalidate();

    this.repaint();
    }//GEN-LAST:event_BntProdutosActionPerformed

    private void RecarregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RecarregarActionPerformed
        // TODO add your handling code here:
        limparCampos();
        carregarTabela();
    }//GEN-LAST:event_RecarregarActionPerformed

    private void PesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PesquisarActionPerformed
        // TODO add your handling code here:
        String texto = TxtBuscarProduto.getText().trim();

        ProdutoRepository repository = new ProdutoRepository();

        DefaultTableModel modelo =
        (DefaultTableModel) tabelaProdutos.getModel();

        modelo.setRowCount(0);

        // VERIFICA SE É NÚMERO
        if (texto.matches("\\d+")) {

            int id = Integer.parseInt(texto);

            Produto produto = repository.buscarPorId(id);

            if (produto != null) {

                modelo.addRow(new Object[]{
                    produto.getId(),
                    produto.getNome(),
                    produto.getPreco(),
                    produto.getEstoque(),
                    produto.getCusto()
            });

        }

    } else {

        List<Produto> lista = repository.buscarPorNome(texto);

        for (Produto produto : lista) {

            modelo.addRow(new Object[]{
                produto.getId(),
                produto.getNome(),
                produto.getPreco(),
                produto.getEstoque(),
                produto.getCusto()
            });
        }
      }
     
    }//GEN-LAST:event_PesquisarActionPerformed

    private void tabelaProdutosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaProdutosMouseClicked
        // TODO add your handling code here:
        if (evt.getClickCount() == 2) {
            adicionarAoCarrinho();
        }
    }//GEN-LAST:event_tabelaProdutosMouseClicked

    private void adcionarCarrinhoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adcionarCarrinhoActionPerformed
        // TODO add your handling code here:
        adicionarAoCarrinho();
    }//GEN-LAST:event_adcionarCarrinhoActionPerformed

    private void BntDeletarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BntDeletarActionPerformed
        // TODO add your handling code here:
        int linha = tabelaCarrinho.getSelectedRow();

        if (linha == -1) {

            JOptionPane.showMessageDialog(null,
                    "Selecione um item do carrinho!");

            return;
        }

        DefaultTableModel carrinho =
                (DefaultTableModel) tabelaCarrinho.getModel();

        carrinho.removeRow(linha);

        calcularTotal();
    
    }//GEN-LAST:event_BntDeletarActionPerformed

    private void BntRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BntRemoverActionPerformed
        // TODO add your handling code here:
        int linha = tabelaCarrinho.getSelectedRow();

        if (linha == -1) {

            JOptionPane.showMessageDialog(
                    null,
                    "Selecione um item do carrinho!"
            );

            return;
        }

        DefaultTableModel carrinho =
                (DefaultTableModel) tabelaCarrinho.getModel();

        int quantidade = Integer.parseInt(
                carrinho.getValueAt(linha, 3).toString());

        // se quantidade maior que 1
        if (quantidade > 1) {

            carrinho.setValueAt(
                    quantidade - 1,
                    linha,
                    3
            );

        } else {

            // remove produto se chegar em 0
            carrinho.removeRow(linha);
        }

        calcularTotal();

        // zera total se carrinho vazio
        if (carrinho.getRowCount() == 0) {

            txtValorTotalPg.setText("R$ 0,00");
        }
    }//GEN-LAST:event_BntRemoverActionPerformed




    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BntDeletar;
    private javax.swing.JButton BntFuncionarios;
    private javax.swing.JButton BntPagar;
    private javax.swing.JButton BntProdutos;
    private javax.swing.JButton BntRelatorios;
    private javax.swing.JButton BntRemover;
    private javax.swing.JButton BntSair;
    private javax.swing.JButton Pesquisar;
    private javax.swing.JButton Recarregar;
    private javax.swing.JTextField TxtBuscarProduto;
    private javax.swing.JButton adcionarCarrinho;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable tabelaCarrinho;
    private javax.swing.JTable tabelaProdutos;
    private javax.swing.JTextPane txtValorTotal;
    private javax.swing.JLabel txtValorTotalPg;
    // End of variables declaration//GEN-END:variables
}

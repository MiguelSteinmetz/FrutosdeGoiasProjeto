package SleeknoteUI;

import Controller.ProdutoController;
import java.awt.BorderLayout;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Produto;
import model.SessaoUsuario;
import model.Usuario;
import repository.ProdutoRepository;

public class TelaProdutos extends javax.swing.JPanel {


    private ProdutoController produtoController = new ProdutoController();

    public TelaProdutos() {
        initComponents();
        carregarTabela();
        aplicarPermissoes();
    }



    public void listarProdutos() {
        DefaultTableModel modelo = (DefaultTableModel) TabelaProdutos.getModel();
        modelo.setRowCount(0);
        for (Produto p : produtoController.listarProdutos()) {
            modelo.addRow(new Object[]{
                    p.getId(), p.getNome(), p.getCusto(), p.getEstoque(), p.getPreco()
            });
        }
    }

    public void carregarTabela() {
        listarProdutos();
    }

    public void limparCampos() {
        TxtBuscarProduto.setText("");
        TxtId.setText("");
        TxtNome.setText("");
        TxtCusto.setText("");
        TxtEstoque.setText("");
        TxtPreco.setText("");
    }

    private void aplicarPermissoes() {
        Usuario u = SessaoUsuario.getUsuarioLogado();
        if (u == null) return;
        if (!u.getTipo().equals("Gerente")) {
            BntRelatorios.setEnabled(false);
            BntFuncionario.setEnabled(false);
            BntProdutos.setEnabled(false);
            BntCadastrarProdutos.setEnabled(false);
            BntDeletar.setEnabled(false);
            BntEditar.setEnabled(false);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        DskCadastroProdutos = new javax.swing.JDesktopPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TabelaProdutos = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        BntCaixa = new javax.swing.JButton();
        BntProdutos = new javax.swing.JButton();
        BntFuncionario = new javax.swing.JButton();
        BntRelatorios = new javax.swing.JButton();
        bntSair = new javax.swing.JButton();
        BntEditar = new javax.swing.JButton();
        BntDeletar = new javax.swing.JButton();
        TxtBuscarProduto = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        BntPesquisar = new javax.swing.JButton();
        BntCadastrarProdutos = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        TxtId = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        TxtNome = new javax.swing.JTextField();
        TxtCusto = new javax.swing.JTextField();
        TxtEstoque = new javax.swing.JTextField();
        TxtPreco = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setMaximumSize(new java.awt.Dimension(1920, 1080));

        DskCadastroProdutos.setBackground(new java.awt.Color(255, 255, 204));

        jPanel1.setBackground(new java.awt.Color(255, 255, 204));

        TabelaProdutos.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.darkGray, null, java.awt.Color.darkGray, java.awt.Color.darkGray));
        TabelaProdutos.setModel(new javax.swing.table.DefaultTableModel(
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
        TabelaProdutos.setShowGrid(false);
        TabelaProdutos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TabelaProdutosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TabelaProdutos);
        if (TabelaProdutos.getColumnModel().getColumnCount() > 0) {
            TabelaProdutos.getColumnModel().getColumn(1).setPreferredWidth(415);
        }

        jButton1.setBackground(new java.awt.Color(255, 153, 51));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("🔃");
        jButton1.addActionListener(this::jButton1ActionPerformed);

        jPanel2.setBackground(new java.awt.Color(51, 51, 51));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logo_256x256.png")));

        BntCaixa.setBackground(new java.awt.Color(255, 153, 51));
        BntCaixa.setFont(new java.awt.Font("Segoe UI", 1, 18));
        BntCaixa.setForeground(new java.awt.Color(255, 255, 255));
        BntCaixa.setText("Caixa");
        BntCaixa.setMaximumSize(new java.awt.Dimension(591, 519));
        BntCaixa.setMinimumSize(new java.awt.Dimension(591, 519));
        BntCaixa.addActionListener(this::BntCaixaActionPerformed);

        BntProdutos.setBackground(new java.awt.Color(255, 153, 51));
        BntProdutos.setFont(new java.awt.Font("Segoe UI", 1, 18));
        BntProdutos.setForeground(new java.awt.Color(255, 255, 255));
        BntProdutos.setText("Produtos");
        BntProdutos.setEnabled(false);
        BntProdutos.setMaximumSize(new java.awt.Dimension(591, 519));
        BntProdutos.setMinimumSize(new java.awt.Dimension(591, 519));

        BntFuncionario.setBackground(new java.awt.Color(255, 153, 51));
        BntFuncionario.setFont(new java.awt.Font("Segoe UI", 1, 18));
        BntFuncionario.setForeground(new java.awt.Color(255, 255, 255));
        BntFuncionario.setText("Funcionarios");
        BntFuncionario.setMaximumSize(new java.awt.Dimension(591, 519));
        BntFuncionario.setMinimumSize(new java.awt.Dimension(591, 519));
        BntFuncionario.addActionListener(this::BntFuncionarioActionPerformed);

        BntRelatorios.setBackground(new java.awt.Color(255, 153, 51));
        BntRelatorios.setFont(new java.awt.Font("Segoe UI", 1, 18));
        BntRelatorios.setForeground(new java.awt.Color(255, 255, 255));
        BntRelatorios.setText("Relatorios");
        BntRelatorios.setMaximumSize(new java.awt.Dimension(591, 519));
        BntRelatorios.setMinimumSize(new java.awt.Dimension(591, 519));
        BntRelatorios.addActionListener(this::BntRelatoriosActionPerformed);

        bntSair.setBackground(new java.awt.Color(255, 153, 51));
        bntSair.setFont(new java.awt.Font("Segoe UI", 1, 18));
        bntSair.setForeground(new java.awt.Color(255, 255, 255));
        bntSair.setText("Sair");
        bntSair.setMaximumSize(new java.awt.Dimension(591, 519));
        bntSair.setMinimumSize(new java.awt.Dimension(591, 519));
        bntSair.addActionListener(this::bntSairActionPerformed);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jLabel1))
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGap(32, 32, 32)
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(BntCaixa, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(BntProdutos, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(BntFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(BntRelatorios, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(bntSair, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(0, 0, Short.MAX_VALUE)))
                                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(BntCaixa, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(BntProdutos, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(BntFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(BntRelatorios, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(bntSair, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
        );

        BntEditar.setBackground(new java.awt.Color(255, 153, 51));
        BntEditar.setForeground(new java.awt.Color(255, 255, 255));
        BntEditar.setText("Editar");
        BntEditar.addActionListener(this::BntEditarActionPerformed);

        BntDeletar.setBackground(new java.awt.Color(255, 51, 51));
        BntDeletar.setForeground(new java.awt.Color(255, 255, 255));
        BntDeletar.setText("Deletar");
        BntDeletar.addActionListener(this::BntDeletarActionPerformed);

        TxtBuscarProduto.setText("Buscar produto por ID ou nome");
        TxtBuscarProduto.addActionListener(this::TxtBuscarProdutoActionPerformed);

        jLabel2.setBackground(new java.awt.Color(0, 0, 0));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18));
        jLabel2.setText("Buscar produto");

        BntPesquisar.setBackground(new java.awt.Color(255, 153, 51));
        BntPesquisar.setForeground(new java.awt.Color(255, 255, 255));
        BntPesquisar.setText("Pesquisar");
        BntPesquisar.addActionListener(this::BntPesquisarActionPerformed);

        BntCadastrarProdutos.setBackground(new java.awt.Color(255, 153, 51));
        BntCadastrarProdutos.setForeground(new java.awt.Color(255, 255, 255));
        BntCadastrarProdutos.setText("Cadastrar Produto");
        BntCadastrarProdutos.addActionListener(this::BntCadastrarProdutosActionPerformed);

        jButton2.setBackground(new java.awt.Color(255, 153, 51));
        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 18));
        jButton2.setForeground(new java.awt.Color(255, 153, 51));
        jButton2.setText("Produtos");
        jButton2.setEnabled(false);

        TxtId.setEditable(false);
        jLabel3.setText("ID");
        TxtNome.addActionListener(this::TxtNomeActionPerformed);
        jLabel4.setText("Nome");
        jLabel6.setText("Custo");
        jLabel5.setText("Estoque");
        jLabel7.setText("Valor");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jButton2)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(145, 145, 145)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addComponent(TxtId, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(TxtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 418, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(TxtCusto, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(TxtEstoque, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(TxtPreco, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addComponent(jLabel2)
                                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 760, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addComponent(TxtBuscarProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(BntPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addGap(6, 6, 6)
                                                                .addComponent(jLabel3)
                                                                .addGap(78, 78, 78)
                                                                .addComponent(jLabel4)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(jLabel6)
                                                                .addGap(58, 58, 58)
                                                                .addComponent(jLabel5)
                                                                .addGap(42, 42, 42)
                                                                .addComponent(jLabel7)
                                                                .addGap(41, 41, 41))
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addComponent(BntCadastrarProdutos, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(BntEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(92, 92, 92)
                                                                .addComponent(BntDeletar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                .addGap(0, 175, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jButton2)
                                .addGap(17, 17, 17)
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(TxtBuscarProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(BntPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel3)
                                        .addComponent(jLabel4)
                                        .addComponent(jLabel6)
                                        .addComponent(jLabel5)
                                        .addComponent(jLabel7))
                                .addGap(1, 1, 1)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(TxtId, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(TxtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(TxtCusto, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(TxtEstoque, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(TxtPreco, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(BntCadastrarProdutos, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(BntEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(BntDeletar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(240, Short.MAX_VALUE))
        );

        DskCadastroProdutos.setLayer(jPanel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout DskCadastroProdutosLayout = new javax.swing.GroupLayout(DskCadastroProdutos);
        DskCadastroProdutos.setLayout(DskCadastroProdutosLayout);
        DskCadastroProdutosLayout.setHorizontalGroup(
                DskCadastroProdutosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(DskCadastroProdutosLayout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 18, Short.MAX_VALUE))
        );
        DskCadastroProdutosLayout.setVerticalGroup(
                DskCadastroProdutosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(DskCadastroProdutosLayout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 17, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 1390, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(DskCadastroProdutos)
                                        .addContainerGap()))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 941, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(DskCadastroProdutos, javax.swing.GroupLayout.Alignment.TRAILING))
        );
    }// </editor-fold>//GEN-END:initComponents



    private void BntEditarActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            int id = Integer.parseInt(TxtId.getText());
            String nome = TxtNome.getText();
            double custo = Double.parseDouble(TxtCusto.getText());
            int estoque = Integer.parseInt(TxtEstoque.getText());
            double preco = Double.parseDouble(TxtPreco.getText());


            ProdutoController.ResultadoOperacao res = produtoController.editarProduto(
                    id, nome, preco, custo, estoque, SessaoUsuario.getUsuarioLogado()
            );

            JOptionPane.showMessageDialog(this, res.getMensagem());
            if (res.isSucesso()) {
                listarProdutos();
                limparCampos();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,
                    "Campo não preenchido corretamente.\nErro: " + e.getMessage());
        }
    }

    private void BntDeletarActionPerformed(java.awt.event.ActionEvent evt) {
        int linha = TabelaProdutos.getSelectedRow();
        if (linha == -1) {
            JOptionPane.showMessageDialog(this, "Selecione um produto.");
            return;
        }
        int id = Integer.parseInt(TabelaProdutos.getValueAt(linha, 0).toString());


        ProdutoController.ResultadoOperacao res =
                produtoController.deletarProduto(id, SessaoUsuario.getUsuarioLogado());

        JOptionPane.showMessageDialog(this, res.getMensagem());
        if (res.isSucesso()) {
            listarProdutos();
            limparCampos();
        }
    }

    private void BntCadastrarProdutosActionPerformed(java.awt.event.ActionEvent evt) {
        TelaCadastroProdutos telaCad = new TelaCadastroProdutos();
        DskCadastroProdutos.add(telaCad);
        telaCad.setVisible(true);
        try { telaCad.setSelected(true); }
        catch (java.beans.PropertyVetoException e) { e.printStackTrace(); }
    }

    private void BntPesquisarActionPerformed(java.awt.event.ActionEvent evt) {
        String texto = TxtBuscarProduto.getText().trim();
        DefaultTableModel modelo = (DefaultTableModel) TabelaProdutos.getModel();
        modelo.setRowCount(0);


        ProdutoRepository repository = new ProdutoRepository();
        if (texto.matches("\\d+")) {
            Produto produto = repository.buscarPorId(Integer.parseInt(texto));
            if (produto != null) {
                modelo.addRow(new Object[]{
                        produto.getId(), produto.getNome(), produto.getCusto(),
                        produto.getEstoque(), produto.getPreco()
                });
            }
        } else {
            for (Produto p : repository.buscarPorNome(texto)) {
                modelo.addRow(new Object[]{
                        p.getId(), p.getNome(), p.getCusto(), p.getEstoque(), p.getPreco()
                });
            }
        }
    }

    private void TabelaProdutosMouseClicked(java.awt.event.MouseEvent evt) {
        int linha = TabelaProdutos.getSelectedRow();
        TxtId.setText(TabelaProdutos.getValueAt(linha, 0).toString());
        TxtNome.setText(TabelaProdutos.getValueAt(linha, 1).toString());
        TxtCusto.setText(TabelaProdutos.getValueAt(linha, 2).toString());
        TxtEstoque.setText(TabelaProdutos.getValueAt(linha, 3).toString());
        TxtPreco.setText(TabelaProdutos.getValueAt(linha, 4).toString());
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        TxtBuscarProduto.setText("");
        carregarTabela();
    }

    private void BntCaixaActionPerformed(java.awt.event.ActionEvent evt) {
        TelaVendas tela = new TelaVendas();
        tela.setSize(this.getSize());
        this.removeAll();
        this.setLayout(new BorderLayout());
        this.add(tela, BorderLayout.CENTER);
        this.revalidate();
        this.repaint();
    }

    private void BntFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {
        TelaFuncionarios tela = new TelaFuncionarios();
        tela.setSize(this.getSize());
        this.removeAll();
        this.setLayout(new BorderLayout());
        this.add(tela, BorderLayout.CENTER);
        this.revalidate();
        this.repaint();
    }

    private void BntRelatoriosActionPerformed(java.awt.event.ActionEvent evt) {
        TelaRelatorios tela = new TelaRelatorios();
        tela.setSize(this.getSize());
        this.removeAll();
        this.setLayout(new BorderLayout());
        this.add(tela, BorderLayout.CENTER);
        this.revalidate();
        this.repaint();
    }

    private void bntSairActionPerformed(java.awt.event.ActionEvent evt) {
        SessaoUsuario.limpar();
        MenuPrincipal tela = new MenuPrincipal();
        tela.setVisible(true);
        javax.swing.SwingUtilities.getWindowAncestor(this).dispose();
    }

    private void TxtBuscarProdutoActionPerformed(java.awt.event.ActionEvent evt) {}
    private void TxtNomeActionPerformed(java.awt.event.ActionEvent evt) {}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BntCadastrarProdutos;
    private javax.swing.JButton BntCaixa;
    private javax.swing.JButton BntDeletar;
    private javax.swing.JButton BntEditar;
    private javax.swing.JButton BntFuncionario;
    private javax.swing.JButton BntPesquisar;
    private javax.swing.JButton BntProdutos;
    private javax.swing.JButton BntRelatorios;
    private javax.swing.JDesktopPane DskCadastroProdutos;
    private javax.swing.JTable TabelaProdutos;
    private javax.swing.JTextField TxtBuscarProduto;
    private javax.swing.JTextField TxtCusto;
    private javax.swing.JTextField TxtEstoque;
    private javax.swing.JTextField TxtId;
    private javax.swing.JTextField TxtNome;
    private javax.swing.JTextField TxtPreco;
    private javax.swing.JButton bntSair;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
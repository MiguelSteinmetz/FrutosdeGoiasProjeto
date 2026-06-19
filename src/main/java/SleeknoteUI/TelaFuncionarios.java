package SleeknoteUI;

import Controller.UsuarioController;
import java.awt.BorderLayout;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Usuario;
import repository.UsuarioRepository;

public class TelaFuncionarios extends javax.swing.JPanel {


    private UsuarioController usuarioController = new UsuarioController();

    public TelaFuncionarios() {
        initComponents();
        carregarTabela();
    }


    public void listarUsuario() {
        DefaultTableModel modelo = (DefaultTableModel) TabelaFuncionarios.getModel();
        modelo.setRowCount(0);

        for (Usuario u : usuarioController.listarUsuarios()) {
            modelo.addRow(new Object[]{
                    u.getId(), u.getNome(), u.getLogin(), u.getSenha(), u.getTipo()
            });
        }
    }

    public void carregarTabela() {
        listarUsuario();
    }

    public void limparCampos() {
        TxtBuscarFuncionarios.setText("");
        TxtNome.setText("");
        TxtLogin.setText("");
        TxtSenha.setText("");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        DskCadastroFuncionarios = new javax.swing.JDesktopPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TabelaFuncionarios = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        BntCaixa = new javax.swing.JButton();
        BntProdutos = new javax.swing.JButton();
        BntFuncionario = new javax.swing.JButton();
        BntRelatorios = new javax.swing.JButton();
        BntSair = new javax.swing.JButton();
        BntEditar = new javax.swing.JButton();
        BntDeletar = new javax.swing.JButton();
        TxtBuscarFuncionarios = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        BntPesquisar = new javax.swing.JButton();
        BntCadastrarFuncionarios = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        TxtNome = new javax.swing.JTextField();
        TxtLogin = new javax.swing.JTextField();
        TxtSenha = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        CbxCargo = new javax.swing.JComboBox<>();

        DskCadastroFuncionarios.setBackground(new java.awt.Color(255, 255, 204));

        jPanel1.setBackground(new java.awt.Color(255, 255, 204));

        TabelaFuncionarios.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.darkGray, null, java.awt.Color.darkGray, java.awt.Color.darkGray));
        TabelaFuncionarios.setModel(new javax.swing.table.DefaultTableModel(
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
            public Class getColumnClass(int columnIndex) { return types[columnIndex]; }
        });
        TabelaFuncionarios.setShowGrid(false);
        TabelaFuncionarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TabelaFuncionariosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TabelaFuncionarios);

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
        BntProdutos.setMaximumSize(new java.awt.Dimension(591, 519));
        BntProdutos.setMinimumSize(new java.awt.Dimension(591, 519));
        BntProdutos.addActionListener(this::BntProdutosActionPerformed);

        BntFuncionario.setBackground(new java.awt.Color(255, 153, 51));
        BntFuncionario.setFont(new java.awt.Font("Segoe UI", 1, 18));
        BntFuncionario.setForeground(new java.awt.Color(255, 255, 255));
        BntFuncionario.setText("Funcionario");
        BntFuncionario.setEnabled(false);
        BntFuncionario.setMaximumSize(new java.awt.Dimension(591, 519));
        BntFuncionario.setMinimumSize(new java.awt.Dimension(591, 519));

        BntRelatorios.setBackground(new java.awt.Color(255, 153, 51));
        BntRelatorios.setFont(new java.awt.Font("Segoe UI", 1, 18));
        BntRelatorios.setForeground(new java.awt.Color(255, 255, 255));
        BntRelatorios.setText("Relatorios");
        BntRelatorios.setMaximumSize(new java.awt.Dimension(591, 519));
        BntRelatorios.setMinimumSize(new java.awt.Dimension(591, 519));
        BntRelatorios.addActionListener(this::BntRelatoriosActionPerformed);

        BntSair.setBackground(new java.awt.Color(255, 153, 51));
        BntSair.setFont(new java.awt.Font("Segoe UI", 1, 18));
        BntSair.setForeground(new java.awt.Color(255, 255, 255));
        BntSair.setText("Sair");
        BntSair.setMaximumSize(new java.awt.Dimension(591, 519));
        BntSair.setMinimumSize(new java.awt.Dimension(591, 519));
        BntSair.addActionListener(this::BntSairActionPerformed);

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
                                                        .addComponent(BntSair, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                                .addComponent(BntSair, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
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

        TxtBuscarFuncionarios.setText("Buscar Funcionario por ID ou nome");
        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18));
        jLabel2.setText("Buscar Funcionarios");

        BntPesquisar.setBackground(new java.awt.Color(255, 153, 51));
        BntPesquisar.setForeground(new java.awt.Color(255, 255, 255));
        BntPesquisar.setText("Pesquisar");
        BntPesquisar.addActionListener(this::BntPesquisarActionPerformed);

        BntCadastrarFuncionarios.setBackground(new java.awt.Color(255, 153, 51));
        BntCadastrarFuncionarios.setForeground(new java.awt.Color(255, 255, 255));
        BntCadastrarFuncionarios.setText("Cadastrar Funcionario");
        BntCadastrarFuncionarios.addActionListener(this::BntCadastrarFuncionariosActionPerformed);

        jButton2.setBackground(new java.awt.Color(255, 153, 51));
        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 18));
        jButton2.setForeground(new java.awt.Color(255, 153, 51));
        jButton2.setText("Funcionarios");
        jButton2.setEnabled(false);

        jLabel4.setText("Nome");
        jLabel6.setText("Login");
        jLabel5.setText("Senha");
        jLabel7.setText("Cargo");

        CbxCargo.setBackground(new java.awt.Color(255, 255, 255));
        CbxCargo.setForeground(new java.awt.Color(0, 0, 0));
        CbxCargo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Gerente", "Funcionario" }));

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
                                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 760, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addComponent(BntCadastrarFuncionarios, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(BntEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(88, 88, 88)
                                                                .addComponent(BntDeletar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(TxtBuscarFuncionarios, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(TxtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                                .addGap(21, 21, 21)
                                                                                .addComponent(jLabel4)))
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                                .addComponent(TxtLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addComponent(TxtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                        .addComponent(BntPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                                .addGap(6, 6, 6)
                                                                                .addComponent(jLabel6)
                                                                                .addGap(134, 134, 134)
                                                                                .addComponent(jLabel5)))
                                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                                .addComponent(jLabel7)
                                                                                .addGap(0, 0, Short.MAX_VALUE))
                                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                                .addComponent(CbxCargo, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addGap(9, 9, 9)
                                                                .addComponent(jLabel2)))))
                                .addContainerGap(261, Short.MAX_VALUE))
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
                                        .addComponent(TxtBuscarFuncionarios, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(BntPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel4)
                                        .addComponent(jLabel6)
                                        .addComponent(jLabel5)
                                        .addComponent(jLabel7))
                                .addGap(1, 1, 1)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(TxtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(TxtLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(TxtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(CbxCargo, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(BntCadastrarFuncionarios, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(BntEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(BntDeletar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(240, 240, 240))
        );

        DskCadastroFuncionarios.setLayer(jPanel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout DskLayout = new javax.swing.GroupLayout(DskCadastroFuncionarios);
        DskCadastroFuncionarios.setLayout(DskLayout);
        DskLayout.setHorizontalGroup(
                DskLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(DskLayout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
        );
        DskLayout.setVerticalGroup(
                DskLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(DskLayout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 19, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 1366, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(DskCadastroFuncionarios)
                                        .addContainerGap()))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 948, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(DskCadastroFuncionarios, javax.swing.GroupLayout.Alignment.TRAILING))
        );
    }// </editor-fold>//GEN-END:initComponents



    private void BntEditarActionPerformed(java.awt.event.ActionEvent evt) {
        int linha = TabelaFuncionarios.getSelectedRow();
        if (linha == -1) {
            JOptionPane.showMessageDialog(this, "Selecione um usuário na tabela.");
            return;
        }
        try {
            int id = Integer.parseInt(TabelaFuncionarios.getValueAt(linha, 0).toString());
            String nome  = TxtNome.getText();
            String login = TxtLogin.getText();
            String senha = TxtSenha.getText();
            String tipo  = CbxCargo.getSelectedItem().toString();


            Usuario u = new Usuario();
            u.setId(id);
            u.setNome(nome);
            u.setLogin(login);
            u.setSenha(senha);
            u.setTipo(tipo);
            new repository.UsuarioRepository().atualizar(u);

            JOptionPane.showMessageDialog(this, "Usuário atualizado!");
            carregarTabela();
            limparCampos();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro: " + e.getMessage());
        }
    }

    private void BntDeletarActionPerformed(java.awt.event.ActionEvent evt) {
        int linha = TabelaFuncionarios.getSelectedRow();
        if (linha == -1) {
            JOptionPane.showMessageDialog(this, "Selecione um usuário na tabela.");
            return;
        }
        int id = Integer.parseInt(TabelaFuncionarios.getValueAt(linha, 0).toString());
        Usuario u = new Usuario();
        u.setId(id);
        new repository.UsuarioRepository().remover(u);
        JOptionPane.showMessageDialog(this, "Usuário removido!");
        carregarTabela();
        limparCampos();
    }

    private void BntCadastrarFuncionariosActionPerformed(java.awt.event.ActionEvent evt) {
        TelaCadastroFuncionarios telaCad = new TelaCadastroFuncionarios();
        DskCadastroFuncionarios.add(telaCad);
        telaCad.setVisible(true);
        try { telaCad.setSelected(true); }
        catch (java.beans.PropertyVetoException e) { e.printStackTrace(); }
    }

    private void BntPesquisarActionPerformed(java.awt.event.ActionEvent evt) {
        String texto = TxtBuscarFuncionarios.getText().trim();
        UsuarioRepository repository = new UsuarioRepository();
        DefaultTableModel modelo = (DefaultTableModel) TabelaFuncionarios.getModel();
        modelo.setRowCount(0);

        if (texto.matches("\\d+")) {
            Usuario u = repository.buscarPorId(Integer.parseInt(texto));
            if (u != null) {
                modelo.addRow(new Object[]{
                        u.getId(), u.getNome(), u.getLogin(), u.getSenha(), u.getTipo()
                });
            }
        } else {
            for (Usuario u : repository.buscarPorNome(texto)) {
                modelo.addRow(new Object[]{
                        u.getId(), u.getNome(), u.getLogin(), u.getSenha(), u.getTipo()
                });
            }
        }
    }

    private void TabelaFuncionariosMouseClicked(java.awt.event.MouseEvent evt) {
        int linha = TabelaFuncionarios.getSelectedRow();
        TxtNome.setText(TabelaFuncionarios.getValueAt(linha, 1).toString());
        TxtLogin.setText(TabelaFuncionarios.getValueAt(linha, 2).toString());
        TxtSenha.setText(TabelaFuncionarios.getValueAt(linha, 3).toString());
        CbxCargo.setSelectedItem(TabelaFuncionarios.getValueAt(linha, 4).toString());
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        limparCampos();
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

    private void BntProdutosActionPerformed(java.awt.event.ActionEvent evt) {
        TelaProdutos tela = new TelaProdutos();
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

    private void BntSairActionPerformed(java.awt.event.ActionEvent evt) {

        usuarioController.logout();
        MenuPrincipal tela = new MenuPrincipal();
        tela.setVisible(true);
        javax.swing.SwingUtilities.getWindowAncestor(this).dispose();
    }


    private javax.swing.JButton BntCadastrarFuncionarios;
    private javax.swing.JButton BntCaixa;
    private javax.swing.JButton BntDeletar;
    private javax.swing.JButton BntEditar;
    private javax.swing.JButton BntFuncionario;
    private javax.swing.JButton BntPesquisar;
    private javax.swing.JButton BntProdutos;
    private javax.swing.JButton BntRelatorios;
    private javax.swing.JButton BntSair;
    private javax.swing.JComboBox<String> CbxCargo;
    private javax.swing.JDesktopPane DskCadastroFuncionarios;
    private javax.swing.JTable TabelaFuncionarios;
    private javax.swing.JTextField TxtBuscarFuncionarios;
    private javax.swing.JTextField TxtLogin;
    private javax.swing.JTextField TxtNome;
    private javax.swing.JTextField TxtSenha;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
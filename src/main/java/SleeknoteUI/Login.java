package SleeknoteUI;

import model.Usuario;
import service.LogService;
import service.UsuarioService;
import model.SessaoUsuario;

public class Login extends javax.swing.JPanel {

    
    private UsuarioService service = new UsuarioService();
    private MenuPrincipal mainPanel;
    LogService log = new LogService();

    public Login(MenuPrincipal mainPanel) {
        this.mainPanel = mainPanel;
        initComponents();

    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jPasswordField1 = new javax.swing.JPasswordField();
        jButton1 = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(1366, 768));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Fundo Login 2.png")));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);

        jPanel3Layout.setHorizontalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel2)
        );

        jPanel3Layout.setVerticalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel2)
        );

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logo_256x256.png")));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18));
        jLabel4.setText("Login");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18));
        jLabel5.setText("Senha");

      

        jButton1.setText("Logar");
        jButton1.addActionListener(evt -> logar());

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);

        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(100)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel3)
                                        .addComponent(jLabel4)
                                        .addComponent(jTextField1, 200, 200, 200)
                                        .addComponent(jLabel5)
                                        .addComponent(jPasswordField1, 200, 200, 200)
                                        .addComponent(jButton1, 200, 200, 200))
                                .addGap(100)
                                .addComponent(jPanel3))
        );

        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel3)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(150)
                                .addComponent(jLabel3)
                                .addGap(30)
                                .addComponent(jLabel4)
                                .addGap(10)
                                .addComponent(jTextField1, 30, 30, 30)
                                .addGap(10)
                                .addComponent(jLabel5)
                                .addGap(10)
                                .addComponent(jPasswordField1, 30, 30, 30)
                                .addGap(10)
                                .addGap(20)
                                .addComponent(jButton1, 40, 40, 40))
        );

        setLayout(new java.awt.BorderLayout());
        add(jPanel2, java.awt.BorderLayout.CENTER);
    }

    private void logar() {
         String login = jTextField1.getText();
        String senha = new String(jPasswordField1.getPassword());

        if (login.isEmpty() || senha.isEmpty()) {
            javax.swing.JOptionPane.showMessageDialog(this, "Preencha todos os campos!");
            return;
        }
        Usuario logado = service.autenticar(login, senha);
        
        if (logado != null) {
            SessaoUsuario.setUsuarioLogado(logado);
            log.registrar(logado.getNome(), "Entrou no sistema");
          
            mainPanel.irParaMenu(); //troca de tela para menu
        } else {
            javax.swing.JOptionPane.showMessageDialog(this, "Usuário ou senha inválidos!");
        }
    }

    private javax.swing.JButton jButton1;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JTextField jTextField1;
}
package SleeknoteUI;

import java.awt.CardLayout;
import javax.swing.JPanel;

public class MenuPrincipal extends javax.swing.JFrame {

    private CardLayout layout;
    private JPanel container;

    public MenuPrincipal() {
    setSize(612, 600);
    setLocationRelativeTo(null);
     layout = new CardLayout();
    container = new JPanel(layout);

    // telas
    Login login = new Login(this);
    TelaInicial inicial = new TelaInicial();
    TelaVendas vendas = new TelaVendas();
    TelaRelatorios relatorios = new TelaRelatorios();

    container.add(login, "LOGIN");
    container.add(inicial, "INICIAL");
    container.add(vendas, "VENDAS");
    container.add(relatorios, "RELATORIOS");

    setContentPane(container);

    layout.show(container, "LOGIN");


    setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    // Metodos de navegacao
    
    public void irParaMenu() {
        layout.show(container, "INICIAL");
          setSize(1366, 768);
          setLocationRelativeTo(null);
          
        
    }

    public void irParaProdutos() {
        layout.show(container, "PRODUTOS");
    }

    public void irParaRelatorios() {
        layout.show(container, "RELATORIOS");
    }

    public void voltarLogin() {
        layout.show(container, "LOGIN");
    }

    
    // acoes dos menus
    
    private void ProdutosActionPerformed(java.awt.event.ActionEvent evt) {
        irParaProdutos();
    }

    private void RelattoriosActionPerformed(java.awt.event.ActionEvent evt) {
        irParaRelatorios();
    }

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {
        voltarLogin();
    }

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {
        irParaProdutos();
    }

    // =========================
    // MAIN
    
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            new MenuPrincipal().setVisible(true);
        });
    }

    // =========================
    // COMPONENTES (mantém do NetBeans)
    // =========================
    private javax.swing.JMenu Funcionarios;
    private javax.swing.JMenu Login;
    private javax.swing.JMenu Menu;
    private javax.swing.JMenu Produtos;
    private javax.swing.JMenu Registros;
    private javax.swing.JMenu Relattorios;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
}
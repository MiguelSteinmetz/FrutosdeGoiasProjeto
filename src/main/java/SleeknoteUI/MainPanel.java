package SleeknoteUI;

import javax.swing.*;
import java.awt.*;

public class MainPanel extends JPanel {

    private CardLayout layout;

    public static final String LOGIN = "login";
    public static final String MENU = "menu";

    public MainPanel() {
        layout = new CardLayout();
        setLayout(layout);

        // telas
        Login login = new Login(this);
        MenuPrincipal menu = new MenuPrincipal();

        add(login, LOGIN);
        add(menu, MENU);

        layout.show(this, LOGIN);
    }

    public void irParaMenu() {
        layout.show(this, MENU);
    }
}
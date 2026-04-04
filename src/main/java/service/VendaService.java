//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package service;

import model.Funcionario;
import model.Usuario;

public class VendaService {
    private double totalGeralLoja = (double)0.0F;

    public void salvarVenda(double valorFinal, Usuario logado) {
        this.totalGeralLoja += valorFinal;
        if (logado instanceof Funcionario) {
            ((Funcionario)logado).adicionarVenda(valorFinal);
        }

    }

    public double getTotalLoja() {
        return this.totalGeralLoja;
    }
}

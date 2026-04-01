package service;

import model.Usuario;
import model.Funcionario;

public class VendaService {
    private double totalGeralLoja = 0.0;

    public void salvarVenda(double valorFinal, Usuario logado) {
        this.totalGeralLoja += valorFinal;

        if (logado instanceof Funcionario) {
            ((Funcionario) logado).adicionarVenda(valorFinal);
        }
    }

    public double getTotalLoja() { return totalGeralLoja; }
}
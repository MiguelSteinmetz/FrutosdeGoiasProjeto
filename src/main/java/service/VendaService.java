package service;

import model.Usuario;
import model.Funcionario;

public class VendaService {
    private double totalGeralLoja = 0.0;

    public void salvarVenda(double valorFinal, Usuario logado) {
        totalGeralLoja += valorFinal;

        // Se quem vendeu foi um funcionário, atualiza a performance dele
        if (logado instanceof Funcionario) {
            ((Funcionario) logado).adicionarVenda(valorFinal);
        }
    }

    public double getTotalLoja() {
        return totalGeralLoja;
    }
}
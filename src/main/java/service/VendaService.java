//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package service;

import model.Funcionario;
import model.Usuario;
import model.Venda;
import repository.VendaRepository;

import java.util.List;

public class VendaService {

    VendaRepository vendaRepository = new VendaRepository();
    private double totalGeralLoja = 0.0;

    public void salvarVenda(double valorFinal, Usuario logado) {
        this.totalGeralLoja += valorFinal;
        }

    public List<Venda> relatorioVendas(){
        List<Venda> vendas = vendaRepository.buscartodos();
        return vendas;
    }

    public double getTotalLoja() {
        return this.totalGeralLoja;
    }
}

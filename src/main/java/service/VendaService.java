//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package service;

import model.Usuario;
import model.Venda;
import repository.VendaRepository;

import java.util.List;

public class VendaService {

    VendaRepository vendaRepository = new VendaRepository();


    public void salvarVenda(Venda venda) {
            vendaRepository.salvar(venda);
        }

    public List<Venda> relatorioVendas(){
        List<Venda> vendas = vendaRepository.buscartodos();
        return vendas;
    }


}

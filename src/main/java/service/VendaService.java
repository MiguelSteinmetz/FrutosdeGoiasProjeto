package service;


import model.Venda;
import org.hibernate.Session;
import repository.CustomizerFactory;
import repository.VendaRepository;

import java.util.List;

public class VendaService {
    VendaRepository vendaRepository = new VendaRepository();


    public void salvarVenda(Venda venda) {
        vendaRepository.salvar(venda);
    }

    public List<Venda> relatorioVendas(){
        List<Venda> vendas = vendaRepository.buscarTodos();
        return vendas;
    }


    public Long totalVendidoPorProduto(int produtoId) {
        VendaRepository repo = new VendaRepository();
        return repo.totalVendidoPorProduto(produtoId);
    }

    public List<Object[]> topProdutosVendidos() {
        return vendaRepository.topProdutosVendidos();
    }
    public List<Venda> listarVendas() {
        return vendaRepository.buscarTodos();
    }
}

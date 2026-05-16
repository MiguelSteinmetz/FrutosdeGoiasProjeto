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

    
    
    public List<Object[]> totalVendidoProduto(){ return vendaRepository.totalVendidoProduto();}
   
    
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

    public double getFaturamentoTotal() {
        
        List<Venda> vendas = vendaRepository.buscarTodos();

        double faturamentoTotal = 0;
        for(Venda v : vendas) {
            faturamentoTotal +=  v.getProduto().getPreco()  * v.getQuantidade();
        }
        return faturamentoTotal;
    }

    public int getQuantidadeVendida() {

        List<Venda> vendas =   vendaRepository.buscarTodos();
        int total = 0;
        for(Venda v : vendas) {
            total += v.getQuantidade();
        }
        return total;
    }

    public String getProdutoMaisVendido() {

        List<Object[]> lista =
                vendaRepository.topProdutosVendidos();
        if(lista.isEmpty()) {
            return "Nenhum";
        }
        return lista.get(0)[0].toString();
    }
   
    public double getCustoTotal(){

     List<Venda> vendas =
            vendaRepository.buscarTodos();

        double custoTotal = 0;

     for(Venda v : vendas) {
          double custo =  v.getProduto().getCusto();
          custoTotal += custo * v.getQuantidade();
    }

     return custoTotal;
    }

    public Double getLucroTotal() {
       List<Venda> vendas =
            vendaRepository.buscarTodos();

    double lucroTotal = 0;

    for(Venda v : vendas) {
        double preco =  v.getProduto().getPreco();
        double custo = v.getProduto().getCusto();

        double lucro = (preco - custo)   * v.getQuantidade();
        lucroTotal += lucro;
        
    }

        return lucroTotal;
    }
    
    
}

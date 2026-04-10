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
        try (Session session = CustomizerFactory.getSessionFactory().openSession()) {

            String hql = """
            SELECT v.produto.nome, SUM(v.quantidade)
            FROM Venda v
            GROUP BY v.produto.nome
            ORDER BY SUM(v.quantidade) DESC
        """;

            return session.createQuery(hql).getResultList();
        }
    }
}

package service;

import model.Venda;

import java.util.ArrayList;
import java.util.List;

public class VendaService {

    private List<Venda> vendas = new ArrayList<>();

    public void registrarVenda(Venda venda) {
        vendas.add(venda);
    }

    public double calcularTotalVendas() {
        double total = 0;
        for (Venda v : vendas) {
            total += v.calcularTotal();
        }
        return total;
    }
}
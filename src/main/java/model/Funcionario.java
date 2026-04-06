//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)

package model;

public class Funcionario {
    private double totalVendas = (double)0.0F;


    public void adicionarVenda(double valor) {
        this.totalVendas += valor;
    }

    public double getTotalVendas() {
        return this.totalVendas;
    }
}

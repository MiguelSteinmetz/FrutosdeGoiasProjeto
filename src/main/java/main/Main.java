package main;

import database.ConectBanco;

import java.sql.Connection;

public class Main {
    public static void main(String[] args) {

        try {
            System.out.println("Tentando conectar..."); // Adicione isso para testar
            Connection conn = ConectBanco.conectar();
            System.out.println("✅ Conectado com sucesso!");
        } catch (Exception e) {
            System.out.println("❌ Erro ao conectar!");
            e.printStackTrace();
        }

        Sistema sistema = new Sistema();
        sistema.iniciar();
    }
}
package repository;

import database.ConectBanco;
import model.Produto;
import model.ProdutoFisico;
import model.ProdutoServico;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProdutoRepository {

    public void salvar(Produto p) {
        // 6 colunas = 6 interrogações
        String sql = "INSERT INTO produtos (id, nome, tipo, preco, custo, estoque) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = ConectBanco.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, p.getId());
            stmt.setString(2, p.getNome());
            stmt.setString(3, p.getTipo());
            stmt.setDouble(4, p.getPreco());
            stmt.setDouble(6, p.getEstoque());

            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Produto> listar() {
        List<Produto> lista = new ArrayList<>();

        String sql = "SELECT * FROM produtos";

        try (Connection conn = ConectBanco.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                String tipo = rs.getString("tipo");
                Produto p;

                if ("FISICO".equals(tipo)) {
                    p = new ProdutoFisico(
                            rs.getInt("id"),
                            rs.getString("nome"),
                            rs.getDouble("preco"),
                            rs.getDouble("estoque")
                    );
                } else {
                    // AGORA PASSAMOS OS ARGUMENTOS:
                    p = new ProdutoServico(
                            rs.getInt("id"),
                            rs.getString("nome"),
                            rs.getDouble("preco"),
                            rs.getDouble("estoque")
                    );
                }
                lista.add(p);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return lista;
    }
}
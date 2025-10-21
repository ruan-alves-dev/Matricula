package dao;

import factory.ConnectionFactory;
import model.Disciplina;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DisciplinaDAO {

    // CREATE - Inserir disciplina
    public void inserir(Disciplina disciplina) {
        String sql = "INSERT INTO disciplina (id, nome_disciplina, sigla) VALUES (?, ?, ?)";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, disciplina.getId());
            stmt.setString(2, disciplina.getNome());
            stmt.setString(3, disciplina.getSigla());

            stmt.executeUpdate();
            System.out.println("Disciplina inserida com sucesso!");

        } catch (SQLException e) {
            System.out.println("Erro ao inserir disciplina: " + e.getMessage());
        }
    }

    // READ - Listar disciplinas
    public List<Disciplina> listar() {
        String sql = "SELECT * FROM disciplina";
        List<Disciplina> disciplinas = new ArrayList<>();

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Disciplina d = new Disciplina();
                d.setId(rs.getInt("id"));
                d.setNome(rs.getString("nome_disciplina"));
                d.setSigla(rs.getString("sigla"));

                disciplinas.add(d);
            }

        } catch (SQLException e) {
            System.out.println("Erro ao listar disciplinas: " + e.getMessage());
        }

        return disciplinas;
    }

    // UPDATE - Atualizar disciplina
    public void atualizar(Disciplina disciplina) {
        String sql = "UPDATE disciplina SET nome_disciplina = ?, sigla = ? WHERE id = ?";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, disciplina.getNome());
            stmt.setString(2, disciplina.getSigla());
            stmt.setInt(3, disciplina.getId());

            stmt.executeUpdate();
            System.out.println("Disciplina atualizada com sucesso!");

        } catch (SQLException e) {
            System.out.println("Erro ao atualizar disciplina: " + e.getMessage());
        }
    }

    // DELETE - Deletar disciplina
    public void deletar(int id) {
        String sql = "DELETE FROM disciplina WHERE id = ?";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();

            System.out.println("Disciplina removida com sucesso!");

        } catch (SQLException e) {
            System.out.println("Erro ao remover disciplina: " + e.getMessage());
        }
    }
}

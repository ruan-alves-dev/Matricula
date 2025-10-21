package dao;

import factory.ConnectionFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MatriculaDAO {

    // Matricular aluno em disciplina
    public void matricular(int idAluno, int idDisciplina) {
        String sql = "INSERT INTO aluno_disciplina (id_aluno, id_disciplina) VALUES (?, ?)";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idAluno);
            stmt.setInt(2, idDisciplina);
            stmt.executeUpdate();

            System.out.println("Aluno matriculado com sucesso!");

        } catch (SQLException e) {
            System.out.println("Erro ao matricular aluno: " + e.getMessage());
        }
    }

    // Listar disciplinas de um aluno
    public List<Integer> listarDisciplinasDoAluno(int idAluno) {
        String sql = "SELECT id_disciplina FROM aluno_disciplina WHERE id_aluno = ?";
        List<Integer> disciplinas = new ArrayList<>();

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idAluno);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                disciplinas.add(rs.getInt("id_disciplina"));
            }

        } catch (SQLException e) {
            System.out.println("Erro ao listar disciplinas do aluno: " + e.getMessage());
        }

        return disciplinas;
    }

    // Listar alunos de uma disciplina
    public List<Integer> listarAlunosDaDisciplina(int idDisciplina) {
        String sql = "SELECT id_aluno FROM aluno_disciplina WHERE id_disciplina = ?";
        List<Integer> alunos = new ArrayList<>();

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idDisciplina);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                alunos.add(rs.getInt("id_aluno"));
            }

        } catch (SQLException e) {
            System.out.println("Erro ao listar alunos da disciplina: " + e.getMessage());
        }

        return alunos;
    }

    // Remover matrícula
    public void removerMatricula(int idAluno, int idDisciplina) {
        String sql = "DELETE FROM aluno_disciplina WHERE id_aluno = ? AND id_disciplina = ?";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idAluno);
            stmt.setInt(2, idDisciplina);
            stmt.executeUpdate();

            System.out.println("Matrícula removida com sucesso!");

        } catch (SQLException e) {
            System.out.println("Erro ao remover matrícula: " + e.getMessage());
        }
    }
}

package application;

import dao.AlunoDAO;
import dao.DisciplinaDAO;
import dao.MatriculaDAO;
import model.Aluno;
import model.Disciplina;

import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        AlunoDAO alunoDAO = new AlunoDAO();
        DisciplinaDAO disciplinaDAO = new DisciplinaDAO();
        MatriculaDAO matriculaDAO = new MatriculaDAO();

        int opcaoPrincipal = 0;

        while (opcaoPrincipal != 4) {
            System.out.println("\n======= MENU PRINCIPAL =======");
            System.out.println("1 - Menu Aluno");
            System.out.println("2 - Menu Disciplina");
            System.out.println("3 - Menu Matrícula");
            System.out.println("4 - Sair");
            System.out.print("Escolha uma opção: ");
            opcaoPrincipal = sc.nextInt();
            sc.nextLine();

            switch (opcaoPrincipal) {
                case 1:
                    menuAluno(sc, alunoDAO);
                    break;
                case 2:
                    menuDisciplina(sc, disciplinaDAO);
                    break;
                case 3:
                    menuMatricula(sc, matriculaDAO);
                    break;
                case 4:
                    System.out.println("Encerrando o sistema...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        }

        sc.close();
    }

    // ===== MENU ALUNO =====
    private static void menuAluno(Scanner sc, AlunoDAO alunoDAO) {
        int opcao = 0;
        while (opcao != 5) {
            System.out.println("\n======= MENU ALUNO =======");
            System.out.println("1 - Inserir aluno");
            System.out.println("2 - Listar alunos");
            System.out.println("3 - Atualizar aluno");
            System.out.println("4 - Deletar aluno");
            System.out.println("5 - Voltar ao menu principal");
            System.out.print("Escolha uma opção: ");
            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Digite o nome: ");
                    String nome = sc.nextLine();

                    System.out.print("Digite o CPF: ");
                    String cpf = sc.nextLine();

                    System.out.print("Digite o endereço: ");
                    String endereco = sc.nextLine();

                    Aluno novo = new Aluno();
                    novo.setNome(nome);
                    novo.setCpf(cpf);
                    novo.setEndereco(endereco);

                    alunoDAO.inserir(novo);
                    break;

                case 2:
                    System.out.println("\n===== LISTA DE ALUNOS =====");
                    for (Aluno a : alunoDAO.listar()) {
                        System.out.println(a);
                    }
                    break;

                case 3:
                    System.out.print("Digite o ID do aluno a ser atualizado: ");
                    int idAtualizar = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Novo nome: ");
                    String novoNome = sc.nextLine();

                    System.out.print("Novo CPF: ");
                    String novoCpf = sc.nextLine();

                    System.out.print("Novo endereço: ");
                    String novoEndereco = sc.nextLine();

                    Aluno atualizado = new Aluno();
                    atualizado.setId(idAtualizar);
                    atualizado.setNome(novoNome);
                    atualizado.setCpf(novoCpf);
                    atualizado.setEndereco(novoEndereco);

                    alunoDAO.atualizar(atualizado);
                    break;

                case 4:
                    System.out.print("Digite o ID do aluno a ser removido: ");
                    int idDeletar = sc.nextInt();
                    alunoDAO.deletar(idDeletar);
                    break;

                case 5:
                    System.out.println("Voltando ao menu principal...");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }
        }
    }

    // ===== MENU DISCIPLINA =====
    private static void menuDisciplina(Scanner sc, DisciplinaDAO disciplinaDAO) {
        int opcao = 0;
        while (opcao != 5) {
            System.out.println("\n======= MENU DISCIPLINA =======");
            System.out.println("1 - Inserir disciplina");
            System.out.println("2 - Listar disciplinas");
            System.out.println("3 - Atualizar disciplina");
            System.out.println("4 - Deletar disciplina");
            System.out.println("5 - Voltar ao menu principal");
            System.out.print("Escolha uma opção: ");
            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Digite o ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Digite o nome da disciplina: ");
                    String nome = sc.nextLine();

                    System.out.print("Digite a sigla: ");
                    String sigla = sc.nextLine();

                    Disciplina nova = new Disciplina();
                    nova.setId(id);
                    nova.setNome(nome);
                    nova.setSigla(sigla);

                    disciplinaDAO.inserir(nova);
                    break;

                case 2:
                    System.out.println("\n===== LISTA DE DISCIPLINAS =====");
                    for (Disciplina d : disciplinaDAO.listar()) {
                        System.out.println(d);
                    }
                    break;

                case 3:
                    System.out.print("Digite o ID da disciplina a ser atualizada: ");
                    int idAtualizar = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Novo nome: ");
                    String novoNome = sc.nextLine();

                    System.out.print("Nova sigla: ");
                    String novaSigla = sc.nextLine();

                    Disciplina atualizada = new Disciplina();
                    atualizada.setId(idAtualizar);
                    atualizada.setNome(novoNome);
                    atualizada.setSigla(novaSigla);

                    disciplinaDAO.atualizar(atualizada);
                    break;

                case 4:
                    System.out.print("Digite o ID da disciplina a ser removida: ");
                    int idDeletar = sc.nextInt();
                    disciplinaDAO.deletar(idDeletar);
                    break;

                case 5:
                    System.out.println("Voltando ao menu principal...");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }
        }
    }

    // ===== MENU MATRÍCULA =====
    private static void menuMatricula(Scanner sc, MatriculaDAO matriculaDAO) {
        int opcao = 0;
        while (opcao != 5) {
            System.out.println("\n======= MENU MATRÍCULA =======");
            System.out.println("1 - Matricular aluno em disciplina");
            System.out.println("2 - Listar disciplinas de um aluno");
            System.out.println("3 - Listar alunos de uma disciplina");
            System.out.println("4 - Remover matrícula");
            System.out.println("5 - Voltar ao menu principal");
            System.out.print("Escolha uma opção: ");
            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("ID do aluno: ");
                    int idAluno = sc.nextInt();
                    System.out.print("ID da disciplina: ");
                    int idDisciplina = sc.nextInt();
                    sc.nextLine();

                    matriculaDAO.matricular(idAluno, idDisciplina);
                    break;

                case 2:
                    System.out.print("ID do aluno: ");
                    int idAlunoList = sc.nextInt();
                    sc.nextLine();

                    List<Integer> disciplinas = matriculaDAO.listarDisciplinasDoAluno(idAlunoList);
                    System.out.println("Disciplinas do aluno " + idAlunoList + ": " + disciplinas);
                    break;

                case 3:
                    System.out.print("ID da disciplina: ");
                    int idDiscList = sc.nextInt();
                    sc.nextLine();

                    List<Integer> alunos = matriculaDAO.listarAlunosDaDisciplina(idDiscList);
                    System.out.println("Alunos da disciplina " + idDiscList + ": " + alunos);
                    break;

                case 4:
                    System.out.print("ID do aluno: ");
                    int idAlunoRemover = sc.nextInt();
                    System.out.print("ID da disciplina: ");
                    int idDiscRemover = sc.nextInt();
                    sc.nextLine();

                    matriculaDAO.removerMatricula(idAlunoRemover, idDiscRemover);
                    break;

                case 5:
                    System.out.println("Voltando ao menu principal...");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }
        }
    }
}

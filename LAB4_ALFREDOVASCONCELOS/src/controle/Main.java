package controle;

import java.util.Scanner;

/**
 * Interface com menus texto para manipular um Controle de Alunos.
 *
 * @author Alfredo Vasconcelos
 */
public class Main {
    public static void main(String[] args) {
        ControleAlunos controle = new ControleAlunos();
        Scanner scanner = new Scanner(System.in);
        String escolha;
        while (true) {
            escolha = menu(scanner);
            comando(escolha, controle, scanner);
        }
    }

    /**
     * Exibe o menu e captura a escolha do/a usuário/a.
     *
     * @param scanner Para captura da opção do usuário.
     * @return O comando escolhido.
     */
    private static String menu(Scanner scanner) {
        System.out.print(
                """

                        (C)adastrar Aluno
                        (E)xibir Aluno
                        (N)ovo Grupo
                        (A)locar Aluno no Grupo e Verificar pertinência a Grupos
                        (R)egistrar Aluno que Respondeu
                        (I)mprimir Alunos que Responderam
                        (O)lhaí quais Grupos o Aluno Tá.
                        (S)im, quero Fechar o Programa!
                        Opção>\s""");
        return scanner.nextLine().toUpperCase();
    }

    /**
     * Interpreta a opção escolhida por quem está usando o sistema e invoca
     * a função que ira manipular o controle de alunos.
     *
     * @param opcao   Opção digitada.
     * @param controle  Controle de Alunos que está sendo manipulado.
     * @param scanner Objeto scanner para o caso do comando precisar de mais input.
     */
    private static void comando(String opcao,ControleAlunos controle, Scanner scanner) {
        switch (opcao) {
            case "C" -> cadastraAluno(controle, scanner);
            case "E" -> consultaAluno(controle, scanner);
            case "N" -> cadastraGrupo(controle,scanner);
            case "A" -> alocaPertence(controle, scanner);
            case "R" -> registraParticpacao(controle, scanner);
            case "I" -> listaAlunos(controle);
            case "O" -> buscaGrupos(controle, scanner);
            case "S" -> System.exit(0);
            default -> {
                if(opcao.isEmpty()){throw new IllegalArgumentException("Entrada Inválida");}
                System.out.println("Opção inválida!");
            }
        }
    }

    /**
     * Cadastra um Aluno no controle de alunos
     *
     * @param controle Controle de Alunos que está sendo manipulado.
     * @param scanner Scanner para pedir informações do contato.
     */
    private static void cadastraAluno(ControleAlunos controle, Scanner scanner) {
        System.out.print("\nMatrícula: ");
        String matricula = scanner.nextLine().trim();
        if(matricula.isEmpty()) {
            System.out.println("Matrícula vazia");
            System.exit(1);
        }

        System.out.print("Nome: ");
        String nome = scanner.nextLine().trim();
        if (nome.isEmpty()) {
            System.out.println("Nome Invalido");
            System.exit(1);
        }

        System.out.print("Curso: ");
        String curso = scanner.nextLine().trim();
        if (curso.isEmpty()) {
            System.out.println("Curso Invalido");
            System.exit(1);
        }

        System.out.println(controle.cadastraAluno(matricula, nome, curso));
    }

    /**
     * Busca um aluno no Controle de alunos
     *
     * @param controle Controle de Alunos que está sendo manipulado.
     * @param scanner Scanner para pedir informações do contato.
     */
    private static void consultaAluno(ControleAlunos controle, Scanner scanner) {
        System.out.print("\nMatrícula: ");
        String matricula = scanner.nextLine();
        if(matricula.isEmpty()) {
            System.out.println("Matrícula vazia");
            System.exit(1);
        }

        System.out.println(controle.getAluno(matricula));
    }

    /**
     * Cadastra um Grupo no controle de alunos
     *
     * @param controle Controle de Alunos que está sendo manipulado.
     * @param scanner Scanner para pedir informações do contato.
     */
    private static void cadastraGrupo(ControleAlunos controle, Scanner scanner) {
        System.out.print("\nGrupo: ");
        String nomeGrupo = scanner.nextLine().trim();
        if (nomeGrupo.isEmpty()) {
            System.out.println("Nome de Grupo Inválido");
            System.exit(1);
        }

        System.out.print("Tamanho: ");
        String tamanho = scanner.nextLine().trim();

        System.out.println(controle.cadastraGrupo(nomeGrupo, tamanho));
    }

    /**
     * Aloca Aluno a um grupo ou verifica se o aluno pertece a um determinado
     * grupo.
     * @param controle Controle de Alunos que está sendo manipulado.
     * @param scanner Scanner para pedir informações do contato.
     */
    private static void alocaPertence(ControleAlunos controle, Scanner scanner) {
        System.out.print("\n(A)locar Aluno ou (P)ertinência a Grupo? ");
        String escolha = scanner.nextLine().trim().toUpperCase();
        switch (escolha) {
            case "A" -> {
                System.out.print("Matrícula: ");
                String matricula = scanner.nextLine();

                System.out.print("Grupo: ");
                String nomeGrupo = scanner.nextLine().trim();

                System.out.println(controle.alocaAluno(matricula, nomeGrupo));
            }
            case "P" -> {
                System.out.print("Grupo: ");
                String nomeGrupo = scanner.nextLine().trim();

                System.out.print("Matrícula: ");
                String matricula = scanner.nextLine().trim();

                System.out.println(controle.pertence(nomeGrupo, matricula));
            }
            default -> {
                System.out.println("Escolha Inválida");
                System.exit(1);
            }
        }
    }

    /**
     * Registra no controle de alunos a participação de um aluno.
     *
     * @param controle Controle de Alunos que está sendo manipulado.
     * @param scanner Scanner para pedir informações do contato.
     */
    private static void registraParticpacao(ControleAlunos controle, Scanner scanner) {
        System.out.print("\nMatrícula: ");
        String matricula = scanner.nextLine().trim();
        if (matricula.isEmpty()) {
            System.out.println("Matrícula Invalida");
            System.exit(1);
        }

        System.out.println(controle.registraParticpacao(matricula));
    }

    /**
     * Imprime uma lista com os Alunos que participaram.
     *
     * @param controle Controle de Alunos que está sendo manipulado.
     */
    private static void listaAlunos(ControleAlunos controle) {
        System.out.print("\n" + controle.alunosParticipantes());
    }

    /**
     * Retorna uma lista de grupos que o aluno faz parte.
     *
     * @param controle Controle de Alunos que está sendo manipulado.
     * @param scanner Scanner para pedir informações do contato.
     */
    private static void buscaGrupos(ControleAlunos controle, Scanner scanner) {
        System.out.print("\nMatrícula: ");
        String matricula = scanner.nextLine().trim();
        if (matricula.isEmpty()) {
            System.out.println("Matrícula Invalida");
            System.exit(1);
        }

        System.out.print(controle.getGrupos(matricula));
    }
}

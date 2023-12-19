import java.util.*;

public class Main {
    public static void main(String[] args) {
        Sistema sistema = new Sistema();
        Biblioteca biblioteca = new Biblioteca();
        biblioteca.adicionarLivro(new Livros("O Senhor dos Anéis", 1, "Fantasia", "J.R.R. Tolkien", 1200));
        biblioteca.adicionarLivro(new Livros("1984", 2, "Ficção Científica", "George Orwell", 328));

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Digite 1 para se registrar, 2 para fazer login, 3 para sair");
            int opcao = scanner.nextInt();
            if (opcao == 1) {
                System.out.println("Digite o login e a senha para se registrar:");
                scanner.nextLine(); 
                String login = scanner.nextLine();
                String senha = scanner.nextLine();
                if (sistema.registrar(login, senha)) {
                    System.out.println("Registro bem-sucedido!");
                } else {
                    System.out.println("O login já está em uso");
                }
            } else if (opcao == 2) {
                System.out.println("Digite o login e a senha para fazer login:");
                scanner.nextLine(); 
                String login = scanner.nextLine();
                String senha = scanner.nextLine();
                if (sistema.login(login, senha)) {
                    System.out.println("Login bem-sucedido!\n=============================\nBem vindo ao app BiblioTech!\n=============================");
                    while (true) {
                        System.out.println(
                                "Digite 1 para buscar livros, 2 para adicionar livros, 3 para remover livros, 4 para alugar livros, 5 para listar livros, 6 para sair");
                        int opcaoBiblioteca = scanner.nextInt();
                        if (opcaoBiblioteca == 1) {
                            System.out.println("Digite 1 para buscar por ID, 2 para buscar por título");
                            int buscaOpcao = scanner.nextInt();
                            if (buscaOpcao == 1) {
                                System.out.println("Digite o ID do livro que você deseja buscar:");
                                int id = scanner.nextInt();
                                Livros livro = biblioteca.buscarLivroPorId(id);
                                if (livro != null) {
                                    System.out.println("Livro encontrado: " + livro.titulo);
                                } else {
                                    System.out.println("Livro não encontrado");
                                }
                            } else if (buscaOpcao == 2) {
                                System.out.println("Digite o título do livro que você deseja buscar:");
                                scanner.nextLine();
                                String titulo = scanner.nextLine();
                                Livros livro = biblioteca.buscarLivroPorTitulo(titulo);
                                if (livro != null) {
                                    System.out.println("Livro encontrado: " + livro.titulo);
                                } else {
                                    System.out.println("Livro não encontrado");
                                }
                            }
                        } else if (opcaoBiblioteca == 2) {
                            System.out.println(
                                    "Digite o título, ID, categoria, autor e número de páginas do livro que você deseja adicionar:");
                            scanner.nextLine(); 
                            String titulo = scanner.nextLine();
                            int id = scanner.nextInt();
                            scanner.nextLine(); 
                            String categoria = scanner.nextLine();
                            String autor = scanner.nextLine();
                            int paginas = scanner.nextInt();
                            biblioteca.adicionarLivro(new Livros(titulo, id, categoria, autor, paginas));
                            System.out.println("Livro adicionado com sucesso!");
                        } else if (opcaoBiblioteca == 3) {
                            System.out.println("Digite o ID do livro que você deseja remover:");
                            int id = scanner.nextInt();
                            if (biblioteca.removerLivro(id)) {
                                System.out.println("Livro removido com sucesso!");
                            } else {
                                System.out.println("Não foi possível remover o livro");
                            }
                        } else if (opcaoBiblioteca == 4) {
                            System.out.println("Digite o ID do livro que você deseja alugar:");
                            int id = scanner.nextInt();
                            System.out.println("Por quantos dias você deseja alugar o livro?");
                            int dias = scanner.nextInt();
                            biblioteca.alugarLivro(id, dias);
                        } else if (opcaoBiblioteca == 5) {
                            biblioteca.listarLivros();
                        } else if (opcaoBiblioteca == 6) {
                            break;
                        }
                    }
                } else {
                    System.out.println("Login ou senha incorretos");
                }
            } else if (opcao == 3) {
                break;
            }
        }
        scanner.close();
    }
}

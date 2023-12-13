import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

public class Biblioteca {
    ArrayList<Livros> livros = new ArrayList<>();
    ArrayList<Usuario> usuario = new ArrayList<>();

    public Biblioteca() {
        while (true) {
            System.out.println("Bem vindo ao sistema de consulta de livros da biblioteca!\n");
            System.out.println("Faca login para poder navegar por nosso sistema!\n");

            Scanner op = new Scanner(System.in);
            System.out.println("Digite 1 para fazer login ou 2 para se cadastrar: ");
            int opcao = op.nextInt();

            if (opcao == 1) {
                fazerLogin();
                break;

            } else if (opcao == 2) {
                fazerCadastro();
                break;
            }

        }
        System.out.println("" + usuario.get(0).getNome() + " voce esta logado no sistema!\n");
    }

    private void fazerCadastro() {
        System.out.println("Para se cadastrar, digite as seguintes informacoes: ");
        Scanner nomeScan = new Scanner(System.in);
        System.out.println("Digite seu nome: ");
        String nome = nomeScan.nextLine();

        Scanner emailScan = new Scanner(System.in);
        System.out.println("Digite seu email: ");
        String email = emailScan.nextLine();

        Scanner senhaScan = new Scanner(System.in);
        System.out.println("Digite sua senha: ");
        String senha = senhaScan.nextLine();

        Random random = new Random();
        int min = 1000;
        int max = 9999;
        int ID = random.nextInt(max - min) + min;
        usuario.add(new Usuario(nome, email, ID, 0, senha));

        System.out.println("Cadastro realizado com sucesso! Seu ID de usuario eh: " + ID);
    }

    private void fazerLogin() {
        Scanner username = new Scanner(System.in);
        System.out.println("Digite seu nome de usuario: ");
        String user = username.nextLine();

        Scanner senhaScan = new Scanner(System.in);
        System.out.println("Digite sua senha: ");
        String senha = senhaScan.nextLine();

        boolean usuarioEncontrado = false;

        for (Usuario usuario : usuario) {
            if (usuario.getNome().equals(user) && usuario.getSenha().equals(senha)) {
                usuarioEncontrado = true;
                break;
            }
            if (usuarioEncontrado) {
                System.out.println("Login realizado com sucesso!");
                break;
            } else {
                System.out.println("Usuario ou senha incorretos!");
                break;
            }
        }

    }

}

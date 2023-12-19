import java.util.*;

public class Biblioteca {
    List<Livros> livros = new ArrayList<>();
    Map<Integer, Integer> alugados = new HashMap<>();

    void adicionarLivro(Livros livro) {
        livros.add(livro);
    }

    Livros buscarLivroPorId(int id) {
        for (Livros livro : livros) {
            if (livro.id == id) {
                return livro;
            }
        }
        return null;
    }

    Livros buscarLivroPorTitulo(String titulo) {
        for (Livros livro : livros) {
            if (livro.titulo.equalsIgnoreCase(titulo)) {
                return livro;
            }
        }
        return null;
    }

    boolean removerLivro(int id) {
        Livros livro = buscarLivroPorId(id);
        if (livro != null) {
            livros.remove(livro);
            return true;
        }
        return false;
    }

    boolean alugarLivro(int id, int dias) {
        Livros livro = buscarLivroPorId(id);
        if (livro != null) {
            if (alugados.containsKey(id)) {
                System.out.println("Livro já alugado!");
                return false;
            } else {
                alugados.put(id, 3 * dias);
                System.out.println("Você alugou o livro " + livro.titulo + " por " + dias + " dias. O valor total é: "
                        + (3 * dias) + " reais");
                return true;
            }
        }
        return false;
    }

    void listarLivros() {
        for (Livros livro : livros) {
            System.out.println("ID: " + livro.id + ", Título: " + livro.titulo + ", Categoria: " + livro.categoria
                    + ", Autor: " + livro.autor + ", Páginas: " + livro.paginas);
        }
    }
}
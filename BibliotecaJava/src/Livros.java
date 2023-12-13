public class Livros {
    String categoria, titulo, autor;
    int ID, paginas;

    public Livros(String categoria, int ID, String titulo, String autor, int paginas) {
        this.categoria = categoria;
        this.ID = ID;
        this.titulo = titulo;
        this.autor = autor;
        this.paginas = paginas;
    }

    public String getCategoria() {
        return categoria;
    }

    public int getID() {
        return ID;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public int getPaginas() {
        return paginas;
    }
        
    public String toString() {
        return "Categoria: " + categoria +
                "\nID: " + ID +
                "\nTitulo: " + titulo +
                "\nAutor: " + autor +
                "\nPaginas: " + paginas;
    }

}

public class Usuario {
    private String nome, email, senha;
    private int ID, saldo;

    public Usuario(String nome, String email, int ID, int saldo, String senha){
        this.nome = nome;
        this.email = email;
        this.ID = ID;
        this.saldo = saldo;
        this.senha = senha;
    }

    public String getSenha(){
        return senha;
    }

    public String getNome(){
        return nome;
    }

    public String getEmail(){
        return email;
    }

    public int getID(){
        return ID;
    }

    public int getSaldo(){
        return saldo;
    }

    public String toString(){
        return "Nome: " + nome +
                "\nEmail: " + email +
                "\nID: " + ID +
                "\nSaldo: " + saldo;
    }
    
}

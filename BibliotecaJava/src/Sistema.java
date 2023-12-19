import java.util.*;

public class Sistema {
    Map<String, Usuario> usuarios = new HashMap<>();

    boolean registrar(String login, String senha) {
        if (usuarios.containsKey(login)) {
            return false;
        } else {
            usuarios.put(login, new Usuario(login, senha));
            return true;
        }
    }

    boolean login(String login, String senha) {
        Usuario usuario = usuarios.get(login);
        if (usuario != null && usuario.senha.equals(senha)) {
            return true;
        }
        return false;
    }
}
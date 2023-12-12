package dao;

import modelo.Login;


public interface UsuarioDAO {
    
    public int inserir(Login login);

    public boolean autenticar(Login usuarioInserido);
}



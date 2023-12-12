package dao;

import conexao.ConexaoMySQL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import modelo.Login;


public class UsuarioDAOJDBC implements UsuarioDAO{
    
    Connection conexao = null;
    PreparedStatement sql = null;
    ResultSet rset = null;
    
    
    @Override
    public int inserir(Login login) {
        
        StringBuilder sqlBuilder = new StringBuilder();
        sqlBuilder
                .append("INSERT INTO login(usuario, senha) ")
                .append("VALUES (?, ?)");
     
        String insert = sqlBuilder.toString();
        int linha = 0;
        
        try {
            conexao = ConexaoMySQL.getConexao();

            sql = (PreparedStatement) conexao.prepareStatement(insert);
            sql.setString(1, login.getUsuario());
            sql.setString(2, login.getSenha());            
            linha = sql.executeUpdate();
            
            
        } catch (Exception e) {           
        }
        
        return linha;
    }
    
    @Override
    public boolean autenticar(Login usuario) {
        
        StringBuilder sqlBuilder = new StringBuilder();
        sqlBuilder
                .append("SELECT * FROM login ") 
                .append("WHERE usuario = ? AND senha = ?");
     
        String query = sqlBuilder.toString();
        boolean linha = false;
        
        try {
            conexao = ConexaoMySQL.getConexao();
            sql = (PreparedStatement) conexao.prepareStatement(query);
            sql.setString(1, usuario.getUsuario());
            sql.setString(2, usuario.getSenha());
                        
            ResultSet resultSet = sql.executeQuery();
            
            if(resultSet.next()){
                linha = true;
            }else{
                linha = false;
            }                 
            
        } catch (Exception e) {  
            e.printStackTrace();
        } finally {
            fecharConexao();
        }
        
        return linha;
    }       
    
     private void fecharConexao() {
        try {
            if (rset != null) {
                rset.close();
            }
            if (sql != null) {
                sql.close();
            }

            if (conexao != null) {
                conexao.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    
}

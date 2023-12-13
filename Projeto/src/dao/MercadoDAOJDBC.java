package dao;

import conexao.ConexaoMySQL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import modelo.Mercado;


public class MercadoDAOJDBC implements MercadoDAO{
    
    Connection conexao = null;
    PreparedStatement sql = null;
    ResultSet rset = null;

    @Override
    public int inserir(Mercado produto) {
        StringBuilder sqlBuilder = new StringBuilder();
        sqlBuilder
                .append("INSERT INTO mercado(produto, preco, validade, peso, quantidade) ")
                .append("VALUES (?, ?, ?, ?, ?)");
     
        String insert = sqlBuilder.toString();
        int linha = 0;
        try {
            conexao = ConexaoMySQL.getConexao();

            sql = (PreparedStatement) conexao.prepareStatement(insert);
            sql.setString(1, produto.getProduto());
            sql.setFloat(2, produto.getPreco());
            sql.setString(3, produto.getValidade());
            sql.setInt(4, produto.getPeso());
            sql.setInt(5, produto.getQuantidade());
            
            linha = sql.executeUpdate();
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            fecharConexao();
        }
        
        return linha;
    }

    @Override
    public int editar(Mercado produto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int apagar(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Mercado> listar() {
       String select = "SELECT * FROM mercado";

        List<Mercado> produtos = new ArrayList<Mercado>();

        try {
            conexao = ConexaoMySQL.getConexao();

            sql = (PreparedStatement) conexao.prepareStatement(select);

            rset = sql.executeQuery();

            while (rset.next()) {

                Mercado mercado = new Mercado();

                mercado.setId(rset.getInt("id"));
                mercado.setProduto(rset.getString("produto"));
                mercado.setPreco(rset.getFloat("preco"));
                mercado.setValidade(rset.getString("validade"));
                mercado.setPeso(rset.getInt("peso"));
                mercado.setQuantidade(rset.getInt("quantidade"));

                produtos.add(mercado);

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            fecharConexao();
        }

        return produtos;
    }

    @Override
    public Mercado encontrar(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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

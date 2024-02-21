
package dao;

import conexao.ConexaoMySQL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import modelo.Mercado;


public class CompraDAOJDBC implements CompraDAO {
     Connection conexao = null;
     PreparedStatement sql = null;
     ResultSet rset = null;
     int novaQuantidadeCompra = 0;
     int novaQuantidadeMercado = 0;
     StringBuilder dadosTabela = new StringBuilder();     
             
    @Override
    public int inserir(Mercado mercado) {
       int linhasAfetadas = 0;

    try {
        conexao = ConexaoMySQL.getConexao();

        
        PreparedStatement consulta = conexao.prepareStatement("SELECT quantidade FROM compra WHERE produto = ?");
        consulta.setString(1, mercado.getProduto());
        ResultSet resultado = consulta.executeQuery();
        
        PreparedStatement consulta2 = conexao.prepareStatement("SELECT quantidade FROM mercado WHERE produto = ?");
        consulta2.setString(1, mercado.getProduto());
        ResultSet resultado2 = consulta2.executeQuery();
                

        if (resultado.next() && resultado2.next()) {
            
            int quantidadeExistenteCompra = resultado.getInt("quantidade");            
            int quantidadeExistenteMercado = resultado2.getInt("quantidade");                         
            novaQuantidadeCompra = quantidadeExistenteCompra + mercado.getQuantidade();           
            novaQuantidadeMercado = quantidadeExistenteMercado - mercado.getQuantidade();
                
                if(novaQuantidadeMercado >= 0)  {                                    
                PreparedStatement atualizacaoCompra = conexao.prepareStatement("UPDATE compra SET quantidade = ? WHERE produto = ?");
                atualizacaoCompra.setInt(1, novaQuantidadeCompra);
                atualizacaoCompra.setString(2, mercado.getProduto());
                linhasAfetadas = atualizacaoCompra.executeUpdate();

                PreparedStatement atualizacaoMercado = conexao.prepareStatement("UPDATE mercado SET quantidade = ? WHERE produto = ?");
                atualizacaoMercado.setInt(1, novaQuantidadeMercado);
                atualizacaoMercado.setString(2, mercado.getProduto());
                linhasAfetadas = atualizacaoMercado.executeUpdate();     
                }else{
                    JOptionPane.showMessageDialog(null, "Estoque Insuficiente");                    
                }
            }else {
                                    
                if(resultado2.next()){
                    int quantidadeExistenteMercado = resultado2.getInt("quantidade"); 
                    novaQuantidadeMercado = quantidadeExistenteMercado - mercado.getQuantidade();
                }
            
            if(novaQuantidadeMercado >= 0){
                PreparedStatement insercao = conexao.prepareStatement("INSERT INTO compra(produto, preco, quantidade) VALUES (?, ?, ?)");         
                insercao.setString(1, mercado.getProduto());
                insercao.setFloat(2, mercado.getPreco());            
                insercao.setInt(3, mercado.getQuantidade());           
                linhasAfetadas = insercao.executeUpdate();
                
                PreparedStatement atualizacaoMercado = conexao.prepareStatement("UPDATE mercado SET quantidade = ? WHERE produto = ?");
                atualizacaoMercado.setInt(1, novaQuantidadeMercado);
                atualizacaoMercado.setString(2, mercado.getProduto());
                linhasAfetadas = atualizacaoMercado.executeUpdate();     
            }else{
                JOptionPane.showMessageDialog(null, "Estoque Insuficiente");  
            }            
        }

        // Fechar recursos
        resultado.close();
        consulta.close();
    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        fecharConexao();
    }

    return linhasAfetadas;
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

    @Override
    public List<Mercado> listar() {
        String select = "SELECT * FROM compra";

        List<Mercado> produtos = new ArrayList<Mercado>();

        try {
            conexao = ConexaoMySQL.getConexao();

            sql = (PreparedStatement) conexao.prepareStatement(select);

            rset = sql.executeQuery();

            while (rset.next()) {

                Mercado mercado = new Mercado();

                mercado.setId(rset.getInt("it"));
                mercado.setProduto(rset.getString("produto"));
                mercado.setPreco(rset.getFloat("preco"));                
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
    public String exibirCompra() {
        float soma = 0;
        String resultSoma = null;
        try {     
            conexao = ConexaoMySQL.getConexao();
           
            sql = conexao.prepareStatement("SELECT * FROM compra");
            rset = sql.executeQuery();
            
            
            dadosTabela.append("ID | Produto | Preço | Quantidade\n");
           
            while (rset.next()) {
                int id = rset.getInt("it");
                String produto = rset.getString("produto");
                float preco = rset.getFloat("preco");                                
                int quantidade = rset.getInt("quantidade");                
                                                                                
                dadosTabela.append(String.format("%-4d", id))
                .append("|")
                .append(String.format("%-20s", produto))
                .append("|")
                .append(String.format("%-10.2f", preco))
                .append("|")                           
                .append(String.format("%-10d", quantidade))
                .append("\n");
                
                soma = soma + (rset.getFloat("preco") * rset.getInt("quantidade"));
            }
            resultSoma = String.valueOf(soma);
            dadosTabela.append("------------------------------------------")
                       .append("\nTotal:            ").append(soma);                       

            // Exibir a string com os dados da tabela em um JOptionPane
            JOptionPane.showMessageDialog(null, dadosTabela.toString(), "RECIBO", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            fecharConexao();
        }
         return "abc";
    }

    @Override
    public String cancelarCompra(String produto) {
       StringBuilder sqlBuilder = new StringBuilder();
        sqlBuilder
                .append("DELETE FROM compra ")
                .append("WHERE produto = ?");
        
        String delete = sqlBuilder.toString();               
        
        try {
            conexao = ConexaoMySQL.getConexao();
                PreparedStatement consulta = conexao.prepareStatement("SELECT quantidade FROM compra WHERE produto = ?");
                consulta.setString(1, produto);
                ResultSet resultado = consulta.executeQuery();
                
                PreparedStatement consulta2 = conexao.prepareStatement("SELECT quantidade FROM mercado WHERE produto = ?");
                consulta2.setString(1, produto);
                ResultSet resultado2 = consulta2.executeQuery();
                
            if (resultado.next() && resultado2.next()){
                int quantidadeExistenteCompra = resultado.getInt("quantidade");
                int quantidadeDevolvida = quantidadeExistenteCompra + resultado2.getInt("quantidade");
                
                PreparedStatement atualizacaoCompra = conexao.prepareStatement("UPDATE mercado SET quantidade = ? WHERE produto = ?");
                atualizacaoCompra.setInt(1, quantidadeDevolvida);
                atualizacaoCompra.setString(2, produto);
                atualizacaoCompra.executeUpdate();
            }
            

            sql = (PreparedStatement) conexao.prepareStatement(delete);
            sql.setString(1, produto);
            
            sql.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            fecharConexao();
        }
        return "abc";
    }
   

   
}

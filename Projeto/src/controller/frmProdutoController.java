package controller;

import aplicacao.frmProduto;
import dao.DAOFactory;
import dao.MercadoDAO;
import java.util.Date;
import javax.swing.JOptionPane;
import modelo.Mercado;


public class frmProdutoController {
    private Mercado mercado;
    MercadoDAO mercadoDAO = DAOFactory.criarMercadoDAO();
    private frmProduto view;

    public frmProdutoController(frmProduto view) {
        this.view = view;
    }

    
    public void inserir(){
        
        Mercado produtoInserido = new Mercado();
        produtoInserido.setProduto(view.getTxtProduto().getText());
        produtoInserido.setPreco(Float.parseFloat(view.getTxtPreco().getText()));
        produtoInserido.setValidade(view.getFmtValidade().getText());
        produtoInserido.setPeso(Integer.parseInt(view.getTxtPeso().getText()));
        produtoInserido.setQuantidade(Integer.parseInt(view.getTxtQuantidade().getText()));
        
       int linha = mercadoDAO.inserir(produtoInserido);
       
       if (linha > 0) {
            JOptionPane.showMessageDialog(null, "Produto Inserido Com Sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Erro ao inserir Produto.");
        }
    }
    
}

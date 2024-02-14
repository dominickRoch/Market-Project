
package controller;

import aplicacao.frmCompra;
import dao.DAOFactory;
import dao.CompraDAO;
import dao.MercadoDAO;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Mercado;

public class frmCompraController {
    CompraDAO compraDAO = DAOFactory.criarCompraDAO();
    MercadoDAO mercadoDAO = DAOFactory.criarMercadoDAO();
    private frmCompra view;
    private final DefaultTableModel modelo;

    public frmCompraController(frmCompra view) {
        this.view = view;
        modelo = (DefaultTableModel) view.getTblProdutos().getModel();
    }
    
    public void listar(){
              
        modelo.getDataVector().clear();
        try {
            for (Mercado mercado : mercadoDAO.listar()) {
                modelo.addRow(new Object[]{mercado.getId(), mercado.getProduto(), mercado.getPreco(),
                              mercado.getValidade(), mercado.getPeso(), mercado.getQuantidade()});
            }
        } catch (Exception e) {
            throw e;
        }    
    }
    
    public void addCarrinho(){
        Mercado produtoInserido = new Mercado();
        produtoInserido.setProduto(view.getTxtProduto().getText());
        produtoInserido.setPreco(Float.parseFloat(view.getTxtPreco().getText()));
        produtoInserido.setQuantidade(Integer.parseInt(view.getTxtQuantidade().getText()));
        
        
       int linha = compraDAO.inserir(produtoInserido);
       
       if (linha > 0) {
            JOptionPane.showMessageDialog(null, "Produto Inserido Com Sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Erro ao inserir Produto.");
        }     
    }
}

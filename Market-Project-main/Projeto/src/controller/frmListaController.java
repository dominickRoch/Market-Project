package controller;

import aplicacao.frmLista;
import aplicacao.frmProduto;
import dao.DAOFactory;
import dao.MercadoDAO;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Mercado;


public class frmListaController {
    private Mercado mercado;
    MercadoDAO mercadoDAO = DAOFactory.criarMercadoDAO();
    private frmLista view;
    private final DefaultTableModel modelo;
    
    public frmListaController(frmLista view) {
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
    
    public void apagar(){
        try {
            Integer id = (Integer) modelo.getValueAt(view.getTblProdutos().getSelectedRow(), 0);

            int linha = mercadoDAO.apagar(id);
            
            if (linha > 0) {
                modelo.removeRow(view.getTblProdutos().getSelectedRow());
                JOptionPane.showMessageDialog(null, "Item excluído com sucesso!");
            } else {
                JOptionPane.showMessageDialog(null, "Erro ao excluir.");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Por favor, selecionar uma linha da tabela");
        } 
    }
    
    public void editar(){
        
        try {
            Integer id = (Integer) modelo.getValueAt(view.getTblProdutos().getSelectedRow(), 0);
            String produto = (String) modelo.getValueAt(view.getTblProdutos().getSelectedRow(), 1);
            Float preco  = (Float) modelo.getValueAt(view.getTblProdutos().getSelectedRow(), 2);
            String validade = (String) modelo.getValueAt(view.getTblProdutos().getSelectedRow(), 3);
            Integer peso = (Integer) modelo.getValueAt(view.getTblProdutos().getSelectedRow(), 4);
            Integer quantidade = (Integer) modelo.getValueAt(view.getTblProdutos().getSelectedRow(), 5);
           
            Mercado produtos = new Mercado();
            produtos.setId(id);
            produtos.setProduto(produto);
            produtos.setPreco(preco);
            produtos.setValidade(validade);
            produtos.setPeso(peso);
            produtos.setQuantidade(quantidade);
            

            new frmProduto(produtos).setVisible(true);            
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Por favor, selecionar uma linha da tabela");
        }
    }
   
}

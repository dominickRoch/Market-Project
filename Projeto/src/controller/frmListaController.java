package controller;

import aplicacao.frmLista;
import dao.DAOFactory;
import dao.MercadoDAO;
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

   
}

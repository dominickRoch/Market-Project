package controller;

import View.telaCadastro;
import dao.DAOFactory;
import javax.swing.JOptionPane;
import modelo.Login;
import dao.UsuarioDAO;


public class frmCadastroController {
    
    private Login login;
    UsuarioDAO usuarioDAO = DAOFactory.criarUsuarioDAO();
    
  private telaCadastro view;

    public frmCadastroController(telaCadastro view) {
        this.view = view;
    }        
    
    public void inserir(){                
                
        Login cadastroInserido = new Login();
        cadastroInserido.setUsuario(view.getTxtUsuario().getText());
        cadastroInserido.setSenha(view.getTxtSenha().getText());
      

        int linha = usuarioDAO.inserir(cadastroInserido);
        if (linha > 0) {
            JOptionPane.showMessageDialog(null, "Cadastro Realizado!");
        } else {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar.");
        }
                
    }    

    
  
    
}

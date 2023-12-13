package controller;

import View.telaLogin;
import aplicacao.frmMenu;
import dao.DAOFactory;
import javax.swing.JOptionPane;
import modelo.Login;
import dao.UsuarioDAO;

public class frmLoginController {
    
    private Login login;
    UsuarioDAO usuarioDAO = DAOFactory.criarUsuarioDAO();
    private telaLogin view;

    public frmLoginController(telaLogin view) {
        this.view = view;
    }
    
    public boolean autenticar(){
        
       //Buscar um Usuario da View
        Login usuarioInserido = new Login();
        usuarioInserido.setUsuario(view.getTxtUsuario().getText());
        usuarioInserido.setSenha(view.getTxtSenha().getText());
       //Verificar se existe no banco de dados
        boolean existe = usuarioDAO.autenticar(usuarioInserido);        
       //Se existir direciona para Menu
       if (existe) {
            frmMenu showMenu = new frmMenu();
            showMenu.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "Usuário ou Senha inválidos!");            
        }
       return existe;
    }
}

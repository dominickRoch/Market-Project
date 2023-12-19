package View;

import controller.frmCadastroController;
import dao.DAOFactory;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import modelo.Login;
import dao.UsuarioDAO;
import javax.swing.JOptionPane;

public class telaCadastro extends javax.swing.JFrame {

    private Login login;
    UsuarioDAO usuarioDAO = DAOFactory.criarUsuarioDAO();
    private final frmCadastroController controller;

    public telaCadastro() {
        initComponents();
        controller = new frmCadastroController(this);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pCadastro = new javax.swing.JPanel();
        lblCadastro = new javax.swing.JLabel();
        lblUsuario = new javax.swing.JLabel();
        lblSenha = new javax.swing.JLabel();
        lblRepetir = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        txtRepetir = new javax.swing.JPasswordField();
        btSalvar = new javax.swing.JToggleButton();
        txtSenha = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        pCadastro.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        lblCadastro.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lblCadastro.setText("Cadastro");

        lblUsuario.setText("Usuario:");

        lblSenha.setText("Senha:");

        lblRepetir.setText("Repetir Senha:");

        txtUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUsuarioActionPerformed(evt);
            }
        });

        txtRepetir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRepetirActionPerformed(evt);
            }
        });

        btSalvar.setText("Salvar");
        btSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSalvarActionPerformed(evt);
            }
        });

        txtSenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSenhaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pCadastroLayout = new javax.swing.GroupLayout(pCadastro);
        pCadastro.setLayout(pCadastroLayout);
        pCadastroLayout.setHorizontalGroup(
            pCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pCadastroLayout.createSequentialGroup()
                .addGroup(pCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pCadastroLayout.createSequentialGroup()
                        .addGap(180, 180, 180)
                        .addComponent(lblUsuario))
                    .addGroup(pCadastroLayout.createSequentialGroup()
                        .addGap(259, 259, 259)
                        .addComponent(lblCadastro))
                    .addGroup(pCadastroLayout.createSequentialGroup()
                        .addGap(279, 279, 279)
                        .addComponent(btSalvar))
                    .addGroup(pCadastroLayout.createSequentialGroup()
                        .addGap(180, 180, 180)
                        .addGroup(pCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblRepetir)
                            .addComponent(lblSenha)
                            .addComponent(txtUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, 269, Short.MAX_VALUE)
                            .addComponent(txtRepetir)
                            .addComponent(txtSenha))))
                .addContainerGap(171, Short.MAX_VALUE))
        );
        pCadastroLayout.setVerticalGroup(
            pCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pCadastroLayout.createSequentialGroup()
                .addGap(87, 87, 87)
                .addComponent(lblCadastro)
                .addGap(83, 83, 83)
                .addComponent(lblUsuario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblSenha)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblRepetir)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtRepetir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(btSalvar)
                .addContainerGap(133, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pCadastro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pCadastro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsuarioActionPerformed

    }//GEN-LAST:event_txtUsuarioActionPerformed

    private void btSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSalvarActionPerformed
        if (txtSenha.getText().equals(txtRepetir.getText())) {
            controller.inserir();
            this.dispose();
        } else{
            JOptionPane.showMessageDialog(this, "Senha diferente");
        }

    }//GEN-LAST:event_btSalvarActionPerformed

    private void txtRepetirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRepetirActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRepetirActionPerformed

    private void txtSenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSenhaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSenhaActionPerformed

    public JPasswordField getTxtSenha() {
        return txtSenha;
    }

    public void setTxtSenha(JPasswordField txtSenha) {
        this.txtSenha = txtSenha;
    }

    public JTextField getTxtUsuario() {
        return txtUsuario;
    }

    public void setTxtUsuario(JTextField txtUsuario) {
        this.txtUsuario = txtUsuario;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton btSalvar;
    private javax.swing.JLabel lblCadastro;
    private javax.swing.JLabel lblRepetir;
    private javax.swing.JLabel lblSenha;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JPanel pCadastro;
    private javax.swing.JPasswordField txtRepetir;
    private javax.swing.JPasswordField txtSenha;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}

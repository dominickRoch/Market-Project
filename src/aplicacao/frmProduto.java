
package aplicacao;

import controller.frmProdutoController;
import dao.DAOFactory;
import dao.MercadoDAO;
import java.util.Date;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import modelo.Mercado;

public class frmProduto extends javax.swing.JFrame {
   
    MercadoDAO mercadoDAO = DAOFactory.criarMercadoDAO();
    private Mercado mercado;
    private final frmProdutoController controller;
    
    public frmProduto(Mercado mercado) {
        initComponents();
        controller = new frmProdutoController(this);
        btEditar.setVisible(false);
        this.mercado = mercado;
        
        if (this.mercado != null) {
            btEditar.setVisible(true);
            btSalvar.setVisible(false);
            txtProduto.setText(this.mercado.getProduto());
            txtPreco.setText(Float.toString(this.mercado.getPreco()));
            fmtValidade.setText(this.mercado.getValidade());
            txtPeso.setText(Integer.toString(this.mercado.getPeso()));
            txtQuantidade.setText(Integer.toString(this.mercado.getQuantidade()));
        }
        
    }
    
    
    frmProduto(Object object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblProduto = new javax.swing.JLabel();
        txtProduto = new javax.swing.JTextField();
        lblPreco = new javax.swing.JLabel();
        txtPreco = new javax.swing.JTextField();
        lblValidade = new javax.swing.JLabel();
        lblPeso = new javax.swing.JLabel();
        txtPeso = new javax.swing.JTextField();
        fmtValidade = new javax.swing.JFormattedTextField();
        lblCabecalho = new javax.swing.JLabel();
        btSalvar = new javax.swing.JButton();
        lblQuantidade = new javax.swing.JLabel();
        txtQuantidade = new javax.swing.JTextField();
        btEditar = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(null);

        lblProduto.setFont(new java.awt.Font("Corbel", 0, 12)); // NOI18N
        lblProduto.setText("Produto:");
        jPanel1.add(lblProduto);
        lblProduto.setBounds(90, 110, 70, 20);

        txtProduto.setBorder(null);
        jPanel1.add(txtProduto);
        txtProduto.setBounds(90, 140, 280, 20);

        lblPreco.setFont(new java.awt.Font("Corbel", 0, 12)); // NOI18N
        lblPreco.setText("Preço:");
        jPanel1.add(lblPreco);
        lblPreco.setBounds(90, 160, 60, 20);

        txtPreco.setBorder(null);
        jPanel1.add(txtPreco);
        txtPreco.setBounds(90, 180, 90, 20);

        lblValidade.setFont(new java.awt.Font("Corbel", 0, 12)); // NOI18N
        lblValidade.setText("Validade:");
        jPanel1.add(lblValidade);
        lblValidade.setBounds(90, 220, 60, 16);

        lblPeso.setFont(new java.awt.Font("Corbel", 0, 12)); // NOI18N
        lblPeso.setText("Peso:");
        jPanel1.add(lblPeso);
        lblPeso.setBounds(90, 270, 50, 16);

        txtPeso.setBorder(null);
        jPanel1.add(txtPeso);
        txtPeso.setBounds(90, 290, 100, 20);

        fmtValidade.setBorder(null);
        try {
            fmtValidade.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jPanel1.add(fmtValidade);
        fmtValidade.setBounds(90, 240, 60, 20);

        lblCabecalho.setFont(new java.awt.Font("Corbel", 1, 24)); // NOI18N
        lblCabecalho.setForeground(new java.awt.Color(255, 102, 0));
        lblCabecalho.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCabecalho.setText("CADASTRO DE PRODUTO");
        jPanel1.add(lblCabecalho);
        lblCabecalho.setBounds(90, 40, 290, 52);

        btSalvar.setBackground(new java.awt.Color(255, 102, 0));
        btSalvar.setFont(new java.awt.Font("Corbel", 0, 11)); // NOI18N
        btSalvar.setForeground(new java.awt.Color(255, 102, 0));
        btSalvar.setText("SALVAR");
        btSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSalvarActionPerformed(evt);
            }
        });
        jPanel1.add(btSalvar);
        btSalvar.setBounds(340, 400, 84, 31);

        lblQuantidade.setFont(new java.awt.Font("Corbel", 0, 12)); // NOI18N
        lblQuantidade.setText("Quantidade:");
        jPanel1.add(lblQuantidade);
        lblQuantidade.setBounds(90, 320, 90, 16);

        txtQuantidade.setBorder(null);
        jPanel1.add(txtQuantidade);
        txtQuantidade.setBounds(90, 340, 80, 20);

        btEditar.setText("SALVAR");
        btEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEditarActionPerformed(evt);
            }
        });
        jPanel1.add(btEditar);
        btEditar.setBounds(340, 400, 86, 31);
        jPanel1.add(jSeparator1);
        jSeparator1.setBounds(10, 378, 430, 10);

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 450, 450));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSalvarActionPerformed
        controller.inserir();   
        this.dispose();
    }//GEN-LAST:event_btSalvarActionPerformed

    private void btEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEditarActionPerformed
        btEditar.setVisible(true);
        controller.editar(mercado);
        this.dispose();
      
    }//GEN-LAST:event_btEditarActionPerformed

    public JFormattedTextField getFmtValidade() {
        return fmtValidade;
    }

    public void setFmtValidade(JFormattedTextField fmtValidade) {
        this.fmtValidade = fmtValidade;
    }

    public JTextField getTxtPeso() {
        return txtPeso;
    }

    public void setTxtPeso(JTextField txtPeso) {
        this.txtPeso = txtPeso;
    }

    public JTextField getTxtPreco() {
        return txtPreco;
    }

    public void setTxtPreco(JTextField txtPreco) {
        this.txtPreco = txtPreco;
    }

    public JTextField getTxtProduto() {
        return txtProduto;
    }

    public void setTxtProduto(JTextField txtProduto) {
        this.txtProduto = txtProduto;
    }

    public JTextField getTxtQuantidade() {
        return txtQuantidade;
    }

    public void setTxtQuantidade(JTextField txtQuantidade) {
        this.txtQuantidade = txtQuantidade;
    }

    public Mercado getMercado() {
        return mercado;
    }

    public void setMercado(Mercado mercado) {
        this.mercado = mercado;
    }
   
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btEditar;
    private javax.swing.JButton btSalvar;
    private javax.swing.JFormattedTextField fmtValidade;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblCabecalho;
    private javax.swing.JLabel lblPeso;
    private javax.swing.JLabel lblPreco;
    private javax.swing.JLabel lblProduto;
    private javax.swing.JLabel lblQuantidade;
    private javax.swing.JLabel lblValidade;
    private javax.swing.JTextField txtPeso;
    private javax.swing.JTextField txtPreco;
    private javax.swing.JTextField txtProduto;
    private javax.swing.JTextField txtQuantidade;
    // End of variables declaration//GEN-END:variables
}

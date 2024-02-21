package aplicacao;

import controller.frmListaController;
import dao.DAOFactory;
import dao.MercadoDAO;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;


public class frmLista extends javax.swing.JFrame {

    MercadoDAO mercadoDAO = DAOFactory.criarMercadoDAO();
    private  DefaultTableModel modelo;
    private  frmListaController controller;
    
    public frmLista() {
        initComponents();
        modelo = (DefaultTableModel) tblProdutos.getModel();        
        controller = new frmListaController(this);
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblProdutos = new javax.swing.JTable();
        btEditar = new javax.swing.JButton();
        btVoltar = new javax.swing.JButton();
        btApagar = new javax.swing.JButton();
        txtConsultar = new javax.swing.JTextField();
        btConsultar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblProdutos.setFont(new java.awt.Font("Corbel", 0, 11)); // NOI18N
        tblProdutos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Produto", "Preço", "Validade", "Peso", "Quantidade"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Float.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblProdutos.setColumnSelectionAllowed(true);
        tblProdutos.getTableHeader().setReorderingAllowed(false);
        tblProdutos.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tblProdutosFocusGained(evt);
            }
        });
        jScrollPane1.setViewportView(tblProdutos);
        tblProdutos.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 910, 470));

        btEditar.setBackground(new java.awt.Color(255, 102, 0));
        btEditar.setFont(new java.awt.Font("Corbel", 0, 11)); // NOI18N
        btEditar.setForeground(new java.awt.Color(255, 102, 0));
        btEditar.setText("EDITAR");
        btEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEditarActionPerformed(evt);
            }
        });
        jPanel1.add(btEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 600, 100, 40));

        btVoltar.setBackground(new java.awt.Color(255, 102, 0));
        btVoltar.setFont(new java.awt.Font("Corbel", 0, 11)); // NOI18N
        btVoltar.setForeground(new java.awt.Color(255, 102, 0));
        btVoltar.setText("VOLTAR");
        btVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btVoltarActionPerformed(evt);
            }
        });
        jPanel1.add(btVoltar, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 600, 90, 40));

        btApagar.setBackground(new java.awt.Color(255, 102, 0));
        btApagar.setFont(new java.awt.Font("Corbel", 0, 11)); // NOI18N
        btApagar.setForeground(new java.awt.Color(255, 102, 0));
        btApagar.setText("DELETAR");
        btApagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btApagarActionPerformed(evt);
            }
        });
        jPanel1.add(btApagar, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 600, 100, 40));

        txtConsultar.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtConsultar.setBorder(null);
        txtConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtConsultarActionPerformed(evt);
            }
        });
        jPanel1.add(txtConsultar, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, 750, 50));

        btConsultar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons8-pesquisar-50.png"))); // NOI18N
        btConsultar.setMaximumSize(new java.awt.Dimension(40, 40));
        btConsultar.setMinimumSize(new java.awt.Dimension(40, 40));
        btConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btConsultarActionPerformed(evt);
            }
        });
        jPanel1.add(btConsultar, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 10, 50, 50));

        jLabel1.setFont(new java.awt.Font("Corbel", 0, 11)); // NOI18N
        jLabel1.setText("Pesquisar:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 664, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEditarActionPerformed
        controller.editar();
    }//GEN-LAST:event_btEditarActionPerformed

    private void tblProdutosFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tblProdutosFocusGained
        controller.listar();
    }//GEN-LAST:event_tblProdutosFocusGained

    private void btVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btVoltarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btVoltarActionPerformed

    private void btApagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btApagarActionPerformed
        controller.apagar();
        
    }//GEN-LAST:event_btApagarActionPerformed

    private void txtConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtConsultarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtConsultarActionPerformed

    private void btConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btConsultarActionPerformed
        controller.consultar();
    }//GEN-LAST:event_btConsultarActionPerformed

    public JTable getTblProdutos() {
        return tblProdutos;
    }

    public void setTblProdutos(JTable tblProdutos) {
        this.tblProdutos = tblProdutos;
    }

    public JTextField getTxtConsultar() {
        return txtConsultar;
    }
     
    
    
   
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btApagar;
    private javax.swing.JButton btConsultar;
    private javax.swing.JButton btEditar;
    private javax.swing.JButton btVoltar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblProdutos;
    private javax.swing.JTextField txtConsultar;
    // End of variables declaration//GEN-END:variables
}

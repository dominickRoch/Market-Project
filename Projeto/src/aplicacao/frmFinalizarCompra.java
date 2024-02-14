package aplicacao;

import controller.frmCompraController;
import dao.DAOFactory;
import dao.CompraDAO;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Mercado;


public class frmFinalizarCompra extends javax.swing.JFrame {

    CompraDAO compraDAO = DAOFactory.criarCompraDAO();
    private  DefaultTableModel modelo;
    private  frmCompraController controller;
    
    public frmFinalizarCompra() {
        initComponents();        
        modelo = (DefaultTableModel) tblProdutos.getModel();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblProdutos = new javax.swing.JTable();
        btVoltar = new javax.swing.JButton();
        btComprar = new javax.swing.JButton();
        btCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tblProdutos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null}
            },
            new String [] {
                "ID", "Produto", "Preço", "Quantidade"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Float.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
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

        btVoltar.setText("VOLTAR");
        btVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btVoltarActionPerformed(evt);
            }
        });

        btComprar.setText("COMPRAR");
        btComprar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btComprarActionPerformed(evt);
            }
        });

        btCancelar.setText("CANCELAR COMPRA");
        btCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btComprar))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(56, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btVoltar)
                .addGap(27, 27, 27))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btComprar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 74, Short.MAX_VALUE)
                .addComponent(btVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tblProdutosFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tblProdutosFocusGained
        modelo.getDataVector().clear();
        try {
            for (Mercado mercado : compraDAO.listar()) {
                modelo.addRow(new Object[]{mercado.getId(), mercado.getProduto(), mercado.getPreco(),
                              mercado.getQuantidade()});
            }
        } catch (Exception e) {
            throw e;
        }    
    }//GEN-LAST:event_tblProdutosFocusGained

    private void btVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btVoltarActionPerformed
        frmCompra showMenu = new frmCompra();
        showMenu.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btVoltarActionPerformed

    private void btComprarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btComprarActionPerformed
        compraDAO.exibirCompra();
    }//GEN-LAST:event_btComprarActionPerformed

    private void btCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelarActionPerformed
        try {            
            String produto = (String) modelo.getValueAt(tblProdutos.getSelectedRow(), 1);
            Object[] opcao = {"Sim", "Não"};
            int opcaoSelecionada = JOptionPane.showOptionDialog(null, "Deseja realmente apagar?", "Aviso",
                                                                JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, opcao, opcao[0]);
            if(opcaoSelecionada == 0){
            String linha  = compraDAO.cancelarCompra(produto); 
                if (linha == "abc") {
                    modelo.removeRow(tblProdutos.getSelectedRow());
                    JOptionPane.showMessageDialog(null, "Item excluído com sucesso!");
                }else{
                    JOptionPane.showMessageDialog(null, "Erro ao excluir.");
                } 
            }                                    
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Por favor, selecionar uma linha da tabela");
        } 
    }//GEN-LAST:event_btCancelarActionPerformed
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCancelar;
    private javax.swing.JButton btComprar;
    private javax.swing.JButton btVoltar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblProdutos;
    // End of variables declaration//GEN-END:variables
}

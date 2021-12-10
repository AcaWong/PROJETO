/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
* Unime Lauro de Freitas
* Sistemas de Informação
* Programação Orientada a Objeto II
* Pablo Roxo
* Douglas Acauã
*/
package telas;

import connection.ConexaoBanco;
import connection.ConnectionFactory;
import dao.ItemDAO;
import java.awt.ScrollPane;
import java.sql.Connection;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import models.Item;

/**
 *
 * @author paulosousa
 */
public class Crud_completo extends javax.swing.JFrame {

    ItemDAO itemDAO = new ItemDAO();
    JTable tabela;
    DefaultTableModel itemTabela = new DefaultTableModel();
     Connection con;
     ConexaoBanco banco = new ConexaoBanco();
     
     
     
     
     public  void buscainformacoes() {
            
        try {
      
            ArrayList<Item> listaRetorno = new ArrayList<>();
            
            itemDAO = new ItemDAO();
           listaRetorno = itemDAO.selecionarItens();
            
        
          DefaultTableModel m1 = (DefaultTableModel) tbItensLista.getModel();
          m1.setNumRows(0);
       
           for(Item i : listaRetorno){
               m1.addRow(new Object[]{
                   i.getId(),
                   i.getNome(),
                   i.getDescricao(),
                   i.getPreco(),
                   i.getQuantidade()
               });
           }
            
            
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null,"Erro ao tentar retornar os itens do banco de datos >> "+ ex.getMessage());
        }
        
   
    }
    
     
    /**
     * Creates new form Crud_completo
     */
    public Crud_completo() {
        initComponents();
       // con =  ConnectionFactory.getConnection();
       // banco.conexao();
        
      //  buscainformacoes();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        btnCadastrar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jScrollPane3 = new javax.swing.JScrollPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbItensLista = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("CONTROLE DE PRODUTOS");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });
        getContentPane().setLayout(null);

        jLabel1.setText("ITENS CADASTRADOS");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(60, 24, 400, 30);

        btnCadastrar.setText("Cadastrar");
        btnCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarActionPerformed(evt);
            }
        });
        getContentPane().add(btnCadastrar);
        btnCadastrar.setBounds(270, 200, 110, 23);

        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });
        getContentPane().add(btnExcluir);
        btnExcluir.setBounds(400, 200, 110, 23);

        jButton1.setText("Buscar/ Editar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(130, 200, 120, 23);
        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(670, 90, 100, 100);

        tbItensLista.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tbItensLista.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Nome", "Descrição", "Preço", "Quantidade"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbItensLista.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbItensListaMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbItensLista);
        if (tbItensLista.getColumnModel().getColumnCount() > 0) {
            tbItensLista.getColumnModel().getColumn(0).setHeaderValue("ID");
            tbItensLista.getColumnModel().getColumn(1).setHeaderValue("Nome");
            tbItensLista.getColumnModel().getColumn(2).setHeaderValue("Descrição");
            tbItensLista.getColumnModel().getColumn(3).setHeaderValue("Preço");
            tbItensLista.getColumnModel().getColumn(4).setHeaderValue("Quantidade");
        }

        jScrollPane3.setViewportView(jScrollPane2);

        getContentPane().add(jScrollPane3);
        jScrollPane3.setBounds(60, 60, 560, 130);

        setSize(new java.awt.Dimension(670, 299));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarActionPerformed
        // TODO add your handling code here:
        
        CadastrarItem CI = new CadastrarItem();
        CI.setVisible(true);
    }//GEN-LAST:event_btnCadastrarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        // TODO add your handling code here:
        
    ExcluirItem ei = new ExcluirItem();
    ei.setVisible(true);
        
        
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
        BuscarItem BI = new BuscarItem();
        BI.setVisible(true);
        
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        // TODO add your handling code here:
        
        buscainformacoes();
    }//GEN-LAST:event_formWindowActivated

    private void tbItensListaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbItensListaMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tbItensListaMouseClicked

    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Crud_completo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Crud_completo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Crud_completo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Crud_completo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Crud_completo().setVisible(true);
            }
        });        
        
        
    }

    
    public boolean verificaCampos(){
       return false;
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCadastrar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable tbItensLista;
    // End of variables declaration//GEN-END:variables
}
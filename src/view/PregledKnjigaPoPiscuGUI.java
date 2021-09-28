/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import db.KonekcijaSaBazom;
import java.util.ArrayList;
import java.util.List;
import model.Pisac;
import model.Knjiga;
import model.table.ListaPisacaTableModel;
import model.table.PregledKnjigaTableModel;

public class PregledKnjigaPoPiscuGUI extends javax.swing.JFrame {

    KonekcijaSaBazom db;

    public PregledKnjigaPoPiscuGUI() {
        initComponents();
        cbPisci.removeAllItems();
        db = new KonekcijaSaBazom();
        List<Pisac> pisci = db.vratiSvePisce();
        for (Pisac pisac : pisci) {
            cbPisci.addItem(pisac);
        }

        this.tPregledKnjigaPoPiscu.setModel(new PregledKnjigaTableModel(new ArrayList<Knjiga>()));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cancelPregledKnjigaPoPiscu = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tPregledKnjigaPoPiscu = new javax.swing.JTable();
        cbPisci = new javax.swing.JComboBox();
        btnPronadjiKnjige = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        cancelPregledKnjigaPoPiscu.setText("Cancel");
        cancelPregledKnjigaPoPiscu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelPregledKnjigaPoPiscuActionPerformed(evt);
            }
        });

        tPregledKnjigaPoPiscu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tPregledKnjigaPoPiscu);

        cbPisci.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnPronadjiKnjige.setText("Pronadji Knjige");
        btnPronadjiKnjige.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPronadjiKnjigeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(cancelPregledKnjigaPoPiscu))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cbPisci, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnPronadjiKnjige))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbPisci, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPronadjiKnjige))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cancelPregledKnjigaPoPiscu)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cancelPregledKnjigaPoPiscuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelPregledKnjigaPoPiscuActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_cancelPregledKnjigaPoPiscuActionPerformed

    private void btnPronadjiKnjigeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPronadjiKnjigeActionPerformed
        Pisac pisac = (Pisac)cbPisci.getSelectedItem();
        List<Knjiga> knjige = db.vratiKnjigeOdPisca(pisac);
        this.tPregledKnjigaPoPiscu.setModel(new PregledKnjigaTableModel(knjige));
    }//GEN-LAST:event_btnPronadjiKnjigeActionPerformed

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
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PregledKnjigaPoPiscuGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PregledKnjigaPoPiscuGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PregledKnjigaPoPiscuGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PregledKnjigaPoPiscuGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PregledKnjigaPoPiscuGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPronadjiKnjige;
    private javax.swing.JButton cancelPregledKnjigaPoPiscu;
    private javax.swing.JComboBox cbPisci;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tPregledKnjigaPoPiscu;
    // End of variables declaration//GEN-END:variables
}

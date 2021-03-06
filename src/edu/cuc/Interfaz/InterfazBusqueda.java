/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.cuc.Interfaz;

import edu.cuc.Inventario.Inventario;
import edu.cuc.Inventario.Moneda;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Maution
 */
public class InterfazBusqueda extends javax.swing.JDialog {

    /**
     * Creates new form InterfazBusqueda
     */
    Inventario m;
    String ruta;
    ArrayList<Moneda> monedas;

    public InterfazBusqueda(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
        lblCodigo.setVisible(false);
        lblDesde.setVisible(false);
        lblHasta.setVisible(false);
        txtCodigo.setVisible(false);
        txtBusqueda.setVisible(false);
        txtBusqueda2.setVisible(false);
        ruta = "src/edu/cuc/Datos/datos.txt";
        m = new Inventario();
        //Cargar Tabla
        monedas = m.traermoneda(ruta);
        m.llenarMonedas(tblMonedas, monedas);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        clockFace1 = new org.edisoncor.gui.varios.ClockFace();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        cmbBusquedas = new javax.swing.JComboBox();
        txtBusqueda = new javax.swing.JTextField();
        lblDesde = new javax.swing.JLabel();
        lblHasta = new javax.swing.JLabel();
        txtBusqueda2 = new javax.swing.JTextField();
        txtCodigo = new javax.swing.JTextField();
        lblCodigo = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblMonedas = new javax.swing.JTable();
        lblPais = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                formMouseMoved(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(clockFace1, new org.netbeans.lib.awtextra.AbsoluteConstraints(882, 17, 120, 120));

        jButton1.setText("Buscar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(176, 97, -1, -1));

        jLabel1.setText("Tipo de busqueda:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 26, -1, -1));

        cmbBusquedas.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-----------------", "Llenar Tabla", "Por Codigo", "Por Precio de Compra", "Por Precio de Venta", "Por Pais", "Por Ceca", "Por Año", "Por Peso", "Por Metal", "Por Valor", "Por Rareza", "Por Vendidas", "Por No Vendidas", "Por Error" }));
        getContentPane().add(cmbBusquedas, new org.netbeans.lib.awtextra.AbsoluteConstraints(149, 17, 214, 32));
        getContentPane().add(txtBusqueda, new org.netbeans.lib.awtextra.AbsoluteConstraints(408, 33, 206, -1));

        lblDesde.setText("De");
        getContentPane().add(lblDesde, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 10, -1, -1));

        lblHasta.setText("Hasta");
        getContentPane().add(lblHasta, new org.netbeans.lib.awtextra.AbsoluteConstraints(508, 66, -1, -1));
        getContentPane().add(txtBusqueda2, new org.netbeans.lib.awtextra.AbsoluteConstraints(411, 87, 206, -1));
        getContentPane().add(txtCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(411, 31, 206, -1));

        lblCodigo.setText("Codigo");
        getContentPane().add(lblCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 10, -1, -1));

        tblMonedas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "N°", "Valor y Unidad         ", "Caracteriscas          ", "Ceca                     ", "Pais", "Peso                    ", "Año                    ", "Tipo de Metal        ", "Estado                  ", "Rareza                  ", "Precio de Compra", "Precio de venta", "Codigo", "Ubicacion", "Nota", "Error", "vendida"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblMonedas);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 173, 1020, 410));

        lblPais.setText("Pais");
        getContentPane().add(lblPais, new org.netbeans.lib.awtextra.AbsoluteConstraints(508, 10, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseMoved
        // TODO add youComprar handling code here:
//        Por Precio de Compra
//Por Precio de Venta
        String combo = cmbBusquedas.getSelectedItem().toString();
        if (combo.equalsIgnoreCase("-----------------")) {
            lblCodigo.setVisible(false);
            lblDesde.setVisible(false);
            lblHasta.setVisible(false);
            txtCodigo.setVisible(false);
            txtBusqueda.setVisible(false);
            txtBusqueda2.setVisible(false);
            txtCodigo.setText("");
            txtBusqueda.setText("");
            txtBusqueda2.setText("");
        } else if (combo.equalsIgnoreCase("Por Codigo")) {
            lblCodigo.setVisible(true);
            txtCodigo.setVisible(true);
            lblDesde.setVisible(false);
            lblHasta.setVisible(false);
            txtBusqueda.setVisible(false);
            txtBusqueda2.setVisible(false);
            txtBusqueda.setText("");
            txtBusqueda2.setText("");
        } else if (combo.equalsIgnoreCase("Por Precio de Compra") || combo.equalsIgnoreCase("Por Precio de Venta")) {
            lblDesde.setVisible(true);
            lblHasta.setVisible(true);
            txtBusqueda.setVisible(true);
            txtBusqueda2.setVisible(true);
            lblCodigo.setVisible(false);
            txtCodigo.setVisible(false);
                        txtCodigo.setText("");
            
        }else if (combo.equalsIgnoreCase("Llenar Tabla")) {
            lblCodigo.setVisible(false);
            lblDesde.setVisible(false);
            lblHasta.setVisible(false);
            txtCodigo.setVisible(false);
            txtBusqueda.setVisible(false);
            txtBusqueda2.setVisible(false);
                        txtCodigo.setText("");
            txtBusqueda.setText("");
            txtBusqueda2.setText("");
        }
    }//GEN-LAST:event_formMouseMoved

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            // TODO add your handling code here:
            String combo = cmbBusquedas.getSelectedItem().toString();
            switch (combo) {
                case "Llenar Tabla":
                    m.llenarMonedas(tblMonedas, monedas);
                    break;
                case "Por Codigo":
                    m.busquedaCodigo(tblMonedas, monedas, m.ConvertirStringADouble(txtCodigo));
                    break;
                case "Por Precio de Compra":
                    m.busquedaPrecioCompra(tblMonedas, monedas, m.convertirStringAInt(txtBusqueda), m.convertirStringAInt(txtBusqueda2));

                    break;
                case "Por Precio de Venta":
                    m.busquedaPrecio(tblMonedas, monedas, m.convertirStringAInt(txtBusqueda), m.convertirStringAInt(txtBusqueda2));
                    break;
                case "Por Pais":
                    m.busquedaPais(tblMonedas, monedas, txtBusqueda.getText());
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getLocalizedMessage());
        }
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(InterfazBusqueda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InterfazBusqueda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InterfazBusqueda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InterfazBusqueda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                InterfazBusqueda dialog = new InterfazBusqueda(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.edisoncor.gui.varios.ClockFace clockFace1;
    private javax.swing.JComboBox cmbBusquedas;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCodigo;
    private javax.swing.JLabel lblDesde;
    private javax.swing.JLabel lblHasta;
    private javax.swing.JLabel lblPais;
    private javax.swing.JTable tblMonedas;
    private javax.swing.JTextField txtBusqueda;
    private javax.swing.JTextField txtBusqueda2;
    private javax.swing.JTextField txtCodigo;
    // End of variables declaration//GEN-END:variables
}

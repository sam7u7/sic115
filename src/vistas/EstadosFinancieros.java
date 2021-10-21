package vistas;

import servicios.sqlEstadosFinancieros;
import Conexiones.Conexion;
import entidades.estadoFinanciero;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
/*import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;*/
import servicios.sqlPeriodo;

/**
 *
 * @author felix
 */
public class EstadosFinancieros extends javax.swing.JDialog {
    sqlEstadosFinancieros financiero = new sqlEstadosFinancieros();
    sqlPeriodo periodo = new sqlPeriodo();
 
    public EstadosFinancieros(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        SimpleDateFormat formatoIni =  new SimpleDateFormat("yyyy-MM-01");
        dateChooserCombo1.setDateFormat(formatoIni);
        //Hay que hacer que ponga bien el ultimo dia por mes
        SimpleDateFormat formatoFin =  new SimpleDateFormat("yyyy-MM-30");
        dateChooserCombo2.setDateFormat(formatoFin);
        llenarCombo();
        
    }
    
    public void llenarCombo(){
        periodo.fechaPeriodo(jComboBox1, 1);
        financiero.nombreEstado(jComboBox2, 1);
        financiero.nombreEstado(jComboBox3, 1);
    }
    
    /*public void generarReporte(String param1,String param2, String path,String tit){
        //Conexion
        Conexion con  = new Conexion();
        Connection conn = con.getConexion();
        try{
            //Variables a utilizar
            JasperReport reporte = null;
            String periodo;
            Map<String, Object> parametros = new HashMap<String, Object>(); //Mapaeado para parametros
            parametros.put(param1, jComboBox2.getSelectedItem().toString());
            periodo = jComboBox1.getSelectedItem().toString();
            parametros.put(param2, "'"+periodo+"'");
            reporte = (JasperReport) JRLoader.loadObjectFromFile(path); //Carga del reporte
            JasperPrint jprint; //Variable de impresion
            jprint = JasperFillManager.fillReport(reporte, parametros, conn); //Impresion del reporte
            JasperViewer view = new JasperViewer(jprint, false); //Vista del reporte
            //view.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            //view.setLocationRelativeTo(null);
            view.setVisible(true);
            view.setTitle(tit); //Titulo del reporte
        }catch(JRException ex){
            JOptionPane.showMessageDialog(null, ex);
        }
    }*/

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        dateChooserCombo1 = new datechooser.beans.DateChooserCombo();
        jButton2 = new javax.swing.JButton();
        dateChooserCombo2 = new datechooser.beans.DateChooserCombo();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jComboBox3 = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Estados finacieros");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Visualizar estados financieros"));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel1.setText("Periodo");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel2.setText("Estado financiero");

        jButton1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton1.setText("Visualizar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jComboBox2, 0, 222, Short.MAX_VALUE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(32, 32, 32)
                .addComponent(jButton1)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Generar estados financieros"));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel3.setText("Periodo");

        dateChooserCombo1.setEnabled(false);

        jButton2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton2.setText("Generar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        dateChooserCombo2.setEnabled(false);

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 11)); // NOI18N
        jLabel4.setText("Inicio");

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 11)); // NOI18N
        jLabel5.setText("Fin");

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel6.setText("Estado finaciero");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(dateChooserCombo2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(dateChooserCombo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jComboBox3, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jButton2)
                                .addGap(56, 56, 56))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addContainerGap())))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dateChooserCombo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addGap(1, 1, 1)
                        .addComponent(dateChooserCombo2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jComboBox3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(44, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
           //Vatiables
           /*String path, parametro1, parametro2, titulo = "";
           //File url = new File("src/BalanceComprobacion.jasper");
           //path = url.getAbsolutePath();
           if(jComboBox2.getSelectedItem().equals("Balance de comprobacion")){
               path = "src\\recursos\\BalanceComprobacion.jasper"; //Lugar del reporte
               parametro2 = "fechaPeriodo";
               parametro1 = "nombreEstado";
               titulo = jComboBox2.getSelectedItem().toString();
               generarReporte(parametro1, parametro2, path, titulo);
           }else if(jComboBox2.getSelectedItem().equals("Estado de resultado")){
               path = "src\\recursos\\EstadoResultado.jasper"; //Lugar del reporte
               parametro2 = "fechas";
               parametro1 = "nombreEstad";
               titulo = jComboBox2.getSelectedItem().toString();
               //generarReporte(parametro1, parametro2, path, titulo);
           }else if(jComboBox2.getSelectedItem().equals("Estado de capital")){
               path = "src\\recursos\\BalanceGeneral.jasper"; //Lugar del reporte
               parametro2 = "fechas";
               parametro1 = "nombreEstad";
               titulo = jComboBox2.getSelectedItem().toString();
               //generarReporte(parametro1, parametro2, path, titulo);
           }else if(jComboBox2.getSelectedItem().equals("Balance general")){
               path = "src\\recursos\\BalanceGeneral.jasper"; //Lugar del reporte
               parametro2 = "fechas";
               parametro1 = "nombreEstad";
               titulo = jComboBox2.getSelectedItem().toString();
               generarReporte(parametro1, parametro2, path, titulo);
           }
           dispose();*/
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        //Variables
        String fechaIni, fechaFin;
        fechaIni = dateChooserCombo1.getText();
        fechaFin = dateChooserCombo2.getText();
        System.out.println(fechaIni);
        System.out.println(fechaFin);
        sqlEstadosFinancieros modSql = new sqlEstadosFinancieros();
        estadoFinanciero mod = new estadoFinanciero();
        //Proceso
        if(jComboBox3.getSelectedItem().equals("Balance de comprobacion")){
            mod.setId_tipo_estado_financiero(1);
            mod.setSaldo_estado_financiero(modSql.obtenerSaldoTotal(fechaIni, fechaFin));
        }else if(jComboBox3.getSelectedItem().equals("Estado de resultado")){
            mod.setId_tipo_estado_financiero(2);
        }else if(jComboBox3.getSelectedItem().equals("Estado de capital")){
            mod.setId_tipo_estado_financiero(3);
        }else if(jComboBox3.getSelectedItem().equals("Balance general")){
            mod.setId_tipo_estado_financiero(1);
            mod.setSaldo_estado_financiero(modSql.obtenerSaldoTotal(fechaIni, fechaFin));
        }
        mod.setFecha_inicio(fechaIni);
        mod.setFecha_fin(fechaFin);
        modSql.agregarEstado(mod);
        JOptionPane.showMessageDialog(null, "Se a guadardado el estado financiero");
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(EstadosFinancieros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EstadosFinancieros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EstadosFinancieros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EstadosFinancieros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                EstadosFinancieros dialog = new EstadosFinancieros(new javax.swing.JFrame(), true);
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
    private datechooser.beans.DateChooserCombo dateChooserCombo1;
    private datechooser.beans.DateChooserCombo dateChooserCombo2;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import java.awt.HeadlessException;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import javax.swing.JOptionPane;
import modelos.ModeloNoEditable;
import servicios.sqlGestionPeriodo;


public class CrearPeriodo extends javax.swing.JDialog {

    
        ModeloNoEditable modeloGestionPeriodo = new ModeloNoEditable();
        sqlGestionPeriodo sql = new sqlGestionPeriodo();
        Date fechaIni, fechaF;
        Date fechaVal = new Date();
        LocalDate local = fechaVal.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        
        
    public CrearPeriodo(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        formatoTablaGestionPeriodo();
        
        sql.llenarListaMeses(jComboBox1, 1);
        sql.llenarTabla(modeloGestionPeriodo, 3);
                  
    }
    
    public void seleccionaFecha() throws ParseException{
        int anio = local.getYear();
        
        String mes = jComboBox1.getSelectedItem().toString();
        
            switch (mes) {
                case "Enero":
                    {
                        SimpleDateFormat formatoIni =  new SimpleDateFormat("yyyy-01-01");
                        dateChooserCombo1.setDateFormat(formatoIni);
                        SimpleDateFormat formatoFin =  new SimpleDateFormat("yyyy-01-31");
                        dateChooserCombo2.setDateFormat(formatoFin);
                        break;
                    }
                case "Febrero":
                    if((anio%4 == 0) || (anio % 100 != 0) || (anio % 400 == 0)){
                         
                         SimpleDateFormat formatoIni =  new SimpleDateFormat("yyyy-02-01");
                         dateChooserCombo1.setDateFormat(formatoIni);
                         SimpleDateFormat formatoFin =  new SimpleDateFormat("yyyy-02-29");
                         dateChooserCombo2.setDateFormat(formatoFin);
                    }
                    else{
                        SimpleDateFormat formatoIni =  new SimpleDateFormat("yyyy-02-01");
                        dateChooserCombo1.setDateFormat(formatoIni);
                        SimpleDateFormat formatoFin =  new SimpleDateFormat("yyyy-02-28");
                        dateChooserCombo2.setDateFormat(formatoFin);
                    }       break;
                case "Marzo":
                    {
                        SimpleDateFormat formatoIni =  new SimpleDateFormat("yyyy-03-01");
                        dateChooserCombo1.setDateFormat(formatoIni);
                        SimpleDateFormat formatoFin =  new SimpleDateFormat("yyyy-03-31");
                        dateChooserCombo2.setDateFormat(formatoFin);
                        break;
                    }
                case "Abril":
                    {
                        SimpleDateFormat formatoIni =  new SimpleDateFormat("yyyy-04-01");
                        dateChooserCombo1.setDateFormat(formatoIni);
                        SimpleDateFormat formatoFin =  new SimpleDateFormat("yyyy-04-30");
                        dateChooserCombo2.setDateFormat(formatoFin);
                        break;
                    }
                case "Mayo":
                    {
                        SimpleDateFormat formatoIni =  new SimpleDateFormat("yyyy-05-01");
                        dateChooserCombo1.setDateFormat(formatoIni);
                        SimpleDateFormat formatoFin =  new SimpleDateFormat("yyyy-05-31");
                        dateChooserCombo2.setDateFormat(formatoFin);
                        break;
                    }
                case "Junio":
                    {
                        SimpleDateFormat formatoIni =  new SimpleDateFormat("yyyy-06-01");
                        dateChooserCombo1.setDateFormat(formatoIni);
                        SimpleDateFormat formatoFin =  new SimpleDateFormat("yyyy-06-30");
                        dateChooserCombo2.setDateFormat(formatoFin);
                        break;
                    }
                case "Julio":
                    {
                        SimpleDateFormat formatoIni =  new SimpleDateFormat("yyyy-07-01");
                        dateChooserCombo1.setDateFormat(formatoIni);
                        SimpleDateFormat formatoFin =  new SimpleDateFormat("yyyy-07-31");
                        dateChooserCombo2.setDateFormat(formatoFin);
                        break;
                    }
                case "Agosto":
                    {
                        SimpleDateFormat formatoIni =  new SimpleDateFormat("yyyy-08-01");
                        dateChooserCombo1.setDateFormat(formatoIni);
                        SimpleDateFormat formatoFin =  new SimpleDateFormat("yyyy-08-31");
                        dateChooserCombo2.setDateFormat(formatoFin);
                        break;
                    }
                case "Septiembre":
                    {
                        SimpleDateFormat formatoIni =  new SimpleDateFormat("yyyy-09-01");
                        dateChooserCombo1.setDateFormat(formatoIni);
                        SimpleDateFormat formatoFin =  new SimpleDateFormat("yyyy-09-30");
                        dateChooserCombo2.setDateFormat(formatoFin);
                        break;
                    }
                case "Octubre":
                    {
                        SimpleDateFormat formatoIni =  new SimpleDateFormat("yyyy-10-01");
                        dateChooserCombo1.setDateFormat(formatoIni);
                        SimpleDateFormat formatoFin =  new SimpleDateFormat("yyyy-10-31");
                        dateChooserCombo2.setDateFormat(formatoFin);
                        break;
                    }
                case "Noviembre":
                    {
                        SimpleDateFormat formatoIni =  new SimpleDateFormat("yyyy-11-01");
                        dateChooserCombo1.setDateFormat(formatoIni);
                        SimpleDateFormat formatoFin =  new SimpleDateFormat("yyyy-11-30");
                        dateChooserCombo2.setDateFormat(formatoFin);
                        break;
                    }
                case "Diciembre":
                    {
                       SimpleDateFormat formatoIni =  new SimpleDateFormat("yyyy-12-01");
                       dateChooserCombo1.setDateFormat(formatoIni);
                       SimpleDateFormat formatoFin =  new SimpleDateFormat("yyyy-12-31");
                       dateChooserCombo2.setDateFormat(formatoFin);
                        break;
                    }
                default: 
                    {
                        SimpleDateFormat vacio =  new SimpleDateFormat("");
                        dateChooserCombo1.setDateFormat(vacio);
                        dateChooserCombo2.setDateFormat(vacio);
                    }   
            }
    }
    
    
    public void limpiar(){
        jComboBox1.setSelectedIndex(-1);
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        dateChooserCombo1 = new datechooser.beans.DateChooserCombo();
        dateChooserCombo2 = new datechooser.beans.DateChooserCombo();
        jLabel3 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jCheckBox1 = new javax.swing.JCheckBox();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Gestionar Periodo");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.MatteBorder(null), "Ingreso de un nuevo periodo", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Book Antiqua", 1, 12))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Book Antiqua", 1, 14)); // NOI18N
        jLabel1.setText("Fecha de inicio:");

        jLabel2.setFont(new java.awt.Font("Book Antiqua", 1, 14)); // NOI18N
        jLabel2.setText("Fecha de fin:");

        dateChooserCombo1.setCurrentView(new datechooser.view.appearance.AppearancesList("Swing",
            new datechooser.view.appearance.ViewAppearance("custom",
                new datechooser.view.appearance.swing.SwingCellAppearance(new java.awt.Font("Tahoma", java.awt.Font.PLAIN, 11),
                    new java.awt.Color(0, 0, 0),
                    new java.awt.Color(0, 0, 255),
                    false,
                    true,
                    new datechooser.view.appearance.swing.ButtonPainter()),
                new datechooser.view.appearance.swing.SwingCellAppearance(new java.awt.Font("Tahoma", java.awt.Font.PLAIN, 11),
                    new java.awt.Color(0, 0, 0),
                    new java.awt.Color(0, 0, 255),
                    true,
                    true,
                    new datechooser.view.appearance.swing.ButtonPainter()),
                new datechooser.view.appearance.swing.SwingCellAppearance(new java.awt.Font("Tahoma", java.awt.Font.PLAIN, 11),
                    new java.awt.Color(0, 0, 255),
                    new java.awt.Color(0, 0, 255),
                    false,
                    true,
                    new datechooser.view.appearance.swing.ButtonPainter()),
                new datechooser.view.appearance.swing.SwingCellAppearance(new java.awt.Font("Tahoma", java.awt.Font.PLAIN, 11),
                    new java.awt.Color(128, 128, 128),
                    new java.awt.Color(0, 0, 255),
                    false,
                    true,
                    new datechooser.view.appearance.swing.LabelPainter()),
                new datechooser.view.appearance.swing.SwingCellAppearance(new java.awt.Font("Tahoma", java.awt.Font.PLAIN, 11),
                    new java.awt.Color(0, 0, 0),
                    new java.awt.Color(0, 0, 255),
                    false,
                    true,
                    new datechooser.view.appearance.swing.LabelPainter()),
                new datechooser.view.appearance.swing.SwingCellAppearance(new java.awt.Font("Tahoma", java.awt.Font.PLAIN, 11),
                    new java.awt.Color(0, 0, 0),
                    new java.awt.Color(255, 0, 0),
                    false,
                    false,
                    new datechooser.view.appearance.swing.ButtonPainter()),
                (datechooser.view.BackRenderer)null,
                false,
                true)));
    try {
        dateChooserCombo1.setDefaultPeriods(new datechooser.model.multiple.PeriodSet(new datechooser.model.multiple.Period(new java.util.GregorianCalendar(2021, 9, 13),
            new java.util.GregorianCalendar(2021, 9, 13))));
} catch (datechooser.model.exeptions.IncompatibleDataExeption e1) {
    e1.printStackTrace();
    }
    dateChooserCombo1.setEnabled(false);

    try {
        dateChooserCombo2.setDefaultPeriods(new datechooser.model.multiple.PeriodSet(new datechooser.model.multiple.Period(new java.util.GregorianCalendar(2021, 10, 11),
            new java.util.GregorianCalendar(2021, 10, 11))));
} catch (datechooser.model.exeptions.IncompatibleDataExeption e1) {
    e1.printStackTrace();
    }
    dateChooserCombo2.setEnabled(false);
    try {
        dateChooserCombo2.setForbiddenPeriods(new datechooser.model.multiple.PeriodSet(new datechooser.model.multiple.Period(new java.util.GregorianCalendar(2020, 10, 30),
            new java.util.GregorianCalendar(2020, 10, 30))));
} catch (datechooser.model.exeptions.IncompatibleDataExeption e1) {
    e1.printStackTrace();
    }

    jLabel3.setFont(new java.awt.Font("Book Antiqua", 1, 14)); // NOI18N
    jLabel3.setText("Seleccionar mes:");

    jComboBox1.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jComboBox1ActionPerformed(evt);
        }
    });

    jButton1.setFont(new java.awt.Font("Book Antiqua", 1, 18)); // NOI18N
    jButton1.setText("Guardar");
    jButton1.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButton1ActionPerformed(evt);
        }
    });

    jCheckBox1.setFont(new java.awt.Font("Book Antiqua", 1, 14)); // NOI18N
    jCheckBox1.setLabel("Activo");

    javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
    jPanel1.setLayout(jPanel1Layout);
    jPanel1Layout.setHorizontalGroup(
        jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel1Layout.createSequentialGroup()
            .addGap(28, 28, 28)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel1)
                        .addComponent(jLabel2))
                    .addGap(18, 18, 18)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(dateChooserCombo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(dateChooserCombo2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addComponent(jLabel3)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jButton1)
                .addComponent(jCheckBox1))
            .addGap(29, 29, 29))
    );
    jPanel1Layout.setVerticalGroup(
        jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
            .addGap(19, 19, 19)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel3)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jCheckBox1))
            .addGap(18, 18, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel1)
                        .addComponent(dateChooserCombo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(17, 17, 17)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel2)
                        .addComponent(dateChooserCombo2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(14, 14, 14))
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(29, 29, 29))))
    );

    jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.MatteBorder(null), "Lista de periodos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Book Antiqua", 1, 12))); // NOI18N

    jTable1.setBorder(new javax.swing.border.MatteBorder(null));
    jTable1.setModel(new javax.swing.table.DefaultTableModel(
        new Object [][] {
            {null, null, null},
            {null, null, null},
            {null, null, null},
            {null, null, null},
            {null, null, null},
            {null, null, null},
            {null, null, null},
            {null, null, null},
            {null, null, null},
            {null, null, null},
            {null, null, null},
            {null, null, null},
            {null, null, null},
            {null, null, null}
        },
        new String [] {
            "Fecha inicio", "Fecha fin", "Activo"
        }
    ));
    jTable1.setRowSelectionAllowed(false);
    jScrollPane1.setViewportView(jTable1);

    javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
    jPanel2.setLayout(jPanel2Layout);
    jPanel2Layout.setHorizontalGroup(
        jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel2Layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );
    jPanel2Layout.setVerticalGroup(
        jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(155, 155, 155))
    );

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
            .addGap(12, 12, 12)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addContainerGap(11, Short.MAX_VALUE))
    );
    layout.setVerticalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(29, 29, 29)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(38, 38, 38))
    );

    pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        //seleccionaFecha();
        try{
            seleccionaFecha();
            // JOptionPane.showMessageDialog(null, );
        }catch(Exception e){
            
        }
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        String fechaIni, fechaF;
        
        fechaIni = dateChooserCombo1.getText();
        fechaF = dateChooserCombo2.getText();
        
        try{
            if(jComboBox1.getSelectedIndex() != -1 || !jComboBox1.getSelectedItem().toString().isEmpty()){
                if(jCheckBox1.isSelected()){
                    sql.ingresarPeriodo(java.sql.Date.valueOf(fechaIni), java.sql.Date.valueOf(fechaF), "si");
                }
                else{
                    sql.ingresarPeriodo(java.sql.Date.valueOf(fechaIni), java.sql.Date.valueOf(fechaF), "no");
                }
                //llenarTablaPeriodo();
                
            }else{
                JOptionPane.showMessageDialog(null, "Debe seleccionar el mes del cual desea crear el periodo contable");
                
            }
        }catch(HeadlessException e){
            System.out.print("error"+ e.getMessage());
        }
        
        limpiar();
        sql.llenarTabla(modeloGestionPeriodo, 3);
    }//GEN-LAST:event_jButton1ActionPerformed
    
    private void jComboBox1AddActionListener(ActionListener al){
        
    }
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
            java.util.logging.Logger.getLogger(CrearPeriodo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CrearPeriodo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CrearPeriodo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CrearPeriodo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                CrearPeriodo dialog = new CrearPeriodo(new javax.swing.JFrame(), true);
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
    
     public void formatoTablaGestionPeriodo(){
        jTable1.setModel(modeloGestionPeriodo);
        modeloGestionPeriodo.setColumnIdentifiers(new String[]{"Fecha inicio","Fecha fin", "Activo"});
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private datechooser.beans.DateChooserCombo dateChooserCombo1;
    private datechooser.beans.DateChooserCombo dateChooserCombo2;
    private javax.swing.JButton jButton1;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}

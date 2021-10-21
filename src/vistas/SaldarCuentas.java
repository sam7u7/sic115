package vistas;

import java.awt.HeadlessException;
import servicios.sqlSaldarCuentas;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
//import java.sql.Date;
import java.util.Date;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;
import javax.swing.JOptionPane;
import modelos.ModeloNoEditable;

public class SaldarCuentas extends javax.swing.JDialog {
    
    //variables
    sqlSaldarCuentas saldarCuentas = new sqlSaldarCuentas();
    ModeloNoEditable modeloCuentaSaldada = new ModeloNoEditable();
    ModeloNoEditable modeloTransaccion = new ModeloNoEditable();
   
    
    public SaldarCuentas(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
       
        //Formato para el calendario
         Date fechaVal = new Date();
         LocalDate local = fechaVal.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        //parametros   
        int anio = local.getYear();
        int mes = local.getMonthValue();       
        fechaMesDia(mes, anio);
        formatoTablaCuentaSaldada();
        formatoTablaTransacciones();
       
        saldarCuentas.llenarTabla(modeloCuentaSaldada, dateChooserCombo2.getText(), dateChooserCombo3.getText(), 5);
        saldarCuentas.llenarTablaMov(modeloTransaccion, 7, dateChooserCombo2.getText(),dateChooserCombo3.getText());
        saldarCuentas.llenarListaMeses(jComboBox1, 1);
        
    }
    
    public void fechaMesDia(int mes, int anio){
       switch (mes) {
                case 1:
                    {
                        SimpleDateFormat formatoIni =  new SimpleDateFormat("yyyy-01-01");
                        dateChooserCombo2.setDateFormat(formatoIni);
                        SimpleDateFormat formatoFin =  new SimpleDateFormat("yyyy-01-31");
                        dateChooserCombo3.setDateFormat(formatoFin);
                        break;
                    }
                case 2:
                    if((anio%4 == 0) || (anio % 100 != 0) || (anio % 400 == 0)){
                        SimpleDateFormat formatoIni =  new SimpleDateFormat("yyyy-02-01");
                        dateChooserCombo2.setDateFormat(formatoIni);
                        SimpleDateFormat formatoFin =  new SimpleDateFormat("yyyy-02-29");
                        dateChooserCombo3.setDateFormat(formatoFin);
                    }
                    else{
                        SimpleDateFormat formatoIni =  new SimpleDateFormat("yyyy-02-01");
                        dateChooserCombo2.setDateFormat(formatoIni);
                        SimpleDateFormat formatoFin =  new SimpleDateFormat("yyyy-02-28");
                        dateChooserCombo3.setDateFormat(formatoFin);
                    }       break;
                case 3:
                    {
                        SimpleDateFormat formatoIni =  new SimpleDateFormat("yyyy-03-01");
                        dateChooserCombo2.setDateFormat(formatoIni);
                        SimpleDateFormat formatoFin =  new SimpleDateFormat("yyyy-03-31");
                        dateChooserCombo3.setDateFormat(formatoFin);
                        break;
                    }
                case 4:
                    {
                        SimpleDateFormat formatoIni =  new SimpleDateFormat("yyyy-04-01");
                        dateChooserCombo2.setDateFormat(formatoIni);
                        SimpleDateFormat formatoFin =  new SimpleDateFormat("yyyy-04-30");
                        dateChooserCombo3.setDateFormat(formatoFin);
                        break;
                    }
                case 5:
                    {
                        SimpleDateFormat formatoIni =  new SimpleDateFormat("yyyy-05-01");
                        dateChooserCombo2.setDateFormat(formatoIni);
                        SimpleDateFormat formatoFin =  new SimpleDateFormat("yyyy-05-31");
                        dateChooserCombo3.setDateFormat(formatoFin);
                        break;
                    }
                case 6:
                    {
                        SimpleDateFormat formatoIni =  new SimpleDateFormat("yyyy-06-01");
                        dateChooserCombo2.setDateFormat(formatoIni);
                        SimpleDateFormat formatoFin =  new SimpleDateFormat("yyyy-06-30");
                        dateChooserCombo3.setDateFormat(formatoFin);
                        break;
                    }
                case 7:
                    {
                        SimpleDateFormat formatoIni =  new SimpleDateFormat("yyyy-MM-01");
                        dateChooserCombo2.setDateFormat(formatoIni);
                        SimpleDateFormat formatoFin =  new SimpleDateFormat("yyyy-MM-31");
                        dateChooserCombo3.setDateFormat(formatoFin);
                        break;
                    }
                case 8:
                    {
                        SimpleDateFormat formatoIni =  new SimpleDateFormat("yyyy-MM-01");
                        dateChooserCombo2.setDateFormat(formatoIni);
                        SimpleDateFormat formatoFin =  new SimpleDateFormat("yyyy-MM-31");
                        dateChooserCombo3.setDateFormat(formatoFin);
                        break;
                    }
                case 9:
                    {
                        SimpleDateFormat formatoIni =  new SimpleDateFormat("yyyy-MM-01");
                        dateChooserCombo2.setDateFormat(formatoIni);
                        SimpleDateFormat formatoFin =  new SimpleDateFormat("yyyy-MM-30");
                        dateChooserCombo3.setDateFormat(formatoFin);
                        break;
                    }
                case 10:
                    {
                        SimpleDateFormat formatoIni =  new SimpleDateFormat("yyyy-MM-01");
                        dateChooserCombo2.setDateFormat(formatoIni);
                        SimpleDateFormat formatoFin =  new SimpleDateFormat("yyyy-MM-31");
                        dateChooserCombo3.setDateFormat(formatoFin);
                        break;
                    }
                case 11:
                    {
                        SimpleDateFormat formatoIni =  new SimpleDateFormat("yyyy-MM-01");
                        dateChooserCombo2.setDateFormat(formatoIni);
                        SimpleDateFormat formatoFin =  new SimpleDateFormat("yyyy-MM-30");
                        dateChooserCombo3.setDateFormat(formatoFin);
                        break;
                    }
                case 12:
                    {
                        SimpleDateFormat formatoIni =  new SimpleDateFormat("yyyy-MM-01");
                        dateChooserCombo2.setDateFormat(formatoIni);
                        SimpleDateFormat formatoFin =  new SimpleDateFormat("yyyy-MM-31");
                        dateChooserCombo3.setDateFormat(formatoFin);
                        break;
                    } 
       }
    }
    
    public void seleccionaFecha(){
        Date fechaVal = new Date();
        LocalDate local = fechaVal.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        int anio = local.getYear();
        String mes = jComboBox1.getSelectedItem().toString();
            switch (mes) {
                case "Enero":
                    {
                        SimpleDateFormat formatoIni =  new SimpleDateFormat("yyyy-01-01");
                        dateChooserCombo2.setDateFormat(formatoIni);
                        SimpleDateFormat formatoFin =  new SimpleDateFormat("yyyy-01-31");
                        dateChooserCombo3.setDateFormat(formatoFin);
                        break;
                    }
                case "Febrero":
                    if((anio%4 == 0) || (anio % 100 != 0) || (anio % 400 == 0)){
                        SimpleDateFormat formatoIni =  new SimpleDateFormat("yyyy-02-01");
                        dateChooserCombo2.setDateFormat(formatoIni);
                        SimpleDateFormat formatoFin =  new SimpleDateFormat("yyyy-02-29");
                        dateChooserCombo3.setDateFormat(formatoFin);
                    }
                    else{
                        SimpleDateFormat formatoIni =  new SimpleDateFormat("yyyy-02-01");
                        dateChooserCombo2.setDateFormat(formatoIni);
                        SimpleDateFormat formatoFin =  new SimpleDateFormat("yyyy-02-28");
                        dateChooserCombo3.setDateFormat(formatoFin);
                    }       break;
                case "Marzo":
                    {
                        SimpleDateFormat formatoIni =  new SimpleDateFormat("yyyy-03-01");
                        dateChooserCombo2.setDateFormat(formatoIni);
                        SimpleDateFormat formatoFin =  new SimpleDateFormat("yyyy-03-31");
                        dateChooserCombo3.setDateFormat(formatoFin);
                        break;
                    }
                case "Abril":
                    {
                        SimpleDateFormat formatoIni =  new SimpleDateFormat("yyyy-04-01");
                        dateChooserCombo2.setDateFormat(formatoIni);
                        SimpleDateFormat formatoFin =  new SimpleDateFormat("yyyy-04-30");
                        dateChooserCombo3.setDateFormat(formatoFin);
                        break;
                    }
                case "Mayo":
                    {
                        SimpleDateFormat formatoIni =  new SimpleDateFormat("yyyy-05-01");
                        dateChooserCombo2.setDateFormat(formatoIni);
                        SimpleDateFormat formatoFin =  new SimpleDateFormat("yyyy-05-31");
                        dateChooserCombo3.setDateFormat(formatoFin);
                        break;
                    }
                case "Junio":
                    {
                        SimpleDateFormat formatoIni =  new SimpleDateFormat("yyyy-06-01");
                        dateChooserCombo2.setDateFormat(formatoIni);
                        SimpleDateFormat formatoFin =  new SimpleDateFormat("yyyy-06-30");
                        dateChooserCombo3.setDateFormat(formatoFin);
                        break;
                    }
                case "Julio":
                    {
                        SimpleDateFormat formatoIni =  new SimpleDateFormat("yyyy-07-01");
                        dateChooserCombo2.setDateFormat(formatoIni);
                        SimpleDateFormat formatoFin =  new SimpleDateFormat("yyyy-07-31");
                        dateChooserCombo3.setDateFormat(formatoFin);
                        break;
                    }
                case "Agosto":
                    {
                        SimpleDateFormat formatoIni =  new SimpleDateFormat("yyyy-08-01");
                        dateChooserCombo2.setDateFormat(formatoIni);
                        SimpleDateFormat formatoFin =  new SimpleDateFormat("yyyy-08-31");
                        dateChooserCombo3.setDateFormat(formatoFin);
                        break;
                    }
                case "Septiembre":
                    {
                        SimpleDateFormat formatoIni =  new SimpleDateFormat("yyyy-09-01");
                        dateChooserCombo2.setDateFormat(formatoIni);
                        SimpleDateFormat formatoFin =  new SimpleDateFormat("yyyy-09-30");
                        dateChooserCombo3.setDateFormat(formatoFin);
                        break;
                    }
                case "Octubre":
                    {
                        SimpleDateFormat formatoIni =  new SimpleDateFormat("yyyy-10-01");
                        dateChooserCombo2.setDateFormat(formatoIni);
                        SimpleDateFormat formatoFin =  new SimpleDateFormat("yyyy-10-31");
                        dateChooserCombo3.setDateFormat(formatoFin);
                        break;
                    }
                case "Noviembre":
                    {
                        SimpleDateFormat formatoIni =  new SimpleDateFormat("yyyy-11-01");
                        dateChooserCombo2.setDateFormat(formatoIni);
                        SimpleDateFormat formatoFin =  new SimpleDateFormat("yyyy-11-30");
                        dateChooserCombo3.setDateFormat(formatoFin);
                        break;
                    }
                case "Diciembre":
                    {
                        SimpleDateFormat formatoIni =  new SimpleDateFormat("yyyy-12-01");
                        dateChooserCombo2.setDateFormat(formatoIni);
                        SimpleDateFormat formatoFin =  new SimpleDateFormat("yyyy-12-31");
                        dateChooserCombo3.setDateFormat(formatoFin);
                        break;
                    }              
            }
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        dateChooserCombo2 = new datechooser.beans.DateChooserCombo();
        dateChooserCombo3 = new datechooser.beans.DateChooserCombo();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Saldar cuentas");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.MatteBorder(null), "Datos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Book Antiqua", 1, 11))); // NOI18N
        jPanel1.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Book Antiqua", 1, 12)); // NOI18N
        jLabel1.setText("Inicio de periodo");

        dateChooserCombo2.setFormat(2);
        dateChooserCombo2.setWeekStyle(datechooser.view.WeekDaysStyle.SHORT);
        try {
            dateChooserCombo2.setDefaultPeriods(new datechooser.model.multiple.PeriodSet(new datechooser.model.multiple.Period(new java.util.GregorianCalendar(2020, 10, 17),
                new java.util.GregorianCalendar(2020, 10, 17))));
    } catch (datechooser.model.exeptions.IncompatibleDataExeption e1) {
        e1.printStackTrace();
    }
    dateChooserCombo2.setEnabled(false);

    try {
        dateChooserCombo3.setDefaultPeriods(new datechooser.model.multiple.PeriodSet(new datechooser.model.multiple.Period(new java.util.GregorianCalendar(2020, 10, 17),
            new java.util.GregorianCalendar(2020, 10, 17))));
} catch (datechooser.model.exeptions.IncompatibleDataExeption e1) {
    e1.printStackTrace();
    }
    dateChooserCombo3.setEnabled(false);
    try {
        dateChooserCombo3.setForbiddenPeriods(new datechooser.model.multiple.PeriodSet());
    } catch (datechooser.model.exeptions.IncompatibleDataExeption e1) {
        e1.printStackTrace();
    }

    jLabel2.setFont(new java.awt.Font("Book Antiqua", 1, 12)); // NOI18N
    jLabel2.setText("Fin de periodo");

    jButton1.setFont(new java.awt.Font("Book Antiqua", 1, 12)); // NOI18N
    jButton1.setText("Saldar cuentas");
    jButton1.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButton1ActionPerformed(evt);
        }
    });

    jComboBox1.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jComboBox1ActionPerformed(evt);
        }
    });

    jLabel3.setFont(new java.awt.Font("Book Antiqua", 1, 12)); // NOI18N
    jLabel3.setText("Periodo:");

    javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
    jPanel1.setLayout(jPanel1Layout);
    jPanel1Layout.setHorizontalGroup(
        jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel1Layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addComponent(jLabel1)
                    .addGap(143, 436, Short.MAX_VALUE))
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(dateChooserCombo3, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2)
                        .addComponent(dateChooserCombo2, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jButton1)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap())))
    );
    jPanel1Layout.setVerticalGroup(
        jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel1Layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(jLabel1)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(dateChooserCombo2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)))
            .addGap(18, 18, 18)
            .addComponent(jLabel2)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(dateChooserCombo3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jButton1)))
    );

    jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.MatteBorder(null), "Cuentas saldadas", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Book Antiqua", 1, 11))); // NOI18N
    jPanel2.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N

    jTable1.setBorder(new javax.swing.border.MatteBorder(null));
    jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
    jTable1.setEnabled(false);
    jScrollPane1.setViewportView(jTable1);

    javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
    jPanel2.setLayout(jPanel2Layout);
    jPanel2Layout.setHorizontalGroup(
        jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 540, Short.MAX_VALUE)
    );
    jPanel2Layout.setVerticalGroup(
        jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel2Layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );

    jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.MatteBorder(null), "Transacciones", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Book Antiqua", 1, 11))); // NOI18N
    jPanel3.setName("Datos"); // NOI18N

    jTable2.setBorder(new javax.swing.border.MatteBorder(null));
    jTable2.setModel(new javax.swing.table.DefaultTableModel(
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
    jTable2.setEnabled(false);
    jScrollPane2.setViewportView(jTable2);

    javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
    jPanel3.setLayout(jPanel3Layout);
    jPanel3Layout.setHorizontalGroup(
        jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel3Layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 597, Short.MAX_VALUE)
            .addContainerGap())
    );
    jPanel3Layout.setVerticalGroup(
        jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel3Layout.createSequentialGroup()
            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(0, 0, Short.MAX_VALUE))
    );

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
            .addGap(19, 19, 19)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGap(18, 18, 18)
            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap(19, Short.MAX_VALUE))
    );
    layout.setVerticalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createSequentialGroup()
                    .addGap(12, 12, 12)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );

    jPanel3.getAccessibleContext().setAccessibleDescription("Transacciones");

    pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
            String fechaI= dateChooserCombo2.getText();
            String fechaF= dateChooserCombo3.getText();
            saldarCuentas.obtenerMovimientos(fechaI, fechaF);
            saldarCuentas.llenarTabla(modeloCuentaSaldada, fechaI, fechaF, 5);
            if(saldarCuentas.bandera == 1){
                RegistrarTransaccion rt = new RegistrarTransaccion(new javax.swing.JFrame(), true);
                this.setVisible(false);
                rt.setVisible(true);
                saldarCuentas.bandera = 0;          
            }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        try{
            seleccionaFecha();
            saldarCuentas.llenarTabla(modeloCuentaSaldada, dateChooserCombo2.getText(), dateChooserCombo3.getText(), 5);
            saldarCuentas.llenarTablaMov(modeloTransaccion, 7, dateChooserCombo2.getText(),dateChooserCombo3.getText());
        }catch(Exception e){
        
        }
    }//GEN-LAST:event_jComboBox1ActionPerformed

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
            java.util.logging.Logger.getLogger(SaldarCuentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SaldarCuentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SaldarCuentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SaldarCuentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                SaldarCuentas dialog = new SaldarCuentas(new javax.swing.JFrame(), true);
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
    
    public void formatoTablaCuentaSaldada(){
        jTable1.setModel(modeloCuentaSaldada);
        modeloCuentaSaldada.setColumnIdentifiers(new String[]{"Cuenta", "Debe", "Haber", "Fecha Inicio", "Fecha Fin"});
    }
    
    public void formatoTablaTransacciones(){
        jTable2.setModel(modeloTransaccion);
        modeloTransaccion.setColumnIdentifiers(new String[]{"Cuenta", "Tipo Cuenta", "Tipo Movimiento", "Descripcion", "Fecha", "Debe", "Haber"});
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private datechooser.beans.DateChooserCombo dateChooserCombo2;
    private datechooser.beans.DateChooserCombo dateChooserCombo3;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    // End of variables declaration//GEN-END:variables
}

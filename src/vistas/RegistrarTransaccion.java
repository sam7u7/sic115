package vistas;
import entidades.movimiento;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import modelos.ModeloNoEditable;
import servicios.sqlMovimiento;
/**
 *
 * @author felix
 */
public class RegistrarTransaccion extends javax.swing.JDialog {
    //Variables a utilizar
    sqlMovimiento movimiento = new sqlMovimiento();
    ModeloNoEditable modeloMovimiento = new ModeloNoEditable();
    List<movimiento> mod = new ArrayList<movimiento>();
    
    public RegistrarTransaccion(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        llenarCuenta();
        formatoTablaMov();
        //Formato para el calendario
        SimpleDateFormat fechaForm = new SimpleDateFormat("yyyy-MM-dd");
        dateChooserCombo1.setDateFormat(fechaForm);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
    }

    public void llenarCuenta(){
        movimiento.cuenta(jComboBox1, 1);
    }
    public void formatoTablaMov(){
        jTable1.setModel(modeloMovimiento);
        modeloMovimiento.setColumnIdentifiers(new String[]{"Fecha", "Cuenta", "Debe", "Haber"});
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jTextField2 = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jCheckBox1 = new javax.swing.JCheckBox();
        jLabel4 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        dateChooserCombo1 = new datechooser.beans.DateChooserCombo();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jTotalDebe = new javax.swing.JTextField();
        jTotalHaber = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Registrar Transacciones");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Ingreso datos"));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel1.setText("Fecha");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel2.setText("Cuenta");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel3.setText("Monto");

        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Acción"));

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jRadioButton1.setText("Cargar");

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jRadioButton2.setText("Abonar");

        jCheckBox1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jCheckBox1.setText("IVA");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jCheckBox1)
                .addGap(16, 16, 16))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jRadioButton1)
                    .addComponent(jRadioButton2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addComponent(jRadioButton1)
                .addGap(18, 18, 18)
                .addComponent(jRadioButton2)
                .addGap(28, 28, 28)
                .addComponent(jCheckBox1)
                .addContainerGap())
        );

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel4.setText("Descripcion");

        dateChooserCombo1.setCalendarPreferredSize(new java.awt.Dimension(360, 240));
        try {
            dateChooserCombo1.setDefaultPeriods(new datechooser.model.multiple.PeriodSet(new datechooser.model.multiple.Period(new java.util.GregorianCalendar(2020, 10, 17),
                new java.util.GregorianCalendar(2020, 10, 17))));
    } catch (datechooser.model.exeptions.IncompatibleDataExeption e1) {
        e1.printStackTrace();
    }

    javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
    jPanel1.setLayout(jPanel1Layout);
    jPanel1Layout.setHorizontalGroup(
        jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel1Layout.createSequentialGroup()
            .addGap(33, 33, 33)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jLabel3)
                .addComponent(jLabel2)
                .addComponent(jLabel1)
                .addComponent(jLabel4))
            .addGap(29, 29, 29)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(dateChooserCombo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(27, 27, 27))
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addComponent(jTextField3)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addContainerGap())
    );
    jPanel1Layout.setVerticalGroup(
        jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel1Layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel1)
                        .addComponent(dateChooserCombo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel2)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(58, 58, 58))))
    );

    jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Registros"));

    jTable1.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
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
    jTable1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
    jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            jTable1MouseClicked(evt);
        }
    });
    jScrollPane1.setViewportView(jTable1);

    jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
    jLabel5.setText("Totales");

    jTotalDebe.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
    jTotalDebe.setEnabled(false);

    jTotalHaber.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
    jTotalHaber.setEnabled(false);

    javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
    jPanel2.setLayout(jPanel2Layout);
    jPanel2Layout.setHorizontalGroup(
        jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel2Layout.createSequentialGroup()
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 578, Short.MAX_VALUE))
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5)
                    .addGap(18, 18, 18)
                    .addComponent(jTotalDebe, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(33, 33, 33)
                    .addComponent(jTotalHaber, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(21, 21, 21)))
            .addContainerGap())
    );
    jPanel2Layout.setVerticalGroup(
        jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel2Layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jTotalHaber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jTotalDebe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel5))
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );

    jButton2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
    jButton2.setText("Eliminar seleccion");
    jButton2.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButton2ActionPerformed(evt);
        }
    });

    jButton1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
    jButton1.setText("Agregar");
    jButton1.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButton1ActionPerformed(evt);
        }
    });

    jButton3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
    jButton3.setText("Guardar transaccion");
    jButton3.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButton3ActionPerformed(evt);
        }
    });

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
            .addGap(21, 21, 21)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addComponent(jButton1)
                    .addGap(49, 49, 49)
                    .addComponent(jButton2)
                    .addGap(33, 33, 33))
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addComponent(jButton3)
                    .addGap(38, 38, 38))))
    );
    layout.setVerticalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
            .addGap(23, 23, 23)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jButton2)
                .addComponent(jButton1))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
            .addComponent(jButton3)
            .addContainerGap())
    );

    pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        //LLenar tabla datos ingresados
        String nombreCuenta;
        movimiento movi = new movimiento();
        //Validacion de campos vacios
        if(dateChooserCombo1.getText().equals("") || jTextField2.getText().equals("") || jComboBox1.getSelectedIndex() == -1 || jTextField3.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Debe llenar todos los campos");
        }else{
            Object[] fila = new Object[4];
            double resultado = 0;
            int codigo = 0;
            movi.setDescripcion(jTextField3.getText());
            fila[0]= dateChooserCombo1.getText();
            movi.setFecha(dateChooserCombo1.getText());
            fila[1] = jComboBox1.getItemAt(jComboBox1.getSelectedIndex());
            //Validar para traer el codigo de la cuenta
            nombreCuenta = jComboBox1.getItemAt(jComboBox1.getSelectedIndex());
            codigo = movimiento.obtenerId(nombreCuenta);
            movi.setId_cuenta(codigo);
            if(jRadioButton1.isSelected()){
                if(jCheckBox1.isSelected()){
                    resultado = Double.parseDouble(jTextField2.getText())+Double.parseDouble(jTextField2.getText())*0.13;
                    fila[2] = String.valueOf(String.valueOf(resultado));
                }else{
                    fila[2] = String.valueOf(jTextField2.getText()); 
                    resultado = Double.parseDouble(jTextField2.getText());
                }
                movi.setCantidad_movimiento_debe(resultado);
                movi.setTipo(jRadioButton1.getText());
                fila[3] = "0.0";
                agregarFila(fila);
                limpiar();
            }else if (jRadioButton2.isSelected()){
                fila[2] ="0.0";
                if(jCheckBox1.isSelected()){
                    resultado = Double.parseDouble(jTextField2.getText())+Double.parseDouble(jTextField2.getText())*0.13;
                    fila[3] = String.valueOf(String.valueOf(resultado));
                }else{
                    fila[3] = String.valueOf(jTextField2.getText());
                    resultado = Double.parseDouble(jTextField2.getText());
                }
                movi.setCantidad_movimiento_haber(resultado);
                movi.setTipo(jRadioButton2.getText());
                agregarFila(fila);
                limpiar();
            }else{
                JOptionPane.showMessageDialog(null, "Seleccione un tipo");
            }
            mod.add(movi); 
        }
            
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        agregarMov(mod);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        int fila = jTable1.getSelectedRow();
        modeloMovimiento.removeRow(fila);
        mod.remove(fila);
        limpiar();
        jTotalDebe.setText(String.valueOf(suma(2)));
        jTotalHaber.setText(String.valueOf(suma(3)));
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

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
            java.util.logging.Logger.getLogger(RegistrarTransaccion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegistrarTransaccion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegistrarTransaccion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegistrarTransaccion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                RegistrarTransaccion dialog = new RegistrarTransaccion(new javax.swing.JFrame(), true);
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
    
    public void agregarFila(Object[] fila){
        modeloMovimiento.addRow(fila);
        jTotalDebe.setText(String.valueOf(suma(2)));
        jTotalHaber.setText(String.valueOf(suma(3)));
    }
    
    public void limpiar(){
        jTextField2.setText("");
        jComboBox1.setSelectedIndex(-1);
        jTextField3.setText("");
        buttonGroup1.clearSelection();
        jCheckBox1.setSelected(false);
    }
    
    public void limpiarTabla(){
        jTotalDebe.setText("");
        jTotalHaber.setText("");
        try{
            int filas = jTable1.getRowCount();
            for(int i =0;i<filas;i++){
                modeloMovimiento.removeRow(0);
            }   
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Error al limpiar la tabla");   
        }
    }
    
    public void agregarMov(List<movimiento> modi){
        sqlMovimiento modSql = new sqlMovimiento();
        //Agregar
        if(modSql.agregar(modi)){
            JOptionPane.showMessageDialog(null, "Registro guardado"); 
            mod.clear();
            //Llenar el total
            limpiar();
            limpiarTabla();
        }else{
            JOptionPane.showMessageDialog(null, "Error, El registro no se pudo guardar");
        }
    }
    
    public double suma(int colum){
        int contar=jTable1.getRowCount();
        double suma = 0;
        for(int i = 0;i< contar; i++){
            suma = suma + Double.parseDouble(jTable1.getValueAt(i, colum).toString());
        }
        return suma;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private datechooser.beans.DateChooserCombo dateChooserCombo1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTotalDebe;
    private javax.swing.JTextField jTotalHaber;
    // End of variables declaration//GEN-END:variables
}

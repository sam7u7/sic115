/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author felix
 */
public class ModeloNoEditable extends DefaultTableModel {
    public boolean isCellEditable(int r, int c){
        return false;
    }
}

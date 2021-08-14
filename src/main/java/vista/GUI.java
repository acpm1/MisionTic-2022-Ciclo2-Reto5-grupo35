/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.ControladorRequerimientos;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JScrollBar;
import javax.swing.table.DefaultTableModel;
import modelo.vo.Requerimiento_1Vo;
import modelo.vo.Requerimiento_2Vo;
import modelo.vo.Requerimiento_3Vo;

/**
 *
 * @author miguel
 */
public class GUI extends javax.swing.JFrame {
    

    /**
     * Creates new form GUI
     */
    
   
    //clear_table()   : to clear the Jtable rows after display a query
    //setscrollbar()  : to set the position of the scrollbar at the top after a query
    //                  to facilitate the exploration
    //set_html(String): helps to display the query statement with justified text 
    
    //set_columns_names(String,String): to change column names of table after a query
    
    //addRowToJTable1(): to fetch data from database to populate a Jtableby using 
    //                   consultarRequerimiento1() method of ControladorRequerimientos class
    //addRowToJTable2(): to fetch data from database to populate a Jtableby using 
    //                   consultarRequerimiento2() method of ControladorRequerimientos class
    //addRowToJTable3(): to fetch data from database to populate a Jtableby using 
    //                   consultarRequerimiento3() method of ControladorRequerimientos class 
    
    // jComboBox1ActionPerformed(ActionEvent evt): to call the corresponding method addRowToJTableX()
            
    public GUI() 
    {               
        initComponents();
        myiniComponents();
    }
    
    private void myiniComponents()
    {
        
    //        addRowToJTable1();
    //        jTextArea1.setVisible(false);
    //        jScrollPane2.setVisible(false);

    setTitle("MisionTic 2022 - Ciclo 2 - Reto5 - Grupo 35");
    setDefaultCloseOperation(EXIT_ON_CLOSE); 
    set_columns_names("variable 1","variable 2");
    
    }
    
    // method
    @SuppressWarnings("empty-statement")
    private void clear_table(){
        
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        int cleared_rows = model.getRowCount();
        for(int i = cleared_rows-1;i>=0;i--){
            model.removeRow(i);
        }   
        
    }
    
    private void setscrollbar()
    {
        JScrollBar vertical = jScrollPane1.getVerticalScrollBar();
        vertical.setValue( vertical.getMinimum());
    }
    
   
    private void set_html(String mytext){
        
        String html = " <html>\n" +
                "<head>\n" +
                "</head>\n" +
                "<body>\n" +
                "<p><b>Enunciado:</b></p>"+"</br>"+
                "<p align=\"justify\">"+mytext +"</p>\n" +
                "</body>\n" +
                "</html>";//    e.printStackTrace();
        jEditorPane1.setContentType("text/html");
        jEditorPane1.setText(html);
        
    }
    
    private void set_columns_names(String column1,String column2){
        
     jTable1.getColumnModel().getColumn(0).setHeaderValue(column1);
     jTable1.getColumnModel().getColumn(1).setHeaderValue(column2);


    }
        
    
    public void addRowToJTable1()
    {   
        
        clear_table();
        setscrollbar();
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        

//        ArrayList<User> list = ListUsers();
        
        ArrayList<Requerimiento_1Vo> mylist = null;
        
        var controlador = new ControladorRequerimientos();
        
        try {
            mylist = controlador.consultarRequerimiento1();           
            
        } catch (SQLException ex) {
            Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Object rowData[] = new Object[2];
        
        for (Requerimiento_1Vo dato: mylist){
        
        rowData[0] = dato.getCiudad_Residencia();
        rowData[1] = Math.round(dato.getPromedio());
        model.addRow(rowData);   
               
//        System.out.println(dato.getID_Proyecto()+" "+dato.getNombre_Material());
            // Su código           
        }
        
        String mytext = "Listado del promedio de los salarios de los líderes de proyecto, agrupados por Ciudad de" +
        " Residencia, y teniendo salario promedio inferior a 500.000. Devolver campos" +
        " Ciudad_Residencia y AVG(Salario) con el alias de Promedio para la columna calculada del" +
        " promedio. Los promedios deben ser ordenados de forma descendente." +
        " Nota: para visualizar el promedio utilizar Math.round.";
        
        set_html(mytext);        
        set_columns_names("Ciudad_Residencia", "Promedio");
                    
    }

    public void addRowToJTable2()
    {   
        clear_table();
        setscrollbar();
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
//        ArrayList<User> list = ListUsers();
        
        ArrayList<Requerimiento_2Vo> mylist = null; 
        
        var controlador = new ControladorRequerimientos();
        
        try {
            mylist = controlador.consultarRequerimiento2();           
            
        } catch (SQLException ex) {
            Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Object rowData[] = new Object[2];
        
        for (Requerimiento_2Vo dato: mylist){
        
        rowData[0] = dato.getID_Proyecto();
        rowData[1] = (dato.getProveedor());
        model.addRow(rowData);   
               
//        System.out.println(dato.getID_Proyecto()+" "+dato.getNombre_Material());
            // Su código           
        }
              
        String mytext = "Listado de los nombres de los proveedores de las diferentes compras realizadas para los" +
        " proyectos de la ciudad de Bogotá. Devolver los campos ID_Proyecto (de la tabla Proyecto)" +
        " y Proveedor (de la tabla Compra).";

        set_html(mytext);        
        set_columns_names("ID_Proyecto", "Proveedor");
        
    }  

    public void addRowToJTable3()
    {   
        clear_table();
        setscrollbar();
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
//        ArrayList<User> list = ListUsers();
        
        ArrayList<Requerimiento_3Vo> mylist = null;  
        
        var controlador = new ControladorRequerimientos();
        
        try {
            mylist = controlador.consultarRequerimiento3();           
            
        } catch (SQLException ex) {
            Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Object rowData[] = new Object[2];
        
        for (Requerimiento_3Vo dato: mylist){
        
        rowData[0] = dato.getID_Proyecto();
        rowData[1] = (dato.getNombre_Material());
        model.addRow(rowData);   
               
//        System.out.println(dato.getID_Proyecto()+" "+dato.getNombre_Material());
            // Su código           
        }
    
        String mytext = "Listado de materiales utilizados para los proyectos con ID entre 20 y 35 ordenados de" +
        " forma ascendente por el ID del proyecto. Devolver los campos id_Proyecto (de la tabla" +
        " Proyecto) y Nombre_Material (de la tabla MaterialConstruccion).";

        set_html(mytext);        
        set_columns_names("ID_Proyecto", "Nombre_Material");
                        
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
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jEditorPane1 = new javax.swing.JEditorPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Ciudad", "Promedio"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "query 1", "query 2", "query 3" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jLabel1.setText("Seleccione la consulta:");

        jScrollPane3.setViewportView(jEditorPane1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(9, 9, 9)))
                        .addGap(143, 143, 143)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 457, Short.MAX_VALUE)
                .addGap(37, 37, 37))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addGap(12, 12, 12)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 231, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(68, 68, 68))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
        int selectedValue = jComboBox1.getSelectedIndex();

        switch(selectedValue){
            case 0:
            addRowToJTable1();
            break;
            case 1:
            addRowToJTable2();
            break;
            case 2:
            addRowToJTable3();
            break;
            default:
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
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JEditorPane jEditorPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}

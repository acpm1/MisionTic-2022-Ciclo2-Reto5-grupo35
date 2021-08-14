package vista;

import java.util.ArrayList;

import controlador.ControladorRequerimientos;
import java.sql.SQLException;
import modelo.vo.Requerimiento_1Vo;
import modelo.vo.Requerimiento_2Vo;
import modelo.vo.Requerimiento_3Vo;

public class VistaRequerimientos {

    public static final ControladorRequerimientos controlador = new ControladorRequerimientos();

    public static void requerimiento1() {
        try {
                    
        ArrayList<Requerimiento_1Vo> mylist = controlador.consultarRequerimiento1();
        
        for (Requerimiento_1Vo dato: mylist){ 
            
            System.out.println(dato.getCiudad_Residencia()+" "+Math.round(dato.getPromedio()));
            
        }
            
            // Su código
        } catch (SQLException e) {
            System.out.println("Se ha producido el siguiente error:" + e.getMessage());
        }
    }

    public static void requerimiento2() {
        try {
            
        ArrayList<Requerimiento_2Vo> mylist = controlador.consultarRequerimiento2();      
        for (Requerimiento_2Vo dato: mylist){
            
        System.out.println(dato.getID_Proyecto()+" "+dato.getProveedor());
            
        }
            // Su código
        } catch (SQLException e) {
            System.out.println("Se ha producido el siguiente error:" + e.getMessage());
        }
    }

    public static void requerimiento3() {
        try {
        ArrayList<Requerimiento_3Vo> mylist = controlador.consultarRequerimiento3();   
        
        for (Requerimiento_3Vo dato: mylist){
           
        System.out.println(dato.getID_Proyecto()+" "+dato.getNombre_Material());
            // Su código
            
        }

        } catch (SQLException e) {
            System.out.println("Se ha producido el siguiente error:" + e.getMessage());
        }
    }

}

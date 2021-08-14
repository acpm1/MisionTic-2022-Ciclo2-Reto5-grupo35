package controlador;

import java.sql.SQLException;
import java.util.ArrayList;

import modelo.dao.Requerimiento_1Dao;
import modelo.dao.Requerimiento_2Dao;
import modelo.dao.Requerimiento_3Dao;
import modelo.vo.Requerimiento_1Vo;
import modelo.vo.Requerimiento_2Vo;
import modelo.vo.Requerimiento_3Vo;

public class ControladorRequerimientos {
    // Su código

    public ArrayList<Requerimiento_1Vo> consultarRequerimiento1() throws SQLException {
        
        Requerimiento_1Dao my_data = new Requerimiento_1Dao();
        ArrayList<Requerimiento_1Vo> mylist = my_data.requerimiento1();
        
        return mylist;
        // Su código
    }

    public ArrayList<Requerimiento_2Vo> consultarRequerimiento2() throws SQLException {
        // Su código
        Requerimiento_2Dao my_data = new Requerimiento_2Dao();
        ArrayList<Requerimiento_2Vo> mylist = my_data.requerimiento2();
        
        return mylist;

    }

    public ArrayList<Requerimiento_3Vo> consultarRequerimiento3() throws SQLException {
        // Su código
        Requerimiento_3Dao my_data = new Requerimiento_3Dao();
        ArrayList<Requerimiento_3Vo> mylist = my_data.requerimiento3();
        
        return mylist;
        
    }
}

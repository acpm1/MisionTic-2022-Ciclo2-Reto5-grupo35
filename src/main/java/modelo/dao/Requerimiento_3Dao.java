package modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import modelo.vo.Requerimiento_3Vo;
import util.JDBCUtilities;

public class Requerimiento_3Dao {
    public ArrayList<Requerimiento_3Vo> requerimiento3() throws SQLException {
        // Su código
        
        Connection c = null;
        
        try 
        {
            
            c = JDBCUtilities.getConnection();
            
        } catch (SQLException e) 
        {
        }
        
        String sql = "select Proyecto.ID_Proyecto, MaterialConstruccion.Nombre_Material FROM Proyecto INNER JOIN Compra ON Proyecto.ID_Proyecto = Compra.ID_Proyecto INNER JOIN MaterialConstruccion ON Compra.ID_MaterialConstruccion = MaterialConstruccion.ID_MaterialConstruccion WHERE (Proyecto.ID_Proyecto >= 20 and Proyecto.ID_Proyecto <=35) order by Proyecto.ID_Proyecto ASC";
        PreparedStatement p = null;       
        ResultSet r = null;
        
        ArrayList<Requerimiento_3Vo> mylist = new ArrayList<>();
        
        try 
        {
            p = c.prepareStatement(sql);
            p.clearParameters();
            
            r = p.executeQuery();
            
            int ID_Proyecto;
            String Nombre_Material;

                           
            while (r.next())
            {
                Requerimiento_3Vo this_row = new Requerimiento_3Vo();
                
                this_row.setID_Proyecto(r.getInt("ID_Proyecto"));
                this_row.setNombre_Material(r.getString("Nombre_Material"));

                
                mylist.add(this_row);              
//                System.err.println("id: "+ id +", area: "+ area);
            }
            
               
        } // try 
        catch (SQLException e) 
        {
        }
        
       return(mylist); 
                   
    }//requerimiento1
}
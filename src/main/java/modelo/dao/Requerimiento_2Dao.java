package modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import modelo.vo.Requerimiento_2Vo;
import util.JDBCUtilities;

public class Requerimiento_2Dao {
    public ArrayList<Requerimiento_2Vo> requerimiento2() throws SQLException {
        // Su código
        
        Connection c = null;
        
        try 
        {
            
            c = JDBCUtilities.getConnection();
            
        } catch (SQLException e) 
        {
        }
        
        String sql = "select Proyecto.ID_Proyecto,Compra.Proveedor FROM Proyecto INNER JOIN Compra ON Proyecto.ID_Proyecto = Compra.ID_Proyecto where Ciudad = 'Bogota' order by Proyecto.ID_Proyecto asc";
        PreparedStatement p = null;       
        ResultSet r = null;
        
        ArrayList<Requerimiento_2Vo> mylist = new ArrayList<>();
        
        try 
        {
            p = c.prepareStatement(sql);
            p.clearParameters();
            
            r = p.executeQuery();
            
            int ID_Proyecto;
            String Proveedor;
            
                           
            while (r.next())
            {
                Requerimiento_2Vo this_row = new Requerimiento_2Vo();
                
                this_row.setID_Proyecto(r.getInt("ID_Proyecto"));
                this_row.setProveedor(r.getString("Proveedor"));

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
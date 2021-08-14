package modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import modelo.vo.Requerimiento_1Vo;
import util.JDBCUtilities;

public class Requerimiento_1Dao {
    public ArrayList<Requerimiento_1Vo> requerimiento1() throws SQLException {
        // Su código
        
        Connection c = null;
        
        try 
        {
            
            c = JDBCUtilities.getConnection();
            
        } catch (SQLException e) 
        {
        }
        
        String sql = "SELECT Ciudad_Residencia, avg(Salario) AS Promedio FROM Lider GROUP BY Ciudad_Residencia HAVING Promedio < 500000 ORDER BY Promedio DESC";
        PreparedStatement p = null;       
        ResultSet r = null;
        
        ArrayList<Requerimiento_1Vo> mylist = new ArrayList<>();
        
        try 
        {
            p = c.prepareStatement(sql);
            p.clearParameters();
            
            r = p.executeQuery();
            
            double Promedio;
            String Ciudad_Residencia;

                           
            while (r.next())
            {
                Requerimiento_1Vo this_row = new Requerimiento_1Vo();
                
                this_row.setCiudad_Residencia(r.getString("Ciudad_Residencia"));
                this_row.setPromedio(r.getDouble("Promedio"));
                
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
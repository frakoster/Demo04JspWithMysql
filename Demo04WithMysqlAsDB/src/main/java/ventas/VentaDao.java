/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ventas;

import batch.Producto;
import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Persona;

/**
 *
 * @author franc
 */
public class VentaDao {

    public VentaDao() {
    }
    
    public int createVenta(ArrayList<Producto> listadoProductos){
        int rowsAffected = 0;
        int getNextIdVenta=getNextIdVenta();
        Connection conn = null;
        PreparedStatement ps = null;
        System.out.println("getCurrentIdVenta" + getCurrentIdVenta());
        createMainVenta(getCurrentIdVenta());
        
        
        String sql = "INSERT INTO detalle_venta (id_venta,producto,precio) VALUES (?,?,?)";
       
        try {
            conn= Conexion.getConnection();
            ps = conn.prepareStatement(sql);
            //ps.setInt(1, persona.getId());
            
            for(Producto producto:listadoProductos){
            ps.setInt(1, getCurrentIdVenta());
            ps.setString(2, producto.getNombre());
            ps.setInt(3, 2500);
             ps.executeUpdate();
            }
                     
            
        } catch (SQLException ex) {
            
        }
        
        
        return rowsAffected;
    }
    
      public int getCurrentIdVenta(){
        Connection conn = null;
        PreparedStatement ps = null;
        String sql = "SELECT * FROM secuencia_venta";
        
        int currentIdVenta=0;
        try {
            conn= Conexion.getConnection();
            ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
              currentIdVenta=rs.getInt("id_venta");
            }
         
        } catch (SQLException ex) {
            
        }
        return currentIdVenta;

    }
    
    public int getNextIdVenta(){
        int currentIdVenta=getCurrentIdVenta();
        int nextIdVenta= currentIdVenta + 1;
        Connection conn = null;
        PreparedStatement ps = null;
        String sql = "UPDATE secuencia_venta set id_venta=?";
       
        try {
            conn= Conexion.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, nextIdVenta);
            ps.executeUpdate();
        } catch (SQLException ex) {
           
        }
       return nextIdVenta;
    }
    
    public int createMainVenta(int idVenta){
        System.out.println("createMainVenta(), idventa="+idVenta);
        int rowsAffected = 0;
        
        Connection conn = null;
        PreparedStatement ps = null;
        String sql = "INSERT INTO lab01.app_main_venta (id_venta,fecha_venta,total_venta,tipo_venta) VALUES (?,CURRENT_TIMESTAMP(),?,?)";
       
        try {
            conn= Conexion.getConnection();
            ps = conn.prepareStatement(sql);
            //ps.setInt(1, persona.getId());
            ps.setInt(1, idVenta);
           // ps.setString(2, "CURRENT_TIMESTAMP()");
           ps.setInt(2, 10000);
            ps.setString(3, "web");
            ps.executeUpdate();
        } catch (SQLException ex) {
            
        }
        
        
        return rowsAffected;
        
    
    }
    
}

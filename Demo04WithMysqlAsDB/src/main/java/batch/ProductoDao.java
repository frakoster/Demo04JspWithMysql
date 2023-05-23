/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package batch;

import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Persona;
import modelo.PersonaDao;

public class ProductoDao {

    public void creaLote(List<Producto> productos) {
        
        Connection conn = null;
        PreparedStatement ps = null;
        String sql = "INSERT INTO producto (nombre,descripcion,lote) VALUES (?,?,?)";
        try {
            conn = Conexion.getConnection();
            ps = conn.prepareStatement(sql);
            
            for (Producto p : productos){
            //ps.setInt(1, persona.getId());
            ps.setString(1, p.getNombre());
            ps.setString(2, p.getDescripcion());
            ps.setString(3, p.getLote());
            ps.executeUpdate();
            }
            } catch (SQLException ex) {

        }

    }

    public Producto getProducto(int idProducto, String lote) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Producto p = null;
        conn = Conexion.getConnection();
        try {
            ps = conn.prepareStatement("SELECT * FROM producto WHERE id_producto=? and lote=?");
            ps.setInt(1, idProducto);
            ps.setString(2, lote);
            rs = ps.executeQuery();
            if (rs.next()) {
                int id = rs.getInt("id_producto");
                String nombre = rs.getString("nombre");
                String descripcion = rs.getString("descripcion");
                String loteProducto = rs.getString("lote");
                
                p = new Producto(id, nombre, descripcion, loteProducto);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PersonaDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Conexion.close(rs);
            Conexion.close(ps);
            Conexion.close(conn);
        }
      
        return p;
    }

    public int borrarProductoPorId(int idProducto) {
        Connection conn = null;
        PreparedStatement ps = null;
        String sql = "DELETE FROM producto WHERE id_producto = ?";
        int rowsUpdated=0;
        try {
            conn= Conexion.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, idProducto);
            rowsUpdated = ps.executeUpdate();
         
        } catch (SQLException ex) {
            
        }
        return rowsUpdated;
    }

    List<Producto> getAllProductos() {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Producto> listado = new ArrayList<>();

        conn = Conexion.getConnection();
        try {
            ps = conn.prepareStatement("SELECT * FROM producto");
            rs = ps.executeQuery();
            while (rs.next()) {
                int idProducto = rs.getInt("id_producto");
                String nombre = rs.getString("nombre");
                String descripcion = rs.getString("descripcion");
                String lote = rs.getString("lote");
               
                
                Producto producto = new Producto(idProducto, nombre, descripcion, lote);
                
                listado.add(producto);
            }
        } catch (SQLException ex) {
           
        } finally {
            Conexion.close(rs);
            Conexion.close(ps);
            Conexion.close(conn);
        }
        return listado;
    }

}

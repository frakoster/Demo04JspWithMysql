/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class UsuarioDao {

    public UsuarioDao() {
    }
    
    public boolean usuarioExiste(Usuario usuario){
        
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Persona> listado = new ArrayList<>();
        boolean isUser = false;
        conn = Conexion.getConnection();
        try {
            ps = conn.prepareStatement("SELECT * FROM usuario WHERE userName=? and password=?");
            ps.setString(1, usuario.getUserName());
            ps.setString(2, usuario.getPassword());
            rs = ps.executeQuery();
            if (rs.next()) {
              isUser = true;  
            }else {
                System.out.println("usuario no existe");
            }
        } catch (SQLException ex) {
            Logger.getLogger(PersonaDao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            Conexion.close(rs);
            Conexion.close(ps);
            Conexion.close(conn);
        }
    return isUser;
    }
    
}

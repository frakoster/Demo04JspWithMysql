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

public class PersonaDao {

    public PersonaDao() {

    }

    public List<Persona> getAllPersona() {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Persona> listado = new ArrayList<>();

        conn = Conexion.getConnection();
        try {
            ps = conn.prepareStatement("SELECT * FROM usuario ORDER BY apellido");
            rs = ps.executeQuery();
            while (rs.next()) {
                int idPersona = rs.getInt("id_usuario");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                String email = rs.getString("email");
                String numtel = rs.getString("telefono");
                String dni = rs.getString("dni");
                
                Persona p = new Persona(idPersona, nombre, apellido, email, numtel,dni);
                
                listado.add(p);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PersonaDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Conexion.close(rs);
            Conexion.close(ps);
            Conexion.close(conn);
        }
        return listado;
    }

    public int crearNuevaPersona(Persona persona) {
        System.out.println(persona.toString());
        
        Connection conn = null;
        PreparedStatement ps = null;
        String sql = "INSERT INTO usuario (nombre,apellido,email,telefono,dni) VALUES (?,?,?,?,?)";
        int rowsUpdated=0;
        try {
            conn= Conexion.getConnection();
            ps = conn.prepareStatement(sql);
            //ps.setInt(1, persona.getId());
            ps.setString(1, persona.getNombre());
            ps.setString(2, persona.getApellido());
            ps.setString(3, persona.getEmail());
            ps.setString(4, persona.getTelefono());
            ps.setString(5, persona.getDni());
            rowsUpdated = ps.executeUpdate();
        } catch (SQLException ex) {
            
        }
        return rowsUpdated;
    }

    public int eliminaPersona(int IdPersona)  {
        Connection conn = null;
        PreparedStatement ps = null;
        String sql = "DELETE FROM usuario WHERE id_usuario = ?";
        
        int rowsUpdated=0;
        try {
            conn= Conexion.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, IdPersona);
            rowsUpdated = ps.executeUpdate();
         
        } catch (SQLException ex) {
            
        }
        return rowsUpdated;
    }

    public int actualizaPersona(Persona p) {
        Connection conn = null;
        PreparedStatement ps = null;
        String sql = "UPDATE usuario set nombre=?,apellido=?,email=?,telefono=?,dni=? WHERE id_usuario = ?";
        
        int rowsUpdated=0;
        try {
            conn= Conexion.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, p.getNombre());
            ps.setString(2, p.getApellido());
            ps.setString(3, p.getEmail());
            ps.setString(4, p.getTelefono());
            ps.setString(5, p.getDni());
            ps.setInt(6, p.getId());
            rowsUpdated = ps.executeUpdate();
            
         
        } catch (SQLException ex) {
            
        }
        return rowsUpdated;
    }
    
    public Persona personaPorId(int idPersona){
        Connection conn = null;
        PreparedStatement ps = null;
        String sql = "SELECT * FROM usuario WHERE id_usuario = ?";
        Persona p = null;
        int rowsUpdated=0;
        try {
            conn= Conexion.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, idPersona);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
             p = new Persona(rs.getInt("id_usuario"),rs.getString("nombre"),rs.getString("apellido"),
                    rs.getString("email"),rs.getString("telefono"),rs.getString("dni"));
            
            }
         
        } catch (SQLException ex) {
            
        }
        return p;
    }
}

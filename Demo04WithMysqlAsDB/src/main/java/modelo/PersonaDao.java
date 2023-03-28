package modelo;

import config.Conexion;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
            ps = conn.prepareStatement("SELECT * FROM persona");
            rs = ps.executeQuery();
            while (rs.next()) {
                int idPersona = rs.getInt("id_persona");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                String email = rs.getString("email");
                String numtel = rs.getString("telefono");
                Persona p = new Persona(idPersona, nombre, apellido, email, numtel);
                listado.add(p);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PersonaDao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            Conexion.close(rs);
            Conexion.close(ps);
            Conexion.close(conn);
        }
        return listado;
    }
}

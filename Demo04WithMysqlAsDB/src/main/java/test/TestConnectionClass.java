package test;

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

public class TestConnectionClass {

    public static void main(String[] args) {

        TestConnectionClass t = new TestConnectionClass();
//        t.showAllContent();


    }

//    void showAllContent() {
//
//        PersonaDao dao = new PersonaDao();
//        List<Persona> listadoPersonas = dao.getAllPersona();
//        for (Persona p : listadoPersonas) {
//            System.out.println("test.TestConnectionClass.main()=" + p.getApellido());
//        }
//
//    }
}

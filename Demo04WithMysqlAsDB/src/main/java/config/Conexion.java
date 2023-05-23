package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Conexion {
    private static final String JDBC_URL = "jdbc:mysql://app.centos/lab01?autoReconnect=true&useSSL=false&";
    private static final String JDBC_USER = "farmijo";
    private static final String JDBC_PASSWD = "fa1400";

    public static Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWD);
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        } catch (ClassNotFoundException ex) {
        }
        return conn;
    }

    public static void close(ResultSet rs) {
        try {
            rs.close();
        } catch (SQLException ex) {

        }
    }

    public static void close(PreparedStatement ps) {
        try {
            ps.close();
        } catch (SQLException ex) {

        }
    }

    public static void close(Connection conn) {
        try {
            conn.close();
        } catch (SQLException ex) {

        }
    }
}

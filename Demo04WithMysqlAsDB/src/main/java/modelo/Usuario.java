
package modelo;

import java.util.Date;


public class Usuario {
    
    private int idUser;
    private String userName;
    private String password;
    private java.util.Date fecCreacion;

    public Usuario() {
    }

    public Usuario(int idUser, String userName, String password, Date fecCreacion) {
        this.idUser = idUser;
        this.userName = userName;
        this.password = password;
        this.fecCreacion = fecCreacion;
    }

    public Usuario(String userName, String password) {
        this.userName= userName;
        this.password = password;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getFecCreacion() {
        return fecCreacion;
    }

    public void setFecCreacion(Date fecCreacion) {
        this.fecCreacion = fecCreacion;
    }

    @Override
    public String toString() {
        return "Usuario{" + "idUser=" + idUser + ", userName=" + userName + ", password=" + password + ", fecCreacion=" + fecCreacion + '}';
    }
    
    
    
}

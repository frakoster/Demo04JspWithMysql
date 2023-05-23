/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package batch;

/**
 *
 * @author franc
 */
public class Producto {
    int idProducto;
    String nombre;
    String descripcion;
    String lote;

    public Producto() {
    }

    public Producto(String nombre, String descripcion, String lote) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.lote = lote;
    }
    
    public Producto(int idProducto, String nombre, String descripcion, String lote) {
        this.idProducto = idProducto;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.lote = lote;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getLote() {
        return lote;
    }

    public void setLote(String lote) {
        this.lote = lote;
    }

    @Override
    public String toString() {
        return "Producto{" + "idProducto=" + idProducto + ", nombre=" + nombre + ", descripcion=" + descripcion + ", lote=" + lote + '}';
    }
    
    
    
    
}

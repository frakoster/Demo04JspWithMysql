/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ventas;

import batch.Producto;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author franc
 */
public class Venta {
    
    int idVenta;
    Date fechaVenta;
    ArrayList<Producto>items=null;

    public Venta() {
    }

    
    public Venta(int idVenta, Date fechaVenta) {
        this.idVenta = idVenta;
        this.fechaVenta = fechaVenta;
    }

    public int getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    public Date getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(Date fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public ArrayList<Producto> getItems() {
        return items;
    }

    public void setItems(ArrayList<Producto> items) {
        this.items = items;
    }
    

    @Override
    public String toString() {
        return "Venta{" + "idVenta=" + idVenta + ", fechaVenta=" + fechaVenta + ", items=" + items + '}';
    }
    
    
}

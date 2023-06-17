/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package batch;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author franc
 */
public class testProducto {
    public static void main(String[] args) {
            ProductoDao pdao = new ProductoDao();
            List<Producto> productos = new ArrayList<>();
            
            for(int i=1;i<=10000;i++){
            Producto producto = new Producto( "silla", "silla de escritorio", "L100");
            productos.add(producto);
            }
         
            
            
            
            
//            producto = new Producto("silla", "silla de escritorio", "L100");
//            productos.add(producto);
//            producto = new Producto( "silla", "silla de escritorio", "L100");
//            productos.add(producto);
//            producto = new Producto( "silla", "silla de escritorio", "L100");
//            productos.add(producto);
//            producto = new Producto( "silla", "silla de escritorio", "L100");
//            productos.add(producto);
            
           
            
            
            
    }
}

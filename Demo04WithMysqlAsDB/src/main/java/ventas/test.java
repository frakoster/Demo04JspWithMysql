/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ventas;

import batch.Producto;
import batch.ProductoDao;
import java.util.ArrayList;

/**
 *
 * @author franc
 */
public class test {
    
    public static void main(String[] args) {
        VentaDao vdao= new VentaDao();
        //System.out.println(vdao.getCurrentIdVenta());
        //System.out.println(vdao.getNextIdVenta());
        
//        ArrayList<Producto> listadoProductos = new ArrayList<>();
//        Producto p = new Producto("test", "test", "test");
//        listadoProductos.add(p);
//         p = new Producto("test", "test", "test");
//        listadoProductos.add(p);
//         p = new Producto("test", "test", "test");
//        listadoProductos.add(p);
//         p = new Producto("test", "test", "test");
//        listadoProductos.add(p);
//                 p = new Producto("test", "test", "test");
//        listadoProductos.add(p);
//         p = new Producto("test", "test", "test");
//        listadoProductos.add(p);
//         p = new Producto("test", "test", "test");
//        listadoProductos.add(p);
//                 p = new Producto("test", "test", "test");
//        listadoProductos.add(p);
//         p = new Producto("test", "test", "test");
//        listadoProductos.add(p);
//         p = new Producto("test", "test", "test");
//        listadoProductos.add(p);
//                 p = new Producto("test", "test", "test");
//        listadoProductos.add(p);
//                 p = new Producto("test", "test", "test");
//        listadoProductos.add(p);
//         p = new Producto("test", "test", "test");
//        listadoProductos.add(p);
//         p = new Producto("test", "test", "test");
//        listadoProductos.add(p);
//                 p = new Producto("test", "test", "test");
//        listadoProductos.add(p);
//         p = new Producto("test", "test", "test");
//        listadoProductos.add(p);
//         p = new Producto("test", "test", "test");
//        listadoProductos.add(p);
//        
//        vdao.createVenta(listadoProductos);
        ProductoDao pdao = new ProductoDao();
          for ( Producto p : pdao.getAllProductosFromMain()){
                System.out.println(p.toString());
            
            }
        
        
        
    }
    
    
    
    
}

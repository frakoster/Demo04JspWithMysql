/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package batch;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.Persona;
import modelo.PersonaDao;

/**
 *
 * @author franc
 */
public class ControladorProducto extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ControladorProducto</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ControladorProducto at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // processRequest(request, response);
        RequestDispatcher rd = null;
        String accion = request.getParameter("accion");
        ProductoDao dao = null;
        HttpSession session = request.getSession();
        switch (accion) {
            case "borrarProducto":
                int idProducto = Integer.parseInt(request.getParameter("idProducto"));
                ProductoDao pdao = new ProductoDao();
                int rowsAffected = pdao.borrarProductoPorId(idProducto);
                response.sendRedirect("productos/dashProductos.jsp");
                break;
            case "listarProductos":
                dao = new ProductoDao();
                List<Producto> listadoProductos = dao.getAllProductos();
                request.setAttribute("listadoProductos", listadoProductos);
                rd = request.getRequestDispatcher("productos/listarProductos.jsp");
                rd.forward(request, response);

                break;
            case "venta":
                 List<Producto>listadoProducto = (List<Producto>) session.getAttribute("listadoProducto");
                 dao = new ProductoDao();
                 listadoProducto = dao.getAllProductosFromMain();

                for (Producto p : listadoProducto) {
                    System.out.println(p.toString());

                }

                request.setAttribute("listadoProducto", listadoProducto);
                rd = request.getRequestDispatcher("productos/ventas.jsp");
                rd.forward(request, response);

                break;

        }

    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // processRequest(request, response); 
        String accion = request.getParameter("accion");
        Producto producto = null;
        HttpSession session = request.getSession();
        List<Producto>listadoProducto = (List<Producto>) session.getAttribute("listadoProducto");
        List<Producto>misProductos = (List<Producto>) session.getAttribute("misProductos");
        switch (accion) {
            case "crearProducto":
                List<Producto> productos = new ArrayList<>();
                ProductoDao pdao = new ProductoDao();
                int cantidad = Integer.parseInt(request.getParameter("cantidadProductos"));
                String nombreProducto = request.getParameter("nombreProducto");
                String loteProducto = request.getParameter("loteProducto");
                String detalleProducto = request.getParameter("detalleProducto");
                System.out.println(cantidad + "," + nombreProducto + "," + loteProducto + "," + detalleProducto);
                response.sendRedirect("productos/dashProductos.jsp");
                for (int i = 1; i <= cantidad; i++) {
                    Producto p = new Producto(nombreProducto, detalleProducto, loteProducto);
                    productos.add(p);
                }
                pdao.creaLote(productos);
                break;
            case "eliminarProducto":
                RequestDispatcher rd = null;
                pdao = new ProductoDao();
                int idProducto = Integer.parseInt(request.getParameter("idProducto"));
                String lote = request.getParameter("lote");
                producto = new Producto();
                producto = pdao.getProducto(idProducto, lote);
                System.out.println(producto.toString());
                request.setAttribute("producto", producto);
                rd = request.getRequestDispatcher("productos/eliminar_producto.jsp");
                rd.forward(request, response);
                break;
            case "getProductoById":
                listadoProducto = (List<Producto>) session.getAttribute("listadoProducto");
                int id = Integer.parseInt(request.getParameter("id"));
                ProductoDao dao = new ProductoDao();
                listadoProducto = dao.getAllProductosFromMain();
                for (Producto p : listadoProducto) {
                    System.out.println(p.toString());
                }
                request.setAttribute("listadoProducto", listadoProducto);

                producto = dao.getProductoById(id);

                System.out.println(producto.toString());
                request.setAttribute("producto", producto);
                
                rd = request.getRequestDispatcher("productos/ventas.jsp");
                rd.forward(request, response);

                break;

            case "agregarProducto":
                listadoProducto = (List<Producto>) session.getAttribute("listadoProducto");
                dao = new ProductoDao();
                listadoProducto = dao.getAllProductosFromMain();
                request.setAttribute("listadoProducto", listadoProducto);
                System.out.println("agregarProducto()");
                int idP = Integer.parseInt(request.getParameter("idProducto"));
                System.out.println("agregarProducto()" + idP);
                
               
               
                if (session.getAttribute("misProductos") == null) {
                    misProductos=new ArrayList<>();
                        session.setAttribute("misProductos",misProductos );
                }
                
                 //idProducto = Integer.parseInt(request.getParameter("idProducto"));
                 ProductoDao pdao1 = new ProductoDao();
                 Producto p =  pdao1.getProductoById(idP);
                 System.out.println("p.toString()" + p.toString());
                 misProductos.add(p);
                rd = request.getRequestDispatcher("productos/ventas.jsp");
                rd.forward(request, response);
                break;

        }

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

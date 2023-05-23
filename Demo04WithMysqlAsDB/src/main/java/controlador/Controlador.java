
package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Persona;
import modelo.PersonaDao;
import modelo.Usuario;
import modelo.UsuarioDao;

/**
 *
 * @author farmijo
 */
public class Controlador extends HttpServlet {

    RequestDispatcher rd = null;

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
            out.println("<title>Servlet Controlador</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Controlador at " + request.getContextPath() + "</h1>");
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
        //processRequest(request, response);
        String accion = request.getParameter("accion");
        System.out.println("accion:" + accion);

        switch (accion) {
            case "listarUsuarios":
                PersonaDao dao = new PersonaDao();
                List<Persona> listadoPersonas = dao.getAllPersona();
                request.setAttribute("listadoPersonas", listadoPersonas);
                rd = request.getRequestDispatcher("vista/listadoUsuarios.jsp");
                rd.forward(request, response);
                break;
            case "eliminarUsuario":
                int idUsuario = Integer.parseInt(request.getParameter("idUser"));
                System.out.println("idUser="+idUsuario + ",accion="+ accion);
                PersonaDao pdao = new PersonaDao();
                int rowsUpdated=pdao.eliminaPersona(idUsuario);
                System.out.println("rowsUpdated="+rowsUpdated);
                
                listadoPersonas = pdao.getAllPersona();
                request.setAttribute("listadoPersonas", listadoPersonas);
                rd = request.getRequestDispatcher("vista/listadoUsuarios.jsp");
                rd.forward(request, response);
                break;
            case "editarUsuario":
                idUsuario = Integer.parseInt(request.getParameter("idUser"));
                System.out.println("idUser="+idUsuario + ",accion="+ accion);
                pdao = new PersonaDao();
                Persona per = pdao.personaPorId(idUsuario);
               // System.out.println("Persona" + per.toString());
                
                int idUser = per.getId();
                String nombre = per.getNombre();
                String apellido = per.getApellido();
                String email = per.getEmail();
                String telefono = per.getTelefono();
                String dni = per.getDni();
                
                request.setAttribute("id", idUser);
                request.setAttribute("nombre", nombre);
                request.setAttribute("apellido", apellido);
                request.setAttribute("email", email);
                request.setAttribute("telefono", telefono);
                request.setAttribute("dni", dni);
                
                listadoPersonas = pdao.getAllPersona();
                request.setAttribute("listadoPersonas", listadoPersonas);
                rd = request.getRequestDispatcher("vista/editarUsuarios.jsp");
                rd.forward(request, response);
                break;
            case "logout":
                response.sendRedirect("index.jsp");
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
        String accion = request.getParameter("accion");
        
        switch (accion) {

            case "logIn":
                System.out.println("entrando al metodo post");
                String userName = request.getParameter("username");
                String password = request.getParameter("password");
                System.out.println(userName + "/" + password);
                Usuario user = new Usuario(userName, password);
                UsuarioDao udao = new UsuarioDao();
                boolean isUser = udao.usuarioExiste(user);
                System.out.println("isUser():" + isUser);
                if (isUser) {
                    rd = request.getRequestDispatcher("vista/dashboard.jsp");
                    rd.forward(request, response);
                } else {
                    response.sendRedirect("logIn.jsp");
                }
                break;
            case "crearUsuario":
                System.out.println("accion=" + accion);
                
                String nombre = request.getParameter("nombre");
                String apellido = request.getParameter("apellido");
                String email = request.getParameter("email");
                String telefono = request.getParameter("telefono");
                String dni = request.getParameter("dni");
                
                Persona p = new Persona(nombre, apellido, email, telefono,dni);
                System.out.println("Persona="+ p.toString());
                PersonaDao pdao = new PersonaDao();
                int rowsUpdated =  pdao.crearNuevaPersona(p);
                System.out.println("rowsUpdated="+rowsUpdated);
                //actualizando todo 
                 PersonaDao dao = new PersonaDao();
                List<Persona> listadoPersonas = dao.getAllPersona();
                request.setAttribute("listadoPersonas", listadoPersonas);
                rd = request.getRequestDispatcher("vista/listadoUsuarios.jsp");
                rd.forward(request, response);
                
                break;
                
            case "actualizarUsuario":
                 int idUser = Integer.parseInt(request.getParameter("idUsuario"));
                 System.out.println("idUser="+idUser);
                 
                 nombre = request.getParameter("nombre");
                 apellido = request.getParameter("apellido");
                 email = request.getParameter("email");
                 telefono = request.getParameter("telefono");
                 dni = request.getParameter("dni");
                 p = new Persona(idUser, nombre, apellido, email, telefono,dni);
                 System.out.println(p.toString());
                 pdao = new PersonaDao();
                 int updatedRows = pdao.actualizaPersona(p);
                 
                    //actualizando todo 
                dao = new PersonaDao();
                listadoPersonas = dao.getAllPersona();
                request.setAttribute("listadoPersonas", listadoPersonas);
                rd = request.getRequestDispatcher("vista/listadoUsuarios.jsp");
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

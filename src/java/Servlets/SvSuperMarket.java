/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import Servlets.DatabaseConnection;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lazar
 */
@WebServlet(name = "SvSuperMarket", urlPatterns = {"/SvSuperMarket"})
public class SvSuperMarket extends HttpServlet {

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
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet SvSuperMarket</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SvSuperMarket at " + request.getContextPath() + "</h1>");
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
        List<Producto> listaProductos = new ArrayList<> ();
        String query = "SELECT * FROM supermarket.alimentoperecedero " +
                        "UNION ALL " +
                        "SELECT * FROM supermarket.alimentonoperecedero " +
                        "UNION All " +
                        "SELECT * FROM supermarket.otrascategorias " +
                        "ORDER BY tipo";
        
        Statement st = null;
        ResultSet rs = null;
        
        try {
            Connection conn = DatabaseConnection.initializeDatabase();
            st = conn.createStatement();
            rs = st.executeQuery(query);

            while(rs.next()) {
                String tipo = rs.getString(2);
                String nombre = rs.getString(3);
                int costo = rs.getInt(4);
                int venta = rs.getInt(5);
                int stock = rs.getInt(6);
                
                listaProductos.add(new Producto(tipo, nombre, costo, venta, stock));
            }
            HttpSession mysession = request.getSession();
            mysession.setAttribute("listaProductos", listaProductos);
            response.sendRedirect("products.jsp");
            rs.close();
            conn.close();
            
        } catch (Exception e) {
            e.printStackTrace();
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
        
        String type = request.getParameter("tipoComida");
        String table = "supermarket.alimentoperecedero";
        
        if(type.equals("arroz")|| type.equals("fideos") || type.equals("enlatados") || type.equals("legumbres") || type.equals("frutos secos y deshidratados") ){
                table = "supermarket.alimentonoperecedero";
            } else if (type.equals("limpieza") || type.equals("bazar") || type.equals("cuidado personal") || type.equals("otros")) {
                table = "supermarket.otrascategorias";
            }
        
        String url = "INSERT INTO " + table + " (tipo, nombre, precioCosto, precioVenta, stock) VALUES (?,?,?,?,?)";
        try {
            
            Connection con = DatabaseConnection.initializeDatabase();

            PreparedStatement st = con.prepareStatement(url);
            
            st.setString(1, request.getParameter("tipoComida"));
            st.setString(2, request.getParameter("nombre"));
            st.setString(3, request.getParameter("precioCosto"));
            st.setString(4, request.getParameter("precioVenta"));
            st.setString(5, request.getParameter("stock"));
            
            st.executeUpdate();
            
            st.close();
            con.close();
            
            response.sendRedirect("Success.jsp");
            
            
        } catch (Exception e) {
            e.printStackTrace();
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

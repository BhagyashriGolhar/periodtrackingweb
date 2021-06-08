/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

/**
 *
 * @author Shree
 */
public class olduser extends HttpServlet {

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
            String user=request.getParameter("userid");
            String pass=request.getParameter("passw");
            
            Connection conn=null;
            ResultSet rs=null;
            PreparedStatement ps=null;
            Statement stmt;
            int flag=0;
             //conn=dbconnection.connect();
             try
            {
                 
                  Class.forName("com.mysql.jdbc.Driver");/*creates driver class object registered 
                                                   with drivermanger service automatically*/
            conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/periodtracking?","root","");
           
                stmt=conn.createStatement();
                rs=stmt.executeQuery("select * from users");
                while(rs.next())
            {
                String u=rs.getString(3);
                String p=rs.getString(4);
                
                if(user.equals(u)&&pass.equals(p))
                {   
                    
                    flag=1;
                    response.sendRedirect("dashboard.html");
                            
                }
                
            }
            if(flag==0)
            {
               response.sendRedirect("login.html");
            }
            }
             catch(Exception e)
             {
             }
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
        processRequest(request, response);
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
        processRequest(request, response);
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

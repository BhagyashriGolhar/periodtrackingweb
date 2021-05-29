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
             conn=dbconnection.connect();
             try
            {
                stmt=conn.createStatement();
                rs=stmt.executeQuery("select * from users");
                while(rs.next())
            {
                String u=rs.getString(3);
                String p=rs.getString(4);
                
                if(user.equals(u)&&pass.equals(p))
                {   
                    
                    flag=1;
                    out.write("<!DOCTYPE html>\n" +
"<html>\n" +
"<head>\n" +
"<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n" +
"<link rel=\"stylesheet\" href=\"web/dashboardcss.css\">\n" +
"</head>\n" +
"<body>\n" +
"    \n" +
" <div class=\"sidebar\">\n" +
"  <a class=\"active\" href=\"#home\">Home</a>\n" +
"  <a href=\"#exercise\">Exercise</a>\n" +
"  <a href=\"#food\">Food</a>\n" +
"  <a href=\"#date\">check date</a>\n" +
"  <a href=\"#cleanness\">maintain cleanness</a>\n" +
"  <a href=\"#logout\">Logout</a>\n" +
"  \n" +
"  \n" +
"  \n" +
"</div>\n" +
"\n" +
"<div class=\"content\">\n" +
"    <img src=\"home.jpg\"  width=\"420\" height=\"300\">\n" +
"  <img src=\"exercise.jpg\"  width=\"420\" height=\"300\">\n" +
"  <img src=\"food.jpg\"  width=\"420\" height=\"300\">\n" +
"    <img src=\"date.png\"  width=\"420\" height=\"300\">\n" +
"<img src=\"cleanness.jpg\"  width=\"420\" height=\"300\">\n" +
"<img src=\"logout.png\"  width=\"420\" height=\"300\">\n" +
"  </div>\n" +
"   \n" +
"</body>\n" +
"</html> \n" +
"");
                            
                }
                
            }
            if(flag==0)
            {
               // JOptionPane.showMessageDialog("Enter correct usename password");
               out.print("<!DOCTYPE html>\n" +
"<!--\n" +
"To change this license header, choose License Headers in Project Properties.\n" +
"To change this template file, choose Tools | Templates\n" +
"and open the template in the editor.\n" +
"-->\n" +
"<html>\n" +
"    <head>\n" +
"        <title>welcome</title>\n" +
"\n" +
"        <meta charset=\"UTF-8\">\n" +
"        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
"        <link rel=\"stylesheet\" href=\"web/logincss.css\">\n" +
"        \n" +
"    </head>\n" +
"    <body>\n" +
"      <!--  <main id=\"main-holder\">-->\n" +
"\n" +
"            <form name=\"form1\"  class=\"signup-form\">\n" +
"                <div class=\"form-body\" >\n" +
"\n" +
"                    <div class=\"form-group1\">\n" +
"                        <h1 id=\"login-header\">Login</h1>\n" +
"                    </div>\n" +
"                    <div class=\"form-group\">\n" +
"                        <label for=\"username\" class=\"label-title\">Username(Email)</label>\n" +
"                        <input type=\"text\" name=\"userid\" class=\"form-input\" id=\"username-field\" placeholder=\"Enter username\">\n" +
"                    </div>\n" +
"\n" +
"                    <div class=\"form-group\">\n" +
"                        <label for=\"password\" class=\"label-title\">Password</label>\n" +
"                        <input type=\"password\" name=\"passw\" class=\"form-input\" id=\"password-field\" placeholder=\"Enter password\">\n" +
"                    </div>\n" +
"\n" +
"\n" +
"                    <input type=\"submit\" value=\"Login\" id=\"login-form-submit\" formaction=\"src/java/olduser.java\" >\n" +
"               \n" +
"\n" +
"               \n" +
"                <p>Don't have an account,<a href=\"web/registration.html\">click here</a></p>\n" +
"                    \n" +
"                    \n" +
"                     </div>\n" +
"            </form>\n" +
"        <!--</main>-->\n" +
"\n" +
"    </body>\n" +
"</html>\n" +
"");
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

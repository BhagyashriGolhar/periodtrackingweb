/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Shree
 */
public class registerusers extends HttpServlet {

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
            String fname=request.getParameter("firstname");
            String lname=request.getParameter("lastname");
            String email=request.getParameter("email");
            String pass1=request.getParameter("password_1");
            String pass2=request.getParameter("password_2");
            String mob=request.getParameter("mobnum");
            
            Connection conn=null;
            ResultSet rs=null;
            PreparedStatement ps=null;
            Statement stmt;
             conn=dbconnection.connect();
            
            try
            {
                stmt=conn.createStatement();
                stmt.executeUpdate("insert into users (firstname,lastname,email,password1,password2,mobnum)"
                        + "values('"+fname+"','"+lname+"','"+email+"','"+pass1+"','"+pass2+"','"+mob+"')");
                     out.write("<!DOCTYPE html>\n" +
"<!--\n" +
"To change this license header, choose License Headers in Project Properties.\n" +
"To change this template file, choose Tools | Templates\n" +
"and open the template in the editor.\n" +
"-->\n" +
"<html>\n" +
"    <head>\n" +
"        <title>welcome</title>\n" +
"        \n" +
"        <meta charset=\"UTF-8\">\n" +
"        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
"        <link rel=\"stylesheet\" href=\"logincss.css\">\n" +
"        <script type=\"text/javascript\" src =\"loginjs.js\"></script>\n" +
"    </head>\n" +
"    <body>\n" +
"        <main id=\"main-holder\">\n" +
"            \n" +
"        <form name=\"form1\" id=\"login-form\">\n" +
"            <div class=\"form-body\">\n" +
"              \n" +
"            <div class=\"form-group1\">\n" +
"                <h1 id=\"login-header\">Login</h1>\n" +
"            </div>\n" +
"            <div class=\"form-group\">\n" +
"            <label for=\"username\" class=\"label-title\">Username(Email)</label>\n" +
"            <input type=\"text\" name=\"userid\" class=\"form-input\" id=\"username-field\" placeholder=\"Enter username\">\n" +
"            </div>\n" +
"            \n" +
"            <div class=\"form-group\">\n" +
"            <label for=\"password\" class=\"label-title\">Password</label>\n" +
"            <input type=\"password\" name=\"passw\" class=\"form-input\" id=\"password-field\" placeholder=\"Enter password\">\n" +
"            </div>\n" +
"            \n" +
"            <input type=\"submit\" value=\"Login\" id=\"login-form-submit\" formaction=\"olduser\" >\n" +
"            </div>\n" +
"            \n" +
"            <p>Don't have an account,<a href=\"registration.html\">click here</a></p>\n" +
"        </form>\n" +
"        </main>\n" +
"    </body>\n" +
"</html>\n" +
"");
              
                     
                     
                     
                     
                     
                     
                     /*  out.write("<html> ");
                 out.write("<head> ");
                 out.print("<link href='index.html'/>");
                 out.print("<style> html\n" +
"{\n" +
"  height: 100%;  \n" +
"}\n" +
"\n" +
"body\n" +
"{\n" +
"     background: linear-gradient(to right, #78a7ba 0%, #385d6c 50%, #78a7ba 99%);\n" +
"    height :100%;\n" +
"    margin: 0;\n" +
"    font-family: Arial,Helvetica,sans-serif;\n" +
"    display: grid;\n" +
"    justify-items: center;\n" +
"    align-items: center;\n" +

"}\n" +
"   #login-button { width: 100%;\n" +
"    padding: 10px;\n" +
"    border: none;\n" +
"    border-radius: 7px;\n" +
"    color: white;\n" +
"    font-weight: bold;\n" +
     "font-size: 30px;\n" +
"    background-color:  #1bba93;\n" +
"    cursor: pointer;\n" +
"    outline: none; } #login-form\n" +
"{\n" +
"    align-self: flex-start;\n" +
"    display: grid;\n" +
"    justify-items: center;\n" +
"    align-items: center;\n" +
"} .form-body {\n" +
"    padding: 10px 40px;\n" +
"    color: #666;\n" +
"}  #main-holder\n" +
"{\n" +
"    width: 40%;\n" +
"    height: 60%;\n" +
"    display: grid;\n" +
"    justify-items: center;\n" +
"    background-color: white;\n" +
"    border-radius: 7px;\n" +
"    box-shadow: 0px 0px 5px 5px black;\n" +
"}</style>  <body>  <main id=\"main-holder\"> <form action='index.html' id=login-form> <div class=\"form-body\">  <img src='welcome.jpg' width='340' height='200'> </br></br></br></br><input type='submit' value='Click to Login' id='login-button'> </div> </form> </main></body>");
                   out.write (" </head>");
                   out.write(" </html>");*/
             
             
            
             
            }
            catch(SQLException e)
            {
                out.print(e);
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

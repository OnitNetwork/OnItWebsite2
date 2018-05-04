package com.onitbc;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URI;
import java.net.URISyntaxException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Cookie;
import java.sql.*;

@WebServlet(name = "dashboardHandler", urlPatterns = {"/dashboard"})
public class dashboardHandler extends HttpServlet {

    private static Connection getConnection() throws URISyntaxException, SQLException {
        URI dbUri = new URI(System.getenv("DATABASE_URL"));

        String username = dbUri.getUserInfo().split(":")[0];
        String password = dbUri.getUserInfo().split(":")[1];
        String dbUrl = "jdbc:postgresql://" + dbUri.getHost() + dbUri.getPath();

        return DriverManager.getConnection(dbUrl, username, password);
    }

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
    }

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

        Cookie cookie[] = request.getCookies();

        if (cookie != null) {
            String privateKey = cookie[0].getValue();
                    
            request.setAttribute("privateKey", privateKey);
            
            if (!privateKey.equals("") || privateKey != null) {
                PrintWriter pw = response.getWriter();

                try {
                    Connection conn = getConnection();
                    
                    Statement st = conn.createStatement();
                    ResultSet rs = st.executeQuery("select pubaddr from users where prikey=" + "'" + privateKey + "';");
                    rs.close();
                    
                    while (rs.next()) {
                        String pA = rs.getString(1);
                        rs.close();
                        request.setAttribute("publicAddress", pA);
                    }
                    
                    rs = st.executeQuery("select balance from users where prikey=" + "'" + privateKey + "';");
                    
                    while (rs.next()) {
                        double bal = rs.getDouble(1);
                        rs.close();
                        request.setAttribute("balance", bal);
                    }
                    
                    rs = st.executeQuery("select pubkey from users where prikey=" + "'" + privateKey + "';");
                    
                    while (rs.next()) {
                        String publicKey = rs.getString(1);
                        rs.close();
                        request.setAttribute("publicKey", publicKey);
                    }
                    
                    st.close();                   
                } 
                catch (Exception e) {
                    pw.println(e);
                }
            } else {
                response.sendRedirect("login");
            }
        }

        getServletConfig().getServletContext().getRequestDispatcher(
                "/Dashboard.jsp").forward(request, response);
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
    }

}

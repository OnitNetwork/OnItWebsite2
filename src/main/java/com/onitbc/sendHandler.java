package com.onitbc;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "sendHandler", urlPatterns = {"/send"})
public class sendHandler extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
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
        String privateKey = cookie[0].getValue();
        
        PrintWriter pw = response.getWriter();

        try {
            Connection conn = getConnection();

            Statement st = conn.createStatement();

            ResultSet rs = st.executeQuery("select balance from users where prikey=" + "'" + privateKey + "';");

            while (rs.next()) {
                double bal = rs.getDouble(1);
                request.setAttribute("balance", bal);
            }
            rs.close();
            st.close();
        } catch (Exception e) {
            pw.println(e);
        }

        getServletConfig().getServletContext().getRequestDispatcher(
                "/Send.jsp").forward(request, response);
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

        PrintWriter out = response.getWriter();
        
        Cookie cookie[] = request.getCookies();
        String privateKey = cookie[0].getValue();

        double sendAmount = Double.parseDouble(request.getParameter("sendAmount"));
        double balance = Double.parseDouble(request.getParameter("balance"));
        String sendAddr = request.getParameter("sendAddress");
        double recipientBalance = 0;

        if (balance - sendAmount < 0) {
            response.setContentType("text/html");
            out.println("<script type=\"text/javascript\">");
            out.println("alert('Gotta send at least as much as you have, guy');");
            out.println("</script>");
        } else {            
            try {
                Connection conn = getConnection();
                Statement st = conn.createStatement();                                

                ResultSet rs = st.executeQuery("select pubaddr from users where pubaddr=" + "'" + sendAddr + "';");
                
                if (rs.next()) {
                    rs = st.executeQuery("select balance from users where pubaddr=" + "'" + sendAddr + "';");
                    while (rs.next()) {
                        recipientBalance += rs.getDouble(1);
                    }
                    
                    double senderFinalBalance = balance - sendAmount;
                    double recipientFinalBalance = recipientBalance + sendAmount;
                    
                    st.executeUpdate("update users set balance = " + senderFinalBalance + " where pubaddr = '" + sendAddr + "';");
                    st.executeUpdate("update users set balance = " + recipientFinalBalance + " where pubaddr = '" + privateKey + "';");
                    response.sendRedirect("dashboard");
                    
                } else {
                    response.setContentType("text/html");
                    out.println("<script type=\"text/javascript\">");
                    out.println("alert('That address doesn't exist);");
                    out.println("</script>");
                }

            } catch (Exception e) {
                out.println(e);
            }
        }

    }

}

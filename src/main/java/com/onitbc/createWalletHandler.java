package com.onitbc;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.security.*;
import java.security.spec.ECGenParameterSpec;

import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.util.encoders.Base64;


import java.net.URI;
import java.net.URISyntaxException;
import java.sql.*;

@WebServlet(name = "createWalletHandler", urlPatterns = {"/createWallet"})
public class createWalletHandler extends HttpServlet {

    
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
     * @param s
     * @param request servlet request
     * @param response servlet response
     * @return 
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */       
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
        KeyGen.generateKeyPair();
        String puKey = new String(Base64.encode(KeyGen.publicKey.getEncoded()));
        String prKey = new String(Base64.encode(KeyGen.privateKey.getEncoded()));
        String puAdd = HashGen.translate(new String(Base64.encode(KeyGen.publicKey.getEncoded())));
        
        request.setAttribute("pukey", puKey);        
        request.setAttribute("prkey", prKey);
        request.setAttribute("pudd", puAdd);
        getServletConfig().getServletContext().getRequestDispatcher(
                "/CreateWallet.jsp").forward(request,response);
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
        
        response.setContentType("text/html");  
        PrintWriter pw = response.getWriter();
        
        PreparedStatement preparedStatement = null;       
        
        try {            
            String publicKey = request.getParameter("publicKey");
            String privateKey = request.getParameter("privateKey");
            String publicAddress = request.getParameter("publicAddress");
            double balance = 100.00;
            
            String sql ="insert into users (prikey, pubkey, pubaddr, balance) "
                    + "values (\'" + privateKey + "\', \'" + publicKey
                    + "\', \'" + publicAddress +"\', \'" + balance + "\')";
            
            Connection conn = getConnection();
            preparedStatement = conn.prepareStatement(sql);
            
            preparedStatement.setString(1, publicKey);
            preparedStatement.setString(2, privateKey);
            preparedStatement.setString(3, publicAddress);
            preparedStatement.setDouble(4, balance);
            
            int i = preparedStatement.executeUpdate();
            String msg = " ";
            if ( i != 0) {
                msg = "Record has been inserted";
                pw.println("<font size='6' color=white>" + msg + "</font>");
            } else {
                msg = "failed to insert data";
                pw.println("<font size='6' color=white>" + msg + "</font>");
            }
            preparedStatement.close();
        }
        catch (Exception e) {
            pw.println(e);
        }
        response.sendRedirect("transaction.jsp");
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

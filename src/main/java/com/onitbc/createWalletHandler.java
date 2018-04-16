/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
/**
 *
 * @author bryce
 */
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
    
    public String getKeyPair() {
        KeyGen.generateKeyPair();
        String puKey = new String(Base64.encode(KeyGen.publicKey.getEncoded()));
        String prKey = new String(Base64.encode(KeyGen.privateKey.getEncoded()));
        String puAdd = HashGen.translate(new String(Base64.encode(KeyGen.publicKey.getEncoded())));
        
        String keys = "<p style=\"margin: -5px auto -10px auto;\">Public:</p><br>\n"
                + "<p style=\"word-wrap: break-word; font-size: 15px;\">" 
                + puKey
                + "</p><br><br>\n"
                + "<p style=\"margin: -10px auto -10px auto;\">Private:</p><br>\n"
                + "<p style=\"word-wrap: break-word; font-size: 15px;\">"
                + prKey
                + "</p><br><br>\n"
                + "<input type=\"hidden\" name=\"publicKey\" value=\""
                + puKey + "\">\n"
                + "<input type=\"hidden\" name=\"privateKey\" value=\""
                + prKey + "\">\n"
                + "<input type=\"hidden\" name=\"publicAddress\" value=\""
                + puAdd + "\">\n";
        return keys;
    }    
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
        request.setAttribute("display data", getKeyPair());
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

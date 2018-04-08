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

/**
 *
 * @author bryce
 */
@WebServlet(name = "createWalletHandler", urlPatterns = {"/createWalletHandler"})
public class createWalletHandler extends HttpServlet {

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
        
        String keys = "<p style=\"margin: -5px auto -10px auto;\">Public:</p><br>"
                + "<label><p style=\"word-wrap: break-word; font-size: 15px;\">" 
                + new String(Base64.encode(KeyGen.publicKey.getEncoded())) 
                + "</p></label><br><br>"
                + "<p style=\"margin: -10px auto -10px auto;\">Private:</p><br>"
                + "<label><p style=\"word-wrap: break-word; font-size: 15px;\">"
                + new String(Base64.encode(KeyGen.privateKey.getEncoded()))
                + "</p></label><br><br>";
        return keys;
    }    
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>OnIt - Create New Wallet</title>");
            out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"css/style.css\">");
            out.println("<meta charset=\"UTF-8\">");
            out.println("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">");
            out.println("<link rel=\"shortcut icon\" type=\"image/png\" href=\"img/favicon.ico\"/>");
            out.println("</head>");
            out.println("<body>");

            out.println("<div class=\"login-box\">");
            out.println("<img src=\"img/wallet1.png\" class=\"logo\">");

            out.println("<form action=\"transaction.jsp\" method=\"POST\">");
            out.println(getKeyPair());
            out.println("<h2>COPY THIS DOWN</h2>");
            out.println("<p><input type=\"submit\" value=\"Continue\"></p>");
            out.println("</form>");
            out.println("</div>");
            out.println("</body>");
            out.println("</html>");
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

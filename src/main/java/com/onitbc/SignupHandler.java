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
import javax.servlet.RequestDispatcher;

import java.security.*;
import java.security.spec.ECGenParameterSpec;

import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.util.encoders.Base64;

/**
 *
 * @author bryce
 */
@WebServlet(name = "SignupHandler", urlPatterns = {"/createwallet"})
public class SignupHandler extends HttpServlet {
    
    private KeyGen keygen = new KeyGen();
    
    public static  PrivateKey privateKey;
    public static PublicKey publicKey;
    
    public static void generateKeyPair() {
		
		Security.addProvider(new BouncyCastleProvider());
		
		try {
			KeyPairGenerator keyGen = KeyPairGenerator.getInstance("ECDSA", "BC");
			SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
			ECGenParameterSpec ecSpec = new ECGenParameterSpec("prime192v1");
			// Initialize the key generator and generate a KeyPair
			keyGen.initialize(ecSpec, random);   //256 bytes provides an acceptable security level
	        	KeyPair keyPair = keyGen.generateKeyPair();
	        	// Set the public and private keys from the keyPair
	        	privateKey = keyPair.getPrivate();
	        	publicKey = keyPair.getPublic();
		}catch(Exception e) {
			throw new RuntimeException(e);
		}
    }
    
    String priKeyVar = new String(Base64.encode(privateKey.getEncoded()));
    String pubKeyVar = new String(Base64.encode(publicKey.getEncoded()));
    String pubAddrVar = HashGen.translate(new String(Base64.encode(publicKey.getEncoded())));
    
    keysAccessor kA = new keysAccessor(priKeyVar,pubKeyVar,pubAddrVar);
    
    public class keysAccessor {
        
        public String priKey, pubKey, pubAddr;
        
        public keysAccessor(String priKeyP, String pubKeyP, String pubAddrP) {
            priKey = priKeyP;
            pubKey = pubKeyP;
            pubAddr = pubAddrP;
        }        
        
        public void setPriKey(String prK) {
            this.priKey = prK;
        }
        
        public String getPriKey() {
            return this.priKey;
        }
        
        public void setPubKey(String puK) {
            this.pubKey = puK;
        }
        
        public String getPubKey() {
            return this.pubKey;
        }
        
        public void setPubAddr(String puA) {
            this.pubAddr = puA;
        }
        
        public String getPubAddr() {
            return this.pubAddr;
        }
        
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
        
        request.setAttribute("keys", kA);
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("createwallet.jsp");
        dispatcher.forward(request, response);
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

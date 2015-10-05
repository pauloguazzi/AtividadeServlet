/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.atividade01;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Paulo Guazzi
 */
//WebServlet("/ProcessaLogin")
@WebServlet(name = "ProcessaLogin", urlPatterns = "/ProcessaLogin")
public class ProcessaLogin extends HttpServlet {

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
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ProcessaLogin</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ProcessaLogin at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
            
            
            String login = request.getParameter("login");
            String senha = request.getParameter("senha");
            String perfilOp = request.getParameter("perfil");
            String perfil;
            
            if(perfilOp.equals("1")){
                perfil = "Cliente";
            } 
            else if(perfilOp.equals("2")){
                perfil = "Gerente";
            }
            else{
                perfil = "Administrador";
            }
            
            if  (request.getMethod().equalsIgnoreCase("post")) {
                if ((login.equals(senha) == false) || login.isEmpty() || senha.isEmpty()){
                    response.sendRedirect("erro.xhtml");
                   
                } else {
                    
                    String querystr = "login=" + login + "&perfil=" + perfil;
                                   
                    response.sendRedirect("sucesso?" + querystr);
                   
                    
                    //out.println("<h2>Olá, " + querystr + "</h2>");
                }
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

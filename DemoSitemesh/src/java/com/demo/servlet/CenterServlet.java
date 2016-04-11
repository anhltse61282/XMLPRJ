/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demo.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Gunner
 */
public class CenterServlet extends HttpServlet {

    private static String filterServlet = "FilterServlet";
    private static String viewServlet = "ViewServlet";
    private static String filterNameServlet = "FilterNameServlet";
    private static String searchNameServlet = "SearchNameServlet";
    private static String addCartServlet = "AddToCart";
    private static String viewCartServlet = "ViewCartServlet";
    private static String removeCartServlet = "RemoveCartServlet";

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
        PrintWriter out = response.getWriter();
        try {
            String button = request.getParameter("btnAction");
            if (button.equals("filter")) {
                RequestDispatcher rd = request.getRequestDispatcher(filterServlet);
                rd.forward(request, response);
            } else if (button.equals("View")) {
                RequestDispatcher rd = request.getRequestDispatcher(viewServlet);
                rd.forward(request, response);
            } else if (button.equals("filterName")) {
                RequestDispatcher rd = request.getRequestDispatcher(filterNameServlet);
                rd.forward(request, response);
            } else if (button.equals("Search")) {
                RequestDispatcher rd = request.getRequestDispatcher(searchNameServlet);
                rd.forward(request, response);
            } else if (button.equals("Addtocart")) {
                RequestDispatcher rd = request.getRequestDispatcher(addCartServlet);
                rd.forward(request, response);
            } else if (button.equals("removeCart")) {
                RequestDispatcher rd = request.getRequestDispatcher(removeCartServlet);
                rd.forward(request, response);
            }else if (button.equals("ViewCart")) {
                RequestDispatcher rd = request.getRequestDispatcher(viewCartServlet);
                rd.forward(request, response);
            }
        } finally {
            out.close();
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

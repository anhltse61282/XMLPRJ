/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.demo.servlet;

import com.assignment.dao.BrandDAO;
import com.assignment.dao.CatalogDAO;
import com.assignment.dao.DeviceDAO;
import com.demo.device.Device;
import com.demo.dto.Brands;
import com.demo.dto.Catalogs;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Gunner
 */
public class FilterNameServlet extends HttpServlet {

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
            String catalogID = request.getParameter("catalogId");
            String brandID = request.getParameter("brandID");
            String page = request.getParameter("p");
            String option = request.getParameter("slSort");
            int size = 12;
            String upper = null;
            String lower = null;
            Integer pageNum=null ;
            if (page == null ) {
                page = "1";
            }
            if (page != null) {
                pageNum = Integer.parseInt(page);
                Integer upperInt = (pageNum)*size;
                Integer lowerint = (pageNum-1)*size;
                upper = upperInt.toString();
                lower = lowerint.toString();
            }
            DeviceDAO deviceDAO = new DeviceDAO();
            List<Device> products = deviceDAO.filterDevice(catalogID, brandID,upper,lower,option);
            CatalogDAO catalogDAO = new CatalogDAO();
            List<Catalogs> catalog = catalogDAO.getAll();
            BrandDAO brandDAO = new BrandDAO();
            List<Brands> list = brandDAO.getAll();
            request.setAttribute("catalogs", catalog);
            request.setAttribute("products", products);
            request.setAttribute("size", deviceDAO.filterDeviceSize(catalogID, brandID,pageNum));
            request.setAttribute("brands", list);
            RequestDispatcher rd = request.getRequestDispatcher("filter.jsp");
            rd.forward(request, response);
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

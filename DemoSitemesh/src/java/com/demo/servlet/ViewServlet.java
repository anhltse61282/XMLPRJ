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
import com.demo.device.Devices;
import com.demo.dto.Brands;
import com.demo.dto.Catalogs;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

/**
 *
 * @author Gunner
 */
public class ViewServlet extends HttpServlet {

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
            String deviceID = request.getParameter("deviceID");
            DeviceDAO deviceDAO = new DeviceDAO();
            Device device = deviceDAO.searchbyID(deviceID);
            Devices devices = new Devices();
            devices.getDevice().add(device);
            JAXBContext jxbctx = JAXBContext.newInstance("com.demo.device");
            Marshaller marshaller = jxbctx.createMarshaller();
            StringWriter sq = new StringWriter();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(devices, sq);
            CatalogDAO catalogDAO = new CatalogDAO();
            List<Catalogs> catalog = catalogDAO.getAll();
            BrandDAO brandDAO = new BrandDAO();
            List<Brands> list = brandDAO.getAll();
            request.setAttribute("catalogs", catalog);
            request.setAttribute("product", sq.toString());
            request.setAttribute("brands", list);
            RequestDispatcher rd = request.getRequestDispatcher("view.jsp");
            rd.forward(request, response);
        } catch (JAXBException ex) {
            Logger.getLogger(ViewServlet.class.getName()).log(Level.SEVERE, null, ex);
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

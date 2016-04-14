/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demo.servlet;

import com.assignment.dao.DeviceDAO;
import com.demo.device.Device;
import com.demo.order.Cart;
import com.demo.order.OrderDetails;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.catalina.Session;

/**
 *
 * @author Gunner
 */
public class AddToCart extends HttpServlet {

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
            HttpSession session = request.getSession(true);
            Cart cart = (Cart) session.getAttribute("Cart");
            if (cart == null) {
                cart = new Cart();
            }
            DeviceDAO deviceDAO = new DeviceDAO();
            Device device = deviceDAO.searchbyID(deviceID);
            OrderDetails orderDetails = new OrderDetails();
            orderDetails.setDeviceName(device.getProductName());
            orderDetails.setId(deviceID);
            orderDetails.setPrice(device.getPrice());
            orderDetails.setDate(new Date());
            cart.addToCart(deviceID, orderDetails);
            session.setAttribute("Cart", cart);
            HashMap hashmaps = cart.getCart();
            Integer numberofProduct = hashmaps.size();
            String responseXml="<?xml version=\"1.0\" encoding=\"UTF-8\"?>"+"<Orderdetail>"+
                    "<numberdevive>"+
                    numberofProduct+
                    "</numberdevive>"+
                    "<totalPrice>"+cart.getTotal()+"</totalPrice>"+
                    "</Orderdetail>";
            
            System.out.println(numberofProduct);
            response.setContentType("text/xml");
            out =response.getWriter();
            out.write(responseXml);
            
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

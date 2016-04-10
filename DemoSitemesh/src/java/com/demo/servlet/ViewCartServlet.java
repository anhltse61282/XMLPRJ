/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demo.servlet;

import com.demo.order.Cart;
import com.demo.order.OrderDetails;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Gunner
 */
public class ViewCartServlet extends HttpServlet {

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
            /* TODO output your page here. You may use following sample code. */
            HttpSession session = request.getSession(false);
            if (session != null) {
                String detailOrd = "";
                Cart cart = (Cart) session.getAttribute("Cart");
                if (cart != null) {
                    HashMap items = cart.getCart();
                    Iterator iter = items.entrySet().iterator();
                    while (iter.hasNext()) {
                        Map.Entry item = (Map.Entry) iter.next();
                        OrderDetails orderDetail = (OrderDetails) item.getValue();
                        detailOrd = detailOrd+"<orderdetail>"+"<deviceName>"+orderDetail.getDeviceName()+"</deviceName>\n"+
                                "<quantity>"+orderDetail.getQuantity()+"</quantity>\n"+
                                "<price>"+orderDetail.getPrice()+"</price>"+
                                "<totalPrice>"+orderDetail.getTotalPrice()+"</totalPrice>"+"</orderdetail>";
                    }
                    String xmlResponse = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>"+
                            "<order>"+
                            detailOrd+
                            "</order>";
                    response.setContentType("text/xml");
                    out= response.getWriter();
                    out.write(xmlResponse);
                }
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

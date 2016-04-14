/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demo.servlet;

import com.demo.api.DBAPI;
import com.demo.dto.OrdersDTO;
import com.demo.dto.UsersDTO;
import com.demo.order.Cart;
import com.demo.order.OrderDetails;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Gunner
 */
public class PaymentServlet extends HttpServlet {

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
        HttpSession session = request.getSession(false);
        Integer orderID = 0;
        try {

            Cart cart = (Cart) session.getAttribute("Cart");
            UsersDTO user = (UsersDTO) session.getAttribute("User");
            String txtFullname = request.getParameter("txtFullname");
            String txtemail = request.getParameter("txtemail1");
            String txtphone = request.getParameter("txttelephone");
            String txtadd = request.getParameter("txtaddress");
            String txtstate = request.getParameter("txtstate");
            String txtcity = request.getParameter("txtcity");
            String txtDelFullname = request.getParameter("txtDelFullname");
            String txtDelemail = request.getParameter("txtDelemail1");
            String txtDelphone = request.getParameter("txtDeltelephone");
            String txtDeladd = request.getParameter("txtDeladdress");
            String txtDelstate = request.getParameter("txtDelstate");
            String txtDelcity = request.getParameter("txtDelcity");
            System.out.println(txtFullname);
            OrdersDTO ordersDTO = new OrdersDTO(txtFullname, txtemail, txtphone, txtadd, txtstate, txtcity, txtDelFullname, txtDelemail, txtDelphone, txtDeladd, txtDelstate, txtDelcity);
            if (cart.getSize() > 0) {

                DBAPI dbapi = new DBAPI();
                String insertOrder = "INSERT INTO TBL_Orders(customerName,phonenumber,address,cusEmail,cusCity,cusState,"
                        + "deliveryaddress,deliveryCustomer,deliveryPhone,delEmail,delCity,delState,totalPrice,username,dateOrd) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
                List<String> params = new ArrayList<String>();
                params.add(txtFullname);
                params.add(txtphone);
                params.add(txtadd);
                params.add(txtemail);
                params.add(txtcity);
                params.add(txtstate);
                params.add(txtDeladd);
                params.add(txtDelFullname);
                params.add(txtDelphone);
                params.add(txtDelemail);
                params.add(txtDelcity);
                params.add(txtDelstate);
                params.add(cart.getTotal().toString());
                if (user != null) {
                    params.add(user.getUsername());
                } else {
                    params.add("guest");
                }
                params.add(new Date().toString());
                orderID = dbapi.insertData(insertOrder, params);
                HashMap items = cart.getCart();
                Iterator iter = items.entrySet().iterator();
                while (iter.hasNext()) {
                    Map.Entry item = (Map.Entry) iter.next();
                    OrderDetails orderDetail = (OrderDetails) item.getValue();
                    String insertOrderDetail = "INSERT INTO TBL_OrderDetail(orderID,productID,quantity,price) VALUES(?,?,?,?)";
                    List<String> paramsDetail = new ArrayList<String>();
                    paramsDetail.add(orderID.toString());
                    paramsDetail.add(orderDetail.getId());
                    paramsDetail.add(orderDetail.getQuantity().toString());
                    paramsDetail.add(orderDetail.getPrice().toString());
                    dbapi.insertData(insertOrderDetail, paramsDetail);
                }
                System.out.println("done");
            }
            request.setAttribute("orderID", orderID);
            request.setAttribute("Order", ordersDTO);
            request.setAttribute("CartReq", cart);
            session.removeAttribute("Cart");
            RequestDispatcher rd = request.getRequestDispatcher("receif.jsp");
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

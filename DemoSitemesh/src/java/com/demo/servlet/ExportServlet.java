/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demo.servlet;

import com.demo.dto.OrdersDTO;
import com.demo.order.Cart;
import com.demo.order.OrderDetails;
import com.demo.orderJB.Order;
import com.demo.orderJB.OrderDetail;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.PropertyException;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.sax.SAXResult;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import org.apache.commons.io.output.ByteArrayOutputStream;
import org.apache.fop.apps.FOPException;
import org.apache.fop.apps.FOUserAgent;
import org.apache.fop.apps.Fop;
import org.apache.fop.apps.FopFactory;
import org.apache.xmlgraphics.util.MimeConstants;
import org.xml.sax.SAXException;

/**
 *
 * @author Gunner
 */
public class ExportServlet extends HttpServlet {

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
        

        try {
            HttpSession session = request.getSession(false);
            if (session != null) {
                String realpath = getServletContext().getRealPath("/");
                String xslPath = realpath + "WEB-INF/orderPDF.xsl";
                String foPath = realpath + "WEB-INF/grammarDoc.fo";
                String xmlpath = realpath +"WEB-INF/order.xml";
                String detailOrd = "";
                Cart cart = (Cart) session.getAttribute("CartReq");
                OrdersDTO orderDTO = (OrdersDTO) session.getAttribute("OrderPDF");
                Order order = new Order();
                order.setCutomerName(orderDTO.getTxtFullname());
                order.setCustomerPhone(new BigInteger(orderDTO.getTxtDelphone()));
                order.setDelAddress(orderDTO.getTxtDeladd());
                order.setDelState(orderDTO.getTxtstate());
                order.setDelCity(orderDTO.getTxtcity());
                order.setTotal(cart.getTotal());
                if (cart != null) {
                    HashMap items = cart.getCart();
                    Iterator iter = items.entrySet().iterator();
                    while (iter.hasNext()) {
                        OrderDetail orderDetailJB = new OrderDetail();
                        Map.Entry item = (Map.Entry) iter.next();
                        OrderDetails orderDetail = (OrderDetails) item.getValue();
                        orderDetailJB.setProductName(orderDetail.getDeviceName());
                        orderDetailJB.setQuantity(BigInteger.valueOf(orderDetail.getQuantity()));
                        orderDetailJB.setPrice(orderDetail.getPrice());
                        orderDetailJB.setTotal(orderDetail.getTotalPrice());
                        order.getOrderdetail().add(orderDetailJB);

                    }

                }
                JAXBContext jAXBContext = JAXBContext.newInstance("com.demo.orderJB");
                Marshaller marshal = jAXBContext.createMarshaller();
                marshal.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
                marshal.marshal(order, new File(xmlpath));
                methodTrax(xslPath, xmlpath, foPath, realpath);
                File file = new File(foPath);
                FileInputStream fileInputStream = new FileInputStream(file);
                ByteArrayOutputStream out = new ByteArrayOutputStream();
                response.setContentType("application/pdf;charset=UTF-8");
                response.setHeader("content-disposition", "inline; filename=\""+orderDTO.getTxtFullname()+"\".pdf");
                FopFactory fopf = FopFactory.newInstance();
                fopf.setUserConfig(new File(realpath+"WEB-INF/fonts.xml"));
                FOUserAgent fua = fopf.newFOUserAgent();
                Fop fop = fopf.newFop(MimeConstants.MIME_PDF, fua, out);
                TransformerFactory tff = TransformerFactory.newInstance();
                Transformer tf = tff.newTransformer();
                File fo = new File(foPath);
                Source src = new StreamSource(fo);
                Result result = new SAXResult(fop.getDefaultHandler());
                tf.transform(src, result);
                
                byte contetn[] = out.toByteArray();
                response.setContentLength(contetn.length);
                response.getOutputStream().write(contetn);
                response.getOutputStream().flush();
            }

        } catch (PropertyException ex) {
            Logger.getLogger(ExportServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JAXBException ex) {
            Logger.getLogger(ExportServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FOPException ex) {
            Logger.getLogger(ExportServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TransformerConfigurationException ex) {
            Logger.getLogger(ExportServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TransformerException ex) {
            Logger.getLogger(ExportServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SAXException ex) {
            Logger.getLogger(ExportServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void methodTrax(String xslpath, String xml, String output, String path) {
        try {
            TransformerFactory tff = TransformerFactory.newInstance();
            StreamSource xslfile = new StreamSource(xslpath);
            Transformer tf = tff.newTransformer(xslfile);
            StreamSource xmlSrc = new StreamSource(xml);
            StreamResult htmlfile = new StreamResult(new FileOutputStream(output));
            tf.transform(xmlSrc, htmlfile);
        } catch (TransformerConfigurationException ex) {
            Logger.getLogger(ExportServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ExportServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TransformerException ex) {
            Logger.getLogger(ExportServlet.class.getName()).log(Level.SEVERE, null, ex);
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

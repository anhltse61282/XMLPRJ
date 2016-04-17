/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demo;

import com.assignment.dao.DeviceDAO;
import com.demo.api.DBAPI;
import com.demo.device.Device;
import com.demo.dto.OrderDBDTO;
import com.demo.dto.OrderDetailsDBDTO;
import com.demo.dto.OrdersDTO;
import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlButtonInput;
import com.gargoylesoftware.htmlunit.html.HtmlForm;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.html.HtmlRadioButtonInput;
import com.gargoylesoftware.htmlunit.html.HtmlTextInput;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.logging.LogFactory;

/**
 *
 * @author Gunner
 */
public class payment {

    private String ordeID;

    public String getOrderDTO() {
        return ordeID;
    }

    public void setOrderDTO(String orderDTO) {
        this.ordeID = orderDTO;
    }

    public payment() {
    }

    public boolean paymentHNAM() {
        try {
            String query = "SELECT * FROM TBL_OrderDetail WHERE orderID = ?";

            List<String> list = new ArrayList<String>();
            list.add(ordeID);
            DBAPI dbapi = new DBAPI();
            List<OrderDetailsDBDTO> orderDetails = dbapi.selectData(query, list, "TBL_OrderDetail");
            query = "SELECT * FROM TBL_Orders WHERE id = ?";
            list = new ArrayList<String>();
            list.add(ordeID);
            OrderDBDTO order = (OrderDBDTO) dbapi.selectData(query, list, "TBL_Orders").get(0);
            int count = 0;
            int countQuan = 0;
            for (int i = 0; i < orderDetails.size(); i++) {
                OrderDetailsDBDTO orderDetail = orderDetails.get(i);
                DeviceDAO deviceDAO = new DeviceDAO();
                Device device = deviceDAO.searchbyID(orderDetail.getProductID());
                countQuan = countQuan + orderDetail.getQuantity();
                if (device != null) {
                    System.out.println(device.getProductName());
                    for (int j = 0; j < orderDetail.getQuantity(); j++) {
                        LogFactory.getFactory().setAttribute("org.apache.commons.logging.Log", "org.apache.commons.logging.impl.NoOpLog");
                        WebClient webCLient = new WebClient(BrowserVersion.FIREFOX_17);
                        webCLient.getOptions().setThrowExceptionOnScriptError(false);
                        webCLient.getOptions().setThrowExceptionOnFailingStatusCode(false);
                        HtmlPage page1 = webCLient.getPage(device.getOrderLinkLink());

            // Get the form that we are dealing with and within that form,
                        // find the submit button and the field that we want to change.
                        HtmlForm form = page1.getFormByName("frmPage");

                        HtmlButtonInput button = form.getInputByName("save");
                        HtmlTextInput fullname = form.getInputByName("fullname");
                        HtmlTextInput phone = form.getInputByName("phone");

                        // Change the value of the text field
                        fullname.setValueAttribute(order.getFullname());
                        phone.setValueAttribute("0" + order.getPhone());
                        HtmlRadioButtonInput radio = form.getInputByValue("ship2");
                        radio.click();

                        // Now submit the form by clicking the button and get back the second page.
                        HtmlPage page2 = button.click();
                        if (page2.getTitleText().contains("Đặt mua sản phẩm")) {
                            count++;
                            System.out.println("done");
                        }
                    }
                }
            }
            if (countQuan == count) {
                return true;
            }
            return false;
        } catch (IOException ex) {
            Logger.getLogger(payment.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FailingHttpStatusCodeException ex) {
            Logger.getLogger(payment.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

}

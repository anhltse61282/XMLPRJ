/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.demo.api;

import com.demo.dto.OrderDetailsDBDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Gunner
 */
public class OrderDetailOBJ {
    public static <T> T tranferRStoOBJ(ResultSet rs){
        try {
            OrderDetailsDBDTO orderDetailsDBDTO = new OrderDetailsDBDTO();
            orderDetailsDBDTO.setOrderID(rs.getString("orderID"));
            orderDetailsDBDTO.setProductID(rs.getString("productID"));
            orderDetailsDBDTO.setQuantity(rs.getInt("quantity"));
            return (T) orderDetailsDBDTO;
        } catch (SQLException ex) {
            Logger.getLogger(OrderDetailOBJ.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}

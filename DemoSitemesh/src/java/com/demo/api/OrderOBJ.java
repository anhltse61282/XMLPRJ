/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.demo.api;

import com.demo.dto.OrderDBDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Gunner
 */
public class OrderOBJ {
    public static <T> T tranferRStoOBJ(ResultSet rs){
        try {
            OrderDBDTO orderDBDTO = new OrderDBDTO();
            orderDBDTO.setId(rs.getString("id"));
            orderDBDTO.setFullname(rs.getString("customerName"));
            orderDBDTO.setPhone(rs.getString("phonenumber"));
            return (T) orderDBDTO;
        } catch (SQLException ex) {
            Logger.getLogger(OrderOBJ.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}

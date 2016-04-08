/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.demo.api;

import com.demo.dto.Brands;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Gunner
 */
public class BrandsOBJ {
    public static <T> T transferRSToOBJ(ResultSet rs){
        try {
            Brands brands = new Brands(rs.getInt("id"),rs.getString("brandName"));
            return (T) brands;
        } catch (SQLException ex) {
            Logger.getLogger(BrandsOBJ.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}

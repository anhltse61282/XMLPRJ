/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.demo.api;

import com.demo.dto.MiningDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Gunner
 */
public class MininingOBJ {
    public static <T> T tranferRStoOBJ(ResultSet rs){
        try {
            MiningDTO miningDTO = new MiningDTO();
            miningDTO.setProductID(rs.getString("productID"));
            miningDTO.setRelatedID(rs.getString("relatedPro"));
            return  (T) miningDTO;
        } catch (SQLException ex) {
            Logger.getLogger(MininingOBJ.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}

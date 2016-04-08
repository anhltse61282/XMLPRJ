/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.demo.api;

import com.demo.dto.Catalogs;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Gunner
 */
public class CatalogOBJ {
    public static <T> T tranferRSToOBJ(ResultSet rs){
        try {
            Catalogs catalogs = new Catalogs(rs.getInt("id"),rs.getString("catalogName"));
            return (T) catalogs;
        } catch (SQLException ex) {
            Logger.getLogger(CatalogOBJ.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}

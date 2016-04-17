/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.demo.api;

import com.demo.dto.UsersDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Gunner
 */
public class UsersOBJ {
    public static <T> T tranferRStoOBJ(ResultSet rs){
        try {
            UsersDTO usersDTO = new UsersDTO();
            usersDTO.setUsername(rs.getString("username"));
            usersDTO.setPassword(rs.getString("password"));
            return (T) usersDTO;
        } catch (SQLException ex) {
            Logger.getLogger(UsersOBJ.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
}

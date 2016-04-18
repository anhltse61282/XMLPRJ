/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demo.api;

import com.demo.dto.User;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Gunner
 */
public class UserOBJ implements SpectOBJ {

    @Override
    public <T> T getDatafromRS(ResultSet rs) {
        try {
            User user = new User();
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            return (T) user; //To change body of generated methods, choose Tools | Templates.
        } catch (SQLException ex) {
            Logger.getLogger(UserOBJ.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.assignment.dao;

import com.demo.api.DBAPI;
import com.demo.dto.UsersDTO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Gunner
 */
public class UserDAO {

    public UserDAO() {
    }

    public UsersDTO createAccount(String username, String password) {
        DBAPI dbapi = new DBAPI();
        String query = "INSERT INTO TBL_USERS(username,password) VALUES(?,?)";
        List<String> params = new ArrayList<String>();
        params.add(username);
        params.add(password);
        dbapi.insertData(query, params);
        UsersDTO usersDTO = new UsersDTO();
        usersDTO.setUsername(username);
        usersDTO.setPassword(password);
        return usersDTO;
    }

    public UsersDTO checkLogin(String username, String password) {
        DBAPI dbapi = new DBAPI();
        String query = "SELECT * FROM dbo.TBL_USERS WHERE username = ? AND password = ?";
        List<String> params = new ArrayList<String>();
        params.add(username);
        params.add(password);
        List<UsersDTO> result = dbapi.selectData(query, params, "TBL_USERS");
        for (UsersDTO usersDTO : result) {
            System.out.println(usersDTO.getUsername());
        }
        if (result.size()>0) {
            return result.get(0);
        }
        return null ;
    }
}

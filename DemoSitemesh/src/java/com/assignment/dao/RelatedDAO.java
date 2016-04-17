/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.assignment.dao;

import com.demo.api.DBAPI;
import com.demo.dto.MiningDTO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Gunner
 */
public class RelatedDAO {
    public void insertDB(List<String>params){
        String query ="INSERT INTO TBL_Mining(productID,relatedPro) VALUES(?,?)";
        DBAPI dbapi = new DBAPI();
        dbapi.insertData(query, params);
    }
    public List<MiningDTO> searchbyID(String ID){
        String query = "SELECT * FROM TBL_Mining WHERE productID = ?";
        DBAPI dbapi = new DBAPI();
        List<String> params = new ArrayList<String>();
        params.add(ID);
        List<MiningDTO> result = dbapi.selectData(query, params, "TBL_Mining");
        return result;
    }
    public List<MiningDTO> checkDuplicate(String proID, String relatedID){
        String query = "SELECT * FROM TBL_Mining WHERE productID = ? AND relatedPro = ?";
        DBAPI dbapi = new DBAPI();
        List<String> params = new ArrayList<String>();
        params.add(proID);
        params.add(relatedID);
        List<MiningDTO> result = dbapi.selectData(query, params, "TBL_Mining");
        for (MiningDTO miningDTO : result) {
            System.out.println("Dubplicate:" +miningDTO.getProductID());
        }
        return result;
    }
}

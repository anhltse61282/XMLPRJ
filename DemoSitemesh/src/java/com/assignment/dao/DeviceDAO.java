/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.assignment.dao;

import com.demo.api.DBAPI;
import com.demo.device.Device;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Gunner
 */
public class DeviceDAO {

    public List<Device> getAll() {
        DBAPI api = new DBAPI();
        return api.getALL("TBL_Products");
    }

    public List<Device> filterDevice(String catalogId, String brandID) {
        DBAPI dbapi = new DBAPI();
        String query = "SELECT * FROM TBL_Products WHERE catalogID = ?";
        List<String> params = new ArrayList<String>();
        params.add(catalogId);
        if (!brandID.equals("")) {
            query = "SELECT * FROM TBL_Products WHERE catalogID = ? AND brandID = ?";
            params.add(brandID);
        }

        List<Device> result = dbapi.selectData(query, params, "TBL_Products");
        return result;
    }

    public Device searchbyID(String id) {
        DBAPI dbapi = new DBAPI();
        String query = "SELECT * FROM TBL_Products WHERE ID = ?";
        List<String> params = new ArrayList<String>();
        params.add(id);
        List<Device> result = dbapi.selectData(query, params, "TBL_Products");
        return result.get(0);
    }
    public List<Device> searchlike(String name) {
        DBAPI dbapi = new DBAPI();
        String query = "SELECT * FROM TBL_Products WHERE productname like ?";
        List<String> params = new ArrayList<String>();
        params.add("%"+name+"%");
        List<Device> result = dbapi.selectData(query, params, "TBL_Products");
        return result;
    }
}

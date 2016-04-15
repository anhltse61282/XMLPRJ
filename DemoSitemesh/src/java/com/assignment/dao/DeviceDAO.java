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
    public int filterDeviceSize(String catalogId, String brandID){
        DBAPI dbapi = new DBAPI();
        String query = "SELECT * FROM dbo.TBL_Products WHERE catalogID = ?";
        List<String> params = new ArrayList<String>();
        params.add(catalogId);
        if (!brandID.equals("")) {
            query = "SELECT * FROM dbo.TBL_Products WHERE catalogID = ? AND brandID = ?";
            params.add(brandID);
        }
       List<Device> result = dbapi.selectData(query, params, "TBL_Products");
        for (Device device : result) {
            System.out.println(device.getMaincamera());
        }
       int pageNum = (result.size())/10;
       return pageNum;
    }
    public List<Device> filterDevice(String catalogId, String brandID, String upper, String lower) {
        DBAPI dbapi = new DBAPI();
        String query = "select * from ("
                + "select ROW_NUMBER() over (order by id) lfd,"
                + "* from dbo.TBL_Products "
                + "WHERE catalogID = ? "
                + ") as t "
                + " where lfd between ? and ? "
                + " order by id";
        List<String> params = new ArrayList<String>();
        String query2 = "";
        params.add(catalogId);
        if (!brandID.equals("")) {
            query2 = "select * from ("
                    + "select ROW_NUMBER() over (order by id) lfd,"
                    + "* from dbo.TBL_Products "
                    + "WHERE catalogID = ? AND brandID = ? "
                    + ") as t "
                    + " where lfd between ? and ? "
                    + " order by id";

         params.add(brandID);
            params.add(lower);
            params.add(upper);
            return dbapi.selectData(query2, params, "TBL_Products");
        }
        
        params.add(lower);
        params.add(upper);
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
        params.add("%" + name + "%");
        List<Device> result = dbapi.selectData(query, params, "TBL_Products");
        return result;
    }
}

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

    public void updateDevice(String param, String id) {
        DBAPI dbapi = new DBAPI();
        String query = "UPDATE  dbo.TBL_Products SET viewTime = ? WHERE id = ?";
        List<String> params = new ArrayList<String>();
        params.add(param);
        params.add(id);
        dbapi.updateDB(query, params);
    }

    public List<Device> getAll() {
        DBAPI api = new DBAPI();
        return api.getALL("TBL_Products");
    }

    public List<Device> getTop() {
        DBAPI api = new DBAPI();
        return api.getTop("TBL_Products");
    }

    public List<String> filterDeviceSize(String catalogId, String brandID, Integer page) {
        DBAPI dbapi = new DBAPI();
        String query = "SELECT * FROM dbo.TBL_Products WHERE catalogID = ?";
        List<String> params = new ArrayList<String>();
        params.add(catalogId);
        if (!brandID.equals("")) {
            query = "SELECT * FROM dbo.TBL_Products WHERE catalogID = ? AND brandID = ?";
            params.add(brandID);
        }
        List<Device> result = dbapi.selectData(query, params, "TBL_Products");

        int pageNum = (result.size()) / 12;
        if (result.size() % 12 > 0) {
            pageNum = pageNum + 1;
        }
        Integer lower = page - 5;
        Integer upper = page + 5;
        if (lower < 1) {
            lower = 1;
        }
        if (upper > pageNum) {
            upper = pageNum;
        }
        List<String> resultPage = new ArrayList<String>();
        for (Integer i = lower; i <= upper; i++) {
            resultPage.add(i.toString());
            System.out.println(i);
        }
        return resultPage;
    }

    public List<Device> filterDevice(String catalogId, String brandID, String upper, String lower, String option) {
        DBAPI dbapi = new DBAPI();
        String query = "select * from ("
                + "select ROW_NUMBER() over (order by id) lfd,"
                + "* from dbo.TBL_Products "
                + "WHERE catalogID = ? "
                + ") as t "
                + " where lfd between ? and ? "
                + " order by id";
        if (option != null) {
            if (option.equals("AZ")) {
                query = "select * from ("
                        + "select ROW_NUMBER() over (order by id) lfd,"
                        + "* from dbo.TBL_Products "
                        + "WHERE catalogID = ? "
                        + ") as t "
                        + " where lfd between ? and ? "
                        + " order by productname ASC";
            }
            if (option.equals("ZA")) {
                query = "select * from ("
                        + "select ROW_NUMBER() over (order by id) lfd,"
                        + "* from dbo.TBL_Products "
                        + "WHERE catalogID = ? "
                        + ") as t "
                        + " where lfd between ? and ? "
                        + " order by productname DESC";
            }
            if (option.equals("ASD")) {
                query = "select * from ("
                        + "select ROW_NUMBER() over (order by id) lfd,"
                        + "* from dbo.TBL_Products "
                        + "WHERE catalogID = ? "
                        + ") as t "
                        + " where lfd between ? and ? "
                        + " order by price ASC";
            }
            if (option.equals("DESC")) {
                query = "select * from ("
                        + "select ROW_NUMBER() over (order by id) lfd,"
                        + "* from dbo.TBL_Products "
                        + "WHERE catalogID = ? "
                        + ") as t "
                        + " where lfd between ? and ? "
                        + " order by price DESC";
            }
        }
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
            if (option != null) {
                if (option.equals("AZ")) {
                    query2 = "select * from ("
                            + "select ROW_NUMBER() over (order by id) lfd,"
                            + "* from dbo.TBL_Products "
                            + "WHERE catalogID = ? AND brandID = ? "
                            + ") as t "
                            + " where lfd between ? and ? "
                            + " order by productname ASC";
                }
                if (option.equals("ZA")) {
                    query2 = "select * from ("
                            + "select ROW_NUMBER() over (order by id) lfd,"
                            + "* from dbo.TBL_Products "
                            + "WHERE catalogID = ? AND brandID = ? "
                            + ") as t "
                            + " where lfd between ? and ? "
                            + " order by productname DESC";
                }
                if (option.equals("ASD")) {
                    query2 = "select * from ("
                            + "select ROW_NUMBER() over (order by id) lfd,"
                            + "* from dbo.TBL_Products "
                            + "WHERE catalogID = ? AND brandID = ? "
                            + ") as t "
                            + " where lfd between ? and ? "
                            + " order by price ASC";
                }
                if (option.equals("DESC")) {
                    query2 = "select * from ("
                            + "select ROW_NUMBER() over (order by id) lfd,"
                            + "* from dbo.TBL_Products "
                            + "WHERE catalogID = ? AND brandID = ? "
                            + ") as t "
                            + " where lfd between ? and ? "
                            + " order by price DESC";
                }
            }
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
        String query = "SELECT * FROM TBL_Products WHERE productname like ? ORDER BY productname ASC";
        List<String> params = new ArrayList<String>();
        params.add("%" + name + "%");
        List<Device> result = dbapi.selectData(query, params, "TBL_Products");
        return result;
    }
}

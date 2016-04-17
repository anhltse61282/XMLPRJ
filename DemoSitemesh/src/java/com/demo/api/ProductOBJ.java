/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.demo.api;

import com.demo.device.Device;
import java.math.BigInteger;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Gunner
 */
public class ProductOBJ {
    public static <T> T tranferRStoOBJ(ResultSet rs){
        try {
            Device device = new Device();
            device.setId(BigInteger.valueOf((rs.getInt("id"))));
            device.setProductName(rs.getString("productname"));
            device.setMonitor(rs.getString("monitor"));
            device.setMemory(rs.getString("memory"));
            device.setMemorycard(rs.getString("memorycard"));
            device.setMaincamera(rs.getString("maincamera"));
            device.setSubCamera(rs.getString("subCamera"));
            device.setOs(rs.getString("OS"));
            device.setColor(rs.getString("color"));
            device.setChipset(rs.getString("Chip"));
            device.setChipName(rs.getString("chipName"));
            device.setBattery(rs.getString("battery"));
            device.setPrice(BigInteger.valueOf((rs.getInt("price"))));
            device.setImageLink(rs.getString("imageLink"));
            device.setBrandID(BigInteger.valueOf((rs.getInt("brandID"))));
            device.setCatalogID(BigInteger.valueOf((rs.getInt("catalogID"))));
            device.setSource(rs.getString("source"));
            device.setViewTime(BigInteger.valueOf(rs.getInt("viewTime")));
            device.setOrderLinkLink(rs.getString("purchaseLnk"));
            return (T) device;
        } catch (SQLException ex) {
            Logger.getLogger(ProductOBJ.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}

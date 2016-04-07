/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.assignment.dao;

import com.demo.api.DBAPI;
import com.demo.device.Device;
import java.util.List;

/**
 *
 * @author Gunner
 */
public class DeviceDAO {
    public List<Device> getAll(){
        DBAPI api = new DBAPI();
        return api.getALL("TBL_Products");
    }
}

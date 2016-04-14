/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.assignment.dao;

import com.demo.api.DBAPI;
import com.demo.dto.Brands;
import com.demo.dto.Catalogs;
import java.util.List;

/**
 *
 * @author Gunner
 */
public class BrandDAO {
      public List<Brands> getAll(){
        DBAPI dbi = new DBAPI();
        List<Brands> result= dbi.getALL("TBL_brand");
        return result;
    }
}

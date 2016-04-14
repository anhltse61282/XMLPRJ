/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.assignment.dao;

import com.demo.api.DBAPI;
import com.demo.dto.Catalogs;
import java.util.List;

/**
 *
 * @author Gunner
 */
public class CatalogDAO {
    public List<Catalogs> getAll(){
        DBAPI dbi = new DBAPI();
        List<Catalogs> result= dbi.getALL("TBL_Catalog");
        return result;
    }
}

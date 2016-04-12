/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demo.api;

import java.sql.ResultSet;

/**
 *
 * @author Gunner
 */
public class JDBCTransfer {

    public static <T> T ResultSettoOBJ(ResultSet rs, String tablename) {
        T result = null;
        switch (tablename) {
            case "TBL_Catalog":
                result = CatalogOBJ.tranferRSToOBJ(rs);
                break;
            case "TBL_brand":
                result = BrandsOBJ.transferRSToOBJ(rs);
                break;

        }
        return result;
    }
}

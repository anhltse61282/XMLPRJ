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

        if (tablename == "TBL_Catalog") {
            return CatalogOBJ.tranferRSToOBJ(rs);
        } else if (tablename == "TBL_brand") {
            return BrandsOBJ.transferRSToOBJ(rs);
        }else if (tablename == "TBL_Products") {
            return ProductOBJ.tranferRStoOBJ(rs);
        }else if (tablename == "TBL_OrderDetail") {
            return OrderDetailOBJ.tranferRStoOBJ(rs);
        }else if (tablename == "TBL_Orders") {
            return OrderOBJ.tranferRStoOBJ(rs);
        }else if (tablename == "TBL_Mining") {
            return MininingOBJ.tranferRStoOBJ(rs);
        }else if (tablename == "TBL_USERS") {
            return UsersOBJ.tranferRStoOBJ(rs);
        }

        return null;
    }

}

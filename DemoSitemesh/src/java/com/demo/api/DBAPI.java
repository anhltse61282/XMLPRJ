/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demo.api;

import com.demo.dbutil.DBUtil;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Gunner
 */
public class DBAPI {

    public <T> List<T> getALL(String tableName) {
        Statement statement = null;
        Connection conn = null;
        ResultSet resultRS = null;

        // TODO code application logic here
        conn = DBUtil.makeConnection();
        if (conn != null) {
            try {
                String query = "SELECT * FROM " + tableName;
                statement = conn.createStatement();
                resultRS = statement.executeQuery(query);
                List<T> result = new ArrayList<T>();
                while (resultRS.next()) {

                    result.add((T) JDBCTransfer.ResultSettoOBJ(resultRS, tableName));
                }
                return result;
            } catch (SQLException ex) {
                ex.printStackTrace();
            } finally {
                try {
                    resultRS.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
                try {
                    statement.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
                try {
                    conn.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }

        }
        return null;
    }
    public <T> List<T> getTop(String tableName) {
        Statement statement = null;
        Connection conn = null;
        ResultSet resultRS = null;

        // TODO code application logic here
        conn = DBUtil.makeConnection();
        if (conn != null) {
            try {
                String query = "SELECT TOP 10 * FROM "+tableName+" ORDER BY viewTime DESC ";
                statement = conn.createStatement();
                resultRS = statement.executeQuery(query);
                List<T> result = new ArrayList<T>();
                while (resultRS.next()) {

                    result.add((T) JDBCTransfer.ResultSettoOBJ(resultRS, tableName));
                }
                return result;
            } catch (SQLException ex) {
                ex.printStackTrace();
            } finally {
                try {
                    resultRS.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
                try {
                    statement.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
                try {
                    conn.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }

        }
        return null;
    }

    public int insertData(String query, List<String> param) {
        PreparedStatement statement = null;
        Connection conn = null;
        ResultSet rs = null;
        // TODO code application logic here
        conn = DBUtil.makeConnection();
        if (conn != null) {
            try {
                statement = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

                for (int i = 0; i < param.size(); i++) {
                    statement.setString(i + 1, param.get(i));
                }
                int rowCount = statement.executeUpdate();
                rs = statement.getGeneratedKeys();
                if (rs.next()) {
                    return rs.getInt(1);
                }
                System.out.println("Total " + rowCount + " row inserted to DB");

            } catch (SQLException ex) {
                ex.printStackTrace();
            } finally {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DBAPI.class.getName()).log(Level.SEVERE, null, ex);
                }
                try {
                    statement.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
                try {
                    conn.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }

        }
        return -1;
    }

    public <T> List<T> selectData(String query, List<String> params, String tablename) {
        PreparedStatement statement = null;
        Connection conn = null;
        ResultSet resultRS = null;

        // TODO code application logic here
        conn = DBUtil.makeConnection();
        if (conn != null) {
            try {
                statement = conn.prepareStatement(query);
                for (int i = 0; i < params.size(); i++) {

                    statement.setString(i + 1, params.get(i));

                }

                resultRS = statement.executeQuery();
                List<T> result = new ArrayList<T>();
                while (resultRS.next()) {

                    result.add((T) JDBCTransfer.ResultSettoOBJ(resultRS, tablename));
                }
                return result;
            } catch (SQLException ex) {
                ex.printStackTrace();
            } finally {
                try {
                    resultRS.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
                try {
                    statement.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
                try {
                    conn.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }

        }
        return null;
    }

    public <T> T searchByName(String query, List<String> params, String tableName) {
        PreparedStatement statement = null;
        Connection conn = null;
        ResultSet resultRS = null;

        // TODO code application logic here
        conn = DBUtil.makeConnection();
        if (conn != null) {
            try {
                statement = conn.prepareStatement(query);
                for (int i = 0; i < params.size(); i++) {
                    statement.setString(i + 1, params.get(i));
                }
                resultRS = statement.executeQuery();
                if (resultRS.next()) {
                    return (T) JDBCTransfer.ResultSettoOBJ(resultRS, tableName);
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            } finally {
                try {
                    resultRS.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
                try {
                    statement.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
                try {
                    conn.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }

        }
        return null;
    }

    public void updateDB(String query, List<String> param) {
        PreparedStatement statement = null;
        Connection conn = null;
        
        // TODO code application logic here
        conn = DBUtil.makeConnection();
        if (conn != null) {
            try {
                statement = conn.prepareStatement(query);

                for (int i = 0; i < param.size(); i++) {
                    statement.setString(i + 1, param.get(i));
                }
                int rowCount = statement.executeUpdate();      
                System.out.println("Total " + rowCount + " row update to DB");

            } catch (SQLException ex) {
                ex.printStackTrace();
            } finally {
                
                try {
                    statement.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
                try {
                    conn.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }

        }
        
    }
}

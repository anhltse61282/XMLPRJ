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
public interface SpectOBJ {

    /**
     *
     * @param <T>
     * @param rs
     * @return
     */
    public <T> T getDatafromRS(ResultSet rs);
}

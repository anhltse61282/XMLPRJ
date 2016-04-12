/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.demo.dto;

/**
 *
 * @author Gunner
 */
public class Catalogs {
    private Integer ID;
    private String catalogName;

    public Catalogs() {
    }

    public Catalogs(Integer ID, String catalogName) {
        this.ID = ID;
        this.catalogName = catalogName;
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getCatalogName() {
        return catalogName;
    }

    public void setCatalogName(String catalogName) {
        this.catalogName = catalogName;
    }
    
}

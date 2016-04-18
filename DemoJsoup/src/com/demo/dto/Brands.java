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
public class Brands {
    private Integer id;
    private String brandName;

    public Brands() {
    }

    public Brands(Integer id, String brandName) {
        this.id = id;
        this.brandName = brandName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }
    
}

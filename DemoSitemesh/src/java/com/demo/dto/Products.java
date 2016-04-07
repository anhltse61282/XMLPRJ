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
public class Products {
    private Integer id;
    private String productName;
    private String monitor;
    private String memory;
    private String memorycard;
    private String maincamera;
    private String subCamera;
    private String os;
    private String chipset;
    private String chipName;
    private String color;
    private String battery;
    private Double price;
    private Integer catalogID;
    private Integer brandID;

    public Products() {
    }

    public Products(String productName, String monitor, String memory, String memorycard, String maincamera, String subCamera, String os, String chipset, String color, String battery, Double price, Integer catalogID, Integer brandID) {
        this.productName = productName;
        this.monitor = monitor;
        this.memory = memory;
        this.memorycard = memorycard;
        this.maincamera = maincamera;
        this.subCamera = subCamera;
        this.os = os;
        this.chipset = chipset;
        this.color = color;
        this.battery = battery;
        this.price = price;
        this.catalogID = catalogID;
        this.brandID = brandID;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getMonitor() {
        return monitor;
    }

    public void setMonitor(String monitor) {
        this.monitor = monitor;
    }

    public String getMemory() {
        return memory;
    }

    public void setMemory(String memory) {
        this.memory = memory;
    }

    public String getMemorycard() {
        return memorycard;
    }

    public void setMemorycard(String memorycard) {
        this.memorycard = memorycard;
    }

    public String getMaincamera() {
        return maincamera;
    }

    public void setMaincamera(String maincamera) {
        this.maincamera = maincamera;
    }

    public String getSubCamera() {
        return subCamera;
    }

    public void setSubCamera(String subCamera) {
        this.subCamera = subCamera;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public String getChipset() {
        return chipset;
    }

    public void setChipset(String chipset) {
        this.chipset = chipset;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getBattery() {
        return battery;
    }

    public void setBattery(String battery) {
        this.battery = battery;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getCatalogID() {
        return catalogID;
    }

    public void setCatalogID(Integer catalogID) {
        this.catalogID = catalogID;
    }

    public Integer getBrandID() {
        return brandID;
    }

    public void setBrandID(Integer brandID) {
        this.brandID = brandID;
    }

    public String getChipName() {
        return chipName;
    }

    public void setChipName(String chipName) {
        this.chipName = chipName;
    }
    
}

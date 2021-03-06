//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.5-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.04.15 at 09:53:28 PM ICT 
//


package com.demo.device;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Device complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Device">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *         &lt;element name="productName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="monitor" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="memory" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="memorycard" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="maincamera" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="subCamera" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="os" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="chipset" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="chipName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="color" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="battery" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="price" type="{http://www.w3.org/2001/XMLSchema}positiveInteger"/>
 *         &lt;element name="catalogID" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *         &lt;element name="brandID" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *         &lt;element name="imageLink" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="orderLinkLink" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="status" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="viewTime" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *         &lt;element name="source" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Device", propOrder = {
    "id",
    "productName",
    "monitor",
    "memory",
    "memorycard",
    "maincamera",
    "subCamera",
    "os",
    "chipset",
    "chipName",
    "color",
    "battery",
    "price",
    "catalogID",
    "brandID",
    "imageLink",
    "orderLinkLink",
    "status",
    "viewTime",
    "source"
})
public class Device {

    @XmlElement(required = true)
    protected BigInteger id;
    @XmlElement(required = true)
    protected String productName;
    @XmlElement(required = true)
    protected String monitor;
    @XmlElement(required = true)
    protected String memory;
    @XmlElement(required = true)
    protected String memorycard;
    @XmlElement(required = true)
    protected String maincamera;
    @XmlElement(required = true)
    protected String subCamera;
    @XmlElement(required = true)
    protected String os;
    @XmlElement(required = true)
    protected String chipset;
    @XmlElement(required = true)
    protected String chipName;
    @XmlElement(required = true)
    protected String color;
    @XmlElement(required = true)
    protected String battery;
    @XmlElement(required = true)
    @XmlSchemaType(name = "positiveInteger")
    protected BigInteger price;
    @XmlElement(required = true)
    protected BigInteger catalogID;
    @XmlElement(required = true)
    protected BigInteger brandID;
    @XmlElement(required = true)
    protected String imageLink;
    @XmlElement(required = true)
    protected String orderLinkLink;
    @XmlElement(required = true)
    protected String status;
    @XmlElement(required = true)
    protected BigInteger viewTime;
    @XmlElement(required = true)
    protected String source;

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setId(BigInteger value) {
        this.id = value;
    }

    /**
     * Gets the value of the productName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProductName() {
        return productName;
    }

    /**
     * Sets the value of the productName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProductName(String value) {
        this.productName = value;
    }

    /**
     * Gets the value of the monitor property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMonitor() {
        return monitor;
    }

    /**
     * Sets the value of the monitor property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMonitor(String value) {
        this.monitor = value;
    }

    /**
     * Gets the value of the memory property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMemory() {
        return memory;
    }

    /**
     * Sets the value of the memory property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMemory(String value) {
        this.memory = value;
    }

    /**
     * Gets the value of the memorycard property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMemorycard() {
        return memorycard;
    }

    /**
     * Sets the value of the memorycard property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMemorycard(String value) {
        this.memorycard = value;
    }

    /**
     * Gets the value of the maincamera property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMaincamera() {
        return maincamera;
    }

    /**
     * Sets the value of the maincamera property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMaincamera(String value) {
        this.maincamera = value;
    }

    /**
     * Gets the value of the subCamera property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSubCamera() {
        return subCamera;
    }

    /**
     * Sets the value of the subCamera property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSubCamera(String value) {
        this.subCamera = value;
    }

    /**
     * Gets the value of the os property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOs() {
        return os;
    }

    /**
     * Sets the value of the os property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOs(String value) {
        this.os = value;
    }

    /**
     * Gets the value of the chipset property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getChipset() {
        return chipset;
    }

    /**
     * Sets the value of the chipset property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setChipset(String value) {
        this.chipset = value;
    }

    /**
     * Gets the value of the chipName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getChipName() {
        return chipName;
    }

    /**
     * Sets the value of the chipName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setChipName(String value) {
        this.chipName = value;
    }

    /**
     * Gets the value of the color property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getColor() {
        return color;
    }

    /**
     * Sets the value of the color property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setColor(String value) {
        this.color = value;
    }

    /**
     * Gets the value of the battery property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBattery() {
        return battery;
    }

    /**
     * Sets the value of the battery property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBattery(String value) {
        this.battery = value;
    }

    /**
     * Gets the value of the price property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getPrice() {
        return price;
    }

    /**
     * Sets the value of the price property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setPrice(BigInteger value) {
        this.price = value;
    }

    /**
     * Gets the value of the catalogID property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getCatalogID() {
        return catalogID;
    }

    /**
     * Sets the value of the catalogID property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setCatalogID(BigInteger value) {
        this.catalogID = value;
    }

    /**
     * Gets the value of the brandID property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getBrandID() {
        return brandID;
    }

    /**
     * Sets the value of the brandID property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setBrandID(BigInteger value) {
        this.brandID = value;
    }

    /**
     * Gets the value of the imageLink property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getImageLink() {
        return imageLink;
    }

    /**
     * Sets the value of the imageLink property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setImageLink(String value) {
        this.imageLink = value;
    }

    /**
     * Gets the value of the orderLinkLink property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrderLinkLink() {
        return orderLinkLink;
    }

    /**
     * Sets the value of the orderLinkLink property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrderLinkLink(String value) {
        this.orderLinkLink = value;
    }

    /**
     * Gets the value of the status property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStatus(String value) {
        this.status = value;
    }

    /**
     * Gets the value of the viewTime property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getViewTime() {
        return viewTime;
    }

    /**
     * Sets the value of the viewTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setViewTime(BigInteger value) {
        this.viewTime = value;
    }

    /**
     * Gets the value of the source property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSource() {
        return source;
    }

    /**
     * Sets the value of the source property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSource(String value) {
        this.source = value;
    }

}

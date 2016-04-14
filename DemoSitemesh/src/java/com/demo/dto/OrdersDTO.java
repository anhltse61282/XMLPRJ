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
public class OrdersDTO {

    private String txtFullname;
    private String txtemail;
    private String txtphone;
    private String txtadd;
    private String txtstate;
    private String txtcity;
    private String txtDelFullname;
    private String txtDelemail;
    private String txtDelphone;
    private String txtDeladd;
    private String txtDelstate;
    private String txtDelcity;

    public OrdersDTO() {
    }

    public OrdersDTO(String txtFullname, String txtemail, String txtphone, String txtadd, String txtstate, String txtcity, String txtDelFullname, String txtDelemail, String txtDelphone, String txtDeladd, String txtDelstate, String txtDelcity) {
        this.txtFullname = txtFullname;
        this.txtemail = txtemail;
        this.txtphone = txtphone;
        this.txtadd = txtadd;
        this.txtstate = txtstate;
        this.txtcity = txtcity;
        this.txtDelFullname = txtDelFullname;
        this.txtDelemail = txtDelemail;
        this.txtDelphone = txtDelphone;
        this.txtDeladd = txtDeladd;
        this.txtDelstate = txtDelstate;
        this.txtDelcity = txtDelcity;
    }

    public String getTxtFullname() {
        return txtFullname;
    }

    public void setTxtFullname(String txtFullname) {
        this.txtFullname = txtFullname;
    }

    public String getTxtemail() {
        return txtemail;
    }

    public void setTxtemail(String txtemail) {
        this.txtemail = txtemail;
    }

    public String getTxtphone() {
        return txtphone;
    }

    public void setTxtphone(String txtphone) {
        this.txtphone = txtphone;
    }

    public String getTxtadd() {
        return txtadd;
    }

    public void setTxtadd(String txtadd) {
        this.txtadd = txtadd;
    }

    public String getTxtstate() {
        return txtstate;
    }

    public void setTxtstate(String txtstate) {
        this.txtstate = txtstate;
    }

    public String getTxtcity() {
        return txtcity;
    }

    public void setTxtcity(String txtcity) {
        this.txtcity = txtcity;
    }

    public String getTxtDelFullname() {
        return txtDelFullname;
    }

    public void setTxtDelFullname(String txtDelFullname) {
        this.txtDelFullname = txtDelFullname;
    }

    public String getTxtDelemail() {
        return txtDelemail;
    }

    public void setTxtDelemail(String txtDelemail) {
        this.txtDelemail = txtDelemail;
    }

    public String getTxtDelphone() {
        return txtDelphone;
    }

    public void setTxtDelphone(String txtDelphone) {
        this.txtDelphone = txtDelphone;
    }

    public String getTxtDeladd() {
        return txtDeladd;
    }

    public void setTxtDeladd(String txtDeladd) {
        this.txtDeladd = txtDeladd;
    }

    public String getTxtDelstate() {
        return txtDelstate;
    }

    public void setTxtDelstate(String txtDelstate) {
        this.txtDelstate = txtDelstate;
    }

    public String getTxtDelcity() {
        return txtDelcity;
    }

    public void setTxtDelcity(String txtDelcity) {
        this.txtDelcity = txtDelcity;
    }
    
}

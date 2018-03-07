/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vib.utilities;

/**
 *
 * @author itdev4
 */
public class PaymentDetails {

    private String amount;
    private String productinfo;
    private String firstname;
    private String email;
    private String phone;
    private String Clientcode;//for atom
    private String txnid;//for atom
    private String custacc;//for atom

    public PaymentDetails() {
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getProductinfo() {
        return productinfo;
    }

    public void setProductinfo(String productinfo) {
        this.productinfo = productinfo;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getClientcode() {
        return Clientcode;
    }

    public void setClientcode(String Clientcode) {
        this.Clientcode = Clientcode;
    }

    public String getTxnid() {
        return txnid;
    }

    public void setTxnid(String txnid) {
        this.txnid = txnid;
    }

    public String getCustacc() {
        return custacc;
    }

    public void setCustacc(String custacc) {
        this.custacc = custacc;
    }

}

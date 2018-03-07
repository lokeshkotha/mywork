/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mongo.location;

import java.io.Serializable;

/**
 *
 * @author itdev7
 */
public class PaymentModes implements Serializable {

    private String _id;
    private String paymentModeName;

    public PaymentModes() {
    }

    public PaymentModes(String _id, String paymentModeName) {
        this._id = _id;
        this.paymentModeName = paymentModeName;
    }

    public String getId() {
        return _id;
    }

    public void setId(String _id) {
        this._id = _id;
    }

    public String getPaymentModeName() {
        return paymentModeName;
    }

    public void setPaymentModeName(String paymentModeName) {
        this.paymentModeName = paymentModeName;
    }

}

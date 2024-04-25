package com.example.solidandratiopack2024.Models;

import java.io.Serializable;

public class SolidPack implements Serializable {
    String buyer;
    String method;
    String cartons;
    String poNumber;
    String cartonNumber;
    String upcNumber;
    String pieces;

    public SolidPack() {
    }

    public SolidPack(String buyer, String method) {
        this.buyer = buyer;
        this.method = method;
    }

    public SolidPack(String buyer, String method, String cartons, String poNumber, String cartonNumber, String upcNumber, String pieces) {
        this.buyer = buyer;
        this.method = method;
        this.cartons = cartons;
        this.poNumber = poNumber;
        this.cartonNumber = cartonNumber;
        this.upcNumber = upcNumber;
        this.pieces = pieces;
    }

    public String getBuyer() {
        return buyer;
    }

    public void setBuyer(String buyer) {
        this.buyer = buyer;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getCartons() {
        return cartons;
    }

    public void setCartons(String cartons) {
        this.cartons = cartons;
    }

    public String getPoNumber() {
        return poNumber;
    }

    public void setPoNumber(String poNumber) {
        this.poNumber = poNumber;
    }

    public String getCartonNumber() {
        return cartonNumber;
    }

    public void setCartonNumber(String cartonNumber) {
        this.cartonNumber = cartonNumber;
    }

    public String getUpcNumber() {
        return upcNumber;
    }

    public void setUpcNumber(String upcNumber) {
        this.upcNumber = upcNumber;
    }

    public String getPieces() {
        return pieces;
    }

    public void setPieces(String pieces) {
        this.pieces = pieces;
    }
}

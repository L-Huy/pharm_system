package com.example.entities.enumclass;

public enum invoiceEnum {

    paid("PAID"),
    unpaid("UNPAID"),
    pending("IN PENDING");

    public final String code;
    invoiceEnum(String code) {this.code = code;}
    public String getCode() {return code;}
}

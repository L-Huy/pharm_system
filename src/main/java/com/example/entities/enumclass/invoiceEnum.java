package com.example.entities.enumclass;

public enum invoiceEnum {

    paid("PAID"),
    unpaid("UNPAID");

    public final String code;
    invoiceEnum(String code) {this.code = code;}
    public String getCode() {return code;}
}

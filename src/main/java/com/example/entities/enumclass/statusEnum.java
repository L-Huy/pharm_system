package com.example.entities.enumclass;

public enum statusEnum {
    active("ACTIVE"),
    inactive("INACTIVE"),
    suspend("SUSPEND");

    private final String code;

    statusEnum(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}

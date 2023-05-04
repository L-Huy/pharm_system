package com.example.entities.enumclass;

public enum statusEnum {
    ACTIVE("ACTIVE"),
    INACTIVE("INACTIVE"),
    SUSPEND("SUSPEND");

    private final String code;

    statusEnum(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}

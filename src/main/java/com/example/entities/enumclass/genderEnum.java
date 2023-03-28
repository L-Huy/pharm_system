package com.example.entities.enumclass;

public enum genderEnum {
    MALE("male"),
    FEMALE("female");

    private final String code;
    genderEnum(String code) {
        this.code = code;
    }
    public String getCode() {
        return code;
    }

}

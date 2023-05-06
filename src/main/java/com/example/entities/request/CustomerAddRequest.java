package com.example.entities.request;

import com.example.entities.enumclass.genderEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerAddRequest {
    private String cusName;
    private Integer age;
    private String phoneNum;
    private genderEnum genderCode;
}

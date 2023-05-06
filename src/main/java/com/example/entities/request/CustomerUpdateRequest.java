package com.example.entities.request;

import com.example.entities.enumclass.genderEnum;
import com.example.entities.enumclass.statusEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerUpdateRequest {
    private Long id;
    private String cusName;
    private Integer age;
    private String phoneNum;
    private genderEnum genderCode;
    private statusEnum statusCode;

}

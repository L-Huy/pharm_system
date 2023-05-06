package com.example.entities.request;

import com.example.entities.enumclass.genderEnum;
import com.example.entities.enumclass.statusEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeUpdateRequest {
    private Long id;
    private String empName;
    private Integer age;
    private String phoneNum;
    private String homeAddress;
    private genderEnum genderCode;
    private statusEnum statusCode;
}

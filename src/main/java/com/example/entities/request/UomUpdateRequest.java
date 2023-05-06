package com.example.entities.request;

import com.example.entities.enumclass.statusEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UomUpdateRequest {
    private Long id;
    private String uomName;
    private statusEnum statusCode;

}

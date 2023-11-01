package com.bootcamp.webhtml3.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrangDto {
    private Integer id;
    private String name;
    private String callName;
    private String address;
    private String gender;
    private Integer age;
    private String parent;
}

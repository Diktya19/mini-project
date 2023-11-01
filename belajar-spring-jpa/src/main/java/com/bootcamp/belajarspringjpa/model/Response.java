package com.bootcamp.belajarspringjpa.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
//STEP2
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Response {
    private int code;
    private String mesagge;
    private Object data;
}

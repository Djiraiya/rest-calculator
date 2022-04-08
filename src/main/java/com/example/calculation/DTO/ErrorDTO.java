package com.example.calculation.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ErrorDTO {
    private String error;
    private String status;
    private String path;
}

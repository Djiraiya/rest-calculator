package com.example.calculation.Service;

import com.example.calculation.DTO.ResultDTO;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Service
public class CalculationService {

    public ResultDTO add(BigDecimal firstNumber, BigDecimal secondNumber) {
        return new ResultDTO(firstNumber.add(secondNumber).toString());
    }

    public ResultDTO subtraction(BigDecimal firstNumber, BigDecimal secondNumber) {
        return new ResultDTO(firstNumber.subtract(secondNumber).toString());
    }

    public ResultDTO multiply(BigDecimal firstNumber, BigDecimal secondNumber) {
        return new ResultDTO(firstNumber.multiply(secondNumber).toString());
    }

    public ResultDTO division(BigDecimal firstNumber, BigDecimal secondNumber) {
        return new ResultDTO(firstNumber.divide(secondNumber, 32, RoundingMode.HALF_UP).stripTrailingZeros().toString());
    }

}

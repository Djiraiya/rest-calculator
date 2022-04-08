package com.example.calculation.Controller;

import com.example.calculation.DTO.ResultDTO;
import com.example.calculation.Service.CalculationService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class CalculationController {

    private final CalculationService calculationService;

    @GetMapping("/add")
    @ApiOperation(value = "Returns the sum of two numbers")
    public ResponseEntity<ResultDTO> add(@RequestParam @ApiParam(example = "55") BigDecimal firstNumber,
                                         @RequestParam @ApiParam(example = "44") BigDecimal secondNumber) {
        return new ResponseEntity<>(calculationService.add(firstNumber, secondNumber), HttpStatus.OK);
    }

    @GetMapping("/subtraction")
    @ApiOperation(value = "Returns the difference of two numbers")
    public ResponseEntity<ResultDTO> subtraction(@RequestParam @ApiParam(example = "55") BigDecimal firstNumber,
                                                 @RequestParam @ApiParam(example = "44") BigDecimal secondNumber) {
        return new ResponseEntity<>(calculationService.subtraction(firstNumber, secondNumber), HttpStatus.OK);
    }

    @GetMapping("/multiply")
    @ApiOperation(value = "Returns the product of two numbers")
    public ResponseEntity<ResultDTO> multiply(@RequestParam @ApiParam(example = "0.06") BigDecimal firstNumber,
                                              @RequestParam @ApiParam(example = "3") BigDecimal secondNumber) {
        return new ResponseEntity<>(calculationService.multiply(firstNumber, secondNumber), HttpStatus.OK);
    }

    @GetMapping("/division")
    @ApiOperation(value = "Returns the quotient of two numbers")
    public ResponseEntity<ResultDTO> division(@RequestParam @ApiParam(example = "27") BigDecimal firstNumber,
                                              @RequestParam @ApiParam(example = "50") BigDecimal secondNumber) {
        return new ResponseEntity<>(calculationService.division(firstNumber, secondNumber), HttpStatus.OK);
    }
}

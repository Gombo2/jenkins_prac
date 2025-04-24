package com.ohgiraffers.demo.service;

import org.springframework.stereotype.Service;

import com.ohgiraffers.demo.dto.CalculatorDTO;

@Service
public class CalculatorService {

	public int plusTwoNumbers(CalculatorDTO calculatorDTO) {

		return calculatorDTO.getNum1() + calculatorDTO.getNum2();
	}
}

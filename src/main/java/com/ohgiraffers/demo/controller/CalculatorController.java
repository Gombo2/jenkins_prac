package com.ohgiraffers.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ohgiraffers.demo.dto.CalculatorDTO;
import com.ohgiraffers.demo.service.CalculatorService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class CalculatorController {

	CalculatorService calculatorService;

	@Autowired
	public CalculatorController(CalculatorService calculatorService) {
		this.calculatorService = calculatorService;
	}

	@GetMapping("/health")
	public String healthCheck() {
		return "I'm alive!!123123";
	}

	// //커맨드 객체로 프론트걸 받을거임 -> DTO로 한번에 받기
	// //fetch의 결과로 promise에 담길 성공 결과가 response~DTO. 뒤의 DTO는  num1,num2받을 용도
	// @GetMapping("/plus")
	// public ResponseEntity<CalculatorDTO> plusTwoNumbers(CalculatorDTO calculatorDTO) {
	//
	// 	log.info("calculatorDTO: {}", calculatorDTO);
	// 	int result = calculatorService.plusTwoNumbers(calculatorDTO);
	// 	calculatorDTO.setSum(result);
	//
	// 	return ResponseEntity
	// 			.ok()
	// 			.body(calculatorDTO);
	// }

	/* PostMapping으로 받으려 변환 뒤, 받는 인자 형식을 @RequestBody를 붙여 JSON.stringify를 통해 문자열로 변환
	* ReuqestBody는 string 문자열을 파싱하여 num1값을 꺼내서 자바 객체로 변환시켜줌
	* */
	@PostMapping("/plus")
	public ResponseEntity<CalculatorDTO> plusTwoNumbers(@RequestBody CalculatorDTO calculatorDTO) {
		log.info("calculatorDTO: {}", calculatorDTO);
		int result = calculatorService.plusTwoNumbers(calculatorDTO);
		calculatorDTO.setSum(result);

		return ResponseEntity
			.ok()
			.body(calculatorDTO);
	}
}

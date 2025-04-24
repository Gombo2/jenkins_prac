package com.ohgiraffers.demo.service;

import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CalculatorServiceTest {
	/* 필드 주입을 통해 의존성 주입 */
	@Autowired
	CalculatorService calculatorService;

	private static Stream<Arguments> provideDTOSources() {
		return Stream.of(
			Arguments.of(new CalculatorDTO(1, 2)),
			Arguments.of(new CalculatorDTO(3, 5)),
			Arguments.of(new CalculatorDTO(10, -2))
		);
	}

	@DisplayName("두 수의 합 구하기 테스트")
	@ParameterizedTest
	@MethodSource("provideDTOSources")
	void testTwoNumbers(CalculatorDTO input) {
		int expected = input.getNum1() + input.getNum2();
		int actual = calculatorService.plusTwoNumbers(input);

		Assertions.assertEquals(expected, actual);
	}

}
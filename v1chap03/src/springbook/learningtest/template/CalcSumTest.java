package springbook.learningtest.template;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

public class CalcSumTest {
	Calculator calculator;
	String numFilepath;
	
	@Before
	public void setUp() {
		this.calculator = new Calculator();
		this.numFilepath = getClass().getResource("numbers.txt").getPath();
	}
	
	@Test
	public void sumOfNumbers() throws IOException {
		Calculator calculator = new Calculator();
		assertThat(calculator.calcSum(this.numFilepath), is(10));
	}
	@Test
	public void multiplyOfNumbers() throws IOException {
		Calculator calculator = new Calculator();
		assertThat(calculator.calcSum(this.numFilepath), is(10));
	}
}

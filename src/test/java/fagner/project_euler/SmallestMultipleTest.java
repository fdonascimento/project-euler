package fagner.project_euler;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@TestInstance(Lifecycle.PER_CLASS)
public class SmallestMultipleTest {

	private SmallestMultiple calculator;
	
	@BeforeAll
	public void setup() {
		calculator = new SmallestMultiple();
	}
	
	@Test
	public void calculateTest() {
		//given 
		int firstNumber = 1;
		int secondNumber = 10;
		
		//when
		long result = calculator.calculate(firstNumber, secondNumber);
		
		//then
		assertThat(result).isEqualTo(2520);
	}
	
	@Test
	public void isDivisible_true() {
		//given
		int beginRange = 1;
		int endRange = 10;
		int value = 2520;
		
		//when
		boolean result = calculator.isDivisibleByAll(beginRange, endRange, value);
				
		//then
		assertThat(result).isTrue();
	}
	
	@Test
	public void isDivisible_false() {
		//given
		int beginRange = 1;
		int endRange = 10;
		int value = 2500;
		
		//when
		boolean result = calculator.isDivisibleByAll(beginRange, endRange, value);
				
		//then
		assertThat(result).isFalse();
	}
	
	@ParameterizedTest
	@ValueSource(ints = {2, 3, 5, 7, 11, 13, 17, 19})
	public void isPrime_true(int value) {
		//given
		
		//when
		boolean result = calculator.isPrime(value);
		
		//then
		assertThat(result).isTrue();
	}
	
	@ParameterizedTest
	@ValueSource(ints = {4, 8, 9, 10, 25, 49, 63})
	public void isPrime_False(int value) {
		//given
		
		//when
		boolean result = calculator.isPrime(value);
		
		//then
		assertThat(result).isFalse();
	}
	
	@Test
	public void getNextPrimeFactor_7_11() {
		//given
		int prime = 7;
		
		//when
		int result = calculator.getNextPrimeFactor(prime);
		
		//then
		assertThat(result).isEqualTo(11);
	}
	
	@Test
	public void multiply_list() {
		//given
		List<Long> values = Arrays.asList(2L, 2L, 3L, 5L);
		
		//when
		long result = calculator.multiply(values);
		
		//then
		assertThat(result).isEqualTo(60);
	}
	
	@Test
	public void calculate2_1_5_60() {
		//given
		int firstNumber = 1;
		int secondNumber = 5;
		
		//when
		long result = calculator.calculate2(firstNumber, secondNumber);
		
		//then
		assertThat(result).isEqualTo(60);
	}
	
	@Test
	public void calculate2_1_10_2520() {
		//given
		int firstNumber = 1;
		int secondNumber = 10;
		
		//when
		long result = calculator.calculate2(firstNumber, secondNumber);
		
		//then
		assertThat(result).isEqualTo(2520);
	}
}

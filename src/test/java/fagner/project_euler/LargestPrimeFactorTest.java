package fagner.project_euler;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@TestInstance(Lifecycle.PER_CLASS)
public class LargestPrimeFactorTest {

	private LargestPrimeFactor calculator;
	
	@BeforeAll
	public void setup() {
		calculator = new LargestPrimeFactor();
	}
	
	@Test
	public void calculateTest() {
		//given
		int value = 13195;
		
		//when
		long result = calculator.calculate(value);
		
		//then
		assertThat(result).isEqualTo(29);
	}
	
	@Test
	public void calculateImprovedTest() {
		//given
		int value = 13195;
		
		//when
		long result = calculator.calculateImproved(value);
		
		//then
		assertThat(result).isEqualTo(29);
	}
	
	@Test
	public void getNextPrimeFactorTest() {
		//given
		int value = 13;
		int maxValue = 13195;
		
		//when
		long result = calculator.getNextPrimeFactor(value, maxValue);
		
		//then
		assertThat(result).isEqualTo(29);
	}
	
	@ParameterizedTest
	@ValueSource(ints = {2, 3, 5, 7, 11, 13, 17, 19, 13187})
	public void isPrime_true(int value) {
		//given int value
		
		//when
		boolean result = calculator.isPrime(value);
				
		//then
		assertThat(result).isTrue();
	}
	
	@ParameterizedTest
	@ValueSource(ints = {4, 8, 12, 25, 33, 90, 45, 21, 49, 81})
	public void isPrime_false(int value) {
		//given int value
		
		//when
		boolean result = calculator.isPrime(value);
				
		//then
		assertThat(result).isFalse();
	}
	
	@ParameterizedTest
	@ValueSource(ints = {2, 4, 100, 56, 1288})
	public void isEven_true(int value) {
		//given int value
		
		//when
		boolean result = calculator.isEven(value);
				
		//then
		assertThat(result).isTrue();
	}
	
	@ParameterizedTest
	@ValueSource(ints = {3, 15, 1001, 12345, 77})
	public void isEven_false(int value) {
		//given int value
		
		//when
		boolean result = calculator.isEven(value);
				
		//then
		assertThat(result).isFalse();
	}
	
	@Test
	public void divideUntilIsPossibleByTest() {
		//given
		int value = 13195;
		int primeFactor = 5;
		
		//when
		long result = calculator.divideUntilIsPossible(value, primeFactor);
		
		assertThat(result).isEqualTo(2639);
	}
}

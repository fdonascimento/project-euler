package fagner.project_euler;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class Find1001stPrimeTest {
	
	private Find1001stPrime calculator = new Find1001stPrime();
	
	@BeforeEach
	public void setup() {
		calculator = new Find1001stPrime();
	}
	
	@Test
	public void calculate_6_13() {
		//given
		int n = 6;
		
		//when
		long result = calculator.calculate(n);
		
		//then
		assertThat(result).isEqualTo(13);
	}
	
	@Test
	public void calculate_1_2() {
		//given
		int n = 1;
		
		//when
		long result = calculator.calculate(n);
		
		//then
		assertThat(result).isEqualTo(2);
	}
	
	@ParameterizedTest
	@ValueSource(ints = {4, 8, 20, 81, 27, 49, 10005})
	public void isPrime_false(int value) {
		//when
		boolean result = calculator.isPrime(value);
		
		//then
		assertThat(result).isFalse();
	}
	
	@ParameterizedTest
	@ValueSource(ints = {2, 3, 7, 11, 13, 5, 109, 113, 199})
	public void isPrime_true(int value) {
		//when
		boolean result = calculator.isPrime(value);
		
		//then
		assertThat(result).isTrue();
	}
	
	@Test
	public void getNextPrime_2_3() {
		//given
		int previousPrime = 2;
		
		
		//when
		long result = calculator.getNexPrime(previousPrime);
		
		//then
		assertThat(result).isEqualTo(3);
	}
	
	@Test
	public void getNextPrime_5_7() {
		//given
		int previousPrime = 5;
		
		
		//when
		long result = calculator.getNexPrime(previousPrime);
		
		//then
		assertThat(result).isEqualTo(7);
	}
	
	@Test
	public void getNextPrime_67_71() {
		//given
		int previousPrime = 67;
		
		
		//when
		long result = calculator.getNexPrime(previousPrime);
		
		//then
		assertThat(result).isEqualTo(71);
	}
	
	@Test
	public void getNextPrime_157_163() {
		//given
		int previousPrime = 157;
		
		
		//when
		long result = calculator.getNexPrime(previousPrime);
		
		//then
		assertThat(result).isEqualTo(163);
	}
}

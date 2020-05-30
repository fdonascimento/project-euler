package fagner.project_euler;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LargestPalindromeProductTest {

	private LargestPalindromeProduct calculator;
	
	@BeforeEach
	public void setup() {
		calculator = new LargestPalindromeProduct();
	}
	
	@Test
	public void calculate_2_9009() {
		//given
		int numberOfDigits = 2;
		
		//when
		long result = calculator.calculate(numberOfDigits);
		
		//then
		assertThat(result).isEqualTo(9009);
	}
	
	@Test
	public void calculate_1_9() {
		//given
		int numberOfDigits = 1;
		
		//when
		long result = calculator.calculate(numberOfDigits);
		
		//then
		assertThat(result).isEqualTo(9);
	}
	
	@Test
	public void getNextMaxPalindrome_4_99999() {
		//given
		int power = 4;
		
		//when
		long result = calculator.getMaxPalindrome(power);
		
		//then
		assertThat(result).isEqualTo(99999);
	}
	
	@Test
	public void getNextMaxPalindrome_0_9() {
		//given
		int power = 0;
		
		//when
		long result = calculator.getMaxPalindrome(power);
		
		//then
		assertThat(result).isEqualTo(9);
	}
	
	@Test
	public void getNextMaxPalindrome_2_999() {
		//given
		int power = 2;
		
		//when
		long result = calculator.getMaxPalindrome(power);
		
		//then
		assertThat(result).isEqualTo(999);
	}


	@Test
	public void getMaxFactor_90009_219( ) {
		//given
		int number = 90009;
		
		//when
		long result = calculator.getMaxFactor(number);
		
		//then
		assertThat(result).isEqualTo(219);
	}

	@Test
	public void countDigits_90009_5( ) {
		//given
		int number = 90009;
		
		//when
		long result = calculator.countDigits(number);
		
		//then
		assertThat(result).isEqualTo(5);
	}
	
	@ParameterizedTest
	@ValueSource(ints = {0, 5, 9, 11, 22, 99, 2002, 30003, 888, 5555, 999999, 900009, 90909, 8080808})
	public void isPalindrome_true(int value) {
		//given int value
		
		//when
		boolean result = calculator.isPalindrome(value);
				
		//then
		assertThat(result).isTrue();
	}
	
	@ParameterizedTest
	@ValueSource(ints = {91, 2202, 323333, 8218, 2555, 999099})
	public void isPalindrome_false(int value) {
		//given int value
		
		//when
		boolean result = calculator.isPalindrome(value);
				
		//then
		assertThat(result).isFalse();
	}
}

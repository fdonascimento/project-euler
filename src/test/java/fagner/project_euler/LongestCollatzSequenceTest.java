package fagner.project_euler;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class LongestCollatzSequenceTest {
	
	private LongestCollatzSequence calculator;
	
	@BeforeEach
	public void setup() {
		calculator = new LongestCollatzSequence();
	}
	
	@Test
	public void calculate_13_9() {
		//given
		int startNumber = 13;
		
		//when
		long result = calculator.calculate(startNumber);
		
		//then
		assertThat(result).isEqualTo(9);
	}
}

package fagner.project_euler;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class FibonacciEvenNumbersSumTest {

	@Test
	public void calculateTest() {
		//given
		int maxValueTerm = 89;
		FibonacciEvenNumbersSum calculator = new FibonacciEvenNumbersSum();
		
		//when
		long result = calculator.calculate(maxValueTerm);
		
		//then
		assertThat(result).isEqualTo(44L);
	}
}

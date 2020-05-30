package fagner.project_euler;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class SummationPrimeTest {

	@Test
	public void calculate_10_17() {
		//given
		SummationPrimes calculator = new SummationPrimes();
		int limit = 10;
		
		//when
		long result = calculator.calculate(limit);
		
		//then
		assertThat(result).isEqualTo(17);
	}
}

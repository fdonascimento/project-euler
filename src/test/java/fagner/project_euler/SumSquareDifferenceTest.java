package fagner.project_euler;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class SumSquareDifferenceTest {

	@Test
	public void calculateTest() {
		//given 
		int limit = 10;
		
		//when
		SumSquareDifference calculator = new SumSquareDifference();
		long result = calculator.calculate(limit);
		
		//then
		assertThat(result).isEqualTo(2640);
	}
}

package fagner.project_euler;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class Multiples3Or5Test {

	@Test
	public void calculateUsingForLoopTest() {
		//given 
		int value = 10;
		
		//when
		Multiples3Or5 calculator = new Multiples3Or5(value);
		long result = calculator.calculateUsingForLoop();
		
		//then
		assertThat(result).isEqualTo(23);
	}
	
	@Test
	public void calculateUsingArithmeticSequenceTest() {
		//given 
		int value = 10;
		
		//when
		Multiples3Or5 calculator = new Multiples3Or5(value);
		long result = calculator.calculateUsingArithmeticSequence();
		
		//then
		assertThat(result).isEqualTo(23);
	}
	
	@Test
	public void calculateUsingArithmeticSerieTest() {
		//given 
		int value = 10;
		
		//when
		Multiples3Or5 calculator = new Multiples3Or5(value);
		long result = calculator.calculateUsingArithmeticSerie();
		
		//then
		assertThat(result).isEqualTo(23);
	}
}

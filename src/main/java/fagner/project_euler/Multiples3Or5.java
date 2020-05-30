package fagner.project_euler;

import java.util.Calendar;

public class Multiples3Or5 {

	private long maxNumber;
	
	public Multiples3Or5(long maxNumber) {
		this.maxNumber = maxNumber;
	}
	
	/**
	 * I have to study PA to try to solve this problem with O(1) complexity.
	 * The current Complexity is O(n).
	 * @param
	 */
	public long calculateUsingForLoop() {
		long sum = 0;
		for (long i = 3L; i <maxNumber; i++) {
			if ((i % 3 == 0) || (i % 5 == 0)) {
				sum += i;
			}
		}
		return sum;
	}
	
	/**
	 * The performance improved drastically with this method. However the complexity still is O(n)
	 * @param value
	 * @return
	 */
	public long calculateArithmeticSequence(long value) {
		long sum = 0;
		for (long i = value; i <maxNumber; i+=value) {
			sum += i;
		}
		return sum;
	}
	
	public long calculateUsingArithmeticSequence() {
		long sumMultiples3 = calculateArithmeticSequence(3);
		long sumMultiples5 = calculateArithmeticSequence(5);
		long sumMultiples15 = calculateArithmeticSequence(15);
		return sumMultiples3 + sumMultiples5 - sumMultiples15;
	}
	
	/**
	 * Way better than the others
	 * O(1) complexity
	 * The result takes less than 1ms to be found no matter how much is the input size
	 * @return
	 */
	public long calculateUsingArithmeticSerie() {
		long sumMultiplesBy3 = calculateSerie(3);
		long sumMultiplesBy5 = calculateSerie(5);
		long sumMultiplesBy15 = calculateSerie(15);
		return sumMultiplesBy3 + sumMultiplesBy5 - sumMultiplesBy15;
	}
	
	/**
	 * 3 + 6 +9 = 3 * (1+2+3)
	 * 
	 * @param pattern
	 * @return
	 */
	private long calculateSerie(int pattern) {
		long n = (maxNumber-1) / pattern;
		return pattern * (n * (n + 1) / 2);
	}
	
	public static void main(String args[]) {
		Multiples3Or5 multiples3Or5 = new Multiples3Or5(1_000_000_000_000_000_000L);
//		Multiples3Or5 multiples3Or5 = new Multiples3Or5(1_000);
		
		long startTime = Calendar.getInstance().getTimeInMillis();
//		long firstResult = multiples3Or5.calculateUsingForLoop();
		long endTime = Calendar.getInstance().getTimeInMillis();
//		System.out.println("First Result = "+firstResult +" | time in ms = "+(endTime-startTime));
//		
//		startTime = Calendar.getInstance().getTimeInMillis();
//		long seconndResult = multiples3Or5.calculateUsingArithmeticSequence();
//		endTime = Calendar.getInstance().getTimeInMillis();
//		System.out.println("Second Result = "+seconndResult +" | time in ms = "+(endTime-startTime));
		
		startTime = Calendar.getInstance().getTimeInMillis();
		long thirdResult = multiples3Or5.calculateUsingArithmeticSerie();
		endTime = Calendar.getInstance().getTimeInMillis();
		System.out.println("Third Result = "+thirdResult +" | time in ms = "+(endTime-startTime));
	}
}

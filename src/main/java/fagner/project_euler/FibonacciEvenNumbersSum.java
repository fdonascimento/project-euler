package fagner.project_euler;

import java.util.Calendar;

public class FibonacciEvenNumbersSum {

	/**
	 * Time complexity = O(log(n))
	 * The term values increase exponentially, although the numbers of iteration increase linearly.
	 * @param maxValueTerm
	 * @return
	 */
	public long calculate(long maxValueTerm) {
		long previousTerm = 1;
		long currentTerm = 2;
		System.out.print(previousTerm+" ");
		
		long sum = 0;
		while (currentTerm <= maxValueTerm) {
			System.out.print(currentTerm+" ");
			if (currentTerm % 2 == 0) {
				sum += currentTerm;
			}
			
			long temp = previousTerm;
			previousTerm = currentTerm;
			currentTerm += temp;
		}
		
		return sum;
	}
	
	public static void main(String args[]) {
		FibonacciEvenNumbersSum calculator = new FibonacciEvenNumbersSum();
		long startTime = Calendar.getInstance().getTimeInMillis();
		long result = calculator.calculate(4_000_000_000_000_000_000L);
		long endTime = Calendar.getInstance().getTimeInMillis();
		System.out.println("\n"+result);
		
		System.out.println("Result = "+result +" | time in ms = "+(endTime-startTime));
	}
}

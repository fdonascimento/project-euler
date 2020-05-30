package fagner.project_euler;

import java.util.Calendar;

public class SumSquareDifference {

	/**
	 * Time complexity = O(n)
	 * @param limit
	 * @return
	 */
	public long calculate(long limit) {
		long sumSquare = 0;
		long sum = limit * (limit + 1) / 2;
		for (long i = 1; i <= limit; ++i) {
			sumSquare += Math.pow(i, 2);
		}
		
		long squareOfTheSum = (long) Math.pow(sum, 2);
		return squareOfTheSum - sumSquare;
	}
	
	public static void main(String args[]) {
		SumSquareDifference calculator = new SumSquareDifference();
		long startTime = Calendar.getInstance().getTimeInMillis();
		long result = calculator.calculate(10);
		long endTime = Calendar.getInstance().getTimeInMillis();
		
		System.out.println("Result = "+result +" | time in ms = "+(endTime-startTime));
		
		startTime = Calendar.getInstance().getTimeInMillis();
		result = calculator.calculate(100);
		endTime = Calendar.getInstance().getTimeInMillis();
		
		System.out.println("Result = "+result +" | time in ms = "+(endTime-startTime));
	}
}

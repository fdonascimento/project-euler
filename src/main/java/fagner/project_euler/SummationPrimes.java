package fagner.project_euler;

import java.util.Calendar;

public class SummationPrimes {

	/**
	 * Time complexity = O(n.log(n))
	 * @param limit
	 * @return
	 */
	public long calculate(long limit) {
		long sum = 2;
		for (long i = 3; i < limit; i+=2) {
			if (isPrime(i)) {
				sum += i;
			}
		}
		return sum;
	}
	
	boolean isPrime(long value) {
		long factor = (long) Math.sqrt(value);
		for (long i = factor; i > 1; i--) {
			if (value % i == 0) {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String args[]) {
		SummationPrimes calculator = new SummationPrimes();
		long startTime = Calendar.getInstance().getTimeInMillis();
		long result = calculator.calculate(2_000_000);
		long endTime = Calendar.getInstance().getTimeInMillis();
		System.out.println("Result = "+result +" | time in ms = "+(endTime-startTime));
	}
}

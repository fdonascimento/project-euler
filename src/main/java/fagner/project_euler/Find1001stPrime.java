package fagner.project_euler;

import java.util.Calendar;

public class Find1001stPrime {

	long calculate(long n) {
		long result = 2;
		for (long i = 1; i < n; ++i) {
			result = getNexPrime(result);
		}
		return result;
	}
	
	long getNexPrime(long previousPrime) {
		if (previousPrime == 2) {
			return 3;
		}
		
		for (long i = previousPrime+=2; ; i+=2) {
			if (isPrime(i)) {
				return i;
			}
		}
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
		Find1001stPrime calculator = new Find1001stPrime();
		long startTime = Calendar.getInstance().getTimeInMillis();
		long result = calculator.calculate(10_001);
		long endTime = Calendar.getInstance().getTimeInMillis();
		
		System.out.println("Result = "+result +" | time in ms = "+(endTime-startTime));
	}
}

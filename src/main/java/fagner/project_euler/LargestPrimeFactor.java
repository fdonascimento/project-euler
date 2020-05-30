package fagner.project_euler;

import java.util.Calendar;

public class LargestPrimeFactor {

	/**
	 * The time complexity is O(n)
	 * @param value
	 * @return
	 */
	public long calculate(long value) {
		long largestPrimeFactor = 1;
		
		long result = value;
		do {
			largestPrimeFactor = getNextPrimeFactor(largestPrimeFactor, result);
			result = divideUntilIsPossible(result, largestPrimeFactor);
		} while (result != 1);
		
		return largestPrimeFactor;
	}
	
	/**
	 * The time complexity is O(log(n))
	 * @param value
	 * @return
	 */
	public long calculateImproved(long value) {
		long maxFactor = (int) Math.sqrt(value);
		long largestPrimeFactor = 1;
		
		long result = value;
		do {
			largestPrimeFactor = getNextPrimeFactor(largestPrimeFactor, maxFactor, result);
			if (largestPrimeFactor == 1) {
				return value;
			}
			result = divideUntilIsPossible(result, largestPrimeFactor);
		} while (result != 1);
		
		return largestPrimeFactor;
	}
	
	long divideUntilIsPossible(long value, long primeFactor) {
		if (primeFactor == 1) {
			throw new IllegalArgumentException();
		}
		
		if (value % primeFactor == 0) {
			long result = value / primeFactor;
			return divideUntilIsPossible(result, primeFactor);
		} else {
			return value;
		}
	}
	
	long getNextPrimeFactor(long lastPrimeFactor, long maxValue) {
		return getNextPrimeFactor(lastPrimeFactor, maxValue, maxValue);
	}
	
	long getNextPrimeFactor(long lastPrimeFactor, long maxValue, long value) {
		for (long i = lastPrimeFactor+1; i <= maxValue; i++) {
			if (value % i == 0) {
				return i;
			}
		}
		return 1;
	}
	
	boolean isPrime(long value) {
		if (value != 2 && isEven(value)) {
			return false;
		}
		for (long i = 3; i < value; i+=2) {
			if (value % i == 0) {
				return false;
			}
		}
		return true;
	}
	
	boolean isEven(long value) {
		return value % 2 == 0;
	}
	
	public static void main(String args[]) {
		LargestPrimeFactor calculator = new LargestPrimeFactor();
		long startTime = Calendar.getInstance().getTimeInMillis();
		long result = calculator.calculate(600851475143L); // number from project euler 
//		long result = calculator.calculate(32416190071L); // big prime number
//		long result = calculator.calculate(179426549);
		long endTime = Calendar.getInstance().getTimeInMillis();
		System.out.println("Result first solution= "+result +" | time in ms = "+(endTime-startTime));
		
		startTime = Calendar.getInstance().getTimeInMillis();
//		result = calculator.calculateImproved(600851475143L); // number from project euler 
		result = calculator.calculateImproved(32416190071L); // big prime number
//		result = calculator.calculateImproved(179426549);
		endTime = Calendar.getInstance().getTimeInMillis();
		System.out.println("Result second solution= "+result +" | time in ms = "+(endTime-startTime));
	}
}

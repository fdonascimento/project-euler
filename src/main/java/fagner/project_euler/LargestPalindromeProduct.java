package fagner.project_euler;

import java.util.Calendar;

public class LargestPalindromeProduct {

	/**
	 * Time complexity is O(n²) when multiply the maxFactor x maxFactor 
	 * The iteration will increase drastically. I have to find a time complexity more accurate because the time complexity is worse than that.  
	 * @param numberOfDigits
	 * @return
	 */
	public long calculate(int numberOfDigits) {
		long minFactor = (long) Math.pow(10, numberOfDigits-1);
		long maxFactor = (long) getMaxPalindrome(numberOfDigits-1);
		
		
		long maxNumber = maxFactor * maxFactor;
		long minNumber = (minFactor * minFactor)+1;
		
		for (long number = maxNumber; number >= minNumber; number--) {
			if (isPalindrome(number)) {
				long firstFactor = getMaxFactor(number);
				if (countDigits(firstFactor) == numberOfDigits) {
					long secondFactor = number / firstFactor;
					if (countDigits(secondFactor) == numberOfDigits) {
						return number;
					}
				}
			}
		}
		
		return 0;
	}
	
	boolean isPalindrome(long result) {
		StringBuilder digits = new StringBuilder();
		digits.append(result);
		
		return digits.toString().equals(digits.reverse().toString());
	}
	
	int countDigits(long number) {
		return String.valueOf(number).length();
	}
	
	long getMaxFactor(long value) {
		long factor = (long) Math.sqrt(value);
		while (value % factor != 0) {
			factor--;
		}
		
		return factor;
	}
	
	long getMaxPalindrome(long power) {
		if (power == 0) {
			return 9;
		}
		
		long currentResult = (long)(Math.pow(10, power) * 9);
		return currentResult + getMaxPalindrome(power-1);
	}
	
	public static void main(String args[]) {
		LargestPalindromeProduct calculator = new LargestPalindromeProduct();
		long startTime = Calendar.getInstance().getTimeInMillis();
		long result = calculator.calculate(6);
		long endTime = Calendar.getInstance().getTimeInMillis();
		System.out.println(result);
		
		System.out.println("Result = "+result +" | time in ms = "+(endTime-startTime));
	}
}
 
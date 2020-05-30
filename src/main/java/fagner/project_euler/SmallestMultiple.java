package fagner.project_euler;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class SmallestMultiple {

	/**
	 * Time complexity = O(n²)
	 * @param firstNumber
	 * @param secondNumber
	 * @return
	 */
	public int calculate(int firstNumber, int secondNumber) {
		int i = 10;
		
		do {
			i+=2;
		} while(!isDivisibleByAll(firstNumber, secondNumber, i));
		
		return i;
	}
	
	/**
	 * Time Complexity = O(n)
	 * @param firstNumber
	 * @param secondNumber
	 * @return
	 */
	public long calculate2(int firstNumber, int secondNumber) {
		List<Long> values = new ArrayList<>();
		for (long i = firstNumber; i <= secondNumber; i++) {
			values.add(i);
		}
		
		int i = 0;
		int primeFactor = 2;
		int indivisibles = 0;
		List<Long> primeFactors = new ArrayList<>();
		long matchPrime = 1;
		while (values.size() > 0) {
			long value = values.get(i);
			
			if (value == 1) {
				values.remove(i);
			} else if (value % primeFactor == 0) {
				matchPrime = primeFactor;
				long division = value / primeFactor;
				if (division == 1) {
					values.remove(i);
				} else {
					values.set(i, division);
					i++;
				}
			} else {
				indivisibles++;
				i++;
			}
			if (i == values.size()) {
				if (matchPrime > 1) {
					primeFactors.add(matchPrime);
					matchPrime = 1;
				}
				i = 0;
				if (indivisibles == values.size()) {
					primeFactor = getNextPrimeFactor(primeFactor);
				}
				indivisibles = 0;
				
			}
		}
		
		return multiply(primeFactors);
	}
	long multiply(List<Long> values) {
		return values.stream().reduce((value, accumulator) -> accumulator * value).get();
	}
	
	int getNextPrimeFactor(int prime) {
		int nextPrime = prime;
		do {
			nextPrime++;
		} while (!isPrime(nextPrime));
		return nextPrime;
	}
	
	boolean isPrime(int value) {
		if (value == 2 || value == 3) {
			return true;
		} else if (value % 2 == 0) {
			return false;
		}
		int sqrt = (int) Math.sqrt(value);
		for (int i = sqrt; sqrt > 0; sqrt--) {
			if (value % i == 0) {
				return false;
			}
		}
		
		return true;
	}
	
	boolean isDivisibleByAll(int beginRange, int endRnge, int number) {
		for (int i = beginRange; i <=endRnge; ++i) {
			if (number % i != 0) {
				return false;
			}
		}
		
		return true;
	}
	
	public static void main(String args[]) {
		SmallestMultiple calculator = new SmallestMultiple();
		long startTime = Calendar.getInstance().getTimeInMillis();
		long result = calculator.calculate(1, 20);
		long endTime = Calendar.getInstance().getTimeInMillis();
		
		System.out.println("Result = "+result +" | time in ms = "+(endTime-startTime));
		
		startTime = Calendar.getInstance().getTimeInMillis();
		result = calculator.calculate2(1, 20);
		endTime = Calendar.getInstance().getTimeInMillis();
		
		System.out.println("Result = "+result +" | time in ms = "+(endTime-startTime));
	}
}

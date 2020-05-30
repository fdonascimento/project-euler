package fagner.project_euler;

import java.util.Calendar;

public class PythagoreanTriplet {

	/**
	 * Time complexity: O(n²)
	 * @return
	 */
	public int calculate() {
		for (int a = 0; a < 1000; a++) {
			for (int b = 0; b < 1000; b++) {
				int result = (int) (Math.pow(a, 2) + Math.pow(b, 2));
				double c =  Math.sqrt(result);
				if ((a < b && b < c) && ((a+b+c) == 1000)) {
					System.out.println("a: "+a+" | b: "+b+" | c: "+c);
					return (int) (a*b*c);
				}
			}
		}
		return 0;
	}
	
	public static void main(String args[]) {
		PythagoreanTriplet calculator = new PythagoreanTriplet();
		long startTime = Calendar.getInstance().getTimeInMillis();
		int result = calculator.calculate();
		long endTime = Calendar.getInstance().getTimeInMillis();
		
		System.out.println("Result = "+result +" | time in ms = "+(endTime-startTime));
	}
}

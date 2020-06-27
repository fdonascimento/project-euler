package fagner.project_euler;

import fagner.project_euler.util.CollatzSequence;

import java.util.ArrayList;
import java.util.Calendar;

public class LongestCollatzSequence {

    public int calculate(int lastNumber) {
        CollatzSequence largestSequence = CollatzSequence.getSequence(1);

        for (int i = 2; i <= lastNumber; i++) {
            CollatzSequence collatzSequence = CollatzSequence.getSequence(i);
            if (!collatzSequence.isReferencedByTwoTerms()) {
                if (collatzSequence.largerThan(largestSequence)) {
                    largestSequence = collatzSequence;
                }
            }
        }

        return largestSequence.getStartNumber();
    }

    public static void main(String[] args) {
        LongestCollatzSequence calculator = new LongestCollatzSequence();
        long startTime = Calendar.getInstance().getTimeInMillis();
        int result = calculator.calculate(200_000);
        long endTime = Calendar.getInstance().getTimeInMillis();
		System.out.println("Result = "+result +" | time in ms = "+(endTime-startTime));
    }
}

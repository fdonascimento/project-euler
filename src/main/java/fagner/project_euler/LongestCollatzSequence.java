package fagner.project_euler;

import fagner.project_euler.util.CollatzSequence;

import java.util.*;

/**
 * @since 20/06/2020
 */
public class LongestCollatzSequence {

    /**
     * Time complexity:
     * @param lastNumber
     * @return
     */
    public long calculate(int lastNumber) {
        CollatzSequence largestSequence = CollatzSequence.getSequence(1);

        for (long i = 2; i <= lastNumber; i++) {
            CollatzSequence collatzSequence = CollatzSequence.getSequence(i);
            if (!collatzSequence.isReferencedByTwoTerms()) {
                if (collatzSequence.largerThan(largestSequence)) {
                    largestSequence = collatzSequence;
                }
            }
        }

        System.out.println("Iterations = "+CollatzSequence.iterations);
        return largestSequence.getStartNumber();
    }

    public static void main(String[] args) {
        LongestCollatzSequence calculator = new LongestCollatzSequence();
        long startTime = Calendar.getInstance().getTimeInMillis();
        long result = calculator.calculate(1_000_000);
        long endTime = Calendar.getInstance().getTimeInMillis();
		System.out.println("Result = "+result +" | time in ms = "+(endTime-startTime));
    }
}

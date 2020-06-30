package fagner.project_euler;

import java.util.*;

/**
 * @since 20/06/2020
 */
public class LongestCollatzSequence {

    /**
     * Time complexity: O(n)
     * @param lastNumber
     * @return
     */
    public long calculate(int lastNumber) {
        int largestSequence = 1;
        long numberWithLargestSequence = 1;

        LinkedHashSet<Long> items = createItemsSet(lastNumber);

        int iterations = 0;
        while(!items.isEmpty()) {
            iterations++;
            long startNumber = items.stream().findFirst().get();
            items.remove(startNumber);

            int numberOfTerms = calculateNumberOfTerms(items, startNumber);

            if (numberOfTerms > largestSequence) {
                numberWithLargestSequence = startNumber;
                largestSequence = numberOfTerms;
            }
        }

        System.out.println("Iterations = "+iterations);
        return numberWithLargestSequence;
    }

    private LinkedHashSet<Long> createItemsSet(int lastNumber) {
        LinkedHashSet<Long> items = new LinkedHashSet<>();
        for (long i = lastNumber; i >= 1; i--) {
            items.add(i);
        }
        return items;
    }

    private int calculateNumberOfTerms(LinkedHashSet<Long> items, long startNumber) {
        long nextTerm = startNumber;
        int countSequence = 1;

        while(nextTerm != 1) {
            nextTerm = calculateNextTerm(nextTerm);
            countSequence++;
            items.remove(nextTerm);
        }
        return countSequence;
    }

    private long calculateNextTerm(long nextTerm) {
        if (nextTerm % 2 == 0) {
            nextTerm =  nextTerm / 2;
        } else {
            nextTerm = (nextTerm * 3) + 1;
        }
        return nextTerm;
    }

    public static void main(String[] args) {
        LongestCollatzSequence calculator = new LongestCollatzSequence();
        long startTime = Calendar.getInstance().getTimeInMillis();
        long result = calculator.calculate(1_000_000);
        long endTime = Calendar.getInstance().getTimeInMillis();
		System.out.println("Result = "+result +" | time in ms = "+(endTime-startTime));
    }
}

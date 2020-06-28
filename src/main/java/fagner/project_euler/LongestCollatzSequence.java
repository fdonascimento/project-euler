package fagner.project_euler;

import fagner.project_euler.util.CollatzSequence;

import java.util.*;

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

    public int calculate2(int lastNumber) {
        int largestSequence = 1;
        int numberLargestSequence = 1;

        Stack<Integer> items = new Stack<>();
        for (int i = 1; i <= lastNumber; i++) {
            items.push(i);
        }

        int iterations = 0;
        while(!items.empty()) {
            iterations++;
            int startNumber = items.pop();

            int nextTerm = startNumber;
            int countSequence = 1;
            while(nextTerm != 1) {
                if (nextTerm % 2 == 0) {
                    nextTerm =  nextTerm / 2;
                } else {
                    nextTerm = (nextTerm * 3) + 1;
                }
                countSequence++;
                items.removeElement(nextTerm);
            }

            if (countSequence > largestSequence) {
                numberLargestSequence = startNumber;
                largestSequence = countSequence;
            }
        }

        System.out.println("Iterations = "+iterations);
        return numberLargestSequence;
    }

    public int calculate3(int lastNumber) {
        int largestSequence = 1;
        int numberLargestSequence = 1;

        LinkedHashSet<Integer> items = new LinkedHashSet<>();
        for (int i = lastNumber; i >= 1; i--) {
            items.add(i);
        }

        int iterations = 0;
        while(!items.isEmpty()) {
            iterations++;
            int startNumber = items.stream().findFirst().get();
            items.remove(startNumber);

            int nextTerm = startNumber;
            int countSequence = 1;
            while(nextTerm != 1) {
                if (nextTerm % 2 == 0) {
                    nextTerm =  nextTerm / 2;
                } else {
                    nextTerm = (nextTerm * 3) + 1;
                }
                countSequence++;
                items.remove(nextTerm);
            }

            if (countSequence > largestSequence) {
                numberLargestSequence = startNumber;
                largestSequence = countSequence;
            }
        }

        System.out.println("Iterations = "+iterations);
        return numberLargestSequence;
    }

    public static void main(String[] args) {
        LongestCollatzSequence calculator = new LongestCollatzSequence();
        long startTime = Calendar.getInstance().getTimeInMillis();
        int result = calculator.calculate3(500_000);
        long endTime = Calendar.getInstance().getTimeInMillis();
		System.out.println("Result = "+result +" | time in ms = "+(endTime-startTime));
    }
}

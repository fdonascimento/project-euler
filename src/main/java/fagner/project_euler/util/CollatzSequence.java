package fagner.project_euler.util;

import java.util.HashMap;
import java.util.Map;

public class CollatzSequence {

    private static Map<Integer, CollatzSequence> sequenceMap = new HashMap<>();
    private int startNumber;
    private int numberOfTerms;
    private CollatzSequence nextSequence;

    public CollatzSequence(int startNumber) {
        this.startNumber = startNumber;
    }

    public int getStartNumber() {
        return startNumber;
    }

    public int getNumberOfTerms() {
        return numberOfTerms;
    }

    public boolean largerThan(CollatzSequence other) {
        return this.numberOfTerms > other.numberOfTerms;
    }

    public void printSequence() {
        System.out.print(startNumber+ " ");
        if (nextSequence != null ) {
            nextSequence.printSequence();
        }
    }

    public void calculateSequence() {
        if (startNumber == 1) {
            nextSequence = null;
            numberOfTerms = 1;
        } else {
            int nextTerm = calculateNextTerm();
            nextSequence = getSequenceFromMap(nextTerm);
            if (nextSequence == null) {
                 nextSequence = new CollatzSequence(nextTerm);
                 nextSequence.calculateSequence();
            }
            numberOfTerms = 1 + nextSequence.getNumberOfTerms();
        }
        sequenceMap.put(startNumber, this);
    }

    int calculateNextTerm() {
        if (startNumber % 2 == 0) {
            return startNumber / 2;
        } else {
            return (startNumber * 3) + 1;
        }
    }

    CollatzSequence getSequence(int number) {
        if (startNumber == number) {
            return this;
        } else if (nextSequence != null) {
            return nextSequence.getSequence(number);
        } else {
            return null;
        }
    }

    CollatzSequence getSequenceFromMap(int number) {
        if (sequenceMap.isEmpty()) {
            return null;
        }

        CollatzSequence sequence = sequenceMap.get(number);
        if (sequence != null) {
            return sequence;
        }

        for (CollatzSequence value : sequenceMap.values()) {
            return value.getSequence(number);
        }

        return null;
    }
}

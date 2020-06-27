package fagner.project_euler.util;

import java.util.HashMap;
import java.util.Map;

public class CollatzSequence {

    private static Map<Integer, CollatzSequence> sequenceMap = new HashMap<>();
    private int startNumber;
    private int numberOfTerms;
    private CollatzSequence nextSequence;
    private int references;

    private CollatzSequence(int startNumber) {
        this.startNumber = startNumber;
    }

    public boolean isReferencedByTwoTerms() {
        return references == 2;
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

    private void calculateSequence() {
        if (startNumber == 1) {
            nextSequence = null;
            numberOfTerms = 1;
        } else {
            int nextTerm = calculateNextTerm();
            nextSequence = getSequence(nextTerm);
            numberOfTerms = 1 + nextSequence.getNumberOfTerms();
        }
    }

    int calculateNextTerm() {
        if (startNumber % 2 == 0) {
            return startNumber / 2;
        } else {
            return (startNumber * 3) + 1;
        }
    }

    public static CollatzSequence getSequence(int number) {
        CollatzSequence sequence;
        sequence = sequenceMap.get(number);
        if (sequence == null) {
            sequence = new CollatzSequence(number);
            sequence.calculateSequence();
            sequenceMap.put(number, sequence);
        } else {
            sequence.references++;
        }
        if (sequence.references == 2) {
            sequenceMap.remove(number);
        }
        return sequence;
    }
}

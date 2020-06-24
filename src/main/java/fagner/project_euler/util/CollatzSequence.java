package fagner.project_euler.util;

import java.util.HashMap;
import java.util.Map;

public class CollatzSequence {

    private static Map<Integer, CollatzSequence> sequenceMap = new HashMap<>();
    private static int currentSequence;
    private int startNumber;
    private int numberOfTerms;
    private CollatzSequence nextSequence;
    private CollatzSequence lastNotCalculated;

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

    public void addTerms(int terms) {
        numberOfTerms += terms;
    }

    public void restartSequence() {
        currentSequence = 0;
    }

    public void calculateSequence() {
        currentSequence++;
        if (startNumber == 1) {
            nextSequence = null;
            numberOfTerms = 1;
        } else {
            int nextTerm = calculateNextTerm();
            nextSequence = getSequenceFromMap(nextTerm);
            if (nextSequence == null) {
                 nextSequence = new CollatzSequence(nextTerm);
                 if (currentSequence > 100) {
                     currentSequence = 0;
                     lastNotCalculated = nextSequence;
                     return;
                 }
                 nextSequence.calculateSequence();
            }
            numberOfTerms = 1 + nextSequence.getNumberOfTerms();
        }
        sequenceMap.put(startNumber, this);
        lastNotCalculated = null;
    }

    public CollatzSequence getLastNotCalculated() {
        if (lastNotCalculated == null && nextSequence != null) {
            return nextSequence.getLastNotCalculated();
        }
        return lastNotCalculated;
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

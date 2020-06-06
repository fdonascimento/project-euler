package fagner.project_euler;

import java.util.Calendar;

/**
 * @since 06/06/2020
 */
public class HighlyDivisibleTriangularNumber {

    /**
     * Time complexity = O(log(n))
     * @param numberOfDivisors
     * @return
     */
    int findFirstTriangularNumberWithDivisorsOver(int numberOfDivisors) {
        int i = 0;
        int triangularNumber = 0;
        int currentNumberOfDivisors;

        do {
            i++;
            triangularNumber += i;
            currentNumberOfDivisors = calculateNumberOfDivisors(triangularNumber);
        }while(currentNumberOfDivisors <= numberOfDivisors);

        return triangularNumber;
    }

    /**
     * If a / b = c then b and c a are factors of a.
     * That said, given a number 1000, if 1000 / 2 = 500, then no number between 500 and 1000 are factors of 1000.
     * We can then loop from 3 to 499 to find the next factors. The next factor is 4, 100 / 4 = 250, so no numbers
     * between 250 and 500 are factors of 1000. Every time we find a new factor, we are going to reduce the range of
     * numbers to check.
     *
     * Since this method is going to be used to find the triangular numbers we are never going to try to calculate
     * factors of prime numbers because the triangular numbers are not prime.
     *
     * @param triangularNumber
     * @return
     */
    int calculateNumberOfDivisors(int triangularNumber) {
        if (triangularNumber == 1) {
            return 1;
        }

        int numberOfDivisors = 2;
        int limit = triangularNumber;
        for (int i = 2; i < limit; i++) {
            if (triangularNumber % i == 0) {
                numberOfDivisors += 2;
                limit = triangularNumber / i;
            }
        }
        return numberOfDivisors;
    }

    public static void main(String[] args) {
        HighlyDivisibleTriangularNumber calculator = new HighlyDivisibleTriangularNumber();
        long startTime = Calendar.getInstance().getTimeInMillis();
        int result = calculator.findFirstTriangularNumberWithDivisorsOver(500);
        long endTime = Calendar.getInstance().getTimeInMillis();
        System.out.println("Result = "+result +" | time in ms = "+(endTime-startTime));
    }
}
package fagner.project_euler;

import java.util.Calendar;

public class HighlyDivisibleTriangularNumber {

    // TODO algorithm too slow. Try to make it run faster
    int findFirstTriangularNumberWithDivisorsOver(int numberOfDivisors) {
        int i = 0;
        int triangularNumber = 0;
        int currentNumberOfDivisors = 0;

        do {
            i++;
            triangularNumber += i;
            currentNumberOfDivisors = calculateNumberOfDivisors(triangularNumber);
        }while(currentNumberOfDivisors <= numberOfDivisors);

        return triangularNumber;
    }

    int calculateNumberOfDivisors(int triangularNumber) {
        int numberOfDivisors = 0;
        for (long i = triangularNumber; i > 0; i--) {
            if (triangularNumber % i == 0) {
                numberOfDivisors++;
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
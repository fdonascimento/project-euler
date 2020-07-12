package fagner.project_euler;

import java.util.Calendar;
import java.util.HashMap;

/**
 * Time Complexity = O(log(n))
 * The number of routes grow exponentially, but the number of iterations grow linearly.
 * @since 02/07/2020
 */
public class LatticePaths {

    private HashMap<String, Long> routesMap = new HashMap<>();
    private int iterations = 0;

    public long calculate(int gridSize) {
        long result = calculateRoutes(0, 0, gridSize);
        System.out.println("Number of iterations: "+ iterations);
        return result;
    }

    public long calculateRoutes(int row, int column, int lastIndex) {
        if (row == lastIndex && column == lastIndex) {
            return 1;
        } else {
            long routes = 0;
            if (row < lastIndex) {
                routes += getNumberOfRoutes(row+1, column, lastIndex);
            }
            if (column < lastIndex) {
                routes += getNumberOfRoutes(row, column+1, lastIndex);
            }
            return routes;
        }
    }

    private long getNumberOfRoutes(int row, int column, int lastIndex) {
        String key = String.format("%d:%d", row, column);
        Long subRoutes = routesMap.get(key);
        if (subRoutes != null) {
            return subRoutes;
        } else {
            iterations++;
            long routes = calculateRoutes(row, column, lastIndex);
            routesMap.put(key, routes);
            return routes;
        }
    }

    public static void main(String[] args) {
        LatticePaths calculator = new LatticePaths();
        long startTime = Calendar.getInstance().getTimeInMillis();
        long result = calculator.calculate(100);
        long endTime = Calendar.getInstance().getTimeInMillis();
        System.out.println("Result = "+result +" | time in ms = "+(endTime-startTime));
    }
}
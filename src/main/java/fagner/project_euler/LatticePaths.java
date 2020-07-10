package fagner.project_euler;

import java.util.Calendar;
import java.util.HashMap;

/**
 * @since 02/07/2020
 */
public class LatticePaths {

    private HashMap<String, Long> routesMap = new HashMap<>();

    public long calculate(int gridSize) {
        return calculateRoutes(0, 0, gridSize);
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
            long routes = calculateRoutes(row, column, lastIndex);
            routesMap.put(key, routes);
            return routes;
        }
    }

    public static void main(String[] args) {
        LatticePaths calculator = new LatticePaths();
        long startTime = Calendar.getInstance().getTimeInMillis();
        long result = calculator.calculate(20);
        long endTime = Calendar.getInstance().getTimeInMillis();
        System.out.println("Result = "+result +" | time in ms = "+(endTime-startTime));
    }
}
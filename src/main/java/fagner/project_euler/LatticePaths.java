package fagner.project_euler;

import org.apache.commons.math3.linear.RealMatrix;

import java.util.Calendar;

public class LatticePaths {

    public long calculate(int gridSize) {
        return calculateRoutes(0, 0, gridSize);
    }

    public long calculateRoutes(int row, int column, int gridSize) {
        if (row == gridSize && column == gridSize) {
            return 1;
        } else {
            long routes = 0;
            if (row < gridSize) {
                routes += calculateRoutes(row+1, column, gridSize);
            }
            if (column < gridSize) {
                routes += calculateRoutes(row, column+1, gridSize);
            }
            return routes;
        }
    }

    public static void main(String[] args) {
        LatticePaths calculator = new LatticePaths();
        long startTime = Calendar.getInstance().getTimeInMillis();
        long result = calculator.calculate(16);
        long endTime = Calendar.getInstance().getTimeInMillis();
        System.out.println("Result = "+result +" | time in ms = "+(endTime-startTime));
    }
}

class Node {
    private static int routes;
    private int row;
    private int column;
    private Node right;
    private Node down;

    public Node(int row, int column) {
        this.row = row;
        this.column = column;
    }

    public void walkUntil(int lastIndex) {
        if (row == lastIndex && column == lastIndex) {
            routes++;
        } else {
            if (row < lastIndex) {
                new Node(row + 1, column).walkUntil(lastIndex);
            }
            if (column < lastIndex) {
                new Node(row, column + 1).walkUntil(lastIndex);
            }
        }
    }
}
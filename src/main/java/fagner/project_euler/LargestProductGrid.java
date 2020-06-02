package fagner.project_euler;

import org.apache.commons.math3.linear.RealMatrix;

/**
 * @since 31/05/2020
 */
public class LargestProductGrid {


    /*TODO Analyze algorithm complexity.
      TODO Remove duplicate code without compromise the performance
      TODO Document how I'm solving the problem. I may not remember in the future and I want to understand it later
           without too much pain.

      TODO This algorithm only works for a 4x4 grid. The goal is to find the product of 4 adjacent numbers.
           I need to implement an algorithm for a bigger grid that is going to split the grid into chunks of
           4x4 grids to pass to this method.

      TODO I need to make it work first, then I can think about improvement in terms of performance and design.
     */
    int calculate(RealMatrix grid) {
        for (int i = 0; i < grid.getRowDimension(); i++) {
            for (int j = 0; j < grid.getRow(i).length; j++) {
            }
        }
        return 0;
    }
    int findGreatestProductOf4AdjacentNumbers(RealMatrix grid) {
        int[] rowProducts = new int[grid.getRowDimension()];
        int[] columnProducts = new int[grid.getRowDimension()];
        int[] diagonalProducts = new int[2];
        int greatestProduct = 1;

        for (int i = 0; i < grid.getRowDimension(); i++) {
            for (int j = 0; j < grid.getRow(i).length; j++) {
                if (rowProducts[i] == 0) {
                    rowProducts[i] = 1;
                }
                if (columnProducts[j] == 0) {
                    columnProducts[j] = 1;
                }

                rowProducts[i] *= grid.getEntry(i, j);
                columnProducts[j] *= grid.getEntry(i, j);

                if (i == j) {
                    if (diagonalProducts[0] == 0) {
                        diagonalProducts[0] = 1;
                    }

                    diagonalProducts[0] *= grid.getEntry(i, j);

                    if (diagonalProducts[0] > greatestProduct) {
                        greatestProduct = diagonalProducts[0];
                    }
                } else if (i + j == grid.getRowDimension()-1) {
                    if (diagonalProducts[1] == 0) {
                        diagonalProducts[1] = 1;
                    }

                    diagonalProducts[1] *= grid.getEntry(i, j);

                    if (diagonalProducts[1] > greatestProduct) {
                        greatestProduct = diagonalProducts[1];
                    }
                }

                if (rowProducts[i] > greatestProduct) {
                    greatestProduct = rowProducts[i];
                }
                if (columnProducts[j] > greatestProduct) {
                    greatestProduct = columnProducts[j];
                }
            }
        }

        return greatestProduct;
    }
}

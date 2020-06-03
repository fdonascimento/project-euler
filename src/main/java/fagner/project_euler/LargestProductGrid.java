package fagner.project_euler;

import org.apache.commons.math3.linear.MatrixUtils;
import org.apache.commons.math3.linear.RealMatrix;

/**
 * @since 31/05/2020
 */
public class LargestProductGrid {


    /*TODO Analyze algorithm complexity.
      TODO Remove duplicate code without compromise the performance
      TODO Document how I'm solving the problem. I may not remember in the future and I want to understand it later
           without too much pain.

      TODO The algorithm works for products in a row and in a column. I need to figure out how to do it for diagonal.

     */
    int calculate(RealMatrix grid) {
        int[] diagonalProducts = new int[2];
        double greatestProduct = 1;

        for (int i = 0; i < grid.getRowDimension(); i++) {
            for (int j = 0; j < grid.getRow(i).length; j++) {
                if (j <= grid.getRowDimension()-4) {
                    double productRow = grid.getEntry(i, j) *
                            grid.getEntry(i, j + 1) *
                            grid.getEntry(i, j + 2) *
                            grid.getEntry(i, j + 3);

                    if (productRow > greatestProduct) {
                        greatestProduct = productRow;
                    }
                }

                if (i <= grid.getRowDimension()-4) {
                    double productColumn = grid.getEntry(i, j) *
                            grid.getEntry(i + 1, j) *
                            grid.getEntry(i + 2, j) *
                            grid.getEntry(i + 3, j);

                    if (productColumn > greatestProduct) {
                        greatestProduct = productColumn;
                    }
                }
            }
        }

        return (int) greatestProduct;
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

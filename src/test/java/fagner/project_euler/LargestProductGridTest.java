package fagner.project_euler;

import org.apache.commons.math3.linear.MatrixUtils;
import org.apache.commons.math3.linear.RealMatrix;
import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LargestProductGridTest {

    private LargestProductGrid calculator;

    @BeforeEach
    public void setup() {
        this.calculator = new LargestProductGrid();
    }

    @Test
    public void calculateGrid20GreatestProductInFirstDiagonal() {
        //given
        RealMatrix grid = MatrixUtils.createRealMatrix(
                new double[][]{
                        {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                        {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                        {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                        {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                        {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                        {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                        {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                        {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                        {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                        {1, 1, 1, 1, 1, 1, 1, 1, 1, 26, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                        {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 63, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                        {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 78, 1, 1, 1, 1, 1, 1, 1, 1},
                        {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 14, 1, 1, 1, 1, 1, 1, 1},
                        {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                        {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                        {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                        {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                        {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                        {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                        {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}
                }
        );

        //when
        int result = calculator.calculate(grid);

        //then
        assertThat(result).isEqualTo(1788696);
    }


    @Test
    public void calculateGrid4GreatestProductInFirstDiagonal() {
        //given
        RealMatrix grid = MatrixUtils.createRealMatrix(
                new double[][]{
                        {26, 1, 1, 1},
                        {1, 63, 1, 1},
                        {1, 1, 78, 1},
                        {1, 1, 1, 14}
                }
        );

        //when
        int result = calculator.findGreatestProductOf4AdjacentNumbers(grid);

        //then
        assertThat(result).isEqualTo(1788696);
    }

    @Test
    public void calculateGrid4GreatestProductInSecondDiagonal() {
        //given
        RealMatrix grid = MatrixUtils.createRealMatrix(
                new double[][]{
                        {1, 1, 1, 26},
                        {1, 1, 63, 1},
                        {1, 78, 1, 1},
                        {14, 1, 1, 1}
                }
        );

        //when
        int result = calculator.findGreatestProductOf4AdjacentNumbers(grid);

        //then
        assertThat(result).isEqualTo(1788696);
    }

    @Test
    public void calculateGrid4GreatestProductInFirstRow() {
        //given
        RealMatrix grid = MatrixUtils.createRealMatrix(
                new double[][]{
                        {26, 63, 78, 14},
                        {1, 1, 1, 1},
                        {1, 1, 1, 1},
                        {1, 1, 1, 1}
                }
        );

        //when
        int result = calculator.findGreatestProductOf4AdjacentNumbers(grid);

        //then
        assertThat(result).isEqualTo(1788696);
    }

    @Test
    public void calculateGrid4GreatestProductInSecondRow() {
        //given
        RealMatrix grid = MatrixUtils.createRealMatrix(
                new double[][]{
                        {1, 1, 1, 1},
                        {26, 63, 78, 14},
                        {1, 1, 1, 1},
                        {1, 1, 1, 1}
                }
        );

        //when
        int result = calculator.findGreatestProductOf4AdjacentNumbers(grid);

        //then
        assertThat(result).isEqualTo(1788696);
    }

    @Test
    public void calculateGrid4GreatestProductInThirdRow() {
        //given
        RealMatrix grid = MatrixUtils.createRealMatrix(
                new double[][]{
                        {1, 1, 1, 1},
                        {1, 1, 1, 1},
                        {26, 63, 78, 14},
                        {1, 1, 1, 1}
                }
        );

        //when
        int result = calculator.findGreatestProductOf4AdjacentNumbers(grid);

        //then
        assertThat(result).isEqualTo(1788696);
    }

    @Test
    public void calculateGrid4GreatestProductInFourthRow() {
        //given
        RealMatrix grid = MatrixUtils.createRealMatrix(
                new double[][]{
                        {1, 1, 1, 1},
                        {1, 1, 1, 1},
                        {1, 1, 1, 1},
                        {26, 63, 78, 14}
                }
        );

        //when
        int result = calculator.findGreatestProductOf4AdjacentNumbers(grid);

        //then
        assertThat(result).isEqualTo(1788696);
    }

    @Test
    public void calculateGrid4GreatestProductInFirstColumn() {
        //given
        RealMatrix grid = MatrixUtils.createRealMatrix(
                new double[][]{
                        {26, 1, 1, 1},
                        {63, 1, 1, 1},
                        {78, 1, 1, 1},
                        {14, 1, 1, 1}
                }
        );

        //when
        int result = calculator.findGreatestProductOf4AdjacentNumbers(grid);

        //then
        assertThat(result).isEqualTo(1788696);
    }

    @Test
    public void calculateGrid4GreatestProductInSecondColumn() {
        //given
        RealMatrix grid = MatrixUtils.createRealMatrix(
                new double[][]{
                        {1, 26, 1, 1},
                        {1, 63, 1, 1},
                        {1, 78, 1, 1},
                        {1, 14, 1, 1}
                }
        );

        //when
        int result = calculator.findGreatestProductOf4AdjacentNumbers(grid);

        //then
        assertThat(result).isEqualTo(1788696);
    }

    @Test
    public void calculateGrid4GreatestProductInThirdColumn() {
        //given
        RealMatrix grid = MatrixUtils.createRealMatrix(
                new double[][]{
                        {1, 1, 26, 1},
                        {1, 1, 63, 1},
                        {1, 1, 78, 1},
                        {1, 1, 14, 1}
                }
        );

        //when
        int result = calculator.findGreatestProductOf4AdjacentNumbers(grid);

        //then
        assertThat(result).isEqualTo(1788696);
    }

    @Test
    public void calculateGrid4GreatestProductInFourthColumn() {
        //given
        RealMatrix grid = MatrixUtils.createRealMatrix(
                new double[][]{
                        {1, 1, 1, 26},
                        {1, 1, 1, 63},
                        {1, 1, 1, 78},
                        {1, 1, 1, 14}
                }
        );

        //when
        int result = calculator.findGreatestProductOf4AdjacentNumbers(grid);

        //then
        assertThat(result).isEqualTo(1788696);
    }
}

package fagner.project_euler;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class HighlyDivisibleTriangularNumberTest {

    private HighlyDivisibleTriangularNumber calculator;

    @BeforeEach
    void setup() {
        calculator = new HighlyDivisibleTriangularNumber();
    }

    @Test
    void findFirstTriangularNumberWithDivisorsOver5Then28() {
        int result = calculator.findFirstTriangularNumberWithDivisorsOver(5);

        assertThat(result).isEqualTo(28);
    }

    @Test
    void findFirstTriangularNumberWithDivisorsOver2Then6() {
        int result = calculator.findFirstTriangularNumberWithDivisorsOver(2);

        assertThat(result).isEqualTo(6);
    }

    @Test
    void findFirstTriangularNumberWithDivisorsOver1Then3() {
        int result = calculator.findFirstTriangularNumberWithDivisorsOver(1);

        assertThat(result).isEqualTo(3);
    }

    @Test
    void calculateNumberOfDivisorsFor28Then6() {
        int result = calculator.calculateNumberOfDivisors(28);
        assertThat(result).isEqualTo(6);
    }

    @Test
    void calculateNumberOfDivisorsFor21Then4() {
        int result = calculator.calculateNumberOfDivisors(21);
        assertThat(result).isEqualTo(4);
    }

    @Test
    void calculateNumberOfDivisorsFor3Then2() {
        int result = calculator.calculateNumberOfDivisors(3);
        assertThat(result).isEqualTo(2);
    }

    @Test
    void calculateNumberOfDivisorsFor1Then1() {
        int result = calculator.calculateNumberOfDivisors(1);
        assertThat(result).isEqualTo(1);
    }
}

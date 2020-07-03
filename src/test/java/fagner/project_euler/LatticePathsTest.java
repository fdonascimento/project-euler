package fagner.project_euler;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LatticePathsTest {

    @Test
    public void calculateGrid20Then6() {
        LatticePaths calculator = new LatticePaths();
        assertThat(calculator.calculate(2)).isEqualTo(6);
    }
}

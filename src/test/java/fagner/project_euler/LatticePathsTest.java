package fagner.project_euler;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LatticePathsTest {

    @Test
    public void calculateGrid2Then6() {
        LatticePaths calculator = new LatticePaths();
        assertThat(calculator.calculate(2)).isEqualTo(6);
    }

    @Test
    public void calculateGrid3Then20() {
        LatticePaths calculator = new LatticePaths();
        assertThat(calculator.calculate(3)).isEqualTo(20);
    }

    @Test
    public void calculateGrid4Then70() {
        LatticePaths calculator = new LatticePaths();
        assertThat(calculator.calculate(4)).isEqualTo(70);
    }

    @Test
    public void calculateGrid15Then155117520() {
        LatticePaths calculator = new LatticePaths();
        assertThat(calculator.calculate(15)).isEqualTo(155117520);
    }

    @Test
    public void calculateGrid14Then40116600() {
        LatticePaths calculator = new LatticePaths();
        assertThat(calculator.calculate(14)).isEqualTo(40116600);
    }

    @Test
    public void calculateGrid13Then10400600() {
        LatticePaths calculator = new LatticePaths();
        assertThat(calculator.calculate(13)).isEqualTo(10400600);
    }

    @Test
    public void calculateGrid12Then2704156() {
        LatticePaths calculator = new LatticePaths();
        assertThat(calculator.calculate(12)).isEqualTo(2704156);
    }

    @Test
    public void calculateGrid11Then705432() {
        LatticePaths calculator = new LatticePaths();
        assertThat(calculator.calculate(11)).isEqualTo(705432);
    }
}

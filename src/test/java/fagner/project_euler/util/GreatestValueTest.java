package fagner.project_euler.util;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class GreatestValueTest {

    @Test
    public void changeValueIfValueIsGreater() {
        GreatestValue greatestValue = new GreatestValue(1);
        greatestValue.setIfItIsTheGreatestValue(5);

        assertThat(greatestValue.getValue()).isEqualTo(5);
    }

    @Test
    public void doesntChangeValueIfValueIsNotGreater() {
        GreatestValue greatestValue = new GreatestValue(5);
        greatestValue.setIfItIsTheGreatestValue(3);

        assertThat(greatestValue.getValue()).isEqualTo(5);
    }
}

package fagner.project_euler.util;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class CollatzSequenceTest {

    @Test
    public void calculateSequence_13_10terms() {
        CollatzSequence collatzSequence = CollatzSequence.getSequence(13);
        assertThat(collatzSequence.getNumberOfTerms()).isEqualTo(10);
    }

    @Test
    public void calculateSequence_14_18terms() {
        CollatzSequence.getSequence(13);

        CollatzSequence collatzSequence14 = CollatzSequence.getSequence(14);
        assertThat(collatzSequence14.getNumberOfTerms()).isEqualTo(18);
    }

    @Test
    public void calculateSequence_9_20terms() {
        CollatzSequence.getSequence(13);
        CollatzSequence.getSequence(14);

        CollatzSequence collatzSequence9 = CollatzSequence.getSequence(9);
        assertThat(collatzSequence9.getNumberOfTerms()).isEqualTo(20);
    }

    @Test
    public void calculateSequence_500_111terms() {
        CollatzSequence collatzSequence500 = CollatzSequence.getSequence(500);
        assertThat(collatzSequence500.getNumberOfTerms()).isEqualTo(111);
    }
}

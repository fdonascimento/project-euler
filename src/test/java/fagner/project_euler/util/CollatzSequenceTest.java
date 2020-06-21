package fagner.project_euler.util;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class CollatzSequenceTest {

    @Test
    public void calculateSequence_13_10terms() {
        //given
        CollatzSequence collatzSequence = new CollatzSequence(13);
        //when
        collatzSequence.calculateSequence();
        //then
        assertThat(collatzSequence.getNumberOfTerms()).isEqualTo(10);
    }

    @Test
    public void calculateSequence_14_18terms() {
        //given
        CollatzSequence collatzSequence13 = new CollatzSequence(13);
        collatzSequence13.calculateSequence();

        //when
        CollatzSequence collatzSequence14 = new CollatzSequence(14);
        collatzSequence14.calculateSequence();

        //then
        assertThat(collatzSequence14.getNumberOfTerms()).isEqualTo(18);
    }

    @Test
    public void calculateSequence_9_20terms() {
        //given
        CollatzSequence collatzSequence13 = new CollatzSequence(13);
        collatzSequence13.calculateSequence();

        CollatzSequence collatzSequence14 = new CollatzSequence(14);
        collatzSequence14.calculateSequence();

        //when
        CollatzSequence collatzSequence9 = new CollatzSequence(9);
        collatzSequence9.calculateSequence();
        //then
        assertThat(collatzSequence9.getNumberOfTerms()).isEqualTo(20);
    }
}

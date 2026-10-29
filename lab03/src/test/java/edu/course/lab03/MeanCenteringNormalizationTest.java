package edu.course.lab03;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class MeanCenteringNormalizationTest {
    @Test
    void subtractsMeanFromValues() {
        NormalizationStrategy normalization = new MeanCenteringNormalization();
        double[] result = normalization.normalize(new double[]{2, 4, 6});
        assertArrayEquals(new double[]{-2, 0, 2}, result, 0.000001);
    }

    @Test
    void returnsEmptyArrayForEmptyInput() {
        NormalizationStrategy normalization = new MeanCenteringNormalization();
        double[] result = normalization.normalize(new double[]{});
        assertArrayEquals(new double[]{}, result, 0.000001);
    }
}

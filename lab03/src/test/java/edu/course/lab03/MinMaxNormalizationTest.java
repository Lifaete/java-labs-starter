package edu.course.lab03;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class MinMaxNormalizationTest {
    @Test
    void normalizesValuesToRangeZeroOne() {
        NormalizationStrategy normalization = new MinMaxNormalization();
        double[] result = normalization.normalize(new double[]{10, 20, 30});
        assertArrayEquals(new double[]{0.0, 0.5, 1.0}, result, 0.000001);
    }

    @Test
    void returnsZerosWhenAllValuesAreEqual() {
        NormalizationStrategy normalization = new MinMaxNormalization();
        double[] result = normalization.normalize(new double[]{5, 5, 5});
        assertArrayEquals(new double[]{0.0, 0.0, 0.0}, result, 0.000001);
    }
}

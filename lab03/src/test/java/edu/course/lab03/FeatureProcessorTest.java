package edu.course.lab03;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class FeatureProcessorTest {
    @Test
    void processesValuesUsingMinMaxNormalization() {
        FeatureProcessor processor = new FeatureProcessor(new MinMaxNormalization());
        double[] result = processor.process(new double[]{10, 20, 30});
        assertArrayEquals(new double[]{0.0, 0.5, 1.0}, result, 0.000001);
    }

    @Test
    void processesValuesUsingMeanCenteringNormalization() {
        FeatureProcessor processor = new FeatureProcessor(new MeanCenteringNormalization());
        double[] result = processor.process(new double[]{2, 4, 6});
        assertArrayEquals(new double[]{-2.0, 0.0, 2.0}, result, 0.000001);
    }

    @Test
    void doesNotChangeOriginalArray() {
        FeatureProcessor processor = new FeatureProcessor(new MinMaxNormalization());
        double[] values = {10, 20, 30};
        processor.process(values);
        assertArrayEquals(new double[]{10, 20, 30}, values, 0.000001);
    }

}

package edu.course.lab02;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class DataSampleTest {
    @Test
    void createCorrectObject() {
        double[] features = {1.0, 2.0, 3.0};
        DataSample sample = new DataSample("sample-1", "apartment", SampleStatus.NEW, features);
        assertEquals("sample-1", sample.getId());
        assertEquals("apartment", sample.getLabel());
        assertEquals(SampleStatus.NEW, sample.getStatus());
        assertArrayEquals(features, sample.getFeatures());
    }

    @Test
    void rejectNullId() {
        assertThrows(IllegalArgumentException.class, () -> new DataSample(null, "apartment", SampleStatus.NEW, new double[]{1.0, 2.0, 3.0}));
    }

    @Test
    void rejectEmpetyId() {
        assertThrows(IllegalArgumentException.class, () -> new DataSample("", "apartment", SampleStatus.NEW, new double[]{1.0, 2.0, 3.0}));
    }

    @Test
    void rejectNullLabel() {
        assertThrows(IllegalArgumentException.class, () -> new DataSample("sample-1", null, SampleStatus.NEW, new double[]{1.0, 2.0, 3.0}));
    }

    @Test
    void rejectEmpetyLabel() {
        assertThrows(IllegalArgumentException.class, () -> new DataSample("sample-1", "", SampleStatus.NEW, new double[]{1.0, 2.0, 3.0}));
    }

    @Test
    void rejectNullStatus() {
        assertThrows(IllegalArgumentException.class, () -> new DataSample("sample-1", "apartment", null, new double[]{1.0, 2.0, 3.0}));
    }

    @Test
    void rejectNullFeatures() {
        assertThrows(IllegalArgumentException.class, () -> new DataSample("sample-1", "apartment", SampleStatus.NEW, null));
    }

    @Test
    void rejectEmpetyFeatures() {
        assertThrows(IllegalArgumentException.class, () -> new DataSample("sample-1", "apartment", SampleStatus.NEW, new double[]{}));
    }

    @Test
    void changeStatus() {
        DataSample sample = new DataSample("sample-1", "apartment", SampleStatus.NEW, new double[]{1.0, 2.0, 3.0});
        sample.changeStatus(SampleStatus.READY);
        assertEquals(SampleStatus.READY, sample.getStatus());
    }

    @Test
    void readyStatusIsDetected() {
        DataSample sample = new DataSample("sample-1", "apartment", SampleStatus.READY, new double[]{1.0, 2.0, 3.0});
        assertTrue(sample.isReady());
    }

    @Test
    void nonReadyStatusIsDetected() {
        DataSample sample = new DataSample("sample-1", "apartment", SampleStatus.NEW, new double[]{1.0, 2.0, 3.0});
        assertFalse(sample.isReady());
    }

    @Test
    void calculateAverage() {
        DataSample sample = new DataSample("sample-1", "apartment", SampleStatus.NEW, new double[]{2.0, 4.0, 6.0});
        assertEquals(4.0, sample.average());
    }

    @Test
    void copiesFeaturesInConstructor() {
        double[] features = {1.0, 2.0, 3.0};
        DataSample sample = new DataSample("sample-1", "apartment", SampleStatus.NEW, features);
        features[0] = 6.7;
        assertArrayEquals(new double[]{1.0, 2.0, 3.0}, sample.getFeatures());
    }

    @Test
    void copiesFeaturesWhenReturningFromAccessor() {
        DataSample sample = new DataSample("sample-1", "apartment", SampleStatus.NEW, new double[]{1.0, 2.0, 3.0});
        double[] features = sample.getFeatures();
        features[0] = 6.7;
        assertArrayEquals(new double[]{1.0, 2.0, 3.0}, sample.getFeatures());
    }

    @Test
    void normalizeFeaturesWithoutChangingOriginalObject() {
        DataSample sample = new DataSample("sample-1", "apartment", SampleStatus.NEW, new double[]{10.0, 20.0, 30.0});
        DataSample normalized = sample.normalized();
        assertArrayEquals(new double[]{0.0, 0.5, 1.0}, normalized.getFeatures());
        assertArrayEquals(new double[]{10.0, 20.0, 30.0}, sample.getFeatures());
    }
}

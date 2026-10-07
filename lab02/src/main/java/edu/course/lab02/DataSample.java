package edu.course.lab02;

public class DataSample {
    private final String id;
    private final String label;
    private SampleStatus status;
    private final double[] features;

    public DataSample(String id, String label, SampleStatus status, double[] features) {
        if (id == null || id.isBlank()) {
            throw new IllegalArgumentException("id mustn't be null");
        }

        if (label == null || label.isBlank()) {
            throw new IllegalArgumentException("label mustn't be null");
        }

        if (status == null) {
            throw new IllegalArgumentException("status mustn't be null");
        }

        if (features == null || features.length == 0) {
            throw new IllegalArgumentException("features mustn't be empety");
        }

        this.id = id;
        this.label = label;
        this.status = status;
        this.features = features.clone();
    }

// Наблюдение
    public String getId() {
        return id;
    }

    public String getLabel() {
        return label;
    }

    public SampleStatus getStatus() {
        return status;
    }

    public double[] getFeatures() {
        return features.clone();
    }

    public void changeStatus(SampleStatus newStatus) {
        if (newStatus == null) {
            throw new IllegalArgumentException("Status mustn't be null");
        }
        this.status = newStatus;
    }

    public boolean isReady() {
        return status == SampleStatus.READY;
    }

    public double average() {
        double sum = 0;
        for (double feature : features) {
            sum += feature;
        }
        return sum/features.length;
    }

    public  DataSample normalized() {
        double min = features[0];
        double max = features[0];
        for (double feature : features) {
            if (feature < min) {
                min = feature;
            }
            if (feature > max) {
                max = feature;
            }
        }
        double[] normalizedFeatures = new double[features.length];
        if (min==max) {
            return new DataSample(id, label, status, normalizedFeatures);
        }
        for (int i = 0; i < features.length; i++) {
            normalizedFeatures[i] = ((features[i]-min)/(max-min));
        }
        return new DataSample(id, label, status, normalizedFeatures);
    }
}

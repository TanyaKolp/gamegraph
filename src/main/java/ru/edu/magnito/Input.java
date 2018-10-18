package ru.edu.magnito;

import java.util.Arrays;

public class Input {
    /**
     * '*' - 0
     * 'S' - 1
     * 'M' - 2
     * 'N' - 3
     *
     * **/
    private int[] recordingTrack;
    private int length;
    private int productionCost;
    private int costForUsingDevice;

    public Input(int[] recordingTrack, int length, int productionCost, int costForUsingDevice) {
        this.recordingTrack = recordingTrack;
        this.length = length;
        this.productionCost = productionCost;
        this.costForUsingDevice = costForUsingDevice;
    }

    public Input() {
    }

    public int[] getRecordingTrack() {
        return recordingTrack;
    }

    public void setRecordingTrack(int[] recordingTrack) {
        this.recordingTrack = recordingTrack;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getProductionCost() {
        return productionCost;
    }

    public void setProductionCost(int productionCost) {
        this.productionCost = productionCost;
    }

    public int getCostForUsingDevice() {
        return costForUsingDevice;
    }

    public void setCostForUsingDevice(int costForUsingDevice) {
        this.costForUsingDevice = costForUsingDevice;
    }

    @Override
    public String toString() {
        return "Input{" +
                "recordingTrack=" + Arrays.toString(recordingTrack) +
                ", length=" + length +
                ", productionCost=" + productionCost +
                ", costForUsingDevice=" + costForUsingDevice +
                '}';
    }
}

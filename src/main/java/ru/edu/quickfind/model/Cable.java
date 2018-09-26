package ru.edu.quickfind.model;

public class Cable {
    private Integer firstNodeId;
    private Integer secondNodeId;
    private Integer transTime;

    public Cable() {
        this.firstNodeId = 0;
        this.transTime = 0;
    }

    public Cable(Integer firstNodeId, Integer secondNodeId, Integer transTime) {
        this.firstNodeId = firstNodeId;
        this.secondNodeId = secondNodeId;
        this.transTime = transTime;
    }

    public Integer getSecondNodeId() {
        return secondNodeId;
    }

    public void setSecondNodeId(Integer secondNodeId) {
        this.secondNodeId = secondNodeId;
    }

    public Integer getFirstNodeId() {
        return firstNodeId;
    }

    public void setFirstNodeId(Integer firstNodeId) {
        this.firstNodeId = firstNodeId;
    }

    public Integer getTransTime() {
        return transTime;
    }

    public void setTransTime(Integer transTime) {
        this.transTime = transTime;
    }

    @Override
    public String toString() {
        return "{firstNodeId=" + firstNodeId +
                ", transTime=" + transTime +
                '}';
    }
}

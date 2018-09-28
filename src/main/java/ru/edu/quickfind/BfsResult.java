package ru.edu.quickfind;

public class BfsResult {
    private Integer max;
    private Integer forNode;

    public BfsResult(Integer max, Integer forNode) {
        this.max = max;
        this.forNode = forNode;
    }

    public Integer getMax() {
        return max;
    }

    public Integer getForNode() {
        return forNode;
    }
}

package ru.edu.magnito;

import java.util.HashMap;
import java.util.SortedSet;
import java.util.TreeSet;

public class Algoritm {

    public void calc(Input input) {
        int[] recordingTrack = input.getRecordingTrack();
        findMaxStep(recordingTrack);
    }

    private int findMaxStep(int[] recordingTrack) {
        int res = 0;
        int stepSize = 0;
        int symbol = 0;
        HashMap<Integer, SortedSet<Integer>> maxStepMap = new HashMap<>();
        for (int i : recordingTrack) {
            if (symbol != 0 && i != 0 && i != symbol) {
                addStep(symbol, stepSize, maxStepMap);
                stepSize = 0;
            }
            if (i != 0) {
                symbol = i;
            }
            stepSize++;
        }

        System.out.println("max step = " + res);
        return res;
    }

    private void addStep(int symbol, int stepSize, HashMap<Integer, SortedSet<Integer>> maxStepMap) {
        SortedSet<Integer> stepSizes = maxStepMap.computeIfAbsent(symbol, k -> new TreeSet<>());
        stepSizes.add(stepSize);
        System.out.println("add size " + stepSize + " for " + symbol);
    }
}

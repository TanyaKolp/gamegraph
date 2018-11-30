package ru.edu.finder;

import java.util.Arrays;

public class FinderMain {
    public static void main(String[] args) {
        MaxFinder maxFinder = new MaxFinder();
        Integer[] objects = maxFinder.find();

        System.out.println("**** res ****");
        System.out.println("Result combination = "+ Arrays.toString(objects));
        System.out.println("Answer: " + Arrays.stream(objects).mapToInt(i->i).sum()/2);
    }
}

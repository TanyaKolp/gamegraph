package ru.edu.finder;

import java.util.Arrays;
import java.util.List;

public class FinderMain {
    public static void main(String[] args) {
        MaxFinder maxFinder = new MaxFinder();
        List<Integer[]> objects = maxFinder.find();

        System.out.println("**** res ****");
        for (Integer[] object : objects) {
            System.out.println(Arrays.toString(object));
        }

    }
}

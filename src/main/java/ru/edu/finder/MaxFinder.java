package ru.edu.finder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MaxFinder {
    private Integer[] array;

    public MaxFinder() {
        init();
//        sec();
        example3();
    }


    private void init() {
        array = new Integer[]{4, 10, 4, 22, 18};
    }

    private void sec() {
        array = new Integer[]{29, 42, 25, 40, 48, 3};
    }

    private void example3() {
        array = new Integer[]{3, 43, 12, 63, 47, 47, 49, 29, 45, 12, 23, 41, 22, 21, 42};
    }

    private void example0() {
        array = new Integer[]{2, 3, 4, 1, 6};
    }


    public List<Integer[]> find() {
        List<Integer[]> result = new ArrayList<>();
        Arrays.sort(array, Collections.reverseOrder());
        System.out.println("***  sort  **** ");
        System.out.println(Arrays.toString(array));
        result.add(array);
        int[] deletedList = new int[array.length];
        deletedList[array.length - 1] = array[array.length - 1];
        Integer[] resArray = Arrays.copyOf(array, array.length);
        for (int index = 1; index < resArray.length; index++) {
            System.out.println("\n iteration ***** " + index);
            System.out.println("deleted = " + Arrays.toString(deletedList));
            System.out.println("last el = " + resArray[resArray.length - index]);
            if (computeSum(deletedList) < resArray[resArray.length - index]) {
                resArray[resArray.length - index + 1] = getMinOf(deletedList);
                deletedList[resArray.length - index] = resArray[resArray.length - index];
                resArray[resArray.length - index] = 0;
                System.out.println("sum < ");
            } else {
                deletedList[resArray.length - index] = resArray[resArray.length - index];
                resArray[resArray.length - index] = 0;
            }
            System.out.println("resArr = " + Arrays.toString(resArray));
            result.add(Arrays.copyOf(resArray, resArray.length));
        }
        return result;
    }

    private Integer getMinOf(int[] deletedList) {
        int min = Integer.MAX_VALUE;
        for (int i : deletedList) {
            min = (i == 0) ? min : Math.min(i, min);
        }
        return min;
    }

    private int computeSum(int[] list) {
        return Arrays.stream(list).sum();
    }

    public Integer[] getArray() {
        return array;
    }
}

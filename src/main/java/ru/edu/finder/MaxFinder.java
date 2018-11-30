package ru.edu.finder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MaxFinder {
    private Integer[] array;
    private int sum;

    public MaxFinder() {
//        case22();
//        case0();
//        case8();
//        case248();
//        case239();
//        case6();
//        crashCase6();
        crashCase6sec();
    }

    private void case22() {
        array = new Integer[]{4, 10, 4, 22, 18};
    }

    private void case239() {
        array = new Integer[]{5, 27, 24, 12, 12, 2, 15, 25, 32, 21, 37, 29, 20, 9, 24, 35, 26, 8, 31, 5, 25, 21, 28, 3, 5};
    }

    private void case6() {
        array = new Integer[]{4, 6, 2};
    }

    private void case0() {
        array = new Integer[]{29, 42, 25, 40, 48, 3};
    }

    private void case248() {
        array = new Integer[]{3, 43, 12, 63, 47, 47, 49, 29, 45, 12, 23, 41, 22, 21, 42};
    }

    private void case8() {
        array = new Integer[]{2, 3, 4, 1, 6};
    }

    private void crashCase6() {
        array = new Integer[]{22, 4, 6, 2};
    }

    private void crashCase6sec() {
        array = new Integer[]{11, 3, 4, 6, 2};
    }

    public Integer[] find() {
        this.sum = Arrays.stream(array).mapToInt(Integer::intValue).sum();
        System.out.println("sum = " + sum);
        Arrays.sort(this.array, Collections.reverseOrder());
        System.out.println("Do magic for **********************\n" + Arrays.toString(array));
        Integer[] result = doMagic(this.array);
        if (result.length == 0) {
            Arrays.sort(this.array);
            System.out.println("\n Do magic again **********************\n" + Arrays.toString(array));
            result = doMagic(this.array);
        }
        return result;
    }

    private Integer[] doMagic(Integer[] array) {
        int[] deletedList = new int[array.length];
        deletedList[array.length - 1] = array[array.length - 1];
        Integer[] resArray = Arrays.copyOf(array, array.length);
        for (int index = 1; index < resArray.length; index++) {
            if (checkPartition(resArray)) {
                return resArray;
            }
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
        }

        return new Integer[0];
    }

    private boolean checkPartition(Integer[] resArray) {
        int[] toPartition = cutArray(resArray);
        if (Partition.findPartition(toPartition, toPartition.length)) {
            System.out.println("*** Yra ***");
            return true;
        }
        return false;
    }

    private int[] cutArray(Integer[] resArray) {
        List<Integer> res = new ArrayList<>(resArray.length);
        for (Integer integer : resArray) {
            if (integer != 0)
                res.add(integer);
        }
        return res.stream().mapToInt(i -> i).toArray();
    }

    private Integer getMinOf(int[] deletedList) {
        int min = Integer.MAX_VALUE;
        int indexMin = -1;
        for (int i = 0; i < deletedList.length; i++) {
            if (deletedList[i] != 0) {
                min = Math.min(deletedList[i], min);
                indexMin = i;
            }
        }
        if (indexMin != -1) {
            deletedList[indexMin] = 0;
        }
        return min;
    }

    public static int computeSum(int[] list) {
        return Arrays.stream(list).sum();
    }

    public Integer[] getArray() {
        return array;
    }
}


package com.zipcodewilmington.arrayutility;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by leon on 3/6/18.
 */
public class ArrayUtility<T> {

    private ArrayList<T> inputArrayList;
    private T[] originalInput;

    public ArrayUtility(T[] input) {
        inputArrayList = new ArrayList(Arrays.asList(input));
        originalInput = input;
    }

    public Integer countDuplicatesInMerge(T[] arrayToMerge, T valueToEvaluate) {
        ArrayList<T> merged = mergeArrays(arrayToMerge);
        int count = 0;
        for (T t : merged) if (t.equals(valueToEvaluate)) count++;
        return count;
    }


    public T getMostCommonFromMerge(T[] arrayToMerge) {
    ArrayList<T> merged = mergeArrays(arrayToMerge);
    Integer maxCount = 0;
    T maxAppearances = null;
    for (T t : merged) {
        Integer occurrences = getNumberOfOccurrences(t);
        if (occurrences > maxCount) {
            maxAppearances = t;
            maxCount = occurrences;
        }
    }
    return maxAppearances;

    }

    public Integer getNumberOfOccurrences(T valueToEvaluate) {
        Integer occurrences = 0;
        for (T t : inputArrayList) if (valueToEvaluate.equals(t)) occurrences++;
        return occurrences;
    }

    public T[] removeValue(T valueToRemove)  {
        while (inputArrayList.contains(valueToRemove)) inputArrayList.remove(valueToRemove);
        return inputArrayList.toArray(Arrays.copyOf(originalInput, inputArrayList.size()));
    }
    public ArrayList<T> mergeArrays(T[] arrayToMerge) {
        if (inputArrayList == null) return null;
        if (arrayToMerge == null | arrayToMerge.length == 0) return inputArrayList;
        ArrayList<T> merged = new ArrayList<>(inputArrayList.size() + arrayToMerge.length);
        merged.addAll(inputArrayList);
        merged.addAll(Arrays.asList(arrayToMerge));
        return merged;
    }

}

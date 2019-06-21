package com.zipcodewilmington.arrayutility;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

/**
 * Created by leon on 3/6/18.
 */
public class ArrayUtility<T> {

    private ArrayList<T> inputArray;
    private T[] originalInput;

    public ArrayUtility(T[] input) {
        inputArray = new ArrayList(Arrays.asList(input));
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
        for (T t : inputArray) if (valueToEvaluate.equals(t)) occurrences++;
        return occurrences;
    }

    public T[] removeValue(T valueToRemove)  {
        while (inputArray.contains(valueToRemove)) inputArray.remove(valueToRemove);
        T[] result = Arrays.copyOf(originalInput, inputArray.size());
        for (int i = 0; i < inputArray.size(); i++) result[i] = inputArray.get(i);
        return result;
    }
    public ArrayList<T> mergeArrays(T[] arrayToMerge) {
        if (inputArray == null) return null;
        if (arrayToMerge == null | arrayToMerge.length == 0) return inputArray;
        ArrayList<T> merged = new ArrayList<>(inputArray.size() + arrayToMerge.length);
        merged.addAll(inputArray);
        merged.addAll(Arrays.asList(arrayToMerge));
        return merged;
    }

}

package com.pykost.lesson2;

import java.util.Comparator;

public class MyQuickSort {
    public static <T> void quickSort(MyArrayList<T> list, Comparator<T> comparator) {
        quickSorts(list, comparator, 0, list.size() - 1);
    }

    public static <T extends Comparable<T>> void quickSort(MyArrayList<T> list) {
        quickSorts(list, Comparator.naturalOrder(), 0, list.size() - 1);
    }

    private static <T> void quickSorts(MyArrayList<T> list, Comparator<T> comparator, int leftIndex, int rightIndex) {
        if (leftIndex < rightIndex) {
            int pivot = partition(list, comparator, leftIndex, rightIndex);
            quickSorts(list, comparator, leftIndex, pivot);
            quickSorts(list, comparator, pivot + 1, rightIndex);
        }
    }

    private static <T> int partition(MyArrayList<T> list, Comparator<T> comparator, int leftIndex, int rightIndex) {
        T pivot = list.get((leftIndex + rightIndex) / 2);
        while (leftIndex <= rightIndex) {
            while (comparator.compare(list.get(leftIndex), pivot) < 0) {
                leftIndex++;
            }
            while (comparator.compare(list.get(rightIndex), pivot) > 0) {
                rightIndex--;
            }
            if (leftIndex >= rightIndex) {
                break;
            }
            swap(list, leftIndex, rightIndex);
            leftIndex++;
            rightIndex--;
        }
        return rightIndex;
    }

    private static <T> void swap(MyArrayList<T> list, int leftIndex, int rightIndex) {
        T temp = list.get(leftIndex);
        list.set(leftIndex, list.get(rightIndex));
        list.set(rightIndex, temp);
    }

}


package sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ShellSort {
    public static int calculateIncrement(int num){
        return 3 * num + 1;
    }

    public static <T extends Comparable<T>> List<Integer> getIncrements(List<T> list){
        int x = 1;
        List<Integer> incrementList = new LinkedList<>();

        int h = 1;
        while(h < list.size()){
            incrementList.add(h);
            h = 3 * h + 1;
        }

        List<Integer> incrementListReversed = new ArrayList<>();
        for(int i = incrementList.size() - 1; i >= 0; i--){
            incrementListReversed.add(incrementList.get(i));
        }

        return incrementListReversed;
    }

    public static <T extends Comparable<T>> List<T> sort(List<T> list){
        List<Integer> incrementList = getIncrements(list);

        for(int increment : incrementList){
            list = InsertionSort.sort(list, increment);
        }

        return list;
    }

    public static void main(String[] args){
        List<Integer> numListUnsorted = new ArrayList<>();
        for(int i = 20; i > 0; i--){
            numListUnsorted.add(i);
        }

        System.out.println("Unsorted list is " + numListUnsorted);

        List<Integer> increments = getIncrements(numListUnsorted);
        System.out.println("Increments are " + increments);

        List<Integer> sortedList = sort(numListUnsorted);
        System.out.println("Sorted list is " + sortedList);
    }
}

package sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InsertionSort {
    public static <T extends Comparable<T>> List<T> sort(List<T> list) {
        return sort(list, 1);
    }

    public static <T extends Comparable<T>> List<T> sort(List<T> list, int strideLength) {
        // Iterate list
        for(int startIndex = 0; startIndex < list.size(); startIndex++){
            int currentIndex = startIndex - strideLength;
            Boolean sortedCurrent = false;
            int moveIndex = startIndex;
            T startElement = list.get(moveIndex);

            while(currentIndex >= 0 && !sortedCurrent){
                T currentElement = list.get(currentIndex);

                if(startElement.compareTo(currentElement) < 0){
                    // Swap elements
                    list.set(currentIndex, startElement);
                    list.set(moveIndex, currentElement);

                    // Update indices
                    moveIndex = currentIndex; // current is swapped
                    currentIndex = currentIndex - strideLength; // move to previous element
                } else {
                    sortedCurrent = true; // exit loop
                }
            }

        }

        return list;
    }

    public static void main(String[] args){
        List<Integer> unsortedIntList = Arrays.asList(9, 8, 7, 4, 6, 5, 4, 3, 2, 1);
        System.out.println("Unsorted list is " + unsortedIntList);

        List<Integer> sortedIntList = sort(unsortedIntList);
        System.out.println("Sorted list is " + sortedIntList);

        List<Character> charList = Arrays.asList('S', 'O', 'R', 'T', 'E', 'X', 'A', 'M', 'P', 'L', 'E');

        List<Character> sortedCharList = sort(charList, 7);
        System.out.println("Sorted char list is " + sortedCharList);
    }
}

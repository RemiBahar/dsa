package sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SelectionSort {
    public static <T> List<T> copy(List<T> list){
        List<T> sortedList = new ArrayList<>();

        for(T item : list){
            sortedList.add(item);
        }

        return  sortedList;
    }

    public static <T extends Comparable<T>> boolean less(T leftItem, T currentItem){
      int result = currentItem.compareTo(leftItem);

      if(result < 0){
          return true;
      } else {
          return false;
      }
    }

    public static <T> void swap(List<T> list, int leftIndex, int rightIndex){
        // Swap
        T left = list.get(leftIndex);
        T right = list.get(rightIndex);
        list.set(leftIndex, right);
        list.set(rightIndex, left);

        return;
    }

    /**
     * Uses selection sort algorithm to sort a generic list type containing any type of data in quadratic time.
     * The original list is not modified
     * @param list list to sort
     * @return sorted list
     * @param <T> type of data in list
     */
    public static <T extends Comparable<T>> List<T> sort(List<T> list) {
        // Deep copy existing list
        List<T> sortedList = copy(list);


        for(int i = 0; i < sortedList.size(); i++){ // loop through each item

            int swapIndex = i;

            for(int j = i + 1; j < sortedList.size(); j++){ // loop through all right items
                int compareResult = sortedList.get(j).compareTo(sortedList.get(swapIndex));

                // Running counter of smallest element
                if(less(sortedList.get(swapIndex), sortedList.get(j))){
                    swapIndex = j;
                }

            }

            // Swap
            swap(sortedList, i, swapIndex);
        }

        return sortedList;
    }

    public static <T> void printAnswer(List<T> list){
        System.out.println();
        for(T item : list){
            System.out.print(item + ", ");
        }
    }

    public static void main(String[] args){
        List<Integer> unsortedList = Arrays.asList(3, 6, 8, 1, 9, 4, 2, 7, 5);
        List<Integer> sortedList = sort(unsortedList);
        printAnswer(sortedList);

        List<String> unsortedListStr = Arrays.asList("a", "d", "c", "b");
        List<String> sortedListStr = sort(unsortedListStr);
        printAnswer(sortedListStr);
    }
}

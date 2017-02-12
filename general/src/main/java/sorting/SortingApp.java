package sorting;


import java.util.Random;

import static sorting.BubbleSort.bubbleSort;
import static sorting.CountingSort.countingSort;

public class SortingApp {

    public static void main(String[] args) {
        int size = 10000000; // 10 mln max from IDE, 100 mln with hip java -Xmx2048m
        int[] arr = getArrayWithRandomIntegers(size);

//        long bubbleTime = bubbleSort(arr);
//        System.out.println("bubbleTime=" + bubbleTime);
        long countingTime = countingSort(arr);
        System.out.println("countingTime=" + countingTime);
    }

    private static int[] getArrayWithRandomIntegers(int size) {
        Random random = new Random();
        int[] arr = new int[size];
        for (int index = 0; index < size; index++) {
            arr[index] = random.nextInt(size);
        }
        return arr;
    }
}

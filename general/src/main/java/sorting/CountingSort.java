package sorting;

import static sorting.SortingApp.notifyIfNotSorted;

public class CountingSort {
    public static long countingSort(int[] arr) {
        int cycles = 0;
        long start0 = System.currentTimeMillis();

        // array to be sorted in, this array is necessary
        // when we sort object datatypes, if we don't,
        // we can sort directly into the input array
        int[] aux = new int[arr.length];

        long start1 = System.currentTimeMillis();

        // find the smallest and the largest value
        int min = arr[0];
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            cycles++;
            if (arr[i] < min) {
                min = arr[i];
            } else if (arr[i] > max) {
                max = arr[i];
            }
        }
        System.out.println("Find smallest time = " + (System.currentTimeMillis() - start1));

        // init array of frequencies
        int[] counts = new int[max - min + 1];

        long start2 = System.currentTimeMillis();

        // init the frequencies
        for (int i = 0; i < arr.length; i++) {
            cycles++;
            counts[arr[i] - min]++;
        }
        System.out.println("Init the frequencies time = " + (System.currentTimeMillis() - start2));

        long start3 = System.currentTimeMillis();

        // recalculate the array - create the array of occurences
        counts[0]--;
        for (int i = 1; i < counts.length; i++) {
            cycles++;
            counts[i] = counts[i] + counts[i - 1];
        }
        System.out.println("Create the array of occurences time = " + (System
          .currentTimeMillis() - start3));


    /*
      Sort the array right to the left
      1) Look up in the array of occurences the last occurence of the given value
      2) Place it into the sorted array
      3) Decrement the index of the last occurence of the given value
      4) Continue with the previous value of the input array (goto set1),
         terminate if all values were already sorted
    */
        long start4 = System.currentTimeMillis();

        for (int i = arr.length - 1; i >= 0; i--) {
            cycles++;
            aux[counts[arr[i] - min]--] = arr[i];
        }
        System.out.println("Sort the array right to the left time = " + (System
          .currentTimeMillis() - start4));


        /* Return time spent for sorting (and notify if not sorted) */
        long finish = System.currentTimeMillis();

        notifyIfNotSorted(aux);
        System.out.println("Cycles = " + cycles);
        return finish - start0;
    }

}

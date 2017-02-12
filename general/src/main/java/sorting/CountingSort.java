package sorting;

public class CountingSort {
    public static long countingSort(int[] arr) {
        long start = System.currentTimeMillis();

        // array to be sorted in, this array is necessary
        // when we sort object datatypes, if we don't,
        // we can sort directly into the input array
        int[] aux = new int[arr.length];

        // find the smallest and the largest value
        int min = arr[0];
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            } else if (arr[i] > max) {
                max = arr[i];
            }
        }

        // init array of frequencies
        int[] counts = new int[max - min + 1];

        // init the frequencies
        for (int i = 0;  i < arr.length; i++) {
            counts[arr[i] - min]++;
        }

        // recalculate the array - create the array of occurences
        counts[0]--;
        for (int i = 1; i < counts.length; i++) {
            counts[i] = counts[i] + counts[i-1];
        }

    /*
      Sort the array right to the left
      1) Look up in the array of occurences the last occurence of the given value
      2) Place it into the sorted array
      3) Decrement the index of the last occurence of the given value
      4) Continue with the previous value of the input array (goto set1),
         terminate if all values were already sorted
    */
        for (int i = arr.length - 1; i >= 0; i--) {
            aux[counts[arr[i] - min]--] = arr[i];
        }

        long finish = System.currentTimeMillis();

        return finish - start;
    }
}

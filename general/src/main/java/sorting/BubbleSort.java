package sorting;

public class BubbleSort {
    public static long bubbleSort(int[] arr) {
        long start = System.currentTimeMillis();

        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        long finish = System.currentTimeMillis();
        return finish - start;
    }
}

// package sorting.array;

import java.util.Arrays;

public class SelectionSort {
    // Selection sort works by repeatedly finding the maximum element from the unsorted part of the array and placing it at the end. Then it continues with the remaining unsorted portion (n-1, n-2, and so on) until the array is sorted.

    public static void main(String[] args) {
        int []arr={5,4,3,2,1};
        for (int i = 0; i < arr.length; i++) {
            int maxInd=0;
            for (int j = 0; j < arr.length-i; j++) {
                if(arr[maxInd]<arr[j]){
                    maxInd=j;
                }
            }
            swap(arr,maxInd,arr.length-i-1);
        }

        System.out.println(Arrays.toString(arr));
    }

    public static void swap(int[]arr, int s, int e){
        int temp=arr[s];
        arr[s]=arr[e];
        arr[e]=temp;
    }
}

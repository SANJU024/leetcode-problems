// package sorting.array;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int []arr={5,4,3,2,1};
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length-i; j++) {
                if(j<arr.length-1 && arr[j]>arr[j+1]){
                    swap(arr,j,j+1);
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void swap(int []arr, int s, int e){
        int temp=arr[s];
        arr[s]=arr[e];
        arr[e]=temp;
    }

}

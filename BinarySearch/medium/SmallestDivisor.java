import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SmallestDivisor {
    public static void main(String[] args) {
        int[]arr1={1,2};
        int[]arr2={3,4};
        
        System.out.println(findMedianSortedArrays(arr1, arr2));
        
    }
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int j=0,i=0;
        int n1=nums1.length, n2=nums2.length;
        int[]arr = new int[n1+n2];
        int k=0;
        while(i<n1 && j<n2){
            if(nums1[i]<nums2[j]){
                arr[k++]=nums1[i];
                i++;
            }else{
                arr[k++]=nums2[j];
                j++;
            }
        }


        while(i<n1){
            arr[k++]=nums1[i];
            i++;
        }

        while(j<n2){
            arr[k++]=nums1[j];
            j++;
        }

        System.out.println(Arrays.toString(arr));
        int n=arr.length;
        if(n%2==0){
            int sum=arr[n/2]+arr[(n-1)/2];
            return (double)sum/2;
        }
        return (double)arr[n/2];
    }
}

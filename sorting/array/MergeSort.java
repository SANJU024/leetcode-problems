import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[]arr={9,5,8,7,4,1,2,3,6};
        partition(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
        int n=10;
        System.out.println(n--);
    }

    public static void partition(int[] arr, int s, int e) {
        if(s>=e){
            return ;
        }

        int mid=s+(e-s)/2;
        partition(arr, s, mid);
        partition(arr, mid+1, e);

        merge(arr, s, mid, e);
    }

    public static void merge(int[] arr, int s, int mid, int e) {
        int[] temp = new int[e-s+1];
        int i=s, j=mid+1, k=0;

        while(i<=mid && j<=e){
            if(arr[i]<arr[j]){
                temp[k++]=arr[i++];
            }else{
                temp[k++]=arr[j++];
            }
        }

        while(i<=mid){
            temp[k++]=arr[i++];
        }

        while(j<=e){
            temp[k++]=arr[j++];
        }

        for(int l=0;l<temp.length;l++){
            arr[s+l]=temp[l];
        }
    }
}

// package BinarySearch;

public class FindEleInInfinArr {
    public static void main(String[] args) {
        int arr[]= {1,2,4,6,7,9,10,15,17,18,19,20,22};
        int target=6;
        System.out.println(answer(arr,target));
    }

    public static int answer(int[]arr, int target){
        int s=0, e=1;

        while(target>arr[e]){
            int newStart=e+1;
            e=e+(e-s+1)*2;
            s=newStart;
        }
        return binarySearch(arr, target,s,e);
    }
    public static int binarySearch(int[]arr, int target,int s, int e){
        while(s<=e){
            int mid=s+(e-s)/2;
            if(arr[mid]==target){
                return mid;
            }else if(target<arr[mid]){
                e=mid-1;
            }else{
                s=mid+1;
            }
        }
        return -1;
    }
}

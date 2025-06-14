public class PeakInMountArr {
    public static void main(String[] args) {
        int[]arr={0,1,2,3,4,5,1};
        System.out.println(findPeak(arr));
        System.out.println(findPeak2(arr));
    }
    public static int findPeak(int[]arr){
        int  s=0, e= arr.length-1;
        while(s<=e){
            int mid=s+(e-s)/2;
            if(arr[mid]>arr[mid+1] && arr[mid]>arr[mid-1]){
                return mid;
            }else if(arr[mid]<arr[mid+1]){
                s=mid+1;
            }else{
                e=mid-1;
            }
        }
        return -1;
    }

    public static int findPeak2(int[]arr){
        int s=0,e=arr.length-1;
        while(s<e){
            int mid=s+(e-s)/2;
            if(arr[mid]<arr[mid+1]){
                s=mid+1;
            }else{
                e=mid;
            }
        }
        return  e;
    }
}

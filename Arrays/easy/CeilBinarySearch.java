public class CeilBinarySearch {
    static int []arr={1,2,3,5,6,8,10};
    public static void main(String[] args) {
        int s=0, e=arr.length-1;
        int target=7;
        boolean got=false;
        while(s<=e){
            int mid=(s+e)/2;
            if(arr[mid]==target){
                System.out.println(mid);
            } else if (target<arr[mid]){
                e=mid-1;
            }
            else{
                s=mid+1;
            }
        }
        if(!got){
            System.out.println(arr[s]);
        }
    }
}



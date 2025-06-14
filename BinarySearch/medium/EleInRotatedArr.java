public class EleInRotatedArr {
    public static void main(String[] args) {
        int arr[]={12,15,18,2,3,6,10};
        int pivot=findPivot(arr);
        System.out.println("Pivot: "+(int)(pivot+1));
        System.out.println("Rotation count: "+countRotation(arr, pivot));
        // int []nums={4,5,6,7,8};
        // System.out.println(findPivotWithDuplicate(nums));
    }

    public static int findPivot(int[] arr) {
        int s=0, e=arr.length-1;
        while(s<=e){
            int mid=s+(e-s)/2;
            if(mid<e && arr[mid]>arr[mid+1]){
                return mid;
            }if (arr[mid]< arr[mid-1]) {
                return mid-1;
            }if(arr[mid]<=arr[s]){
                s=mid+1;
            }else{
                e=mid-1;
            }   
        }
        return -1;
    }

    public static int findPivotWithDuplicate(int[] arr) {
        int s=0, e=arr.length-1;
        while(s<=e){
            int mid=s+(e-s)/2;
            if(mid<e && arr[mid]>arr[mid+1]){
                return mid;
            }if (arr[mid]< arr[mid-1]) {
                return mid-1;
            }if(arr[mid]==arr[s] && arr[mid]==arr[e]){
                if(arr[s]>arr[s+1]){
                    return s;
                }
                s++;
                if(arr[e]<arr[e-1]){
                    return e-1;
                }
                e--;
            }else if(arr[s]<arr[mid] || (arr[mid]==arr[s] && arr[mid]>arr[e])){
                s=mid+1;
            }
            else{
                e=mid-1;
            }   
        }
        return -1;
    }

    public static int countRotation(int []arr, int pivot){
        int ans=0;
        for (int i = pivot; i >=0; i--) {
            ans+=1;
        }
        return ans;
    }
}

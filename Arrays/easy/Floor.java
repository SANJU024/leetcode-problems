class Floor extends CeilBinarySearch{
    public static void main(String[] args) {
        // static int []arr={1,2,3,5,6,8,10};
        System.out.println(floorBS(0, arr.length-1, 7, arr));
    }
    public static int floorBS(int s, int e, int target, int[]arr){
        while(s<=e){
            int mid=(s+e)/2;
            if(arr[mid]==target){
                return mid;
            }else if(target>arr[mid]){
                s=mid+1;
            }else{
                e=mid-1;
            }
        }
        return arr[e];
    }
}
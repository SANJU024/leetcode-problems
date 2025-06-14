// package hard;

public class FindInMountArr {
 
    public static void main(String[] args) {
        int[]mountainArr={5,1,3};
        int target=2;
        int peakInd=peak(mountainArr); 
        System.out.println(peakInd);
        int left=search(mountainArr,0,peakInd, target);
        int right=rSearch(mountainArr,peakInd+1,mountainArr.length-1,target);

        System.out.println("left:"+left);
        System.out.println("right:"+right);

        if(left!=-1){
            System.out.println(left);
        }else{
            System.out.println(right);
        }
    }

    public static int peak(int[] arr){
        int s=0,  e=arr.length-1;
        while(s<e){
            int mid = s+(e-s)/2;
            if(mid>0&&arr[mid]<arr[mid-1]){
                e=mid-1;
            }else{
                s=mid+1;
            }
        }
        return s;
    }

    public static int search(int[] arr, int s, int e,int target){
        while(s<=e){
            int mid = s+(e-s)/2;
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

    public static int rSearch(int[] arr, int s, int e,int target){
        while(s<=e){
            int mid = s+(e-s)/2;
            if(arr[mid]==target){
                return mid;
            }else if(target<arr[mid]){
                s=mid+1;
            }else{
                e=mid-1;
            }
        }
        return -1;
    }

}


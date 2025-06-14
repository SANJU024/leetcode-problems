

public class SplitArrLargestSum {
    public static void main(String[] args) {
        int[]nums={7,2,5,10,8};
        int m=2;

        int start=getMax(nums);
        int end=getSum(nums);

        while(start<end){
            int mid=(start+end)/2; 
            
            int sum=0;
            int pieces=1;
            
            for(int n:nums){
                if(sum+n>mid){
                    sum=n;
                    pieces++;
                }else{
                    sum+=n;
                }
            }
            if(pieces>m){
                start=mid+1;
            }else{
                end=mid;
            }

        }
        System.out.println(end);
    }
    
    public static int getMax(int[]arr){
        int maxi=0;
        for (int i = 0; i < arr.length; i++) {
            maxi=Math.max(maxi,arr[i]);
        }
        return maxi;
    }

    public static int getSum(int[]arr){
        int sum=0;
        for (int i = 0; i < arr.length; i++) {
            sum+=arr[i];
        }
        return sum;
    }
}

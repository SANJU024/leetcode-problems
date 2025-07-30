import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MergeTwoSortedArr{
    public static int count =0;
    public static void main(String[] args) {
        int [] nums={1,3,2,3,1}; //1,2,3
                                 //2,3,4   

        sort(nums,0,nums.length-1);
        System.out.println(Arrays.toString(nums));
        System.out.println(count);
    }

    public static  void sort(int[]nums, int s, int e){
        if(s>=e) return;
        int mid=s+(e-s)/2;
        sort(nums, s, mid);
        sort(nums, mid+1, e);
        merge(nums,s,mid,e);
    }

    public static void merge(int[]nums,int low, int mid, int hi){
        int i=low,j=mid+1,k=0;
        int[] temp= new int [hi-low+1];

        int right=mid+1;
        for(int m=low;m<=mid;m++){
            while(right<=hi && nums[m]>2*nums[right]){
                right++;
            }
            count+=right-(mid+1);
        }

        while(i<=mid && j<=hi){
            if(nums[i]<nums[j]){
                temp[k++]=nums[i++];
            }else{
                temp[k++]=nums[j++];
            }
        }

        while(i<=mid)temp[k++]=nums[i++];
        while(j<=hi)temp[k++]=nums[j++];

        for(int l=0;l<temp.length;l++){
            nums[l+low]=temp[l];
        }
    }

}

// Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue.

// We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.

// You must solve this problem without using the library's sort function.
// https://leetcode.com/problems/sort-colors/

class sortColors {
    public void sortColors(int[] nums) {
        partition(nums,0,nums.length-1);
    }
    public void partition(int[]nums,int si,int ei){
        if(si>=ei) return;
        int mid=si+(ei-si)/2;
        partition(nums,si,mid);
        partition(nums,mid+1,ei);
        merge(nums,si,mid,ei);
    }
    public void merge(int[]nums,int si, int mid, int ei){
        int[]temp=new int[ei-si+1];
        int i=si;
        int j=mid+1;
        int k=0;

        while(i<=mid && j<=ei){
            if(nums[i]<nums[j]){
                temp[k]=nums[i];
                i++;
            }else{
                temp[k]=nums[j];
                j++;
            }
            k++;
        }

        while(i<=mid){
            temp[k]=nums[i];
            i++;
            k++;
        }

        while(j<=ei){
            temp[k]=nums[j];
            j++;
            k++;
        }

        for(k=0,i=si; k<temp.length;k++,i++){
            nums[i]=temp[k];
        }
    }
}
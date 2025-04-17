// Given an integer array nums, find the subarray with the largest sum, and return its sum.

// Example 1:

// Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
// Output: 6
// Explanation: The subarray [4,-1,2,1] has the largest sum 6.
// https://leetcode.com/problems/maximum-subarray/
class Solution {
    public int maxSubArray(int[] nums) {
        int maxi=Integer.MIN_VALUE;
        int currSum=0;
        for(int i=0;i<nums.length;i++){
            currSum+=nums[i];
            if(nums[i]>currSum){
                currSum=nums[i];
            }
            maxi=Math.max(maxi,currSum);
        }
        return maxi;
    }
}
// Given an array nums of size n, return the majority element.

// The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.

// Example 1:

// Input: nums = [3,2,3]
// Output: 3
// https://leetcode.com/problems/majority-element/
import java.util.*;
class MajorityElement {
    public int majorityElement(int[] nums) {
        int matchFreq=nums.length/2;
        Map<Integer,Integer> hm = new HashMap<>();

        for(int num : nums){
            hm.put(num , hm.getOrDefault(num,0)+1);//key=ele , val=freqency/appearance count
        }

        for(Map.Entry<Integer,Integer> entry : hm.entrySet()){ 
            //ex:[3,2,3]
            //entrySet()=>3=2 , 2=1
            if(entry.getValue()>matchFreq) return entry.getKey();
        }
        return 0;
    }
}
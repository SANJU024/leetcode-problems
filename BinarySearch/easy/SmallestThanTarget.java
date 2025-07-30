// package BinarySearch.easy;

import java.util.Stack;

public class SmallestThanTarget {
    public static void main(String[] args) {
        char[]nums={'c','f','j'};
        char target='c';

        System.out.println(search(nums,target));
    }

    public static char search(char[] letters, char target){
        int s=0,e=letters.length-1;

        Stack<Integer> st = new Stack<>();
        while(s<=e){
            int mid=s+(e-s)/2;
            System.out.println("mid: "+mid);
            if(letters[mid]>target){
                e=mid-1;
            }else{
                s=mid+1;
            }
        }
        System.out.println("S: "+s);
        System.out.println(1%3);
        return letters[s%letters.length];
    }
}

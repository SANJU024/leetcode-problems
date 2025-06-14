public class SplitArrLargestSum {
    public static void main(String[] args) {
        int[]nums={7,2,5,10,8};
        int m=2;

        //brute force;
        int maxi=0;
        int min=Integer.MAX_VALUE;
        for (int i = 1; i < nums.length; i++) {
            int sumL=0;
            int j;
            for (j = 0; j < nums.length-i; j++) {
                sumL+=nums[j];
            }
            // maxi=Math.max(maxi,sumL);
            int sumR=0;
            for (int k = j; k < nums.length; k++) {
                sumR+=nums[k];
            }
            // maxi=Math.max(maxi,sumR);
            min=Math.min(min,Math.max(sumL,sumR));
        }
        System.out.println(min);
    }  
}

import java.util.Arrays;

public class CountingSort {
    public static void main(String[] args) {
        int[]arr={5,4,3,2,1};
        
        int max=Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]>max){
                max=arr[i];
            }
        }

        int count[]= new int[max+1];

        for(int i=0;i<arr.length;i++){
            count[arr[i]]++;
        }
        int ind=0;
        for (int i = 0; i < count.length; i++) {
            while(count[i]>0){
                arr[ind]=i;
                count[i]--;
                ind++;
            }
        }

        System.out.println(Arrays.toString(arr));

    }
}

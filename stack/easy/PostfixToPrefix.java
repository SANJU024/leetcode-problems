import java.util.Arrays;
import java.util.Stack;

public class PostfixToPrefix extends PostfixToInfix{
    public static void main(String[] args) {
        String s = "AB-DE+F*/";
        // System.out.println(postfixToPrefix(s));
        // System.out.println(0%3);
        int[]nums={1,2,1};
        int size=nums.length;
        int[]ans= new int[size];
        int k=0;
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                if(nums[j%size]>nums[i]){
                    ans[k]=nums[j%size];
                    break;
                }else{
                    ans[k]=-1;
                }
            }
            k++;
        }
        System.out.println(Arrays.toString(ans));
    }
    public static String postfixToPrefix(String s){
        int n=s.length();
        int i=0;
        Stack<String> st = new Stack<>();

        while(i<n){
            char ch = s.charAt(i);
            if(isOperand(ch)){
                st.push(ch+"");
            }else{
                String t1=st.pop();
                String t2=st.pop();
                String t=ch+t2+t1;
                st.push(t);
            }
            i++; 
        }
        return st.toString();   
    }
}

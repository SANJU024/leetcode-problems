import java.util.Stack;

public class PostfixToInfix extends InfixToPost {
    public static void main(String[] args) {
        String s = infixToPostfix("(A-B)/((D+E)*F)");
        System.out.println(postfixToInfix(s));
    }
    public static String postfixToInfix(String s){
        Stack<String> st  = new Stack<>();
        int i=0;
        int n=s.length();
        while (i<n) {
            char ch = s.charAt(i);
            if(isOperand(ch)){
                st.push(ch+"");
            }else{
                String t1=st.pop();
                String t2=st.pop();
                String t="("+t2+ch+t1+")";
                st.push(t);
            }
            i++;
        }
        return st.toString();
    }

    // (A-B)/((D+E)*F)
    public static boolean isOperand(char ch){
        if((ch>='A'&&ch<='Z')||(ch>='A'&&ch<='Z')||(ch>='0'&&ch<='9')){
            return true;
        }
        return false;
    }
}

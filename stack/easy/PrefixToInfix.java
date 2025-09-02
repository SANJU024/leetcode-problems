import java.util.Stack;

public class PrefixToInfix {
    public static void main(String[] args) {
        String s ="+-*+ABCDF";
        System.out.println(PrefixToInfix(s.strip()));
    }

    public static boolean isOperand(char ch){
        if((ch>='A'&&ch<='Z')||(ch>='A'&&ch<='Z')||(ch>='0'&&ch<='9')){
            return true;
        }
        return false;
    }
    public static String PrefixToInfix(String s){
        int n=s.length()-1;
        Stack<String> st = new Stack<>();

        while (n>=0) {
            char ch = s.charAt(n);
            if(isOperand(ch)){
                st.push(ch+"");
            }else{
                String t1=st.pop();
                String t2=st.pop();
                String t ="("+t1+ch+t2+")";
                st.push(t);
            }
            n--;
        }
        return st.toString();
    }
}

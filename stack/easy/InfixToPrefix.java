import java.util.Stack;

public class InfixToPrefix extends InfixToPost {
    public static void main(String[] args) {
        String s ="(A+B)*C-D+F";
        System.out.println("Infix: "+s);;
        System.out.println("Prefix: "+infixTOPrefix(s));
    }

    public static String infixTOPrefix(String s){
        int n  = s.length()-1;
        Stack<Character> st =  new Stack<>();
        String ans ="";
        while(n>=0){
            char ch=s.charAt(n);
            if((ch>='A'&& ch<='Z')||(ch>='a'&& ch<='a')||(ch>='0'&& ch<='9')){
                ans+=ch;
            }else if(ch==')'){//'('
                st.push(')');
            }else if(ch=='('){//')'
                while (!st.isEmpty() && st.peek()!=')') {
                    ans+=st.pop();
                }
                st.pop();
            }else{
                while(!st.isEmpty() && priority(st.peek())>priority(ch) && st.peek()!=')'){
                    ans+=st.pop();
                }
                st.push(ch);
            }
            n--;
        }
        while(!st.isEmpty()){
            ans+=st.pop();
        }
        System.out.println(ans);
        StringBuilder sb = new StringBuilder(ans).reverse();
        return sb.toString();
    }
}

import java.util.Stack;

public class InfixToPost {
    public static void main(String[] args) {
        String s = "(A-B)/((D+E)*F)";   
        System.out.println("Infix: " + s);
        System.out.println("Postfix: " + infixToPostfix(s));
        System.out.println("ans: AB-DE+F*/");
    }

    public static String infixToPostfix(String s) {
        Stack<Character> operator = new Stack<>();
        String ans = "";
        int n = s.length();

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);

            if ((ch >= 'A' && ch <= 'Z') || (ch >= 'a' && ch <= 'z') || (ch >= '0' && ch <= '9')) {
                ans += ch;
            } else if (ch == '(') {
                operator.push(ch);
            } else if (ch == ')') {
                while (!operator.isEmpty() && operator.peek() != '(') {
                    ans += operator.pop();
                }
                operator.pop(); // remove '('
            } else {
                while (!operator.isEmpty() && operator.peek() != '(' &&
                        priority(operator.peek()) <= priority(ch)) {
                    ans += operator.pop();
                }
                operator.push(ch);
            }
        }

        while (!operator.isEmpty()) {
            ans += operator.pop();
        }

        return ans;
    }

    public static int priority(char ch) {
        if (ch == '*' || ch == '/' || ch == '%') return 2;
        if (ch == '+' || ch == '-') return 1;
        if(ch=='^') return 3;
        return -1; // default for '('
    }
}

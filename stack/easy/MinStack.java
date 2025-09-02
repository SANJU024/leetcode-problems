import java.util.Stack;

public class MinStack {
    static Stack<Integer> st = new Stack<>();
    static Stack<Integer> minSt = new Stack<>();
    public static void main(String[] args) {
        // myPush(1);
        // myPush(7);
        // myPush(10);
        // myPush(0);
        // myPop();
        System.out.println(minSt.peek());
    }

    public static void myPush(int val){
        st.push(val);
        minStack(val);
    }

    public static int myPop(){
        int curr=st.pop();
        Stack<Integer> temp = new Stack<>();
        while(!minSt.isEmpty()){
            if(minSt.peek()==curr){
                minSt.pop();
            }else{
            temp.push(minSt.pop());
            }
        }

        while(!temp.isEmpty()){
            minSt.push(temp.pop());
        }

        return curr;
    }

    
    public static void minStack(int val){
        if(minSt.isEmpty()){
            minSt.push(val);
            return;
        }

        if(minSt.peek()<val){
            int temp = minSt.pop();
            minStack(val);
            minSt.push(temp);
        }else{
            minSt.push(val);
        }
    }
    
}

import java.util.Stack;

public class SortUsingRecurrsion {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(5);
        stack.push(4);
        stack.push(3);
        stack.push(2);
        stack.push(1);
        System.out.println(stack);
        sortStack(stack);
        System.out.println(stack);
        System.out.println(1<<2);
    }

    public static void sortStack(Stack<Integer> stack){
        if(!stack.isEmpty()){
            int top=stack.pop();
            sortStack(stack);
            System.out.println("sending "+top);
            insertReverse(stack,top);
            // insertIntoStack(stack,top);
        }
    }

    public static void insertReverse(Stack<Integer> stack, int element){
        if(stack.isEmpty()){
            System.out.println("insertng "+element);
            stack.push(element);
        }else{
            int top=stack.pop();
            insertIntoStack(stack, element);
            System.out.println("insertng "+element);
            stack.push(top);
        }

    }

    public static void insertIntoStack(Stack<Integer> stack, int element){
        if(stack.isEmpty() || stack.peek()<=element){
            stack.push(element);
        }else{
            int top= stack.pop();
            insertIntoStack(stack, element);
            stack.push(top);
        }
    }
}

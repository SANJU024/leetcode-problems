// package stack.implimentation;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;
import java.util.Stack;

public class UsingList {
    int ptr=-1;
    List<Integer>st= new ArrayList<>();

    public void push(int val){
        ptr++;
        st.add(ptr,val);
    }

    public int pop(){
        if(ptr>-1){
            int removed=st.get(ptr);
            ptr--;
            return removed;
        }
        throw new EmptyStackException();
    }

    public int peek(){
        if(ptr>-1){
            return st.get(ptr);
        }
        throw new EmptyStackException();
    }

    public int size(){
        return ptr+1;
    }

    public static void main(String[] args) {

        // Stack<Integer> st = new Stack<>();

        // st.
        UsingList st = new UsingList();
        st.push(1);
        st.pop();
        st.push(2);
        st.push(3);
        st.push(7);
        st.push(5);

        st.peek();//7
        System.out.println(st.pop());//5

        st.peek();//7
        System.out.println(st.pop());//7

        st.peek();//7
        System.out.println(st.pop());//7

        st.peek();//7
        System.out.println(st.pop());//7

        st.peek();//7
        System.out.println(st.pop());//7
    }


}

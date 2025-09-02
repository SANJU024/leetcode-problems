// package queue.Implementation;

import java.util.EmptyStackException;

public class UsingLL {
    Node head;
    Node ptr;
    int size=0;

    class Node{
        int val;
        Node next;

        Node(int val){
            this.val=val;
        }
    }

    public void push(int val){
        size++;
        Node newNode= new Node(val);
        if(head==null){
            head=newNode;
            ptr=head;
            return;
        }
        ptr.next=newNode;
        ptr=ptr.next;
    }

    public int pop(){
        if(size==0) throw new EmptyStackException();
        size--;

        int removed=head.val;
        head=head.next;
        if(head==null)ptr=null;
        return removed;
    }

    public int peek(){
        return head.val;
    }

    public int size(){
        return size;
    }
}

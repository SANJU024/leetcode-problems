import java.util.EmptyStackException;
import java.util.LinkedList;
import java.util.Queue;

public class UsingLinkedList {
    Node head;

    class Node{
        int val;
        Node next;

        public Node(){

        }

        public Node(int val){
            this.val=val;
        }
    }
    int ptr=0;
    
    public  void push(int val){
        ptr++;
        Node newHead= new Node(val);
        newHead.next=head;
        head=newHead;
    }

    public int  pop(){
        if(head==null) throw new EmptyStackException();
        ptr--;
        int removed=head.val;
        head=head.next;
        return removed;
    }


    public void display(){
        Node temp=head;
        System.out.print("[");
        while(temp!=null){
            System.out.print(temp.val+",");
            temp=temp.next;
        }
        System.out.print("]");
        System.out.println();
    }

    public int size(){
        return ptr;
    }

    public int top(){
        return head.val;
    }

    public static void main(String[] args) {
        UsingLinkedList ul = new UsingLinkedList();
        // ul.push(5);
        // ul.push(4);
        // ul.push(3);
        // ul.push(2);
        // System.out.println(ul.top());
    }
}

// package LinkedList.Basics;

public class Reverse extends SinglyLL{

    public void reverse(){
        if(head==null || head.next==null){
            return;
        }

        ListNode prev=null, curr=head, nextN=null;
        while(curr!=null){
            nextN=curr.next;
            curr.next=prev;
            prev=curr;
            curr=nextN;
        }
        head=prev;
    }
    public static void main(String[] args) {
        Reverse ll = new Reverse();
        ll.insert(1);
        ll.insert(2);
        ll.insert(3);
        ll.insert(4);
        ll.insert(5);
        ll.display();
        ll.reverse();
        ll.display();
    }
}

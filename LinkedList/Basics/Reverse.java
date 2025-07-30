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

    public ListNode reverse2(){
        return reverse2(head);
    }

    private ListNode reverse2(ListNode head){
        if(head==null || head.next!=null) return head;

        ListNode newHead=reverse2(head.next);
        ListNode front = head.next;
        front.next=head;
        head=null;
        return newHead;
    }

    public void display2(){
        ListNode rHead=reverse2(head);
        display2(rHead);
    }

    private void display2(ListNode head){
        ListNode temp=head;
        while(temp!=null){
            System.out.print(temp.val+"->");
            temp=temp.next;
        }
        System.out.print("null");
        System.out.println();

    }
 
    public static void main(String[] args) {
        Reverse ll = new Reverse();
        ll.insert(1);
        ll.insert(2);
        ll.insert(3);
        ll.insert(4);
        ll.insert(5);
        ll.display();
        // ll.reverse2();
        ll.display2();
    }
}

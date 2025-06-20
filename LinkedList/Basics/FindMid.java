// package LinkedList.Basics;

public class FindMid extends SinglyLL {
   
    public ListNode mid(){
        if(head==null || head.next==null) return head;

        ListNode fast=head,slow=head;

        while(fast!=null && fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }

        return slow;
    }
    public static void main(String[] args) {
        FindMid fm = new FindMid();
        fm.insert(1);
        fm.insert(2);
        fm.insert(3);
        fm.insert(4);
        fm.insert(5);
        fm.display();
        System.out.println(fm.mid().val);
    }
}

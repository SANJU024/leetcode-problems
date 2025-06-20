// package LinkedList.Basics;

public class SortLL extends SinglyLL{

    public ListNode findMid(ListNode head){
        if(head==null || head.next==null) return head;

        ListNode f=head,s=head;
        while(f.next!=null && f.next.next!=null){
            f=f.next.next;
            s=s.next;
        }

        return s;
    }

    public ListNode sort(ListNode head){
        if(head==null || head.next==null) return head;
        
        ListNode mid=findMid(head);
        ListNode rightHead=mid.next;
        mid.next=null;
        
        ListNode left=sort(head);
        ListNode right=sort(rightHead);

        return merge(left, right);
    }

    public ListNode merge(ListNode left, ListNode right){
        ListNode ansL = new ListNode(-1);
        ListNode dummy= ansL;

        while(left!=null && right!=null){
            if(left.val<right.val){
                dummy.next=left;
                left=left.next;
            }else{
                dummy.next=right;
                right=right.next;
            }
            dummy=dummy.next;
        }

        if(left!=null){
            dummy.next=left;
        }

        if(right!=null){
            dummy.next=right;
        }

        return ansL.next;
    }

    public void sort(){
        head=sort(head);
    }

    public static void main(String[] args) {
        SortLL ll = new SortLL();
        ll.insert(5);
        ll.insert(4);
        ll.insert(3);
        ll.insert(0);
        ll.insert(2);
        ll.insert(1);

        ll.display();
        ll.sort();
        ll.display();
    }
}

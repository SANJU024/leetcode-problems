

public class SinglyLL {
    public ListNode head;

    class ListNode{
        int val;
        ListNode next;
    
        ListNode(int val){
        this.val=val;
        }

        public ListNode(){

        }
    }

    public void insert(int val){
        if(head==null){
            head=new ListNode(val);
            return;
        }
        ListNode temp=head;
        while(temp.next!=null){
            temp=temp.next;
        }
        temp.next=new ListNode(val);
    }

    public void display(){
        ListNode temp=head;
        while(temp!=null){
            System.out.print(temp.val+"->");
            temp=temp.next;
        }
        System.out.print("null");
        System.out.println();
    }
    
    public void delete(int val){
        if(head==null) return;
        ListNode temp=head;

        if(head.val==val){
            head=head.next;
            return;
        }
        while(temp.next!=null){
            if(temp.next.val==val){
                temp.next=temp.next.next;
                return;
            }
            temp=temp.next;
        }
    }

    

    public static void main(String[] args) {
        SinglyLL ll = new SinglyLL();
        for(int i=1;i<6;i++){
            ll.insert(i);
        }
        System.out.println("Inserted");
        ll.display();
        ll.delete(2);
        ll.display();
    }


}

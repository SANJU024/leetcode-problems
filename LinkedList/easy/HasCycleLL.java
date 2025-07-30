
public class HasCycleLL {
    Node head;
    class Node{
        int val;
        Node next;

        public  Node(int val){
            this.val=val;
        }

        public Node(){

        }
    }
    public void insert(int val){
        if(head==null){
            head= new Node(val);
            return;
        }
        Node temp=head;
        while(temp.next!=null){
            temp=temp.next;
        }
        temp.next=new Node(val);
    }
    public boolean hasCycle(){
        return hasCycle(head);
    }

    private boolean hasCycle(Node head){
        Node fast=head, slow=head;

        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast){
                return true;
            }
        }
        return false;
    }

    public Node hasCycle2(){
        return hasCycle2(head);
    }

    private Node hasCycle2(Node head){
        //this method return the node which starts the loop or  the node which attached by the tail. 
        if(head==null || head.next==null){
            return head;
        }
        Node fast=head,slow=head;
        int length=0;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(fast==slow){
                do{
                    slow=slow.next;
                    length++;
                }while(slow!=fast);
                break;
            }
        }

        if (length==0) return null;
        Node s=head,f=head;
        while(length>0){
            s=s.next;
            length--;
        }
        while(s!=f){
            s=s.next;
            f=f.next;
        }

        return s;
    }

    public int lengthOfLoop(){
        return lengthOfLoop(head);
    }

    private int lengthOfLoop(Node head){
        Node startNode=hasCycle2(head);
        if(startNode==null)return 0;
        Node checkNode=startNode;
        int length=0;
        do{
            length++;
            checkNode=checkNode.next;
        }while(startNode!=checkNode);
        return length;
    }

    public void createLLCycle(){
        Node node1= new Node(1);
        Node node2= new Node(2);
        Node node3= new Node(3);
        Node node4= new Node(4);

        node1.next=node2;
        node2.next=node3;
        node3.next=node4;
        node4.next=node2;
        head=node1;
    }

    // package LinkedList.Basics;


    public void reverse(){
        if(head==null || head.next==null){
            return;
        }

        Node prev=null, curr=head, nextN=null;
        while(curr!=null){
            nextN=curr.next;
            curr.next=prev;
            prev=curr;
            curr=nextN;
        }
        head=prev;
    }

    public Node reverse2(){
        head =reverse2(head);
        return head;
    }

    private Node reverse2(Node head){
        if(head==null || head.next==null) return head;

        Node newHead=reverse2(head.next);
        Node front = head.next;
        front.next=head;
        head.next=null;
        return newHead;
    }

    public void display2(){
        Node rHead=reverse2();
        display2(rHead);
    }

    private void display2(Node head){
        Node temp=head;
        while(temp!=null){
            System.out.print(temp.val+"->");
            temp=temp.next;
        }
        System.out.print("null");
        System.out.println();

    }
 
    


    public static void main(String[] args) {
        HasCycleLL hc = new HasCycleLL();
        hc.insert(1);
        hc.insert(2);
        hc.insert(3);
        hc.insert(4);
        hc.insert(5);
        hc.display2();

        // hc.createLLCycle();
        // System.out.println(hc.hasCycle2().val);
        // System.out.println(hc.lengthOfLoop());
    }
}

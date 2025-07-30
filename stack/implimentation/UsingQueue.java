import java.util.LinkedList;
import java.util.Queue;

public class UsingQueue {

    Queue<Integer> qu = new LinkedList<>();
    public void push(int val){
        int size =qu.size();
        System.out.println("size "+size);
        qu.offer(val);
        for(int i=0;i<size;i++){
            qu.add(qu.poll());
            System.out.println("i="+ i);
        }
        System.out.println();
    }

    public int pop(){
        return qu.poll();
    }

    public int top(){
        return qu.peek();
    }

    public static void main(String[] args) {
        UsingQueue uq = new UsingQueue();
        uq.push(1);
        uq.push(2);
        uq.push(3);
        uq.push(4);
        System.out.println(uq.pop());

    }
}

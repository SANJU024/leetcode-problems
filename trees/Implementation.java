// package trees;

public class Implementation {
    class Tree{
        int val;
        Tree left;
        Tree right;

        Tree(int val){
            this.val=val;
        }
        Tree(){

        }

        
    }
    Tree root;

    public void insert(int val){
        if(root==null){
            root=new Tree(val);
        }
    }
}

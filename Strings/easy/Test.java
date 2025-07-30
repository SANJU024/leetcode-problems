public class Test{
    int age;

    @Override
    public String toString(){
        return "helllo";
    }

    public void hello(){
        System.out.println("Hello, Sanjay K I");
    }

    public static void main(String[] args) {
        // Test t = new Test();
        // System.out.println(t);
        // t.hello();
        int i=10;
        test(i);
        
        System.out.println("I value after loop: "+i);
    }
    public static void test(int i){
        while(i>0){
            System.out.println(i);
            i--;
        }
        System.out.println(i+" after the loop");
        for(int k=0;k<i;k++){
            System.out.println("i times");
        }
    }
}

public class ReverseString {
    public static void main(String[] args) {
        String name ="sanjay";
        int s=0,e = name.length()-1;
        StringBuilder sb = new StringBuilder(name);

        while(s<=e){
            char ch=sb.charAt(s);
            sb.setCharAt(s, sb.charAt(e));
            sb.setCharAt(e, ch);
            s++;
            e--;
        }
        name=sb.toString();
        System.out.println(name);
    }
}

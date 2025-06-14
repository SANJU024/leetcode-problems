class CheckStringRotation{
    public static void main(String[] args) {
        String s ="abcde";
        String goal="cdeab";

        System.out.println(check(s,goal));
    }

    public static  boolean check(String s , String goal){
        if(s.equals(goal)) return true;
        char ch=s.charAt(s.length()-1);
        return check(ch+s.substring(0,s.length()-1), goal);
    }
}
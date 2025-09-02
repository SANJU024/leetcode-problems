


class StringToInteger{
    public static void main(String[] args) {
        System.out.println(countGoodNumbers(50));
        StringBuilder sb = new StringBuilder("djnfs");
        System.out.println(sb);
        sb.deleteCharAt(sb.length()-1);
        System.out.println(sb);
    }

    public static int countGoodNumbers(long n) {
        if(n==1) return 5;
        long even =(n%2==0)?n/2:n/2+1;
        long odd= n/2;

        long evenPro=product(even,5)%1000000007;
        long oddPro=product(odd,4)%1000000007;

        long ans=(evenPro*oddPro)%1000000007;
        return (int)ans%1000000007;//564908303
    }

    public static long product(long indeces, int times){
        if(indeces==1){
            return times;
        }
        return times*product(indeces-1,times);
    }

}
public class Test {
    public static void main(String[] args) {
        int[]piles={3,6,7,11};
        int h=8;
        System.out.println(minEatingSpeed(piles,h));
    }
    public static int minEatingSpeed(int[] piles, int h) {
        int sum=0;
        for(int n:piles){
            sum+=n;
        }
        double ans=3/2d;
        System.out.println((int)Math.ceil(ans));
        return (int)Math.ceil(3/h);
    }
}

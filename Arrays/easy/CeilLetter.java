public class CeilLetter {
    public static void main(String[] args) {
        char[]letters = {'c','f','j'};
        char target = 'a';
        System.out.println(nextGreatestLetter(letters,target));
        System.out.println(1%3);
    }
    public static char nextGreatestLetter(char[] letters, char target) {
            int s=0,e=letters.length-1;

            while(s<=e){
                int mid=s+(e-s)/2;
                if(letters[mid]==target){
                    return letters[mid+1];
                }else if(letters[mid]<target){
                    s=mid+1;
                }else{
                    e=mid-1;
                }
                System.out.println("e: "+e+", s: "+s);
            }
        return e==-1?letters[0]:letters[e];
    }
}

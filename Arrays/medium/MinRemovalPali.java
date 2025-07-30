import java.util.HashMap;
import java.util.Map;

public class MinRemovalPali {
    public static void main(String[] args) {
        char[] arr={'c','b','b','d'};
        Map<Character, Integer> hm=  new HashMap<>();


        for(char ch:arr){
            hm.put(ch, hm.getOrDefault(ch, 0)+1);
        }
        
        int oddCount=0;
        for(int i:hm.values()){
            if(i%2!=0){
                oddCount++;
            }
        }

        hm.keySet();
        System.out.println(hm.keySet());
    }
}

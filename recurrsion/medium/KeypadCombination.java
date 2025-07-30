// package recurrsion.medium.medium;

import java.io.BufferedReader;
import java.nio.Buffer;
import java.util.*;

public class KeypadCombination {
    public static void main(String[] args) {
        // Map<Integer,String> hm;
        // hm=generateKeypadString(new HashMap<>());
        // // System.out.println(hm);
        // String num="23";
        // int n1=num.charAt(0)-'0';
        // System.out.println(n1);
        // System.out.println((char)('a'+18));
        for(int digit=2;digit<=9;digit++){
            int start=(digit==8||digit==9)?(digit-2)*3+1:(digit-2)*3;
            int end =(digit==7||digit==8)?(digit-1)*3:(digit==9)?((digit-1)*3)+1:((digit-1)*3)-1;
            System.out.println("start: "+start+" ,end: "+end);
            System.out.println((char)('a'+start));
        }
    }

    public static Map<Integer,String> generateKeypadString(Map<Integer,String>hm){
        int ptr=0;
        for(int i=2;i<=9;i++){
            if(i==7 || i==9){
                String str="";
                for(int j=0;j<4;j++){
                    str+=(char)('a'+(char)ptr);
                    ptr++;
                }
                hm.put(i,str);
            }else{
                String str="";
                for(int j=0;j<3;j++){
                    str+=(char)('a'+(char)ptr);
                    ptr++;
                }
                hm.put(i,str);
            }
        }
        return hm;
    }
}

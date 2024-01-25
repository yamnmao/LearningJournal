package Arrays_Hashing;

import java.util.HashMap;
import java.util.HashSet;

public class ValidAnagram {
    public static boolean isAnagram(String s, String t) {
        HashMap<Character,Integer> count = new HashMap<>();
        for(char x:s.toCharArray()){
            count.put(x,count.getOrDefault(x,0)+1);
            System.out.println("HashMap: " + count);
        }
        for(char x:t.toCharArray()){
            count.put(x,count.getOrDefault(x,0)-1);
            System.out.println("HashMap: " + count);
        }
        // Check if any character has non-zero frequency
        for (int val : count.values()) {
            System.out.println(val);
            if (val != 0) {
                return false;
            }
        }

        return true;
    }
public static void main(String args[]){
        String s = "anagram";
        String t = "nagaram";
        boolean answer = isAnagram(s,t);
        System.out.println(answer);

        s="car";
        t="rat";
    answer = isAnagram(s,t);
    System.out.println(answer);
    }
}


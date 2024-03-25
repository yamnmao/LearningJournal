package Arrays_Hashing;

import java.util.HashMap;
import java.util.HashSet;

/**
 * for(char x : s.toCharArray())：这个循环遍历字符串s中的每个字符。对于s中的每个字符，它执行以下操作：
 count.put(x, count.getOrDefault(x, 0) + 1);：这行代码检查字符x是否已经在HashMap中有记录。如果有，就获取它的当前计数值，然后加1；
 如果没有，就用getOrDefault方法返回默认值0，并对这个值加1。这样，每次遇到相同的字符时，其计数就会增加。
 for(char x : t.toCharArray())：这个循环遍历字符串t中的每个字符。对于t中的每个字符，它执行类似的操作，但是这次是减少计数：
 count.put(x, count.getOrDefault(x, 0) - 1);：对于t中的每个字符，它也检查HashMap中是否有该字符的记录。
 如果有，就将该字符的计数减1；如果没有，就用getOrDefault方法返回默认值0，并对这个值减1。
 如果在完成所有操作后，HashMap中所有的计数都为0，这意味着两个字符串具有相同的字符和相同数量的每个字符，尽管它们的排列顺序可能不同。
 这个技术在解决如判断两个字符串是否是变位词（即，通过重新排列字母而形成的词）这类问题时非常有用。*/
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


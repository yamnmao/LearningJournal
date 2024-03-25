package Arrays_Hashing;

import java.util.*;
import org.junit.Test;

/**
 * Given an array of strings strs, group the anagrams together. You can return the answer in any order.
 * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase,
 * typically using all the original letters exactly once.
 * Example 1:
 * Input: strs = ["eat","tea","tan","ate","nat","bat"]
 * Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
 *
 * Example 2:
 * Input: strs = [""]
 * Output: [[""]]
 *
 * Example 3:
 * Input: strs = ["a"]
 * Output: [["a"]]
 * */
/**O(nLogk), k is the length of maximum string and n is number of strings*/
public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs){
        //check for empty inputs
        if(strs == null || strs.length==0){
            return new ArrayList<>();
        }
        //create a hashmap to store the string pattern
        Map<String, Integer> mp = new HashMap<>();
        //create a list to store the strings
        List<List<String>> ans = new ArrayList<>();

        for (String str : strs) {
            /**
             * 将字符串转换成字符数组，例如："eat".toCharArray()得到['e', 'a', 't']。
             * 将字符数组排序，Arrays.sort(chars)后得到['a', 'e', 't']。
             * 将排序后的字符数组转换回字符串，String sortedStr = new String(chars)得到"aet"。*/
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String sortedStr = new String(chars);

            /**
             * 检查并分组：检查排序后的字符串"aet"是否已经存在于HashMap mp中。mp用来储存sorted string。
             * 如果不存在（如首次遇到ate（sorted后的"eat", "tea"），将其添加到mp中，并在ans中创建一个新的列表来存放这个字符串。
             * mp会记录这个排序后的字符串，创建一个key值，这个值对应的列表在ans中的索引。
             * 如果存在，找到该排序字符串对应的列表索引，然后将当前字符串添加到该列表中。*/
            /**example:String[] strs = {"eat", "tea","tan","nat"};
             * 第一步处理eat，原始状态ans和mp都是空的，eat排序后得到ate，mp没有ate，于是进入else，此时ans.size=0; put（“ate”，0）
             * 同时在list创建index =0的list，list里面的第一个string是eat
             * 第二步处理tea，排序后得到ate，mp.containsKey(ate)==true，进入if，用mp.get获得了key值=0，这个pattern在ans里面对应的索引也是0
             * ans.get（0）=[["eat"]],.add("tea) -> ans = [["eat", "tea"]]
             * 第三部处理tan，排序后得到ant，mp没有ant，进入else，ans.size=1; put（“ant”，1），以此类推
            //if the frequency string is present, add the string to the list*/
            if (mp.containsKey(sortedStr)) {
                ans.get(mp.get(sortedStr)).add(str);
                //检查是否有ate，有，mp.get("ate)=0;ans.get(0).add("tea"); ans = [["eat", "tea"]]
            } else {
                //else create a new list
                mp.put(sortedStr, ans.size());//eat-> put("ate",0)
                ans.add(new ArrayList<>(Arrays.asList(str)));//ans = [["eat"]]，mp = {"aet": 0}
                //Arrays.asList(str),给str建立一个列表，该子列表初始时仅包含一个字符串元素str
                //new ArrayList<>(Collection<? extends E> c)是ArrayList的一个构造函数，它接收一个集合作为参数，并创建一个包含相同元素的新ArrayList实例，但这个新的列表是可变的。
                //在这个场景中，将Arrays.asList(str)的结果传递给ArrayList的构造函数，创建了一个包含相同单个字符串str的新ArrayList。与通过Arrays.asList得到的列表不同，这个ArrayList是完全可变的，意味着你可以添加更多的元素、删除元素或更改其内容。
                //如果要获许子集里面的内容要用ans.get(0).get(0)
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        // 示例字符串数组
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        // 创建 GroupAnagrams 实例
        GroupAnagrams groupAnagrams = new GroupAnagrams();
        // 调用 groupAnagrams 方法并接收结果
        List<List<String>> groupedAnagrams = groupAnagrams.groupAnagrams(strs);
        // 打印分组后的变位词列表
        for (int i = 0; i < groupedAnagrams.size(); i++) {
            // 获取每个子列表
            List<String> subgroup = groupedAnagrams.get(i);
            System.out.println("Group " + (i + 1) + ": " + subgroup);
        }
    }
}

package Arrays_Hashing;
import java.util.HashSet;
import java.util.Set;

public class Longest128 {
    public int longestConsecutive(int[] nums) {
        //create a hashset and add all element to the hashset
        Set<Integer> numSet = new HashSet<Integer>();
        for(int num:nums){
            numSet.add(num);
        }
        int longest = 0;
        //loop through nums
        for(int num:numSet){
            // Check if the current number is the start of a sequence
            // A number is considered the start if there is no preceding consecutive number (i.e., num - 1 is not in the set)
            if(!numSet.contains(num-1)){
                //if yes, then num is the start point, and begin to count length
                int currentNum = num;
                int length = 1;
                // If the next consecutive number is found, update the current number and increment the sequence length
                while (numSet.contains(currentNum + 1)) {
                    currentNum += 1;
                    length += 1;
                }
                ///Update the longest sequence length if the current sequence is longer
                longest = Math.max(longest, length);
            }
        }
        return longest;
    }
}

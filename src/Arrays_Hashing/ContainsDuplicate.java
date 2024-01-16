package Arrays_Hashing;

import java.util.HashSet;

public class ContainsDuplicate {
    public boolean containsDuplicateOne(int[] nums) {
        int n = nums.length;
        for(int i = 0; i<n-1;i++)
        {
            for(int j = i+1;j<n;j++){
                if(nums[i]==nums[j]){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean containDuplicateTwo(int[] nums){
        HashSet<Integer> seen = new HashSet<>();
        for(int num:nums){
            if(seen.contains(num)){
                return true;
            }
            seen.add(num);
        }
        return false;
    }

}

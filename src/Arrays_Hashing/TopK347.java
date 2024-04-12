package Arrays_Hashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TopK347 {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> bucket1 = new HashMap<>();
        for (int num : nums) {
            bucket1.put(num, bucket1.getOrDefault(num, 0) + 1);
        }
        //Store each element's frequency as the key
        //其中的键是元素频率，值是具有该频率的所有元素的列表
        Map<Integer, List<Integer>> bucket2 = new HashMap<>();
        for (Integer num : bucket1.keySet()) {
            Integer elementFreq = bucket1.get(num);
            if (!bucket2.containsKey(elementFreq)) {
                bucket2.put(elementFreq, new ArrayList<>());
            }
            bucket2.get(elementFreq).add(num);
        }

        //Get Top K elements
        int[] res = new int[k];
        for (int n = nums.length; n > 0; n--) {
            if (bucket2.containsKey(n)) {
                List<Integer> list = bucket2.get(n);
                for (Integer integer : list) {
                    res[--k] = integer;
                    if (k == 0)
                        return res;
                }
            }
        }
        return res;
    }
}


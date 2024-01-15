package Arrays_Hashing;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Map;
/*
Given an array of integers nums and an integer target,
return indices of the two numbers such that they add up to target.
 */
class TwoSum {

    // Time complexity: O(n^2)
	//暴力解法- 嵌套loop
    public static int[] findTwoSum_BruteForce(int[] nums, int target) {
    /*nums=给出的数组，target是要求的数字，比如nums = [2,7,11,15], target = 9
    nums.length获得nums的长度; 根据上面例子nums.length = 4,index是0,1,2,3
    第一个loop的是nums[0] to nums[2](2,7,11), 第二个loop是nums[1] to nums[3](7,11,15)
    两个loop的过程是：i=0,nums[0]=2;j=1,2,3,nums[j]=7,11,15; 2+7/11/15
    i=1,nums[1]=7;j=2,3,num[j]=11,15; 7+11+15,x 以此类推
    */
    	for (int i = 0; i < nums.length-1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[] { i, j };
                // a new integer array initialized with the values of i and j
                }
            }
        }
        return new int[] {};
    }
    public int[] findTwoSum_BruteForce2(int[] nums, int target){
        for(int i=0;i<nums.length;i++){
            int complement = target - nums[i];
            for(int j=0;j<nums.length;j++){
                if(complement == nums[j]&& i!=j){
                    int[] result = {i,j};
                    return result;
                }
            }
        }
     return new int[]{};
    }

    
    //Hashmap, Time complexity: O(n)
    public static int[] findTwoSum_Hashmap(int[] nums, int target) {
        Map<Integer, Integer> numMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (numMap.containsKey(complement)) {
                return new int[]{numMap.get(complement), i};
            }
            //populate numMap,key = nums[i],value = i(index)
            numMap.put(nums[i], i);
        }

        return new int[]{}; // No solution found
    }


    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        
        System.out.println("How many numbers do you have");
        int n = keyboard.nextInt();
        int[] nums = new int[n];
        /*declares an integer array variable named nums 
         * and initializes it with a new array of size n.*/

        for(int i = 0; i < n; i++) {
        	System.out.println("Type the"+i+"number");
            nums[i] = keyboard.nextInt();
        }
        System.out.println("Type the target number");
        int target = keyboard.nextInt();

        keyboard.close();

        int[] indices = findTwoSum_BruteForce(nums, target);
        int[] indices1 = findTwoSum_Hashmap(nums, target);

        if (indices.length == 2) {
            System.out.println("Brute Force: The answer is "+indices[0] + " " + indices[1]);
        } else {
            System.out.println("No solution found!");
        }
        
        if (indices1.length == 2) {
            System.out.println("Hash Map: The answer is "+indices1[0] + " " + indices1[1]);
        } else {
            System.out.println("No solution found!");
        }
    }
}
package Arrays_Hashing;

public class ProductExceptSelf238 {
    public int[]productExceptSelf(int[] nums){
        int[] res = new int[nums.length];
        //get prefix
        res[0]=1;
        for(int i =1;i<nums.length;i++){
            res[i]=res[i-1]*nums[i-1];
        }
        //eg: nums:[1,2,3,4]; res[1,1,2,6]
        //get postfix
        int postFix =1;
        //prefix，位置左边的乘积，postfix，位置右边的乘积
        for(int i =nums.length-1;i>=0;i--){
            res[i]*=postFix;
            postFix *=nums[i];
        }
        return res;
    }
}

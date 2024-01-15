package Recursion;

public class RecursionTutorial {
    public static void main(String[] args){
/**       递归_三要素_基础算法必备
 *        第一要素：明确函数作用
 *        第二要素：递归结束条件
 *        第三要素：函数等价关系*/
        //recursion: call method itself
        int before = 5;
        int after = 0;
        sayHi(before);
    }
    private static void sayHi(int i){
        //before: 5,4,3,2,1
        //System.out.println("hi"+i);
        //base case
        if(i<=1){
            return;
        }
       sayHi(i-1);
        //after:2,3,4,5
       System.out.println("boo"+i);
    }
}

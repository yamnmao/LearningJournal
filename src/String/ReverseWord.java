package String;

import java.util.Scanner;
import java.util.Stack;

class ReverseWord {
	//Loop 解法， 原理是靠空格区分word+首尾index（i和j）来锁定word
	 public static String reverseWords(String s) {
		 
		 String result=new String();
		 int i=0;//loop index
		 int n = s.length();//n=index = string's length; length和length()是有区别的
		 
		 //hello world -> world hello
		 //i<n，index小于句子长度
		 while(i<n) {
			 while(i<n && s.charAt(i)==' ')i++; //去掉括号的whileloop
			 /*这个whileloop确认单词的第一个字母的index，并且过滤掉开头的空格
			  * index小于句子长度且character=空格，
			  * charAt()used to retrieve the character at a specific index within a string
			 会一直i++直到碰到第一个字母, loop停止，此时的i所在的位置是第一个字母*/
			
			 if(i>=n)break;
			 
			 //j比i多一个index
			 int j=i+1;
			 while(j<n&&s.charAt(j)!=' ')j++;
			 //这个whileloop靠j确认一个单词的最后一个字母，一直j++直到碰到空格
			 
			 String sub = s.substring(i,j);//substring method
			 
			 //如果result是空的，说明这是result的第一个word，result=sub，否则result=sub+result
			 //第一个loop后sub=hello，result=sub=hello
			 //第二个loop后sub=world!， result= sub+result =world！+hello，以此类推
			 if(result.length()==0) result = sub;
			 else result = sub+ " "+result;
			 
			 i=j+1;
			 //第一个loop的时候j在index4=o，i往前移一位，开始新的loop确认下一个单词
			 //直到i>=n，loop停止
			 
		 }
				 
		return result;
		
	 }
	 //Stack解法，用split
	 public static String reverseWords_Stack(String s) {
		 //split words by space
		 String[] wordsArray = s.split(" ");
		 String result = new String();
		 Stack<String> wordStack = new Stack<String>();
		 
		 /*the value of the current element is assigned to the variable s1. 
		  * The loop will run as many times as there are elements in the wordsArray.
		  */
		 for(String s1:wordsArray)wordStack.push(s1);
		 
		 //while loop that repeatedly pops elements from a stack named wordStack 
		 //until the stack becomes empty.
		 //wordStack.pop() remove the word from stack
		 /*这里末尾+result逻辑和line 33一样，忘记加的话只会记录最后一个word
		 因为不断被assign新的pop value而没有叠加前面的word
		  * 但要注意stack的原理是先取world再取hello，loop是先取hello再取world，所以要调整叠加的顺序
		  */
		while(wordStack.empty()==false) result =result+" "+ wordStack.pop();
		return result;
	 }
	 

		
		public static void main(String[] args) {
			Scanner keyboard = new Scanner(System.in);
			 
			
		     System.out.println("Enter the sentence:");
		     String sentence = keyboard.nextLine();
		    //String result = reverseWords(sentence);
		    String result= reverseWords_Stack(sentence);
		     System.out.println("Here is the words in reverse:");
		     System.out.println(result);
		       
		 }
	
		/*public static  void main(String[] args) {
			 Scanner keyboard = new Scanner(System.in);
				
		     System.out.println("Enter the sentence:");
		     String s = keyboard.nextLine();
			 //split words by space
			 String[] wordsArray = s.split(" ");
			 String result = new String();
			 Stack<String> wordStack = new Stack<String>();
			 
			 
			 for(String s1:wordsArray)wordStack.push(s1);
			 
			 //while loop that repeatedly pops elements from a stack named wordStack 
			 //until the stack becomes empty.
			 //wordStack.pop() remove the word from stack
			 //这里末尾+result逻辑和line 33一样，忘记加的话只会记录最后一个word
			 //因为不断被assign新的pop value而没有叠加前面的word
			while(wordStack.empty()==false) { 
				result =result+" " +wordStack.pop();
				}
			System.out.println(result);
}*/

}

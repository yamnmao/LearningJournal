package String;

import java.util.LinkedList;
import java.util.List;

public class EncodeDecode271 {
    final char DELIMITER = '#';
    //Encodes a list of strings to a sing string
    public String encode(List<String> strs){
        StringBuilder sb= new StringBuilder();
        for(String str: strs){
            sb.append(str.length());//add length
            sb.append(DELIMITER);// add #
            sb.append(str);//5#Hello
        }
        return sb.toString();
    }

    //Decodes a single string to a list of strings.
    public List<String>decode(String s){
        List<String> res = new LinkedList<>();
        char[] arr = s.toCharArray();//converts the given string into a sequence of characters.
        for(int i = 0;i<arr.length;i++){
            StringBuilder sb = new StringBuilder();
            //loop until reach the #, this step is to get the number
            while(arr[i]!=DELIMITER){
                sb.append(arr[i++]);//add arr[i] to sb then i++, eg:get 5 from 5#hello
            }
            i++;//if meet #，skip while loop，i++，at this time it should be the first char of the world
            int numOfChars = Integer.valueOf(sb.toString());//eg: 5
            int end = i+numOfChars;
            //the length we need to read, eg: when i =2, end=2+5 =7, 5#hello,hello start at index 2 and end at 6
            sb = new StringBuilder();
            //Iteration the enter string to add to res list
            while(i < end){
                sb.append(arr[i++]);
            }
            //when i = end it skips while loop and we need to deduct it to where we stop
            //eg: 5#hello5#world, when i = 7, while loop stops. index[7]=5
            i--;
            res.add(sb.toString());
        }
        return res;
    }
}

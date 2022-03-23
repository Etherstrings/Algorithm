/**
 * @author Etherstrings
 * @create 2022-02-03 17:53
 */
public class L2000 {

    /**
     * 2000. 反转单词前缀
     给你一个下标从 0 开始的字符串 word 和一个字符 ch 。
     找出 ch 第一次出现的下标 i ，反转 word 中从下标 0 开始、直到下标 i 结束（含下标 i ）的那段字符。
     如果 word 中不存在字符 ch ，则无需进行任何操作。

     例如，如果 word = "abcdefd" 且 ch = "d" ，那么你应该 反转 从下标 0 开始、直到下标 3 结束（含下标 3 ）。
     结果字符串将会是 "dcbaefd" 。
     返回 结果字符串 。


     */
    public String reversePrefix(String word, char ch) {

        String newch= String.valueOf(ch);

            //找出角标
            int index=word.indexOf(ch);
            if(index<0){
                return word;
            }
            StringBuffer change=new StringBuffer(word.substring(0,index+1));
            //反转
            change.reverse().append(word.substring(index+1));









        return change.toString();


    }

    class Solution {
        public String reversePrefix(String word, char ch) {
            int index = word.indexOf(ch);
            if (index >= 0) {
                char[] arr = word.toCharArray();
                int left = 0, right = index;
                while (left < right) {
                    char temp = arr[left];
                    arr[left] = arr[right];
                    arr[right] = temp;
                    left++;
                    right--;
                }
                word = new String(arr);
            }
            return word;
        }
    }

}

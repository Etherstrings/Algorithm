package StringExer;

/**
 * @author Justice_wby
 * @create 2023-01-26 16:14
 */
public class L58 {
    //58. 最后一个单词的长度
    //给你一个字符串 s，由若干单词组成，单词前后用一些空格字符隔开。返回字符串中 最后一个 单词的长度。
    //
    //单词 是指仅由字母组成、不包含任何空格字符的最大子字符串。
    public int lengthOfLastWord(String s) {
        String[] words=s.split(" ");
        int ans=-1;
        for(int i=words.length-1;i>=0;i--){
            if(words[i].equals(" ")){
                continue;
            }else {
                ans=words[i].length();
                break;
            }
        }
        return ans;
    }
}

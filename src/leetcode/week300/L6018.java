package leetcode.week300;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author Etherstrings
 * @create 2022-07-03 10:30 leetcode.week300 - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L6018 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/7/3 - the current system date.  10:30 - the current system time.  2022 - the current year.  07 - the current month.  03 - the current day of the month.  10 - the current hour.  30 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  7月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  七月 - full name of a month. Example: January, February, etc
 */
public class L6018 {
    //6108. 解密消息 显示英文描述
    //通过的用户数0
    //尝试过的用户数0
    //用户总通过次数0
    //用户总提交次数0
    //题目难度Easy
    //给你字符串 key 和 message ，分别表示一个加密密钥和一段加密消息。解密 message 的步骤如下：
    //
    //使用 key 中 26 个英文小写字母第一次出现的顺序作为替换表中的字母 顺序 。
    //将替换表与普通英文字母表对齐，形成对照表。
    //按照对照表 替换 message 中的每个字母。
    //空格 ' ' 保持不变。
    //例如，key = "happy boy"（实际的加密密钥会包含字母表中每个字母 至少一次），据此，可以得到部分对照表（'h' -> 'a'、'a' -> 'b'、'p' -> 'c'、'y' -> 'd'、'b' -> 'e'、'o' -> 'f'）。
    public String decodeMessage(String key, String message) {
        //定位新表 Set+遍历
        Character[] newdict=new Character[26];
        Set<Character> Judge=new HashSet<>();
        int index=0;
        for(int i=0;i<key.length();i++){
            if(Character.isLetter(key.charAt(i))){
                //如果当前的是一个字母
                Character temp=key.charAt(i);
                if(!Judge.contains(temp)){
                    Judge.add(temp);
                    newdict[index]=temp;
                    index++;
                }
            }
        }
        //按照出现顺序---对应了相关的数据

        //怎么按照加密的取呢？
        Map<Character,Character> Tran=new HashMap<>();
        Tran.put(newdict[0],'a');
        Tran.put(newdict[1],'b');
        Tran.put(newdict[2],'c');
        Tran.put(newdict[3],'d');
        Tran.put(newdict[4],'e');
        Tran.put(newdict[5],'f');
        Tran.put(newdict[6],'g');
        Tran.put(newdict[7],'h');
        Tran.put(newdict[8],'i');
        Tran.put(newdict[9],'j');
        Tran.put(newdict[10],'k');
        Tran.put(newdict[11],'l');
        Tran.put(newdict[12],'m');
        Tran.put(newdict[13],'n');
        Tran.put(newdict[14],'o');
        Tran.put(newdict[15],'p');
        Tran.put(newdict[16],'q');
        Tran.put(newdict[17],'r');
        Tran.put(newdict[18],'s');
        Tran.put(newdict[19],'t');
        Tran.put(newdict[20],'u');
        Tran.put(newdict[21],'v');
        Tran.put(newdict[22],'w');
        Tran.put(newdict[23],'x');
        Tran.put(newdict[24],'y');
        Tran.put(newdict[25],'z');
        //翻译Message
        char[] chars = message.toCharArray();
        String ans="";
        for(int i=0;i<chars.length;i++){
            if(chars[i]==' '){
                ans+=chars[i];
            }else {
                Character temp=Tran.get(chars[i]);
                ans+=temp;
            }
        }
        return ans;
    }
}

package HASH;

import java.util.*;

/**
 * @author Etherstrings
 * @create 2022-08-14 0:32 HASH - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L1002 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/8/14 - the current system date.  0:32 - the current system time.  2022 - the current year.  08 - the current month.  14 - the current day of the month.  00 - the current hour.  32 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  8月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  八月 - full name of a month. Example: January, February, etc
 */
public class L1002 {
    //1002. 查找共用字符
    //给你一个字符串数组 words ，请你找出所有在 words 的每个字符串中都出现的共用字符（ 包括重复字符），并以数组形式返回。你可以按 任意顺序 返回答案。
    //
    //
    //示例 1：
    //
    //输入：words = ["bella","label","roller"]
    //输出：["e","l","l"]
    //示例 2：
    //
    //输入：words = ["cool","lock","cook"]
    //输出：["c","o"]
    //
    //
    //提示：
    //
    //1 <= words.length <= 100
    //1 <= words[i].length <= 100
    //words[i] 由小写英文字母组成
    public List<String> commonChars(String[] words) {
        HashMap<Character,Integer> Judge=new HashMap<>();
        for(Character a:words[0].toCharArray()){
            if(Judge.containsKey(a)){
                Judge.put(a,Judge.get(a)+1);
            }else {
                Judge.put(a,1);
            }
        }

        for(int i=1;i<words.length;i++){
            HashMap<Character,Integer> Temp=new HashMap<Character,Integer>();
            for(Character temp:words[i].toCharArray()){
                if(Judge.containsKey(temp)){
                    int left=Judge.get(temp);
                    if(left==1){
                        if(Temp.containsKey(temp)){
                            Temp.put(temp,Temp.get(temp)+1);
                            Judge.remove(temp);
                        }else {
                            Temp.put(temp,1);
                            Judge.remove(temp);
                        }
                    }else {
                        //剩下的不等于1
                        if(Temp.containsKey(temp)){
                            Temp.put(temp,Temp.get(temp)+1);
                            Judge.put(temp, Temp.get(temp)-1);
                        }else {
                            Temp.put(temp,1);
                            Judge.put(temp, Temp.get(temp)-1);
                        }
                    }
                }
            }
            Judge=Temp;
        }
        List<String> ans=new ArrayList<>();
        Set<Map.Entry<Character, Integer>> entries = Judge.entrySet();
        for(Map.Entry<Character, Integer> now:entries){
            for(int i=0;i<now.getValue();i++){
                ans.add(now.getKey().toString());
            }
        }
        return ans;
    }

    public List<String> commonChars1(String[] A) {
        List<String> result = new ArrayList<>();
        if (A.length == 0) return result;
        int[] hash= new int[26]; // 用来统计所有字符串里字符出现的最小频率
        for (int i = 0; i < A[0].length(); i++) { // 用第一个字符串给hash初始化
            hash[A[0].charAt(i)- 'a']++;
        }
        // 统计除第一个字符串外字符的出现频率
        for (int i = 1; i < A.length; i++) {
            int[] hashOtherStr= new int[26];
            for (int j = 0; j < A[i].length(); j++) {
                hashOtherStr[A[i].charAt(j)- 'a']++;
            }
            // 更新hash，保证hash里统计26个字符在所有字符串里出现的最小次数
            for (int k = 0; k < 26; k++) {
                hash[k] = Math.min(hash[k], hashOtherStr[k]);
            }
        }
        // 将hash统计的字符次数，转成输出形式
        for (int i = 0; i < 26; i++) {
            while (hash[i] != 0) { // 注意这里是while，多个重复的字符
                char c= (char) (i+'a');
                result.add(String.valueOf(c));
                hash[i]--;
            }
        }
        return result;
    }
}

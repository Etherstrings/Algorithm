package HASH;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wuboyu <wuboyu@kuaishou.com>
 * Created on 2024-07-22
 */
public class L290 {
    public static void main(String[] args) {
        //"abba"
        //			"dog cat cat dog"

        System.out.println(wordPattern("abba","dog cat cat dog"));


    }
    public static boolean wordPattern(String pattern, String s) {
        int showTime = 0;
        Map<String,Integer> showMap = new HashMap<>();
        Map<String,Integer> parrtenMap = new HashMap<>();
        String[] words = s.split(" ");
        if (pattern.length() != words.length) {
            return false;
        }
        String code = "";
        String parttenCode = "";
        for(String word:words){
            if(showMap.size() == 0){
                showTime++;
                showMap.put(word,showTime);
                code += showTime;
                continue;
            }
            if(showMap.containsKey(word)){
                code += showMap.get(word);
                continue;
            }else {
                showTime++;
                showMap.put(word,showTime);
                code += showTime;
                continue;
            }
        }
        int nshowtime = 0;
        for(char now:pattern.toCharArray()){
            if(parrtenMap.size() == 0){
                nshowtime++;
                parrtenMap.put(now+"",nshowtime);
                parttenCode += nshowtime;
                continue;
            }
            if(parrtenMap.containsKey(now+"")){
                parttenCode += parrtenMap.get(now+"");
                continue;
            }else {
                nshowtime++;
                parrtenMap.put(now+"",nshowtime);
                parttenCode += nshowtime;
                continue;
            }
        }
        return code.equals(parttenCode);
    }
}

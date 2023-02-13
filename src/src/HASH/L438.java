package src.HASH;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Etherstrings
 * @create 2022-02-07 22:21
 */
public class L438 {
    public List<Integer> findAnagrams(String s, String p) {
        int plength=p.length();
        int slength=s.length();

        if(plength>slength){
            return new ArrayList<Integer>();
        }


        List<Integer> answer=new ArrayList<Integer>();



        int[] ptype=new int[26];
        int[] stype=new int[26];

        for(int i=0;i<plength;i++){
            stype[i-'a']+=1;
            ptype[i-'a']+=1;

        }


        if(Arrays.equals(stype,ptype)){
            answer.add(0);
        }

        //开始滑动窗口
        for(int i=0;i<slength-plength;i++){
            stype[s.charAt(i)-'a']--;
            stype[s.charAt(i+plength)-'a']++;

            if(Arrays.equals(stype,ptype)){
                answer.add(i+1);
            }
        }

        return answer;
    }

    class Solution {
        public List<Integer> findAnagrams(String s, String p) {
            int sLen = s.length(), pLen = p.length();

            if (sLen < pLen) {
                return new ArrayList<Integer>();
            }

            List<Integer> ans = new ArrayList<Integer>();
            int[] sCount = new int[26];
            int[] pCount = new int[26];
            for (int i = 0; i < pLen; ++i) {
                ++sCount[s.charAt(i) - 'a'];
                ++pCount[p.charAt(i) - 'a'];
            }

            if (Arrays.equals(sCount, pCount)) {
                ans.add(0);
            }

            for (int i = 0; i < sLen - pLen; ++i) {
                --sCount[s.charAt(i) - 'a'];
                ++sCount[s.charAt(i + pLen) - 'a'];

                if (Arrays.equals(sCount, pCount)) {
                    ans.add(i + 1);
                }
            }

            return ans;
        }
    }

}

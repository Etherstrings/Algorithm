package src;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

/**
 * @description:
 * @author： wuboyu
 * @date： 2022-08-01 15:05
 */
public class L38 {

    public String countAndSay(int n) {
        if(n==1){
            return "1";
        }
        if(n==2){
            return "11";
        }
        if(n==3){
            return "21";
        }
        if(n==4){
            return "1211";
        }
        String[] dp=new String[n+1];
        dp[1]="1";
        dp[2]="11";
        dp[3]="21";
        for(int i=4;i<=n;i++){
            String temp=dp[i-1];
            dp[i]=trans(temp);
        }
        return dp[n];
    }

    String trans(String temp){
        //描述转换类
        char[] tempchars = temp.toCharArray();
        //这是一个链表 每一个格子存的是一个 String(数字是什么？)-出现几次
        ArrayList<HashMap<Character,Integer>> Judege=new ArrayList<>();
        Character target=tempchars[0];
        int size=0;
        for(int i=0;i<tempchars.length;i++){
            if(target==tempchars[i]){
                size++;
                if(i==tempchars.length-1){
                    HashMap<Character,Integer> ttemp=new HashMap<>();
                    ttemp.put(target,size);
                    Judege.add(ttemp);
                    break;
                }
            }else {
                HashMap<Character,Integer> ttemp=new HashMap<>();
                ttemp.put(target,size);
                Judege.add(ttemp);
                size=0;
                target=tempchars[i];
                i=i-1;
            }
        }
        String ans="";
        for(HashMap<Character,Integer> t:Judege){
            Set<Character> set = t.keySet();
            for(Character a:set){
                ans+=t.get(a);
                ans+=a;
            }
        }
        return ans;
    }
}

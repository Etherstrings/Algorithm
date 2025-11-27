package StringExer;

import java.util.HashMap;

/**
 * @author Etherstrings
 * @create 2023-02-20 2:20 StringExer - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L2347 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2023/2/20 - the current system date.  2:20 - the current system time.  2023 - the current year.  02 - the current month.  20 - the current day of the month.  02 - the current hour.  20 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  2月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  二月 - full name of a month. Example: January, February, etc
 */
public class L2347 {
    //2347. 最好的扑克手牌
    //给你一个整数数组 ranks 和一个字符数组 suit 。你有 5 张扑克牌，第 i 张牌大小为 ranks[i] ，花色为 suits[i] 。
    //
    //下述是从好到坏你可能持有的 手牌类型 ：
    //
    //"Flush"：同花，五张相同花色的扑克牌。
    //"Three of a Kind"：三条，有 3 张大小相同的扑克牌。
    //"Pair"：对子，两张大小一样的扑克牌。
    //"High Card"：高牌，五张大小互不相同的扑克牌。
    //请你返回一个字符串，表示给定的 5 张牌中，你能组成的 最好手牌类型 。
    //
    //注意：返回的字符串 大小写 需与题目描述相同。
    //
    //
    //
    //示例 1：
    //
    //输入：ranks = [13,2,3,1,9], suits = ["a","a","a","a","a"]
    //输出："Flush"
    //解释：5 张扑克牌的花色相同，所以返回 "Flush" 。
    public String bestHand(int[] ranks, char[] suits) {
        HashMap<Character,Integer> map1=new HashMap<>();
        for(char now:suits){
            if(map1.containsKey(now)){
                map1.put(now,map1.get(now)+1);
            }else {
                map1.put(now,1);
            }
        }
        for(Character n: map1.keySet()){
            if(map1.get(n)>=5){
                return "Flush";
            }
        }
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i:ranks){
            if(map.containsKey(i)){
                map.put(i,map.get(i)+1);
            }else {
                map.put(i,1);
            }
        }
        for(int i: map.keySet()){
            if(map.get(i)>=3){
                return "Three of a Kind";
            }
        }
        for(int i: map.keySet()){
            if(map.get(i)>=2){
                return "Pair";
            }
        }
        return "High Card";
    }
}

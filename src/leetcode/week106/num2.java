package leetcode.week106;

public class num2 {
    //2730. 找到最长的半重复子字符串
    //给你一个下标从 0 开始的字符串 s ，这个字符串只包含 0 到 9 的数字字符。
    //
    //如果一个字符串 t 中至多有一对相邻字符是相等的，那么称这个字符串 t 是 半重复的 。例如，0010 、002020 、0123 、2002 和 54944 是半重复字符串，而 00101022 和 1101234883 不是。
    //
    //请你返回 s 中最长 半重复 子字符串的长度。
    //
    //一个 子字符串 是一个字符串中一段连续 非空 的字符。
    //
    //
    //
    //示例 1：
    //
    //输入：s = "52233"
    //输出：4
    //解释：最长半重复子字符串是 "5223" ，子字符串从 i = 0 开始，在 j = 3 处结束。
    //示例 2：
    //
    //输入：s = "5494"
    //输出：4
    //解释：s 就是一个半重复字符串，所以答案为 4 。
    //示例 3：
    //
    //输入：s = "1111111"
    //输出：2
    //解释：最长半重复子字符串是 "11" ，子字符串从 i = 0 开始，在 j = 1 处结束。
    public static void main(String[] args) {
        String s="00";
        System.out.println(longestSemiRepetitiveSubstring(s));
    }
    public static int longestSemiRepetitiveSubstring(String s) {
        int showup=0;
        int slow=0;
        int len=0;
        for(int fast=0;fast<s.length();fast++){
            if(fast==0){
                showup=0;
                len=Math.max(fast-slow+1,len);
                continue;
            }
            String now=s.charAt(fast)+"";
            String last=s.charAt(fast-1)+"";
            //这俩不相同
            if(!now.equals(last)){
                len=Math.max(fast-slow+1,len);
            }else {
                showup++;
                if(showup>1){
                    showup=1;
                    slow++;
                    len=Math.max(fast-slow+1,len);
                }else {
                    len=Math.max(fast-slow+1,len);
                }
            }
        }
        return len;
    }

}

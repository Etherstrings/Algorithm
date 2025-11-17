package TanXin;

import java.util.*;

public class L1177 {
    //1177. 构建回文串检测
    //给你一个字符串 s，请你对 s 的子串进行检测。
    //
    //每次检测，待检子串都可以表示为 queries[i] = [left, right, k]。我们可以 重新排列 子串 s[left], ..., s[right]，并从中选择 最多 k 项替换成任何小写英文字母。
    //
    //如果在上述检测过程中，子串可以变成回文形式的字符串，那么检测结果为 true，否则结果为 false。
    //
    //返回答案数组 answer[]，其中 answer[i] 是第 i 个待检子串 queries[i] 的检测结果。
    //
    //注意：在替换时，子串中的每个字母都必须作为 独立的 项进行计数，也就是说，如果 s[left..right] = "aaa" 且 k = 2，我们只能替换其中的两个字母。（另外，任何检测都不会修改原始字符串 s，可以认为每次检测都是独立的）
    //
    //
    //
    //示例：
    //
    //输入：s = "abcda", queries = [[3,3,0],[1,2,0],[0,3,1],[0,3,2],[0,4,1]]
    //输出：[true,false,false,true,true]
    //解释：
    //queries[0] : 子串 = "d"，回文。
    //queries[1] : 子串 = "bc"，不是回文。
    //queries[2] : 子串 = "abcd"，只替换 1 个字符是变不成回文串的。
    //queries[3] : 子串 = "abcd"，可以变成回文的 "abba"。 也可以变成 "baab"，先重新排序变成 "bacd"，然后把 "cd" 替换为 "ab"。
    //queries[4] : 子串 = "abcda"，可以变成回文的 "abcba"。


    //超时
    public static List<Boolean> canMakePaliQueries(String s, int[][] queries) {
        //        4 1 1 1 1  1
        //        4 1 1 1 1  2
        //        5 2 1 1 1  2
        //        长度 用大的先填充--此时不消耗k，减少长度--一对一对的填充
        //        7 3 1 1 2  2
        //        3 1 1 1 0  2
        List<Boolean> ans=new ArrayList<>();
        for(int[] nq:queries){
            int k=nq[2];
            int len=nq[1]-nq[0]+1;
            int[] temp=new int[26];
            for(int i=nq[0];i<=nq[1];i++){
                temp[s.charAt(i)-'a']++;
            }
            ans.add(getans(temp,len,k));
        }
        return ans;
    }

    public static boolean getans(int[] temp,int len,int k){
        //        长度 用大的先填充--此时不消耗k，减少长度--一对一对的填充
        //        7 3 1 1 2  2
        //        3 1 1 1 0  2
        int odd=0;
        for(int i=0;i<temp.length;i++){
            if(temp[i]==0){
                continue;
            }
            if(temp[i]==1){
                odd++;
                continue;
            }
            if(temp[i]%2==0){
                len-=temp[i];
            }else {
                len-=(temp[i]-1);
                odd++;
            }
        }
        //此时 判断len的长度和odd的个数和k的关系
        if(k==0){
            if(len==1){
                return true;
            }
        }
        if(len/2<=k){
            return true;
        }
        return false;
    }

    //正确解法
    public List<Boolean> canMakePaliQueries_true(String s, int[][] queries) {
        int n = s.length();
        int[][] ss = new int[n + 1][26];
        for (int i = 1; i <= n; ++i) {
            for (int j = 0; j < 26; ++j) {
                ss[i][j] = ss[i - 1][j];
            }
            ss[i][s.charAt(i - 1) - 'a']++;
        }
        List<Boolean> ans = new ArrayList<>();
        for (int[] q : queries) {
            int l = q[0], r = q[1], k = q[2];
            int x = 0;
            for (int j = 0; j < 26; ++j) {
                x += (ss[r + 1][j] - ss[l][j]) & 1;
            }
            ans.add(x / 2 <= k);
        }
        return ans;
    }

}

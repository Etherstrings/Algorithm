package PreSum;

/**
 * @author wuboyu <wuboyu@kuaishou.com>
 * Created on 2023-09-05
 */
public class L1915 {
    //如果某个字符串中 至多一个 字母出现 奇数 次，则称其为 最美 字符串。
    //
    //例如，"ccjjc" 和 "abab" 都是最美字符串，但 "ab" 不是。
    //给你一个字符串 word ，该字符串由前十个小写英文字母组成（'a' 到 'j'）。请你返回 word 中 最美非空子字符串 的数目。如果同样的子字符串在 word 中出现多次，那么应当对 每次出现 分别计数。
    //
    //子字符串 是字符串中的一个连续字符序列。
    //
    //示例 1：
    //
    //输入：word = "aba"
    //输出：4
    //解释：4 个最美子字符串如下所示：
    //- "aba" -> "a"
    //- "aba" -> "b"
    //- "aba" -> "a"
    //- "aba" -> "aba"
    public static long wonderfulSubstrings(String word) {
        //只能有一个字母出现奇数次
        //双重循环可以做，但是会超时
        //可以用前缀和的思想
        int n=word.length();
        int[][] PreS=new int[n+1][26];
        //l-r之间字母出现的次数 等于 pre[r][i]-pre[l-1][i]
        for(int i=0;i<PreS.length;i++){
            if(i==0){
                PreS[i]=new int[26];
                continue;
            }
            int[] temp=PreS[i-1].clone();
            temp[word.charAt(i-1)-'a']++;
            PreS[i]=temp;
        }
        long res=0;
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                int[] temp=new int[26];
                for(int k=0;k<26;k++){
                    temp[k]=PreS[j+1][k]-PreS[i][k];
                }
                if(check(temp)){
                    res++;
                }
            }
        }
        return res;
    }
    public static boolean check(int[] temp){
        int count=0;
        for(int i=0;i<26;i++){
            if(temp[i]%2==1){
                count++;
            }
        }
        return count<=1;
    }
}

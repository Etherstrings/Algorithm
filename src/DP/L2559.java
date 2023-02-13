package DP;

/**
 * @author Justice_wby
 * @create 2023-02-09 21:50
 */
public class L2559 {
    public static int[] vowelStrings(String[] words, int[][] queries) {
        int[] dp=presum(words);
        int[] ans=new int[queries.length];
        for(int i=0;i<ans.length;i++){
            int left=queries[i][0];
            int right=queries[i][1];
            if(right-left==0){
                if(left==0){
                    ans[i]=dp[left];
                    continue;
                }
                ans[i]=dp[left]-dp[left-1];
            }else{
                int nr=dp[right]-dp[left];
                if(left==0){
                    nr+=dp[0];
                }else{
                    nr+=dp[left]-dp[left-1];
                }
                ans[i]=nr;
            }

        }
        return ans;
    }
    public static int[] presum(String[] words){
        //构造前缀和
        //当前位置前面有多少个 包括当前位置
        int[] dp=new int[words.length];
        String uan="aeiou";
        for(int i=0;i<dp.length;i++){
            String now=words[i];
            char first=now.charAt(0);
            char last=now.charAt(now.length()-1);
            if(uan.contains(first+"")&&uan.contains(last+"")){
                if(i==0){dp[i]=1;}
                else{dp[i]=dp[i-1]+1;}
            }else{
                if(i==0){dp[i]=0;}else{
                    dp[i]=dp[i-1];
                }
            }

        }
        return dp;

    }
}

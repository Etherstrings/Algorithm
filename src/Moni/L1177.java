package Moni;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author wuboyu <wuboyu@kuaishou.com>
 * Created on 2023-09-26
 */
public class L1177 {
    public static void main(String[] args) {
        String s="hunu";
        int[][] queries={{0,3,1},{1,1,1}};
        System.out.println(canMakePaliQueries(s,queries));
    }
    public static List<Boolean> canMakePaliQueries(String s, int[][] queries) {
        List<Boolean> ans=new ArrayList<>();
        for(int[] query:queries){
            int l=query[0];
            int r=query[1];
            int k=query[2];
            String temp=s.substring(l,r+1);
            if(isHuiwen(temp,k)){
                ans.add(true);
            }else{
                ans.add(false);
            }
        }
        return ans;
    }

    public static boolean isHuiwen(String s,int k){
        Set<Character> set=new HashSet<>();
        //对子全都碰掉了
        for(char c:s.toCharArray()){
            if(set.contains(c)){
                set.remove(c);
            }else {
                set.add(c);
            }
        }
        //剩下的是奇数个的
        if(set.size()<=k*2+1){
            return true;
        }else {
            return false;
        }
    }

    //换个思路
    //1.前缀和维护是否奇数、偶数
    //2.计算

    //搞定
    //> 2023/09/26 22:17:41
    //解答成功:
    //	执行耗时:64 ms,击败了8.85% 的Java用户
    //	内存消耗:100.2 MB,击败了9.62% 的Java用户
    public static List<Boolean> canMakePaliQueries_Pre(String s, int[][] queries){
       int n=s.length();
       boolean[][] pre=new boolean[n+1][26];
         for(int i=0;i<n;i++){
              pre[i+1]=pre[i].clone();
              pre[i+1][s.charAt(i)-'a']=!pre[i+1][s.charAt(i)-'a'];
         }
            List<Boolean> ans=new ArrayList<>();
            for(int[] query:queries){
                int l=query[0];
                int r=query[1];
                int k=query[2];
                int sum=0;
                for(int i=0;i<26;i++){
                    sum+=(pre[r+1][i]^pre[l][i])?1:0;
                }
                ans.add(sum/2<=k);
            }
            return ans;
    }

}

package src;

/**
 * @description:
 * @author： wuboyu
 * @date： 2022-08-01 11:21
 */
public class L1374 {
    //1374. 生成每种字符都是奇数个的字符串
    //给你一个整数 n，请你返回一个含 n 个字符的字符串，其中每种字符在该字符串中都恰好出现 奇数次 。
    //
    //返回的字符串必须只含小写英文字母。如果存在多个满足题目要求的字符串，则返回其中任意一个即可。
    //
    // 
    //
    //示例 1：
    //
    //输入：n = 4
    //输出："pppz"
    //解释："pppz" 是一个满足题目要求的字符串，因为 'p' 出现 3 次，且 'z' 出现 1 次。当然，还有很多其他字符串也满足题目要求，比如："ohhh" 和 "love"。
    //示例 2：
    //
    //输入：n = 2
    //输出："xy"
    //解释："xy" 是一个满足题目要求的字符串，因为 'x' 和 'y' 各出现 1 次。当然，还有很多其他字符串也满足题目要求，比如："ag" 和 "ur"。
    //示例 3：
    //
    //输入：n = 7
    //输出："holasss"
    public String generateTheString(int n) {
        //整数n怎么被分配为奇数组合？
        //n为整数 1+奇数
        //n为奇数 1+1+奇数
        if(n==1){
            return "a";
        }
        if(n==2){
            return "ab";
        }
        if(n==3){
            return "abc";
        }
        String ans="";
        if(n%2==0){
            //偶数
            for(int i=0;i<n-1;i++){
                ans+="a";
            }
            ans+="b";
        }else {
            //奇数
            for(int i=0;i<n-2;i++){
                ans+="a";
            }
            ans+="b";
            ans+="c";
        }
        return ans;
    }


}

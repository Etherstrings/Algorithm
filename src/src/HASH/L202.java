package src.HASH;

import java.util.HashSet;
import java.util.Set;

/**
 * @description:
 * @author： wuboyu
 * @date： 2022-08-08 09:50
 */
public class L202 {
    //202. 快乐数
    //编写一个算法来判断一个数 n 是不是快乐数。
    //
    //「快乐数」 定义为：
    //
    //对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和。
    //然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。
    //如果这个过程 结果为 1，那么这个数就是快乐数。
    //如果 n 是 快乐数 就返回 true ；不是，则返回 false 。
    //
    //
    //
    //示例 1：
    //
    //输入：n = 19
    //输出：true
    //解释：
    //12 + 92 = 82
    //82 + 22 = 68
    //62 + 82 = 100
    //12 + 02 + 02 = 1
    //示例 2：
    //
    //输入：n = 2
    //输出：false

    public boolean isHappy(int n) {
        if(n==1){
            return true;
        }
        Set<Integer> sum=new HashSet<>();
        while(n!=1) {
            sum.add(n);
            n = trans(n);
            if (sum.contains(n)) {
                return false;
            }
        }
        return true;

    }

    int trans(int n){
        String s = String.valueOf(n);
        int ans=0;
        for(char a:s.toCharArray()){
            String temp = String.valueOf(a);
            ans+=Integer.valueOf(temp)*Integer.valueOf(temp);
        }
        return ans;
    }
}

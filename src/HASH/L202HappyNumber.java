package HASH;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Etherstrings
 * @create 2022-02-08 21:15
 */
public class L202HappyNumber {
    /**
     *
     * 202. 快乐数
     * 编写一个算法来判断一个数 n 是不是快乐数。
     *
     * 「快乐数」 定义为：
     *
     * 对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和。
     * 然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。
     * 如果这个过程 结果为 1，那么这个数就是快乐数。
     * 如果 n 是 快乐数 就返回 true ；不是，则返回 false 。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/happy-number
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    public boolean isHappy(int n) {
        Set<Integer> record=new HashSet<>();
        while(n!=1&&!record.contains(n)){
            record.add(n);
            n=getNextNumber(n);
        }
        return n==1;
    }

    public int getNextNumber(int n){
        int res=0;
        while(n>0){
            int temp=n%10;
            res+=temp*temp;
            n=n/10;
        }

        return res;
    }
}

package TanXin;

/**
 * @description:
 * @author： wuboyu
 * @date： 2022-07-22 09:25
 */
public class L738 {
    //单调递增的数字
    //Category	Difficulty	Likes	Dislikes
    //algorithms	Medium (50.14%)	268	-
    //Tags
    //Companies
    //当且仅当每个相邻位数上的数字 x 和 y 满足 x <= y 时，我们称这个整数是单调递增的。
    //
    //给定一个整数 n ，返回 小于或等于 n 的最大数字，且数字呈 单调递增 。
    //
    //
    //
    //示例 1:
    //
    //输入: n = 10
    //输出: 9
    //示例 2:
    //
    //输入: n = 1234
    //输出: 1234
    //示例 3:
    //
    //输入: n = 332
    //输出: 299
    public int monotoneIncreasingDigits9(int n){
        String s=String.valueOf(n);
        char[] chars = s.toCharArray();
        int start=chars.length;
        for(int i=chars.length-1;i>0;i--){
            if(chars[i-1]>chars[i]){
                chars[i-1]--;
                start=i;
            }
        }

        for(int i=start;i<chars.length;i++){
            chars[i]='9';
        }

        return Integer.parseInt(String.valueOf(chars));
    }
}

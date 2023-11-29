package TanXin;
import java.util.*;

/**
 * @author wuboyu <wuboyu@kuaishou.com>
 * Created on 2023-11-29
 */
public class L2165 {
    //给你一个整数 num 。重排 num 中的各位数字，使其值 最小化 且不含 任何 前导零。
    //
    // 返回不含前导零且值最小的重排数字。
    //
    // 注意，重排各位数字后，num 的符号不会改变。
    //
    //
    //
    // 示例 1：
    //
    // 输入：num = 310
    //输出：103
    //解释：310 中各位数字的可行排列有：013、031、103、130、301、310 。
    //不含任何前导零且值最小的重排数字是 103 。
    //
    //
    // 示例 2：
    //
    // 输入：num = -7605
    //输出：-7650
    //解释：-7605 中各位数字的部分可行排列为：-7650、-6705、-5076、-0567。
    //不含任何前导零且值最小的重排数字是 -7650 。
    //
    //
    //
    // 提示：
    //
    //
    // -10¹⁵ <= num <= 10¹⁵
    //
    //
    // Related Topics 数学 排序 👍 13 👎 0
    public static void main(String[] args) {
        System.out.println(smallestNumber(310));
    }
    public static long smallestNumber(long num) {
        if(num<10&&num>-10){
            return num;
        }
        long zerosize = 0;
        String str = num+"";
        for(char c : str.toCharArray()){
            if(c == '0'){
                zerosize++;
            }
        }
        if(num<0){
            str = str.substring(1);
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            StringBuilder sb = new StringBuilder();
            sb.append("-");
            for(int i=str.length()-1;i>=0;i--){
                if(chars[i]!='0'){
                    sb.append(chars[i]);
                }
            }
            for(int i = 0; i < zerosize; i++){
                sb.append("0");
            }
            return Long.parseLong(sb.toString());
        }else {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            StringBuilder sb = new StringBuilder();
            boolean flag = false;
            for(int i=0;i<chars.length;i++){
                if(chars[i]!='0'){
                    sb.append(chars[i]);
                    if(flag==false){
                        for(int j=0;j<zerosize;j++){
                            sb.append("0");
                        }
                        flag = true;
                    }
                }
            }
            return Long.parseLong(sb.toString());
        }
    }
}

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author Etherstrings
 * @create 2023-04-25 11:47 PACKAGE_NAME - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L2418 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2023/4/25 - the current system date.  11:47 - the current system time.  2023 - the current year.  04 - the current month.  25 - the current day of the month.  11 - the current hour.  47 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  4月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  四月 - full name of a month. Example: January, February, etc
 */
public class L2418 {
    //2418. 按身高排序
    //给你一个字符串数组 names ，和一个由 互不相同 的正整数组成的数组 heights 。两个数组的长度均为 n 。
    //
    //对于每个下标 i，names[i] 和 heights[i] 表示第 i 个人的名字和身高。
    //
    //请按身高 降序 顺序返回对应的名字数组 names 。
    //
    //
    //
    //示例 1：
    //
    //输入：names = ["Mary","John","Emma"], heights = [180,165,170]
    //输出：["Mary","Emma","John"]
    //解释：Mary 最高，接着是 Emma 和 John 。
    //示例 2：
    //
    //输入：names = ["Alice","Bob","Bob"], heights = [155,185,150]
    //输出：["Bob","Alice","Bob"]
    //解释：第一个 Bob 最高，然后是 Alice 和第二个 Bob 。
    //
    //
    //提示：
    //
    //n == names.length == heights.length
    //1 <= n <= 103
    //1 <= names[i].length <= 20
    //1 <= heights[i] <= 105
    //names[i] 由大小写英文字母组成
    //heights 中的所有值互不相同
    public String[] sortPeople(String[] names, int[] heights) {
        Queue<int[]> Dui = new PriorityQueue<>((x, y) -> (y[1] - x[1]));
        for(int i=0;i<names.length;i++){
            int[] temp=new int[]{i,heights[i]};
            Dui.offer(temp);
        }
        String[] ans=new String[names.length];
        for(int i=0;i<ans.length;i++){
            ans[i]=names[Dui.poll()[0]];
        }
        return ans;
    }
}

package TanXin;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author Etherstrings
 * @create 2023-06-07 12:52 TanXin - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L2611 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2023/6/7 - the current system date.  12:52 - the current system time.  2023 - the current year.  06 - the current month.  07 - the current day of the month.  12 - the current hour.  52 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  6月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  六月 - full name of a month. Example: January, February, etc
 */
public class L2611 {
    //2611. 老鼠和奶酪
    //有两只老鼠和 n 块不同类型的奶酪，每块奶酪都只能被其中一只老鼠吃掉。
    //
    //下标为 i 处的奶酪被吃掉的得分为：
    //
    //如果第一只老鼠吃掉，则得分为 reward1[i] 。
    //如果第二只老鼠吃掉，则得分为 reward2[i] 。
    //给你一个正整数数组 reward1 ，一个正整数数组 reward2 ，和一个非负整数 k 。
    //
    //请你返回第一只老鼠恰好吃掉 k 块奶酪的情况下，最大 得分为多少。
    //
    //
    //
    //示例 1：
    //
    //输入：reward1 = [1,1,3,4], reward2 = [4,4,1,1], k = 2
    //输出：15
    //解释：这个例子中，第一只老鼠吃掉第 2 和 3 块奶酪（下标从 0 开始），第二只老鼠吃掉第 0 和 1 块奶酪。
    //总得分为 4 + 4 + 3 + 4 = 15 。
    //15 是最高得分。
    //示例 2：
    //
    //输入：reward1 = [1,1], reward2 = [1,1], k = 2
    //输出：2
    //解释：这个例子中，第一只老鼠吃掉第 0 和 1 块奶酪（下标从 0 开始），第二只老鼠不吃任何奶酪。
    //总得分为 1 + 1 = 2 。
    //2 是最高得分。
    public int miceAndCheese(int[] reward1, int[] reward2, int k) {
        int n=reward1.length;
        //假设先让2号全部吃完
        int ans = Arrays.stream(reward2).sum();
        //优先选择差值较大的让1号吃

        //那么其中有一些 是吃的比较少的
        //选择r1-r2>0,并且优先比较大的先扔出来
        //大顶堆--堆顶大于每个子孩子。
        Queue<Integer> bigd = new PriorityQueue<>((x, y) -> (y - x));
        for(int i=0;i<n;i++){
            bigd.offer(reward1[i]-reward2[i]);
        }
        while(k--!=0){
            ans+=bigd.poll();
        }
        return ans;
    }
}

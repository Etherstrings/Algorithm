package src.TanXin;

import java.util.Arrays;

/**
 * @author Etherstrings
 * @create 2022-06-12 18:00 TanXin - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L445 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/6/12 - the current system date.  18:00 - the current system time.  2022 - the current year.  06 - the current month.  12 - the current day of the month.  18 - the current hour.  00 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  6月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  六月 - full name of a month. Example: January, February, etc
 */
public class L445 {
    //455. 分发饼干
    //假设你是一位很棒的家长，想要给你的孩子们一些小饼干。但是，每个孩子最多只能给一块饼干。
    //
    //对每个孩子 i，都有一个胃口值 g[i]，这是能让孩子们满足胃口的饼干的最小尺寸；并且每块饼干 j，都有一个尺寸 s[j] 。如果 s[j] >= g[i]，我们可以将这个饼干 j 分配给孩子 i ，这个孩子会得到满足。你的目标是尽可能满足越多数量的孩子，并输出这个最大数值。
    //
    //
    //示例 1:
    //
    //输入: g = [1,2,3], s = [1,1]
    //输出: 1
    //解释:
    //你有三个孩子和两块小饼干，3个孩子的胃口值分别是：1,2,3。
    //虽然你有两块小饼干，由于他们的尺寸都是1，你只能让胃口值是1的孩子满足。
    //所以你应该输出1。
    //示例 2:
    //
    //输入: g = [1,2], s = [1,2,3]
    //输出: 2
    //解释:
    //你有两个孩子和三块小饼干，2个孩子的胃口值分别是1,2。
    //你拥有的饼干数量和尺寸都足以让所有孩子满足。
    //所以你应该输出2.
    public int findContentChildren(int[] g, int[] s) {
        //贪心
        //目的是让更多的人满足
        //小的就给小的

        //先对小孩排序 把胃口小的放里面
        Arrays.sort(g);

        //再对饼干排序
        Arrays.sort(s);

        //遍历饼干或者小孩
        int cookieindex=0;
        int childindex=0;


        //保证小孩还有以及饼干也还有
        while(childindex<g.length&&cookieindex<s.length){
            if(g[childindex]<=s[cookieindex]){
                //如果当前小孩被小饼干喂饱了
                //那就下一个小孩了
                childindex++;
            }
            //饼干只可以用一次
            //如果不满足 那只能换一个更大号的饼干
            cookieindex++;
        }
        return childindex;
    }
}

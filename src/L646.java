import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Etherstrings
 * @create 2022-09-03 17:59 PACKAGE_NAME - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L646 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/9/3 - the current system date.  17:59 - the current system time.  2022 - the current year.  09 - the current month.  03 - the current day of the month.  17 - the current hour.  59 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  9月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  九月 - full name of a month. Example: January, February, etc
 */
public class L646 {
    //646. 最长数对链
    //给出 n 个数对。 在每一个数对中，第一个数字总是比第二个数字小。
    //
    //现在，我们定义一种跟随关系，当且仅当 b < c 时，数对(c, d) 才可以跟在 (a, b) 后面。我们用这种形式来构造一个数对链。
    //
    //给定一个数对集合，找出能够形成的最长数对链的长度。你不需要用到所有的数对，你可以以任何顺序选择其中的一些数对来构造。
    public int findLongestChain(int[][] pairs) {
        //贪心
        //每次都取最小的拼
        Comparator<int[]> com=new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {

                    //如果左侧相同
                    return Integer.compare(o1[1],o2[1]);


            }
        };
        Arrays.sort(pairs,com);
        //按照左边拼
        //找右边最小的
        int right= pairs[0][1];
        int size=1;
        for(int i=1;i< pairs.length;i++){
            int[] now=pairs[i];
            if(now[0]>right){
                size++;
                right=now[1];
            }

        }
        return size;
    }

}

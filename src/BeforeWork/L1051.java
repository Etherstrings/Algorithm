import java.util.Arrays;

/**
 * @author Etherstrings
 * @create 2022-06-13 10:14 PACKAGE_NAME - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L1051 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/6/13 - the current system date.  10:14 - the current system time.  2022 - the current year.  06 - the current month.  13 - the current day of the month.  10 - the current hour.  14 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  6月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  六月 - full name of a month. Example: January, February, etc
 */
public class L1051 {
    //1051. 高度检查器
    //学校打算为全体学生拍一张年度纪念照。根据要求，学生需要按照 非递减 的高度顺序排成一行。
    //
    //排序后的高度情况用整数数组 expected 表示，其中 expected[i] 是预计排在这一行中第 i 位的学生的高度（下标从 0 开始）。
    //
    //给你一个整数数组 heights ，表示 当前学生站位 的高度情况。heights[i] 是这一行中第 i 位学生的高度（下标从 0 开始）。
    //
    //返回满足 heights[i] != expected[i] 的 下标数量 。
    public int heightChecker(int[] heights) {
        int many=0;
        int[] copy = Arrays.copyOf(heights, heights.length);
        Arrays.sort(copy);
        for(int i=0;i<heights.length;i++){
            if(heights[i]!=copy[i]){
                many++;
            }
        }
        return many;
    }
}

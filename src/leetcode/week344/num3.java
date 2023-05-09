package leetcode.week344;

/**
 * @author Etherstrings
 * @create 2023-05-07 12:52 leetcode.week344 - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  num3 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2023/5/7 - the current system date.  12:52 - the current system time.  2023 - the current year.  05 - the current month.  07 - the current day of the month.  12 - the current hour.  52 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  5月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  五月 - full name of a month. Example: January, February, etc
 */
public class num3 {
    //6418. 有相同颜色的相邻元素数目
    //给你一个下标从 0 开始、长度为 n 的数组 nums 。一开始，所有元素都是 未染色 （值为 0 ）的。
    //
    //给你一个二维整数数组 queries ，其中 queries[i] = [indexi, colori] 。
    //
    //对于每个操作，你需要将数组 nums 中下标为 indexi 的格子染色为 colori 。
    //
    //请你返回一个长度与 queries 相等的数组 answer ，其中 answer[i]是前 i 个操作 之后 ，相邻元素颜色相同的数目。
    //
    //更正式的，answer[i] 是执行完前 i 个操作后，0 <= j < n - 1 的下标 j 中，满足 nums[j] == nums[j + 1] 且 nums[j] != 0 的数目。
    //
    //
    //
    //示例 1：
    //
    //输入：n = 4, queries = [[0,2],[1,2],[3,1],[1,1],[2,1]]
    //输出：[0,1,1,0,2]
    //解释：一开始数组 nums = [0,0,0,0] ，0 表示数组中还没染色的元素。
    //- 第 1 个操作后，nums = [2,0,0,0] 。相邻元素颜色相同的数目为 0 。
    //- 第 2 个操作后，nums = [2,2,0,0] 。相邻元素颜色相同的数目为 1 。
    //- 第 3 个操作后，nums = [2,2,0,1] 。相邻元素颜色相同的数目为 1 。
    //- 第 4 个操作后，nums = [2,1,0,1] 。相邻元素颜色相同的数目为 0 。
    //- 第 5 个操作后，nums = [2,1,1,1] 。相邻元素颜色相同的数目为 2 。
    //示例 2：
    //
    //输入：n = 1, queries = [[0,100000]]
    //输出：[0]
    //解释：一开始数组 nums = [0] ，0 表示数组中还没染色的元素。
    //- 第 1 个操作后，nums = [100000] 。相邻元素颜色相同的数目为 0 。
    public int[] colorTheArray(int n, int[][] queries) {
        int[] ans=new int[n];
        int[] grid=new int[n];
        int show=0;
        //染色相同的个数
        for(int i=0;i<ans.length;i++){
            int index=queries[i][0];
            int color=queries[i][1];
            if(index==0){
                int rightc=grid[index+1];
            }else if(index==n-1){

            }

        }
        return  ans;
    }
}

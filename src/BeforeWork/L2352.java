/**
 * @author Etherstrings
 * @create 2023-06-06 14:17 PACKAGE_NAME - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L2352 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2023/6/6 - the current system date.  14:17 - the current system time.  2023 - the current year.  06 - the current month.  06 - the current day of the month.  14 - the current hour.  17 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  6月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  六月 - full name of a month. Example: January, February, etc
 */
public class L2352 {
    public static void main(String[] args) {
        int[][] grid=new int[][]{{3,2,1},{1,7,6},{2,7,7}};
        System.out.println(equalPairs(grid));
    }
    //2352. 相等行列对
    //给你一个下标从 0 开始、大小为 n x n 的整数矩阵 grid ，返回满足 Ri 行和 Cj 列相等的行列对 (Ri, Cj) 的数目。
    //
    //如果行和列以相同的顺序包含相同的元素（即相等的数组），则认为二者是相等的。
    public static int equalPairs(int[][] grid) {
        int ans=0;
        for(int i=0;i<grid.length;i++){
            int[] now=grid[i];
            ans+=getans(now,grid);
        }
        return ans;
    }
    public static int getans(int[] now,int[][] grid){
        int ans=0;
        for(int j=0;j<grid.length;j++){
            boolean flag=true;
            for(int i=0;i<grid.length;i++){
                if(grid[i][j]!=now[i]){
                    flag=false;
                    break;
                }
            }
            if(flag){
                ans+=1;
            }
        }
        return ans;
    }
}

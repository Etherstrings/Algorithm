package leetcode.week300;

import LinkedList.ListNode;

import java.util.List;

/**
 * @author Etherstrings
 * @create 2022-07-03 10:48 leetcode.week300 - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L6111 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/7/3 - the current system date.  10:48 - the current system time.  2022 - the current year.  07 - the current month.  03 - the current day of the month.  10 - the current hour.  48 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  7月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  七月 - full name of a month. Example: January, February, etc
 */
public class L6111 {
    //6111. 螺旋矩阵 IV 显示英文描述
    //通过的用户数436
    //尝试过的用户数487
    //用户总通过次数436
    //用户总提交次数551
    //题目难度Medium
    //给你两个整数：m 和 n ，表示矩阵的维数。
    //
    //另给你一个整数链表的头节点 head 。
    //
    //请你生成一个大小为 m x n 的螺旋矩阵，矩阵包含链表中的所有整数。链表中的整数从矩阵 左上角 开始、顺时针 按 螺旋 顺序填充。如果还存在剩余的空格，则用 -1 填充。
    //
    //返回生成的矩阵。
    //从左往右
    int right = 0;
    //从上往下
    int down = 1;
    //从右往左
    int left = 2;
    //从下往上
    int up = 3;

    //第几圈
    int circle=1;
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        ListNode Dummy=new ListNode(-1);
        Dummy.next=head;
        ListNode Now=head;
        //m---行数
        //n---列数
        //初始化数组
        int[][] ans=new int[m][n];

        fillit(m,n,0,0,right,ans,Now);
        return ans;
    }

    void fillit(int row,int col,int x,int y,int direct,int[][] ans,ListNode Now){
        if(row==0||col==0){

            return;
        }
        switch(direct){
            case 0:
                for(int j = y; j < y + col; j++) {
                    if (Now != null) {
                        ans[x][j] = Now.val;
                        Now = Now.next;
                    } else {
                        ans[x][j] = -1;
                    }
                }
                fillit(row - 1, col, x + 1, y,down,ans,Now);
                break;
            case 1:
                for (int i = x; i < x + row; i++){
                    if (Now != null){
                        ans[i][y + col - 1]=Now.val;
                        Now = Now.next;
                    }else {
                        ans[i][y + col - 1]=-1;
                    }
                }
                fillit(row, col - 1, x, y, left,ans,Now);
                break;
            case 2:
                for (int j = y + col - 1; j >= y; j--){
                    if (Now != null){
                        ans[x + row - 1][j]=Now.val;
                        Now = Now.next;
                    }else {
                        ans[x + row - 1][j]=-1;
                    }
                }
                fillit(row - 1, col, x, y, up,ans,Now);
                break;
            case 3:
                for (int i = x + row - 1; i >= x; i--){
                    if (Now != null){
                        ans[i][y]=Now.val;
                        Now = Now.next;
                    }else {
                        ans[i][y]=-1;
                    }
                    circle++;//打印完一圈
                }
                fillit(row, col - 1, x, y + 1, right,ans,Now);
                break;
        }

    }
}

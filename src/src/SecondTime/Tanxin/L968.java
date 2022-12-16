package src.SecondTime.Tanxin;

import Tree.TreeNode;

/**
 * @author Etherstrings
 * @create 2022-08-29 13:04 SecondTime.Tanxin - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L968 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/8/29 - the current system date.  13:04 - the current system time.  2022 - the current year.  08 - the current month.  29 - the current day of the month.  13 - the current hour.  04 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  8月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  八月 - full name of a month. Example: January, February, etc
 */
public class L968 {
    int res=0;
    public int minCameraCover(TreeNode root){
        if(minCame(root)==0){
            res++;
        }
        return res;
    }
    public int minCame(TreeNode root){
        /**
         节点的状态值：
         0 表示无覆盖
         1 表示 有摄像头
         2 表示有覆盖
         后序遍历，根据左右节点的情况,来判读 自己的状态
         */
        if(root==null){
            // 空节点默认为 有覆盖状态，避免在叶子节点上放摄像头
            return 2;
        }

        int left=minCame(root.left);
        int right=minCame(root.right);
        if(left==2&&right==2){
            //左右两边都是有覆盖
            return 0;
        }else if(left==0||right==0){
            res++;
            return 1;
        }else {
            return 2;
        }
    }


}

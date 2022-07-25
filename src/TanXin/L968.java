package TanXin;

import Tree.TreeNode;

/**
 * @author Etherstrings
 * @create 2022-07-22 13:50 TanXin - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L968 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/7/22 - the current system date.  13:50 - the current system time.  2022 - the current year.  07 - the current month.  22 - the current day of the month.  13 - the current hour.  50 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  7月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  七月 - full name of a month. Example: January, February, etc
 */
public class L968 {
    //968. 监控二叉树
    //给定一个二叉树，我们在树的节点上安装摄像头。
    //
    //节点上的每个摄影头都可以监视其父对象、自身及其直接子对象。
    //
    //计算监控树的所有节点所需的最小摄像头数量。
    //
    //
    //
    //示例 1：
    //
    //
    //
    //输入：[0,0,null,0,0]
    //输出：1
    //解释：如图所示，一台摄像头足以监控所有节点。
    //示例 2：
    //
    //
    //
    //输入：[0,0,null,0,null,0,null,null,0]
    //输出：2
    //解释：需要至少两个摄像头来监视树的所有节点。 上图显示了摄像头放置的有效位置之一。
    //
    //提示：
    //
    //给定树的节点数的范围是 [1, 1000]。
    //每个节点的值都是 0。

    public int minCameraCover(TreeNode root) {
        //局部最优：让叶子节点的父节点安摄像头，所用摄像头最少，整体最优：全部摄像头数量所用最少

        //遍历方式---后序遍历 左右中
    }
}

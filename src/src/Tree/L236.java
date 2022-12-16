package src.Tree;

import Tree.TreeNode;

/**
 * @author Etherstrings
 * @create 2022-04-16 10:51 Tree - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L236 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/4/16 - the current system date.  10:51 - the current system time.  2022 - the current year.  04 - the current month.  16 - the current day of the month.  10 - the current hour.  51 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  4月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  四月 - full name of a month. Example: January, February, etc
 */
public class L236 {
    //236. 二叉树的最近公共祖先
    //给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
    //
    //百度百科中最近公共祖先的定义为：“对于有根树 T 的两个节点 p、q，最近公共祖先表示为一个节点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
    //
    //
    //
    //示例 1：
    //
    //
    //输入：root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
    //输出：3
    //解释：节点 5 和节点 1 的最近公共祖先是节点 3 。
    //示例 2：
    //
    //
    //输入：root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
    //输出：5
    //解释：节点 5 和节点 4 的最近公共祖先是节点 5 。因为根据定义最近公共祖先节点可以为节点本身。
    //示例 3：
    //
    //输入：root = [1,2], p = 1, q = 2
    //输出：1

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {


        if(root==null||root==p||root==q){
            //递归的结束条件
            return root;
        }


        //后序遍历
        //左右中
        TreeNode left=lowestCommonAncestor(root.left,p,q);
        TreeNode right=lowestCommonAncestor(root.right,p,q);


        if(left==null&&right==null){
            //未找到节点q或者p
            return null;
        }else if(left == null && right != null){
            //找到一个节点
            return right;
        }else if(left != null && right == null){
            //找到一个节点
            return left;
        }else {
            //若找到两个节点
            return root;
        }



    }
}

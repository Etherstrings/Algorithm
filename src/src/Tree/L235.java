package src.Tree;

import Tree.TreeNode;

/**
 * @author Etherstrings
 * @create 2022-04-17 14:34 Tree - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L235 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/4/17 - the current system date.  14:34 - the current system time.  2022 - the current year.  04 - the current month.  17 - the current day of the month.  14 - the current hour.  34 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  4月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  四月 - full name of a month. Example: January, February, etc
 */
public class L235 {
    //235. 二叉搜索树的最近公共祖先
    //给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
    //
    //百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
    //
    //例如，给定如下二叉搜索树:  root = [6,2,8,0,4,7,9,null,null,3,5]
    //
    //
    //
    //
    //
    //示例 1:
    //
    //输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
    //输出: 6
    //解释: 节点 2 和节点 8 的最近公共祖先是 6。
    //示例 2:
    //
    //输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
    //输出: 2
    //解释: 节点 2 和节点 4 的最近公共祖先是 2, 因为根据定义最近公共祖先节点可以为节点本身

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root.val> p.val&&root.val> q.val){
            return lowestCommonAncestor(root.left,p,q);
        }

        if(root.val< p.val&&root.val< q.val){
            return lowestCommonAncestor(root.right,p,q);
        }

        return root;
    }


    //迭代法
    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q){
        while(true){
            if (root.val > p.val && root.val > q.val) {
                root = root.left;
            } else if (root.val < p.val && root.val < q.val) {
                root = root.right;
            } else {
                break;
            }
        }





        return root;
        }


}

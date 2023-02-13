package src.SecondTime.Tree.DiGui;

import Tree.TreeNode;

/**
 * @author Etherstrings
 * @create 2022-08-19 0:15 SecondTime.Tree.DiGui - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L450 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/8/19 - the current system date.  0:15 - the current system time.  2022 - the current year.  08 - the current month.  19 - the current day of the month.  00 - the current hour.  15 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  8月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  八月 - full name of a month. Example: January, February, etc
 */
public class L450 {
    //450. 删除二叉搜索树中的节点
    //给定一个二叉搜索树的根节点 root 和一个值 key，删除二叉搜索树中的 key 对应的节点，并保证二叉搜索树的性质不变。返回二叉搜索树（有可能被更新）的根节点的引用。
    //
    //一般来说，删除节点可分为两个步骤：
    //
    //首先找到需要删除的节点；
    //如果找到了，删除它。
    //
    //
    //示例 1:
    //
    //
    //
    //输入：root = [5,3,6,2,4,null,7], key = 3
    //输出：[5,4,6,2,null,null,7]
    //解释：给定需要删除的节点值是 3，所以我们首先找到 3 这个节点，然后删除它。
    //一个正确的答案是 [5,4,6,2,null,null,7], 如下图所示。
    //另一个正确答案是 [5,2,6,null,4,null,7]。
    //
    //
    //示例 2:
    //
    //输入: root = [5,3,6,2,4,null,7], key = 0
    //输出: [5,3,6,2,4,null,7]
    //解释: 二叉树不包含值为 0 的节点
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root==null){
            return root;
        }
        if(root.val>key){
            root.left=deleteNode(root.left,key);
        }else if(root.val<key){
            root.right=deleteNode(root.right,key);
        }else {
            if(root.left==null&&root.right==null&&root.val==key){
                return null;
            }
            if(root.left!=null&&root.right==null&&root.val==key){
                return root.right;
            }
            if(root.left!=null&&root.right!=null&&root.val==key){
                //返回右节点
                TreeNode left=root.left;
                TreeNode right=root.right;
                while(right.left!=null){
                    right=right.left;
                }
                right.left=left;
                return root.right;
                //左节点放到右节点的最左边的节点
            }
        }


    }
}

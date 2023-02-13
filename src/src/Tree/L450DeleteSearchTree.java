package src.Tree;

import Tree.TreeNode;

/**
 * @author Etherstrings
 * @create 2022-04-20 23:15 Tree - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L450DeleteSearchTree - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/4/20 - the current system date.  23:15 - the current system time.  2022 - the current year.  04 - the current month.  20 - the current day of the month.  23 - the current hour.  15 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  4月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  四月 - full name of a month. Example: January, February, etc
 */
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
//示例 3:
//
//输入: root = [], key = 0
//输出: []
public class L450DeleteSearchTree {

    //递归方法

    //首先确定返回值+传入参数
    //返回的为TreeNode 传入参数为当前节点+删除数key
    public Tree.TreeNode deleteNode(Tree.TreeNode root, int key) {
        //确定返回值
        if(root==null){
            return null;
        }

        //每一次递归的逻辑判断

        //当前数值大于val
        if(root.val>key){
            root.left=deleteNode(root.left,key);
            //当前数值小于val
        }else if(root.val<key){
            root.right=deleteNode(root.right,key);
        }else{
            //当前就是找到了root.val==key
            //分情况讨论
            //第一种情况 叶子节点
            if(root.left==null&&root.right==null){
                root=null;
            }
            //右边不空
            if(root.left==null){
                return root.right;
            }
            //左边不空
            if(root.right==null){
                return root.left;
            }


            //最后一种
            //左右都不空
            TreeNode temp=root.right;

            while (temp.left != null) {
                temp = temp.left;
            }
            root.val=temp.val;
            root.right=deleteNode(root.right, temp.val);


        }
        return root;
    }
}

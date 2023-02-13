package src.Tree;

import Tree.TreeNode;

/**
 * @author Etherstrings
 * @create 2022-04-07 13:45 Tree - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L105 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/4/7 - the current system date.  13:45 - the current system time.  2022 - the current year.  04 - the current month.  07 - the current day of the month.  13 - the current hour.  45 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  4月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  四月 - full name of a month. Example: January, February, etc
 */
//105. 从前序与中序遍历序列构造二叉树
//给定两个整数数组 preorder 和 inorder ，其中 preorder 是二叉树的先序遍历， inorder 是同一棵树的中序遍历，请构造二叉树并返回其根节点。
//
//
//
//示例 1:
//
//
//输入: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
//输出: [3,9,20,null,null,15,7]
//示例 2:
//
//输入: preorder = [-1], inorder = [-1]
//输出: [-1]
public class L105 {
    //递归重构
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree1(preorder,0,preorder.length-1,inorder,0,inorder.length-1);
    }

    private TreeNode buildTree1(int[] preorder,int proleft,int proright,int[] inorder,int inleft,int inright){
        // 递归终止条件
        if (inleft > inright || proleft > proright) return null;
        //首先在前序中找根结点root
        int val=preorder[proleft];

        TreeNode root=new TreeNode(val);

        //根据找到的根节点的值
        //在中序中寻找相对应的indx----分界点
        int rootindex=0;
        for(int i=inleft;i<inright;i++){
            if(inorder[i]==val){
                rootindex=i;
                break;
            }
        }

        //前序
            //prleft+1 --------------- proleft+1+(rootindex-inleft)

        //中序
            //inleft------------rootindex
        root.left=buildTree1(preorder,proleft+1,proleft+1+(rootindex-inleft),inorder,inleft,rootindex);


        //前序
            //preleft+1+(rootindex-inleft)-----------------preright

        //中序
            //index------------inright
        root.right=buildTree1(preorder,proleft+1+(rootindex-inleft),proright,inorder,rootindex,inright);


        return root;


        //根据找到的index
        //在前序中分为 左树+右树
        //中序中分为 左树和右数
    }


}

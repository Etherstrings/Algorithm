package src.MihaYou;


import Tree.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Etherstrings
 * @create 2022-09-14 19:11 MihaYou - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  GetPathMax - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/9/14 - the current system date.  19:11 - the current system time.  2022 - the current year.  09 - the current month.  14 - the current day of the month.  19 - the current hour.  11 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  9月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  九月 - full name of a month. Example: January, February, etc
 */
public class GetPathMax {
    static List<Integer> ans=new ArrayList<>();
    static int sum=0;
    public int maxPathSum (int[] preorder, int[] inorder) {
        // write code here
        //先根据前序遍历和中序遍历构建树
        // 树的路径最大值
        TreeNode root=buildTree(preorder,inorder);
        //回溯找最大值
        Collections.sort(ans);
        return ans.get(ans.size()-1);
    }
    static void BackTarcking(TreeNode root){
        sum+=root.val;
        if(root.left==null&&root.right==null){
            ans.add(sum);
            return;
        }

        if(root.left!=null){

            BackTarcking(root.left);
            sum-=root.left.val;
        }

        if(root.right!=null){

            BackTarcking(root.right);
            sum-=root.right.val;
        }
    }
    static public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree1(preorder,0,preorder.length-1,inorder,0,inorder.length-1);
    }

    static TreeNode buildTree1(int[] preorder,int proleft,int proright,int[] inorder,int inleft,int inright){
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

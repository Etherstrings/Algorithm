package src.SecondTime.Tree;

import Tree.TreeNode;

import java.util.List;

/**
 * @description:
 * @author： wuboyu
 * @date： 2022-08-12 14:06
 */
public class TreeSeeAll {
    //前中后深搜
    void Pre(TreeNode root,List<Integer> ans){

        if(root==null){
            return ;
        }
        //中左右
        ans.add(root.val);
        if(root.left!=null){
            Pre(root.left,ans);
        }

        if(root.right!=null){
            Pre(root.right,ans);
        }

    }

    void Mid(TreeNode root,List<Integer> ans){
        if(root==null){
            return;
        }
        if(root.left!=null){
            Mid(root.left,ans);
        }
        ans.add(root.val);
        if(root.right!=null){
            Mid(root.right,ans);
        }
    }

    void Back(TreeNode root,List<Integer> ans){
        if(root==null){
            return;
        }
        if(root.left!=null){
            Back(root.left,ans);
        }
        if(root.right!=null){
            Back(root.right,ans);
        }
        ans.add(root.val);
    }


}

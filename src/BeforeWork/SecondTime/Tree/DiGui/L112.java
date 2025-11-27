package SecondTime.Tree.DiGui;

import Tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author： wuboyu
 * @date： 2022-08-16 16:37
 */
public class L112 {
    //回溯+对比
    List<Integer> ans=new ArrayList<>();
    int sum=0;
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root==null){
            return false;
        }
        BackTarcking(root);
        for(Integer a:ans){
            if(targetSum==a){
                return true;
            }
        }
        return false;
    }

    void BackTarcking(TreeNode root){
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

    public boolean hasPathSum1(TreeNode root, int targetSum) {
        if(root==null){
            return false;
        }
        BackTarcking(root);
        for(Integer a:ans){
            if(targetSum==a){
                return true;
            }
        }
        return false;
    }
    void BackTarcking(TreeNode root,int sum){
        sum+=root.val;
        if(root.left==null&&root.right==null){
            ans.add(sum);
            return;
        }

        if(root.left!=null){

            BackTarcking(root.left,sum);


        }

        if(root.right!=null){

            BackTarcking(root.right,sum);


        }
    }
}

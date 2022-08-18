package SecondTime.Tree.DiGui;

import Tree.TreeNode;

import javax.management.Query;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @description:
 * @author： wuboyu
 * @date： 2022-08-16 15:51
 */
public class L404 {
    //左叶子之和
    //第一种为层序遍历
    //第二种为递归
    public int sumOfLeftLeaves1(TreeNode root) {
        return dfs(root);
    }

    int dfs(TreeNode root){
        if(root==null){
            return 0;
        }
        int left=dfs(root.left);//左
        int right=dfs(root.right);//右
        //中
        //中何时才可以进来？
        int sum=0;
        if(root.left!=null&&root.left.left!=null&&root.left.right!=null){
            sum=root.left.val;
        }

        return sum+left+right;
    }

    public int sumOfLeftLeaves(TreeNode root){
        //层序遍历
        int ans=0;
        if(root==null){
            return 0;
        }
        Queue<TreeNode> Judge=new LinkedList<>();
        Judge.offer(root);
        while(!Judge.isEmpty()){
            int size=Judge.size();
            for(int i=0;i<size;i++){
                TreeNode Temp=Judge.poll();
                if(Temp.left!=null){
                    Judge.offer(Temp.left);
                    if (Temp.left.left == null && Temp.left.right == null){ // 左叶子节点
                        ans += Temp.left.val;
                    }
                }
                if(Temp.right!=null){
                    Judge.offer(Temp.right);
                }
            }
        }
        return ans;
    }
}

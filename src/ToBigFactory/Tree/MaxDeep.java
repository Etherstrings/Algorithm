package ToBigFactory.Tree;

import Tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class MaxDeep {
    public int maxDepth(TreeNode root) {
        return 1;
    }

    public static int getmaxBFS(TreeNode root){
        if(root==null){
            return 0;
        }
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        int dep=0;
        while(!queue.isEmpty()){
            dep++;
            for(int i=0;i<queue.size();i++){
                TreeNode now=queue.poll();
                if(now.left!=null){
                    queue.offer(now.left);
                }
                if(now.right!=null){
                    queue.offer(now.right);
                }
            }
        }
        return dep;
    }

    public static int getMaxDep(TreeNode root){
        if(root==null){
            return 0;
        }
        int left=getMaxDep(root.left);
        int right=getMaxDep(root.right);
        int ans=Math.max(left,right)+1;
        return ans;
    }
}

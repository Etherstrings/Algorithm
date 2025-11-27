package DFS;

import Tree.TreeNode;

/**
 * @author wuboyu <wuboyu@kuaishou.com>
 * Created on 2023-09-27
 */
public class L111 {
    //给定一个二叉树，找出其最小深度。
    //
    //最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
    //
    //说明：叶子节点是指没有子节点的节点。

    //> 2023/09/27 14:52:48
    //解答成功:
    //	执行耗时:13 ms,击败了7.97% 的Java用户
    //	内存消耗:60.3 MB,击败了52.02% 的Java用户
    public int minDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        if(root.left==null && root.right==null){
            return 1;
        }
        int left=minDepth(root.left);
        int right=minDepth(root.right);
        if(root.left==null || root.right==null){
            return left+right+1;
        }
        return Math.min(left,right)+1;
    }
}

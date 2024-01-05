package DFS;

import Tree.TreeNode;

/**
 * @author wuboyu <wuboyu@kuaishou.com>
 * Created on 2023-12-15
 */
public class L2415 {
    public TreeNode reverseOddLevels(TreeNode root) {
        //思路 通过dfs进行互换
        return root;
    }

    public void dfs(TreeNode left, TreeNode right, int level){
        if(left==null||right==null){
            return;
        }
        if(level%2==1){
            int temp = left.val;
            left.val = right.val;
            right.val = temp;
        }
        dfs(left.left,right.right,level+1);
        dfs(left.right,right.left,level+1);
    }

}

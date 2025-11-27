package DP;


import Tree.TreeNode;

/**
 * @author wuboyu <wuboyu@kuaishou.com>
 * Created on 2023-09-18
 */
public class L337 {
    //打家劫舍3
    //树上dp
    //> 2023/09/18 10:53:42
    //解答成功:
    //	执行耗时:0 ms,击败了100.00% 的Java用户
    //	内存消耗:42.5 MB,击败了78.09% 的Java用户
    public int rob(TreeNode root) {
        int[] res=getmax(root);
        return Math.max(res[0],res[1]);
    }

    public int[] getmax(TreeNode root){
        if (root == null) {
            return new int[2];
        }
        int[] left= getmax(root.left);
        int[] right= getmax(root.right);
        int[] res=new int[2];
        //res[0]表示不偷当前节点的最大值
        //当前不偷 左右两边的选择可以任取
        res[0]=Math.max(left[0],left[1])+Math.max(right[0],right[1]);
        //res[1]表示偷当前节点的最大值
        //当前偷 左右两边只能选择不偷
        res[1]=left[0]+right[0]+root.val;
        return res;
    }
}

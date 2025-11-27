package Tree;

import java.util.ArrayList;

/**
 * @description:
 * @author： wuboyu
 * @date： 2022-08-23 11:43
 */
public class L1382 {
    public TreeNode balanceBST(TreeNode root) {
        //先后序或者前序遍历
        //然后构造二叉平衡树
        inorder(root);
        return trans(res,0,res.size()-1);
    }
    ArrayList<Integer> res = new ArrayList<Integer>();
    void inorder(TreeNode root){
        if(root==null){
            return;
        }
        //左
        inorder(root.left);
        //中
        res.add(root.val);
        //右
        inorder(root.right);
    }
    TreeNode trans(ArrayList<Integer> res,int left,int right){
        if(left>right){
            return null;
        }
        //有序数组构建二叉平衡树
        int mind=left+(right-left)/2;
        TreeNode root=new TreeNode(res.get(mind));
        //根据mid划分左子树和右子树
        root.left=trans(res,left,mind-1);
        root.right=trans(res,mind+1,right);
        return root;
    }

}

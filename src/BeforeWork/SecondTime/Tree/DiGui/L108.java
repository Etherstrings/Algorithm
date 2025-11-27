package SecondTime.Tree.DiGui;

import Tree.TreeNode;

/**
 * @description:
 * @author： wuboyu
 * @date： 2022-08-19 10:27
 */
public class L108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        return build(nums,0,nums.length);
    }

    TreeNode build(int[] nums,int left,int right){
        if(left>=right){
            return null;
        }
        int index=left+(right-left)/2;
        TreeNode root=new TreeNode(nums[index]);

        root.left=build(nums,left,index);
        root.right=build(nums,index+1,right);

        return root;
    }
}

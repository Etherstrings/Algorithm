package src.SecondTime.Tree.DiGui;

import Tree.TreeNode;

/**
 * @description:
 * @author： wuboyu
 * @date： 2022-08-18 14:09
 */
public class L654 {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        //依旧是找到最大值
        //构造左 构造右
        return build(nums,0,nums.length);
    }

    TreeNode build(int[] nums,int left,int right){
        if(left>=right){
            return null; }
        int index=-1;
        int maxValue=-1;
        for(int i=left;i<right;i++){
            maxValue=Math.max(maxValue,nums[i]);
        }
        for(int i=left;i<right;i++){
            if(nums[i]==maxValue){
                index=i;
            }
        }
        TreeNode root=new TreeNode(nums[index]);

        int left1=left;
        int left2=index;


        int right1=index+1;
        int right2=right;

        root.left=build(nums,left1,left2);
        root.right=build(nums,right1,right2);

        return root;
    }
}

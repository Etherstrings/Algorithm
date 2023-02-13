package src.Tree;

import Tree.TreeNode;

/**
 * @author Etherstrings
 * @create 2022-04-11 11:07 Tree - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L654 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/4/11 - the current system date.  11:07 - the current system time.  2022 - the current year.  04 - the current month.  11 - the current day of the month.  11 - the current hour.  07 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  4月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  四月 - full name of a month. Example: January, February, etc
 */
public class L654 {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return constructMaximumBinaryTree1(nums, 0, nums.length);
    }

    private TreeNode constructMaximumBinaryTree1(int[] nums,int leftindex,int rightindex){
        if(rightindex-leftindex==0){
            //没有元素了
            //终止！
            return null;
        }
        //如果right-left=1
        //分不了了
        //只有一个元素 只需要建立一个新的TreeNode
        if(rightindex-leftindex==1){
            return new TreeNode(nums[leftindex]);
        }

        int maxindex=leftindex;
        int maxvalue=nums[leftindex];

        for(int i=leftindex+1;i<rightindex;i++){
            if(nums[i]>maxvalue){
                maxindex=i;
                maxvalue=nums[i];
            }
        }

        TreeNode root=new TreeNode(maxvalue);

        root.left=constructMaximumBinaryTree1(nums,leftindex,maxindex);
        root.right=constructMaximumBinaryTree1(nums,maxindex+1,rightindex);

        return root;





    }
}

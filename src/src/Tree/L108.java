package src.Tree;

import Tree.TreeNode;

/**
 * @author Etherstrings
 * @create 2022-04-29 20:57 Tree - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L108 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/4/29 - the current system date.  20:57 - the current system time.  2022 - the current year.  04 - the current month.  29 - the current day of the month.  20 - the current hour.  57 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  4月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  四月 - full name of a month. Example: January, February, etc
 */
public class L108 {

    public Tree.TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBST(nums, 0, nums.length);
    }

    public Tree.TreeNode sortedArrayToBST(int[] nums, int left, int right){
        if(left>=right){
            return null;
        }

        if(right-left==1){
            return new Tree.TreeNode(nums[left]);
        }

        int mid=left+(right-left)/2;
        Tree.TreeNode root=new TreeNode(nums[mid]);
        root.left=sortedArrayToBST(nums, left, mid);
        root.right=sortedArrayToBST(nums,mid+1,right);
        return root;
    }

}

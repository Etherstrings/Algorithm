package Build;

import java.util.LinkedList;

import Tree.TreeNode;

/**
 * @author wuboyu <wuboyu@kuaishou.com>
 * Created on 2024-01-16
 */
public class YingWeiDaBuildTree {
    public static void main(String[] args) {
        //[1,5,9,4,3,7,6]
        int[] nums = new int[]{1,5,9,4,3,7,6};
        YingWeiDaBuildTree yingWeiDaBuildTree = new YingWeiDaBuildTree();
        TreeNode root = yingWeiDaBuildTree.buildTreeFromArrayList(nums,0,nums.length-1);
        int[] res = yingWeiDaBuildTree.recoeryArrayListFromTree2(root);
        //打印res到一行
        for(int i = 0; i < res.length; i++){
            System.out.print(res[i] + " ");
        }
    }

    public TreeNode buildTreeFromArrayList(int[] nums, int left, int right){
        if(left > right){
            return null;
        }
        int maxIndex = findMax(nums,left,right);
        TreeNode root = new TreeNode(nums[maxIndex]);
        root.left = buildTreeFromArrayList(nums,left,maxIndex-1);
        root.right = buildTreeFromArrayList(nums,maxIndex+1,right);
        return root;
    }

    public int findMax(int[] nums, int left, int right){
        int max = Integer.MIN_VALUE;
        int maxIndex = -1;
        for(int i = left; i <= right; i++){
            if(nums[i] > max){
                max = nums[i];
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    //双向列表
    public LinkedList<Integer> recoeryArrayListFromTree(TreeNode root){
        if(root== null){
            return null;
        }
        LinkedList<Integer> res = new LinkedList<>();
        LinkedList<Integer> left = recoeryArrayListFromTree(root.left);
        LinkedList<Integer> right = recoeryArrayListFromTree(root.right);
        if(left != null){
            res.addAll(left);
        }
        res.add(root.val);
        if(right != null){
            res.addAll(right);
        }
        return res;
    }

    public int[] recoeryArrayListFromTree2(TreeNode root){
        LinkedList<Integer> res = recoeryArrayListFromTree(root);
        int[] resArray = new int[res.size()];
        for(int i = 0; i < res.size(); i++){
            resArray[i] = res.get(i);
        }
        return resArray;
    }
}

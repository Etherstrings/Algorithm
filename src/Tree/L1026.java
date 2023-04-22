package Tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class L1026 {
    public static void main(String[] args) {
        TreeNode root=new TreeNode(1);
        root.left=new TreeNode(5,null,null);
        root.right=new TreeNode(6,new TreeNode(3,null,null),null);
        System.out.println(maxAncestorDiff(root));
    }
    //1.深搜 获取每一条路径
    //2.查找 当前路径: int[] nums 任意两个数之间的最大值
    public static int maxAncestorDiff(TreeNode root) {
        ans=new ArrayList<>();
        Path=new LinkedList<>();
        backtarcking(root);
        int Tans=Integer.MIN_VALUE;
        for(List<Integer> now:ans){
            Collections.sort(now);
            Tans=Math.max((now.get(now.size()-1)-now.get(0)),Tans);
        }
        return Tans;
    }
    public static List<List<Integer>> ans;
    public static LinkedList<Integer> Path;
    public static void backtarcking(TreeNode root){
        Path.add(root.val);
        if(root.left==null&&root.right==null){
            if(Path.size()!=0){
                ans.add(new ArrayList<>(Path));
            }
            return;
        }
        if(root.left!=null){
            backtarcking(root.left);
            Path.removeLast();
        }

        if(root.right!=null){
            backtarcking(root.right);
            Path.removeLast();
        }

    }
}

package WorkReview.CralBook.TreeProblem;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import Tree.TreeNode;

/**
 * @author wuboyu <wuboyu@kuaishou.com>
 * Created on 2025-12-04
 */
public class L102 {
    public static List<List<Integer>> getCengXu(Tree.TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        Queue<Tree.TreeNode> Tool = new LinkedList<>();
        Tool.offer(root);
        while (!Tool.isEmpty()) {
            int size = Tool.size();
            List<Integer> nowL = new ArrayList<>();
            for (int i = 0;i<size;i++) {
                TreeNode poll = Tool.poll();
                nowL.add(poll.val);
                if (poll.left!=null) {
                    Tool.offer(poll.left);
                }
                if (poll.right!=null) {
                    Tool.offer(poll.right);
                }
            }
            ans.add(nowL);
        }
        return ans;
    }
}

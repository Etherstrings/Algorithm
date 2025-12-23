package WorkReview.CralBook.TreeProblem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author wuboyu <wuboyu@kuaishou.com>
 * Created on 2025-12-11
 */
public class L107 {

    public List<List<Integer>> levelOrderBottom(Tree.TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> ans = new ArrayList<>();
        Queue<Tree.TreeNode> jud = new LinkedList<>();
        jud.offer(root);
        while (!jud.isEmpty()) {
            int size = jud.size();
            List<Integer> temp = new ArrayList<>();
            for (int i = 0 ;i < size; i++) {
                Tree.TreeNode node = jud.poll();
                temp.add(node.val);
                if (node.left!=null) {
                    jud.offer(node.left);
                }
                if (node.right!=null) {
                    jud.offer(node.right);
                }
            }
            ans.add(temp);
        }
        Collections.reverse(ans);
        return ans;
    }
}

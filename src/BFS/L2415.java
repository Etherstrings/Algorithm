package BFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import Tree.TreeNode;

/**
 * @author wuboyu <wuboyu@kuaishou.com>
 * Created on 2023-12-15
 */
public class L2415 {
    //给你一棵 完美 二叉树的根节点 root ，请你反转这棵树中每个 奇数 层的节点值。
    //
    //
    // 例如，假设第 3 层的节点值是 [2,1,3,4,7,11,29,18] ，那么反转后它应该变成 [18,29,11,7,4,3,1,2] 。
    //
    //
    // 反转后，返回树的根节点。
    //
    // 完美 二叉树需满足：二叉树的所有父节点都有两个子节点，且所有叶子节点都在同一层。
    //
    // 节点的 层数 等于该节点到根节点之间的边数。
    //
    //
    //
    // 示例 1：
    //
    //
    //输入：root = [2,3,5,8,13,21,34]
    //输出：[2,5,3,8,13,21,34]
    //解释：
    //这棵树只有一个奇数层。
    //在第 1 层的节点分别是 3、5 ，反转后为 5、3 。
    //
    //
    // 示例 2：
    //
    //
    //输入：root = [7,13,11]
    //输出：[7,11,13]
    //解释：
    //在第 1 层的节点分别是 13、11 ，反转后为 11、13 。
    //
    //
    // 示例 3：
    //
    //
    //输入：root = [0,1,2,0,0,0,0,1,1,1,1,2,2,2,2]
    //输出：[0,2,1,0,0,0,0,2,2,2,2,1,1,1,1]
    //解释：奇数层由非零值组成。
    //在第 1 层的节点分别是 1、2 ，反转后为 2、1 。
    //在第 3 层的节点分别是 1、1、1、1、2、2、2、2 ，反转后为 2、2、2、2、1、1、1、1 。
    //
    //
    //
    //
    // 提示：
    //
    //
    // 树中的节点数目在范围 [1, 2¹⁴] 内
    // 0 <= Node.val <= 10⁵
    // root 是一棵 完美 二叉树
    //
    //
    // Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 50 👎 0


    //> 2023/12/15 14:21:47
    //解答成功:
    //	执行耗时:8 ms,击败了48.47% 的Java用户
    //	内存消耗:45.9 MB,击败了92.86% 的Java用户
    //leetcode submit region begin(Prohibit modification and deletion)
    public TreeNode reverseOddLevels(TreeNode root) {
        //BFS完成
        if(root==null){
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        int len = 0;
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            //这一层的高度是奇数还是偶数？
            if(len%2==1){
                //反转这一层
                //反转该层的每一个节点的值
                List<TreeNode> nodes = new ArrayList<>(queue);
                for (int i = 0; i < nodes.size() / 2; i++) {
                    TreeNode left = nodes.get(i);
                    TreeNode right = nodes.get(nodes.size() - 1 - i);
                    int temp = left.val;
                    left.val = right.val;
                    right.val = temp;
                }
            }
            //这一层的高度是多少？
            for(int i=0;i<size;i++){
                TreeNode node = queue.poll();
                if(node.left!=null){
                    queue.offer(node.left);
                }
                if(node.right!=null){
                    queue.offer(node.right);
                }
            }
            len++;
        }
        return root;
    }
}

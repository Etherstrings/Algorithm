package Sword2Job;

import Tree.TreeNode;

/**
 * @author wuboyu <wuboyu@kuaishou.com>
 * Created on 2023-11-30
 */
public class Mian410 {
    //检查子树。你有两棵非常大的二叉树：T1，有几万个节点；T2，有几万个节点。设计一个算法，判断 T2 是否为 T1 的子树。
    //
    // 如果 T1 有这么一个节点 n，其子树与 T2 一模一样，则 T2 为 T1 的子树，也就是说，从节点 n 处把树砍断，得到的树与 T2 完全相同。
    //
    // 注意：此题相对书上原题略有改动。
    //
    // 示例1:
    //
    //
    // 输入：t1 = [1, 2, 3], t2 = [2]
    // 输出：true
    //
    //
    // 示例2:
    //
    //
    // 输入：t1 = [1, null, 2, 4], t2 = [3, 2]
    // 输出：false
    //
    //
    // 提示：
    //
    //
    // 树的节点数目范围为[0, 20000]。
    //
    //
    // Related Topics 树 深度优先搜索 二叉树 字符串匹配 哈希函数 👍 81 👎 0


    //leetcode submit region begin(Prohibit modification and deletion)
    //递归判断

    //> 2023/11/30 14:24:50
    //解答成功:
    //	执行耗时:0 ms,击败了100.00% 的Java用户
    //	内存消耗:43.6 MB,击败了63.20% 的Java用户
    public boolean checkSubTree(TreeNode t1, TreeNode t2) {
        if (t1 == null) {
            return false;
        }
        if (t1.val == t2.val && isSameTree(t1, t2)) {
            return true;
        }
        return checkSubTree(t1.left, t2) || checkSubTree(t1.right, t2);
    }

    public boolean isSameTree(TreeNode t1, TreeNode t2) {
        if(t1==null && t2==null){
            return true;
        }
        if(t1==null || t2==null){
            return false;
        }
        if(t1.val!=t2.val){
            return false;
        }
        return isSameTree(t1.left,t2.left) && isSameTree(t1.right,t2.right);
    }
}

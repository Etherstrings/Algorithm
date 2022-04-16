package Tree;

/**
 * @author Etherstrings
 * @create 2022-04-16 11:03 Tree - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L701 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/4/16 - the current system date.  11:03 - the current system time.  2022 - the current year.  04 - the current month.  16 - the current day of the month.  11 - the current hour.  03 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  4月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  四月 - full name of a month. Example: January, February, etc
 */
public class L701 {
    //701. 二叉搜索树中的插入操作
    //给定二叉搜索树（BST）的根节点 root 和要插入树中的值 value ，将值插入二叉搜索树。 返回插入后二叉搜索树的根节点。 输入数据 保证 ，新值和原始二叉搜索树中的任意节点值都不同。
    //
    //注意，可能存在多种有效的插入方式，只要树在插入后仍保持为二叉搜索树即可。 你可以返回 任意有效的结果 。
    //
    //
    //
    //示例 1：
    //
    //
    //输入：root = [4,2,7,1,3], val = 5
    //输出：[4,2,7,1,3,5]
    //解释：另一个满足题目要求可以通过的树是：
    //
    //示例 2：
    //
    //输入：root = [40,20,60,10,30,50,70], val = 25
    //输出：[40,20,60,10,30,50,70,null,null,25]
    //示例 3：
    //
    //输入：root = [4,2,7,1,3,null,null,null,null,null,null], val = 5
    //输出：[4,2,7,1,3,5]

    //递归方法
    public TreeNode insertIntoBST(TreeNode root, int val) {


        //如果当前节点未空，说明找到了合适的位置
        if(root==null){
            return new TreeNode(val);
        }

        if(root.val<val){
            // 递归创建右子树
            root.right=insertIntoBST(root.right,val);

        }

        if(root.val>val){
            // 递归创建左子树
            root.left=insertIntoBST(root.left,val);

        }

        return root;
    }


    //迭代方法
    public TreeNode insertIntoBST(TreeNode root, int val) {



    }

}

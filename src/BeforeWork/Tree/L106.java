package Tree;

/**
 * @author Etherstrings
 * @create 2022-04-07 11:41 Tree - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L106 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/4/7 - the current system date.  11:41 - the current system time.  2022 - the current year.  04 - the current month.  07 - the current day of the month.  11 - the current hour.  41 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  4月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  四月 - full name of a month. Example: January, February, etc
 */
public class L106 {
    //106. 从中序与后序遍历序列构造二叉树
    //给定两个整数数组 inorder 和 postorder ，其中 inorder 是二叉树的中序遍历， postorder 是同一棵树的后序遍历，请你构造并返回这颗 二叉树 。
    //
    //
    //
    //示例 1:
    //
    //
    //输入：inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
    //输出：[3,9,20,null,null,15,7]
    //示例 2:
    //
    //输入：inorder = [-1], postorder = [-1]
    //输出：[-1]
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        //递归
        return buildTree1(inorder,0,inorder.length,postorder,0,postorder.length);
    }

    public TreeNode buildTree1(int[] inorder,int inleft,int inright,int[] postorder,int postleft,int postright){

        if(inright-inleft<1){
            return null;
        }

        if(inright-inleft==1){
            return new TreeNode(inorder[inleft]);
        }
        //后续遍历的最后一个数值
        //就是根节点
        int rootval=postorder[postright-1];
        TreeNode root = new TreeNode(rootval);
        //此时
        //在中序遍历中找到了根节点的数值
        //左边的就是left 右边的就是right
        int rootindex=0;
        for(int i=inleft;i<inright;i++){
            if(inorder[i]==rootval){
                rootindex=i;
                break;
            }
        }



        //中序的左边
        //节点的前边都是 节点为index 左边为left-index

        //后序的左边
        //算出左边有多长---ileft-index
        //左边为left------left+（ileft-index）；
        root.left
                =buildTree1(inorder,inleft,rootindex,postorder,postleft,postleft+(rootindex-inleft));



        //中序的右边
        //节点的后边都是 index---iright
        //后序的右边
        //从左边结束 到右边结束
        //左边结束为 left+左长度
        //右结束为 right-1

        root.right=buildTree1(inorder,rootindex,inright,postorder,postleft+(rootindex-inleft),postright-1);


        return root;
    }
}

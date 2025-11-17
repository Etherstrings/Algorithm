package Tree;

public class L538 {
    int sum;
    public TreeNode convertBST(TreeNode root) {
        sum=0;
        convertBST1(root);
        return root;
    }


    //右中左的方式进行遍历
    //左边都是小的
        //中间如何处理：
        //主需要加上右边的值+自身的数值
    //右边都是大的
    public void convertBST1(TreeNode root){
        if(root==null){
            return;
        }
        convertBST1(root.right);
        sum+= root.val;
        root.val=sum;

        convertBST1(root.left);

    }




}

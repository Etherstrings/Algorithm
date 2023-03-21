package Tree;


import java.util.ArrayList;
import java.util.List;

/**
 * @author Etherstrings
 * @create 2022-03-13 11:26 Tree - the name of the target package where the new class or interface will be created.  ideaworkplace - the name of the current project.  ${FILE_NAME} - the name of the PHP file that will be created.  FindAll - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/3/13 - the current system date.  11:26 - the current system time.  2022 - the current year.  03 - the current month.  13 - the current day of the month.  11 - the current hour.  26 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  三月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  三月 - full name of a month. Example: January, February, etc
 */
public class FindAll {



        //前序遍历
        //递归
        public List<Integer> preorderTraversal (TreeNode root){
        List<Integer> result = new ArrayList<>();
        perorder(root, result);
        return result;

        }
        public void perorder (TreeNode root, List < Integer > result){
        if (root == null) {
            return;
        }
        result.add(root.val);
        perorder(root.left, result);
        perorder(root.right, result);

    }



    //中序遍历
    public List<Integer> inorderTraversal(TreeNode root){
        List<Integer> result=new ArrayList<>();
        inorder(root,result);
        return result;
    }

    void inorder(TreeNode root,List<Integer> result){
            if(root==null){
                return;
            }
            inorder(root.left,result);
            result.add(root.val);
            inorder(root.right,result);
    }


    //后序遍历
    public List<Integer> postorderTraversal(TreeNode root){
        List<Integer> result=new ArrayList<>();
        postorder(root,result);
        return result;
    }

    void postorder(TreeNode root,List<Integer> result){
            if(root==null){
                return;
            }
            postorder(root.left, result);
            postorder(root.right,result);
            result.add(root.val);
    }

}

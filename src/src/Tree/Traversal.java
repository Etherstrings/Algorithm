package src.Tree;

import Tree.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @author Etherstrings
 * @create 2022-03-15 9:42 Tree - the name of the target package where the new class or interface will be created.  ideaworkplace - the name of the current project.  ${FILE_NAME} - the name of the PHP file that will be created.  Traversal - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/3/15 - the current system date.  9:42 - the current system time.  2022 - the current year.  03 - the current month.  15 - the current day of the month.  09 - the current hour.  42 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  三月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  三月 - full name of a month. Example: January, February, etc
 */
public class Traversal {

    //中序迭代遍历
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result=new LinkedList<>();
        Stack<TreeNode> stack=new Stack<>();

        if(root!=null){
            stack.push(root);
        }
        while(!stack.empty()){
            TreeNode node=stack.peek();
            if(node!=null){
                stack.pop();
                if(node.right!=null){
                    stack.push(node.right);
                }
                stack.push(node);
                stack.push(null);
                if(node.left!=null){
                    stack.push(node.left);
                }
            }else{
                stack.pop();
                node=stack.peek();
                stack.pop();
                result.add(node.val);
            }
        }

        return result;
    }


    //前序迭代遍历
    public List<Integer> preorderTraversal(TreeNode root){
        List<Integer> result=new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();

        if(root!=null){
            stack.push(root);
        }

        while(!stack.empty()){
            TreeNode node=stack.peek();
            if(node!=null){
                stack.pop();
                if(node.right!=null){
                    stack.push(node.right);
                }
                if(node.left!=null){
                    stack.push(node.left);
                }

                stack.push(node);
                stack.push(null);
            }else{
                stack.pop();
                node=stack.peek();
                stack.pop();
                result.add(node.val);
            }
        }
        return result;
    }


    //后序迭代遍历
    public List<Integer> postorderTraversal(TreeNode root){
        List<Integer> result=new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();

        if(root!=null){
            stack.push(root);
        }

        while(!stack.empty()){
            TreeNode node=stack.peek();
            if(node!=null){

                stack.pop();
                stack.push(node);
                stack.push(null);
                if(node.right!=null){
                    stack.push(node.right);
                }
                if(node.left!=null){
                    stack.push(node.left);
                }


            }else{
                stack.pop();
                node=stack.peek();
                stack.pop();
                result.add(node.val);
            }
        }
        return result;
    }
}

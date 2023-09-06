package Tree;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author wuboyu <wuboyu@kuaishou.com>
 * Created on 2023-09-04
 */
public class L449_SerTree {
    public static String serialize(TreeNode root) {
        //考虑用什么进行遍历
        Ino=new ArrayList<>();
        inorder(root);
        Post=new ArrayList<>();
        postorder(root);
        StringBuilder sb=new StringBuilder("");
        for(int i=0;i<Ino.size();i++){
            sb.append(Ino.get(i));
            sb.append(",");
        }
        for(int i=0;i<Post.size();i++){
            if(i==Post.size()-1){
                sb.append(Post.get(i));
                break;
            }
            sb.append(Post.get(i));
            sb.append(",");
        }
        return sb.toString();
    }
    public static List<Integer> Ino;
    public static List<Integer> Post;
    public static void inorder(TreeNode node){
        //左中右
        if(node==null){
            return ;
        }

            inorder(node.left);

        Ino.add(node.val);

            inorder(node.right);

    }

    public static void postorder(TreeNode node){
        //左右中
        if(node==null){
            return ;
        }
        postorder(node.left);
        postorder(node.right);
        Post.add(node.val);
    }
    // Decodes your encoded data to tree.
    public static TreeNode deserialize(String data) {
        if(data.equals("")){
            return null;
        }
        String[] str=data.split(",");
        List<Integer> Ino=new ArrayList<>();
        List<Integer> Post=new ArrayList<>();
        for(int i=0;i<str.length;i++){
            if(i<str.length/2){
                Ino.add(Integer.parseInt(str[i]));
            }else{
                Post.add(Integer.parseInt(str[i]));
            }
        }
        return build(Ino,Post);
    }
    public static TreeNode build(List<Integer> Ino,List<Integer> Post){
        if(Ino.size()==0){
            return null;
        }
        TreeNode root=new TreeNode(Post.get(Post.size()-1));
        int index=Ino.indexOf(Post.get(Post.size()-1));
        root.left=build(Ino.subList(0,index),Post.subList(0,index));
        root.right=build(Ino.subList(index+1,Ino.size()),Post.subList(index,Post.size()-1));
        return root;
    }
}

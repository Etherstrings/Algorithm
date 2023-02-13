package src.SecondTime.Tree.CengXu;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Etherstrings
 * @create 2022-08-15 22:22 SecondTime.Tree.CengXu - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L116 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/8/15 - the current system date.  22:22 - the current system time.  2022 - the current year.  08 - the current month.  15 - the current day of the month.  22 - the current hour.  22 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  8月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  八月 - full name of a month. Example: January, February, etc
 */
public class L116 {
    public Node connect(Node root) {
        if(root==null){
            return root;
        }
        Queue<Node> Judge=new LinkedList<>();
        Judge.offer(root);
        while(!Judge.isEmpty()){
            int size=Judge.size();
            Node cur=Judge.poll();
            if(cur.left!=null){
                Judge.offer(cur.left);
            }
            if(cur.right!=null){
                Judge.offer(cur.right);
            }

            for(int index=1;index<size;index++){
                Node next=Judge.poll();
                if (next.left != null) Judge.add(next.left);
                if (next.right != null) Judge.add(next.right);

                cur.next = next;
                cur = next;

            }
        }
        return root;
    }
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }
}

package Tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @description:
 * @author： wuboyu
 * @date： 2022-08-23 13:43
 */
public class L116 {
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
    public Node connect(Node root) {
        //层序遍历
        if(root==null){
            return root;
        }
        Queue<Node> Judge=new LinkedList<>();
        Judge.offer(root);
        Node nodePre = null;
        Node now = null;
        while(!Judge.isEmpty()){
            int size=Judge.size();
            for(int i=0;i<size;i++){
                if(i==0){
                    nodePre = Judge.peek(); // 记录一层的头结点
                    Judge.poll();
                    now = nodePre;
                }else {
                    now = Judge.peek();
                    Judge.poll();
                    nodePre.next = now;
                    nodePre = nodePre.next;
                }
                if(now.left!=null){
                    Judge.offer(now.left);
                }
                if(now.right!=null){
                    Judge.offer(now.right);
                }
            }
            nodePre.next = null;
        }
        return root;
    }
}

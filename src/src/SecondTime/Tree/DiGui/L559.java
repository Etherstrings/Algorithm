package src.SecondTime.Tree.DiGui;

import java.util.List;

/**
 * @description:
 * @author： wuboyu
 * @date： 2022-08-16 14:06
 */
public class L559 {

    public int maxDepth(Node root) {
        return dfs(root);
    }

    int dfs(Node root){
        if(root==null){
            return 0;
        }
        int level=0;
        for(Node Chidere:root.children){
            level=Math.max(level,dfs(Chidere));
        }
        return level+1;
    }
    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
}

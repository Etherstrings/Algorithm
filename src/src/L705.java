package src;

import java.util.LinkedList;

/**
 * @description:
 * @author： wuboyu
 * @date： 2022-07-25 11:35
 */
public class L705 {
    //设计哈希集合
    //Category	Difficulty	Likes	Dislikes
    //algorithms	Easy (63.86%)	245	-
    //Tags
    //Companies
    //不使用任何内建的哈希表库设计一个哈希集合（HashSet）。
    //
    //实现 MyHashSet 类：
    //
    //void add(key) 向哈希集合中插入值 key 。
    //bool contains(key) 返回哈希集合中是否存在这个值 key 。
    //void remove(key) 将给定值 key 从哈希集合中删除。如果哈希集合中没有这个值，什么也不做。
    //
    //示例：
    //
    //输入：
    //["MyHashSet", "add", "add", "contains", "contains", "add", "contains", "remove", "contains"]
    //[[], [1], [2], [1], [3], [2], [2], [2], [2]]
    //输出：
    //[null, null, null, true, false, null, true, null, false]
    //
    //解释：
    //MyHashSet myHashSet = new MyHashSet();
    //myHashSet.add(1);      // set = [1]
    //myHashSet.add(2);      // set = [1, 2]
    //myHashSet.contains(1); // 返回 True
    //myHashSet.contains(3); // 返回 False ，（未找到）
    //myHashSet.add(2);      // set = [1, 2]
    //myHashSet.contains(2); // 返回 True
    //myHashSet.remove(2);   // set = [1]
    //myHashSet.contains(2); // 返回 False ，（已移除）
    class MyHashSet {
        LinkedList<Object> my=new LinkedList<>();
        public MyHashSet() {
            my=new LinkedList<>();
        }

        public void add(int key) {
            if(this.my.contains(key)){
                return;
            }else {
                this.my.add(key);
            }
        }

        public void remove(int key) {
            if(this.my.contains(key)){
                this.my.remove(key);
            }else {
                return;
            }
        }

        public boolean contains(int key) {
            return this.my.contains(key);
        }
    }
}

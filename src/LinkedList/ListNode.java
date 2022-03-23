package LinkedList;

/**
 * @author Etherstrings
 * @create 2022-01-19 11:17
 */
public class ListNode {
    //结点的数值---真实数值
    int val;

    //下一个结点
    ListNode next;

    // 节点的构造函数(无参)

    public ListNode() {
    }


    // 节点的构造函数(有一个参数)

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(ListNode next) {
        this.next = next;
    }
// 节点的构造函数(有两个参数)

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

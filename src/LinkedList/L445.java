package LinkedList;

public class L445 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        l1=reverseList(l1);
        l2=reverseList(l2);
        ListNode l3=addTwo(l1,l2,0);
        return reverseList(l3);
    }

    public ListNode reverseList(ListNode head) {

        ListNode Pre=null;
        ListNode Now=head;
        ListNode Temp=null;
        while(Now!=null){
            //保存下个结点
            Temp=Now.next;
            //前边节点的数值 赋给Now.next
            Now.next=Pre;


            //移动前边的指针
            Pre=Now;
            //移动现在的指针
            Now=Temp;
        }
        return Pre;
    }
    private ListNode addTwo(ListNode l1, ListNode l2, int carry) {
        if (l1 == null && l2 == null) // 递归边界：l1 和 l2 都是空节点
            return carry != 0 ? new ListNode(carry) : null; // 如果进位了，就额外创建一个节点
        if (l1 == null) { // 如果 l1 是空的，那么此时 l2 一定不是空节点
            l1 = l2;
            l2 = null; // 交换 l1 与 l2，保证 l1 非空，从而简化代码
        }
        carry += l1.val + (l2 != null ? l2.val : 0); // 节点值和进位加在一起
        l1.val = carry % 10; // 每个节点保存一个数位
        l1.next = addTwo(l1.next, (l2 != null ? l2.next : null), carry / 10); // 进位
        return l1;
    }


}

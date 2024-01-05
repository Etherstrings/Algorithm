package LinkedList;

/**
 * @author wuboyu <wuboyu@kuaishou.com>
 * Created on 2023-11-29
 */
public class L2816 {

    public ListNode doubleIt(ListNode head) {
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        String num = "";
        //不可以用字符串转换，会超过int的范围
        while (head != null) {
            num += head.val;
            head = head.next;
        }
        num = String.valueOf(Integer.parseInt(num) * 2);
        for (int i = 0; i < num.length(); i++) {
            cur.next = new ListNode(num.charAt(i) - '0');
            cur = cur.next;
        }
        return dummy.next;
    }
}

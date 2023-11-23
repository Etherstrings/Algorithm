package LinkedList;

/**
 * @author Justice_wby
 * @create 2023-01-30 0:02
 */
public class L1669 {
    //1669. 合并两个链表
    //给你两个链表 list1 和 list2 ，它们包含的元素分别为 n 个和 m 个。
    //
    //请你将 list1 中下标从 a 到 b 的全部节点都删除，并将list2 接在被删除节点的位置。
    //
    //下图中蓝色边和节点展示了操作后的结果：
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {

        ListNode Now1=list1;
        int index=0;
        while(Now1!=null){
            index++;
            if(index==a){
                break;
            }else {
                Now1=Now1.next;
            }
        }

        ListNode Now2=list1;
        index=0;
        ListNode Nodeb=new ListNode(-1);
        while(Now2!=null){
            index++;
            if(index==b){
                Nodeb=Now2.next.next;
                Now2.next.next=null;
                break;
            }else {
                Now2=Now2.next;
            }
        }
        Now1.next=list2;
        ListNode Now=list2;
        ListNode P=Now1;
        while(Now!=null){
            P=P.next;
            Now=Now.next;
        }
        P.next=Nodeb;
        return list1;
    }

    //2023.10.12 16:54 Second Round
    public ListNode mergeInBetweenRoundTwo(ListNode list1, int a, int b, ListNode list2){
        ListNode Now=list1;
        ListNode Dum=new ListNode(-1);
        Dum.next=list1;
        ListNode Pre=Dum;
        ListNode index_a= Now;
        ListNode index_b= Now;
        while(Now!=null){
            if(Now.val==a){
                index_a=Pre;
            }
            if(Now.val==b){
                index_b=Now.next;
            }
            Pre=Now;
            Now=Now.next;
        }
        index_a.next=list2;
        ListNode Now2=list2;
        while(Now2!=null){
            Now2=Now2.next;
        }
        Now2.next=index_b;
        return Dum.next;
    }
}

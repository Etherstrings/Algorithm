package LinkedList;

import java.util.List;

/**
 * @author Etherstrings
 * @create 2022-01-21 14:09
 */
public class L707ListWays {
    /**
     * 707. 设计链表
     * 设计链表的实现。您可以选择使用单链表或双链表。单链表中的节点应该具有两个属性：val 和 next。val 是当前节点的值，next 是指向下一个节点的指针/引用。如果要使用双向链表，则还需要一个属性 prev 以指示链表中的上一个节点。假设链表中的所有节点都是 0-index 的。
     *
     * 在链表类中实现这些功能：
     *
     * get(index)：获取链表中第 index 个节点的值。如果索引无效，则返回-1。
     * addAtHead(val)：在链表的第一个元素之前添加一个值为 val 的节点。插入后，新节点将成为链表的第一个节点。
     * addAtTail(val)：将值为 val 的节点追加到链表的最后一个元素。
     * addAtIndex(index,val)：在链表中的第 index 个节点之前添加值为 val  的节点。如果 index 等于链表的长度，则该节点将附加到链表的末尾。如果 index 大于链表长度，则不会插入节点。如果index小于0，则在头部插入节点。
     * deleteAtIndex(index)：如果索引 index 有效，则删除链表中的第 index 个节点。
     *
     */
}

class MyLinkedList {
    //size  元素个数
    int size;
    //虚拟头结点
    ListNode head;


    //初始化链表
    public MyLinkedList() {
        size=0;
        head=new ListNode(0);
    }

    public int get(int index) {
        if(index<0||index>=size){
            return -1;
        }
        //虚拟头结点
        ListNode Now=head;
        //0进去
            //首先指向虚拟结点head head.next为初始节点
                //循环结束-----指向当前0结点

        //index-1 进去
            //指向index-1
                //循环结束-----指向index
        for(int i=0;i<=index;i++){
            Now=Now.next;
        }
        return Now.val;
    }

    public void addAtHead(int val) {

        addAtIndex(0,val);

    }

    public void addAtTail(int val) {
        addAtIndex(size,val);
    }

    // 在第 index 个节点之前插入一个新节点，例如index为0，那么新插入的节点为链表的新头节点。
    // 如果 index 等于链表的长度，则说明是新插入的节点为链表的尾结点
    // 如果 index 大于链表的长度，则返回空
    public void addAtIndex(int index, int val) {
        if(index>size){
            return;
        }
        if(index<0){
            index=0;
        }
        size++;
        //找到插入结点的前驱节点
        ListNode Pre=head;
        for(int i=0;i<index;i++){
            Pre=Pre.next;
        }
        ListNode newnode=new ListNode(val);
        newnode.next=Pre.next;
        Pre.next=newnode;
    }

    public void deleteAtIndex(int index) {
        if(index<0||index>=size){
            return;
        }

        size--;
        ListNode Pre=head;
        for(int i=0;i<index;i++){
            Pre= Pre.next;
        }
        Pre.next= Pre.next.next;
    }
}

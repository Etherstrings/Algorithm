package StackAndQueue;

import java.util.Stack;

/**
 * @author Etherstrings
 * @create 2022-02-25 23:14 StackAndQueue - the name of the target package where the new class or interface will be created.  ideaworkplace - the name of the current project.  ${FILE_NAME} - the name of the PHP file that will be created.  L232 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/2/25 - the current system date.  23:14 - the current system time.  2022 - the current year.  02 - the current month.  25 - the current day of the month.  23 - the current hour.  14 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  二月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  二月 - full name of a month. Example: January, February, etc
 */
public class L232 {
    //232. 用栈实现队列
    //请你仅使用两个栈实现先入先出队列。队列应当支持一般队列支持的所有操作（push、pop、peek、empty）：
    //
    //实现 MyQueue 类：
    //
    //void push(int x) 将元素 x 推到队列的末尾
    //int pop() 从队列的开头移除并返回元素
    //int peek() 返回队列开头的元素
    //boolean empty() 如果队列为空，返回 true ；否则，返回 false
    //说明：
    //
    //你 只能 使用标准的栈操作 —— 也就是只有 push to top, peek/pop from top, size, 和 is empty 操作是合法的。
    //你所使用的语言也许不支持栈。你可以使用 list 或者 deque（双端队列）来模拟一个栈，只要是标准的栈操作即可。

    class MyQueue {
        //定义专门用来
        //存的栈
        //出的栈
        Stack<Integer> stackIn;
        Stack<Integer> stackOut;
    public MyQueue() {
        stackIn = new Stack<>(); // 负责进栈
        stackOut = new Stack<>(); // 负责出栈
    }

    /** Push element x to the back of queue. */
    //queue的入列

    public void push(int x) {
        stackIn.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */

    //queue的出列

    public int pop() {
        //出先入的
        //就是出1
        //变换后的 4 3 2 1 直接调用出栈
        dumpstackIn();
        return stackOut.pop();
    }

    /** Get the front element. */
    //queue的查看末尾
    public int peek() {
        //看队列第一个
        //也就是看1
        //变换后的4 3 2 1 左边是底
        //直接调用OUT的peek
        dumpstackIn();
        return stackOut.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stackIn.isEmpty() && stackOut.isEmpty();
    }

    // 如果stackOut为空，那么将stackIn中的元素全部放到stackOut中

        //如果专门用来出栈的栈 为空
        //尾 1 2 3 4 头  入
        //头 4 3 2 1 尾  出
    private void dumpstackIn(){
        if (!stackOut.isEmpty()) return;
        while (!stackIn.isEmpty()){
            //出一个 存一个
            //顺序正好调头
            stackOut.push(stackIn.pop());
        }
    }
}
}

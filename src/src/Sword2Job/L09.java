package src.Sword2Job;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Etherstrings
 * @create 2022-03-08 14:20 Sword2Job - the name of the target package where the new class or interface will be created.  ideaworkplace - the name of the current project.  ${FILE_NAME} - the name of the PHP file that will be created.  L09 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/3/8 - the current system date.  14:20 - the current system time.  2022 - the current year.  03 - the current month.  08 - the current day of the month.  14 - the current hour.  20 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  三月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  三月 - full name of a month. Example: January, February, etc
 */
public class L09 {
    //剑指 Offer 09. 用两个栈实现队列
    //用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead 操作返回 -1 )
    //
    //
    //
    //示例 1：
    //
    //输入：
    //["CQueue","appendTail","deleteHead","deleteHead"]
    //[[],[3],[],[]]
    //输出：[null,null,3,-1]
    //示例 2：
    //
    //输入：
    //["CQueue","deleteHead","appendTail","appendTail","deleteHead","deleteHead"]
    //[[],[],[5],[2],[],[]]
    //输出：[null,-1,null,null,5,2]

    class CQueue {

        Deque<Integer> stack1;
        Deque<Integer> stack2;

        public CQueue() {
            stack1 = new LinkedList<Integer>();
            stack2 = new LinkedList<Integer>();

        }

        public void appendTail(int value) {
            stack1.push(value);
        }

        public int deleteHead() {
            if(stack2.isEmpty()){
                while(!stack1.isEmpty()){
                    stack2.push(stack1.pop());
                }
            }

            if(stack2.isEmpty()){
                return -1;
            }else{
                int deletenum=stack2.pop();
                return deletenum;
            }
        }
    }
}

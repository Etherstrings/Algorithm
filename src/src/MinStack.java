package src;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * @description:
 * @author： wuboyu
 * @date： 2022-08-18 10:49
 */
public class MinStack {
    Stack<Integer> stack;
    ArrayList<Integer> list;
    public MinStack() {
        this.stack=new Stack<>();
        this.list=new ArrayList<>();
    }
    public MinStack(int num){
        stack.push(num);
        list.add(num);
    }

    public void push(int val) {
        stack.push(val);
        list.add(val);
    }

    public void pop() {
        stack.pop();
        list.remove(list.size()-1);
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        List<Integer> clone =(ArrayList<Integer>) list.clone();
        if(clone!=null){

            Collections.sort(clone);

        }
        return clone.get(0);


    }
}

package src.StackAndQueue;

import java.util.Stack;

/**
 * @author Etherstrings
 * @create 2022-03-03 11:15 StackAndQueue - the name of the target package where the new class or interface will be created.  ideaworkplace - the name of the current project.  ${FILE_NAME} - the name of the PHP file that will be created.  L150 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/3/3 - the current system date.  11:15 - the current system time.  2022 - the current year.  03 - the current month.  03 - the current day of the month.  11 - the current hour.  15 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  三月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  三月 - full name of a month. Example: January, February, etc
 */
public class L150 {
    //150. 逆波兰表达式求值
    //根据 逆波兰表示法，求表达式的值。
    //
    //有效的算符包括 +、-、*、/ 。每个运算对象可以是整数，也可以是另一个逆波兰表达式。
    //
    //注意 两个整数之间的除法只保留整数部分。
    //
    //可以保证给定的逆波兰表达式总是有效的。换句话说，表达式总会得出有效数值且不存在除数为 0 的情况。

    //示例 1：
    //
    //输入：tokens = ["2","1","+","3","*"]
    //输出：9
    //解释：该算式转化为常见的中缀算术表达式为：((2 + 1) * 3) = 9
    //示例 2：
    //
    //输入：tokens = ["4","13","5","/","+"]
    //输出：6
    //解释：该算式转化为常见的中缀算术表达式为：(4 + (13 / 5)) = 6
    //示例 3：
    //
    //输入：tokens = ["10","6","9","3","+","-11","*","/","*","17","+","5","+"]
    //输出：22
    //解释：该算式转化为常见的中缀算术表达式为：
    //  ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
    //= ((10 * (6 / (12 * -11))) + 17) + 5
    //= ((10 * (6 / -132)) + 17) + 5
    //= ((10 * 0) + 17) + 5
    //= (0 + 17) + 5
    //= 17 + 5
    //= 22
    // 
    //
    //提示：
    //
    //1 <= tokens.length <= 104
    //tokens[i] 是一个算符（"+"、"-"、"*" 或 "/"），或是在范围 [-200, 200] 内的一个整数
    // 
    //
    //逆波兰表达式：
    //
    //逆波兰表达式是一种后缀表达式，所谓后缀就是指算符写在后面。
    //
    //平常使用的算式则是一种中缀表达式，如 ( 1 + 2 ) * ( 3 + 4 ) 。
    //该算式的逆波兰表达式写法为 ( ( 1 2 + ) ( 3 4 + ) * ) 。
    //逆波兰表达式主要有以下两个优点：
    //
    //去掉括号后表达式无歧义，上式即便写成 1 2 + 3 4 + * 也可以依据次序计算出正确结果。
    //适合用栈操作运算：遇到数字则入栈；遇到算符则取出栈顶两个数字进行计算，并将结果压入栈中
    //
    public int evalRPN1(String[] tokens) {
        Stack<Integer> judgement=new Stack<>();
        for(int i=0;i<tokens.length;i++){
            if("+".equals(tokens[i])){
                int a=judgement.pop();
                int b=judgement.pop();
                judgement.push(a+b);

            }else if("-".equals(tokens[i])){
                int a=judgement.pop();
                int b=judgement.pop();
                judgement.push(b-a);

            }else if("*".equals(tokens[i])){
             int a=judgement.pop();
             int b=judgement.pop();
             judgement.push(a*b);

            }else if("/".equals(tokens[i])){
                int a=judgement.pop();
                int b=judgement.pop();
                judgement.push(b/a);
            }else{
                judgement.push(Integer.valueOf(tokens[i]));
            }
        }
        return judgement.pop();

    }

    public int evalRPN(String[] tokens){
        Stack<Integer> Judge=new Stack<>();
        for(String temp:tokens){
            if(temp.equals("+")){
                //取前边两个数计算
                int a=Judge.pop();
                int b=Judge.pop();
                Judge.push(a+b);
            }else if(temp.equals("-")){
                Judge.push(-Judge.pop() + Judge.pop());
            }else if(temp.equals("*")){
                Judge.push(Judge.pop()*Judge.pop());
            }else if(temp.equals("/")){
                //取前边两个数计算
                int a=Judge.pop();
                int b=Judge.pop();
                Judge.push(b/a);
            }else {
                Judge.push(Integer.valueOf(temp));
            }
        }
        return Judge.pop();
    }
}

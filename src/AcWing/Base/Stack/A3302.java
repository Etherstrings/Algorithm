package AcWing.Base.Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author Etherstrings
 * @create 2023-03-30 21:00 AcWing.Base.Stack - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  A3302 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2023/3/30 - the current system date.  21:00 - the current system time.  2023 - the current year.  03 - the current month.  30 - the current day of the month.  21 - the current hour.  00 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  3月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  三月 - full name of a month. Example: January, February, etc
 */
public class A3302 {
    //中缀表达式+栈实现+四则运算
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> num = new Stack<>();
        Stack<Character> op = new Stack<>();
        String s = br.readLine();
        int len = s.length();
        Map<Character, Integer> map = new HashMap<>();
        map.put('+',1);
        map.put('-',1);
        map.put('*',2);
        map.put('/',2);
        for (int i = 0; i < len; i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                int x = 0, j = i;
                while (j < len && Character.isDigit(s.charAt(j))) x = x * 10 + s.charAt(j++) - '0';
                num.push(x);
                i = j - 1;
            }else if (s.charAt(i) == '('){
                op.push(s.charAt(i));
            }else if (s.charAt(i) == ')'){
                while (op.peek() != '(') eval(num, op);
                op.pop();
            }else if (op.isEmpty()){
                op.push(s.charAt(i));
            }else {
                //在这里多一个判断，因为优先级中没有存储左括号的优先级，故map会产生空指针异常
                while (!op.isEmpty() && op.peek() != '(' && map.get(op.peek()) >= map.get(s.charAt(i))) eval(num, op);
                op.push(s.charAt(i));
            }
        }
        while (op.size() > 0) eval(num, op);
        System.out.print(num.peek());
    }
    public static void eval (Stack<Integer> num, Stack<Character> op){
        int num1 = num.pop();
        int num2 = num.pop();
        char x = op.pop();
        if(x == '*') num.push(num2 * num1);
        else if (x == '/') num.push(num2 / num1);
        else if (x == '+') num.push(num2 + num1);
        else if (x == '-') num.push(num2 - num1);
    }

}

package StringExer;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Stack;

public class L316 {
    //给你一个字符串 s ，请你去除字符串中重复的字母，使得每个字母只出现一次。需保证 返回结果的字典序最小（要求不能打乱其他字符的相对位置）。
    //
    //
    //
    //示例 1：
    //
    //输入：s = "bcabc"
    //输出："abc"
    //示例 2：
    //
    //输入：s = "cbacdcbc"
    //输出："acdb"
    public String removeDuplicateLetters(String s) {
        //先判断有哪些字母----取出来只出现一次
        //单调栈+HashMap判断
        Map<Character,Integer> Judge=new HashMap<>();
        for(Character a:s.toCharArray()){
            if(Judge.containsKey(a)){
                Judge.put(a,Judge.get(a)+1);
            }else {
                Judge.put(a,1);
            }
        }

        Stack<Character> stk=new Stack<>();
        boolean[] inStack = new boolean[256];
        for(Character c:s.toCharArray()){
            //每遍历到一个C---都可以将存在次数减1
            Judge.put(c,Judge.get(c)-1);
            if(inStack[c]){
                //如果当前栈已经有这个元素了
                continue;
            }

            while(!stk.isEmpty()&&stk.peek()>c){
                //如果栈顶不是空的
                //如果当前栈顶的c 大于 a
                if(Judge.get(stk.peek())==0){
                    //如果打算poop的这个元素 以后没了
                    //那就不能pop
                    break;
                }
                Character temp=stk.pop();
                //这个是不是已经存在在里面？
                inStack[temp]=false;
            }
            stk.push(c);
            inStack[c]=true;

        }



        StringBuilder sb=new StringBuilder();
        while(!stk.isEmpty()){
            sb.append(stk.pop());
        }
        return sb.reverse().toString();
    }

    public String removeDuplicateLetters(String s){
        Stack<Character> stk=new Stack<>();
        //用什么来判断是不是已经存在
        //用什么判断出现了几次？-----int[256] Or Hashmap
        LinkedList<Character> Judge=new LinkedList<>();
        int[] howmany=new int[256];
        boolean[] init=new boolean[256];
        for(Character a:s.toCharArray()){
            howmany[a]+=1;
        }
        //可以判断哪些是剩几个的了
        for(Character a:s.toCharArray()){
            howmany[a]-=1;
            if(init[a]){
                //已经有这个元素了----直接下一个
                break;
            }
            //没有当前这个元素---那考滤该怎么进
            while(!Judge.isEmpty()&&Judge.getLast()>a){
                if(howmany[Judge.getLast()]==0){
                    //当前尾元素是最后一个
                    //不能弹
                    break;
                }
                Character temp=Judge.getLast();
                Judge.removeLast();
                init[temp]=false;
            }
            Judge.add(a);
            init[a]=true;
        }
        String ans="";
        while(!Judge.isEmpty()){
            ans+=Judge.getFirst();
            Judge.removeFirst();
        }
        return ans;
    }
}

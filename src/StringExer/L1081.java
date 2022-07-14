package StringExer;

import javax.print.DocFlavor;
import java.util.Stack;

public class L1081 {

    public String smallestSubsequence(String s) {
        int[] howmany=new int[26];
        boolean[] init=new boolean[26];
        for(Character a:s.toCharArray()){
            howmany[a-'a']+=1;
        }
        Stack<Character> stk=new Stack<>();



        for(Character a:s.toCharArray()){
            howmany[a-'a']-=1;


            if(init[a-'a']){
                break;
            }

            while(!stk.isEmpty()&&stk.peek()>a){
                if(howmany[stk.peek()-'a']==0){
                    break;
                }
                Character temp=stk.peek();
                stk.pop();
                init[temp-'a']=false;
            }
            stk.push(a);
            init[a-'a']=true;


        }
        StringBuilder sb=new StringBuilder();
        while(!stk.isEmpty()){
            sb.append(stk.pop());
        }
        return sb.reverse().toString();
    }
}

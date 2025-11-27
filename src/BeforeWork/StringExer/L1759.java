package StringExer;

import java.util.ArrayList;
import java.util.List;

public class L1759 {
    public static int countHomogenous(String s) {
        final int MOD = 1000000007;
        List<String> list=new ArrayList<>();
        if(s.length()==1){
            return 1;
        }
        char temp=s.charAt(0);
        String t="";
        t=t+temp;
        for(int i=1;i<s.length();i++){
            char now=s.charAt(i);
            if(temp==now){
                t=t+temp;
                if(i==s.length()-1){
                    list.add(t);
                    break;
                }
            }else {
                //此时不相同
                list.add(t);
                t=now+"";
                temp=now;
                if(i==s.length()-1){
                    list.add(t);
                }
            }
        }
        long ans=0;
        for(String now:list){
            long l=now.length();
            ans+=(l*(l+1))/2;
        }
        return (int) (ans % MOD);
    }
}

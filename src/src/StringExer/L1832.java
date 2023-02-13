package src.StringExer;

import java.util.Arrays;

/**
 * @author Etherstrings
 * @create 2022-12-15 19:56
 */
public class L1832 {
    public boolean checkIfPangram(String sentence) {
        boolean[] b=new boolean[26];
        Arrays.fill(b,false);
        for(char n:sentence.toCharArray()){
            if(b[n-'a']==true){
                continue;
            }else {
                b[n-'a']=true;
            }
        }
        boolean flag=true;
        for(boolean f:b){
            if(f==false){
                flag=false;
                break;
            }
        }
        return flag;
    }
}

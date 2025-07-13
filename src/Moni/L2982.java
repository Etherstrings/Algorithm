package Moni;
import java.util.*;
/**
 * @author wuboyu <wuboyu@kuaishou.com>
 * Created on 2024-05-30
 */
public class L2982 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        System.out.println(maximumLength(s));
    }
    public static int maximumLength(String s) {
        //length最少大于等于3
        Set<String> set = new HashSet<>();
        Map<Character,Integer> map = new HashMap<>();
        String now = s.charAt(0)+"";
        map.put(s.charAt(0),1);
        for( int i=1;i<s.length();i++){
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
            if(s.charAt(i)==s.charAt(i-1)){
                now+=s.charAt(i);
                set.add(now);
                continue;
            }
            now = s.charAt(i)+"";
        }
        if(set.size()==0){
            //判断map里是不是有大于等于3的
            for(Map.Entry<Character,Integer> entry:map.entrySet()){
                if(entry.getValue()>=3){
                    return 1;
                }
            }
        }
        //从长往小找
        List<String> list = new ArrayList<>(set);
        list.sort((a,b)->b.length()-a.length());
        for(String str:list){
            int count = 0;
            for(int i=0;i<s.length()-str.length()+1;i++){
                if(s.substring(i,i+str.length()).equals(str)){
                    count++;
                    if(count>=3){
                        return str.length();
                    }
                }
            }
        }
        for(Map.Entry<Character,Integer> entry:map.entrySet()){
            if(entry.getValue()>=3){
                return 1;
            }
        }
        return -1;
    }
}

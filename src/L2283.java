import java.util.HashMap;

public class L2283 {
    public boolean digitCount(String num) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(char now:num.toCharArray()){
            Integer n=Integer.parseInt(now+"");
            if(map.containsKey(n)){
                map.put(n,map.get(n)+1);
            }else {
                map.put(n,1);
            }
        }
        boolean flag=true;
        for(int i=0;i<num.length();i++){
            int now=i;
            if(!map.containsKey(now)){
                if(Integer.parseInt(num.charAt(i)+"")==0){
                    continue;
                }
                flag=false;
                break;
            }
            if(Integer.parseInt(num.charAt(now)+"")!=map.get(now)){
                flag=false;
                break;
            }
        }
        return flag;
    }
}

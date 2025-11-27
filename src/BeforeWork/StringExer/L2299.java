package StringExer;

import java.util.HashMap;

/**
 * @author Justice_wby
 * @create 2023-01-19 16:51
 */
public class L2299 {
    //2299. 强密码检验器 II
    //如果一个密码满足以下所有条件，我们称它是一个 强 密码：
    //
    //它有至少 8 个字符。
    //至少包含 一个小写英文 字母。
    //至少包含 一个大写英文 字母。
    //至少包含 一个数字 。
    //至少包含 一个特殊字符 。特殊字符为："!@#$%^&*()-+" 中的一个。
    //它 不 包含 2 个连续相同的字符（比方说 "aab" 不符合该条件，但是 "aba" 符合该条件）。
    //给你一个字符串 password ，如果它是一个 强 密码，返回 true，否则返回 false
    public boolean strongPasswordCheckerII(String password) {
        boolean flag=true;
        if(password.length()<8){
            return false;
        }
        HashMap<String,Integer> map=new HashMap<>();
        map.put("lowerletter",0);
        map.put("Upperletter",0);
        map.put("Digit",0);
        map.put("Special",0);
        String temp="!@#$%^&*()-+";
        for(char now:password.toCharArray()){
            if(Character.isDigit(now)){
                map.put("Digit",map.get("Digit")+1);
                continue;
            }
            if(Character.isLowerCase(now)){
                map.put("lowerletter",map.get("lowerletter")+1);
                continue;
            }
            if(Character.isUpperCase(now)){
                map.put("Upperletter",map.get("Upperletter")+1);
                continue;
            }
            for(char t:temp.toCharArray()) {
                if (now == t) {
                    map.put("Special", map.get("Special") + 1);
                    break;
                }
            }
        }
        if(map.get("lowerletter")<1){
            return false;
        }
        if(map.get("Upperletter")<1){
            return false;
        }
        if(map.get("Digit")<1){
            return false;
        }
        if(map.get("Special")<1){
            return false;
        }
        for(int i=1;i<password.length();i++){
            char now=password.charAt(i);
            char before=password.charAt(i-1);
            if(now==before){
                flag=false;
                break;
            }
        }
        return flag;
    }
}

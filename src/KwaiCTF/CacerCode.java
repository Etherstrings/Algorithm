package KwaiCTF;

import java.util.Scanner;

/**
 * @author wuboyu <wuboyu@kuaishou.com>
 * Created on 2024-08-21
 */
public class CacerCode {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String base = sc.nextLine();
        String code = sc.nextLine();
        String ans = "";
        char[] charArray = base.toCharArray();
        for(int i=0;i<charArray.length;i++){
            if(Character.isUpperCase(charArray[i])){
                ans += Character.toUpperCase(code.charAt(i));
                continue;
            }
            ans += code.charAt(i);
        }
        System.out.println(ans);
    }
}

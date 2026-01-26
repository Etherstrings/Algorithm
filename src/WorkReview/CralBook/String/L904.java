package WorkReview.CralBook.String;

import java.util.HashSet;
import java.util.Set;

/**
 * @author wuboyu <wuboyu@kuaishou.com>
 * Created on 2026-01-07
 */
public class L904 {
    public static void main(String[] args) {
        //fruits =
        //[1,2,3,2,2]
        System.out.println(new L904().totalFruit(new int[]{3,3,3,1,2,1,1,2,3,3,4}));
    }
    public static int totalFruit(int[] fruits) {
        if(fruits.length<=2){
            return fruits.length;
        }
        Set<Integer> set=new HashSet<>();
        int ans=0;
        int index=0;
        int len=0;
        while(index<fruits.length){
            if(set.size()<2){
                set.add(fruits[index]);
                len++;
                ans=Math.max(len,ans);
                index++;
                continue;
            }
            if(set.size()==2){
                if(!set.contains(fruits[index])){
                    ans=Math.max(len,ans);
                    len=1;
                    set.clear();
                    //当前我是4
                    //现在我要返回6的位置
                    int tar=fruits[index-1];
                    index=index-1;
                    while(index>=0&&tar==fruits[index]){
                        index--;
                    }
                    index++;
                    set.add(fruits[index]);
                    index++;
                }else{
                    len++;
                    ans=Math.max(len,ans);
                    index++;
                }

                continue;
            }
        }
        return ans;
    }
}

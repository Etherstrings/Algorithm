package TanXin;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class L1753 {

    //1753. 移除石子的最大得分
    public int maximumScore(int a, int b, int c) {
        int ans=0;
        boolean flag=true;
        List<Integer> temp=new ArrayList<>();
        temp.add(a);
        temp.add(b);
        temp.add(c);
        while(flag){
            //每次取前两个
            a=temp.get(0);
            b=temp.get(1);
            c=temp.get(2);
            if(a==0&&b==0){
                flag=false;
                break;
            }
            if(a==0&&c==0){
                flag=false;
                break;
            }
            if(b==0&&c==0){
                flag=false;
                break;
            }
            if(a==0&&b==0&&c==0){
                flag=false;
                break;
            }
            //排序 第一个第一个减去一个
            Collections.sort(temp);
            //减去最大的
            temp.set(2,temp.get(2)-1);
            temp.set(1,temp.get(1)-1);
            ans++;
        }
        return ans;
    }
}

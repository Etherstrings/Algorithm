package Moni;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wuboyu <wuboyu@kuaishou.com>
 * Created on 2023-10-12
 */
public class L291 {
    public List<Integer> sequentialDigits(int low, int high) {
        ArrayList list = new ArrayList(); //存储
        String number = "123456789";
        int low_l = String.valueOf(low).length();  //长度，也是初始窗口大小
        int high_l = String.valueOf(high).length(); //最终窗口大小
        //System.out.println(number.substring(0,3));
        for(int i=low_l;i<=high_l;i++)  //大循环每次窗口长度+1
        {
            for(int j=0;j+i<10;j++)     //找到固定窗口长度下的顺序数，不断移动窗口
            {
                String fin = number.substring(j,j+i);  //截取字符串，转换成int形式
                int a2=Integer.valueOf(fin);
                if(a2<=high&&a2>=low)   //符合条件加入list
                {
                    list.add(a2);
                    continue;
                }

            }
        }

        return list;
    }
}

package TwoPoint;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * @author Etherstrings
 * @create 2022-01-10 11:24 TwoPoint - the name of the target package where the new class or interface will be created.  project01 - the name of the current project.  ${FILE_NAME} - the name of the PHP file that will be created.  L904Fruits - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/1/10 - the current system date.  11:24 - the current system time.  2022 - the current year.  01 - the current month.  10 - the current day of the month.  11 - the current hour.  24 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  一月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  一月 - full name of a month. Example: January, February, etc
 */
public class L904Fruits {


    /**
     *
     * 904. 水果成篮
     *
     * 你正在探访一家农场，农场从左到右种植了一排果树。这些树用一个整数数组 fruits 表示，其中 fruits[i] 是第 i 棵树上的水果 种类 。
     *
     * 你想要尽可能多地收集水果。然而，农场的主人设定了一些严格的规矩，你必须按照要求采摘水果：
     *
     * 你只有 两个 篮子，并且每个篮子只能装 单一类型 的水果。每个篮子能够装的水果总量没有限制。
     * 你可以选择任意一棵树开始采摘，你必须从 每棵 树（包括开始采摘的树）上 恰好摘一个水果 。采摘的水果应当符合篮子中的水果类型。每采摘一次，你将会向右移动到下一棵树，并继续采摘。
     * 一旦你走到某棵树前，但水果不符合篮子的水果类型，那么就必须停止采摘。
     * 给你一个整数数组 fruits ，返回你可以收集的水果的 最大 数目
     */

    public int totalFruit(int[] fruits) {
    if(fruits.length==0){
        return 0;
    }
    if(fruits.length==1){
            return 1;
        }

        if(fruits.length==2){
            return 2;
        }
        //从哪颗树开始摘果子
        ArrayList<Object> answer = new ArrayList<>();

        for(int i=0;i<fruits.length;i++){


            int slow=i;
            int sum=0;

            for(int fast=i;fast<fruits.length;fast++){
                sum+=1;
                ArrayList<Integer> integers = new ArrayList<>();
                for(int j=slow;j<fast;j++){
                    integers.add(fruits[j]);
                }

                if(  integers.contains(fruits[fast])
                        ){}
                        else{
                    answer.add(sum-1);
                    break;


                }
            }

        }
        Comparator com=new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                Integer t1=(Integer)o1;
                Integer t2=(Integer)o2;

                return -t1.compareTo(t2);
            }
        };
        answer.sort(com);
        return (int)answer.get(0);
    }
}

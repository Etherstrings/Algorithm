package TanXin;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

/**
 * @author Etherstrings
 * @create 2022-07-20 21:32 TanXin - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L406 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/7/20 - the current system date.  21:32 - the current system time.  2022 - the current year.  07 - the current month.  20 - the current day of the month.  21 - the current hour.  32 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  7月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  七月 - full name of a month. Example: January, February, etc
 */
public class L406 {
    //406. 根据身高重建队列
    //假设有打乱顺序的一群人站成一个队列，数组 people 表示队列中一些人的属性（不一定按顺序）。每个 people[i] = [hi, ki] 表示第 i 个人的身高为 hi ，前面 正好 有 ki 个身高大于或等于 hi 的人。
    //
    //请你重新构造并返回输入数组 people 所表示的队列。返回的队列应该格式化为数组 queue ，其中 queue[j] = [hj, kj] 是队列中第 j 个人的属性（queue[0] 是排在队列前面的人）。
    //
    //
    //
    //示例 1：
    //
    //输入：people = [[7,0],[4,4],[7,1],[5,0],[6,1],[5,2]]
    //输出：[[5,0],[7,0],[5,2],[6,1],[4,4],[7,1]]
    //解释：
    //编号为 0 的人身高为 5 ，没有身高更高或者相同的人排在他前面。
    //编号为 1 的人身高为 7 ，没有身高更高或者相同的人排在他前面。
    //编号为 2 的人身高为 5 ，有 2 个身高更高或者相同的人排在他前面，即编号为 0 和 1 的人。
    //编号为 3 的人身高为 6 ，有 1 个身高更高或者相同的人排在他前面，即编号为 1 的人。
    //编号为 4 的人身高为 4 ，有 4 个身高更高或者相同的人排在他前面，即编号为 0、1、2、3 的人。
    //编号为 5 的人身高为 7 ，有 1 个身高更高或者相同的人排在他前面，即编号为 1 的人。
    //因此 [[5,0],[7,0],[5,2],[6,1],[4,4],[7,1]] 是重新构造后的队列。
    //示例 2：
    //
    //输入：people = [[6,0],[5,0],[4,0],[3,2],[2,2],[1,4]]
    //输出：[[4,0],[5,0],[2,2],[3,2],[1,4],[6,0]]
    public int[][] reconstructQueue(int[][] people) {
        //思路
        //1.首先按照身高排列----如果身高一致，那么k的小的放前面
        //2.直接按照k的位置插入
        Comparator<int[]> com=new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0]==o2[0]){
                    return o1[1]-o2[1];
                }
                return o2[0]-o1[0];
            }
        };
        Arrays.sort(people,com);
        //排好相应的位置
        LinkedList<int[]> que=new LinkedList<>();
        for(int[] person:people){
            //将person插入到链表的所在位置
            que.add(person[1],person);
        }

        return que.toArray(new int[people.length][]);

    }
}

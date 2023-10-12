package Moni;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author wuboyu <wuboyu@kuaishou.com>
 * Created on 2023-10-11
 */
public class L2512 {
    //给你两个字符串数组 positive_feedback 和 negative_feedback ，分别包含表示正面的和负面的词汇。不会 有单词同时是正面的和负面的。
    //
    //一开始，每位学生分数为 0 。每个正面的单词会给学生的分数 加 3 分，每个负面的词会给学生的分数 减 1 分。
    //
    //给你 n 个学生的评语，用一个下标从 0 开始的字符串数组 report 和一个下标从 0 开始的整数数组 student_id 表示，其中 student_id[i] 表示这名学生的 ID ，这名学生的评语是 report[i] 。每名学生的 ID 互不相同。
    //
    //给你一个整数 k ，请你返回按照得分 从高到低 最顶尖的 k 名学生。如果有多名学生分数相同，ID 越小排名越前。
    //
    //示例 1：
    //
    //输入：positive_feedback = ["smart","brilliant","studious"], negative_feedback = ["not"], report = ["this student is studious","the student is smart"], student_id = [1,2], k = 2
    //输出：[1,2]
    //解释：
    //两名学生都有 1 个正面词汇，都得到 3 分，学生 1 的 ID 更小所以排名更前。
    //示例 2：
    //
    //输入：positive_feedback = ["smart","brilliant","studious"], negative_feedback = ["not"], report = ["this student is not studious","the student is smart"], student_id = [1,2], k = 2
    //输出：[2,1]
    //解释： - ID 为 1 的学生有 1 个正面词汇和 1 个负面词汇，所以得分为 3-1=2 分。 - ID 为 2 的学生有 1 个正面词汇，得分为 3 分。 学生 2 分数更高，所以返回 [2,1] 。


    //> 2023/10/11 19:45:05
    //解答成功:
    //	执行耗时:68 ms,击败了44.44% 的Java用户
    //	内存消耗:53.1 MB,击败了98.83% 的Java用户

    public static void main(String[] args) {
        List<Integer> ans=topStudents(
                new String[]{"smart","brilliant","studious"},
                new String[]{"not"},
                new String[]{"this student is not studious","the student is smart"},
                new int[]{1,2},
                2
        );
        for(int i=0;i<ans.size();i++){
            System.out.print(ans.get(i)+" ");
        }
    }
    public static List<Integer> topStudents(String[] positive_feedback,
            String[] negative_feedback, String[] report, int[] student_id, int k) {
        Comparator<int[]> com=new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o2[1]==o1[1]){
                    return o1[0]-o2[0];
                }
                return o2[1]-o1[1];
            }
        };
        Queue<int[]> bigq=new PriorityQueue<>(com);
        for(int i=0;i<student_id.length;i++){
            int grade=0;
            for(String s:positive_feedback){
                if(report[i].contains(s)){
                    grade+=3;
                }
            }
            for(String s:negative_feedback){
                if(report[i].contains(s)){
                    grade-=1;
                }
            }
            bigq.add(new int[]{student_id[i],grade});
        }
        List<Integer> ans=new ArrayList<>();
        for(int i=0;i<k;i++){
            ans.add(bigq.poll()[0]);
        }
        return ans;
    }
}

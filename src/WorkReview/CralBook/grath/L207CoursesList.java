package WorkReview.CralBook.grath;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author wuboyu <wuboyu@kuaishou.com>
 * Created on 2026-01-12
 */
public class L207CoursesList {
    public static void main(String[] args) {

    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //当前这门课程，有多少个入度
        int[] indexMights = new int[numCourses];
        //例如，先修课程对 [0, 1] 表示：想要学习课程 0 ，你需要先完成课程 1
        //1->0 0的入度增加
        for (int[] array : prerequisites) {
            int index = array[0];
            indexMights[index]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i=0;i<indexMights.length;i++) {
            if (indexMights[i]==0) {
                queue.offer(i);
            }
        }
        int visited = 0;
        while (!queue.isEmpty()) {
            int nowCourse = queue.poll();
            visited++;
            for (int[] array : prerequisites) {
                if (array[1] == nowCourse) {
                    indexMights[array[0]]--;
                    if (indexMights[array[0]]==0) {
                        queue.offer(array[0]);
                    }
                }
            }
        }
        if (visited == numCourses) {
            return true;
        }
        return false;
    }
}

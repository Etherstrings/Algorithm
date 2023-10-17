package BFS;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author wuboyu <wuboyu@kuaishou.com>
 * Created on 2023-10-13
 */
public class L210 {
    //现在你总共有 numCourses 门课需要选，记为 0 到 numCourses - 1。给你一个数组 prerequisites ，其中 prerequisites[i] = [ai, bi] ，表示在选修课程 ai 前 必须 先选修 bi 。
    //
    //例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示：[0,1] 。
    //返回你为了学完所有课程所安排的学习顺序。可能会有多个正确的顺序，你只要返回 任意一种 就可以了。如果不可能完成所有课程，返回 一个空数组 。
    //
    //示例 1：
    //
    //输入：numCourses = 2, prerequisites = [[1,0]]
    //输出：[0,1]
    //解释：总共有 2 门课程。要学习课程 1，你需要先完成课程 0。因此，正确的课程顺序为 [0,1] 。
    //示例 2：
    //
    //输入：numCourses = 4, prerequisites = [[1,0],[2,0],[3,1],[3,2]]
    //输出：[0,2,1,3]
    //解释：总共有 4 门课程。要学习课程 3，你应该先完成课程 1 和课程 2。并且课程 1 和课程 2 都应该排在课程 0 之后。
    //因此，一个正确的课程顺序是 [0,1,2,3] 。另一个正确的排序是 [0,2,1,3] 。
    //示例 3：
    //
    //输入：numCourses = 1, prerequisites = []
    //输出：[0]
    //提示：
    //1 <= numCourses <= 2000
    //0 <= prerequisites.length <= numCourses * (numCourses - 1)
    //prerequisites[i].length == 2
    //0 <= ai, bi < numCourses
    //ai != bi
    //所有[ai, bi] 互不相同
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        //1 0 想学1 要先把0学了 因此1的入度起码为1
        int[] inDree = new int[numCourses];
        for (int i = 0; i < prerequisites.length; i++) {
            inDree[prerequisites[i][0]]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDree[i] == 0) {
                queue.offer(i);
            }
        }
        int[] ans = new int[numCourses];
        int index = 0;
        //不停的加入入度为0的课
        while (!queue.isEmpty()) {
            int now = queue.poll();
            ans[index++] = now;
            for (int i = 0; i < prerequisites.length; i++) {
                if (prerequisites[i][1] == now) {
                    inDree[prerequisites[i][0]]--;
                    if (inDree[prerequisites[i][0]] == 0) {
                        queue.offer(prerequisites[i][0]);
                    }
                }
            }
        }
        if (index == numCourses) {
            return ans;
        } else {
            return new int[0];
        }
    }

}

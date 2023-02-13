/**
 * @author Justice_wby
 * @create 2023-01-24 1:56
 */
public class L1828 {
    //1828. 统计一个圆中点的数目
    //给你一个数组 points ，其中 points[i] = [xi, yi] ，表示第 i 个点在二维平面上的坐标。多个点可能会有 相同 的坐标。
    //
    //同时给你一个数组 queries ，其中 queries[j] = [xj, yj, rj] ，表示一个圆心在 (xj, yj) 且半径为 rj 的圆。
    //
    //对于每一个查询 queries[j] ，计算在第 j 个圆 内 点的数目。如果一个点在圆的 边界上 ，我们同样认为它在圆 内 。
    //
    //请你返回一个数组 answer ，其中 answer[j]是第 j 个查询的答案。
    public int[] countPoints(int[][] points, int[][] queries) {

        //每个圆遍历点 判断有几个在上面
        int[] ans=new int[queries.length];
        for(int i=0;i<queries.length;i++){
            ans[i]=0;
            int[] yuan=queries[i];
            //x y r
            for(int[] p:points){
                //x y
                double temp=Math.sqrt((yuan[0]-p[0])*(yuan[0]-p[0])+(yuan[1]-p[1])*(yuan[1]-p[1]));
                if(temp<=yuan[2]){
                    ans[i]++;
                }
            }
        }
        return ans;
    }
}

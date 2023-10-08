import java.util.HashSet;
import java.util.Set;

/**
 * @author wuboyu <wuboyu@kuaishou.com>
 * Created on 2023-09-06
 */
public class L1198 {
    //给你一个矩阵 mat，其中每一行的元素都已经按 递增 顺序排好了。
    // 请你帮忙找出在所有这些行中 最小的公共元素。
    //
    //如果矩阵中没有这样的公共元素，就请返回 -1。
    //示例：
    //输入：mat = [[1,2,3,4,5],[2,4,5,8,10],[3,5,7,9,11],[1,3,5,7,9]]
    //输出：5
    //
    //提示：
    //1 <= mat.length, mat[i].length <= 500
    //1 <= mat[i][j] <= 10^4
    //mat[i] 已按递增顺序排列。
    public static int smallestCommonElement(int[][] mat){
        Set<Integer> set = new HashSet<>();
        for(int i=0;i<mat[0].length;i++){
            set.add(mat[0][i]);
        }
        for(int i=1;i<mat.length;i++){
            Set<Integer> temp = new HashSet<>();
            for(int j=0;j<mat[i].length;j++){
                if(set.contains(mat[i][j])){
                    temp.add(mat[i][j]);
                }
            }
            set = temp;
        }
        if(set.size()==0){
            return -1;
        }
        int min = Integer.MAX_VALUE;
        for(int i:set){
            min = Math.min(min,i);
        }
        return min;
    }
}

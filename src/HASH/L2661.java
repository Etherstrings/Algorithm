package HASH;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wuboyu <wuboyu@kuaishou.com>
 * Created on 2023-12-01
 */
public class L2661 {
    //给你一个下标从 0 开始的整数数组 arr 和一个 m x n 的整数 矩阵 mat 。arr 和 mat 都包含范围 [1，m * n] 内的 所有 整数
    //。
    //
    // 从下标 0 开始遍历 arr 中的每个下标 i ，并将包含整数 arr[i] 的 mat 单元格涂色。
    //
    // 请你找出 arr 中在 mat 的某一行或某一列上都被涂色且下标最小的元素，并返回其下标 i 。
    //
    //
    //
    // 示例 1：
    //
    //
    //输入：arr = [1,3,4,2], mat = [[1,4],[2,3]]
    //输出：2
    //解释：遍历如上图所示，arr[2] 在矩阵中的第一行或第二列上都被涂色。
    //
    //
    // 示例 2：
    //
    //
    //输入：arr = [2,8,7,4,1,3,5,6,9], mat = [[3,2,5],[1,4,6],[8,7,9]]
    //输出：3
    //解释：遍历如上图所示，arr[3] 在矩阵中的第二列上都被涂色。
    //
    //
    //
    //
    // 提示：
    //
    //
    // m == mat.length
    // n = mat[i].length
    // arr.length == m * n
    // 1 <= m, n <= 10⁵
    // 1 <= m * n <= 10⁵
    // 1 <= arr[i], mat[r][c] <= m * n
    // arr 中的所有整数 互不相同
    // mat 中的所有整数 互不相同
    //
    //
    // Related Topics 数组 哈希表 矩阵 👍 48 👎 0

    //> 2023/12/01 16:53:34
    //解答成功:
    //	执行耗时:25 ms,击败了59.81% 的Java用户
    //	内存消耗:67.6 MB,击败了12.15% 的Java用户

    public static int firstCompleteIndex(int[] arr, int[][] mat) {
        //第一个填充了行或者列的数字的索引
        int[] row = new int[mat.length];
        int[] col = new int[mat[0].length];
        Map<Integer,int[]> map = new HashMap<>();
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
                map.put(mat[i][j],new int[]{i,j});
            }
        }
        for(int i=0;i<arr.length;i++){
            int[] temp = map.get(arr[i]);
            row[temp[0]]++;
            col[temp[1]]++;
            if(row[temp[0]]==mat[0].length || col[temp[1]]==mat.length){
                return i;
            }
        }
        return -1;
    }
}

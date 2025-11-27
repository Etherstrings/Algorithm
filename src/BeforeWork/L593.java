import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @description:
 * @author： wuboyu
 * @date： 2022-07-29 16:47
 */
public class L593 {
    //593. 有效的正方形
    //给定2D空间中四个点的坐标 p1, p2, p3 和 p4，如果这四个点构成一个正方形，则返回 true 。
    //
    //点的坐标 pi 表示为 [xi, yi] 。输入 不是 按任何顺序给出的。
    //
    //一个 有效的正方形 有四条等边和四个等角(90度角)。
    //
    //
    //
    //示例 1:
    //
    //输入: p1 = [0,0], p2 = [1,1], p3 = [1,0], p4 = [0,1]
    //输出: True
    //示例 2:
    //
    //输入：p1 = [0,0], p2 = [1,1], p3 = [1,0], p4 = [0,12]
    //输出：false
    //示例 3:
    //
    //输入：p1 = [1,0], p2 = [-1,0], p3 = [0,1], p4 = [0,-1]
    //输出：true
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        Set<Integer> Judge=new HashSet<>();
        Judge.add(length(p1,p2));
        Judge.add(length(p1,p3));
        Judge.add(length(p1,p4));
        Judge.add(length(p2,p3));
        Judge.add(length(p2,p4));
        Judge.add(length(p3,p4));

        //此时这里面只应该有两个数 而且不该有0
        if(Judge.size()!=2){
            return false;
        }
        if(Judge.contains(0)){
            return false;
        }

        //里面的应该满足关系
        Integer[] integers = Judge.toArray(new Integer[2]);
        Arrays.sort(integers);
        return integers[1]==integers[0]*2;
    }

    Integer length(int[] a,int[] b){
        int lenght=(a[0]-b[0])*(a[0]-b[0])+(a[1]-b[1])*(a[1]-b[1]);
        return lenght;
    }
}

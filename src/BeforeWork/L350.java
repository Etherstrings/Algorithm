import java.lang.reflect.Array;
import java.util.*;

/**
 * @author Etherstrings
 * @create 2022-06-20 20:33 PACKAGE_NAME - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L350 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/6/20 - the current system date.  20:33 - the current system time.  2022 - the current year.  06 - the current month.  20 - the current day of the month.  20 - the current hour.  33 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  6月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  六月 - full name of a month. Example: January, February, etc
 */
public class L350 {
    //350. 两个数组的交集 II
    //给你两个整数数组 nums1 和 nums2 ，请你以数组形式返回两数组的交集。返回结果中每个元素出现的次数，应与元素在两个数组中都出现的次数一致（如果出现次数不一致，则考虑取较小值）。可以不考虑输出结果的顺序。
    //
    //
    //
    //示例 1：
    //
    //输入：nums1 = [1,2,2,1], nums2 = [2,2]
    //输出：[2,2]
    //示例 2:
    //
    //输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
    //输出：[4,9]
    //
    //
    //提示：
    //
    //1 <= nums1.length, nums2.length <= 1000
    //0 <= nums1[i], nums2[i] <= 1000
    //
    //
    //进阶：
    //
    //如果给定的数组已经排好序呢？你将如何优化你的算法？
    //如果 nums1 的大小比 nums2 小，哪种方法更优？
    //如果 nums2 的元素存储在磁盘上，内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？
    public int[] intersect(int[] nums1, int[] nums2) {
        //交集什么意思？
        //实际上是取都出现的数--并且返更小的一方
        Map<Integer,Integer> J1=new HashMap<>();
        Map<Integer,Integer> J2=new HashMap<>();
        for(Integer a:nums1){
            if(J1.containsKey(a)){
                J1.put(a,J1.get(a)+1);
            }else {
                J1.put(a,1);
            }
        }
        for(Integer a:nums2){
            if(J2.containsKey(a)){
                J2.put(a,J2.get(a)+1);
            }else {
                J2.put(a,1);
            }
        }
        int Size1=J1.size();
        int Size2=J2.size();
        List<Integer> Ans=new ArrayList<>();
        if(Size1>Size2){
            //遍历2---找1
            for(Integer a:J2.keySet()){
                if(J1.containsKey(a)){
                    //1 2都有 交集
                    int k=Math.min(J1.get(a),J2.get(a));
                    for(int i=0;i<k;i++){
                        Ans.add(a);
                    }
                }
            }
        }else if(Size1<Size2){
            //遍历1---找2
            for(Integer a:J1.keySet()){
                if(J2.containsKey(a)){
                    //1 2都有 交集
                    int k=Math.min(J1.get(a),J2.get(a));
                    for(int i=0;i<k;i++){
                        Ans.add(a);
                    }
                }
            }
        }else {
            //随便遍历一个 找另一个
            for(Integer a:J1.keySet()){
                if(J2.containsKey(a)){
                    //1 2都有 交集
                    int k=Math.min(J1.get(a),J2.get(a));
                    for(int i=0;i<k;i++){
                        Ans.add(a);
                    }
                }
            }
        }
        int[] rel=new int[Ans.size()];
        for(int i=0;i<Ans.size();i++){
            rel[i]=Ans.get(i);
        }
        return rel;
    }
}

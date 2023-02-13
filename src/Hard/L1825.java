package Hard;

import java.util.Arrays;

/**
 * @author Justice_wby
 * @create 2023-01-18 11:22
 */
public class L1825 {

    //1825. 求出 MK 平均值
    //给你两个整数 m 和 k ，以及数据流形式的若干整数。你需要实现一个数据结构，计算这个数据流的 MK 平均值 。
    //
    //MK 平均值 按照如下步骤计算：
    //
    //如果数据流中的整数少于 m 个，MK 平均值 为 -1 ，否则将数据流中最后 m 个元素拷贝到一个独立的容器中。
    //从这个容器中删除最小的 k 个数和最大的 k 个数。
    //计算剩余元素的平均值，并 向下取整到最近的整数 。
    //请你实现 MKAverage 类：
    //
    //MKAverage(int m, int k) 用一个空的数据流和两个整数 m 和 k 初始化 MKAverage 对象。
    //void addElement(int num) 往数据流中插入一个新的元素 num 。
    //int calculateMKAverage() 对当前的数据流计算并返回 MK 平均数 ，结果需 向下取整到最近的整数 。
    static class MKAverage {
        private int[] arr;
        private int k;
        private int m;
        private int len;
        private int size;
        public MKAverage(int m, int k) {
            arr=new int[m];
            this.size=0;
            this.len=m;
            this.m=m;
            this.k=k;
        }

        public void addElement(int num) {
            if(size>=len){
                arr = Arrays.copyOf(arr, 2 * len);
                len = arr.length;
            }
            arr[size++]=num;
        }

        //如果数据流中的整数少于 m 个，MK 平均值 为 -1 ，否则将数据流中最后 m 个元素拷贝到一个独立的容器中。
        //从这个容器中删除最小的 k 个数和最大的 k 个数。
        //计算剩余元素的平均值，并 向下取整到最近的整数 。
        public int calculateMKAverage() {
            if(size<m){
                return -1;
            }
            int[] copyArr = Arrays.copyOfRange(arr, size - m, size);
            Arrays.sort(copyArr);
            int[] newArr = Arrays.copyOfRange(copyArr, k, copyArr.length - k);
            return avg(newArr);
        }

        private int avg(int[] arr){
            if(arr.length == 0){
                return 0;
            }
            long res = 0;
            for (int i = 0; i < arr.length; i++) {
                res += arr[i];
            }
            return (int)(res / arr.length);
        }
    }
}

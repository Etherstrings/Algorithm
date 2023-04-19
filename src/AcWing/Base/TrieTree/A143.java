package AcWing.Base.TrieTree;

import java.util.Scanner;

public class A143 {
    static int idx;
    //当前这个int的值 最大为10的5次方
    //因此 转化为 二进制 最高为3000000位
    //每一个都可能是0 或者 1
    static int[][] son = new int[3000000][2];

    static void insert(int x){
        int p = 0;
        for(int i = 30; i >= 0; i--){
            if(son[p][(x >> i) & 1] == 0){
                //当前的这个位置把值填充
                son[p][(x >> i) & 1] = ++ idx;
            }
            //跳转P的位置 我这里写错了
            p = son[p][(x >> i) & 1];
        }
    }

    static int query(int x){
        int p = 0, res = 0;
        for(int i = 30; i >= 0; i--){
            int s = (x >> i) & 1;
            if(son[p][1-s] != 0){
                res += (1 << i);
                p = son[p][1-s];
            }else{
                p = son[p][s];
            }
        }
        return res;
    }

    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for(int i = 0; i < n; i++){
            a[i] = sc.nextInt();
            insert(a[i]);
        }
        int res = 0;
        for(int num : a){
            res = Math.max(res, query(num));
        }
        System.out.println(res);
    }

}

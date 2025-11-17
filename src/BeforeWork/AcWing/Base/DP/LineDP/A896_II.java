package AcWing.Base.DP.linedp;

import java.util.Scanner;

public class A896_II {
    //896. 最长上升子序列 II
    //   题目
    //   提交记录
    //   讨论
    //   题解
    //   视频讲解
    //
    //给定一个长度为 N
    // 的数列，求数值严格单调递增的子序列的长度最长是多少。
    //
    //输入格式
    //第一行包含整数 N
    //。
    //
    //第二行包含 N
    // 个整数，表示完整序列。
    //
    //输出格式
    //输出一个整数，表示最大长度。
    //
    //数据范围
    //1≤N≤100000
    //，
    //−109≤数列中的数≤109
    //输入样例：
    //7
    //3 1 2 1 8 5 6
    //输出样例：
    //4
    public static int N=100010;
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        int[] nums=new int[N];
        for(int i=1;i<=n;i++){
            nums[i]=in.nextInt();
        }
        int[] f=new int[N];
        int cnt=0;
        f[++cnt] = nums[1];

        for(int i=2;i<=n;i++){
            if(nums[i]>f[cnt]){
                f[++cnt]=nums[i];
            }else {
                int temp=find(nums[i],f,cnt);
                f[temp]=nums[i];
            }
        }
        System.out.println(cnt);
    }
    private static int find(int x,int[] f,int cnt){
        int l=1;
        int r=cnt;
        while(l<r){
            int mid=l+r>>1;
            if(f[mid]>=x){
                r=mid;
            }else {
                l=mid+1;
            }
        }
        return l;
    }
}

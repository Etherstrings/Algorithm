package BackStracking;

/**
 * @author wuboyu <wuboyu@kuaishou.com>
 * Created on 2023-09-06
 */
public class L526 {
    public static void main(String[] args) {
        System.out.println(countArrangement(12));
    }
    public static int ans;
    public static boolean[] used;
    public static int[] bucket;
    public static int countArrangement(int n) {
        used = new boolean[n+1];
        int[] bucket = new int[n+1];
        ans=0;
        backtarcking(bucket,n,1);
        return ans;
    }
    public static void backtarcking(int[] bucket,int n,int index){
        if(index==n+1){
            for(int i=1;i<=n;i++){
                if(!(bucket[i]%i==0||i%bucket[i]==0)){
                    return;
                }
            }
            ans++;
            return;
        }
        //index为当前bucket的位置
        for(int i=1;i<=n;i++){
            if(!used[i]){
                bucket[index]=i;
                used[i]=true;
                backtarcking(bucket,n,index+1);
                used[i]=false;
            }
        }
    }
}

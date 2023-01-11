import java.util.Arrays;

public class L1806 {
    public int reinitializePermutation(int n) {
        //初始
        int[] perm=new int[n];
        int[] base=new int[n];
        for(int i=0;i<n;i++){
            perm[i]=i;
            base[i]=i;
        }

        int step=0;
        while(true){
            int[] arr=new int[n];
            for(int i=0;i<n;i++){
                if(i%2==0){
                    arr[i]=perm[i/2];
                }else {
                    arr[i]=perm[n / 2 + (i - 1) / 2];
                }
            }
            perm=arr;
            step++;
            if(Arrays.equals(arr,base)){
                break;
            }
        }
        return step;
    }
}

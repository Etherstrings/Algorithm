package leetcode.week106;

public class num1 {
    public boolean isFascinating(int n) {
        int[] showup=new int[10];
        StringBuffer sb=new StringBuffer("");
        sb.append(n).append(2*n).append(3*n);
        for(char now:sb.toString().toCharArray()){
            showup[Integer.parseInt(now+"")]++;
        }
        for(int i=0;i<10;i++){
            if(i==0){
                if(showup[0]!=0){
                    return false;
                }
                continue;
            }
            if(showup[i]!=1){
                return false;
            }
        }
        return true;
    }
}

public class L2180 {
    public int countEven(int num) {
        int ans=0;
        for(int i=1;i<=num;i++){
            int temp=0;
            for(char c:(""+i).toCharArray()){
                temp+=Integer.parseInt(c+"");
            }
            if(temp<=num&&temp%2==0){
                ans++;
            }
        }
        return ans;
    }
}

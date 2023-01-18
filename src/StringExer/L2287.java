package StringExer;

/**
 * @author Justice_wby
 * @create 2023-01-13 13:41
 */
public class L2287 {
    public static int rearrangeCharacters(String s, String target) {
        int ans=0;
        boolean flag=true;
        while(flag){
            for(int i=0;i<target.length();i++){
                String now=target.charAt(i)+"";
                if(s.indexOf(now)==-1){
                    flag=false;
                    break;
                }
                int index=s.indexOf(now);
                if(index==0){
                    s=s.substring(1,s.length());
                }else if(index==s.length()-1){
                    s=s.substring(0,s.length()-1);
                }else {
                    String left=s.substring(0,s.indexOf(now));
                    String right=s.substring(s.indexOf(now)+1,s.length());
                    s=left+right;
                }
            }
            ans++;
        }
        return ans-1;
    }
}

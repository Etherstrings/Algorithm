/**
 * @author Etherstrings
 * @create 2022-09-06 1:27 PACKAGE_NAME - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L1582 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/9/6 - the current system date.  1:27 - the current system time.  2022 - the current year.  09 - the current month.  06 - the current day of the month.  01 - the current hour.  27 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  9月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  九月 - full name of a month. Example: January, February, etc
 */
public class L1582 {
    public int numSpecial(int[][] mat) {
        int level=mat.length;
        int col=mat[0].length;
        int ans=0;

        for(int i=0;i<level;i++){
            for(int j=0;j<col;j++){
                if(mat[i][j]!=1){
                    continue;
                }
                if(search(mat,i,j)){
                    ans++;
                }
            }
        }
        return ans;
    }

    boolean search(int[][] mat,int level,int col){
        boolean flag=true;
        int m=mat.length;
        int n=mat[0].length;
        for(int i=0;i<m;i++){
            if(i==level){
                continue;
            }
            if(mat[i][col]==1){
                flag=false;
                break;
            }
        }
        if(flag==false){
            return flag;
        }else {
            for(int i=0;i<n;i++){
                if(i==col){
                    continue;
                }
                if(mat[level][i]==1){
                    flag=false;
                    break;
                }
            }
        }
        return flag;
    }
}

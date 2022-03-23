/**
 * @author Etherstrings
 * @create 2022-01-03 2:02 PACKAGE_NAME - the name of the target package where the new class or interface will be created.  project01 - the name of the current project.  ${FILE_NAME} - the name of the PHP file that will be created.  L2022 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/1/3 - the current system date.  2:02 - the current system time.  2022 - the current year.  01 - the current month.  03 - the current day of the month.  02 - the current hour.  02 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  一月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  一月 - full name of a month. Example: January, February, etc
 */
public class L2022 {
    public static void main(String[] args) {
        L2022 l2022=new L2022();
        int[] original={1,2,3,4,5,6,7,8};
        l2022.construct2DArray(original,4,2);
    }


    public int[][] construct2DArray(int[] original, int m, int n) {

        if(original.length!=m*n){
            return new int[0][];
        }
        int num=0;
        int[][] ans=new int[m][n];
        for(int i=0;i<m;i++){

            for(int j=0;j<n;j++){
                ans[i][j]=original[num++];

            }

        }
        return ans;

    }
}

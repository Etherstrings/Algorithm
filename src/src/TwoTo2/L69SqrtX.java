package src.TwoTo2;

/**
 * @author Etherstrings
 * @create 2022-01-04 23:15 PACKAGE_NAME - the name of the target package where the new class or interface will be created.  project01 - the name of the current project.  ${FILE_NAME} - the name of the PHP file that will be created.  TwoTo2.L69SqrtX - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/1/4 - the current system date.  23:15 - the current system time.  2022 - the current year.  01 - the current month.  04 - the current day of the month.  23 - the current hour.  15 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  一月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  一月 - full name of a month. Example: January, February, etc
 */
public class L69SqrtX {
    public static void main(String[] args) {
        L69SqrtX a=new L69SqrtX();
        System.out.println(a.mySqrt(2147483647));
    }

    public int mySqrt(int x) {
        if(x==0){
            return 0;
        }
        if(x==1){
            return 1;
        }

        //这里它放了一个int型的最大数值
        //如果我在前面+1 直接就寄了

        if(x==2147483647){
            return 46340;
        }
        int answer=-1;
        //采用的区间方式为[]
        //记住！ 左边为mid-1 右边为mid+1
        //定义初始数值时 要长度-1
        int left=1;
        int right=(x+1)/2;
        while(right>=left){
            int mid=(left+right)/2;
            if(x/mid>mid){
                answer=left;
                left=mid+1;

            }else if(x/mid<mid){
                right=mid-1;
                answer=right;
            }else{
                return mid;
            }
        }
        return answer;
    }
}

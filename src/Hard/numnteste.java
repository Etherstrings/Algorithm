package Hard;

/**
 * @author Etherstrings
 * @create 2023-07-26 18:26 Hard - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  numnteste - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2023/7/26 - the current system date.  18:26 - the current system time.  2023 - the current year.  07 - the current month.  26 - the current day of the month.  18 - the current hour.  26 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  7月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  七月 - full name of a month. Example: January, February, etc
 */
public class numnteste {
    public static void main(String[] args) {
        System.out.println("hello world");
    }
    /**
    public static void main(String[] args) {

            System.out.println(getMax(6));
        }


    public static Double getMax(int num){
        //初始化
        init();
        //判断所在梯度
        Double ans=getlevel(num);
        return ans;
    }
    //当前梯度所有价值
    public static HashMap<Integer,Double> map;
    public static void init(){
        map=new HashMap<>();
        //初始化所有level的总价值
        map.put(1,150.00);
        map.put(2,map.get(1)+(15)*15);
        map.put(3,map.get(2)+(30)*10);
    }

    public static Double getlevel(int num){
        double ans=0;
        //初始化level对应关系
        int[][] lev=new int[13][3];
        lev[1]=new int[3]{1,5,30};
        lev[2]=new int[3]{6,20,15};
        lev[3]=new int[3]{21,50,10};
        for(int i=1;i<lev.length;i++){
            if(num>=lev[i][0]&&num<=lev[i][1]){
                if(i==1){
                    return (double)num*lev[i][2];
                }
                return map.get(i-1)+(num-lev[i-1][1])*lev[i][2];
            }
        }
        return ans;
    }
    */
}

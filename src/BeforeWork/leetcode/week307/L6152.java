package leetcode.week307;

/**
 * @author Etherstrings
 * @create 2022-08-21 12:44 leetcode.week307 - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L6152 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/8/21 - the current system date.  12:44 - the current system time.  2022 - the current year.  08 - the current month.  21 - the current day of the month.  12 - the current hour.  44 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  8月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  八月 - full name of a month. Example: January, February, etc
 */
public class L6152 {
    public int minNumberOfHours(int initialEnergy, int initialExperience, int[] energy, int[] experience) {
        //动态规划
        //模拟
        //当前状态
        //训练后状态
        //战斗后状态
        //训练时间
        //当前对手状态
        //倒叙

        if(energy.length==1){
            int ans=0;
            if(initialEnergy<=energy[0]){
                ans+=energy[0]+1-initialEnergy;
            }
            if(initialExperience<=experience[0]){
                ans+=experience[0]+1-initialExperience;
            }
            return ans;
        }
        int tempen=0;
        for(int i=energy.length-1;i>=0;i--){

            tempen+=energy[i];
        }
        if(initialEnergy<=tempen){
            tempen=tempen-initialEnergy+1;
        }else {
            tempen=0;
        }
        int tempce=0;
        for(int i=0;i<experience.length;i++){
            if(initialExperience<=experience[i]){
                tempce+=experience[i]+1-initialExperience;
                initialExperience=experience[i]+1+experience[i];
            }else {
                initialExperience+=experience[i];
            }
        }
        return tempen+tempce;
    }
}

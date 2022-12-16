package src.StringExer;

/**
 * @author Etherstrings
 * @create 2022-02-16 0:28 StringExer - the name of the target package where the new class or interface will be created.  ideaworkplace - the name of the current project.  ${FILE_NAME} - the name of the PHP file that will be created.  L541 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/2/16 - the current system date.  0:28 - the current system time.  2022 - the current year.  02 - the current month.  16 - the current day of the month.  00 - the current hour.  28 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  二月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  二月 - full name of a month. Example: January, February, etc
 */
public class L541 {
    //541. 反转字符串 II
    //给定一个字符串 s 和一个整数 k，从字符串开头算起，每计数至 2k 个字符，就反转这 2k 字符中的前 k 个字符。
    //
    //如果剩余字符少于 k 个，则将剩余字符全部反转。
    //如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。

    public String reverseStr1(String s, int k) {
        char[] ch=s.toCharArray();

        //每2k字符 翻转前k个字符
        for(int i=0;i<ch.length;i+=2*k){
            //判断是否够
            if(i+k<=ch.length){
                reverse(ch,i,i+k-1);
                continue;
            }
            //不够的话如何
            reverse(ch,i,ch.length-1);
        }

        return new String(ch);

    }

    public void reverse(char[] ch,int i,int j){
        for(;i<j;i++,j--){
            char temp=ch[i];
            ch[i]=ch[j];
            ch[j]=temp;
        }
    }

    public String reverseStr(String s, int k) {
        if(k==1){
            return s;
        }
        char[] ch = s.toCharArray();
        int len = s.length();
        if (len < k) {
            //当前的小于k
            //直接翻转s
            StringBuilder temp = new StringBuilder(s);
            temp.reverse();
            return temp.toString();
        }
        //分为多少个2k和不足2k的
        int size=len/(2*k);
        String Tk=s.substring(0,2*k*size);
        for(int i=0;i<size;i++){
            //每一组翻转前k
            if(i==0){
                //第一组
                String temp=Tk.substring(i*2*k,(i+1)*2*k);
                String right=Tk.substring((i+1)*2*k,size*2*k);

                String ttemp=temp.substring(0,k);
                String tright=temp.substring(k,temp.length());
                StringBuilder Now=new StringBuilder(ttemp);

                Tk=Now.reverse().toString()+tright+right;
            }else if(i==size-1){
                //最后一组
                String temp=Tk.substring(i*2*k,(i+1)*2*k);
                String left=Tk.substring((i-1)*2*k,i*2*k);

                String ttemp=temp.substring(0,k);
                String tright=temp.substring(k,temp.length());
                StringBuilder Now=new StringBuilder(ttemp);

                Tk=left+Now.reverse().toString()+tright;
            }else {

                String temp=Tk.substring(i*2*k,(i+1)*2*k);
                String left=Tk.substring(0,i*2*k);
                String right=Tk.substring((i+1)*2*k,size*2*k);

                String ttemp=temp.substring(0,k);
                String tright=temp.substring(k,temp.length());
                StringBuilder Now=new StringBuilder(ttemp);

                Tk=left+Now.reverse().toString()+tright+right;
            }


        }

        int left=len%(2*k);
        String leftr=s.substring(size*2*k,s.length());
        if(left<k){
            //全翻转
            StringBuilder Now=new StringBuilder(leftr);
            leftr=Now.reverse().toString();
        }else {
            //翻转前k
            String Now=leftr.substring(0,k);
            String lr=leftr.substring(k,leftr.length());
            StringBuilder temp=new StringBuilder(Now);
            Now=temp.reverse().toString();
            leftr=Now+lr;
        }

        return Tk+leftr;

    }


}

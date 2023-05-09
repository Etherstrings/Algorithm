package StringExer;

import java.util.Arrays;
import java.util.Comparator;

public class L2409 {
    public static void main(String[] args) {
        System.out.println(countDaysTogether("01-20",
                "04-18",
                "01-01",
                "08-30"));
    }
    public static int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        //1.转化日期
        //2.合并区间
        int[] A=new int[2];
        A[0]=getDays("2019-"+arriveAlice);
        A[1]=getDays("2019-"+leaveAlice);
        int[] B=new int[2];
        B[0]=getDays("2019-"+arriveBob);
        B[1]=getDays("2019-"+leaveBob);


        Comparator<int[]> com=new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        };
        int[][] Days=new int[2][2];
        Days[0]=A;
        Days[1]=B;
        Arrays.sort(Days,com);
        int left=Days[0][0];
        int right=Days[0][1];
        int nowleft=Days[1][0];
        int ans=0;
        if(nowleft>right){
            //不重叠
        }else {
            right=Math.min(right,Days[1][1]);
            ans=right-Days[1][0]+1;
        }
        return ans;
    }



    public static int getDays(String date){

        //创建char型的数组 数组长度为10 一一对应 从0-3为year 从5-6为月份 从8-9为天
        char[] year1=new char[4];
        char[] month1=new char[2];
        char[] day1=new char[2];
        date.getChars(0,4,year1,0);
        date.getChars(5,7,month1,0);
        date.getChars(8,10,day1,0);
        //将字符串char[]转化为int[];
        int[] year2=new int[4];
        int[] month2=new int[2];
        int[] day2=new int[2];
        for(int i=0;i<year1.length;i++){
            year2[i]=year1[i]-'0';
        }
        int year=year2[0]*1000+year2[1]*100+year2[2]*10+year2[3];
        for(int i=0;i<month1.length;i++){
            month2[i]=month1[i]-'0';
        }
        int month=month2[0]*10+month2[1];
        for(int i=0;i<day1.length;i++){
            day2[i]=day1[i]-'0';
        }
        int day=day2[0]*10+day2[1];
        int days=0;
        if(year%400==0){
            //闰年

            switch(month){
                case 12:
                    days+=30;
                case 11:
                    days+=31;
                case 10:
                    days+=30;
                case 9:
                    days+=31;
                case 8:
                    days+=31;
                case 7:
                    days+=30;
                case 6:
                    days+=31;
                case 5:
                    days+=30;
                case 4:
                    days+=31;
                case 3:
                    days+=29;
                case 2:
                    days+=31;
                case 1:
                    days+=day;
            }
            return days;
        }else{
            if(year%4==0){
                //闰年

                switch(month){
                    case 12:
                        days+=30;
                    case 11:
                        days+=31;
                    case 10:
                        days+=30;
                    case 9:
                        days+=31;
                    case 8:
                        days+=31;
                    case 7:
                        days+=30;
                    case 6:
                        days+=31;
                    case 5:
                        days+=30;
                    case 4:
                        days+=31;
                    case 3:
                        days+=29;
                    case 2:
                        days+=31;
                    case 1:
                        days+=day;
                }
                return days;

            }else{
                //不是闰年

                switch(month){
                    case 12:
                        days+=30;
                    case 11:
                        days+=31;
                    case 10:
                        days+=30;
                    case 9:
                        days+=31;
                    case 8:
                        days+=31;
                    case 7:
                        days+=30;
                    case 6:
                        days+=31;
                    case 5:
                        days+=30;
                    case 4:
                        days+=31;
                    case 3:
                        days+=28;
                    case 2:
                        days+=31;
                    case 1:
                        days+=day;
                }
                return days;
            }
        }



    }

    public static int[] trans(String arrive,String leave){
        //转换为第几天 从1.1开始
        int[] first=new int[2];
        String[] words=arrive.split("-");
        Integer month=Integer.parseInt(words[0]);
        Integer day=Integer.parseInt(words[1]);
        Integer days=0;
        switch (month){
            case 12:
                days+=(365-31);
                break;
            case 11:
                days+=(365-31-30);
                break;
            case 10:
                days+=(365-31-30-31);
                break;
            case 9:
                days+=(365-31-30-31-30);
                break;
            case 8:
                days+=(365-31-30-31-30-31);
                break;
            case 7:
                days+=(365-31-30-31-30-31-31);
                break;
            case 6:
                days+=(365-31-30-31-30-31-31-30);
                break;
            case 5:
                days+=(365-31-30-31-30-31-31-30-31);
                break;
            case 4:
                days+=(365-31-30-31-30-31-31-30-31-30);
                break;
            case 3:
                days+=(365-31-30-31-30-31-31-30-31-30-31);
                break;
            case 2:
                days+=(365-31-30-31-30-31-31-30-31-30-28);
                break;
            case 1:
                days+=(365-31-30-31-30-31-31-30-31-30-28-30);
                break;
        }
        days+=day;
        first[0]=days;
        words=leave.split("-");
        month=Integer.parseInt(words[0]);
        day=Integer.parseInt(words[1]);
        days=0;
        switch (month){
            case 12:
                days+=(365-31);
                break;
            case 11:
                days+=(365-31-30);
                break;
            case 10:
                days+=(365-31-30-31);
                break;
            case 9:
                days+=(365-31-30-31-30);
                break;
            case 8:
                days+=(365-31-30-31-30-31);
                break;
            case 7:
                days+=(365-31-30-31-30-31-31);
                break;
            case 6:
                days+=(365-31-30-31-30-31-31-30);
                break;
            case 5:
                days+=(365-31-30-31-30-31-31-30-31);
                break;
            case 4:
                days+=(365-31-30-31-30-31-31-30-31-30);
                break;
            case 3:
                days+=(365-31-30-31-30-31-31-30-31-30-31);
                break;
            case 2:
                days+=(365-31-30-31-30-31-31-30-31-30-28);
                break;
            case 1:
                days+=(365-31-30-31-30-31-31-30-31-30-28-30);
                break;
        }
        days+=day;
        first[1]=days;
        return first;
    }
}

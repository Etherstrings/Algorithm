package StringExer;

public class L2409 {
    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        //1.转化日期
        //2.合并区间
        int[] A=trans(arriveAlice,leaveAlice);
        int[] B=trans(arriveBob,leaveBob);
        int left=Math.min(A[0],B[0]);
        int right;
        return 0;
    }

    public static int[] trans(String arrive,String leave){
        //转换为第几天 从1.1开始
        int[] first=new int[2];
        String[] words=arrive.split(" ");
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
        words=leave.split(" ");
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

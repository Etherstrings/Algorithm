package StringExer;

public class L1138 {
    public static String alphabetBoardPath(String target) {
        char now='a';
        int nx=0;
        int ny=0;
        StringBuffer sb=new StringBuffer();
        for(char c:target.toCharArray()){
            if(now==c){
                sb.append("!");
                continue;
            }
            //需要移动字母所在的位置
            int mx=(c-'a')/5;
            int my=(c-'a')%5;
            if(now=='z'){
                //从Z移动到另外字母
                //先上移动
                for(;nx>mx;nx--){
                    sb.append("U");
                }
                //再右移动
                for(;ny<my;ny++){
                    sb.append("R");
                }
                sb.append("!");
                nx=mx;
                ny=my;
                now=c;
                continue;
            }
            if(c=='z'){
                //从当前字母移动到Z
                //先向左移动
                for(;ny>0;ny--){
                    sb.append("L");
                }
                //再向下移动
                for(;nx<5;nx++){
                    sb.append("D");
                }
                sb.append("!");
                nx=mx;
                ny=my;
                now=c;
                continue;
            }
            //先左右
            if(ny==my){

            }else {
                if(ny<my){
                    for(;ny<my;ny++){
                        sb.append("R");
                    }
                }else {
                    for(;ny>my;ny--){
                        sb.append("L");
                    }
                }
            }
            //后上下
            if(nx==mx){

            }else {
                if(nx<mx){
                    for(;nx<mx;nx++){
                        sb.append("D");
                    }
                }else {
                    for(;nx>mx;nx--){
                        sb.append("U");
                    }
                }
            }
            sb.append("!");
            nx=mx;
            ny=my;
            now=c;
            continue;
        }
        return sb.toString();
    }
}

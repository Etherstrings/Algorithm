package leetcode.week325;

public class L6269 {
    public int closetTarget(String[] words, String target, int startIndex) {
        int toleft=0;
        int toright=0;
        boolean exist=false;
        for(String now:words){
            if(now.equals(target)){
                exist=true;
                break;
            }
        }
        if(exist==false){
            return -1;
        }
        int three=0;
        if(startIndex==0){
            if(words[startIndex].equals(target)){
                three=0;
            }else {
                for(int i=words.length-1;i>0;i--){
                    three++;
                    if(words[i]==target){
                        break;
                    }
                }
            }
        }
        int four=0;
        if(startIndex==words.length-1){
            if(words[startIndex].equals(target)){
                four=0;
            }else {
                for(int i=0;i< words.length-1;i++){
                    four++;
                    if(words[i]==target){
                        break;
                    }
                }
            }
        }
        for(int i=startIndex;i<words.length;i++){
            if(words[i].equals(target)){
                //当前找到了-要移动几次？
                toright=i-startIndex;
                break;
            }
        }
        for(int i=startIndex;i>=0;i--){
            if(words[i].equals(target)){
                toleft=startIndex-i;
                break;
            }
        }
        return Math.min(Math.min(toright,toleft),Math.min(three,four));
    }
}

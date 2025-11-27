/**
 * @description:
 * @author： wuboyu
 * @date： 2022-08-04 13:56
 */
public class L941 {

    public boolean validMountainArray(int[] arr) {
        int leftsize=0;
        int rihtsize=0;
        if(arr.length<=2){
            return false;
        }

        for(int i=1;i<arr.length;i++){
            if(arr[i]>arr[i-1]){
                leftsize++;
            }else {
                break;
            }
        }

        for(int i=arr.length-1;i>0;i--){
            if(arr[i-1]>arr[i]){
                rihtsize++;
            }else {
                break;
            }
        }
        if(leftsize==0||rihtsize==0){
            return false;
        }
        if(leftsize+rihtsize+1== arr.length){
            return true;
        }
        return false;
    }
}

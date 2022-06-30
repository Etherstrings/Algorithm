import java.util.ArrayList;
import java.util.List;

public class L1108 {
    public String defangIPaddr(String address) {
        List<Character> Answer=new ArrayList<>();
        for(Character a:address.toCharArray()){
            if(a.equals('.')){
                Answer.add('[');
                Answer.add('.');
                Answer.add(']');
            }else {
                Answer.add(a);
            }
        }
        String turea="";
        for(Character a:Answer){
            turea+=a;
        }
        return turea;
    }
}

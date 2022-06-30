package StringExer;

import java.util.ArrayList;
import java.util.HashMap;

public class L500_way2 {
    public String[] findWords(String[] words) {
        ArrayList<String> Judege=new ArrayList<>();

        for(String a:words){
            if(istrue(a)){
                Judege.add(a);
            }
        }
        return (String[])Judege.toArray();

    }

    boolean istrue(String word){
        HashMap<Character,Integer> How=new HashMap<>();
        Character c='a';
        for(Character a:word.toCharArray()){
            if(Character.isUpperCase(a)){
                a=Character.toLowerCase(a);
            }
            if(How.isEmpty()){
                c=a;
                How.put(a,1);
            }
            How.put(a,How.get(a)+1);
        }
        String line1="qwertyuio";
        String line2="asdfghjkl";
        String line3="zxcvbnm";
        if(line1.contains(c.toString()){
            //第一行了
            for(Character d:How.keySet()){
                if(!line1.contains(d.toString())){
                    return false;
                }
            }
        }

        if(line2.contains(c.toString())){
            for(Character d:How.keySet()){
                if(!line1.contains(d.toString())){
                    return false;
                }
            }
        }



    }
}

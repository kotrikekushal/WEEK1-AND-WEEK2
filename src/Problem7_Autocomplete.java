import java.util.*;

public class Problem7_Autocomplete {

    HashMap<String,Integer> map=new HashMap<>();

    void add(String q){
        map.put(q,map.getOrDefault(q,0)+1);
    }

    void search(String prefix){
        for(String s:map.keySet())
            if(s.startsWith(prefix))
                System.out.println(s);
    }

    public static void main(String[] args){
        Problem7_Autocomplete obj=new Problem7_Autocomplete();
        obj.add("java tutorial");
        obj.add("javascript");
        obj.search("jav");
    }
}

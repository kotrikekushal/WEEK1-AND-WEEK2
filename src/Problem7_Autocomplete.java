import java.util.*;

public class Problem7_Autocomplete {

    HashMap<String,Integer> queries=new HashMap<>();

    public void addQuery(String q){
        queries.put(q,queries.getOrDefault(q,0)+1);
    }

    public List<String> search(String prefix){

        List<String> res=new ArrayList<>();

        for(String q:queries.keySet())
            if(q.startsWith(prefix))
                res.add(q);

        res.sort((a,b)->queries.get(b)-queries.get(a));

        return res.subList(0,Math.min(10,res.size()));
    }

    public static void main(String[] args){

        Problem7_Autocomplete obj=new Problem7_Autocomplete();

        obj.addQuery("java tutorial");
        obj.addQuery("javascript");
        obj.addQuery("java download");

        System.out.println(obj.search("jav"));
    }
}

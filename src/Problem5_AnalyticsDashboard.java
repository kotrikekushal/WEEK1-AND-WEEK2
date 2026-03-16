import java.util.*;

public class Problem5_AnalyticsDashboard {

    HashMap<String,Integer> pageViews=new HashMap<>();
    HashMap<String,Set<String>> visitors=new HashMap<>();
    HashMap<String,Integer> sources=new HashMap<>();

    public void processEvent(String url,String user,String source){

        pageViews.put(url,pageViews.getOrDefault(url,0)+1);

        visitors.putIfAbsent(url,new HashSet<>());
        visitors.get(url).add(user);

        sources.put(source,sources.getOrDefault(source,0)+1);
    }

    public static void main(String[] args){

        Problem5_AnalyticsDashboard obj=new Problem5_AnalyticsDashboard();

        obj.processEvent("/news","user1","google");
        obj.processEvent("/news","user2","facebook");

        System.out.println(obj.pageViews);
        System.out.println(obj.sources);
    }
}
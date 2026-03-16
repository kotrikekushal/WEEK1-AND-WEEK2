import java.util.*;

public class Problem5_AnalyticsDashboard {

    HashMap<String,Integer> views=new HashMap<>();

    void visit(String page){
        views.put(page,views.getOrDefault(page,0)+1);
    }

    public static void main(String[] args){
        Problem5_AnalyticsDashboard obj=new Problem5_AnalyticsDashboard();
        obj.visit("/news");
        obj.visit("/news");
        System.out.println(obj.views);
    }
}
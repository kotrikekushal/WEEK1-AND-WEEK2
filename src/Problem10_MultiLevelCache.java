import java.util.*;

public class Problem10_MultiLevelCache {

    HashMap<String,String> cache=new HashMap<>();

    void add(String id,String data){
        cache.put(id,data);
    }

    String get(String id){
        return cache.getOrDefault(id,"MISS");
    }

    public static void main(String[] args){
        Problem10_MultiLevelCache obj=new Problem10_MultiLevelCache();
        obj.add("video1","data");
        System.out.println(obj.get("video1"));
    }
}

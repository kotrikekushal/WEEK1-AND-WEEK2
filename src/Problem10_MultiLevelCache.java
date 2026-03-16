import java.util.*;

public class Problem10_MultiLevelCache {

    HashMap<String,String> l1=new HashMap<>();
    HashMap<String,String> l2=new HashMap<>();
    HashMap<String,String> db=new HashMap<>();

    public void addVideo(String id,String data){
        db.put(id,data);
    }

    public String getVideo(String id){

        if(l1.containsKey(id))
            return "L1 HIT";

        if(l2.containsKey(id)){
            l1.put(id,l2.get(id));
            return "L2 HIT";
        }

        if(db.containsKey(id)){
            l2.put(id,db.get(id));
            return "DB HIT";
        }

        return "MISS";
    }

    public static void main(String[] args){

        Problem10_MultiLevelCache obj=new Problem10_MultiLevelCache();

        obj.addVideo("video1","data");

        System.out.println(obj.getVideo("video1"));
        System.out.println(obj.getVideo("video1"));
    }
}

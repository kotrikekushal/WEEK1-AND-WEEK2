import java.util.*;

class Bucket{
    int tokens;
    long last;

    Bucket(int t,long l){
        tokens=t;
        last=l;
    }
}

public class Problem6_RateLimiter {

    HashMap<String,Bucket> map=new HashMap<>();
    int limit=5;

    public boolean allow(String client){

        long now=System.currentTimeMillis();

        if(!map.containsKey(client)){
            map.put(client,new Bucket(1,now));
            return true;
        }

        Bucket b=map.get(client);

        if(b.tokens<limit){
            b.tokens++;
            return true;
        }

        return false;
    }

    public static void main(String[] args){

        Problem6_RateLimiter obj=new Problem6_RateLimiter();

        System.out.println(obj.allow("client1"));
        System.out.println(obj.allow("client1"));
        System.out.println(obj.allow("client1"));
    }
}

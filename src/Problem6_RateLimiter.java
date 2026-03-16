import java.util.*;

public class Problem6_RateLimiter {

    HashMap<String,Integer> count=new HashMap<>();

    boolean allow(String client){
        count.put(client,count.getOrDefault(client,0)+1);
        return count.get(client)<=5;
    }

    public static void main(String[] args){
        Problem6_RateLimiter obj=new Problem6_RateLimiter();
        System.out.println(obj.allow("client1"));
    }
}

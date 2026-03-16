import java.util.*;

class Entry{
    String ip;
    long expiry;

    Entry(String ip,long expiry){
        this.ip=ip;
        this.expiry=expiry;
    }
}

public class Problem3_DNSCache {

    HashMap<String,Entry> cache=new HashMap<>();

    public void add(String domain,String ip,int ttl){
        long exp=System.currentTimeMillis()+ttl*1000;
        cache.put(domain,new Entry(ip,exp));
    }

    public String resolve(String domain){

        if(cache.containsKey(domain)){
            Entry e=cache.get(domain);

            if(System.currentTimeMillis()<e.expiry){
                return e.ip;
            }else{
                cache.remove(domain);
            }
        }

        return "MISS";
    }

    public static void main(String[] args){

        Problem3_DNSCache obj=new Problem3_DNSCache();

        obj.add("google.com","172.217.14.206",300);

        System.out.println(obj.resolve("google.com"));
    }
}
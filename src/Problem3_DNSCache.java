import java.util.*;

class DNSRecord{
    String ip;
    long expiry;

    DNSRecord(String ip,long ttl){
        this.ip=ip;
        this.expiry=System.currentTimeMillis()+ttl*1000;
    }
}

public class Problem3_DNSCache {

    HashMap<String,DNSRecord> cache=new HashMap<>();

    public void add(String domain,String ip,int ttl){
        cache.put(domain,new DNSRecord(ip,ttl));
    }

    public String resolve(String domain){

        if(cache.containsKey(domain)){

            DNSRecord r=cache.get(domain);

            if(System.currentTimeMillis()<r.expiry)
                return "Cache HIT: "+r.ip;

            cache.remove(domain);
        }

        return "Cache MISS";
    }

    public static void main(String[] args){

        Problem3_DNSCache obj=new Problem3_DNSCache();

        obj.add("google.com","172.217.14.206",60);

        System.out.println(obj.resolve("google.com"));
    }
}
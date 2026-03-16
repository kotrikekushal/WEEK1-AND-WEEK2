import java.util.*;

public class Problem_UsernameChecker {

    HashMap<String,Integer> users = new HashMap<>();
    HashMap<String,Integer> attempts = new HashMap<>();

    public boolean checkAvailability(String username){
        attempts.put(username, attempts.getOrDefault(username,0)+1);
        return !users.containsKey(username);
    }

    public void registerUser(String username,int id){
        users.put(username,id);
    }

    public List<String> suggestAlternatives(String username){
        List<String> list = new ArrayList<>();
        for(int i=1;i<=3;i++){
            if(!users.containsKey(username+i))
                list.add(username+i);
        }
        list.add(username.replace("_","."));
        return list;
    }

    public String getMostAttempted(){
        String res="";
        int max=0;

        for(String u:attempts.keySet()){
            if(attempts.get(u)>max){
                max=attempts.get(u);
                res=u;
            }
        }
        return res;
    }

    public static void main(String[] args){

        Problem_UsernameChecker obj=new Problem_UsernameChecker();

        obj.registerUser("john_doe",1);

        System.out.println(obj.checkAvailability("john_doe"));
        System.out.println(obj.checkAvailability("jane_smith"));

        System.out.println(obj.suggestAlternatives("john_doe"));
    }
}



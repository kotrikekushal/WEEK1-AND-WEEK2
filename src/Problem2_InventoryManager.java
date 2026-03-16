import java.util.*;

public class Problem2_InventoryManager {

    HashMap<String,Integer> stock=new HashMap<>();
    HashMap<String,Queue<Integer>> waiting=new HashMap<>();

    public void addProduct(String id,int quantity){
        stock.put(id,quantity);
        waiting.put(id,new LinkedList<>());
    }

    public int checkStock(String id){
        return stock.getOrDefault(id,0);
    }

    public String purchaseItem(String id,int user){

        if(stock.getOrDefault(id,0)>0){
            stock.put(id,stock.get(id)-1);
            return "Success";
        }else{
            waiting.get(id).add(user);
            return "Added to waiting list";
        }
    }

    public static void main(String[] args){

        Problem2_InventoryManager obj=new Problem2_InventoryManager();

        obj.addProduct("IPHONE15",3);

        System.out.println(obj.checkStock("IPHONE15"));

        System.out.println(obj.purchaseItem("IPHONE15",101));
        System.out.println(obj.purchaseItem("IPHONE15",102));
        System.out.println(obj.purchaseItem("IPHONE15",103));
        System.out.println(obj.purchaseItem("IPHONE15",104));
    }
}
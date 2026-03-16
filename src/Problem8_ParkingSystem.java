public class Problem8_ParkingSystem {

    String[] spots=new String[10];

    int park(String plate){
        int i=Math.abs(plate.hashCode())%10;
        while(spots[i]!=null) i=(i+1)%10;
        spots[i]=plate;
        return i;
    }

    public static void main(String[] args){
        Problem8_ParkingSystem obj=new Problem8_ParkingSystem();
        System.out.println(obj.park("ABC123"));
    }
}

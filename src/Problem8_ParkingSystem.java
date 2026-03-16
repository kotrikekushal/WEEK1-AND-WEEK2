public class Problem8_ParkingSystem {

    String[] spots;
    int size;

    public Problem8_ParkingSystem(int n){
        size=n;
        spots=new String[n];
    }

    public int parkVehicle(String plate){

        int index=Math.abs(plate.hashCode())%size;

        while(spots[index]!=null)
            index=(index+1)%size;

        spots[index]=plate;

        return index;
    }

    public void exitVehicle(String plate){

        for(int i=0;i<size;i++)
            if(plate.equals(spots[i]))
                spots[i]=null;
    }

    public static void main(String[] args){

        Problem8_ParkingSystem obj=new Problem8_ParkingSystem(10);

        System.out.println(obj.parkVehicle("ABC123"));
    }
}

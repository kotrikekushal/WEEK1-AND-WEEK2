import java.util.*;

public class Problem9_TwoSumTransactions {

    int[] twoSum(int[] arr,int target){

        HashMap<Integer,Integer> map=new HashMap<>();

        for(int i=0;i<arr.length;i++){
            int c=target-arr[i];

            if(map.containsKey(c))
                return new int[]{map.get(c),i};

            map.put(arr[i],i);
        }

        return new int[]{};
    }

    public static void main(String[] args){

        Problem9_TwoSumTransactions obj=new Problem9_TwoSumTransactions();

        int[] arr={200,300,500};

        int[] res=obj.twoSum(arr,500);

        System.out.println(res[0]+" "+res[1]);
    }
}
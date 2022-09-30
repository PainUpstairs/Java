import java.util.*;

public class a1And2 {

    // Function returns count of ways to cover 'dist'
    static int printCountDP(int[] arr, int target){
        Map<Integer, Integer> store = new HashMap<>();
        store.put(0,1);

        for( int i : store.keySet()){
            boolean done = true;
            for( int a: arr){
                int temp = i+a;
                if( temp < target) done = false;

                // if( store.containsKey(temp)) store.put(temp , store.get(temp)+1);
                // else store.put

                store.put(temp, store.getOrDefault(temp, 0)+1);
            }
            if( done ) break;
        }


        return store.getOrDefault(target, 0);
    }
     
    // driver program
    public static void main (String[] args)
    {
        // int target = 9;
        // int[] arr = {3,5};
        // System.out.println(printCountDP(arr, target));
        int a = 0;
        int b = 1;
        System.out.println(a);
        System.out.println(b);

        for( int i = 0 ; i<8 ; i++){
            int z = a+b;
            System.out.println(z);

            a = b;
            b = z;
            
        }
    }
}

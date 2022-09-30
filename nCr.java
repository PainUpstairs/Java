import java.util.*;

class nCr {
    static public List<List<Integer>> getCombination(List<Integer> arr,
            List<List<Integer>> store, int start, int k, int count) {
        if (count == k )
            return store;
        
        Map<Integer,List<List<Integer>>> parallel = new HashMap<>();
        List<List<Integer>> send_store = new ArrayList<>();


        

        for (int i = start; i < Math.min(start + k, arr.size()); i++) {
            // System.out.println(arr.get(i));
            parallel.put(i, Arrays.asList(new ArrayList<>(store.get(0))));
            parallel.get(i).get(0).add(arr.get(i));
            // parallel.put(i,getCombination(arr,parallel.get(i), i+1,k, count+1 ));
            send_store.addAll(getCombination(arr,parallel.get(i), i+1,k, count+1 ));
        }

        // List<List<Integer>> send_store = new ArrayList<>();
        // for(Map.Entry<Integer, List<List<Integer>>> e : parallel.entrySet()){
        //     send_store.addAll(e.getValue());
        // }
        return send_store;
    }

    static int add( int a, int b , List<Integer> arr){

        return 0 ;
    }

    public static void main(String[] args) {

        int start = 0;
        int k = 4;
        int[] rr = new int [2];
        System.out.println( rr.length);

        List<Integer> arr = new ArrayList<>();

        arr.add(1);
        arr.add(2);
        arr.add(3);
        arr.add(4);
        arr.add(5);
        arr.add(6);

        ArrayList<Integer> num = new ArrayList<>();

        List<List<Integer>> store = new ArrayList<>();
        store.add(num);
        store = getCombination(arr, store, start, k, 0);
        System.out.println(store);
        int min = Integer.MAX_VALUE;
        System.out.println(store.size());
        // for( List<Integer> l : store ){
            
        // }
    }
}
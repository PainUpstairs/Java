import java.util.*;

class javaTemp {

    public static void main(String[] args) {
        // ArrayList<Map<Integer,Integer>> a = new ArrayList<>();
        // Map<Integer,Integer> b = new HashMap<Integer,Integer>();
        // b.put(1, 1);
        // a.add(new HashMap<Integer,Integer>(b));
        // a.add(new HashMap<Integer,Integer>(b));
        // a.add(new HashMap<Integer,Integer>(b));
        // a.add(new HashMap<Integer,Integer>(b));
        
        // a.get(2).put(2,3);

        // for (Map<Integer,Integer> map : a) {
        //     for(Map.Entry<Integer, Integer> e : map.entrySet()){
        //         System.out.println(e.getKey()+"->"+e.getValue());
        //     }
        // }
        // System.out.println(a.get(2).containsKey(3)+"\n");

        // Set<Integer> set = new HashSet<>();

        // set.add(1);
        // set.add(100);
        // set.add(19);
        // set.add(1);
        // set.add(19);
        // set.add(69);

        // for (Integer i : set) {
        //     System.out.println(i);
        // }


        // Set<Integer> set1 = new HashSet<>();

        
        // set1.add(1);
        // set1.add(19);
        // set1.add(69);
        // set.removeAll(set1);
        // System.out.println("THis->"+set);

        String s = "BOT";
        String b = "BIT";


        System.out.println("yehwala"+s.contains("o"));
        s = s.replace("A", "");
        System.out.println();
        
        String[] temp_s = s.split("");
        String[] temp_b = b.split("");
        ArrayList<String> strlist = new ArrayList<>(Arrays.asList(temp_s));
        ArrayList<String> strlist1 = new ArrayList<>(Arrays.asList(temp_s));
        

         Set<String> se = new HashSet<>(); 

         se.addAll(strlist);
         se.addAll(strlist1);

        System.out.println(se);

        for (String q : strlist) {
            System.out.println(q);
            
        }

//         Map<Integer,ArrayList<Integer>> b = new HashMap<>();
//         ArrayList<Integer> t = new ArrayList<>();
// t.add(1);
//         b.put(1,t);

//         b.getOrDefault(2, )


        int[] w = {1,2,3,4,5};
        System.out.print(w.length);
        
        
        // Set<Integer> mySet = new HashSet<>(Arrays.asList(w));
    }
}

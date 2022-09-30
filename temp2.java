import java.util.*;

class temp2 {

    static public List<List<String>> finalAnswer(String a, Map<String, List<String>> graph, Map<String, Boolean> lock,
            List<List<String>> answer, String endWord) {
        if (endWord == a)
            return answer;

        boolean _endFlag = true;


        Map<String, Boolean> lock_new = new HashMap<>(lock); 

        Map<String, List<List<String>>> parallel = new HashMap<>();

        for (String s : graph.get(a)) {
            System.out.println(s);
            if (lock.get(s)) {
                //Termination if did not get here
                _endFlag = false;
                //locking the visited node 
                lock_new.put(s, false);

                // making a deep copy of the incoming array(very tough)
                parallel.put(s, Arrays.asList(new ArrayList<String>(answer.get(0))));
                // adding new element
                parallel.get(s).get(0).add(s);

                // getting the elements from the children  
                parallel.put(s, finalAnswer(s, graph, lock_new, parallel.get(s), endWord));
                System.out.println();
            }
        }

        if (_endFlag) {
            answer = new ArrayList<>();
            return answer;
        }

        List<List<String>> send_answer = new ArrayList<>();

        // combining the list at this level 
        for (String s : graph.get(a)) {
            if (parallel.containsKey(s)) {
                for (List<String> l : parallel.get(s)) {
                    if (!l.isEmpty())
                        send_answer.add(l);
                }
            }
        }
        return send_answer;
    }

    public static void main(String[] args) {
        List<List<String>> answer = new ArrayList<>();
        List<String> v = new ArrayList<>();

        answer.add(v);
        Map<String, List<String>> graph = new HashMap<>();
        Map<String, Boolean> lock = new HashMap<>();
        lock.put("hit", false);
        lock.put("lot", true);
        lock.put("hot", true);
        lock.put("dot", true);
        lock.put("log", true);
        lock.put("cog", true);
        lock.put("dog", true);

        graph.put("hit", Arrays.asList("hot"));
        graph.put("lot", Arrays.asList("hot", "dot", "log"));
        graph.put("log", Arrays.asList("dog", "lot", "cog"));
        graph.put("dot", Arrays.asList("hot", "dog", "lot"));
        graph.put("cog", Arrays.asList("dog", "log"));
        graph.put("hot", Arrays.asList("dot", "lot"));
        graph.put("dog", Arrays.asList("dot", "log", "cog"));

        for(String s : graph.get("hit")){
            System.out.println(s);
        }
        System.out.println("\n\n\n");

        answer = finalAnswer("hit", graph, lock, answer, "cog");

        int min = Integer.MAX_VALUE;
        for( List<String> l : answer){
            if( l.size() < min ) min = l.size();
        }


        List<List<String>> _answer = new ArrayList<>();


        for( List<String> l : answer){
            if( !(l.size()>min)) _answer.add(l);
        }
        for (List<String> s : _answer) {
            System.out.println(s);
        }
    }

}
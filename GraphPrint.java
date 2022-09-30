import java.util.*;

public class GraphPrint {
    static public List<List<String>> GraphPathDFS(String a, Map<String, List<String>> graph, List<List<String>> answer,
            Map<String, Boolean> lock) {

        List<List<String>> send_answer = new ArrayList<>();
        Map<String,Boolean> new_lock = new HashMap<>(lock);
        new_lock.put(a, false);

        boolean _flag = true;
        for (String s : graph.get(a)) {
            if(lock.get(s)){
                _flag = false;
                List<List<String>> temp = new ArrayList<>(Arrays.asList(new ArrayList<>(answer.get(0))));
                temp.get(0).add(s);
                send_answer.addAll(GraphPathDFS(s, graph, temp, new_lock));
            }
        }

        if( _flag) return answer;
        return send_answer;
    }


    static public List<List<String>> GraphPathBFS(Map<String, List<String>> graph, List<List<String>> answer, String endWord) {
    
        List<List<String>> send_answer = new ArrayList<>();

        boolean complete = true;
        // boolean reached = false;
        for( List<String> l : answer){
            String last_ele = l.get(l.size()-1);
            for ( String s : graph.get(last_ele)){
                // if( s.equals(endWord)) reached = true;
                if( !l.contains(s)){
                    complete = false;
                    List<String> temp = new ArrayList<>(l);;
                    temp.add(s);
                    send_answer.add(temp);
                }
                
            }
        }

        for( List<String> l : send_answer) System.out.println(l);
        System.out.println("\n");

        if( complete ) return answer;
        else send_answer = GraphPathBFS(graph, send_answer, endWord);

        return send_answer;
    }
    public static void main(String[] args) {
        Map<String, List<String>> graph = new HashMap<>();
        Map<String, Boolean> lock = new HashMap<>();
        List<List<String>> answer1 = new ArrayList<>();
        List<List<String>> answer2 = new ArrayList<>();
        Map<String, List<List<String>>> answer_temp = new HashMap<>();

        // graph.put("A", Arrays.asList("B", "C", "D"));
        // graph.put("B", Arrays.asList("A", "C", "D", "E"));
        // graph.put("C", Arrays.asList("A", "B", "F"));
        // graph.put("D", Arrays.asList("A", "C", "G"));
        // graph.put("E", Arrays.asList("B", "F", "G"));
        // graph.put("F", Arrays.asList("C", "E", "G"));
        // graph.put("G", Arrays.asList("D", "E", "F"));

        // lock.put("A", true);
        // lock.put("B", true);
        // lock.put("C", true);
        // lock.put("D", true);
        // lock.put("E", true);
        // lock.put("F", true);
        // lock.put("G", true);

        graph.put("A", Arrays.asList("B", "C"));
        graph.put("B", Arrays.asList("D", "A"));
        graph.put("C", Arrays.asList("D", "A"));
        graph.put("D", Arrays.asList("B", "C", "E"));
        graph.put("E", Arrays.asList("D"));

        lock.put("A", true);
        lock.put("B", true);
        lock.put("C", true);
        lock.put("D", true);
        lock.put("E", true);

        String start = "A";
        String end = "D";

        answer1.add(Arrays.asList(start));

        // answer1 = GraphPathDFS(start, graph, answer1, lock);
        // answer_temp.put(start,Arrays.asList(Arrays.asList(start)));
        answer2.add(new ArrayList<>(Arrays.asList("A")));
        answer2 = GraphPathBFS(graph, answer2, end);

        // System.out.println("DFS->");
        // for( List<String> l : answer1)
        //     System.out.println(l);

        System.out.println("BFS->");
        for( List<String> l : answer2)
            System.out.println(l);

        List<String> temp = new ArrayList<>();
        // List<String> arr = new ArrayList<>(Arrays.asList("A"));
        // arr.add("b");
        // System.out.println(arr);

        // ArrayList<String> arr = new ArrayList<>(Arrays.asList("A"));
        // List<String> arr1 = new ArrayList<>(Arrays.asList("A"));
        // System.out.println(arr);
        // System.out.println(arr1);

        // Map<String, List<String>> map = new HashMap<>();

        // map.put("A", Arrays.asList("B"));
        // map.getOrDefault("B", map.put("B", Arrays.asList("C"))).add("C");
        // map.getOrDefault("A", map.put("B", Arrays.asList("C"))).add("C");

        // System.out.println(map);
        


        // System.out.println(graph.get("A").get(0).getClass().getSimpleName());
        // System.out.println(graph.get("A").get(1).getClass().getSimpleName());
    }
}

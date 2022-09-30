import java.util.*;

class temp3 {

    static public List<List<String>> finalAnswer(Map<String, List<String>> graph, List<List<String>> answer,
            String endWord) {

        List<List<String>> send_answer = new ArrayList<>();

        boolean complete = true;
        boolean reached = false;
        for (List<String> l : answer) {
            String last_ele = l.get(l.size() - 1);
            boolean DintContain = true;
            if (graph.containsKey(last_ele))
                for (String s : graph.get(last_ele)) {
                    if (s.equals(endWord))
                        reached = true;
                    if (!l.contains(s)) {
                        DintContain = false;
                        complete = false;
                        List<String> temp = new ArrayList<>(l);
                        ;
                        temp.add(s);
                        send_answer.add(temp);
                    }

                }

            if (DintContain)
                send_answer.add(l);
        }

        if (complete)
            return answer;
        else if (reached)
            return send_answer;
        else
            send_answer = finalAnswer(graph, send_answer, endWord);

        return send_answer;
    }

    static boolean diff(String a, String b) {
        int count = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) == b.charAt(i))
                count++;
        }
        if ((a.length() - count) == 1)
            return true;
        return false;
    }

    static public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {

        List<List<String>> answer = new ArrayList<>();
        if (!wordList.contains(endWord))
            return answer;

        Map<String, List<String>> graph = new HashMap<>();
        if (!wordList.contains(beginWord))
            wordList.add(beginWord);

        for (String s : wordList) {
            for (String com : wordList) {
                if (!s.equals(com)) {
                    boolean connection = diff(s, com);
                    if (connection) {
                        if (graph.containsKey(s))
                            graph.get(s).add(com);
                        else
                            graph.put(s, new ArrayList<>(Arrays.asList(com)));
                    }
                }
            }
        }

        for( String e : graph.keySet()){
            System.out.println(e+"->"+ graph.get(e));


        }

        // if (graph.size() == 0)
        //     return answer;

        // answer.add(new ArrayList<>(Arrays.asList(beginWord)));
        // answer = new ArrayList<>(finalAnswer(graph, answer, endWord));

        
        // List<List<String>> send_answer = new ArrayList<>();

        // for (List<String> l : answer) {
        //     int len = l.size() - 1;
        //     if (l.get(len).equals(endWord))
        //         send_answer.add(l);
        // }

        return answer;
    }

    public static void main(String[] args) {
        String beginWord = "cet";
        String endWord = "ism";
        ArrayList<String> wordList = new ArrayList<>(
                Arrays.asList("kid","tag","pup","ail","tun","woo","erg","luz","brr","gay","sip","kay","per","val","mes","ohs","now","boa","cet","pal","bar","die","war","hay","eco","pub","lob","rue","fry","lit","rex","jan","cot","bid","ali","pay","col","gum","ger","row","won","dan","rum","fad","tut","sag","yip","sui","ark","has","zip","fez","own","ump","dis","ads","max","jaw","out","btu","ana","gap","cry","led","abe","box","ore","pig","fie","toy","fat","cal","lie","noh","sew","ono","tam","flu","mgm","ply","awe","pry","tit","tie","yet","too","tax","jim","san","pan","map","ski","ova","wed","non","wac","nut","why","bye","lye","oct","old","fin","feb","chi","sap","owl","log","tod","dot","bow","fob","for","joe","ivy","fan","age","fax","hip","jib","mel","hus","sob","ifs","tab","ara","dab","jag","jar","arm","lot","tom","sax","tex","yum","pei","wen","wry","ire","irk","far","mew","wit","doe","gas","rte","ian","pot","ask","wag","hag","amy","nag","ron","soy","gin","don","tug","fay","vic","boo","nam","ave","buy","sop","but","orb","fen","paw","his","sub","bob","yea","oft","inn","rod","yam","pew","web","hod","hun","gyp","wei","wis","rob","gad","pie","mon","dog","bib","rub","ere","dig","era","cat","fox","bee","mod","day","apr","vie","nev","jam","pam","new","aye","ani","and","ibm","yap","can","pyx","tar","kin","fog","hum","pip","cup","dye","lyx","jog","nun","par","wan","fey","bus","oak","bad","ats","set","qom","vat","eat","pus","rev","axe","ion","six","ila","lao","mom","mas","pro","few","opt","poe","art","ash","oar","cap","lop","may","shy","rid","bat","sum","rim","fee","bmw","sky","maj","hue","thy","ava","rap","den","fla","auk","cox","ibo","hey","saw","vim","sec","ltd","you","its","tat","dew","eva","tog","ram","let","see","zit","maw","nix","ate","gig","rep","owe","ind","hog","eve","sam","zoo","any","dow","cod","bed","vet","ham","sis","hex","via","fir","nod","mao","aug","mum","hoe","bah","hal","keg","hew","zed","tow","gog","ass","dem","who","bet","gos","son","ear","spy","kit","boy","due","sen","oaf","mix","hep","fur","ada","bin","nil","mia","ewe","hit","fix","sad","rib","eye","hop","haw","wax","mid","tad","ken","wad","rye","pap","bog","gut","ito","woe","our","ado","sin","mad","ray","hon","roy","dip","hen","iva","lug","asp","hui","yak","bay","poi","yep","bun","try","lad","elm","nat","wyo","gym","dug","toe","dee","wig","sly","rip","geo","cog","pas","zen","odd","nan","lay","pod","fit","hem","joy","bum","rio","yon","dec","leg","put","sue","dim","pet","yaw","nub","bit","bur","sid","sun","oil","red","doc","moe","caw","eel","dix","cub","end","gem","off","yew","hug","pop","tub","sgt","lid","pun","ton","sol","din","yup","jab","pea","bug","gag","mil","jig","hub","low","did","tin","get","gte","sox","lei","mig","fig","lon","use","ban","flo","nov","jut","bag","mir","sty","lap","two","ins","con","ant","net","tux","ode","stu","mug","cad","nap","gun","fop","tot","sow","sal","sic","ted","wot","del","imp","cob","way","ann","tan","mci","job","wet","ism","err","him","all","pad","hah","hie","aim"));
        // System.out.println(wordList);
        List<List<String>> temp = findLadders(beginWord, endWord, wordList);

        // System.out.println("Answer");
        // for (List<String> list : temp) {
        //     System.out.println(list);
        // }
        // System.out.println(temp);

        // for( List<String> l : temp){
        // for( String s : l){
        // System.out.print(s+" ");
        // }
        // System.out.println();
        // }
    }
}

/// test questions

/*
 * "hit"
 * "cog"
 * ["hot","dot","dog","lot","log","cog"]
 * "talk"
 * "tail"
 * "cet"
"ism"
["kid","tag","pup","ail","tun","woo","erg","luz","brr","gay","sip","kay","per","val","mes","ohs","now","boa","cet","pal","bar","die","war","hay","eco","pub","lob","rue","fry","lit","rex","jan","cot","bid","ali","pay","col","gum","ger","row","won","dan","rum","fad","tut","sag","yip","sui","ark","has","zip","fez","own","ump","dis","ads","max","jaw","out","btu","ana","gap","cry","led","abe","box","ore","pig","fie","toy","fat","cal","lie","noh","sew","ono","tam","flu","mgm","ply","awe","pry","tit","tie","yet","too","tax","jim","san","pan","map","ski","ova","wed","non","wac","nut","why","bye","lye","oct","old","fin","feb","chi","sap","owl","log","tod","dot","bow","fob","for","joe","ivy","fan","age","fax","hip","jib","mel","hus","sob","ifs","tab","ara","dab","jag","jar","arm","lot","tom","sax","tex","yum","pei","wen","wry","ire","irk","far","mew","wit","doe","gas","rte","ian","pot","ask","wag","hag","amy","nag","ron","soy","gin","don","tug","fay","vic","boo","nam","ave","buy","sop","but","orb","fen","paw","his","sub","bob","yea","oft","inn","rod","yam","pew","web","hod","hun","gyp","wei","wis","rob","gad","pie","mon","dog","bib","rub","ere","dig","era","cat","fox","bee","mod","day","apr","vie","nev","jam","pam","new","aye","ani","and","ibm","yap","can","pyx","tar","kin","fog","hum","pip","cup","dye","lyx","jog","nun","par","wan","fey","bus","oak","bad","ats","set","qom","vat","eat","pus","rev","axe","ion","six","ila","lao","mom","mas","pro","few","opt","poe","art","ash","oar","cap","lop","may","shy","rid","bat","sum","rim","fee","bmw","sky","maj","hue","thy","ava","rap","den","fla","auk","cox","ibo","hey","saw","vim","sec","ltd","you","its","tat","dew","eva","tog","ram","let","see","zit","maw","nix","ate","gig","rep","owe","ind","hog","eve","sam","zoo","any","dow","cod","bed","vet","ham","sis","hex","via","fir","nod","mao","aug","mum","hoe","bah","hal","keg","hew","zed","tow","gog","ass","dem","who","bet","gos","son","ear","spy","kit","boy","due","sen","oaf","mix","hep","fur","ada","bin","nil","mia","ewe","hit","fix","sad","rib","eye","hop","haw","wax","mid","tad","ken","wad","rye","pap","bog","gut","ito","woe","our","ado","sin","mad","ray","hon","roy","dip","hen","iva","lug","asp","hui","yak","bay","poi","yep","bun","try","lad","elm","nat","wyo","gym","dug","toe","dee","wig","sly","rip","geo","cog","pas","zen","odd","nan","lay","pod","fit","hem","joy","bum","rio","yon","dec","leg","put","sue","dim","pet","yaw","nub","bit","bur","sid","sun","oil","red","doc","moe","caw","eel","dix","cub","end","gem","off","yew","hug","pop","tub","sgt","lid","pun","ton","sol","din","yup","jab","pea","bug","gag","mil","jig","hub","low","did","tin","get","gte","sox","lei","mig","fig","lon","use","ban","flo","nov","jut","bag","mir","sty","lap","two","ins","con","ant","net","tux","ode","stu","mug","cad","nap","gun","fop","tot","sow","sal","sic","ted","wot","del","imp","cob","way","ann","tan","mci","job","wet","ism","err","him","all","pad","hah","hie","aim"]
 * ["talk","tons","fall","tail","gale","hall","negs"]
 * "hit"
 * "cog"
 * ["hot","dot","dog","lot","log"]
 */
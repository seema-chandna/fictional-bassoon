import java.util.*;

/**
 * @author schandna created on 18/07/20
 */
public class ReconstructItinerary {

    /*
    public List<String> findItinerary(List<List<String>> tickets) {

        Map<String, Set<String>> tickMap = new HashMap<>();
        tickets.forEach( ticket -> {
            Set<String> toList = tickMap.getOrDefault(ticket.get(0), new TreeSet<>());
            toList.add(ticket.get(1));
            tickMap.put(ticket.get(0), toList);
        });

        String word = "JFK";
        List<String> res = new ArrayList<>();
        while(!tickMap.isEmpty()){

            res.add(word);
            Set<String> toList = tickMap.get(word);
            if(toList != null){
                String to = null;
                Iterator itr = toList.iterator();
                if(itr.hasNext()){
                    to = (String) itr.next();
                }

                toList.remove(to);
                if(toList.isEmpty()){
                    tickMap.remove(word);
                } else {
                    tickMap.put(word, toList);
                }
                word = to;

            } else {
                break;
            }
        }
        res.add(word);
        return res;
    }*/

/*    public List<String> findItinerary(List<List<String>> tickets) {

        Map<String, List<String>> tickMap = new HashMap<>();
        tickets.forEach( ticket -> {
            List<String> toList = tickMap.getOrDefault(ticket.get(0), new ArrayList<>());
            toList.add(ticket.get(1));
            Collections.sort(toList);
            tickMap.put(ticket.get(0), toList);
        });

        String word = "JFK";
        List<String> res = new ArrayList<>();

        Stack<String> stk = new Stack<>();
        findItineraryDfs(tickMap, stk, word, tickets.size(), new ArrayList<>());

        while (!stk.isEmpty()) {
            res.add(stk.pop());
        }
        return res;
    }

    boolean findItineraryDfs(Map<String, List<String>> tickMap, Stack<String>  res, String word, int size, List<Pair> visited){

        if(visited.size() == size){
            res.add(word);
            return true;
        }

        List<String> toList = tickMap.get(word);

        if(toList != null){

            for(String to : toList){

                Pair tick = new Pair(word, to);

                if(!visited.contains(tick)) {
                    visited.add(tick);
                    if(findItineraryDfs(tickMap, res, to, size, visited)) {
                        res.add(word);
                        return true;
                    }
                    visited.remove(tick);
                }

            }
        }
        return false;
    }*/

    Map<String, PriorityQueue<String>> ticketMap;
    LinkedList<String> res;

    public List<String> findItinerary(List<List<String>> tickets) {
        // Initialization
        ticketMap = new HashMap<>();
        res = new LinkedList<>();

        // build graph
        for (List<String> ticket : tickets) {
//            ticketMap.putIfAbsent(ticket.get(0), new PriorityQueue<>());
//            ticketMap.get(ticket.get(0)).add(ticket.get(1));
            ticketMap.computeIfAbsent(ticket.get(0),  d -> new PriorityQueue<>()).add(ticket.get(1));
        }
        dfs("JFK");// dfs call from starting airport JFK
        return res;
    }

    public void dfs(String departure) {
        PriorityQueue<String> arrivals = ticketMap.get(departure);
        while (arrivals != null && !arrivals.isEmpty())
            dfs(arrivals.poll());
        res.addFirst(departure);
    }

    public static void main(String[] args) {
        ReconstructItinerary itinerary = new ReconstructItinerary();

//        List<List<String>> tickets = new ArrayList<>();
//        tickets.add(Arrays.asList(new String [] {"MUC","LHR"}));
//        tickets.add(Arrays.asList(new String [] {"JFK","MUC"}));
//        tickets.add(Arrays.asList(new String [] {"SFO","SJC"}));
//        tickets.add(Arrays.asList(new String [] {"LHR","SFO"}));
//        System.out.println(itinerary.findItinerary(tickets));

//        List<List<String>> tickets2 = new ArrayList<>();
//        tickets2.add(Arrays.asList(new String [] {"JFK","KUL"}));
//        tickets2.add(Arrays.asList(new String [] {"JFK","NRT"}));
//        tickets2.add(Arrays.asList(new String [] {"NRT","JFK"}));
//        System.out.println(itinerary.findItinerary(tickets2)); // ["JFK","NRT","JFK","KUL"]

        List<List<String>> tickets4 = new ArrayList<>();
        tickets4.add(Arrays.asList(new String [] {"JFK","KUL"}));
        tickets4.add(Arrays.asList(new String [] {"JFK","ABC"}));
        tickets4.add(Arrays.asList(new String [] {"JFK","NRT"}));
        tickets4.add(Arrays.asList(new String [] {"NRT","JFK"}));
        tickets4.add(Arrays.asList(new String [] {"JFK","DEF"}));
        tickets4.add(Arrays.asList(new String [] {"DEF","JFK"}));
        System.out.println(itinerary.findItinerary(tickets4)); // ["JFK","NRT","JFK","KUL"]

        List<List<String>> tickets3 = new ArrayList<>();
        tickets3.add(Arrays.asList(new String [] {"EZE","AXA"}));
        tickets3.add(Arrays.asList(new String [] {"TIA","ANU"}));
        tickets3.add(Arrays.asList(new String [] {"ANU","JFK"}));
        tickets3.add(Arrays.asList(new String [] {"JFK","ANU"}));
        tickets3.add(Arrays.asList(new String [] {"ANU","EZE"}));
        tickets3.add(Arrays.asList(new String [] {"TIA","ANU"}));
        tickets3.add(Arrays.asList(new String [] {"AXA","TIA"}));
        tickets3.add(Arrays.asList(new String [] {"TIA","JFK"}));
        tickets3.add(Arrays.asList(new String [] {"ANU","TIA"}));
        tickets3.add(Arrays.asList(new String [] {"JFK","TIA"}));
        System.out.println(itinerary.findItinerary(tickets3)); // ["JFK","ANU","EZE","AXA","TIA","ANU","JFK","TIA","ANU","TIA","JFK"]


    }
}

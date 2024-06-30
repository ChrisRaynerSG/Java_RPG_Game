package gameloop;

import java.util.*;

public class Collections {
    public static void main(String[] args) {
        PriorityQueue<Integer> wildcardQueue = new PriorityQueue<>();
        List<String> stringList = new LinkedList<>();
        Set<String> stringSet = new HashSet<>();
        Map<Integer, String> intStringMap = new HashMap<>();

        for(int i = 0; i<101; i++){
            wildcardQueue.add(i);
        }

        while(!wildcardQueue.isEmpty()){
            System.out.println(wildcardQueue.poll());
        }

        //comparable //comparator

        intStringMap.put(1, "Hello");
        intStringMap.put(0, "Good Morning");
        intStringMap.put(9, "VeryLate");

        for (int i = 0; i < 100; i++){
            stringSet.add("number " + i);
        }  //Sets unordered

        for(String string : stringSet){
            System.out.println(string);
        }

        for (int i = 0; i < intStringMap.size(); i++) {
            System.out.println(intStringMap.get(i));
            System.out.println(intStringMap.keySet());
        }

        for(Iterator<Map.Entry<Integer,String>> iterator = intStringMap.entrySet().iterator(); iterator.hasNext();){
            Map.Entry<Integer,String> m = iterator.next();
            System.out.println(m.getKey() + " " + m.getValue());
        }
    }
}

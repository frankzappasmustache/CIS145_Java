import java.util.*;

         public class ReadingCode {

             public static void main(String[] args) {
                 Map<Integer, List<String>> map = new TreeMap<Integer, List<String>>();
                 List<String> list1 = new ArrayList<String>();
                 list1.add("hello");
                 list1.add("hi");
                 map.put(3, list1);

                 List<String> list2 = new ArrayList<String>();
                 list2.add("howdy");
                 list2.add("hello");
                 list2.add("hola");
                 map.put(2, list2);

                 List<String> list3 = new ArrayList<String>();
                 list3.add("hi");
                 map.put(4, list3);

                 readMaps(map);
             }

             public static void readMaps(Map<Integer, List<String>> map) {
                 for(int k : map.keySet()) {
                     for(String s : map.get(k)) {
                         for(int i = 0; i < k; i++) {
                             System.out.println(s);
                         }
                     }
                     System.out.println();
                 }
             }
         }

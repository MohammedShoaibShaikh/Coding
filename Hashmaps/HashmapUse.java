package Hashmaps;

import java.util.HashMap;

public class HashmapUse {
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();

        // insert
        map.put("abc", 10);
        map.put("Shoaib", 20);
        map.put("shoaib", 30);

        // Size of Map
        System.out.println("Size of Map: " + map.size());

        // Printing Elements in Objects of Map
        System.out.println(map);
    }
}

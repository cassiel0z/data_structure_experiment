package exp5;

import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeMap;
import java.util.TreeSet;

public class problem2 {
    public static void main(String[] args) {

        HashMap<String,Integer> hmap=new HashMap<>();
        HashSet<Integer> hset=new HashSet<>();
        TreeMap<String,Integer> tmap=new TreeMap<>();
        TreeSet<Integer> tset=new TreeSet<>();

        hmap.put("class1",40);
        hmap.put("class2",50);
        hmap.put("class3",38);
        hmap.put("class4",47);
        hmap.put("class5",46);
        hmap.put("class6",42);
        hmap.remove("class1");
        hmap.remove("class2");

        hset.add(46);
        hset.add(47);
        hset.add(41);
        hset.add(50);
        hset.add(30);
        hset.add(100);
        hset.remove(47);
        hset.remove(46);

        tmap.put("class1",40);
        tmap.put("class2",50);
        tmap.put("class3",38);
        tmap.put("class4",47);
        tmap.put("class5",46);
        tmap.put("class6",42);
        tmap.remove("class1");
        tmap.remove("class2");

        tset.add(46);
        tset.add(47);
        tset.add(41);
        tset.add(50);
        tset.add(30);
        tset.add(100);
        tset.remove(47);
        tset.remove(46);

        System.out.println(hmap);
        System.out.println(hset);
        System.out.println(tmap);
        System.out.println(tset);
    }
}

package exp4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.TreeMap;

public class problem3 {
    public static void main(String[] args) {
        try {
            BufferedReader in = new BufferedReader(new FileReader("./src/main/java/exp4/problem3.txt"));
            TreeMap<String, Integer> wordsCounter = new TreeMap<>();
            String str;
            while (in.ready()) {
                str = in.readLine().toLowerCase().replaceAll("\\p{Punct}", "");
                String[] words = str.split(" ");
                for (String x : words) {
                    if(!wordsCounter.containsKey(x)) wordsCounter.put(x,1);
                    else wordsCounter.replace(x, wordsCounter.get(x)+1);
                }
                System.out.println(wordsCounter);
            }
            in.close();
        } catch (IOException ignored) {
        }
    }
}

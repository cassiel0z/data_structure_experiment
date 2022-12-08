package exp9;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        String s="Every year, TED works with a group of select companies and foundations to identify internal ideators, inventors, connectors and creators. Drawing on the same rigorous regimen that has prepared speakers for the TED main stage, TED Institute works closely with each partner, overseeing curation and fact-checking and providing intensive one-on-one talk development to sharpen and finetune ideas. The culmination is an event that is produced, filmed and hosted by TED, generating a growing library of valuable, vetted TED Talks that showcase original research, spur innovation and can transform organizations.";
        Map<String,Integer> letterMap=countLetter(s);
        HuffmanTree t=new HuffmanTree();

        for (Map.Entry<String, Integer> entry : letterMap.entrySet()) {
            t.addNode(entry.getKey(), entry.getValue());
        }

        Map<String,String> codeTable=t.GetHuffmanCodes();

        print(codeTable,s);
    }

    public static void print(Map<String,String> codeTable,String str){
        for(int i=0;i<str.length();i++){
            String s=str.substring(i,i+1);
            System.out.print(codeTable.get(s));
        }
    }

    public static Map<String,Integer> countLetter(String str){
        Map<String,Integer> letterMap=new HashMap<>();
        for(int i=0;i<str.length();i++){
            String s=str.substring(i,i+1);
            if(!letterMap.containsKey(s)){
                letterMap.put(s,1);
            }
            else{
                int tmp=letterMap.get(s);
                letterMap.remove(s);
                letterMap.put(s,tmp+1);
            }

        }
        return letterMap;
    }

}

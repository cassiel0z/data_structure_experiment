package exp9;

import java.util.*;

public class HuffmanTree {
    List<Node> forest;

    public HuffmanTree(){
        forest=new LinkedList<>();
    }

    public void addNode(String data,int weight){
        forest.add(new Node(data,weight));
    }

    public Map<String,String> GetHuffmanCodes(){
        //构造哈夫曼树
        Node root=BuildHuffmanTree();
        //根据哈夫曼树进行编码
        Map<String,String> codeTable=new HashMap<String, String>();
        GetHuffmanCodes(root,"",codeTable);
        return codeTable;
    }

    private Node BuildHuffmanTree(){
        if(forest.size()==0)
            return null;

        while(forest.size()>1){
            forest.sort(Comparator.comparingInt(a -> a.weight));
            Node left=forest.get(0);
            Node right=forest.get(1);
            Node parent = new Node(null,left.weight+right.weight,left,right);
            forest.remove(0);
            forest.remove(0);
            forest.add(parent);
        }

        return forest.get(0);

    }

    private void GetHuffmanCodes(Node root,String pathCode,Map<String,String> codeTable){
        if(root.isLeaf()){
            codeTable.put(root.data,pathCode);
            return;
        }
        GetHuffmanCodes(root.left,pathCode+"0",codeTable);
        GetHuffmanCodes(root.right,pathCode+"1",codeTable);
    }


    class Node{
        private String data;
        private int weight;
        private Node left;
        private Node right;

        public Node(){

        }

        public Node(String data, int weight, Node left, Node right) {
            this.data=data;
            this.weight=weight;
            this.left=left;
            this.right=right;
        }

        public Node(String data,int weight){
            this.data=data;
            this.weight=weight;
            this.left=null;
            this.right=null;
        }

        public boolean isLeaf(){
            return left==null&&right==null;
        }
    }
}

package exp8;

public class problem3 {
    public static void main(String[] args) {
        String[] names={"A","B","C","D","E","F"};
        Graph_prim g=new Graph_prim(names);
        g.addEdge("A","D",30);
        g.addEdge("A","C",5);
        g.addEdge("B","A",2);
        g.addEdge("B","E",8);
        g.addEdge("C","B",15);
        g.addEdge("C","F",7);
        g.addEdge("E","D",4);
        g.addEdge("F","D",10);
        g.prim();

        for (Graph_prim.Vertex v:g.vertices){
            boolean flag=true;

            for (Graph_prim.Vertex w:g.vertices){
                if(w.path==v)
                    flag=false;
            }
            if (flag){
                g.printPath(v);
                System.out.println();
            }

        }
    }
}

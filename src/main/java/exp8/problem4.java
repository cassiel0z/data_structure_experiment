package exp8;

public class problem4 {
    public static void main(String[] args) {
        String[] names = {"A", "B", "C", "D", "E", "F"};
        Graph_kruskal g = new Graph_kruskal(names);
        g.addEdge("A","D",30);
        g.addEdge("A","C",5);
        g.addEdge("B","A",2);
        g.addEdge("B","E",8);
        g.addEdge("C","B",15);
        g.addEdge("C","F",7);
        g.addEdge("E","D",4);
        g.addEdge("F","D",10);

        for(Graph_kruskal.Edge e:g.kruskal()){
            System.out.println(e.u+" to "+e.v);
        }

    }
}

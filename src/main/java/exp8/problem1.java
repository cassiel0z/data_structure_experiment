package exp8;

public class problem1 {
    public static void main(String[] args) {
        String[] names={"A","B","C","D","E","F"};
        Graph_topo g=new Graph_topo(names);
        g.addEdge("A","C");
        g.addEdge("A","D");
        g.addEdge("C","B");
        g.addEdge("C","F");
        g.addEdge("F","E");
        g.addEdge("B","E");
        g.addEdge("E","D");
        g.addEdge("F","D");
        System.out.println(g.topSort());
    }
}

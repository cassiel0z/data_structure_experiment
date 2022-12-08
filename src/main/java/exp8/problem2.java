package exp8;

public class problem2 {
    public static void main(String[] args) {
        String[] names={"A","B","C","D","E","F"};
        Graph_dijkstra g=new Graph_dijkstra(names);
        g.addEdge("A","D",30);
        g.addEdge("A","C",5);
        g.addEdge("B","A",2);
        g.addEdge("B","E",8);
        g.addEdge("C","B",15);
        g.addEdge("C","F",7);
        g.addEdge("E","D",4);
        g.addEdge("F","D",10);
        g.dijkstra(g.vertices.get(0));

        for (Graph_dijkstra.Vertex v: g.vertices){
            System.out.print(v.name+":");
            g.printPath(v);
            System.out.println();
            System.out.println("dist="+g.calculateDist(v));
        }
    }
}

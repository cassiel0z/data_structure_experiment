package exp8;

public class problem6 {
    public static void main(String[] args) {
        String[] names={"A","B","C","D","E","F"};
        Graph_dfs_bfs g=new Graph_dfs_bfs(names);
        g.addEdge("A","D");
        g.addEdge("A","C");
        g.addEdge("B","A");
        g.addEdge("B","E");
        g.addEdge("C","B");
        g.addEdge("C","F");
        g.addEdge("E","D");
        g.addEdge("F","D");
        g.bfs();


        for (Graph_dfs_bfs.Vertex v:g.vertices){
            boolean flag=true;

            for (Graph_dfs_bfs.Vertex w:g.vertices){
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

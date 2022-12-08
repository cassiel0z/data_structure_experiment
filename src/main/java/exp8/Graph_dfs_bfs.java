package exp8;

import java.util.*;

public class Graph_dfs_bfs {

    public ArrayList<Vertex> vertices;

    Graph_dfs_bfs(String[] verteNames) {
        vertices = new ArrayList<>();
        for (String verteName : verteNames) {
            vertices.add(new Vertex(verteName));
        }
    }

    public void addEdge(String from, String to) {
        Vertex vfrom = null, vto = null;
        for (Vertex vertice : vertices) {
            if (Objects.equals(vertice.name, from)) vfrom = vertice;
            if (Objects.equals(vertice.name, to)) vto = vertice;
        }

        //无向图两边都添加进邻接表
        vfrom.AdjacentTo(vto);
        vto.AdjacentTo(vfrom);

    }

    public void dfs() {
        //初始化所有顶点
        for (Vertex v : vertices) {
            v.visited = false;
            v.path = null;
        }
        Dfs(vertices.get(0));
    }

    private void Dfs(Vertex v) {

        v.visited = true;

        for (Vertex w : v.adj) {
            if (!w.visited) {
                w.path = v;
                Dfs(w);
            }
        }
    }

    public void bfs() {
        //初始化所有顶点
        for (Vertex v : vertices) {
            v.visited = false;
            v.path = null;
            v.traversed=false;
        }

        vertices.get(0).visited = true;

        while(hasUnsolved()){

            Vertex v;

            for(Vertex w:vertices) {
                if (w.visited && !w.traversed){

                    v = w;

                    for(Vertex u:v.adj){
                        if(!u.visited){
                            u.visited=true;
                            u.path=v;
                        }
                    }

                    v.traversed=true;

                }

            }

        }

    }

    //判断图是否还未完全解决
    private boolean hasUnsolved() {
        for (Vertex v : vertices)
            if (!v.visited || !v.traversed)
                return true;
        return false;
    }

    public void printPath(Vertex v) {
        if (v.path != null) {
            printPath(v.path);
            System.out.print(" to ");
        }
        System.out.print(v.name);
    }


    class Vertex {
        public String name;
        public List<Vertex> adj;
        public boolean visited;
        public boolean traversed;
        public Vertex path;

        Vertex(String name) {
            this.name = name;
            adj = new LinkedList<>();
            visited = false;
            traversed = false;
            path = null;
        }

        //添加邻接点
        public void AdjacentTo(Vertex to) {
            adj.add(to);
        }

    }
}

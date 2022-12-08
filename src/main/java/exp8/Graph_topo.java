package exp8;

import java.util.*;

public class Graph_topo {

    private ArrayList<Vertex> vertices;

    public Graph_topo(String[] verteNames) {
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
        vfrom.AdjacentTo(vto);
    }

    public String topSort() {
        StringBuilder str = new StringBuilder();
        Queue<Vertex> q = new LinkedList<>();
        int counter = 0;
        for (Vertex v : vertices)
            if (v.indegree == 0)
                q.add(v);
        while (!q.isEmpty()) {
            Vertex v = q.poll();
            v.topNum = ++counter;
            str.append(v.name);

            for (Vertex w : v.adj)
                if (--w.indegree == 0)
                    q.add(w);
        }

        return str.toString();
    }

    class Vertex {
        private int indegree, topNum;
        private String name;
        private List<Vertex> adj;
        private List<Vertex> invAdj;

        Vertex(String name) {
            this.name = name;
            indegree = 0;
            topNum = 0;
            adj = new LinkedList<Vertex>();
            invAdj = new LinkedList<Vertex>();
        }

        //添加邻接点
        public void AdjacentTo(Vertex to) {
            adj.add(to);
            to.indegree++;
            to.invAdj.add(this);
        }

        public void AdjacentFrom(Vertex from) {
            invAdj.add(from);
            this.indegree++;
            from.adj.add(this);
        }
    }
}

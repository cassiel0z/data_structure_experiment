package exp8;

import java.util.*;

public class Graph_prim {

    public ArrayList<Vertex> vertices;
    public Map<String, Integer> dists = new HashMap<>();

    Graph_prim(String[] verteNames) {
        vertices = new ArrayList<>();
        for (String verteName : verteNames) {
            vertices.add(new Vertex(verteName));
        }
    }

    public void addEdge(String from, String to, int dist) {
        Vertex vfrom = null, vto = null;
        for (Vertex vertice : vertices) {
            if (Objects.equals(vertice.name, from)) vfrom = vertice;
            if (Objects.equals(vertice.name, to)) vto = vertice;
        }

        vfrom.AdjacentTo(vto);
        vto.AdjacentTo(vfrom);

        //无向图两边都添加进邻接表
        dists.put(vfrom.name + vto.name, dist);
        dists.put(vto.name + vfrom.name, dist);

    }

    void prim() {
        //初始化所有顶点
        for (Vertex v : vertices) {
            v.dist = Integer.MAX_VALUE;
            v.known = false;
        }

        vertices.get(0).dist = 0;

        while (hasUnknown()) {//全部已知时退出循环
            Vertex v = findMin();

            v.known = true;

            for (Vertex w : v.adj)
                if (!w.known) {
                    int cvw = dists.get(v.name + w.name);

                    if (w.dist>cvw+v.dist) {
                        w.dist=cvw+v.dist;
                        w.path=v;
                    }
                }
        }
    }

    //递归法打印路径
    public void printPath(Vertex v) {
        if (v.path != null) {
            printPath(v.path);
            System.out.print(" to ");
        }
        System.out.print(v.name);
    }

    private boolean hasUnknown() {
        for (Vertex v : vertices)
            if (!v.known)
                return true;
        return false;
    }

    private Vertex findMin() {
        Vertex min = null;

        //先取第一个未知的顶点为最小值
        for (Vertex v : vertices)
            if (!v.known) {
                min = v;
                break;
            }
        for (Vertex v : vertices)
            if (!v.known && v.dist < min.dist)
                min = v;
        return min;
    }

    class Vertex {
        public String name;
        public List<Vertex> adj;

        public boolean known;
        public int dist;
        public Vertex path;

        Vertex(String name) {
            this.name = name;
            adj = new LinkedList<>();
            known = false;
            dist = Integer.MAX_VALUE;
            path = null;
        }

        //添加邻接点
        public void AdjacentTo(Vertex to) {
            adj.add(to);
        }

    }
}

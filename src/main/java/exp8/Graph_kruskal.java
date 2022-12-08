package exp8;

import java.util.*;

public class Graph_kruskal {
    private String[] vertices;
    private List<Edge> edges;

    public Graph_kruskal(String[] verteNames) {
        vertices = verteNames;
        edges = new ArrayList<>();
    }

    public void addEdge(String u, String v, int weight) {
        edges.add(new Edge(u, v, weight));
    }

    public ArrayList<Edge> kruskal() {
        int numVertices= vertices.length;
        DisjSets ds = new DisjSets(numVertices);
        PriorityQueue<Edge> pq = new PriorityQueue<>(edges);
        ArrayList<Edge> mst = new ArrayList<>();

        while (mst.size() != numVertices - 1) {
            int uindex, vindex;
            Edge e = pq.poll();
            uindex = ds.find(e.getu());
            vindex = ds.find(e.getv());

            String uset = vertices[uindex];
            String vset = vertices[vindex];

            if (uset != vset) {
                mst.add(e);
                ds.union(uindex, vindex);
            }

        }

        return mst;
    }



    class Edge implements Comparable<Edge>{
        public String u; // 边
        public String v;   // 边
        public int weight; // 边的权重

        public Edge(String u, String v, int weight) {
            this.u = u;
            this.v = v;
            this.weight = weight;
        }

        public int getu() {
            for (int i = 0; i < vertices.length; i++) {
                if (Objects.equals(vertices[i], u))
                    return i;
            }
            return -1;
        }

        public int getv() {
            for (int i = 0; i < vertices.length; i++) {
                if (Objects.equals(vertices[i], v))
                    return i;
            }
            return -1;
        }


        @Override
        public int compareTo(Edge o) {
            return this.weight-o.weight;
        }
    }

    public static class DisjSets {

        int[] parent;

        public DisjSets(int size) {
            parent = new int[size];
            for (int i = 0; i < parent.length; i++) {
                parent[i] = i;
            }
        }

        private int find(int x) {//查询操作，其实是查询  根节点
            if (x < 0 || x > parent.length)
                return -1;
            while (parent[x] != x)
                x = parent[x];

            return x;
        }

        private void union(int a, int b) {
            int ap = find(a);
            int bp = find(b);
            if (ap != bp) {
                parent[ap] = bp;//让其中一个节点的根节点 指向  另外一个节点的根节点
            }
        }

        private boolean isJoined(int a, int b) { //两个节点是否是  连接的
            return find(a) == find(b);
        }

    }

}

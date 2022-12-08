package exp8;

import java.util.*;

public class Graph_dijkstra {
    public ArrayList<Vertex> vertices;
    public Map<String,Integer> dists = new HashMap<>();

    Graph_dijkstra(String[] verteNames){
        vertices = new ArrayList<>();
        for (String verteName : verteNames) {
            vertices.add(new Vertex(verteName));
        }
    }

    public void addEdge(String from, String to,int dist) {
        Vertex vfrom = null, vto = null;
        for (Vertex vertice : vertices) {
            if (Objects.equals(vertice.name, from)) vfrom = vertice;
            if (Objects.equals(vertice.name, to)) vto = vertice;
        }
        vfrom.AdjacentTo(vto);

        dists.put(vfrom.name+vto.name,dist);

    }

    void dijkstra(Vertex s){
        //初始化所有顶点
        for(Vertex v:vertices){
            v.dist=Integer.MAX_VALUE;
            v.known=false;
        }

        s.dist=0;

        while (hasUnknown()){//全部已知时退出循环
            Vertex v=findMin();

            v.known=true;

            for (Vertex w : v.adj)
                if (!w.known){
                    int cvw = dists.get(v.name+w.name);

                    if(v.dist+cvw<w.dist){
                        w.dist=v.dist+cvw;
                        w.path=v;
                    }
                }
        }
    }

    public int calculateDist(Vertex v){
        return v.dist;
    }

    //递归法打印路径
    public void printPath(Vertex v){
        if(v.path!=null){
            printPath(v.path);
            System.out.print(" to ");
        }
        System.out.print(v.name);
    }

    private boolean hasUnknown(){
        for(Vertex v:vertices)
            if (!v.known)
                return true;
        return false;
    }


    private Vertex findMin(){
        Vertex min = null;
        //先取第一个未知的顶点为最小值
        for(Vertex v:vertices)
            if(!v.known){
                min=v;
                break;
            }

        for(Vertex v:vertices)
            if (!v.known && v.dist<min.dist)
                min=v;
        return min;
    }

    class Vertex{
        public String name;
        public List<Vertex> adj;
        public boolean known;
        public int dist;
        public Vertex path;

        Vertex(String name){
            this.name=name;
            adj=new LinkedList<>();
            known=false;
            dist=Integer.MAX_VALUE;
            path=null;
        }

        //添加邻接点
        public void AdjacentTo(Vertex to) {
            adj.add(to);
        }
    }
}

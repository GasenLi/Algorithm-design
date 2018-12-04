package 实验六;

import java.util.TreeSet;

public class MapBuilder {
    public int pointNum = 0;

    public TreeSet<Edge> build(){
        TreeSet<Edge> edges=new TreeSet<Edge>();
        edges.add(new Edge("A","B",1));
        edges.add(new Edge("A","C",4));
        edges.add(new Edge("A","F",6));
        edges.add(new Edge("B","D",8));
        edges.add(new Edge("B","E",3));
        edges.add(new Edge("C","F",5));
        edges.add(new Edge("C","E",9));
        edges.add(new Edge("D","E",7));
        edges.add(new Edge("D","F",10));
        edges.add(new Edge("E","F",2));
        return edges;
    }

    public TreeSet<Edge> Randombuild(){
        TreeSet<Edge> edges=new TreeSet<Edge>();
        for(int i=0 ; i<Math.random()*pointNum*pointNum; i++){
            edges.add(new Edge(Math.random()*pointNum+"",Math.random()*pointNum+"",(int)(Math.random()*10+1)));
        }

        return edges;
    }
}

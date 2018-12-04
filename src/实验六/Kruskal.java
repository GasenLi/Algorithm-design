package 实验六;

import java.util.*;

public class Kruskal {
    private Set<String> points=new HashSet<String>();
    private List<Edge> treeEdges=new ArrayList<Edge>();
    public void buildTree(MapBuilder builder){
        TreeSet<Edge> edges=builder.Randombuild();
        int pointNum=builder.pointNum;
        for(Edge edge:edges){
            if(isCircle(edge)){
                continue;
            }else{//没有出现回路,将这条边加入treeEdges集合
                treeEdges.add(edge);
                //如果边数等于定点数-1,则遍历结束
                if(treeEdges.size()==pointNum-1){
                    return;
                }
            }
        }
    }
    public void printTreeInfo(){
        int totalDistance=0;
        for(Edge edge:treeEdges){
            totalDistance+=edge.getDistance();
            System.out.println(edge.toString());
        }
        System.out.println("总路径长度:"+totalDistance);
    }
    private boolean isCircle(Edge edge){
        int size=points.size();
        if(!points.contains(edge.getStart())){
            size++;
        }
        if(!points.contains(edge.getEnd())){
            size++;
        }
        if(size==treeEdges.size()+1){
            return true;
        }else{
            points.add(edge.getStart());
            points.add(edge.getEnd());
            return false;
        }
    }
}


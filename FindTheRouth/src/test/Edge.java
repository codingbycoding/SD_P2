/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.util.ArrayList;
import java.util.Map;

/**
 *
 * @author sarahjessica
 */
public class Edge {
    Vertex beg;
    Vertex end;
    
    Edge(Vertex beg, Vertex end) {
        this.beg = beg;
        this.end = end;
    }
     
     public static ArrayList<Edge> genEdge(ArrayList<Vertex> arrVertex, ArrayList<Edge> arrEdge, Map<Vertex, ArrayList<Vertex>> lineMap, ArrayList<Edge> arrVertexDistrubLines) {
        if (arrVertex.size() > 1) {
            for (int i = 0; i < arrVertex.size(); i++) {
                if (i != arrVertex.size() - 1) {
                    arrEdge.add(new Edge(arrVertex.get(i), arrVertex.get(i+1)));
                    //arrCircleLines.add(new CircleLine(arrVertex.get(i+1), arrVertex.get(i)));
                    ArrayList<Vertex> arr2CircleX, arr2CircleY = null;
                    arr2CircleX = lineMap.get(arrVertex.get(i));
                    arr2CircleY = lineMap.get(arrVertex.get(i + 1));

                    if (null == arr2CircleX) {
                        arr2CircleX = new ArrayList<Vertex>();
                    }

                    if (null == arr2CircleY) {
                        arr2CircleY = new ArrayList<Vertex>();
                    }

                    arr2CircleX.add(arrVertex.get(i + 1));
                    lineMap.put(arrVertex.get(i), arr2CircleX);

                    arr2CircleY.add(arrVertex.get(i));
                    //lineMap.put(arrVertex.get(i + 1), arr2CircleY);

                }
            }
        }
        
        arrVertexDistrubLines.add(new Edge(arrVertex.get(1), arrVertex.get(arrVertex.size()-1)));
     
    return arrVertexDistrubLines;
    }
    
}
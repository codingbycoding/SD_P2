/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.util.ArrayList;

/**
 *
 * @author sarahjessica
 */
public class Vertex {
    int x, y;
    
    Vertex(int i, int j) {
        this.x = i;
        this.y = j;
    }
    
    public static ArrayList<Vertex> genVertex(ArrayList<Vertex> arrVertex) {
        int circleNum = TestUtils.get5To8();
        ArrayList<Integer> arrNumEachRow = TestUtils.randomWithWeight(circleNum);
        ArrayList<Integer> arrRows = TestUtils.shuffle0To9();

        for (int i = 0; i < arrNumEachRow.size(); i++) {
            ArrayList<Integer> arrRowEach = TestUtils.shuffle0To9();
            for (int k = arrNumEachRow.get(i), j = 0; k > 0; k--, j++) {
                Vertex index = new Vertex(arrRows.get(i), arrRowEach.get(j));
                arrVertex.add(index);
            }
        }
        
        return(arrVertex);
    }
    
    boolean equals(Vertex rhs) {
        boolean ret = false;
        if(rhs.x == this.x && rhs.y == this.y) {
            ret = true;
        }
        return ret;
    }
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JPanel;

/**
 *
 * @author onezero
 */
public class GraphPanel extends JPanel {

    ArrayList<Vertex> arrVertex;
    ArrayList<Vertex> arrColorVertex;
    ArrayList<Vertex> arrPickupVertex;
    ArrayList<Edge> arrEdge;
    ArrayList<Edge> arrVertexDistrubLines;
    ArrayList<Edge> arrEdgeLines;
    Map<Vertex, ArrayList<Vertex>> lineMap;
    final int f_r = 6;
    
    public GraphPanel() {
        arrVertex = new ArrayList<Vertex>();
        arrEdge = new ArrayList<Edge>();
        arrVertexDistrubLines = new ArrayList<Edge>();
        arrEdgeLines = new ArrayList<Edge>();
        arrPickupVertex = new ArrayList<Vertex>();
        arrColorVertex = new ArrayList<Vertex>();
        lineMap = new HashMap<Vertex, ArrayList<Vertex>>();
        
        arrVertex = Vertex.genVertex(arrVertex);
        arrVertexDistrubLines = Edge.genEdge(arrVertex, arrEdge, lineMap, arrVertexDistrubLines);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        //ArrayList arrList = new ArrayList();

        /*
        for (int x = 0; x < 10; x++) {
            //g.drawOval(2*f_r + x*f_r, 2*f_r + x*f_r, f_r*2, f_r*2);
            g.fillOval(4 * f_r + x * 10 * f_r - f_r, 4 * f_r + x * 10 * f_r - f_r, f_r * 4, f_r * 4);
        }
         */
        for (int i = 0; i < arrVertex.size(); i++) {
            g.fillOval(4 * f_r + arrVertex.get(i).x * 10 * f_r - f_r, 4 * f_r + arrVertex.get(i).y * 10 * f_r - f_r, f_r * 4, f_r * 4);
        }

        for (int i = 0; i < arrEdge.size(); i++) {
            g.drawLine(
                    4 * f_r + arrEdge.get(i).beg.x * 10 * f_r,
                    4 * f_r + arrEdge.get(i).beg.y * 10 * f_r,
                    4 * f_r + arrEdge.get(i).end.x * 10 * f_r,
                    4 * f_r + arrEdge.get(i).end.y * 10 * f_r);
        }

        for (int i = 0; i < arrVertexDistrubLines.size(); i++) {
            g.drawLine(
                    4 * f_r + arrVertexDistrubLines.get(i).beg.x * 10 * f_r,
                    4 * f_r + arrVertexDistrubLines.get(i).beg.y * 10 * f_r,
                    4 * f_r + arrVertexDistrubLines.get(i).end.x * 10 * f_r,
                    4 * f_r + arrVertexDistrubLines.get(i).end.y * 10 * f_r);
        }
                
        Color originalColor = g.getColor();
        g.setColor(Color.RED);
        for (int i = 0; i < arrEdgeLines.size(); i++) {
            g.drawLine(
                    4 * f_r + arrEdgeLines.get(i).beg.x * 10 * f_r,
                    4 * f_r + arrEdgeLines.get(i).beg.y * 10 * f_r,
                    4 * f_r + arrEdgeLines.get(i).end.x * 10 * f_r,
                    4 * f_r + arrEdgeLines.get(i).end.y * 10 * f_r);
        }
        g.setColor(originalColor);

        for (int i = 0; i < arrColorVertex.size(); i++) {
            originalColor = g.getColor();
            g.setColor(Color.ORANGE);
            g.fillOval(4 * f_r + arrColorVertex.get(i).x * 10 * f_r - f_r, 4 * f_r + arrColorVertex.get(i).y * 10 * f_r - f_r, f_r * 4, f_r * 4);
            g.setColor(originalColor);
        }

        for (int i = 0; i < arrPickupVertex.size(); i++) {
            originalColor = g.getColor();
            g.setColor(Color.ORANGE);
            g.fillOval(4 * f_r + arrPickupVertex.get(i).x * 10 * f_r - f_r, 4 * f_r + arrPickupVertex.get(i).y * 10 * f_r - f_r, f_r * 4, f_r * 4);
            g.setColor(originalColor);
        }
    }

    public void refreshGraphPanel() {
        arrVertex.clear();
        arrColorVertex.clear();
        arrPickupVertex.clear();
        arrEdge.clear();
        arrEdgeLines.clear();
        arrVertexDistrubLines.clear();
        lineMap.clear();
        
        arrVertex = Vertex.genVertex(arrVertex);
        arrVertexDistrubLines = Edge.genEdge(arrVertex, arrEdge, lineMap, arrVertexDistrubLines);
        repaint();
    }

    public void mouseOnCircleCheck(int x, int y) {
        boolean bRepaint = false;
        for (int i = 0; i < arrVertex.size(); i++) {
            double dx = ((double) (4 * f_r + arrVertex.get(i).x * 10 * f_r) - (double) x);
            double dy = ((double) (4 * f_r + arrVertex.get(i).y * 10 * f_r) - (double) y);
            if (dx * dx + dy * dy <= (f_r + 6) * (f_r + 6)) {
                //change color
                arrColorVertex.add(arrVertex.get(i));
                bRepaint = true;
                break;
            }
        }

        if (!bRepaint && arrColorVertex.size() > 0) {
            arrColorVertex.clear();
            bRepaint = true;
        }
        if (bRepaint) {
            repaint();
        }

    }

    public void setPickupCircle(int x, int y) {
        boolean bRepaint = false;
        if (arrColorVertex.size() > 0) {
            double dx = ((double) (4 * f_r + arrColorVertex.get(0).x * 10 * f_r) - (double) x);
            double dy = ((double) (4 * f_r + arrColorVertex.get(0).y * 10 * f_r) - (double) y);
            if (dx * dx + dy * dy <= (f_r + 6) * (f_r + 6)) {
                //arrPickupCircleIndex.add(new CircleIndex(arrColorCircleIndex.get(0)));
                if (arrPickupVertex.size() < 2) {
                    arrPickupVertex.add(arrColorVertex.get(0));
                    arrColorVertex.clear();
                    bRepaint = true;
                }
            }
        }

        if (bRepaint) {
            //logic for find the route.
            if (2 == arrPickupVertex.size()) {
                Vertex circleBeg = arrPickupVertex.get(0), circleEnd = arrPickupVertex.get(1);
                for(int i=0; i<arrVertex.size(); i++) {
                    if(circleEnd.equals(arrVertex.get(i))) {
                        circleBeg = arrPickupVertex.get(1);
                        circleEnd = arrPickupVertex.get(0);
                        break;
                    } else if(circleBeg.equals(arrVertex.get(i))) {
                        break;
                    }
                }
                         
                findRoute(circleBeg, circleEnd, null);
            }

            repaint();
        }
    }

    public void findRoute(Vertex beg, Vertex end, Vertex preCircle) {
        //static int limit_count = 0;
        if (beg == end) {
            return;
        }
        ArrayList<Vertex> arr2Circle = lineMap.get(beg);
        for (int i = 0; i < arr2Circle.size(); i++) {
            if (null == preCircle || preCircle != arr2Circle.get(i)) {
                arrEdgeLines.add(new Edge(beg, arr2Circle.get(i)));
                preCircle = beg;
                beg = arr2Circle.get(i);
                break;
            }
        }
           
        findRoute(beg, end, preCircle);

    }

}
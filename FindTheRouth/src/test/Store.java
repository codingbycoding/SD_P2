/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

/**
 *
 * @author sarahjessica
 */
public class Store extends Vertex {
   String name;
   
   public Store(int i, int j, String name){
       super(i,j);
       this.name = name;
   }
    
   public String getName()
   {
      return name;
   }
}

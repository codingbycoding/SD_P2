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
   String type; //(Emisor or Receptor)
   Order placeOrder;
   
   
   public Store(int i, int j, String name, String type){
       super(i,j);
       this.name = name;
       this.type = type;
   }
    
   public String getName()
   {
      return this.name;
   }
   
   public String getType()
   {
      return this.type;
   }
}

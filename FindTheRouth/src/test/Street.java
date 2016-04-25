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
public class Street {
    Boolean accesible;
    String name;
    
    public Street (Boolean accesible, String name) {
        this.accesible = accesible;
        this.name = name;
    }
    
    public Boolean getAccesible (){
        return this.accesible;
    }
    
    public String getName (){
        return this.name;
    }
}

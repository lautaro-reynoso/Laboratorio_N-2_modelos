/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package resources;

import Entities.Entity;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Familia
 */
public class Queue {
    
    private int id;
    List<Entity> entities;

    public Queue(int id) {
        this.id = id;
        this.entities = new ArrayList<>();
        
    }
    
    public int getSize(){
        
        return this.entities.size();
    }
    
    public boolean isEmpty(){
    
         return this.entities.isEmpty();
    }
    
    public void enqueue(Entity entity){
        
        this.entities.add(entity);
        
    }
  
    public Entity dequeue (){
    
    return this.entities.remove(0);
        
    }
}

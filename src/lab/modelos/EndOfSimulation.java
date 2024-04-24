/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab.modelos;

import Entities.Entity;
import java.util.List;
import resources.Server;

/**
 *
 * @author Familia
 */
public class EndOfSimulation extends Event{

    public EndOfSimulation(double clock, Entity entity, int ordering) {
        super(clock, null, 3);
    }

    @Override
    public void planificate(FutureEventList fel, Server server) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
    
}

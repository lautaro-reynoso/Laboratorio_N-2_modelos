/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab.modelos.utils;

import java.util.Comparator;
import lab.modelos.Event;

/**
 *
 * @author Familia
 */
public class OrdenFel implements Comparator<Event>{

    @Override
    public int compare(Event e1, Event e2) {
       int ret = 0;
                
                if(e1.getClock() < e2.getClock())
                    ret = -1;
                else if (e1.getClock() > e2.getClock())
                    ret = 1;
                else if (e1.getOrdering() < e2.getOrdering() )
                    ret = -1;
                else 
                    ret = 1;
                
                return ret;
    }
    
}

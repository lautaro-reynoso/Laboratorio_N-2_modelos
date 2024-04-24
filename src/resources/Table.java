/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package resources;

/**
 *
 * @author Familia
 */
public class Table {
        private int randomizer;
    

    /**
     * {@inheritDoc}
     * 
     */
   
    public int nextTime(double clock) {
        int ret;
        double r= Math.random();
        if(r<=0.3){
            ret=10;
        } else if (r<=0.7) {
            ret=15;
        }
        else {
            ret=20;
        }
        return ret;
    }
    
      public static int ArrTime(double seed){
        if(seed<0.35)
            return 10;
        else if(seed<0.80)
            return 15;
        else 
            return 17;
                 
    }
    
    public static int DepTime(double seed){
        if(seed<0.38)
            return 8;
        else if(seed<0.70)
            return 10;
        else if(seed<0.80)
            return 13;
        else 
            return 15;
                 
    }
    
}

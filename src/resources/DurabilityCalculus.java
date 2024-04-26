
package resources;

import java.util.Random;

public  class DurabilityCalculus {

    public double NormalizationCalculateDurability(float mu, double variancy){

        Random r = new Random();
        float suma =  0;


        for (int i = 0 ; i < 36 ; i ++){

            suma += r.nextFloat();


        }
        float mux = (suma/36)*36;

        float variancyx=(1/36)*36;

        float zprima = (suma - mux)/variancyx;

        return (zprima*Math.sqrt(variancy))+mu;

    }
}
    



/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lab.modelos;

import Entities.Aircraft;
import Politicas.ServerSelection;

import java.util.ArrayList;
import java.util.List;
import resources.Report;
import resources.Server;

/**
 *
 * @author Familia
 */
public class LabModelos {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
    List<Server> pistas= new ArrayList<>();
    FutureEventList fel = new FutureEventList();
    fel.insert(new EndOfSimulation (40320, null, 3));
    fel.insert(new Arrival(0, new Aircraft(1,0)));
    double clock;
   // ServerSelection s;
    Event eventoInminente = fel.imminent();
    while (!(eventoInminente instanceof EndOfSimulation)) {
        eventoInminente.planificate(fel, pistas);
        clock=eventoInminente.getClock();
        eventoInminente = fel.imminent();
    } 
        System.out.println("Report:\n"
                + "Cantidad Arribos:" + Report.cantArr
                + "\nCantidad Aterrizados:" + Report.cantAtr
                + "\nTiempo medio Transito:" + (Report.acumTransito/Report.cantAtr)
                + "\nTiempo maximo Transito:" + Report.maxTransito
                + "\nTiempo minimo Transito:" + Report.minTransito
                + "\nTotal de aviones que entraron a cola:" + Report.cantEspera
                + "\nTiempo total acumulado de espera:" + Report.acumEspera
                + "\nTiempo medio Espera:" + Report.acumEspera / Report.cantEspera
                + "\nTiempo maximo Espera:" + Report.maxEspera
                + "\nTiempo minimo Espera:" + Report.minEspera
                + "\nTiempo total Ocio:" + Report.totalOcio
                + "\nTiempo maximo Ocio:" + Report.maxOcio
                + "\nTiempo minimo Ocio:" + Report.minOcio
                + "\nCantidad maxima de Aviones en cola:" + Report.maxCola
                + "\nCantidad minima de Aviones en cola:" + Report.minCola);
        
        

        
    }
    
  
    
}

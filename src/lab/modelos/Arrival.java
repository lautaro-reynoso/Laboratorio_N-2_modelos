/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab.modelos;

import Entities.Aircraft;
import Entities.Entity;
import Politicas.ServerSelection;
import java.util.List;
import resources.Report;
import resources.Server;
import resources.Table;

/**
 *
 * @author Familia
 */
public class Arrival extends Event {
    private ServerSelection policy;

    public Arrival(double clock, Entity entity, ServerSelection policy) {
        super(clock, entity, 1);
        this.policy = policy;
    }

    public void planificate(FutureEventList fel, List<Server> server) {
   
        Server s = policy.selectServer(server);
         //Agregar tipo servidor para saber donde esta parada cada entidad a futuro
         Report.cantArr++;
         
        if(s.isBusy()){
            
            Entity plane = this.getEntity();
            plane.setTime(this.getClock());
            s.getQueue().enqueue(plane); 
            Report.cantEspera++;
            if (s.getQueue().getSize()!=0){
                    if (s.getQueue().getSize()<Report.minCola  || Report.minCola==0){
                    Report.minCola=s.getQueue().getSize();
                    }
                    if (s.getQueue().getSize()>Report.maxCola){
                    Report.maxCola=s.getQueue().getSize();
                    }
                }                              
            
        }
        else {
            //El servidor estaba desocupado, dejo de estar ocioso y pasa a estar ocupado, fin tiempo ocio medioOcio
            if (this.getClock()-Report.medioOcio>0){
                    if (Report.maxOcio<this.getClock()-Report.medioOcio){
                    Report.maxOcio=this.getClock()-Report.medioOcio;
                    }
                    if (Report.minOcio>this.getClock()-Report.medioOcio || Report.minOcio==0){
                    Report.minOcio=this.getClock()-Report.medioOcio;
                    }
                }
            Report.totalOcio=Report.totalOcio+(this.getClock()-Report.medioOcio);
            Report.medioOcio=0;
            //El servidor esta siendo ocupado, empieza el tiempo de transito
            s.setCurrentEntity(this.getEntity());
            Report.cantAtr++;
            //El servidor esta siendo ocupado, empieza el tiempo de transito
            Report.medioTransito=this.getClock();
            fel.insert(new Departure(this.getClock()+Table.DepTime(Math.random()),this.getEntity()));
        }
        
        fel.insert(new Arrival(this.getClock()+Table.ArrTime(Math.random()), new Aircraft (this.getEntity().getId()+1 ,0)));
        
    }

    

    @Override
    public void planificate(FutureEventList fel, List<Server> server) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'planificate'");
    }

   
}

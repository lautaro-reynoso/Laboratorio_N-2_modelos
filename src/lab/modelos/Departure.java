/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab.modelos;

import Entities.Entity;
import java.util.List;
import resources.Report;
import resources.Server;
import resources.Table;

/**
 *
 * @author Familia
 */
public  class Departure extends Event {
    
    
    public Departure(double clock, Entity entity){
        super(clock, entity, 2);
        //End of simulation va a tener orden 3
    }

    public void planificate(FutureEventList fel, Server server) {
    
        Server s = server;
        
         if (s.getQueue().isEmpty()){
                 s.setCurrentEntity(null);
                 //el servidor pasa a estar desocupado, tiempo de ocio
                 Report.medioOcio=this.getClock();
                 //termina el tiempo de transito
                 if(this.getClock()-Report.medioTransito>0){
                     if(this.getClock()-Report.medioTransito<Report.minTransito  || Report.minTransito==0){
                         Report.minTransito=this.getClock()-Report.medioTransito;
                     }
                     if(this.getClock()-Report.medioTransito>Report.maxTransito){
                         Report.maxTransito=this.getClock()-Report.medioTransito;
                    }
                     Report.acumTransito=Report.acumTransito+this.getClock()-Report.medioTransito;
                     
                 }
                 
                }
         
         else{
                //Asigno la entidad que estaba en cola de espera, para modificar el tiempo, el nuevo va a ser en el que paso a aterrizar
                Entity entityOn = s.getQueue().dequeue(); 
                if (this.getClock()-entityOn.getTime()>0){
                    if (this.getClock()-entityOn.getTime()<Report.minEspera || Report.minEspera==0){
                    Report.minEspera=this.getClock()-entityOn.getTime();
                    }
                    if (this.getClock()-entityOn.getTime()>Report.maxEspera){
                    Report.maxEspera=this.getClock()-entityOn.getTime();
                    }
                }    
                Report.acumEspera+=this.getClock()-entityOn.getTime();
                s.setCurrentEntity(entityOn);
                Report.cantAtr++;
                if(this.getClock()-s.getCurrentEntity().getTime()!=0){
                    if(this.getClock()-s.getCurrentEntity().getTime()>Report.maxEspera){
                    Report.maxEspera=(int) (this.getClock()-s.getCurrentEntity().getTime());
                    }
                    if(this.getClock()-s.getCurrentEntity().getTime()<Report.minEspera){
                    Report.minEspera=(int) (this.getClock()-s.getCurrentEntity().getTime());
                    }
                }
                fel.insert(new Departure(this.getClock()+Table.DepTime(Math.random()),s.getCurrentEntity()));
                
         }
    }
}

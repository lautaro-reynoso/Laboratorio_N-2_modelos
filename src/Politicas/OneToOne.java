/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Politicas;

import java.util.List;
import resources.Server;

/**
 *
 * @author Usuario
 */
public class OneToOne implements ServerSelection {

    @Override
    public Server selectServer(List<Server> servers) {
          
       for(Server s : servers){
           if(!s.isBusy())
               return s;
       }
       
       Server minQueueServer = servers.get(0);
       for(int i = 1; i < servers.size(); i++){
           if(servers.get(i).getQueue().getSize()< minQueueServer.getQueue().getSize())
               minQueueServer = servers.get(i);
       }
       
       
       return minQueueServer;
    }
    
}

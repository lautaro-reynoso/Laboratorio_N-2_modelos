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
public class UniqueServer implements ServerSelection{

    @Override
    public Server selectServer(List<Server> servers) {
        
        return servers.get(0);
        
    }
    
    
    
}

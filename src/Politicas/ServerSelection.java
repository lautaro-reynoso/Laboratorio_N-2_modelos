/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Politicas;

import java.util.List;
import resources.Server;

/**
 *
 * @author Usuario
 */
public interface ServerSelection {
    
    Server selectServer(List<Server> servers);
    
    
    
}

package resources;


import Entities.Entity;
import java.util.List;
import resources.Queue;



public class Server {

    private int id;

    private Entity currentEntity;

    private Queue queue;
    //Agregar tipo servidor para saber donde esta parada cada entidad a futuro


    public Server(int id) {
        this.id=id;
        this.queue= new Queue(16);
        this.currentEntity = null;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Entity getCurrentEntity() {
        return this.currentEntity;
    }

    public void setCurrentEntity(Entity currentEntity) {
        this.currentEntity = currentEntity;
    }

    public boolean isBusy() {
        return this.currentEntity!=null;
    }

    public Queue getQueue(){
    
        return this.queue;
    
    }

}



package lab.modelos;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import lab.modelos.utils.OrdenFel;
/**
 *
 * @author Familia
 */
public class FutureEventList {
    private List<Event> fel;
    private Comparator<Event> comparator;
    
    public FutureEventList(){
        this.fel = new ArrayList<>();
        this.comparator = new OrdenFel();
    }
    
    public void insert(Event event){
        this.fel.add(event);
        this.fel.sort(this.comparator);
    }
    
    public Event imminent(){
        return this.fel.remove(0);
    }
}

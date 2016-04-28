
import java.util.LinkedList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author sfoo004
 */
public class Leaf {
    
    LinkedList<Integer> values = new LinkedList<>();
    
    Leaf(){
        
    }
    
    protected boolean hasRoom(){
        return values.size() <= 4;
    }
    
    protected void insert(int number){
        boolean added = false;
        for(int i = 0; i < values.size(); i++){
            if(number > values.get(i)){
                continue;
            } else {
                added = true;
                values.add(i, number);
                break;
            }
        }
        if(!added){
            values.addLast(number);
        }
    }
}

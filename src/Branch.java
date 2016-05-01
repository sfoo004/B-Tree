/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author sfoo004
 */
public class Branch extends Leaf {
    
    int value;
    Leaf left = null;
    Leaf right = null;
    
    Branch(){
    }
    
    protected boolean hasOverflow(){
        return left.overflow() || right.overflow();
    }
    
    protected void insert(int number){
        if(number < value){ // check if it belongs in left leaf
            if(left.hasRoom()){
                left.add(number);   
            }
        } else { // value belong to right leaf
            if(right.hasRoom()){
                right.add(number);     
            } 
        }
    }
    
    protected boolean remove(int number){
        boolean deleted = false;
        //deleted value is a branch
        if(number == value){
            //remove value from left branch
            if(left.values.contains(number)){
                left.delete(number);
            } else { // remove from right branch
                right.delete(number);
            }
            //get highest left value
            if(left.values.size() > 0){
                value = left.values.getLast();
            }
            //get lowest right value
            else if (right.values.size() > 0){
                value = right.values.getFirst();
            }
            deleted = true;
        } else {
            if(number < value){
                deleted = left.delete(number);   
            } else {
                deleted = right.delete(number);
            }
        }
        
        return deleted;
    }
}

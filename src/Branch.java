/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author sfoo004
 */
public class Branch {
    
    int value;
    Tree left = null;
    Tree right = null;
    boolean leaf = false;
    Branch parent = new Branch();
    
    
    Branch(){
    }
    
    protected void turnIntoLeaf(Branch b){
        
    }
    
    protected void insert(Branch b) {
        if (!leaf) {
            if (b.value < value) { // check if it belongs in left leaf
                if (left.hasRoom()) {
                    left.add(b);
                }
            } else if (right.hasRoom()) { // value belong to right leaf
                right.add(b);
            }
        }
    }
      
    
//    protected boolean hasOverflow(){
//        return left.overflow() || right.overflow();
//    }
//    
//    
//    protected boolean remove(int b.value){
//        boolean deleted = false;
//        //deleted value is a branch
//        if(b.value == value){
//            //remove value from left branch
//            if(left.values.contains(b.value)){
//                left.delete(b.value);
//            } else { // remove from right branch
//                right.delete(b.value);
//            }
//            //get highest left value
//            if(left.values.size() > 0){
//                value = left.values.getLast();
//            }
//            //get lowest right value
//            else if (right.values.size() > 0){
//                value = right.values.getFirst();
//            }
//            deleted = true;
//        } else {
//            if(b.value < value){
//                deleted = left.delete(b.value);   
//            } else {
//                deleted = right.delete(b.value);
//            }
//        }
//        
//        return deleted;
//    }
}


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
public class Tree {
    
    LinkedList<Branch> branches = new LinkedList<>();
    Tree leftSibling = null;
    Branch parent = new Branch();
    boolean leaf = false;
    
    Tree(){      
    }
    
     protected boolean hasRoom(){
        return branches.size() <= 4; 
    }
    
    protected boolean overflow(){
        return branches.size() > 4;
    }
    
    //adds item to Branch. Already checked for over flow
    protected void add(Branch b){
        //check to see if the list is over filled
        //if it does split the list in half
        
        boolean added = false;
        for(int i = 0; i < branches.size(); i++){
            if(b.value > branches.get(i).value){
                continue;
            } else {
                added = true;
                branches.add(i, b);
                break;
            }
        }
        if(!added){
            branches.addLast(b);
        }
        if(overflow()){
            overfilled();
            parent = findParent(this);
            parent.right = this;
            parent.left = leftSibling;
        }
    }
    //splits the overfill
    public void overfilled(){
        Tree temp = new Tree();//less than tree
       for(int i = 0; i < branches.size()/2 ; i++){
           temp.add(branches.remove(i));
       }
       //changes left sibilings
       temp.leftSibling = leftSibling;
       leftSibling = temp;    
    }
    //make a function to search for parent and select leftmost right value recursively
    public Branch findParent(Tree tree){
        if(tree.leaf){
            return tree.branches.get(0);
        } else {
            //searches next layer
            return findParent(tree.branches.get(0).left);
        }
        
    }
    
    //if deleted value exists remove and return true. If not then return false
    protected boolean delete(int number){
        return branches.removeFirstOccurrence(number);
    }
    
//    protected void inserted(int number){
//        for(int i = 0; i < children.size(); i++){
//            //if something is in the list but overflow
//            if(children.get(i).overflow()){
//                //check left side of child size == 4 
//                if(children.get(i).left.overflow()){
//                   //grab item 2 and 3. Make 2 a branch and add 3 and 4 as branches to it. 
//                    
//                } else {
//                    //grab item 2 and 3. Make 2 a branch and add 3 and 4 as branches to it. 
//                    
//                }
//                break;
//            }
//            //if something is in the list but no overflow
//            else if(number > children.get(i).value){
//                continue;
//            } else {
//                children.get(i).insert(number);
//                break;
//            }
//        }
//        //if nothing is in the list
//        if(children.size()==0){
//            Branch b = new Branch();
//            b.value = number;
//            b.right.add(number);
//        }
//    }
//    
//    protected boolean deleted(int number){
//        for(int i = 0; i < children.size(); i++){
//            if(number > children.get(i).value){
//                continue;
//            } else {
//                return children.get(i).delete(number);
//            }
//        }
//        return false;
//    }
    
}

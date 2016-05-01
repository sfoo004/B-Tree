
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
    
    LinkedList<Branch> children = new LinkedList<>();
    
    Tree(){      
    }
    
    protected void inserted(int number){
        for(int i = 0; i < children.size(); i++){
            //if something is in the list but overflow
            if(children.get(i).overflow()){
                //check left side of child size == 4 
                if(children.get(i).left.overflow()){
                   //grab item 2 and 3. Make 2 a branch and add 3 and 4 as values to it. 
                    
                } else {
                    //grab item 2 and 3. Make 2 a branch and add 3 and 4 as values to it. 
                    
                }
                break;
            }
            //if something is in the list but no overflow
            else if(number > children.get(i).value){
                continue;
            } else {
                children.get(i).insert(number);
                break;
            }
        }
        //if nothing is in the list
        if(children.size()==0){
            Branch b = new Branch();
            b.value = number;
            b.right.add(number);
        }
    }
    
    protected boolean deleted(int number){
        for(int i = 0; i < children.size(); i++){
            if(number > children.get(i).value){
                continue;
            } else {
                return children.get(i).delete(number);
            }
        }
        return false;
    }
    
}

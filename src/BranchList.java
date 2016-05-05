
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
public class BranchList {
    
    LinkedList<Branch> branches = new LinkedList<>();
    BranchList leftSibling = null;
    Branch parent = null;
    boolean leaf = false;
    
    BranchList(){      
    }
    
     protected boolean hasRoom(){
        return branches.size() <= 4; 
    }
    
    protected boolean overflow(){
        return branches.size() > 4;
    }
    protected void insertBranch(Branch b){
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
    }
    //adds item to Branch. Already checked for over flow
    protected void add(Branch b){
        if(leaf){
            insertBranch(b);
            if(overflow()){
                overfilled();
            }
        } else {
            boolean added = false;
            for(Branch branch: branches){
                if(branch.value<b.value){
                    continue;
                } else {
                    added = true;
                    branch.left.add(b);
                    break;
                }
            }
            if(!added){
                    branches.getLast().right.add(b);
            }
            if(overflow()) {
                overfilled();
            }
        }
    }
    //splits the overfill
    public void overfilled(){
        //if there is a parent then just add on to parents value
        if(parent != null){
            BranchList right = new BranchList();
            right.leaf = true;
            right.branches.add(branches.remove(0));
            right.branches.add(branches.remove(0));
            right.branches.add(branches.remove(0));
            Branch newParent = findParent(right);
            parent.currentList.add(newParent);
            newParent.left = this;
            newParent.right = right;  
            newParent.right.leftSibling = newParent.left;
            //if theer is no parent then this is a first time split.
        } else {
            BranchList left = new BranchList();
            BranchList right = new BranchList();
            left.leaf = true;
            right.leaf = true;
            left.branches.add(branches.remove(0));
            left.branches.add(branches.remove(0));
            right.branches.add(branches.remove(0));
            right.branches.add(branches.remove(0));
            right.branches.add(branches.remove(0));
            Branch newParent =findParent(right);
            newParent.left = left;
            newParent.right = right;
            newParent.currentList = this;
            right.leftSibling = left;
            this.add(newParent);
            this.leaf = false;
            
        } 
    }
    //make a function to search for parent and select leftmost right value recursively
    public Branch findParent(BranchList tree){
        if(tree.leaf){
            return tree.branches.get(0);
        } else {
            //searches next layer
            return findParent(tree.branches.get(0).left);
        }
        
    }
    
    //if deleted value exists remove and return true. If not then return false
    protected boolean delete(int number){
        boolean deleted = false;
        BranchList temp = find(number);
        if(temp != null){
            for(Branch b: temp.branches){
                if(b.value==number){
                    temp.branches.remove(b);
                    deleted = true;
                    break;
                }
            }
            
        }
        return deleted;
    }
    
    protected BranchList find(int number) {
        BranchList temp = null;
        
        if (leaf) {
            for(Branch b: branches){
                if(b.value == number){
                    return this;
                }
            }
        } else {
            boolean largeNumber = false;
            for (Branch b : branches) {
                if (b.value < number) {
                    continue;
                } else {
                    largeNumber = true;
                    temp = b.search(number);
                }
                if (!largeNumber) {
                   temp = branches.getLast().search(number);
                }

            }
        }
        return temp;
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

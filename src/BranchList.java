
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
                System.out.println(b.value + " added to the tree");
                break;
            }
        }
        if(!added){
            branches.add(b);
            System.out.println(b.value + " added to the tree");
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
           //add parent
            right.branches.add(branches.remove(0));
            right.branches.add(branches.remove(0));
            right.branches.add(branches.remove(0));
            Branch newParent = findParent(right);
            System.out.println("Splitting the list... promote "+ newParent.value + " as a key");
            parent.currentList.add(newParent);
            addParent(newParent, right);
            newParent.left = this;
            newParent.right = right;  
            newParent.right.leftSibling = newParent.left;
            //if theer is no parent then this is a first time split.
        } else {
            BranchList left = new BranchList();
            BranchList right = new BranchList();
            left.leaf = true;
            right.leaf = true;
            //ad parent
            left.branches.add(branches.remove(0));
            left.branches.add(branches.remove(0));
            right.branches.add(branches.remove(0));
            right.branches.add(branches.remove(0));
            right.branches.add(branches.remove(0));
            Branch newParent =findParent(right);
            newParent.left = left;
            newParent.right = right;
            addParent(newParent, right);
            addParent(newParent, left);
            newParent.currentList = this;
            System.out.println("Splitting the list... promote "+ newParent.value + " as a key");
            right.leftSibling = left;
            this.add(newParent);
            this.leaf = false;
            
        } 
    }
    
    public void addParent(Branch a, BranchList b){
        for(Branch branch: b.branches){
            branch.parent = a;
            branch.currentList = b;
        }
        b.parent = a;
        
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
                    System.out.println("deleteing..." + number);
                    deleted = true;
                    if(!temp.leaf && temp.parent.value==number){
                        System.out.println("deleted key");
                        temp.parent.value = temp.branches.get(0).value;
                        addParent(temp.parent, temp);
                        System.out.println("replaced key with " + temp.parent.value);
                    }
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
    
}

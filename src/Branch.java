
import java.io.BufferedWriter;
import java.io.IOException;

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
    BranchList currentList;
    BranchList left = null;
    BranchList right = null;
    boolean leaf = false;
    Branch parent;
    BufferedWriter bw;
    
    
    Branch(int value, BufferedWriter bw){
        this.value = value;
        this.bw = bw;
    }
    
    protected void insert(Branch b) throws IOException {
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
    
    protected BranchList search(int number){
        if(number < value){
            return left.find(number);
        } else {
            return right.find(number);
        }  
    }
}

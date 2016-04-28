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
    Branch left = null;
    Branch right = null;
    
    Branch(int value, Branch left, Branch right){
        this.value = value;
        this.left = left;
        this.right = right;
    }
    
    
    
    
}

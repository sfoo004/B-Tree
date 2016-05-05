
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author sfoo004
 */
public class Main {
    
    public static void main(String [] args) throws FileNotFoundException{
//        Scanner reader = new Scanner(new FileReader(args[0]));
//        String input = null;
        
        BranchList rootList = new BranchList();
        rootList.leaf = true;
        rootList.add(new Branch(5));
        rootList.add(new Branch(10));
        rootList.add(new Branch(20));
        rootList.add(new Branch(15));
        rootList.add(new Branch(21));
        rootList.find(15);
        rootList.delete(10);
        rootList.find(10);
//        while((input = reader.nextLine()) !=null){
//            String [] command;
//            command = input.trim().split(" ");
//        }
        
        
        
        
    }
    
//        Scanner reader = new Scanner(new InputStreamReader(System.in));
//        //Scanner reader = new Scanner(new FileReader("leaving.judge.in"));
//        String [] input= new String[2];
//        while()
//        String input = reader.nextLine();
//        
//       
//        
//       
//
//        do {
//            char[] input;
//            room start = null;
//            int row = reader.nextInt();
//            int column = reader.nextInt();
//
//            field = new room[row + 2][column + 2];
//            reader.nextLine();
//
//                input = reader.nextLine().replace(" ", "").toCharArray();
//    }    
}


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
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
    
    public static void main(String [] args) throws FileNotFoundException, IOException{
        Scanner reader = new Scanner(new FileReader(args[0]));
        String input = null;
        File file = new File("output.txt");

        // if file doesnt exists, then create it
        if (!file.exists()) {
            file.createNewFile();
        }

        FileWriter fw = new FileWriter(file.getAbsoluteFile());
        BufferedWriter bw = new BufferedWriter(fw);
  
        BranchList rootList = new BranchList();
        rootList.leaf = true;

        while((input = reader.nextLine()) != null){
            String [] commands = input.trim().split(" ");
        if(commands[0].toUpperCase().equals("I")){
            int i = Integer.parseInt(commands[1]);
            rootList.add(new Branch(i));
            
        } else if(commands[0].toUpperCase().equals("D")){
            int d = Integer.parseInt(commands[1]);
            rootList.delete(d);
            
        } else if(commands[0].toUpperCase().equals("F")) {
            int f = Integer.parseInt(commands[1]);
            rootList.find(f);
            //bw.write(content);
            
        }
        }
//        while((input = reader.nextLine()) !=null){
//            String [] command;
//            command = input.trim().split(" ");
//        }
        
        
        
        
    }
    public void printTree(BranchList rootList) {
        for (Branch a : rootList.branches) {
            System.out.printf("[%d]", a.value);
        }
        System.out.println();
        BranchList current = rootList;
        while (!current.leaf) {
            for (Branch a : rootList.branches) {
                for (Branch b : a.left.branches) {
                    System.out.printf("[%d]", b.value);

                }
            }
            for( Branch c : current.branches.getLast().right.branches){
                    System.out.printf("[%d]", c.value);
            }
        }
        
        
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

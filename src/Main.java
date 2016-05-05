
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
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
public class Main {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
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

        while ((input = reader.readLine()) != null) {
            System.out.println(input);
            String[] commands = input.trim().split(" ");
            if (commands[0].toUpperCase().equals("I")) {
                int i = Integer.parseInt(commands[1]);
                rootList.add(new Branch(i));
                bw.write("Item " + i + " was inserted into the tree");

            } else if (commands[0].toUpperCase().equals("D")) {
                int d = Integer.parseInt(commands[1]);
                if (rootList.delete(d)){
                    bw.write("Item " + d + " was deleted from the tree");
                } else {
                    bw.write("Item " + d + " was not deleted from the tree");     
                    }
            } else if (commands[0].toUpperCase().equals("F")) {
                int f = Integer.parseInt(commands[1]);
                if(rootList.find(f) != null){
                     bw.write("Item " + f + " was found in the tree");
                } else {
                    bw.write("Item " + f + " was not found on the tree");   
                }
            }
        }
        printTree(rootList);
    }

    public static void printTree(BranchList rootList) {
        System.out.print("\t");
        for (Branch a : rootList.branches) {
            System.out.printf("[%d]", a.value);
        }
        System.out.println();
        BranchList current = rootList;
        if (!current.leaf) {
            for (Branch a : rootList.branches) {
                for (Branch b : a.left.branches) {
                    System.out.printf("[%d]", b.value);
                }
                System.out.print(" ");
            }
            for (Branch c : current.branches.getLast().right.branches) {
                System.out.printf("[%d]", c.value);
            }
            System.out.print(" ");
            System.out.println();
            if (!current.branches.getFirst().left.leaf) {
            for (Branch a : rootList.branches) {
                for (Branch b : a.left.branches) {
                    for(Branch c :b.left.branches){
                        System.out.printf("[%d]", c.value);
                    }
                }
            }
            for (Branch c : current.branches.getLast().right.branches) {
                
                System.out.printf("[%d]", c.value);
            }
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

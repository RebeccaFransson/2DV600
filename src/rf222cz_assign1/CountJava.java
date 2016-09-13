package rf222cz_assign1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by ymafr on 2016-09-06.
 */
public class CountJava {
    public static void main(String[] args) throws IOException {
        //File f = new File("C:\\Users\\ymafr\\IdeaProjects\\2DV600\\src\\rf222cz_assign1");

        try{
            if(args.length == 0){
                throw new IOException("No file found");
            }
            File f = new File(args[0]);

            System.out.println("----Welcome to CountJava----");
            System.out.println("Root directory: "+args[0]);
            File[] files = f.listFiles();

            List<String> nameList = new ArrayList<>();
            List<Integer> linesList = new ArrayList<>();

            for (int i = 0; i < files.length; i++){
                //Seperating the name from the end(.java)
                String[] name = files[i].getName().split("\\.(?=[^\\.]+$)");
                //name[0] = the name (tex Arrays)
                if(files[i].getName().endsWith(".java")){
                    nameList.add(name[0]);

                    //Counting all lines
                    try(Scanner sc = new Scanner(files[i])) {
                        int countLines = 0;
                        while (sc.hasNextLine()) {
                            countLines++;
                            sc.nextLine();
                        }
                        linesList.add(countLines);
                    }catch(FileNotFoundException e) { System.err.println(e.getMessage());}
                }
            }
            for (int x = 0; x < nameList.size(); x++){
                System.out.println(x+" "+nameList.get(x)+"\t Lines = "+linesList.get(x));
            }
        }catch(IOException e){
            System.err.println(e.getMessage());
        }

    }
}

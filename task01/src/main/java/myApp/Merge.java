package myApp;

import java.io.File;
import java.io.IOException;
import java.util.List;

import main.java.myApp.csvData;
/**
 * Hello world!
 *
 */
public class Merge 
{
    public static void main( String[] args )
    {
        //Read File from the inputs
        String csvFileString = args[0];

        String templateFileString = args[1];

        //Initialise the different  files based on the inputs given 
        File csvFile = new File(csvFileString);

        File templateFile = new File(templateFileString);

        //Intialise the csvData class to call the method later
        csvData csv = new csvData();
        try {
            //Initialise the 2 Lists that will be used to stored the 2 files
            List<String> csvData = csv.getList(csvFile); 
            List<String> templateData = csv.getList(templateFile);

            //Extract the header out of the csvData List 
            String [] header = csvData.get(0).split(",");

            //Go through every set of csvData value
            for(int i = 1; i< csvData.size(); i++){

                //For each row of data is a set of data, hence split them into the different type through ","
                String [] value = csvData.get(i).split(",");

                //For each csvData set, go through the template
                for(int templateRow = 0; templateRow < templateData.size(); templateRow ++){

                    //For each row generate a line that is to be processed
                    String lineToProcess = templateData.get(templateRow);

                    //If the line still contains "__" or "\\n", means it is not completely processed
                    while(lineToProcess.contains("__") || lineToProcess.contains("\\n")){

                        //As the line is not completely processed, check against each headers
                        for(int keyword=0; keyword< header.length; keyword++){

                            //if contain the header, replace the keyword with respective value
                            if(lineToProcess.contains(header[keyword])){
                                lineToProcess = lineToProcess.replace("__" + header[keyword] + "__", value[keyword]);
                            } 
                            //if the lineToProcess contain "\\n" replace it with a line break
                            if(lineToProcess.contains("\\n")){
                                lineToProcess = lineToProcess.replace("\\n", "\n");
                            }
                        }
                    }
                    //End of while loop, means the line is completely processed, hence print the processed line
                    System.out.println(lineToProcess);
                }
                //print next line between each set of csvData
                p(" ");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void p(String message){
        System.out.println(message); 
    }

    public static void printArr(String [] arr){
        for(int i =0; i<arr.length; i++){
        System.out.println(arr[i]); 

        }
    }
}

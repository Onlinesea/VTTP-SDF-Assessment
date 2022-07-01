package main.java.myApp;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class csvData {

    public List getList(File csvFile)throws IOException{

        Scanner scsv = new Scanner(csvFile);
        // System.out.println(csvFile.exists());
        List<String> csvData = new LinkedList<>();

        while(scsv.hasNextLine()){
            String line = scsv.nextLine();
            csvData.add(line); 
            //System.out.println(line); 
            //Pattern regex = Pattern.compile("\\n");
            //Matcher match = regex.matcher(line);
            //int count = 0;

            //while(match.find()){
            //    count++;
            //}
            //System.out.println(count);
            
        }
        scsv.close();

        return csvData;
    }

    public List getListStream(File csvFile)throws IOException{
        List <String> csvList = new LinkedList<>();
        FileInputStream fis = new FileInputStream(csvFile);
        InputStreamReader isr = new InputStreamReader(fis);
        BufferedReader br = new BufferedReader(isr);
        String line;
        while((line = br.readLine())!=null){
            csvList.add(line);
        }

        br.close();
        isr.close();
        fis.close();


        return csvList;
    }
    
}

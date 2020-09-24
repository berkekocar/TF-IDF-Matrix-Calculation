/*
 * Task2.java
 * Student Name: Erdogan Berke Kocar
 * Number: 2984944
 *
 * Description of the class:
 *	This class solves the Task1 part, which has doing the pre-processing part.
 *  This class is responsible for:
 *		1- Reading the file by BufferReader.
 *		2- Parsing the documents
 *		3- Save it in text file.
 *
 *
 *	Input:
 *		1- Compiled by javac Task2.java , Run by java Task2
 *
 *
 *
 *
 */

import java.io.*;
import java.util.*;

public class Task2 {

    public static void main(String[] args) throws IOException {

        //Create a hash map.
        HashMap<String, String> myList = new HashMap<String, String>();
        //Read file by buffer reader.
        File file = new File("/Users/berkekocar/Desktop/IRWS_Assignment1/src/input2.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        //Create an array has 3 items buffer.
        String sw;
        String [] Doc = new String[2];
        //Read the documets.
        while ((sw = br.readLine()) != null) {

            Doc = sw.split("\t");
            //Split the document.
            for(int i = 0; i<Doc[1].split(" ").length;i++){
                //Check the list by index has document and if has it write it instead of the temp variable.
                if(myList.containsKey(Doc[1].split(" ")[i])){
                    String temp = myList.get(Doc[1].split(" ")[i]);
                        myList.put(Doc[1].split(" ")[i], temp + " , " + Doc[0]);
                }
                else{
                    myList.put(Doc[1].split(" ")[i],Doc[0]);
                }

            }




        }
        //Write and print the Buffer.
        BufferedWriter writer = new BufferedWriter(new FileWriter("/Users/berkekocar/Desktop/IRWS_Assignment1/src/output2.txt"));
        for (String i : myList.keySet()) {
            System.out.println(i + "\t" + myList.get(i));
            writer.write(i + "\n" + myList.get(i));

        }
        writer.close();


    }




}


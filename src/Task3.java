/*
 * Task3.java
 * Student Name: Erdogan Berke Kocar
 * Number: 2984944
 *
 * Description of the class:
 *	This class solves the Task3 part, which has creates the TF-IDF weights matrix and saves it in a file.
 *  This class is responsible for:
 *
 *
 *	Input:
 *		1- Compiled by javac Task3.java , Run by java Task3
 *
 *
 *
 *
 */

import java.io.*;


public class Task3 {
    public static void main(String[] args) throws IOException {
        //Read the file.
        File file = new File("/Users/berkekocar/Desktop/IRWS_Assignment1/src/input3.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));

        //Create string bound has 100.
        String[] tf = new String[10];

        String sw;
        //Create an integer represents the Number of documents.
        int N = 6;
        //Read the documents.
        while ((sw = br.readLine()) != null) {
            //Sprit the document by TAB.
            String [] Doc;
            Doc = sw.split("\t");
            //Number of documents containing the term.
            int Ni = 0;
            //Check if term frequency's index and documents index matches. If not increment.
            for (int i = 0 ; i < Doc.length ; i++){
                if (i == 0){
                    tf[i] = Doc[i];
                }
                else if (Doc[i] != ""){
                    tf[i] = "1";
                    Ni++;
                }
                else {
                    tf[i] = "0";
                }
                //System.out.println(Doc[i]);
            }//Calculate idf.
            double idf =  Math.log(N / Ni);
            //tf-idf
            for (int i = 1 ; i < tf.length ; i++){
                if(tf[i] == null || tf[i] == "0"){
                    tf[i]= "0";
                }
                else{
                    double temp = Integer.parseInt(tf[i]) * idf;
                    tf[i] = Double.toString(temp);
                }

            }
            //Write the array on array list.
            BufferedWriter writer = new BufferedWriter(new FileWriter("/Users/berkekocar/Desktop/IRWS_Assignment1/src/output3.txt"));
            String s="";
            for (int i = 0; i < tf.length ; i++){
                s = s+ tf[i]+ " ";
                writer.write(s);
            }
            System.out.println(s);


        }
        br.close();

    }
}
